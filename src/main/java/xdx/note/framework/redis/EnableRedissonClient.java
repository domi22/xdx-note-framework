package xdx.note.framework.redis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RedisConfiguration.class})
public @interface EnableRedissonClient {
}
