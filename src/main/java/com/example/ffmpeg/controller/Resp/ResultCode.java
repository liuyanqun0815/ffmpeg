package com.example.ffmpeg.controller.Resp;

import lombok.Getter;

/**
 * @author liuyanqun
 * @description: TODO
 * @date 2023/2/16 10:18
 */
@Getter
public enum ResultCode {

    ERROR("ERROR", "未知错误"),

    ;

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
