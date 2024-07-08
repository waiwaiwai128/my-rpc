package chenbo.rpc.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import chenbo.rpc.annotation.RpcService;
import chenbo.rpc.provider.ServiceProvider;
import chenbo.rpc.registry.ServiceRegistry;

import java.net.InetSocketAddress;

/**
 * Spring实现服务自动注册
 * TO DO: 自动消费
 */

@Component
public class SpringBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(SpringBeanPostProcessor.class);

    private final ServiceRegistry serviceRegistry;
    private final ServiceProvider serviceProvider;

    public SpringBeanPostProcessor(ServiceRegistry serviceRegistry, ServiceProvider serviceProvider) {
        this.serviceRegistry = serviceRegistry;
        this.serviceProvider = serviceProvider;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(RpcService.class)) {
            logger.info("[{}] is annotated with [{}]", bean.getClass().getName(), RpcService.class.getCanonicalName());
            RpcService rpcServiceAnnotation = bean.getClass().getAnnotation(RpcService.class);
            String serviceName = rpcServiceAnnotation.value(); // 获取 RpcService 注解中定义的服务名称


            if (serviceName.isEmpty()) {
                serviceName = bean.getClass().getName(); // 如果注解中未定义服务名称，则默认使用类名作为服务名
            }
            //String serviceName = HelloService.class.getCanonicalName();
            publishService(bean, serviceName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private <T> void publishService(T service, String serviceName) {
        serviceProvider.addServiceProvider(service, serviceName);
        serviceRegistry.register(serviceName, new InetSocketAddress("127.0.0.1", 9999));
        logger.info("Published service [{}] at {}:{}", serviceName, "127.0.0.1", 9999);
    }
}
