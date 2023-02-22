package com.example.ffmpeg.config;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
public class CombineException extends RuntimeException {
    public CombineException() {
        super();
    }

    public CombineException(String message) {
        super(message);
    }

    public CombineException(String message,String mess,String code) {
        super(message);
    }

    public CombineException(String message, Throwable cause) {
        super(message, cause);
    }

    public CombineException(Throwable cause) {
        super(cause);
    }

    protected CombineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
