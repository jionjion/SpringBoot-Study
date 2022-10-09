package top.jionjion.web.exception;

/**
 *  @author Jion
 *      自定义用户异常
 */
public class UserException extends RuntimeException{

    /** 内部版本代码 */
    private static final long serialVersionUID = 2L;

    /**自定义异常代码*/
    private final Integer code;

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
