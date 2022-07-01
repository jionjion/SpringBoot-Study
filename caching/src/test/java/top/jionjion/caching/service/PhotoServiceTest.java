package top.jionjion.caching.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试,带有缓存的查询
 *
 * @author Jion
 */
@SpringBootTest
class PhotoServiceTest {


    private static final Logger logger = LoggerFactory.getLogger(PhotoServiceTest.class);

    @Autowired
    PhotoService photoService;

    @Test
    public void findById() {
        logger.info("photo 1 => " + photoService.findById(1L));
        logger.info("photo 2 => " + photoService.findById(2L));
        logger.info("photo 3 => " + photoService.findById(3L));

        // 重复查询
        logger.info("photo 1 => " + photoService.findById(1L));
        logger.info("photo 2 => " + photoService.findById(2L));
        logger.info("photo 3 => " + photoService.findById(3L));
    }
}