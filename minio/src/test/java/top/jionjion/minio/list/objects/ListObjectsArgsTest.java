package top.jionjion.minio.list.objects;

import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ListObjectsArgs 列出存储桶的对象信息
 *
 * @author Jion
 */
@Slf4j
public class ListObjectsArgsTest {

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
    public void listObjects1() {
        // 列出
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket("cache").build());
        log.info(results.toString());
    }

    @Test
    public void listObjects2() {
        // 递归列出
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket("cache").recursive(true).build());
        log.info(results.toString());
    }

    @Test
    public void listObjects3() {
        // 最大 100个, 前缀为j 后缀 .gif
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder()
                        .bucket("cache")
                        .startAfter(".gif")
                        .prefix("j")
                        .maxKeys(100)
                        .build());
        log.info(results.toString());
    }

    @Test
    public void listObjects4() {
        // 最大 100个, 前缀为j 后缀 .gif .携带版本信息
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder()
                        .bucket("cache")
                        .startAfter(".gif")
                        .prefix("j")
                        .maxKeys(100)
                        .includeVersions(true)
                        .build());
        log.info(results.toString());
    }
}
