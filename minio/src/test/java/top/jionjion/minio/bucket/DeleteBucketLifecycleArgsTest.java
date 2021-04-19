package top.jionjion.minio.bucket;

import io.minio.DeleteBucketLifecycleArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DeleteBucketLifecycleArgs 删除桶的生命配置周期
 *
 * @author Jion
 */
public class DeleteBucketLifecycleArgsTest {
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
    public void deleteBucketLifecycle() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.deleteBucketLifecycle(
                DeleteBucketLifecycleArgs.builder().bucket("cache").build());
    }
}
