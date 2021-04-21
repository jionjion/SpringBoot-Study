package top.jionjion.minio.object.remove;

import io.minio.MinioClient;
import io.minio.RemoveObjectsArgs;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

/**
 * RemoveObjectsArgs 延迟删除多个对象
 * 迭代返回的Iterable以执行删除操作是必需的
 *
 * @author Jion
 */
@Slf4j
public class RemoveObjectsArgsTest {

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
    public void removeObjects() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<DeleteObject> objects = new LinkedList<>();
        objects.add(new DeleteObject("my-object1"));
        objects.add(new DeleteObject("my-object2"));
        objects.add(new DeleteObject("my-object3"));
        Iterable<Result<DeleteError>> results =
                minioClient.removeObjects(
                        RemoveObjectsArgs.builder().bucket("my-bucket").objects(objects).build());
        for (Result<DeleteError> result : results) {
            DeleteError error = result.get();
            log.error("Error in deleting object " + error.objectName() + "; " + error.message());
        }
    }
}
