package top.jionjion.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义.Springboot的场景启动器
 * 需要打包后使用.
 *
 * @author Jion
 */
@SpringBootApplication
public class UtilStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilStarterApplication.class, args);
    }

}
