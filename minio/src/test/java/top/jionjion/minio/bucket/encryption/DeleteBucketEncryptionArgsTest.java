package top.jionjion.minio.bucket.encryption;

import io.minio.DeleteBucketEncryptionArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DeleteBucketEncryptionArgs 删除存储桶的加密配置
 * 这样可以直接访问, 无需权限
 *
 * @author Jion
 */
class DeleteBucketEncryptionArgsTest {

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
    void deleteBucketEncryption() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.deleteBucketEncryption(
                DeleteBucketEncryptionArgs.builder().bucket("cache").build());
    }
}
