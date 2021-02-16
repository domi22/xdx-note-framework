package xdx.note.framework.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;



public class RedissonConfiguration {

    @Bean
    public RedissonClient redissonClient(RedissonConfigProperties properties) {
        Config config = new Config();
        ClusterServersConfig clusterConfig = config.useClusterServers();
        clusterConfig.addNodeAddress(
                "redis://192.168.15.128:7001",
                "redis://192.168.15.128:7002",
                "redis://192.168.15.128:7003",
                "redis://192.168.15.128:7004",
                "redis://192.168.15.128:7005",
                "redis://192.168.15.128:7006");
        return Redisson.create(config);
    }




}
