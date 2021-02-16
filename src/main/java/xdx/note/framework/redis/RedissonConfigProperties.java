package xdx.note.framework.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "redis")
public class RedissonConfigProperties {

    private String name;
    private String age;




}
