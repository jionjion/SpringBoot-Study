package top.jionjion.minio.object.upload;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.ServerSideEncryptionS3;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * PutObjectArgs 将给定的流作为对象上传到存储桶中
 *
 * @author Jion
 */
public class PutObjectArgsTest {

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
    public void putObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 上传一个确切大小的输入流
        minioClient.putObject(
                PutObjectArgs.builder().bucket("my-bucket").object("my-object").stream(
                        new FileInputStream("/my-video.mp4"), 1024, -1)
                        .contentType("video/mp4")
                        .build());
    }

    @Test
    public void putObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 上传一个未知大小的输入流
        minioClient.putObject(
                PutObjectArgs.builder().bucket("my-bucket").object("my-object").stream(
                        new FileInputStream("/my-video.mp4"), -1, 10485760)
                        .contentType("video/mp4")
                        .build());

    }

    @Test
    public void putObject3() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 使用 ByteArrayInputStream 上传二进制文件, 并指定文件名
        minioClient.putObject(
                PutObjectArgs.builder().bucket("my-bucket").object("path/to/fileName").stream(
                        new ByteArrayInputStream(new byte[]{}), 0, -1)
                        .build());
    }

    @Test
    public void putObject4() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 上传带有元数据的数据, 并进行服务器端加密
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");
        Map<String, String> userMetadata = new HashMap<>();
        userMetadata.put("My-Project", "Project One");
        minioClient.putObject(
                PutObjectArgs.builder().bucket("my-bucket").object("my-object").stream(
                        new FileInputStream("/my-video.mp4"), -1, -1)
                        .headers(headers)
                        .userMetadata(userMetadata)
                        .sse(new ServerSideEncryptionS3())
                        .build());
    }
}