package top.jionjion.minio.object.tags;

import io.minio.MinioClient;
import io.minio.SetObjectTagsArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * SetObjectTagsArgs 为对象设置标签
 *
 * @author Jion
 */
class SetObjectTagsArgsTest {

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
    void setObjectRetention() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Map<String, String> map = new HashMap<>();
        map.put("Project", "Project One");
        map.put("User", "Jion");
        minioClient.setObjectTags(
                SetObjectTagsArgs.builder().bucket("my-bucket").object("my-object").tags(map).build());

    }
}