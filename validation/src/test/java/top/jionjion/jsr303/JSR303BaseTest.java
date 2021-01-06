package top.jionjion.jsr303;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * JSR303  基础测试
 *
 * @author Jion
 */
@Slf4j
public abstract class JSR303BaseTest {

    /**
     * 验证对象是否符合要求
     *
     * @param obj 验证对象
     */
    public void validate(@Valid Object obj) {
        // 验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // 验证错误
        Set<ConstraintViolation<Object>> validateSet = validator.validate(obj);

        log.info("=========================================");
        // 结果返回
        for (ConstraintViolation<Object> violation : validateSet) {
            // key:对象属性路径,  value:校验消息
            // 校验结果
            log.info(violation.toString());
        }
    }
}
