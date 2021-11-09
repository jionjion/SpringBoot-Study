package top.jionjion.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import top.jionjion.mybatis.config.PlusConfig;

/**
 * 主启动类
 *
 * @author JionJion
 */
@Import(PlusConfig.class)
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
