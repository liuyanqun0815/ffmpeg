package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.domain.video.repositories.ThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.video.repositories.dto.CreateTokenParam;
import com.example.ffmpeg.avr.utils.RtcRoomUtils;
import com.tencentyun.TLSSigAPIv2;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Slf4j
public class TrtcPublicAdapter implements ThirdPartySysAdapter {

    @Override
    public String createRoomId() {
        return RtcRoomUtils.createRoomId();
    }

    @Override
    public String createToken(CreateTokenParam tokenParam) {
        Long appId = tokenParam.getAppId();
        String appKey = tokenParam.getPrivateKey();
        int expiration = tokenParam.getEXPIRATION();
        String accid = tokenParam.getAccid();
        TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(appId, appKey);
        String userSig = tlsSigAPIv2.genUserSig(accid, expiration);
        log.info("TrtcPublicAdapter tokenParam:{} trtc userSig:{}", tokenParam, userSig);
        return userSig;
    }

}
