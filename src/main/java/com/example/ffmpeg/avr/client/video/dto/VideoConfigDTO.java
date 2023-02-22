package com.example.ffmpeg.avr.client.video.dto;

import com.example.ffmpeg.avr.client.base.dto.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 *
 * 音视频配置信息
 * @author liuyanqun
 * @version
 * @see
 */
@Data
public class VideoConfigDTO extends BaseDTO {

    /**
     * trtc sdkAppId
     */
    private Long appId;

    /**
     * 用户id
     */
    private String accid;
    /**
     * 用户token
     */
    private String token;
    /**
     * 支持的通道集合
     */
    private List<Integer> passagewayList;
    /**
     * 腾讯私有trtc内网
     */
    private TrtcInConfig inConfig;
    /**
     * 腾讯私有trtc外网
     */
    private TrtcOutConfig outConfig;
    /**
     * 即构私有配置
     */
    private ZegoConfig zegoConfig;

    /**
     * 内网私有trtc 配置信息
     */
    @Data
    public static class TrtcInConfig {
        /**
         * 域名
         */
        private String accessHost;
        /**
         * ip
         */
        private String[] accessIP;
        /**
         * 入网密钥
         */
        private String accessPubKey;
        /**
         * web代理的地址
         */
        private String webProxyServer;
    }


    /**
     * 外网私有trtc 配置信息
     */
    @Data
    public static class TrtcOutConfig {
        private String accessHost;
        private String[] accessHostList;
        private String[] accessIP;
        private String accessPubKey;
        private String webProxyServer;
    }
    @Data
    public static class ZegoConfig {

        /**
         * 派发的签名, 用来校验对应 appID 的合法性。
         */
        private String appSign;
        /**
         * Zego 派发的数字 ID, 开发者的唯一标识
         */
        private String appId;
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



    }

}


