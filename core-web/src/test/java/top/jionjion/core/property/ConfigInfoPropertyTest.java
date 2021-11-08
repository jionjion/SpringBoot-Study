package top.jionjion.core.property;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author Jion
 */
@SpringBootTest
class ConfigInfoPropertyTest {

    @Autowired
    ConfigInfoProperty property;

    @Test
    public void testInfo(){
        // 字符串
        System.out.println(property.getAuthor());

        // 数组
        System.out.println(Arrays.toString(property.getArray()));

        // 列表
        System.out.println(property.getList());

        // 集合
        System.out.println(property.getMap());
    }
}