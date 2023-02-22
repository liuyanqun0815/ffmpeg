package com.example.ffmpeg.avr.client.video.param;

import lombok.Data;

import java.util.List;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class RemoveUserParam {

    /**
     * 房间id
     */
    private String roomId;
    /**
     * 会话id
     */
    private String sessionId;
    /**
     * 踢出accid用户类型
     */
    private List<String> accidList;
}
