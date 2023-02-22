package com.example.ffmpeg.avr.client.base.enums;

import lombok.Getter;

/**
 * 通道枚举
 *
 * @author liuyanqun
 * @description: TODO
 * @date 2023/2/20 14:07
 */
@Getter
public enum PassageWayEnum {

    TRTC_PRI(11, "trtc私有"),
    TRTC_PUB(12, "trtc共有"),
    TRTC_CLOUD(13, "腾讯共有云端录制"),
    ZEGO_PRI(21, "即构私有");

    private int code;

    private String desc;

    PassageWayEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PassageWayEnum getEnumByCode(int code) {
        for (PassageWayEnum passageWayEnum : PassageWayEnum.values()) {
            if (passageWayEnum.getCode() == code) {
                return passageWayEnum;
            }
        }
        throw new IllegalArgumentException("没有找到对应的配置");
    }
}
