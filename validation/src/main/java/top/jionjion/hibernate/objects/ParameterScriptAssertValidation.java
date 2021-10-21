package top.jionjion.hibernate.objects;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 方法级别校验, 验证参数是否符合预期.
 * .@ParameterScriptAssert 方法级注解
 * .@ScriptAssert  类级注解
 *
 * @author Jion
 */
@Deprecated
public class ParameterScriptAssertValidation {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @ParameterScriptAssert(script = "start.before(end)", lang = "javascript", message = "开始日必须早于结束日")
    public void validationDate(Date start, Date end) {
        logger.info("开始日, {}", start);
        logger.info("结束日, {}", end);
    }
}
