package top.jionjion.minio.object.hold;

import io.minio.EnableObjectLegalHoldArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * EnableObjectLegalHoldArgs 启用对某个对象的合法保全
 *
 * @author Jion
 */
public class EnableObjectLegalHoldArgsTest {

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
    public void enableObjectLegalHold() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.enableObjectLegalHold(
                EnableObjectLegalHoldArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .build());
    }
}
