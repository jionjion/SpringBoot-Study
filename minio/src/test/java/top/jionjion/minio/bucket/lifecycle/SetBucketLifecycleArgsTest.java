package top.jionjion.minio.bucket.lifecycle;

import io.minio.MinioClient;
import io.minio.SetBucketLifecycleArgs;
import io.minio.errors.*;
import io.minio.messages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * SetBucketLifecycleArgs 配置设置存储桶的生命周期
 * @author Jion
 */
class SetBucketLifecycleArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    void init() {
        // 创建连接
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    void setBucketLifecycle() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        List<LifecycleRule> rules = new LinkedList<>();
        rules.add(
                new LifecycleRule(
                        Status.ENABLED,
                        null,
                        null,
                        new RuleFilter("documents/"),
                        "rule1",
                        null,
                        null,
                        new Transition((ZonedDateTime) null, 30, "GLACIER")));
        rules.add(
                new LifecycleRule(
                        Status.ENABLED,
                        null,
                        new Expiration((ZonedDateTime) null, 365, null),
                        new RuleFilter("logs/"),
                        "rule2",
                        null,
                        null,
                        null));
        LifecycleConfiguration config = new LifecycleConfiguration(rules);
        minioClient.setBucketLifecycle(
                SetBucketLifecycleArgs.builder().bucket("cache").config(config).build());

    }
}
