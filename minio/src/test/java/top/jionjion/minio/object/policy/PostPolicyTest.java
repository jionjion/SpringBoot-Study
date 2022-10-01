package top.jionjion.minio.object.policy;

import io.minio.MinioClient;
import io.minio.PostPolicy;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * PostPolicy 获取对象的PostPolicy的表单数据，以使用POST方法上传其数据
 *
 * @author Jion
 */
@Slf4j
public class PostPolicyTest {

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
    public void getPresignedPostFormData() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // 创建发布策略, 有效期7天
        PostPolicy policy = new PostPolicy("my-bucket", ZonedDateTime.now().plusDays(7));

        // 策略关键字, key = my-object
        policy.addEqualsCondition("key", "my-object");

        // 策略方式 Content-Type 以 image/ 开头
        policy.addStartsWithCondition("Content-Type", "image/");

        // 策略长度限制  [64KiB, 10MiB]
        policy.addContentLengthRangeCondition(64 * 1024, 10 * 1024 * 1024);

        Map<String, String> formData = minioClient.getPresignedPostFormData(policy);

        // 使用POST请求执行上传一个图片
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            multipartBuilder.addFormDataPart(entry.getKey(), entry.getValue());
        }
        // 关键字
        multipartBuilder.addFormDataPart("key", "my-object");
        // 内容类型
        multipartBuilder.addFormDataPart("Content-Type", "image/png");

        //  上传文件, 最后添加
        multipartBuilder.addFormDataPart(
                "file", "my-object",
                RequestBody.create(MediaType.parse("image/png"), new File("C:\\Users\\JionJion\\Desktop\\jion.png")));

        // 请求体
        Request request =
                new Request.Builder()
                        .url("http://127.0.0.1:9000/my-bucket")
                        .post(multipartBuilder.build())
                        .build();

        // 执行请求
        OkHttpClient httpClient = new OkHttpClient().newBuilder().build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                log.error("文件上传成功!");
            } else {
                log.error("文件上传失败!");
            }
        }
    }
}
