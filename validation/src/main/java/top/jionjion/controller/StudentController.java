package top.jionjion.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.jionjion.bean.Student;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

/**
 * 前端传入校验..
 *
 * @author Jion
 */
@RestController
public class StudentController {

    /**
     * 校验不通过时直接抛异常
     * curl -H "Content-Type:application/json" -X POST --data '{"id":"1","name":"Jion"}' http://127.0.0.1:8080/student/a
     *
     * @param student 传入参数
     * @return 处理结果
     */
    @PostMapping("/student/a")
    public Student studentA(@RequestBody @Valid Student student) {
        return student;
    }

    /**
     * 将校验结果放进BindingResult里面，用户自行判断并处理.交由统一异常处理
     *
     * @param student       传入参数
     * @param bindingResult 验证结果
     * @return 处理结果
     */
    @PostMapping("/student/b")
    public Student studentB(@RequestBody @Valid Student student, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            String messages = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            throw new RuntimeException(messages);
        }
        return student;
    }

    /**
     * 统一异常处理
     *
     * @param exception 异常
     * @return 信息
     */
    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(RuntimeException exception) {
        return exception.getMessage();
    }

    /**
     * 手动调用验证
     *
     * @param student 传入参数
     * @return 处理结果
     */
    @PostMapping("/student/c")
    public Student studentC(@RequestBody Student student) {
        // 参数校验
        validate(student);
        return student;
    }

    /**
     * 手动校验
     */
    private void validate(@Valid Student student) {
        // 不符合要求的项目
        Set<ConstraintViolation<@Valid Student>> validateSet = Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(student);

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