package top.jionjion.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * H2 内存数据库
 *
 * @author Jion
 */
@SpringBootApplication
public class DataH2Application {

    public static void main(String[] args) {
        SpringApplication.run(DataH2Application.class, args);
    }

}
