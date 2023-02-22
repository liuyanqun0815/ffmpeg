package com.example.ffmpeg.avr.application.feign;

import com.example.ffmpeg.avr.application.services.VideoConfigService;
import com.example.ffmpeg.avr.client.base.enums.PassageWayEnum;
import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.client.VideoConfigClient;
import com.example.ffmpeg.avr.client.video.dto.VideoConfigDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@RestController
@Slf4j
public class VideoConfigClientController implements VideoConfigClient {

    @Value("${video.passageway.default}")
    private Integer defaultPassageway;
    @Value("${video.passageway.support}")
    private List<Integer> supportPassageway;
    @Resource
    private VideoConfigService videoConfigService;

    @Override
    @GetMapping("/getVideoConfig")
    public ResultDTO<VideoConfigDTO> getVideoConfig(String accid, PassageWayEnum passageway) {

        if (StringUtils.isEmpty(accid)){
            throw new RuntimeException("用户信息有误");
        }
        if(passageway == null && defaultPassageway == null){
            throw new RuntimeException("未配置默认通道");
        }
        if(passageway == null && defaultPassageway!= null){
            passageway = PassageWayEnum.getEnumByCode(defaultPassageway);
        }
        if(!supportPassageway.contains(passageway.getCode())){
            throw new RuntimeException("不支持的通道"+passageway);
        }
        return ResultDTO.success(videoConfigService.getVideoConfig(accid,passageway));
    }

    @Override
    public ResultDTO<String> getChatRoomId(PassageWayEnum passageway) {
        if(passageway == null && defaultPassageway == null){
            throw new RuntimeException("未配置默认通道");
        }
        if(passageway == null && defaultPassageway!= null){
            passageway = PassageWayEnum.getEnumByCode(defaultPassageway);
        }
        if(!supportPassageway.contains(passageway.getCode())){
            throw new RuntimeException("不支持的通道"+passageway);
        }
        return ResultDTO.success(videoConfigService.getChatRoomId(passageway));
    }
}
