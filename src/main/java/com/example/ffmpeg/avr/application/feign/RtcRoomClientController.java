package com.example.ffmpeg.avr.application.feign;

import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.client.RtcRoomClient;
import com.example.ffmpeg.avr.client.video.param.RemoveUserParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@RestController
public class RtcRoomClientController implements RtcRoomClient {


    @Override
    public ResultDTO<Void> removeUser(RemoveUserParam removeUser) {
        return null;
    }

    @Override
    public ResultDTO<Void> dismissRoom(String roomId, String sessionId) {
        return null;
    }
}
