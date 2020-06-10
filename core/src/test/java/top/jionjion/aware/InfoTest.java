package top.jionjion.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author Jion
 */
@RunWith(SpringRunner.class)
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