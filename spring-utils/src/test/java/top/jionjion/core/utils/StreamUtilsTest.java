package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * StreamUtils 流操作
 *
 * @author Jion
 */
@Slf4j
class StreamUtilsTest {

    private final File in = new File("W:\\SpringBoot-Study\\core-utils\\src\\main\\resources\\application.properties");

    /**
     * 输入
     */
    @Test
    void testA() throws IOException {

        // 从输入流中读入到字节数组中
        byte[] bytes = StreamUtils.copyToByteArray(new FileInputStream(in));
        log.info("内容: {}", new String(bytes));

        // 从输入流中读入到字符串中
        String context = StreamUtils.copyToString(new FileInputStream(in), StandardCharsets.UTF_8);
        log.info("内容: {}", context);

        // 舍弃输入流中的内容
        StreamUtils.drain(new FileInputStream(in));
    }

    /**
     * 输出
     */
    @Test
    void testB() throws IOException {
        // 从字节到输出流
        StreamUtils.copy("这是内容...".getBytes(), System.out);

        // 从字符串到输出流
        StreamUtils.copy("这是内容...", StandardCharsets.UTF_8, System.out);

        // 从输入流到输出流
        StreamUtils.copy(new FileInputStream(in), System.out);

        // 从输入流到输入流,指定范围
        StreamUtils.copyRange(new FileInputStream(in), System.out, 0, 100L);
    }
}
