package top.jionjion.minio.object.retention;

import io.minio.GetObjectRetentionArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Retention;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetObjectRetentionArgs 获取对象的保留配置
 *
 * @author Jion
 */
@Slf4j
public class GetObjectRetentionArgsTest {

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
    public void getObjectRetention() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 指定桶的文件和其版本ID
        Retention retention =
                minioClient.getObjectRetention(
                        GetObjectRetentionArgs.builder()
                                .bucket("my-bucket")
                                .object("my-object")
                                .versionId("object-version-id")
                                .build());
        log.info("模式: " + retention.mode() + "保留日期: " + retention.retainUntilDate());
    }
}
