package top.jionjion.minio.object.lock;

import io.minio.DeleteObjectLockConfigurationArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DeleteObjectLockConfigurationArgs 删除存储桶中的对象锁定配置
 *
 * @author Jion
 */
public class DeleteObjectLockConfigurationArgsTest {

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
    public void deleteObjectLockConfiguration() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.deleteObjectLockConfiguration(
                DeleteObjectLockConfigurationArgs.builder().bucket("cache").build());

    }
}
