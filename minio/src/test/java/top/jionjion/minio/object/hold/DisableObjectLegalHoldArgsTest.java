package top.jionjion.minio.object.hold;

import io.minio.DisableObjectLegalHoldArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DisableObjectLegalHoldArgs 禁用对某个对象的合法保全
 *
 * @author Jion
 */
public class DisableObjectLegalHoldArgsTest {

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
    public void deleteObjectTags() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.disableObjectLegalHold(
                DisableObjectLegalHoldArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .build());
    }
}
