package com.example.ffmpeg.controller;

import com.example.ffmpeg.utils.FfmpegUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.schild.jave.info.MultimediaInfo;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@RestController
@RequestMapping("test")
public class VideoController {

    @GetMapping("videoInfo")
    public Object getVideoInfo(String url){
        MultimediaInfo multimediaInfo = FfmpegUtil.getMultimediaInfoFromUrl(url);
        return multimediaInfo;
    }

    @GetMapping("getVideomediaInfo")
    public Object getVideomediaInfo(String url){
        MultimediaInfo multimediaInfo = FfmpegUtil.getMultimediaInfo(url);
        return multimediaInfo;
    }
    @GetMapping("getFirstStreamInfo")
    public void getFirstStreamInfo(String url){
        FfmpegUtil.getTargetThumbnail(url,"E:\\ffmpeg\\first.jpg");
    }
    @GetMapping("addWaterMark")
    public void addWaterMark(String url){
        FfmpegUtil.addSubtitle(url, "E:\\ffmpeg\\f1.mp4","E:\\ffmpeg\\word.srt");

    }

}
