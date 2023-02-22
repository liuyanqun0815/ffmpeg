package com.example.ffmpeg.avr.client.video.client;

import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.param.VideoEndRecordParam;
import com.example.ffmpeg.avr.client.video.param.VideoStartRecordParam;

/**
 * 音视频录制客户端接口，该接口提供了一系列基础功
 * @author liuyanqun
 * @version TODO
 * @see
 */
public interface VideoRecordClient {

    /**
     * 开始录制
     * @param startRecord 开始录制参数
     * @return
     */
    ResultDTO<Void> startRecord(VideoStartRecordParam startRecord);

    /**
     * 停止录制
     * @param endRecord 结束录制参数
     * @return
     */
    ResultDTO<Void> stopRecord(VideoEndRecordParam endRecord);


}
