package com.example.ffmpeg.avr.domain.video.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
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
@ConfigurationProperties(prefix = "video.trtc")
public class VideoTrtcProperties {


    /**
     * 公有云对应腾讯云帐号的APPID
     */
    private Long appId;
    /**
     * SDKAppID（应用标识/应用 ID）是腾讯云后台用来区分不同 TRTC 应用的唯一标识
     */
    private Long sdkAppId;
    /**
     * 获取userSig凭证 传递的秘钥
     */
    private String privateKey;
    /**
     * 腾讯云账户secretId
     */
    private String secretId;

    private In in;

    private Out out;
    /**
     * trtc 地区
     */
    private String region;

    /**
     * 内网私有trtc 配置信息
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class In {
        /**
         * 公有云对应腾讯云帐号的ID
         */
        private String accountId;

        /**
         * 私有trtc 服务地址
         */
        private String address;
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
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Out {
        private String accessHost;
        private String[] accessHostList;
        private String[] accessIP;
        private String accessPubKey;
        private String webProxyServer;
    }

}
