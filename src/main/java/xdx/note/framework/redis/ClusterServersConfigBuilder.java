package xdx.note.framework.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import xdx.note.framework.common.Assert;
import java.util.ArrayList;
import java.util.List;


public class ClusterServersConfigBuilder {

    private static final int MIN = 0;

    private static final int MAX = 100;

    private static final String NODE_ADDRESS_PARAM = "NodeAddress";

    private Config config;

    private ClusterServersConfig clusterServersConfig;

    public ClusterServersConfigBuilder() {
        this.config = new Config();
        this.clusterServersConfig = config.useClusterServers();
    }

    public ClusterServersConfigBuilder addNodeAddress(String nodeAddress) {
        List<String> nodes = checkAndGetNodes(nodeAddress);
        nodes.stream().forEach(node -> clusterServersConfig.addNodeAddress(node));
        return this;
    }

    public ClusterServersConfigBuilder setSubscriptionConnectionMinimumIdleSize(Integer size) {
        // 从节点发布和订阅连接的最小空闲连接数 2
        check(size, "subscriptionConnectionMinimumIdleSize");
        clusterServersConfig.setSubscriptionConnectionMinimumIdleSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSubscriptionConnectionPoolSize(Integer size) {
        // 节点发布和订阅连接池大小 50
        check(size, "subscriptionConnectionPoolSize");
        clusterServersConfig.setSubscriptionConnectionPoolSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSlaveConnectionMinimumIdleSize(Integer size) {
        // 从节点最小空闲连接数 32
        check(size, "slaveConnectionMinimumIdleSize");
        clusterServersConfig.setSlaveConnectionMinimumIdleSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSlaveConnectionPoolSize(Integer size) {
        // 从节点连接池大小 64
        check(size, "slaveConnectionPoolSize");
        clusterServersConfig.setSlaveConnectionPoolSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSubscriptionsPerConnection(Integer connection) {
        // 单个连接最大订阅数量 5
        check(connection, "subscriptionsPerConnection");
        clusterServersConfig.setSubscriptionsPerConnection(connection);
        return this;
    }

    public ClusterServersConfigBuilder setMasterConnectionPoolSize(Integer size) {
        // 64
        check(size, "subscriptionsPerConnection");
        clusterServersConfig.setMasterConnectionPoolSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setMasterConnectionMinimumIdleSize(Integer size) {
        // 32
        check(size, "subscriptionsPerConnection");
        clusterServersConfig.setMasterConnectionMinimumIdleSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setIdleConnectionTimeout(Integer timeout) {
        // 10000
        check(timeout, "idleConnectionTimeout");
        clusterServersConfig.setIdleConnectionTimeout(timeout);
        return this;
    }


    public ClusterServersConfigBuilder setConnectTimeout(Integer timeout) {
        check(timeout, "connectTimeout");
        // 同任何节点建立连接时的等待超时 10000
        clusterServersConfig.setConnectTimeout(timeout);

        return this;
    }

    public ClusterServersConfigBuilder setTimeout(Integer timeout) {
        check(timeout, "timeout");
        // 等待节点回复命令的时间。该时间从命令发送成功时开始计时 3000
        clusterServersConfig.setTimeout(timeout);

        return this;
    }

    public ClusterServersConfigBuilder setRetryAttempts(Integer retryAttempts) {
        check(retryAttempts, "retryAttempts");
        // 如果尝试达到 retryAttempts（命令失败重试次数 3） 仍然不能将命令发送至某个指定的节点时，将抛出错误。
        // 如果尝试在此限制之内发送成功，则开始启用 timeout（命令等待超时） 计时
        clusterServersConfig.setRetryAttempts(retryAttempts);

        return this;
    }

    public ClusterServersConfigBuilder setRetryInterval(Integer interval) {
        check(interval, "retryInterval");
        // 在某个节点执行相同或不同命令时，连续 失败 failedAttempts（执行失败最大次数） 时，
        // 该节点将被从可用节点列表里清除，直到 reconnectionTimeout（重新连接时间间隔 1500） 超时以后再次尝试。
        clusterServersConfig.setRetryInterval(interval);
        return this;
    }


    public RedissonClient build() {
        return Redisson.create(config);
    }

    private boolean right(Integer size) {
        return size != null && size <= MAX && size >= MIN;
    }

    private void check(Integer size, String param) {
        Assert.isTrue(right(size), new IllegalArgumentException(msg(param)));
    }

    private String msg(String param) {
        return String.format("ClusterServersConfig Param:[%s] Is Error", param);
    }


    private List<String> checkAndGetNodes(String address) {
        Assert.notEmpty(address, new IllegalArgumentException(msg(NODE_ADDRESS_PARAM)));
        String[] split = address.split("&");
        Assert.notEmpty(split, new IllegalArgumentException(msg(NODE_ADDRESS_PARAM)));
        List<String> nodes = new ArrayList<>(8);
        for (String node : split) {
            nodes.add(String.format("redis://%s", node));
        }
        return nodes;
    }


}
