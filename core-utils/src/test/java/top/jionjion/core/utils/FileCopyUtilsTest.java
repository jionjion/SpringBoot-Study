package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.FileCopyUtils;

import java.io.*;

/**
 * FileCopyUtils 文件工具类
 *
 * @author Jion
 */
@Slf4j
public class FileCopyUtilsTest {

    private final File in = new File("W:\\SpringBoot-Study\\core-utils\\src\\main\\resources\\application.properties");
    private final File out = new File("W:\\SpringBoot-Study\\core-utils\\test\\main\\resources\\application.properties");


    /**
     * 输入
     */
    @Test
    public void testA() throws IOException {
        // 从文件中读入到字节数组中
        byte[] bytes = FileCopyUtils.copyToByteArray(in);
        log.info("内容: {}", new String(bytes));

        // 从输入流中读入到字节数组中
        byte[] bytes1 = FileCopyUtils.copyToByteArray(new FileInputStream(in));
        log.info("内容: {}", new String(bytes1));

        // 从输入流中读入到字符串中
        String context = FileCopyUtils.copyToString(new FileReader(in));
        log.info("内容: {}", context);
    }


    /**
     * 输出
     */
    @Test
    public void testB() throws IOException {
        // 从字节数组到文件
        FileCopyUtils.copy("这是内容".getBytes(), new File("输出内容.txt"));

        // 从文件到文件
        FileCopyUtils.copy(in, out);

        // 从字节数组到输出流
        FileCopyUtils.copy("这是内容".getBytes(), System.out);

        // 从输入流到输出流
        FileCopyUtils.copy(new FileInputStream(in), System.out);

        // 从输入流到输出流
        FileCopyUtils.copy(new FileReader(in), new FileWriter(out));

        // 从字符串到输出流
        FileCopyUtils.copy("这是内容", new FileWriter(out));
    }
}
