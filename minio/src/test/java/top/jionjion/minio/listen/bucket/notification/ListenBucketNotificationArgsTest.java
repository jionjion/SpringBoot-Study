package top.jionjion.minio.listen.bucket.notification;

import io.minio.CloseableIterator;
import io.minio.ListenBucketNotificationArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Event;
import io.minio.messages.NotificationRecords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * ListenBucketNotificationArgs 侦听存储桶的对象前缀和后缀的事件。
 * 返回的可关闭迭代器是延迟计算的，因此需要迭代以获取新记录，并且必须与try-with-resource一起使用以释放网络资源。
 *
 * @author Jion
 */
class ListenBucketNotificationArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    void init() {
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    // 持续监听事件
    @Test
    void listenBucketNotification() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String[] events = {"s3:ObjectCreated:*", "s3:ObjectAccessed:*"};
        try (CloseableIterator<Result<NotificationRecords>> ci =
                     minioClient.listenBucketNotification(
                             ListenBucketNotificationArgs.builder()
                                     .bucket("cache")
                                     .prefix("")
                                     .suffix("")
                                     .events(events)
                                     .build())) {
            while (ci.hasNext()) {
                NotificationRecords records = ci.next().get();
                for (Event event : records.events()) {
                    System.out.println("Event " + event.eventType() + " occurred at " + event.eventTime()
                            + " for " + event.bucketName() + "/" + event.objectName());
                }
            }
        }

    }
}
