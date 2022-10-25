package top.jionjion.minio.object.tags;

import io.minio.GetObjectTagsArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Tags;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetObjectTagsArgs 获取对象的标签
 *
 * @author Jion
 */
@Slf4j
class GetObjectTagsArgsTest {

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
    void getObjectTags() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Tags tags = minioClient.getObjectTags(
                GetObjectTagsArgs.builder().bucket("my-bucket").object("my-object").build());
        log.info("标签: {}", tags);
    }
}
