package top.jionjion.minio.object.copy;

import io.minio.CopyObjectArgs;
import io.minio.CopySource;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * CopyObjectArgs 通过服务器端从另一个对象复制数据来创建对象
 *
 * @author Jion
 */
class CopyObjectArgsTest {

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
    void copyObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 拷贝不同桶下的同名文件
        minioClient.copyObject(
                CopyObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .source(CopySource.builder()
                                .bucket("my-source-bucket")
                                .build())
                        .build());
    }

    @Test
    void copyObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 拷贝不同桶下的不同文件
        minioClient.copyObject(
                CopyObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .source(CopySource.builder()
                                .bucket("my-source-bucket")
                                .object("my-source-object")
                                .build())
                        .build());
    }
}