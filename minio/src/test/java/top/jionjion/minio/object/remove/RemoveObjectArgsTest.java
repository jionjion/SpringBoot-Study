package top.jionjion.minio.object.remove;

import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * RemoveObjectArgs 删除一个对象
 *
 * @author Jion
 */
public class RemoveObjectArgsTest {

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
    public void removeObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 删除对象
        minioClient.removeObject(
                RemoveObjectArgs.builder().bucket("my-bucket").object("my-object").build());
    }

    @Test
    public void removeObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 删除对象, 指定版本
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .versionId("my-version-id")
                        .build());
    }

    @Test
    public void removeObject3() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 删除对象, 指定版本, 绕过授权控制
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .versionId("my-version-id")
                        .bypassGovernanceMode(true)
                        .build());
    }
}
