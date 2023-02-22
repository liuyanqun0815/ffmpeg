package com.example.ffmpeg.avr.application.services;

import com.example.ffmpeg.avr.client.base.enums.PassageWayEnum;
import com.example.ffmpeg.avr.client.video.dto.VideoConfigDTO;
import com.example.ffmpeg.avr.domain.video.entities.VideoConfigEntity;
import com.example.ffmpeg.avr.domain.video.repositories.ThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.video.services.VideoDomainService;
import com.example.ffmpeg.avr.infrastructure.adapters.RtcCommonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Service
@Slf4j
public class VideoConfigService {


    @Autowired
    private VideoDomainService videoDomainService;
    @Value("${video.passageway.support}")
    private List<Integer> suportPassageWay;

    /**
     * 获取用户音视频配置信息
     * @param accid
     * @param passageway
     * @return
     */
    public VideoConfigDTO getVideoConfig(String accid, PassageWayEnum passageway) {
        VideoConfigDTO dto = new VideoConfigDTO();
        dto.setAccid(accid);
        dto.setPassagewayList(suportPassageWay);
        if (PassageWayEnum.TRTC_PUB == passageway){
            VideoConfigEntity trtcConfig = videoDomainService.getTrtcConfig(accid);
             BeanUtils.copyProperties(trtcConfig,dto);
            return dto;
        }else if (PassageWayEnum.TRTC_PRI == passageway){
            VideoConfigEntity trtcConfig = videoDomainService.getTrtcConfig(accid);
            BeanUtils.copyProperties(trtcConfig,dto);
            VideoConfigEntity.TrtcInEntity inEntity = trtcConfig.getInEntity();
            VideoConfigDTO.TrtcInConfig inConfig = new VideoConfigDTO.TrtcInConfig();
            BeanUtils.copyProperties(inEntity,inConfig);
            dto.setInConfig(inConfig);
            VideoConfigEntity.TrtcOutEntity outEntity = trtcConfig.getOutEntity();
            VideoConfigDTO.TrtcOutConfig outConfig = new VideoConfigDTO.TrtcOutConfig();
            BeanUtils.copyProperties(outEntity,outConfig);
            dto.setOutConfig(outConfig);
            return dto;
        }else if (PassageWayEnum.ZEGO_PRI == passageway){
            VideoConfigEntity zegoConfig = videoDomainService.getZegoConfig(accid);
            BeanUtils.copyProperties(zegoConfig,dto);
            VideoConfigEntity.ZegoEntity zegoEntity = zegoConfig.getZegoEntity();
            VideoConfigDTO.ZegoConfig zegoConfigDTO = new VideoConfigDTO.ZegoConfig();
            BeanUtils.copyProperties(zegoEntity,zegoConfigDTO);
            dto.setZegoConfig(zegoConfigDTO);
            return dto;
        }else {
            return dto;
        }
    }

    /**
     * 创建房间号
     * @param passageway
     * @return
     */
    public String getChatRoomId(PassageWayEnum passageway) {
        ThirdPartySysAdapter adapter = RtcCommonFactory.getThirdPartySysAdapter(passageway);
        String roomId = adapter.createRoomId();
        return roomId;
    }
}
