//package com.example.ffmpeg.avr.client.video.param;
//
//import lombok.Data;
//
///**
// * @author liuyanqun
// * @version TODO
// * @see
// */
//public class VideoRecordParam {
//
//    /**
//     * sdkappid
//     */
//    private String appId;
//    /**
//     * 会话id
//     */
//    private String sessionId;
//    /**
//     * 房间号id
//     */
//    private String roomId;
//    /**
//     * 流id
//     */
//    private String streamId;
//    /**
//     * 混流录制类型(默认值3)：1 只录制音频；2 只录制视频；3 录制音视频
//     */
//    private int streamType;
//    /**
//     * 背景画布颜色，格式为RGB，如红色为"#FF0000"
//     */
//    private int backgroundColor;
//
//    /**
//     * 布局参数
//     */
//    private MixstreamLayout mixstreamLayout;
//
//
//}
//@Data
//class MixstreamLayout {
//
//    /**
//     * 用户唯一标识 userId
//     */
//    private String accid;
//
//    /**
//     * 层级，取值范围[1, 15]，数字越大，层级越高
//     */
//    private int layer;
//    /**
//     * 画布上该画面宽度的相对值，取值范围 [0, 1920]，与Left相加不应超过画布的宽
//     */
//    private long width;
//    /**
//     * 画布上该画面高度的相对值，取值范围 [0, 1920]，与Top相加不应超过画布的高
//     */
//    private long height;
//    /**
//     * 画布上该画面左上角的 x 轴坐标，取值范围 [0, 1920]，不能超过画布的宽
//     */
//    private long left;
//    /**
//     * 画布上该画面左上角的 y 轴坐标，取值范围 [0, 1920]，不能超过画布的高。
//     */
//    private long top;
//    /**
//     * 水印类型，取值范围 [1, 3]，1：图片水印；2：文字水印；3时间戳水印----腾讯本地录制
//     */
//    private long waterType;
//    /**
//     * 水印宽度
//     */
//    private long waterWidth;
//    /**
//     * 水印高度
//     */
//    private long waterHeight;
//    /**
//     * 水印左上角的 x 轴坐标，取值范围 [0, 1920]，不能超过画布的宽
//     */
//    private long waterleft;
//    /**
//     * 水印左上角的 y 轴坐标，取值范围 [0, 1920]，不能超过画布的高。
//     */
//    private long waterTop;
//    /**
//     * 文字大小
//     */
//    private int fontSize;
//
//    /**
//     * 水印文字内容
//     */
//    private String waterContent;
//}