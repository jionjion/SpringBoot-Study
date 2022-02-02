package top.jionjion.redisom;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Redis 官方提供的 OM 映射
 *
 * 项目私库有问题,作废...
 *
 * @author Jion
 */
@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "top.jionjion.redisom.po.*")
public class RedisOmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisOmApplication.class, args);
    }

}
