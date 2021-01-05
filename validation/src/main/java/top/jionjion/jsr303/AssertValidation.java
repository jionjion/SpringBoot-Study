package top.jionjion.jsr303;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

/**
 *
 * @author jion
 */
public class AssertValidation {

    /**
     *  @AssertTrue 必须为 true
     */
    @AssertTrue(message = "必须为 true")
    public Boolean mustTrue;

    /**
     *  @AssertFalse 必须为 false
     */
    @AssertFalse(message = "必须为 false")
    public Boolean mustFalse;
}
