package top.jionjion.minio.bucket.encryption;

import io.minio.MinioClient;
import io.minio.SetBucketEncryptionArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * SetBucketEncryptionArgs 设置存储桶的加密配置
 *
 * @author Jion
 */
class SetBucketEncryptionArgsTest {

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
    void setBucketEncryption() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.setBucketEncryption(
                SetBucketEncryptionArgs.builder().bucket("cache").config(null).build());

    }
}
