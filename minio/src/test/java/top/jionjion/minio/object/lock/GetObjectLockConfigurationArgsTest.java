package top.jionjion.minio.object.lock;

import io.minio.GetObjectLockConfigurationArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.ObjectLockConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketVersioningArgs 获取存储桶的版本控制配置
 *
 * @author Jion
 */
@Slf4j
class GetObjectLockConfigurationArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    public void init() {
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    void getObjectLockConfiguration() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        ObjectLockConfiguration config =
                minioClient.getObjectLockConfiguration(
                        GetObjectLockConfigurationArgs.builder().bucket("cache").build());

        log.info("配置策略: {}", config);
        log.info("Mode: " + config.mode());
        log.info("Duration: " + config.duration().duration() + " " + config.duration().unit());
        Assertions.assertNotNull(config);
    }
}
