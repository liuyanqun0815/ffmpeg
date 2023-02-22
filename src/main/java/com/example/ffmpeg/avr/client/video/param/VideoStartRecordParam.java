package com.example.ffmpeg.avr.client.video.param;

import com.example.ffmpeg.avr.client.base.enums.PassageWayEnum;
import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import lombok.Data;

/**
 * 开始录制，录制音视频的客户端参数
 *
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class VideoStartRecordParam {

    /**
     * 通道标识
     */
    private PassageWayEnum passageWay;

    /**
     * sdkappid
     */
    private String appId;
    /**
     * 会话id
     */
    private String sessionId;
    /**
     * 房间号id
     */
    private String roomId;
    /**
     * 混流录制类型(默认值3)：1 只录制音频；2 只录制视频；3 录制音视频
     */
    private int streamType;
    /**
     * 背景画布颜色，格式为RGB，如红色为"#FF0000"
     * 默认黑色，0x000000
     */
    private int backgroundColor;

    /**
     * 音视频加解密类型，默认不加密
     * 0：不加密
     * 1:  商密 (RSA, AES)
     * 2: 国密 （SM2 + SM4）
     */
    private int videoEncryptionType;
    /**
     * 加解密秘钥
     */
    private String sessionkey;
    /**
     * 本地录制观众身份
     */
    private String audienceUserid;
    /**
     * 本地录制观众身份签名
     */
    private String audienceUserSig;
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 布局参数
     */
    private MixstreamLayout mixstreamLayout;

    public ResultDTO<Void> checkParam() {
        if (passageWay == null) {
            return ResultDTO.fail("通道标识不能为空");
        }
        if(passageWay == PassageWayEnum.TRTC_PRI || passageWay == PassageWayEnum.TRTC_PUB){
            if(audienceUserid == null || audienceUserid.length() == 0){
                return ResultDTO.fail("本地录制观众用户ID不能为空");
            }
            if(audienceUserSig == null || audienceUserSig.length() == 0) {
                return ResultDTO.fail("本地录制观众用户签名不能为空");
            }
            if (sessionkey == null || sessionkey.length() == 0) {
                return ResultDTO.fail("加解密秘钥不能为空");
            }
            if (videoEncryptionType < 0 || videoEncryptionType > 2) {
                return ResultDTO.fail("视频加解密类型格式有误");
            }
        }
        if(tenantId == null || tenantId.length() == 0){
            return ResultDTO.fail("租户ID不能为空");
        }
        if (appId == null) {
            return ResultDTO.fail("sdkappid不能为空");
        }
        if (sessionId == null) {
            return ResultDTO.fail("会话id不能为空");
        }
        if (roomId == null) {
            return ResultDTO.fail("房间号id不能为空");
        }
        if (streamType < 1 || streamType > 3) {
            return ResultDTO.fail("混流录制类型只能为1、2、3");
        }
        if (tenantId == null) {
            return ResultDTO.fail("租户ID不能为空");
        }
        if (mixstreamLayout != null) {
            return mixstreamLayout.checkParam();
        }
        return ResultDTO.success(null);
    }


    @Data
   public static class MixstreamLayout {

        /**
         * 用户唯一标识 userId
         */
        private String accid;

        /**
         * 层级，取值范围[1, 15]，数字越大，层级越高
         */
        private int layer;
        /**
         * 画布上该画面宽度的相对值，取值范围 [0, 1920]，与Left相加不应超过画布的宽
         */
        private long width;
        /**
         * 画布上该画面高度的相对值，取值范围 [0, 1920]，与Top相加不应超过画布的高
         */
        private long height;
        /**
         * 画布上该画面左上角的 x 轴坐标，取值范围 [0, 1920]，不能超过画布的宽
         */
        private long left;
        /**
         * 画布上该画面左上角的 y 轴坐标，取值范围 [0, 1920]，不能超过画布的高。
         */
        private long top;
        /**
         * 水印类型，取值范围 [1, 3]，1：图片水印；2：文字水印；3时间戳水印----腾讯本地录制
         */
        private long waterType;
        /**
         * 水印宽度
         */
        private long waterWidth;
        /**
         * 水印高度
         */
        private long waterHeight;
        /**
         * 水印左上角的 x 轴坐标，取值范围 [0, 1920]，不能超过画布的宽
         */
        private long waterleft;
        /**
         * 水印左上角的 y 轴坐标，取值范围 [0, 1920]，不能超过画布的高。
         */
        private long waterTop;
        /**
         * 文字大小
         */
        private int fontSize;

        /**
         * 水印文字内容
         */
        private String waterContent;

        public ResultDTO<Void> checkParam() {
            if (accid == null) {
                return ResultDTO.fail("用户唯一标识不能为空");
            }
            if (layer < 1 || layer > 15) {
                return ResultDTO.fail("层级只能为1-15");
            }
            if (width < 0 || width > 1920) {
                return ResultDTO.fail("画布上该画面宽度的相对值只能为0-1920");
            }
            if (height < 0 || height > 1920) {
                return ResultDTO.fail("画布上该画面高度的相对值只能为0-1920");
            }
            if (left < 0 || left > 1920) {
                return ResultDTO.fail("画布上该画面左上角的 x 轴坐标只能为0-1920");
            }
            if (top < 0 || top > 1920) {
                return ResultDTO.fail("画布上该画面左上角的 y 轴坐标只能为0-1920");
            }
            if (waterType < 1 || waterType > 3) {
                return ResultDTO.fail("水印类型只能为1-3");
            }
            if (waterWidth < 0 || waterWidth > 1920) {
                return ResultDTO.fail("水印宽度只能为0-1920");
            }
            if (waterHeight < 0 || waterHeight > 1920) {
                return ResultDTO.fail("水印高度只能为0-1920");
            }
            if (waterleft < 0 || waterleft > 1920) {
                return ResultDTO.fail("水印左上角的 x 轴坐标只能为0-1920");
            }
            if (waterTop < 0 || waterTop > 1920) {
                return ResultDTO.fail("水印左上角的 y 轴坐标只能为0-1920");
            }
            if (fontSize < 0 || fontSize > 1920) {
                return ResultDTO.fail("文字大小只能为0-1920");
            }
            if (waterContent == null) {
                return ResultDTO.fail("水印文字内容不能为空");
            }
            return ResultDTO.success(null);
        }
    }

}
