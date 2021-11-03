package top.jionjion.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 日志管理
 *
 * @author Jion
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class LogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

}
