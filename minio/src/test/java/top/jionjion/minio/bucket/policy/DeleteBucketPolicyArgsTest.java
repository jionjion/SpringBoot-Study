package top.jionjion.minio.bucket.policy;

import io.minio.DeleteBucketReplicationArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DeleteBucketPolicyArgs 删除桶的桶策略配置
 * 这样可以可读或者可写或者可读可写
 *
 * @author Jion
 */
public class DeleteBucketPolicyArgsTest {
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
    public void deleteBucketReplication() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.deleteBucketReplication(
                DeleteBucketReplicationArgs.builder().bucket("cache").build());
    }
}