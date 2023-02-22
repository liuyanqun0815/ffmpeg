package com.example.ffmpeg.avr.domain.record.repositories.dto;

import lombok.Data;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class VideoRecordStatusDTO extends RecordCommonDTO{
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
     * 录制任务的唯一Id，在启动录制成功后会返回。
     */
    private String taskId;
    /**
     * 即构录制服务器地址
     */
    private String zegoRecordAddress;
}
