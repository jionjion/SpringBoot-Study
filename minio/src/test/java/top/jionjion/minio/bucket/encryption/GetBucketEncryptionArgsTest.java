package top.jionjion.minio.bucket.encryption;

import io.minio.GetBucketEncryptionArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.SseConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketEncryptionArgs 获取存储桶的加密配置
 *
 * @author Jion
 */
class GetBucketEncryptionArgsTest {

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
    void getBucketEncryption() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        SseConfiguration config =
                minioClient.getBucketEncryption(
                        GetBucketEncryptionArgs.builder().bucket("cache").build());
        Assertions.assertNotNull(config);
    }
}
