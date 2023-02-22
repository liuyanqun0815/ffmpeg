package com.example.ffmpeg.avr.domain.record.repositories.dto;

import lombok.Data;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Data
public class RecordResult {
    /**
     * 腾讯云端录制和机构录制通用
     */
    private String taskId;
    /**
     * 机构录制文件url
     */
    private String url;
    /**
     * 机构实际录制机器
     */
    private String recordSvrHost;
}
