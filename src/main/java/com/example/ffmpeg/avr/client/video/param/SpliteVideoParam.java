package com.example.ffmpeg.avr.client.video.param;

import lombok.Data;

import java.util.Date;

/**
 * 视频裁剪参数
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class SpliteVideoParam {

    /**
     * 会话id
     */
    private String sessionId;
    /**
     * 本次视频裁剪标识（交易流水号）
     */
    private String tranId;
    /**
     * 截取开始时间
     */
    private Date startTime;
    /**
     *  截取结束时间
     */
    private Date stopTime;

}
