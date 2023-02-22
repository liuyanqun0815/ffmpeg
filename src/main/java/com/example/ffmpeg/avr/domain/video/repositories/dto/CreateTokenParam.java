package com.example.ffmpeg.avr.domain.video.repositories.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
@Builder
public class CreateTokenParam {

    /**
     * 用户id
     */
    private String accid;
    /**
     * appId 由第三方系统提供
     */
    private Long appId;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 过期时间2day
     */
    private final int EXPIRATION = 2 * 24 * 60 * 60;

}
