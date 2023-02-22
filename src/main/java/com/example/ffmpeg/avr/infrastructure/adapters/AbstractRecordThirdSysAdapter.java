package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.domain.record.repositories.dto.RecordCommonDTO;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.profile.Language;
import com.tencentcloudapi.trtc.v20190722.TrtcClient;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
public abstract class AbstractRecordThirdSysAdapter {

    public TrtcClient CloudRecord(RecordCommonDTO commonDTO) {
        String privateKey = commonDTO.getTrtcProperties().getPrivateKey();
        String secretId = commonDTO.getTrtcProperties().getSecretId();
        String region = commonDTO.getTrtcProperties().getRegion();
        Credential cred = new Credential(secretId, privateKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        /**
         * </p>从3.1.16版本开始, 单独设置 HTTP 代理
         * </p>httpProfile.setProxyHost("真实代理ip");
         * </p>httpProfile.setProxyPort(真实代理端口);
         */
        httpProfile.setReqMethod("POST");
        // 请求连接超时时间，单位为秒(默认60秒)
        httpProfile.setConnTimeout(30);
        // 设置写入超时时间，单位为秒(默认0秒)
        httpProfile.setWriteTimeout(30);
        // 设置读取超时时间，单位为秒(默认0秒)
        httpProfile.setReadTimeout(30);
        /**
         * 增加代理
         * this.setHttpProfileProxy(httpProfile);
         * </p>
         * 实例化一个client选项，可选的，没有特殊需求可以跳过
         */
        ClientProfile clientProfile = new ClientProfile();
        // 指定签名算法(默认为HmacSHA256)
        clientProfile.setSignMethod("HmacSHA256");
        // 自3.1.80版本开始，SDK 支持打印日志。
        clientProfile.setHttpProfile(httpProfile);
        clientProfile.setDebug(true);
        // 从3.1.16版本开始，支持设置公共参数 Language, 默认不传，选择(ZH_CN or EN_US)
        clientProfile.setLanguage(Language.EN_US);
        // 实例化要请求产品(以cvm为例)的client对象,clientProfile是可选的
        TrtcClient client = new TrtcClient(cred, region, clientProfile);
        return client;
    }

}
