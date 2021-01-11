package top.jionjion.hibernate.group;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/groups/a")
    @ResponseBody
    public String studentB(@RequestBody @Validated({GroupsEnum.UPDATE.class}) GroupsValidation obj, BindingResult bindingResult) {
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
}
