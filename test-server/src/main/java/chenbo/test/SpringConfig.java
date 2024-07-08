package chenbo.test;

import chenbo.rpc.api.HelloService;
import chenbo.rpc.serializer.CommonSerializer;
import chenbo.rpc.transport.RpcClient;
import chenbo.rpc.transport.RpcClientProxy;
import chenbo.rpc.transport.netty.client.NettyClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring启动配置类，跟随服务端启动
 */

@Configuration
@ComponentScan(basePackages = "chenbo")
public class SpringConfig {
    @Bean
    public HelloService helloService() {
        return new HelloServiceImpl();
    }

    @Bean
    public RpcClient rpcClient() {
        return new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
    }

    @Bean
    public RpcClientProxy rpcClientProxy(RpcClient rpcClient) {
        return new RpcClientProxy(rpcClient);
    }
}
