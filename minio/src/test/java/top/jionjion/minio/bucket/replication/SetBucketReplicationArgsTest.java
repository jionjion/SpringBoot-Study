package top.jionjion.minio.bucket.replication;

import io.minio.MinioClient;
import io.minio.SetBucketReplicationArgs;
import io.minio.errors.*;
import io.minio.messages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * SetBucketReplicationArgs  配置设置存储桶的复制策略
 *
 * @author Jion
 */
public class SetBucketReplicationArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    public void init() {
        // 创建连接
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    public void setBucketReplication() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Map<String, String> tags = new HashMap<>();
        tags.put("key1", "value1");
        tags.put("key2", "value2");
        ReplicationRule rule =
                new ReplicationRule(
                        new DeleteMarkerReplication(Status.DISABLED),
                        new ReplicationDestination(
                                null, null, "REPLACE-WITH-ACTUAL-DESTINATION-BUCKET-ARN", null, null, null, null),
                        null,
                        new RuleFilter(new AndOperator("TaxDocs", tags)),
                        "rule1",
                        null,
                        1,
                        null,
                        Status.ENABLED);

        List<ReplicationRule> rules = new LinkedList<>();
        rules.add(rule);

        ReplicationConfiguration config =
                new ReplicationConfiguration("REPLACE-WITH-ACTUAL-ROLE", rules);

        minioClient.setBucketReplication(
                SetBucketReplicationArgs.builder().bucket("my-bucketname").config(config).build());

    }
}
