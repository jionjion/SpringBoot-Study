package top.jionjion.knife4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 使用 Knife4j 进行文档管理
 * 文档地址 <a href="http://localhost:8080/doc.html">...</a>
 *
 * @author Jion
 */
@EnableOpenApi
@SpringBootApplication
public class Knife4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Knife4jApplication.class, args);
    }

}
