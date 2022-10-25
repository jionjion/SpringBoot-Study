package top.jionjion.minio.object.download;

import io.minio.DownloadObjectArgs;
import io.minio.MinioClient;
import io.minio.ServerSideEncryptionCustomerKey;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.kerberos.EncryptionKey;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DownloadObjectArgs 将对象的数据下载到文件
 *
 * @author Jion
 */
class DownloadObjectArgsTest {

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
    void downloadObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 下载指定桶内的指定文件, 并下载到指定路径
        minioClient.downloadObject(
                DownloadObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .filename("my-object-file")
                        .build());

    }


    @Test
    void downloadObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 下载指定桶内的指定文件, 并下载到指定路径. 使用指定密码
        minioClient.downloadObject(
                DownloadObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .ssec(new ServerSideEncryptionCustomerKey(new EncryptionKey("123456".getBytes(), 1)))
                        .filename("my-object-file")
                        .build());

    }
}
