package top.jionjion.minio.object.download;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.ServerSideEncryptionCustomerKey;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.kerberos.EncryptionKey;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GetObjectArgs 获取对象的数据
 * 返回InputStream使用后必须关闭才能释放网络资源
 *
 * @author Jion
 */
@Slf4j
public class GetObjectArgsTest {

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
    public void getObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 返回对应桶的对象的输入流
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .build())) {
            // 读取操作
            log.info(stream.toString());
        }
    }

    @Test
    public void getObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 读取IO流, 并设置偏移量与读取量, 服务端密码
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .offset(1024L)
                        .length(4096L)
                        .ssec(new ServerSideEncryptionCustomerKey(new EncryptionKey("123456".getBytes(), 1)))
                        .build())) {
            // 读取操作
            log.info(stream.toString());
        }
    }
}
