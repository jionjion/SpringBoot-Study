package top.jionjion.hibernate.objects;

import org.hibernate.validator.constraints.ISBN;

/**
 * 通用对象校验
 * .@ISBN 必须为ISBN图书编码.是否携带 - 无所谓
 *
 * @author jion
 */
public class IsbnValidation {

    @ISBN(message = "必须为ISBN图书编码")
    public String mustIsbn;
}
