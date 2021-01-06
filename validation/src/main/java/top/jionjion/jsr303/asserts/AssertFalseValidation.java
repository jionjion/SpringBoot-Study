package top.jionjion.jsr303.asserts;

import javax.validation.constraints.AssertFalse;

/**
 * 布尔值校验
 * .@AssertFalse 必须为 false
 *
 * @author jion
 */
public class AssertFalseValidation {

    /**
     * .@AssertFalse 必须为 false
     */
    @AssertFalse(message = "必须为 false")
    public Boolean mustFalse;
}
