package top.jionjion.minio.bucket;

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
public class DeleteBucketEncryptionArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    public void init() {
        // 创建连接
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    public void deleteBucketEncryption() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        this.minioClient.deleteBucketEncryption(
                DeleteBucketEncryptionArgs.builder().bucket("cache").build());
    }
}
