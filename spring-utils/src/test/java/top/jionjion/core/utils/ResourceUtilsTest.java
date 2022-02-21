package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * ResourceUtils 资源获取
 *
 * @author Jion
 */
@Slf4j
public class ResourceUtilsTest {

    /**
     * 从资源路径获取文件
     */
    @Test
    public void testA() throws FileNotFoundException {
        // 判断字符串是否是一个合法的 URL 字符串
        log.info("判断字符串是否是一个合法的URL, {}", ResourceUtils.isUrl("http://www.baidu.com"));
        log.info("判断字符串是否是一个合法的URL, {}", ResourceUtils.isUrl("classpath:application.properties"));

        // 获取 URL
        log.info("获取 URL, {}", ResourceUtils.getURL("classpath:application.properties"));

        // 获取文件, 在 JAR 包内无法正常使用,需要是一个独立的文件
        File file = ResourceUtils.getFile("W:\\SpringBoot-Study\\core-utils\\src\\main\\resources\\application.properties");
        log.info("获取文件: {}", file);
    }

    /**
     * Resource 资源
     */
    @Test
    public void testB() throws IOException {

        // URL 资源 如 file://... http://...
        UrlResource urlResource = new UrlResource("file:///W:/SpringBoot-Study/core-utils/src/main/resources/application.properties");

        // 从资源中获得 URI 对象
        URI url = urlResource.getURI();
        log.info("获得");

        // 从资源中获得 URI 对象
        URL uri = urlResource.getURL();


        // 文件系统资源 D:\...
        FileSystemResource fileSystemResource = new FileSystemResource("W:\\SpringBoot-Study\\core-utils\\src\\main\\resources\\application.properties");

        // 判断资源是否存在
        fileSystemResource.exists();

        // 从资源中获得 File 对象
        File file = fileSystemResource.getFile();


        // 获得资源的 InputStream
        InputStream inputStream = fileSystemResource.getInputStream();

        // 类路径下的资源 classpth:...
        ClassPathResource classPathResource = new ClassPathResource("classpath:application.properties");

        // 获得资源的描述信息
        String description = classPathResource.getDescription();
    }
}
