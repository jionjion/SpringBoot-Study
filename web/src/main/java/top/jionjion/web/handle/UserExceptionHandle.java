package top.jionjion.web.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jionjion.web.dto.ResultMessage;
import top.jionjion.web.exception.UserException;

/**
 * @author Jion
 * 全局异常通知
 */
@ControllerAdvice
public class UserExceptionHandle {

    /**
     * 处理异常的类,这里将异常统一捕获,完成分类处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultMessage<Object> handle(Exception exception) {
        // 如果属于自定义的异常
        if (exception instanceof UserException) {
            // 强制类型转换
            UserException e = (UserException) exception;

            // 将抛出的异常捕获后包装
            return new ResultMessage<>(e.getCode(), e.getMessage());
        }

        //如果不是自动返回系统的异常
        return new ResultMessage<>(550, exception.getMessage());
    }
}