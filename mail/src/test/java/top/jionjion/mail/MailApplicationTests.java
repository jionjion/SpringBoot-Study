package top.jionjion.mail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Spring 邮件发送测试
 */
class MailApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> MailApplication.main(new String[]{""}));
    }

}
