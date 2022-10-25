package top.jionjion.minio.object.url;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * GetPresignedObjectUrlArgs 获取对象的预签名URL，对应的HTTP方法，到期时间和自定义请求参数
 *
 * @author Jion
 */
@Slf4j
class GetPresignedObjectUrlArgsTest {

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
    void getPresignedObjectUrl1() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 获取删除对象的URL，使用Post请求, 设置到期时间和自定义请求参数。
        String url =
                minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.DELETE)
                                .bucket("my-bucket")
                                .object("my-object")
                                .expiry(24 * 60 * 60)
                                .build());
        log.info("删除URL: {}", url);
    }

    @Test
    void getPresignedObjectUrl2() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 获得更新对象的URL, 使用PUT请求, 设置到期时间与自定义响应头信息
        Map<String, String> reqParams = new HashMap<>();
        reqParams.put("response-content-type", "application/json");
        String url =
                minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.PUT)
                                .bucket("my-bucket")
                                .object("my-object")
                                .expiry(1, TimeUnit.DAYS)
                                .extraQueryParams(reqParams)
                                .build());
        log.info("更新URL: {}", url);
    }

    @Test
    void getPresignedObjectUrl3() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 获得下载对象的URL, 使用GET请求, 设置到期时间
        String url =
                minioClient.getPresignedObjectUrl(
                        GetPresignedObjectUrlArgs.builder()
                                .method(Method.GET)
                                .bucket("my-bucket")
                                .object("my-object")
                                .expiry(2, TimeUnit.HOURS)
                                .build());
        log.info("更新URL: {}", url);
    }

}
