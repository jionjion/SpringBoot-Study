package top.jionjion.hibernate.objects;

import org.hibernate.validator.constraints.LuhnCheck;

/**
 * 通用对象校验
 * .@LuhnCheck 通过Luhn算法计算.
 * 一般用于验证身份识别码,银行卡
 *
 * @author jion
 */
public class LuhnCheckValidation {

    /**
     * .@LuhnCheck 通过Luhn算法计算
     */
    @LuhnCheck(message = "不符合Luhn算法要求")
    public String mustLuhnCheck;
}
