package top.jionjion.minio.bucket.notification;

import io.minio.MinioClient;
import io.minio.SetBucketNotificationArgs;
import io.minio.errors.*;
import io.minio.messages.EventType;
import io.minio.messages.NotificationConfiguration;
import io.minio.messages.QueueConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

/**
 * SetBucketNotificationArgs 配置设置存储桶的生命周期通知配置
 *
 * @author Jion
 */
public class SetBucketNotificationArgsTest {

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
    public void setBucketNotification() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<EventType> eventList = new LinkedList<>();
        eventList.add(EventType.OBJECT_CREATED_PUT);
        eventList.add(EventType.OBJECT_CREATED_COPY);

        QueueConfiguration queueConfiguration = new QueueConfiguration();
        queueConfiguration.setQueue("arn:minio:sqs::1:webhook");
        queueConfiguration.setEvents(eventList);
        queueConfiguration.setPrefixRule("images");
        queueConfiguration.setSuffixRule("pg");

        List<QueueConfiguration> queueConfigurationList = new LinkedList<>();
        queueConfigurationList.add(queueConfiguration);

        NotificationConfiguration config = new NotificationConfiguration();
        config.setQueueConfigurationList(queueConfigurationList);

        minioClient.setBucketNotification(
                SetBucketNotificationArgs.builder().bucket("cache").config(config).build());

    }
}
