package com.example.ffmpeg.avr.client.video.param;

import lombok.Data;

/**
 * 音视频结束录制
 *
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class VideoEndRecordParam {
    /**
     * 会话id
     */
    private String sesionId;
    /**
     * appid
     */
    private String appId;
    /**
     * 房间号ID
     */
    private String roomId;
    /**
     * 用户accid (userid)
     */
    private String userId;
    /**
     * 租户ID
     */
    private String tenantId;

}
