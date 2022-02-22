package top.jionjion.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * StringUtils 测试类
 *
 * @author Jion
 */
@Slf4j
public class StringUtilsTest {

    @Test
    public void test() {
        // 判断字符串是否已指定内容开头。忽略大小写
        log.info("是否以指定开头: {}", StringUtils.startsWithIgnoreCase("ABC", "A"));
        log.info("是否以指定开头: {}", StringUtils.startsWithIgnoreCase("ABC", "a"));

        // 判断字符串是否是以指定内容结束,忽略大小写
        log.info("是否以指定结尾: {}", StringUtils.endsWithIgnoreCase("ABC", "C"));
        log.info("是否以指定结尾: {}", StringUtils.endsWithIgnoreCase("ABC", "c"));

        // 是否包含空白符
        log.info("是否包含空白符: {}", StringUtils.containsWhitespace("AB "));

        // 判断字符串非空且长度不为 0,即,Not Empty
        log.info("判断字符串非空且长度不为0: {}", StringUtils.hasLength(" "));

        // 判断字符串是否包含实际内容,即非仅包含空白符,也就是 Not Blank
        log.info("判断字符串是否包含实际内容: {}", StringUtils.hasText(" "));

        // 判断字符串指定索引处是否包含一个子串。
        log.info("判断字符串指定索引处是否包含一个子串: {}", StringUtils.substringMatch("ABC", 1, "BC"));

        // 计算一个字符串中指定子串的出现次数
        log.info("计算一个字符串中指定子串的出现次数: {}", StringUtils.countOccurrencesOf("ABB", "B"));
    }

    @Test
    public void testB() {
        // 查找并替换指定子串
        log.info("查找并替换指定子串: {}", StringUtils.replace("ABC", "ABC", "abc"));

        // 去除头部的特定字符
        log.info("去除头部的特定字符: {}", StringUtils.trimLeadingCharacter("AAB", 'A'));

        // 去除尾部的特定字符
        log.info("去除尾部的特定字符: {}", StringUtils.trimTrailingCharacter("ABB", 'B'));

        // 去除头部的空白符
        log.info("去除头部的空白符: {}", StringUtils.trimLeadingWhitespace("  ABC"));

        // 去除尾部的空白符
        log.info("去除尾部的空白符: {}", StringUtils.trimTrailingWhitespace("ABC  "));

        // 去除头部和尾部的空白符
        log.info("去除头部和尾部的空白符: {}", StringUtils.trimWhitespace("  ABC  "));

        // 删除头尾和中间的空白符
        log.info("删除头尾和中间的空白符: {}", StringUtils.trimAllWhitespace("  A  B  C  "));

        // 删除指定子串
        log.info("删除指定子串: {}", StringUtils.delete("ABCDEFG", "DEFG"));

        // 删除指定字符（可以是多个）
        log.info("删除指定字符: {}", StringUtils.deleteAny("ABCDEFG", "A"));

        // 对数组的每一项执行 trim() 方法
        log.info("对数组的每一项执行trim()方法: {}", Arrays.toString(StringUtils.trimArrayElements(new String[]{"  A ", "  B", "   C"})));

        // 将 URL 字符串进行解码
        log.info("将URL字符串进行解码: {}", StringUtils.uriDecode("https://www.baidu.com", StandardCharsets.UTF_8));
    }

    /**
     * 路径相关工具方法
     */
    @Test
    public void testC() {
        String filePath = "src/main/resources/application.properties";
        // 解析路径字符串,优化其中的 .=> StringUtilsTest.java
        log.info("优化文件路径: {}", StringUtils.cleanPath("./StringUtilsTest.java"));

        // 解析路径字符串,解析出文件名部分 => application.properties
        log.info("获得文件名: {}", StringUtils.getFilename(filePath));

        // 解析路径字符串,解析出文件后缀名 => properties
        log.info("获得文件后缀名: {}", StringUtils.getFilenameExtension(filePath));

        // 比较两个两个字符串,判断是否是同一个路径. 会自动处理路径中的 '..' 和 '.'  => true
        log.info("比较两个路径是否相同: {}", StringUtils.pathEquals("../", "./.././"));

        // 删除文件路径名中的除后缀名后剩余部分  => src/main/resources/application
        log.info("删除文件路径名中的除后缀名后剩余部分: {}", StringUtils.stripFilenameExtension(filePath));

        // 以 . 作为分隔符,获取其最后一部分 => properties
        log.info("文件类型: {}", StringUtils.unqualify(filePath));

        // 以指定字符作为分隔符,获取其最后一部分 => application.properties
        log.info("以指定字符作为分隔符: {}", StringUtils.unqualify("classpath:application.properties", ':'));
    }
}
