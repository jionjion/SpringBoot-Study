package top.jionjion.minio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 使用 minio 进行上传下载
 *
 * @author Jion
 */
class MinioApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> MinioApplication.main(new String[]{""}));
    }

}
