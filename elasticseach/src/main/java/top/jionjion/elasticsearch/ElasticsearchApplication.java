package top.jionjion.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考 <a href="https://blog.csdn.net/promsing/article/details/122876032">...</a>?
 * 设置密码  ./bin/elasticsearch-setup-passwords interactive
 *
 * @author JionJion
 */
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}