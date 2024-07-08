package chenbo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import chenbo.rpc.api.HelloObject;
import chenbo.rpc.api.HelloService;
import chenbo.rpc.transport.RpcClientProxy;

/**
 * 测试用Netty消费者
 */
public class NettyTestClient {

    public static void main(String[] args) {
//        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
//        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
//        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
//        HelloObject object = new HelloObject(12, "This is a message");
//        String res = helloService.hello(object);
//        System.out.println(res);
        ApplicationContext context = new AnnotationConfigApplicationContext(chenbo.test.SpringConfig.class);
        //RpcClient client = context.getBean(RpcClient.class);
        RpcClientProxy rpcClientProxy = context.getBean(RpcClientProxy.class);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }

}
