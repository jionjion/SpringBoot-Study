package top.jionjion.minio.object.copy;

import io.minio.ComposeObjectArgs;
import io.minio.ComposeSource;
import io.minio.MinioClient;
import io.minio.ServerSideEncryptionS3;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ComposeObjectArgs 通过使用服务器端副本组合来自不同源对象的数据来创建对象
 * 可以将多个附件聚合为一个
 *
 * @author Jion
 */
class ComposeObjectArgsTest {

    private MinioClient minioClient;

    private List<ComposeSource> sourceObjectList;

    @BeforeEach
    void init() {
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();

        // 来源文件信息
        this.sourceObjectList = new ArrayList<>();
        sourceObjectList.add(
                ComposeSource.builder().bucket("my-job-bucket").object("my-object-part-one").build());
        sourceObjectList.add(
                ComposeSource.builder().bucket("my-job-bucket").object("my-object-part-two").build());
        sourceObjectList.add(
                ComposeSource.builder().bucket("my-job-bucket").object("my-object-part-three").build());
    }

    @Test
    void composeObject1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 创建 my-bucket / my-object 通过聚合文件
        minioClient.composeObject(
                ComposeObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .sources(sourceObjectList)
                        .build());
    }

    @Test
    void composeObject2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 创建 my-bucket / my-object 通过聚合文件, 自定义元信息
        Map<String, String> userMetadata = new HashMap<>();
        userMetadata.put("My-Project", "Project One");
        minioClient.composeObject(
                ComposeObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .sources(sourceObjectList)
                        .userMetadata(userMetadata)
                        .build());
    }

    @Test
    void composeObject3() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 创建 my-bucket / my-object 通过聚合文件, 指定元信息, 并进行服务器端加密
        Map<String, String> userMetadata = new HashMap<>();
        userMetadata.put("My-Project", "Project Two");
        minioClient.composeObject(
                ComposeObjectArgs.builder()
                        .bucket("my-bucket")
                        .object("my-object")
                        .sources(sourceObjectList)
                        .userMetadata(userMetadata)
                        .sse(new ServerSideEncryptionS3())
                        .build());

    }
}
