package top.jionjion.minio.bucket.bucket;

import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * MakeBucketArgs 创建一个启用了给定区域和对象锁定功能的存储桶
 *
 * @author Jion
 */
class MakeBucketArgsTest {

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
    void makeBucket1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 使用默认地区创建
        minioClient.makeBucket(
                MakeBucketArgs.builder()
                        .bucket("cache")
                        .build());
    }

    @Test
    void makeBucket2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 指定区域
        minioClient.makeBucket(
                MakeBucketArgs.builder()
                        .bucket("cache")
                        .region("us-west-1")
                        .build());
    }

    @Test
    void makeBucket3() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 指定区域与启用对象锁
        minioClient.makeBucket(
                MakeBucketArgs.builder()
                        .bucket("cache")
                        .region("us-west-1")
                        .objectLock(true)
                        .build());

    }
}
