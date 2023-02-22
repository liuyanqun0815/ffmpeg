package com.example.ffmpeg.avr.domain.record.repositories.dto;

import com.example.ffmpeg.avr.domain.video.entities.VideoTrtcProperties;
import com.example.ffmpeg.avr.domain.video.entities.VideoZegoProperties;
import lombok.Data;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class RecordCommonDTO implements java.io.Serializable {
    /**
     * trtc配置
     */
    private VideoTrtcProperties trtcProperties;
    /**
     * 机构配置
     */
    private VideoZegoProperties zegoProperties;
}
