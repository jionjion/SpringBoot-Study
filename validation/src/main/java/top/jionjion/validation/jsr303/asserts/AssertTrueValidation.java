package top.jionjion.validation.jsr303.asserts;

import javax.validation.constraints.AssertTrue;

/**
 * 布尔值校验
 * .@AssertTrue 必须为 true
 *
 * @author jion
 */
@SuppressWarnings("unused")
public class AssertTrueValidation {

    /**
     * .@AssertTrue 必须为 true
     */
    @AssertTrue(message = "必须为 true")
    public Boolean mustTrue;
}
