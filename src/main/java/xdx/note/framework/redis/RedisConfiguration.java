package xdx.note.framework.redis;

import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;


public class RedisConfiguration {

    @Bean
    public RedissonClient redissonClient(RedisConfigProperties properties) {
        if (!RedisMode.CLUSTER.equals(RedisMode.match(properties.getMode()))) {
            throw new RuntimeException("REDIS MODE ERROR");
        }
        return new
                ClusterServersConfigBuilder()
                .addNodeAddress(properties.getNodeAddresses())
                .setSubscriptionConnectionMinimumIdleSize(properties.getSubscriptionConnectionMinimumIdleSize())
                .setSlaveConnectionMinimumIdleSize(properties.getSlaveConnectionMinimumIdleSize())
                .setSubscriptionConnectionPoolSize(properties.getSubscriptionConnectionPoolSize())
                .setSubscriptionsPerConnection(properties.getSubscriptionsPerConnection())
                .setSlaveConnectionPoolSize(properties.getSlaveConnectionPoolSize())

                .setMasterConnectionMinimumIdleSize(properties.getMasterConnectionMinimumIdleSize())
                .setMasterConnectionPoolSize(properties.getMasterConnectionPoolSize())
                .setIdleConnectionTimeout(properties.getIdleConnectionTimeout())

                .setConnectTimeout(properties.getConnectTimeout())
                .setRetryInterval(properties.getRetryInterval())
                .setRetryAttempts(properties.getRetryAttempts())
                .setTimeout(properties.getTimeout())
                .build();
    }





}
