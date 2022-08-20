package top.jionjion.redisom;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Redis 官方提供的 OM 映射
 *
 * 使用 @EnableRedisDocumentRepositories 开启 Redis-OM 映射, 完成检索
 * basePackages 指向项目根路径, 将 po 和 repository 都包围
 *
 * @author Jion
 */
@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "top.jionjion.redisom.*")
public class RedisOmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisOmApplication.class, args);
    }

}
