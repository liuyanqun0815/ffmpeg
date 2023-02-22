package com.example.ffmpeg.avr.domain.record.repositories.dto;

import lombok.Data;

import java.util.List;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class RemoveUserDTO extends RecordCommonDTO {
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
