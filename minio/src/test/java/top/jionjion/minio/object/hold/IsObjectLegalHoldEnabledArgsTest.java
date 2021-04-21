package top.jionjion.minio.object.hold;

import io.minio.IsObjectLegalHoldEnabledArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * IsObjectLegalHoldEnabledArgs 如果在对象上启用了合法保留，则返回true
 *
 * @author Jion
 */
@Slf4j
public class IsObjectLegalHoldEnabledArgsTest {

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
    public void getPresignedObjectUrl1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        boolean enabled =
                minioClient.isObjectLegalHoldEnabled(
                        IsObjectLegalHoldEnabledArgs.builder()
                                .bucket("my-bucket")
                                .object("my-object")
                                .versionId("object-versionId")
                                .build());
        if (enabled) {
            log.info("Legal hold is on");
        } else {
            log.info("Legal hold is off");
        }
    }
}
