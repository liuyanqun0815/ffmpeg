package com.example.ffmpeg.avr.domain.record.repositories.dto;

import lombok.Data;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class DissmissRoomDTO extends RecordCommonDTO {

    private String roomId;

    private String sessionId;

}
