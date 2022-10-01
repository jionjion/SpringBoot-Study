package top.jionjion.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  使用 Swagger3 进行项目接口管理
 *      自带的文档地址
 *          <a href="http://127.0.0.1:8080/swagger-ui/index.html">...</a>
 *      官网
 *          <a href="http://springfox.github.io/springfox/docs/current/">...</a>
 *
 * @author Jion
 */
@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

}
