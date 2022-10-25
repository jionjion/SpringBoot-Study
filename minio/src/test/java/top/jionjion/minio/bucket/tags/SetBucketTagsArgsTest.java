package top.jionjion.minio.bucket.tags;

import io.minio.MinioClient;
import io.minio.SetBucketTagsArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * SetBucketTagsArgs 设置存储桶的标签
 *
 * @author Jion
 */
class SetBucketTagsArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    void init() {
        // 创建连接
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    void setBucketTags() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Map<String, String> map = new HashMap<>();
        map.put("Project", "Project One");
        map.put("User", "Jion");
        minioClient.setBucketTags(SetBucketTagsArgs.builder().bucket("cache").tags(map).build());
    }
}
