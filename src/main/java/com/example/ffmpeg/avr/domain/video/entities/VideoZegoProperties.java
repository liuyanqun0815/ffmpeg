package com.example.ffmpeg.avr.domain.video.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "video.zego")
public class VideoZegoProperties {

        /**
        * 派发的签名, 用来校验对应 appID 的合法性。
        */
        private String appSign;
        /**
        * Zego 派发的数字 ID, 开发者的唯一标识
        */
        private Long appId;
        /**
         *serverSecret，从即构控制台获取，用户获取token
         */
        private String serverSecret;
        /**
        * 日志上报服务域名。格式：sample_domain.com:9005，具体请联系 ZEGO 技术支持获取
        */
        private String logDomainName;
        /**
        * 音视频服务域名。格式：sample_domain.com:15443，具体请联系 ZEGO 技术支持获取
        */
        private String domainName;
        /**
        * 是否使用https
        */
        private boolean useHttps;

        private int anType;
        /**
         * 录制服务器地址
         */
        private String recordAddress;

}
