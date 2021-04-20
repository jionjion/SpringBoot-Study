package top.jionjion.minio.bucket.versioning;

import io.minio.MinioClient;
import io.minio.SetBucketVersioningArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * SetBucketVersioningArgs 设置存储桶的版本控制策略
 * @author Jion
 */
public class SetBucketVersioningArgsTest {

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
    public void setBucketVersioning() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.setBucketVersioning(
                SetBucketVersioningArgs.builder().bucket("cache").config(null).build());
    }
}