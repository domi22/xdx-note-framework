package xdx.note.framework.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;


public class ClusterServersConfigBuilder {

    private static final int MIN = 0;

    private static final int MAX = 100;

    private Config config;

    private ClusterServersConfig clusterServersConfig;

    public ClusterServersConfigBuilder() {
        this.config = new Config();
        this.clusterServersConfig = config.useClusterServers();
    }


    public ClusterServersConfigBuilder addNodeAddress(String nodeAddress) {
        clusterServersConfig.addNodeAddress(nodeAddress);
        return this;
    }
    public ClusterServersConfigBuilder setSubscriptionConnectionMinimumIdleSize(Integer size) {
        // 从节点发布和订阅连接的最小空闲连接数
        clusterServersConfig.setSubscriptionConnectionMinimumIdleSize(2);
        return this;
    }
    public ClusterServersConfigBuilder setSubscriptionConnectionPoolSize(Integer size) {
        // 节点发布和订阅连接池大小
        clusterServersConfig.setSubscriptionConnectionPoolSize(50);
        return this;
    }
    public ClusterServersConfigBuilder setSlaveConnectionMinimumIdleSize(Integer size) {
        // 从节点最小空闲连接数
        clusterServersConfig.setSlaveConnectionMinimumIdleSize(32);
        return this;
    }
    public ClusterServersConfigBuilder setSlaveConnectionPoolSize(Integer size) {
        // 从节点连接池大小
        clusterServersConfig.setSlaveConnectionPoolSize(64);
        return this;
    }
    public ClusterServersConfigBuilder setSubscriptionsPerConnection(Integer connection) {
        // 单个连接最大订阅数量
        clusterServersConfig.setSubscriptionsPerConnection(5);
        return this;
    }

    public ClusterServersConfigBuilder setMasterConnectionPoolSize(Integer size) {
        clusterServersConfig.setMasterConnectionPoolSize(64);
        return this;
    }
    public ClusterServersConfigBuilder setMasterConnectionMinimumIdleSize(Integer size) {
        clusterServersConfig.setMasterConnectionMinimumIdleSize(32);
        return this;
    }
    public ClusterServersConfigBuilder setIdleConnectionTimeout(Integer timeout) {
        clusterServersConfig.setIdleConnectionTimeout(10000);
        return this;
    }


    public ClusterServersConfigBuilder setConnectTimeout(Integer timeout) {
        // 同任何节点建立连接时的等待超时
        clusterServersConfig.setConnectTimeout(10000);

        return this;
    }
    public ClusterServersConfigBuilder setTimeout(Integer timeout) {
        // 等待节点回复命令的时间。该时间从命令发送成功时开始计时
        clusterServersConfig.setTimeout(3000);

        return this;
    }
    public ClusterServersConfigBuilder setRetryAttempts(Integer retryAttempts) {
        // 如果尝试达到 retryAttempts（命令失败重试次数） 仍然不能将命令发送至某个指定的节点时，将抛出错误。
        // 如果尝试在此限制之内发送成功，则开始启用 timeout（命令等待超时） 计时
        clusterServersConfig.setRetryAttempts(3);

        return this;
    }
    public ClusterServersConfigBuilder setRetryInterval(Integer interval) {
        // 在某个节点执行相同或不同命令时，连续 失败 failedAttempts（执行失败最大次数） 时，
        // 该节点将被从可用节点列表里清除，直到 reconnectionTimeout（重新连接时间间隔） 超时以后再次尝试。
        clusterServersConfig.setRetryInterval(1500);
        return this;
    }


    public RedissonClient build() {
        return Redisson.create(config);
    }


}
