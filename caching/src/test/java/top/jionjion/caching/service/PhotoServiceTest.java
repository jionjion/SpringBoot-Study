package top.jionjion.caching.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.caching.vo.Photo;

/**
 * 测试,带有缓存的查询
 *
 * @author Jion
 */
@SpringBootTest
class PhotoServiceTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServiceTest.class);

    @Autowired
    PhotoService photoService;

    @BeforeEach
    void insert() {
        Photo photo1 = photoService.insert(1L, "图片-1");
        Photo photo2 = photoService.insert(2L, "图片-2");
        Photo photo3 = photoService.insert(3L, "图片-3");
        Photo photo4 = photoService.insert(4L, "图片-4");
        LOGGER.info("批量保存 {},{},{},{}", photo1, photo2, photo3, photo4);
    }

    @Test
    void delete() {
        // 通过默认查询..此时走缓存,会很快
        Photo photoA = photoService.findById(1L);
        LOGGER.info("缓存获取 {}", photoA);
        // 删除缓存
        photoService.delete(1L);
        // 再次查询会很慢, 并且没有返回结果
        Photo photoB = photoService.findById(1L);
        LOGGER.info("删除缓存后获取 {}", photoB);
    }

    @Test
    void deleteAll() {
        // 删除全部
        photoService.deleteAll();
        // 查询会很慢, 并且没有返回结果
        Photo photo = photoService.findById(1L);
        LOGGER.info("删除缓存后获取 {}", photo);
    }

    @Test
    void update() {
        // 缓存查询
        Photo photoA = photoService.findById(1L);
        photoA.setTitle("修改图片-1");
        Photo update = photoService.update(photoA);
        LOGGER.info("修改 {}", update);

        // 修改,同时修改缓存
        Photo photoB = photoService.findById(1L);
        LOGGER.info("修改缓存后获取 {}", photoB);
    }

    @Test
    void findById() {
        // 缓存查询
        Photo photo = photoService.findById(1L);
        LOGGER.info("缓存中获取 {}", photo);
    }
}