package top.jionjion.demo;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 官方测试用例
 *
 * @author Jion
 */
class DemoTest {

    @Test
    void demo() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // 创建连接
            MinioClient minioClient =
                    MinioClient.builder()
                            // 地址, 前台访问 http://127.0.0.1:9000/minio
                            .endpoint("http://127.0.0.1:9000")
                            // 登录用户名密码
                            .credentials("minioadmin", "minioadmin")
                            .build();

            // 创建一个桶, 如果桶 cache 不存在的话.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("cache").build());
            if (!found) {
                // 不存在则创建
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("cache").build());
            } else {
                // 存在...
                System.out.println("Bucket 'cache' already exists.");
            }

            // 上传文件 C:\Users\JionJion\Desktop\jion.gif 到 http://localhost:9000/minio/cache/jion.gif
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("cache")
                            .object("jion.gif")
                            .filename("C:\\Users\\JionJion\\Desktop\\jion.gif")
                            .build());
            // 上传成功
            System.out.println(
                    "'C:\\Users\\JionJion\\Desktop\\jion.gif' is successfully uploaded as "
                            + "object 'jion.gif' to bucket 'cache'.");
        } catch (MinioException e) {
            // 上传失败异常
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
}
