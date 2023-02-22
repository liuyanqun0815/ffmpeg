package com.example.ffmpeg.avr.client.video.client;

import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.param.RemoveUserParam;

/**
 *
 * rtc房间管理客户端接口，该接口提供了一系列基础功能
 * @author liuyanqun
 * @version TODO
 * @see
 */
public interface RtcRoomClient {

    /**
     * 移除用户
     * @param removeUser
     * @return
     */
    ResultDTO<Void> removeUser(RemoveUserParam removeUser);

    /**
     * 解散房间号
     * @param roomId 房间号
     * @param sessionId 会话id
     * @return
     */
    ResultDTO<Void> dismissRoom(String roomId,String sessionId);


}
