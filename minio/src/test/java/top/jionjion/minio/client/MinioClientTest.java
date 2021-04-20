package top.jionjion.minio.client;

import io.minio.MinioClient;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * MinioClient 客户端的创建
 *
 * @author Jion
 */
public class MinioClientTest {

    @Test
    public void build1() {
        // 通过 url地址 直接创建
        MinioClient minioClient = MinioClient.builder()
                .endpoint("https://play.min.io").build();
        Assertions.assertNotNull(minioClient);
    }

    @Test
    public void build2() throws MalformedURLException {
        // 通过 URL 创建
        MinioClient minioClient = MinioClient.builder()
                .endpoint(new URL("https://play.min.io")).build();
        Assertions.assertNotNull(minioClient);
    }

    @Test
    public void build3() {
        // 指定 地址端口
        MinioClient minioClient =
                MinioClient.builder().endpoint(HttpUrl.parse("https://play.min.io:9000")).build();
        Assertions.assertNotNull(minioClient);
    }

    @Test
    public void build4() {
        // 指定地址端口 认证登录用户名
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("https://play.min.io")
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .build();
        Assertions.assertNotNull(minioClient);
    }

    @Test
    public void build5() {
        // 指定域名 端口 不启用SSL 安全套接字  用户密码
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("play.min.io", 9000, false)
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .build();
        Assertions.assertNotNull(minioClient);
    }

    @Test
    public void build6() {
        // 指定域名 端口 启用SSL 安全套接字  用户密码
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("play.min.io", 9000, true)
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .build();
        Assertions.assertNotNull(minioClient);
    }

    @Test
    public void build7() throws MalformedURLException {
        // // 指定域名 用户密码 地址
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(new URL("https://play.min.io"))
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .region("us-west-1")
                        .build();
        Assertions.assertNotNull(minioClient);
    }


    @Test
    public void build8() {
        // okhttp3 包, 自定义
        OkHttpClient customHttpClient = new OkHttpClient();
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("https://play.min.io:9000")
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .region("eu-east-1")
                        .httpClient(customHttpClient)
                        .build();
    }
}