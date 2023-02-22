package com.example.ffmpeg.config;


import lombok.Data;

/**
 *
 * 即构音视频配置对象
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class VideoConfig {
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
    private String logDomainname;
    /**
     * 音视频服务域名。格式：sample_domain.com:15443，具体请联系 ZEGO 技术支持获取
     */
    private String domainname;
    /**
     * 是否使用https
     */
    private boolean useHttps;

    private int anType;

}
