package top.jionjion.validation.hibernate.objects;

import org.hibernate.validator.constraints.EAN;

/**
 * 通用对象校验
 * .@EAN 必须为EAN商品编码,商品后面一维码编号.不能有空格
 *
 * @author jion
 */
@SuppressWarnings("unused")
public class EanValidation {

    /**
     * .@EAN 必须为EAN商品编码,商品后面一维码编号.不能有空格
     */
    @EAN(message = "必须为EAN商品编码")
    public String mustEan;
}
