package com.example.ffmpeg.avr.client.video.client;

import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.dto.SessionDotDTO;
import com.example.ffmpeg.avr.client.video.param.AddSessionDotParam;
import com.example.ffmpeg.avr.client.video.param.SpliteVideoParam;

import java.util.List;

/**
 * 音视频处理
 * @author liuyanqun
 * @version TODO
 * @see
 */
public interface VideoHandleClient {

    /**
     * 批量下载指定视频到本地
     * @param roomId
     * @param sessionIdList
     * @return
     */
    ResultDTO<Void> downLoadVideo(String roomId, List<String> sessionIdList);

    /**
     * 视频裁剪请求
     * @param spliteVideo
     * @return
     */
    ResultDTO<Void> spliteVideo(SpliteVideoParam spliteVideo);

    /**
     *  查询视频打点
     * @param sessionId
     * @return
     */
    ResultDTO<SessionDotDTO> getSessionDots(String sessionId);

    /**
     * 新增打点
     * @param addSessionDot
     * @return
     */
    ResultDTO<Void> addSessionDot(AddSessionDotParam addSessionDot);

    /**
     *  删除打点
     * @param sessionId
     * @param id
     * @return
     */
    ResultDTO<Void> delSessionDot(String sessionId,Long id);


}
