package top.jionjion.hibernate.objects;

import org.hibernate.validator.constraints.Currency;

/**
 * 通用对象校验
 * .@CurrencyValidation 必须为一个币种
 *
 * @author jion
 */
@Deprecated
public class CurrencyValidation {

    /**
     * .@CurrencyValidation 必须为一个币种
     */
    @Currency(value = {"RMB", "CNY"}, message = "必须为范围内的币种.")
    public String mustCurrency;
}
