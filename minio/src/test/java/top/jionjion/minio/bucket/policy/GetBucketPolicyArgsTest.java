package top.jionjion.minio.bucket.policy;

import io.minio.GetBucketPolicyArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketPolicyArgs 获取桶的桶策略配置
 *
 * @author Jion
 */
@Slf4j
public class GetBucketPolicyArgsTest {

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
    public void getBucketPolicy() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, BucketPolicyTooLargeException {
        String config =
                minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket("cache").build());
        log.info("配置策略: {}", config);
        Assertions.assertNotNull(config);
    }
}
