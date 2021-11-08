package top.jionjion.validation.hibernate.objects;

import org.hibernate.validator.constraints.CreditCardNumber;

/**
 * 通用对象校验
 * .@CreditCardNumber 必须为一个信用卡编码
 *
 * @author jion
 */
public class CreditCardNumberValidation {

    /**
     * .@CreditCardNumber 必须为一个信用卡编码
     */
    @CreditCardNumber(message = "必须为一个信用卡编码")
    public String mustCreditCardNumber;
}
