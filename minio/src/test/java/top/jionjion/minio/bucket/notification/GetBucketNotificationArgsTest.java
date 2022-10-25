package top.jionjion.minio.bucket.notification;

import io.minio.GetBucketNotificationArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.NotificationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketNotificationArgs 获取存储桶的通知配置
 *
 * @author Jion
 */
@Slf4j
class GetBucketNotificationArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    void init() {
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    void getBucketNotification() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        NotificationConfiguration config =
                minioClient.getBucketNotification(
                        GetBucketNotificationArgs.builder().bucket("cache").build());
        Assertions.assertNotNull(config);
    }
}
