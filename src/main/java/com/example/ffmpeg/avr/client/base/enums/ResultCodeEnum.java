package com.example.ffmpeg.avr.client.base.enums;

/**
 * @author liuyanqun
 * @description: TODO
 * @date 2023/2/16 15:27
 */
public enum ResultCodeEnum {

    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    PARAM_ERROR(2, "param error"),
    NOT_FOUND(3, "not found"),
    UNAUTHORIZED(4, "unauthorized"),
    FORBIDDEN(5, "forbidden"),
    INTERNAL_SERVER_ERROR(6, "internal server error"),
    ;

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
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
