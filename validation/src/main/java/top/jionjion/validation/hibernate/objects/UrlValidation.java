package top.jionjion.validation.hibernate.objects;

import org.hibernate.validator.constraints.URL;

/**
 * 通用对象校验
 * .@URL 必须为URL格式
 *
 * @author jion
 */
public class UrlValidation {

    /**
     *  .@URL 必须为URL格式
     */
    @URL(message="必须为地址格式")
    public String mustUrl;
}
