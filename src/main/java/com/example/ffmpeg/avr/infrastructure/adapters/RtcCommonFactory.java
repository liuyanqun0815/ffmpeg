package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.client.base.enums.PassageWayEnum;
import com.example.ffmpeg.avr.domain.video.repositories.ThirdPartySysAdapter;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
public class RtcCommonFactory {

    /**
     * 工厂模式选择合适的适配器
     *
     * @param passageWayEnum
     * @return
     */
    public static ThirdPartySysAdapter getThirdPartySysAdapter(PassageWayEnum passageWayEnum) {
        switch (passageWayEnum) {
            case TRTC_PRI:
                return new TrtcPrivateAdapter();
            case TRTC_PUB:
                return new TrtcPublicAdapter();
            case ZEGO_PRI:
                return new ZegoPrivateAdapter();
            default:
                return null;
        }
    }

}
