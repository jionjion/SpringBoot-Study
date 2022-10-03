package top.jionjion.elasticsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Jion
 */
class ElasticsearchApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> ElasticsearchApplication.main(new String[]{""}));
    }

}
