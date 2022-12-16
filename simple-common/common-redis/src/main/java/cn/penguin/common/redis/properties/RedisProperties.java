package cn.penguin.common.redis.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String host;

    private String password;

    private int port;

    private int timeout;

//    @Value("${spring.redis.lettuce.shutdown-timeout}")
//    private long shutdownTimeout;
//
//    @Value("${spring.redis.lettuce.time-between-eviction-runs-millis}")
//    private long timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.redis.lettuce.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.lettuce.pool.min-idle}")
//    private int minIdle;
//
//    @Value("${spring.redis.lettuce.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.lettuce.pool.max-wait}")
//    private long maxWait;
}
