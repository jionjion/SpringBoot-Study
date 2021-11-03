package top.jionjion.mail.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.mail.bean.Mail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Jion
 */
@SpringBootTest
class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        Mail mail = new Mail();
        mail.setRecipient("1434501783@qq.com");
        mail.setSubject("测试");
        mail.setContent("这是一封测试内容...嘤嘤嘤");
        mailService.sendSimpleMail(mail);
    }

    @Test
    void sendHTMLMail() {
        Mail mail = new Mail();
        mail.setRecipient("1434501783@qq.com");
        mail.setSubject("这是一封HTML格式的邮件");
        String sb = "<h2>SpringBoot测试邮件HTML</h2>" +
                "<p style='text-align:left'>这是一封HTML邮件...</p>" +
                "<p> 时间为：" +
                LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) +
                "</p>";
        mail.setContent(sb);
        mailService.sendHtmlMail(mail);
    }

    @Test
    void sendAttachmentMail(){
        Mail mail = new Mail();
        mail.setRecipient("1434501783@qq.com");
        mail.setSubject("SpringBootMail之这是一封有附件格式的邮件");
        mail.setContent("SpringBootMail发送一封有附件格式的邮件，时间为："+ LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));

        mailService.sendAttachmentMail(mail);
    }
}