package top.jionjion.elasticsearch.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import top.jionjion.elasticsearch.pojo.Food;

/**
 * 测试索引操作
 *
 * @author Jion
 */
@Slf4j
@SpringBootTest
class IndexOperationTest {

    /**
     * Elasticsearch 模板引擎
     */
    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;

    /**
     * 索引操作
     */
    @Test
    public void testIndex() {
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(Food.class);
        indexOperations.create();
        indexOperations.putMapping();
        indexOperations.delete();
    }
}