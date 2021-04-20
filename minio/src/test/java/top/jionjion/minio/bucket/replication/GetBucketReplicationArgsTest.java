package top.jionjion.minio.bucket.replication;

import io.minio.GetBucketReplicationArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.ReplicationConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketReplicationArgs 获取存储桶的存储桶复制配置
 *
 * @author Jion
 */
@Slf4j
public class GetBucketReplicationArgsTest {

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
    public void getBucketReplication() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        ReplicationConfiguration config =
                minioClient.getBucketReplication(
                        GetBucketReplicationArgs.builder().bucket("cache").build());
        log.info("配置策略: {}", config);
        Assertions.assertNotNull(config);
    }
}
