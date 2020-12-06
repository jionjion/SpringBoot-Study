package top.jionjion.aware;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author Jion
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = "top.jionjion.aware")
public class InfoTest {

    @Autowired
    Info info;

    @Test
    public void testInfo(){
        // 字符串
        System.out.println(info.getAuthor());

        // 数组
        System.out.println(Arrays.toString(info.getArray()));

        // 列表
        System.out.println(info.getList());

        // 集合
        System.out.println(info.getMap());
    }
}