package top.jionjion.minio.object.sql;

import io.minio.MinioClient;
import io.minio.SelectObjectContentArgs;
import io.minio.SelectResponseStream;
import io.minio.errors.*;
import io.minio.messages.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * SelectObjectContentArgs 通过SQL表达式选择对象的内容
 *
 * @author Jion
 */
@Slf4j
class SelectObjectContentArgsTest {

    private MinioClient minioClient;

    @BeforeEach
    void init() {
        this.minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();
    }

    @Test
    void selectObjectContent() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String sqlExpression = "select * from S3Object";
        InputSerialization is = new InputSerialization(null, false, null, null, FileHeaderInfo.USE, null, null, null);
        OutputSerialization os = new OutputSerialization(null, null, null, QuoteFields.ASNEEDED, null);
        SelectResponseStream stream =
                minioClient.selectObjectContent(
                        SelectObjectContentArgs.builder()
                                .bucket("my-bucket")
                                .object("my-object")
                                .sqlExpression(sqlExpression)
                                .inputSerialization(is)
                                .outputSerialization(os)
                                .requestProgress(true)
                                .build());

        byte[] buf = new byte[512];
        int bytesRead = stream.read(buf, 0, buf.length);
        log.info(new String(buf, 0, bytesRead, StandardCharsets.UTF_8));

        Stats stats = stream.stats();
        log.info("bytes scanned: " + stats.bytesScanned());
        log.info("bytes processed: " + stats.bytesProcessed());
        log.info("bytes returned: " + stats.bytesReturned());

        stream.close();
    }
}
