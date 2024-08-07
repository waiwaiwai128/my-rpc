package chenbo.test;

import chenbo.rpc.api.HelloService;
import chenbo.rpc.serializer.CommonSerializer;
import chenbo.rpc.transport.socket.server.SocketServer;

/**
 * 测试用服务提供方（服务端）
 */
public class SocketTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl2();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        socketServer.publishService(helloService, HelloService.class.getCanonicalName());
    }

}
