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
    private static final int MAX_SIZE = 100;
    private static final int MAX_TIMEOUT = 20000;
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
        checkSize(size, "subscriptionConnectionMinimumIdleSize");
        clusterServersConfig.setSubscriptionConnectionMinimumIdleSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSubscriptionConnectionPoolSize(Integer size) {
        checkSize(size, "subscriptionConnectionPoolSize");
        clusterServersConfig.setSubscriptionConnectionPoolSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSlaveConnectionMinimumIdleSize(Integer size) {
        checkSize(size, "slaveConnectionMinimumIdleSize");
        clusterServersConfig.setSlaveConnectionMinimumIdleSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSlaveConnectionPoolSize(Integer size) {
        checkSize(size, "slaveConnectionPoolSize");
        clusterServersConfig.setSlaveConnectionPoolSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setSubscriptionsPerConnection(Integer connection) {
        checkSize(connection, "subscriptionsPerConnection");
        clusterServersConfig.setSubscriptionsPerConnection(connection);
        return this;
    }

    public ClusterServersConfigBuilder setMasterConnectionPoolSize(Integer size) {
        checkSize(size, "subscriptionsPerConnection");
        clusterServersConfig.setMasterConnectionPoolSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setMasterConnectionMinimumIdleSize(Integer size) {
        checkSize(size, "subscriptionsPerConnection");
        clusterServersConfig.setMasterConnectionMinimumIdleSize(size);
        return this;
    }

    public ClusterServersConfigBuilder setIdleConnectionTimeout(Integer timeout) {
        checkTime(timeout, "idleConnectionTimeout");
        clusterServersConfig.setIdleConnectionTimeout(timeout);
        return this;
    }


    public ClusterServersConfigBuilder setConnectTimeout(Integer timeout) {
        checkTime(timeout, "connectTimeout");
        clusterServersConfig.setConnectTimeout(timeout);

        return this;
    }

    public ClusterServersConfigBuilder setTimeout(Integer timeout) {
        checkTime(timeout, "timeout");
        clusterServersConfig.setTimeout(timeout);

        return this;
    }

    public ClusterServersConfigBuilder setRetryAttempts(Integer retryAttempts) {
        checkSize(retryAttempts, "retryAttempts");
        clusterServersConfig.setRetryAttempts(retryAttempts);

        return this;
    }

    public ClusterServersConfigBuilder setRetryInterval(Integer interval) {
        checkTime(interval, "retryInterval");
        clusterServersConfig.setRetryInterval(interval);
        return this;
    }


    public RedissonClient build() {
        return Redisson.create(config);
    }

    private boolean rightSize(Integer size) {
        return size != null && size <= MAX_SIZE && size >= MIN;
    }

    private boolean rightTime(Integer timeout) {
        return timeout != null && timeout <= MAX_TIMEOUT && timeout >= MIN;
    }

    private void checkSize(Integer size, String param) {
        Assert.isTrue(rightSize(size), new IllegalArgumentException(msg(param)));
    }

    private void checkTime(Integer time, String param) {
        Assert.isTrue(rightTime(time), new IllegalArgumentException(msg(param)));
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
