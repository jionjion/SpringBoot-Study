package top.jionjion.minio.bucket.lifecycle;

import io.minio.GetBucketLifecycleArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.LifecycleConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketLifecycleArgs 获取存储桶的生命周期配置
 *
 * @author Jion
 */
@Slf4j
class GetBucketLifecycleArgsTest {

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
    void getBucketLifecycle() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        LifecycleConfiguration config =
                minioClient.getBucketLifecycle(
                        GetBucketLifecycleArgs.builder().bucket("cache").build());
        Assertions.assertNotNull(config);
    }
}
