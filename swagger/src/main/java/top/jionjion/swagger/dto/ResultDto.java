package top.jionjion.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Jion
 */
@ApiModel("api通用返回数据")
@SuppressWarnings("unused")
public class ResultDto<T> {

    /**
     * uuid 序列化ID
     */
    private static final long serialVersionUID = 7498486491866881777L;


    /**
     * 标识代码，0表示成功，非0表示出错
     */
    @ApiModelProperty("标识代码,0表示成功，非0表示出错")
    private Integer code;

    /**
     * 提示信息，通常供报错时使用
     */
    @ApiModelProperty("提示信息,供报错时使用")
    private String msg;

    /**
     * 正常返回时返回的数据
     */
    @ApiModelProperty("返回的数据")
    private T data;

    /**
     * 无参数构造器
     */
    public ResultDto() {

    }

    /**
     * 全参数构造器
     */
    public ResultDto(Integer status, String msg, T data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功数据
     */
    public ResultDto<T> success(T data) {
        return new ResultDto<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static ResultDto<?> success(Integer code, String msg) {
        return new ResultDto<>(code, msg, null);
    }

    /**
     * 返回出错数据
     */
    public static ResultDto<?> error(ResponseCode code) {
        return new ResultDto<>(code.getCode(), code.getMsg(), null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}