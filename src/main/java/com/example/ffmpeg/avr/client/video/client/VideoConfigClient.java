package com.example.ffmpeg.avr.client.video.client;

import com.example.ffmpeg.avr.client.base.enums.PassageWayEnum;
import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.dto.VideoConfigDTO;

/**
 * 音视频配置公共接口
 * @author liuyanqun
 * @version TODO
 * @see
 */

public interface VideoConfigClient {

    /**
     * 获取音视频配置信息
     * @param accid 用户id
     * @param passageway 通道号
     * @return
     */
    ResultDTO<VideoConfigDTO> getVideoConfig(String accid, PassageWayEnum passageway);

    /**
     * 通过通道获取房间ID
     * @param passageway
     * @return
     */
    ResultDTO<String> getChatRoomId(PassageWayEnum passageway);
}
