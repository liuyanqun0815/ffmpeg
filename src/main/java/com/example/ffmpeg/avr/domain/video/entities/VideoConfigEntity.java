package com.example.ffmpeg.avr.domain.video.entities;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 音视频配置信息（值对象）
 *
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class VideoConfigEntity {

    private String token;

    /**
     * trtc sdkAppId
     */
    private Long appId;

    private String privateKey;
    /**
     * 私有trtc，内网配置信息
     */
    private TrtcInEntity inEntity;
    /**
     * 私有trtc，外网配置信息
     */
    private TrtcOutEntity outEntity;

    private ZegoEntity zegoEntity;

    public static VideoConfigEntity paseEntity(VideoTrtcProperties trtcProperties) {
        VideoConfigEntity videoConfigEntity = new VideoConfigEntity();
        videoConfigEntity.setPrivateKey(trtcProperties.getPrivateKey());
        videoConfigEntity.setAppId(trtcProperties.getSdkAppId());
        videoConfigEntity.setInEntity(TrtcInEntity.paseEntity(trtcProperties.getIn()));
        videoConfigEntity.setOutEntity(TrtcOutEntity.paseEntity(trtcProperties.getOut()));
        return videoConfigEntity;
    }

    public static VideoConfigEntity paseEntity(VideoZegoProperties zegoProperties) {
        VideoConfigEntity videoConfigEntity = new VideoConfigEntity();
        ZegoEntity zegoEntity = new ZegoEntity();
        BeanUtils.copyProperties(zegoProperties, zegoEntity);
        videoConfigEntity.setZegoEntity(zegoEntity);
        videoConfigEntity.setAppId(zegoProperties.getAppId());
        return videoConfigEntity;
    }

    /**
     * 内网私有trtc 配置信息
     */
    @Data
    public static class TrtcInEntity {
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

        public static TrtcInEntity paseEntity(VideoTrtcProperties.In trtcProperties) {
            TrtcInEntity trtcInEntity = new TrtcInEntity();
            BeanUtils.copyProperties(trtcProperties, trtcInEntity);
            return trtcInEntity;
        }
    }

    /**
     * 外网私有trtc 配置信息
     */
    @Data
    public static class TrtcOutEntity {
        private String accessHost;
        private String[] accessHostList;
        private String[] accessIP;
        private String accessPubKey;
        private String webProxyServer;

        public static TrtcOutEntity paseEntity(VideoTrtcProperties.Out trtcProperties) {
            TrtcOutEntity trtcOutEntity = new TrtcOutEntity();
            BeanUtils.copyProperties(trtcProperties, trtcOutEntity);
            return trtcOutEntity;
        }
    }

    @Data
    public static class ZegoEntity {

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

    }

}



