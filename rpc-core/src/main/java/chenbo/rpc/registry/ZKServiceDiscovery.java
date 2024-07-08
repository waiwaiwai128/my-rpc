package chenbo.rpc.registry;

import chenbo.rpc.loadbalancer.LoadBalancer;
import chenbo.rpc.loadbalancer.RandomLoadBalancer;
import chenbo.rpc.registry.util.CuratorUtils;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * Zookeeper服务发现中心
 * 使用Curator框架实现
 */
public class ZKServiceDiscovery implements ServiceDiscovery {

    private final LoadBalancer loadBalancer;

    public ZKServiceDiscovery(LoadBalancer loadBalancer) {
        if(loadBalancer == null) this.loadBalancer = new RandomLoadBalancer();
        else this.loadBalancer = loadBalancer;
    }

    @Override
    public InetSocketAddress lookupService(String serviceName) {

        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, serviceName);

        // load balancing
        //String targetServiceUrl = String.valueOf(loadBalancer.select(serviceUrlList));
        String targetServiceUrl = serviceUrlList.get(0);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
