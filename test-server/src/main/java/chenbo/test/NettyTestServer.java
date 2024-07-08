package chenbo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import chenbo.rpc.serializer.CommonSerializer;
import chenbo.rpc.transport.netty.server.NettyServer;

/**
 * 测试用Netty服务提供者（服务端）
 */
public class NettyTestServer {

    public static void main(String[] args) {
//        HelloService helloService = new HelloServiceImpl();
//        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
//        server.publishService(helloService, HelloService.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //HelloService helloService = context.getBean((HelloService.class));
        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        //server.publishService(helloService, HelloService.class.getCanonicalName());
        server.start();
    }

}
