package top.jionjion.minio.object.lock;

import io.minio.MinioClient;
import io.minio.SetObjectLockConfigurationArgs;
import io.minio.errors.*;
import io.minio.messages.ObjectLockConfiguration;
import io.minio.messages.RetentionDurationDays;
import io.minio.messages.RetentionMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * SetObjectLockConfigurationArgs 设置储桶中的对象锁策略
 *
 * @author Jion
 */
class SetObjectLockConfigurationArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    void init() {
        // 创建连接
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    void setObjectLockConfiguration() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        ObjectLockConfiguration config =
                new ObjectLockConfiguration(RetentionMode.COMPLIANCE, new RetentionDurationDays(100));
        minioClient.setObjectLockConfiguration(
                SetObjectLockConfigurationArgs.builder().bucket("cache").config(config).build());

    }
}
