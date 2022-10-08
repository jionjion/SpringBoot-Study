package top.jionjion.elasticsearch.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * 测试 ElasticsearchRestTemplate 模板类
 *
 * @author Jion
 */
@SpringBootTest
class ElasticsearchRestTemplateTest {

    @Autowired
    ElasticsearchRestTemplate template;

    @Test
    void test() {
        Assertions.assertNotNull(template);
    }
}
