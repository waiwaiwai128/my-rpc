package chenbo.rpc.registry;

import chenbo.rpc.registry.util.CuratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

/**
 * Zookeeper服务注册
 * 使用Curator框架实现
 */

//@Component
@Slf4j
public class ZKServiceRegistry implements ServiceRegistry {

    @Override
    public void register(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
