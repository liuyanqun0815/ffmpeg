package com.example.ffmpeg.avr.client.base.result;

import com.example.ffmpeg.avr.client.base.enums.ResultCodeEnum;

import java.util.Objects;

import static com.example.ffmpeg.avr.client.base.enums.ResultCodeEnum.PARAM_ERROR;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
public class ResultDTO<T> {

    private Integer code;
    private String msg;
    private T data;

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

    public boolean  isOk(){
        return Objects.equals(this.code, ResultCodeEnum.SUCCESS.getCode());
    }

    public static <T> ResultDTO<T> success(T data) {
        ResultDTO<T> result = new ResultDTO<T>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> ResultDTO<T> fail(ResultCodeEnum code) {
        ResultDTO<T> result = new ResultDTO<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }
    public static <T> ResultDTO<T> fail(String message) {
        ResultDTO<T> result = new ResultDTO<T>();
        result.setCode(PARAM_ERROR.getCode());
        result.setMsg(message);
        return result;
    }
}
