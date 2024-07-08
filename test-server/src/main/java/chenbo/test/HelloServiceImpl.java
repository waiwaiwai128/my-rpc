package chenbo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import chenbo.rpc.annotation.RpcService;
import chenbo.rpc.api.HelloObject;
import chenbo.rpc.api.HelloService;

/**
 */
@Service
@Primary
@RpcService(value= "chenbo.rpc.api.HelloService", group = "testGroup", version = "1.0")
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("接收到消息：{}", object.getMessage());
        return "本次处理来自Netty服务";
    }

}
