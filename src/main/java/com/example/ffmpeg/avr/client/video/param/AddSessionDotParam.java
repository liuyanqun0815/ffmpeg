package com.example.ffmpeg.avr.client.video.param;

import lombok.Data;

import java.util.Date;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class AddSessionDotParam {
    /**
     * 会话id
     */
    private String sessionId;
    /**
     * 打点时间
     */
    private Date dotTime;
    /**
     * 打点类型，1：自动打点，2:手动打点
     */
    private int dotType;
    /**
     * 打点内容
     */
    private String dotContent;
}
