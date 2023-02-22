package com.example.ffmpeg.avr.domain.video.repositories;

import com.example.ffmpeg.avr.domain.video.entities.VideoConfigEntity;
import com.example.ffmpeg.avr.domain.video.repositories.dto.CreateTokenParam;

/**
 * 音视频通用接口
 * @author liuyanqun
 * @see
 */
public interface ThirdPartySysAdapter {

    /**
     * 调用三方系统创建房间
     * @return
     */
    String createRoomId();

    /**
     * 获取三方的token
     * @param tokenParam
     * @return
     */
    String createToken(CreateTokenParam tokenParam);

}
