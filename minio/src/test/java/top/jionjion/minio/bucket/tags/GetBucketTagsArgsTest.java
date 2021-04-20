package top.jionjion.minio.bucket.tags;

import io.minio.GetBucketTagsArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Tags;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetBucketTagsArgs 获取存储桶的标签
 *
 * @author Jion
 */
@Slf4j
public class GetBucketTagsArgsTest {

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
    public void getBucketTags() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Tags tags = minioClient.getBucketTags(GetBucketTagsArgs.builder().bucket("cache").build());
        log.info("标签: {}", tags);
        Assertions.assertNotNull(tags);
    }
}
