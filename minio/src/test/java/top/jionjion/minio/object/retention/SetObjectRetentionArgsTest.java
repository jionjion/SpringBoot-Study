package top.jionjion.minio.object.retention;

import io.minio.MinioClient;
import io.minio.SetObjectRetentionArgs;
import io.minio.errors.*;
import io.minio.messages.Retention;
import io.minio.messages.RetentionMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;

/**
 * SetObjectRetentionArgs 为对象设置储存设置
 *
 * @author Jion
 */
public class SetObjectRetentionArgsTest {

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
    public void setObjectRetention() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Retention retention = new Retention(RetentionMode.COMPLIANCE, ZonedDateTime.now().plusYears(1));
        minioClient.setObjectRetention(
                SetObjectRetentionArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .config(retention)
                        .bypassGovernanceMode(true)
                        .build());
    }
}
