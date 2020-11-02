package top.jionjion.swagger.dto;

/**
 * @author Jion
 */
public enum ResponseCode {

    /** 成功消息 */
    SUCCESS(0, "成功");

    private final Integer code;

    private final String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
