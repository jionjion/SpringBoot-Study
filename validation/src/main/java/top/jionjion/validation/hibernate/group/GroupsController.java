package top.jionjion.validation.hibernate.group;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.jionjion.validation.bean.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

/**
 * 分组校验
 *
 * @author Jion
 */
@RestController
public class GroupsController {

    /**
     * 将校验结果放进BindingResult里面，用户自行判断并处理.交由统一异常处理
     *
     * @param obj           传入参数
     * @param bindingResult 验证结果
     * @return 处理结果
     */
    @PutMapping("/groups/b")
    @ResponseBody
    public String studentB(@RequestBody @Validated({GroupsEnum.Update.class}) GroupsValidation obj, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
        }
        return obj.toString();
    }


    /**
     * 手动调用验证
     *
     * @param student 传入参数
     * @return 处理结果
     */
    @PostMapping("/groups/c")
    public Student studentC(@RequestBody Student student) {
        // 参数校验
        validateWhenUpdate(student);
        return student;
    }

    /**
     * 手动校验
     */
    private void validateWhenUpdate(@Valid Student student) {
        // 不符合要求的项目
        Set<ConstraintViolation<@Valid Student>> validateSet = Validation.buildDefaultValidatorFactory()
                .getValidator()
                // 分组
                .validate(student, GroupsEnum.Update.class);

        // 处理并返回
        if (!CollectionUtils.isEmpty(validateSet)) {
            String messages = validateSet.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            throw new RuntimeException(messages);
        }
    }
}
