package top.jionjion.elasticsearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * 测试 ElasticsearchRestTemplate 模板类
 *
 * @author Jion
 */
@SpringBootTest
public class ElasticsearchRestTemplateTest {

    @Autowired
    ElasticsearchRestTemplate template;


}
