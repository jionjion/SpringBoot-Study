package top.jionjion.mail.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.jionjion.mail.bean.Mail;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件发送服务
 *
 * @author Jion
 */
@Slf4j
@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String mailSender;

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    /**
     * 发送文本邮件
     *
     * @param mail 邮件对象
     */
    void sendSimpleMail(Mail mail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(mailSender);
            mailMessage.setTo(mail.getRecipient());
            mailMessage.setSubject(mail.getSubject());
            mailMessage.setText(mail.getContent());
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败:{}", e.getMessage());
        }
    }

    void sendHtmlMail(Mail mail) {
        try {
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            //true 表示需要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getContent(), true);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败: {}", e.getMessage());

        }
    }

    void sendAttachmentMail(Mail mail) {
        try {
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            //true 表示需要创建一个multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailSender);
            mimeMessageHelper.setTo(mail.getRecipient());
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getContent());
            //文件路径 目前写死在代码中，之后可以当参数传过来，或者在Mail中添加属性absolutePath
            String absolutePath = "G:\\test.jpg";
            FileSystemResource file = new FileSystemResource(new File(absolutePath));
            //FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/email.png"));
            String fileName = absolutePath.substring(absolutePath.lastIndexOf(File.separator));
            //添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
            mimeMessageHelper.addAttachment(fileName, file);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败: {}", e.getMessage());
        }
    }
}