package com.example.ffmpeg.avr.utils;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
public class RtcRoomUtils {

    /**
     * 生成房间号</p>
     * 规则：时间戳 + 生成随机数（4位）
     * @return
     */
    public static String createRoomId() {
        StringBuffer sb = new StringBuffer();
        sb.append(System.currentTimeMillis()).append((int) (Math.random() * 10000));
        return sb.toString();
    }

}
