package com.example.ffmpeg.avr.domain.video.services;

import com.example.ffmpeg.avr.client.base.enums.PassageWayEnum;
import com.example.ffmpeg.avr.domain.video.entities.VideoConfigEntity;
import com.example.ffmpeg.avr.domain.video.entities.VideoTrtcProperties;
import com.example.ffmpeg.avr.domain.video.entities.VideoZegoProperties;
import com.example.ffmpeg.avr.domain.video.repositories.ThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.video.repositories.dto.CreateTokenParam;
import com.example.ffmpeg.avr.infrastructure.adapters.RtcCommonFactory;
import com.example.ffmpeg.avr.utils.TokenServerAssistant;
import com.tencentyun.TLSSigAPIv2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Service
@Slf4j
public class VideoDomainService {
    /**
     * 过期时间2day
     */
    private final int EXPIRATION = 2 * 24 * 60 * 60;

    @Resource
    private VideoTrtcProperties trtcProperties;
    @Resource
    private VideoZegoProperties zegoProperties;

    /**
     * 获取trtc登录信息配置
     *
     * @param accid
     * @return
     */
    public VideoConfigEntity getTrtcConfig(String accid) {
        VideoConfigEntity config = VideoConfigEntity.paseEntity(trtcProperties);
        //获取用户token
        ThirdPartySysAdapter adapter = RtcCommonFactory.getThirdPartySysAdapter(PassageWayEnum.TRTC_PRI);
        CreateTokenParam tokenParam = CreateTokenParam.builder()
                .accid(accid)
                .appId(config.getAppId())
                .privateKey(config.getPrivateKey())
                .build();
        String token = adapter.createToken(tokenParam);
        config.setToken(token);
        return config;
    }

    /**
     * 获取机构登录信息配置
     *
     * @param accid
     * @return
     */
    public VideoConfigEntity getZegoConfig(String accid) {
        VideoConfigEntity config = VideoConfigEntity.paseEntity(zegoProperties);
        ThirdPartySysAdapter adapter = RtcCommonFactory.getThirdPartySysAdapter(PassageWayEnum.ZEGO_PRI);
        CreateTokenParam tokenParam = CreateTokenParam.builder()
                .accid(accid)
                .appId(config.getAppId())
                .privateKey(config.getPrivateKey())
                .build();
        String token = adapter.createToken(tokenParam);
        if (StringUtils.isEmpty(token)) {
            log.error("accid:{} get zego token error:{}", accid, token);
            //TODO 获取token失败抛异常
            throw new RuntimeException(String.format("accid:[%s] get zego token error", accid));
        }
        //获取用户token
        config.setToken(token);
        return config;
    }


}
