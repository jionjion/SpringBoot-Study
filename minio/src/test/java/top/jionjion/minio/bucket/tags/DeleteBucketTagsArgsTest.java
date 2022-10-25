package top.jionjion.minio.bucket.tags;

import io.minio.DeleteBucketTagsArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DeleteBucketTagsArgs 删除桶的标签
 *
 * @author Jion
 */
class DeleteBucketTagsArgsTest {

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
    void deleteBucketTags() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.deleteBucketTags(
                DeleteBucketTagsArgs.builder().bucket("cache").build());
    }
}
