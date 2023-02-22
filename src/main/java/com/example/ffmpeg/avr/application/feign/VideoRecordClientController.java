package com.example.ffmpeg.avr.application.feign;

import com.example.ffmpeg.avr.client.base.result.ResultDTO;
import com.example.ffmpeg.avr.client.video.client.VideoRecordClient;
import com.example.ffmpeg.avr.client.video.param.VideoEndRecordParam;
import com.example.ffmpeg.avr.client.video.param.VideoStartRecordParam;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
public class VideoRecordClientController implements VideoRecordClient {



    @Override
    public ResultDTO<Void> startRecord(VideoStartRecordParam startRecord) {
        ResultDTO<Void> checkParam = startRecord.checkParam();
        if (!checkParam.isOk()){
            return checkParam;
        }


        return null;
    }

    @Override
    public ResultDTO<Void> stopRecord(VideoEndRecordParam endRecord) {
        return null;
    }
}
