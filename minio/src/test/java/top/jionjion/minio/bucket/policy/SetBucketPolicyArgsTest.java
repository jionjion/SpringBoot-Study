package top.jionjion.minio.bucket.policy;

import io.minio.MinioClient;
import io.minio.SetBucketPolicyArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * SetBucketPolicyArgs  配置设置存储桶的存储桶策略
 *
 * @author Jion
 */
public class SetBucketPolicyArgsTest {

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
    public void setBucketPolicy() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 储存配置,必须为JSON串
        String policyJson = "" +
                "{\n" +
                "             \"Statement\": [\n" +
                "                 {\n" +
                "                     \"Action\": [\n" +
                "                         \"s3:GetBucketLocation\",\n" +
                "                         \"s3:ListBucket\"\n" +
                "                     ],\n" +
                "                     \"Effect\": \"Allow\",\n" +
                "                     \"Principal\": \"*\",\n" +
                "                     \"Resource\": \"arn:aws:s3:::my-bucket_name\"\n" +
                "                 },\n" +
                "                 {\n" +
                "                     \"Action\": \"s3:GetObject\",\n" +
                "                     \"Effect\": \"Allow\",\n" +
                "                     \"Principal\": \"*\",\n" +
                "                     \"Resource\": \"arn:aws:s3:::my-bucket_name/my_object*\"\n" +
                "                 }\n" +
                "             ],\n" +
                "             \"Version\": \"2012-10-17\"\n" +
                "         }";
        minioClient.setBucketPolicy(
                SetBucketPolicyArgs.builder().bucket("cache").config(policyJson).build());

    }
}
