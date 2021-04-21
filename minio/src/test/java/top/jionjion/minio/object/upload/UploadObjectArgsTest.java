package top.jionjion.minio.object.upload;

import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * UploadObjectArgs 上传为存储桶中的对象
 *
 * @author Jion
 */
public class UploadObjectArgsTest {

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
    public void uploadObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 上传文件
        minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .filename("person.json")
                        .build());
    }

    @Test
    public void uploadObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 上传文件,指定文件类型
        minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .filename("my-video.avi")
                        .contentType("video/mp4")
                        .build());
    }
}
