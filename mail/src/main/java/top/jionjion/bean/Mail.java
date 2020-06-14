package top.jionjion.bean;

import lombok.Data;

/**
 *  邮件类
 *  @author Jion
 */
@Data
public class Mail {
    /** 收件人 */
    private String recipient;
    /** 主题 */
    private String subject;
    /** 内容 */
    private String content;
}
