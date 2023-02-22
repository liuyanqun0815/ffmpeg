package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.domain.video.repositories.ThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.video.repositories.dto.CreateTokenParam;
import com.example.ffmpeg.avr.utils.RtcRoomUtils;
import com.example.ffmpeg.avr.utils.TokenServerAssistant;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Slf4j
public class ZegoPrivateAdapter implements ThirdPartySysAdapter {

    @Override
    public String createRoomId() {
        return RtcRoomUtils.createRoomId();
    }

    @Override
    public String createToken(CreateTokenParam tokenParam) {
        //获取用户token
        long appId = tokenParam.getAppId();
        String serverSecret = tokenParam.getPrivateKey();
        String accid = tokenParam.getAccid();
        int EXPIRATION = tokenParam.getEXPIRATION();
        /**
         *  调试时，置为 true, 可在控制台输出更多信息；正式运行时，最好置为 false
         */
        TokenServerAssistant.VERBOSE = true;
        //TODO 权限认证Token区别
        TokenServerAssistant.TokenInfo token = TokenServerAssistant.generateToken04(appId, accid, serverSecret, EXPIRATION, null);
        if (token.error == null || token.error.code == TokenServerAssistant.ErrorCode.SUCCESS) {
            return token.data;
        }else {
            log.error("accid:{} get zego token error:{}",accid, token);
        }
        log.info("accid:{} zego token:{}",accid, token);
        return null;
    }


}
