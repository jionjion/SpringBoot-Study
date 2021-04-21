package top.jionjion.minio.object.meta;

import io.minio.MinioClient;
import io.minio.ServerSideEncryptionCustomerKey;
import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.kerberos.EncryptionKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * StatObjectArgs 获取对象信息和对象的元数据
 *
 * @author Jion
 */
@Slf4j
public class StatObjectArgsTest {

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
    public void statObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 获得对象信息
        StatObjectResponse objectResponse =
                minioClient.statObject(
                        StatObjectArgs.builder().bucket("my-bucket").object("my-object").build());
        log.info("对象信息: {}", objectResponse);
    }


    @Test
    public void statObject() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 获得对象信息, 指定版本和服务器加密
        StatObjectResponse objectResponse =
                minioClient.statObject(
                        StatObjectArgs.builder()
                                .bucket("my-bucket")
                                .object("my-object")
                                .versionId("version-id")
                                .ssec(new ServerSideEncryptionCustomerKey(new EncryptionKey("123456".getBytes(), 1)))
                                .build());
        log.info("对象信息: {}", objectResponse);
    }
}
