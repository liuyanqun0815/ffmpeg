//package com.example.ffmpeg.avr.client.video.dto;
//
//import lombok.Data;
//
///**
// * @author liuyanqun
// * @version TODO
// * @see
// */
//@Data
//public class TrtcConfig {
//    /**
//     * trtc sdkAppId
//     */
//    private String appId;
//    /**
//     * 私有trtc，内网配置信息
//     */
//    private TrtcInConfig trtcInConfig;
//    /**
//     * 私有trtc，外网配置信息
//     */
//    private TrtcOutConfig trtcOutConfig;
//
//}
//
///**
// * 内网私有trtc 配置信息
// */
//@Data
//class TrtcInConfig {
//    /**
//     * 域名
//     */
//    private String accessHost;
//    /**
//     * ip
//     */
//    private String[] accessIP;
//    /**
//     * 入网密钥
//     */
//    private String accessPubKey;
//    /**
//     * web代理的地址
//     */
//    private String webProxyServer;
//}
//
///**
// * 外网私有trtc 配置信息
// */
//@Data
//class TrtcOutConfig {
//    private String accessHost;
//    private String[] accessHostList;
//    private String[] accessIP;
//    private String accessPubKey;
//    private String webProxyServer;
//}
