package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.domain.record.repositories.RecordThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.record.repositories.dto.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 即构录制相关接口
 *
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Slf4j
public class RecordZegoPrivateAdapter extends AbstractRecordThirdSysAdapter implements RecordThirdPartySysAdapter {
    /**
     * 即构接口返回状态码，成功200
     */
    private final static int SUCCESS_CODE = 200;
    //TODO 更换http工具
    private static RestTemplate restTemplate;

    {
        //TODO 初始化restTemplate
        restTemplate = new RestTemplate();
    }

    @Override
    public RecordResult startRecord(VideoStartRecordDTO startRecord) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("app_id", startRecord.getAppId());
        param.put("room_id", startRecord.getRoomId());
        param.put("record_id", startRecord.getTaskId());
        param.put("user_id", startRecord.getUserId());
        //固定填写0.0.1，后台区分多任务录制版本；不写则房间内同一时间只能存在一个录制任务，即返回的recordID是default
        param.put("version", "0.0.1");
        param.put("record_config", startRecord.getRecordConfig());
        param.put("mix_stream_layout", startRecord.getMixStreamLayout());
        String recordAddress = startRecord.getZegoRecordAddress() + "/recorder/start";
        ResponseEntity<ZegoResult> response = restTemplate.postForEntity(recordAddress, param, ZegoResult.class);
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            ZegoResult body = response.getBody();
            log.info("即构开始录制，param:{},resp:{}", param, body);
            if (body.getCode() != SUCCESS_CODE) {
                throw new RuntimeException("即构开始录制失败");
            }
            RecordResult result = new RecordResult();
            result.setRecordSvrHost(body.getRecord_svr_host());
            result.setTaskId(body.getRecord_id());
            result.setUrl(body.getUrl());
            return result;
        } else {
            log.error("即构开始录制失败,param:{},resp:{}", param, response);
            throw new RuntimeException("即构开始录制失败");
        }
    }

    @Override
    public void modifyStream(VideoModifyRecordDTO modifyStream) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("app_id", modifyStream.getAppId());
        param.put("room_id", modifyStream.getRoomId());
        param.put("record_id", modifyStream.getTaskId());
        param.put("user_id", modifyStream.getUserId());
        param.put("mix_stream_layout", modifyStream.getMixStreamLayout());
        String recordAddress = modifyStream.getZegoRecordAddress() + "/recorder/update";
        ResponseEntity<ZegoResult> response = restTemplate.postForEntity(recordAddress, param, ZegoResult.class);
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            ZegoResult body = response.getBody();
            log.info("即构更新录制，param:{},resp:{}", param, body);
            if (body.getCode() != SUCCESS_CODE) {
                throw new RuntimeException("即构更新录制失败");
            }
        } else {
            log.error("即构更新录制失败,param:{},resp:{}", param, response);
            throw new RuntimeException("即构录制修改流失败");
        }
    }

    @Override
    public void endStream(VideoEndRecordDTO endRecord) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("app_id", endRecord.getAppId());
        param.put("room_id", endRecord.getRoomId());
        param.put("record_id", endRecord.getTaskId());
        param.put("user_id", endRecord.getUserId());
        String recordAddress = endRecord.getZegoRecordAddress() + "/recorder/stop";
        //TODO 请求头设置 Content-Type: application/json
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
//        HttpEntity<Map> httpEntity=new HttpEntity<>(param,headers);
        ResponseEntity<ZegoResult> response = restTemplate.postForEntity(recordAddress, param, ZegoResult.class);
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            ZegoResult body = response.getBody();
            log.info("即构结束录制，param:{},resp:{}", param, body);
            if (body.getCode() != SUCCESS_CODE) {
                throw new RuntimeException("即构录制结束失败");
            }
        } else {
            log.error("即构结束录制失败,param:{},resp:{}", param, response);
            throw new RuntimeException("即构结束录制失败");
        }
    }

    @Override
    public void monitorRecordStatus(VideoRecordStatusDTO recordStatus) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("app_id", recordStatus.getAppId());
        param.put("room_id", recordStatus.getRoomId());
        param.put("record_id", recordStatus.getTaskId());
        param.put("user_id", recordStatus.getUserId());
        String recordAddress = recordStatus.getZegoRecordAddress() + "/recorder/status";
        ResponseEntity<ZegoResult> response = restTemplate.postForEntity(recordAddress, param, ZegoResult.class);
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            ZegoResult body = response.getBody();
            log.info("即构监控录制状态，param:{},resp:{}", param, body);
            if (body.getCode() != SUCCESS_CODE) {
                throw new RuntimeException("即构监控录制状态失败");
            }
        } else {
            log.error("即构监控状态失败,param:{},resp:{}", param, response);
            throw new RuntimeException("即构监控录制状态失败");
        }
    }

    @Override
    public void removeUser(RemoveUserDTO removeUser) throws Exception {
        //TODO 移除用户，发送信令
    }

    @Override
    public void dismissRoom(DissmissRoomDTO dismissRoom) throws Exception {
        //TODO 解散房间，发送信令
    }
}

@Data
class ZegoResult {
    /**
     * 即构返回编码，200成功，其他失败
     */
    private int code;
    /**
     * 即构返回信息
     */
    private String message;
    /**
     * 开始录制时间
     */
    private long start_time;
    /**
     * 录制文件url
     */
    private String url;
    /**
     * 录制任务ID，在停止录制和更新时需要的参数不同
     */
    private String record_id;
    /**
     * 开始录制响应携带本机地址，负载下实际录制机器
     */
    private String record_svr_host;
}