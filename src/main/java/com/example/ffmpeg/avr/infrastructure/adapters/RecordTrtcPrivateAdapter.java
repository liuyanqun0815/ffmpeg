package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.domain.record.repositories.RecordThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.record.repositories.dto.*;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * trtc私有录制第三方录像适配器
 *
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Slf4j
public class RecordTrtcPrivateAdapter extends AbstractRecordThirdSysAdapter implements RecordThirdPartySysAdapter {

    @Override
    public RecordResult startRecord(VideoStartRecordDTO startRecord) throws Exception {

        return null;
    }

    @Override
    public void modifyStream(VideoModifyRecordDTO modifyStream) throws Exception {

    }

    @Override
    public void endStream(VideoEndRecordDTO endRecord) {

    }

    @Override
    public void monitorRecordStatus(VideoRecordStatusDTO recordStatus) throws Exception {

    }

    @Override
    public void removeUser(RemoveUserDTO removeUser) {
        log.info("移除用户 RecordTrtcPrivateAdapter param:{}", removeUser);

        Map<String, Object> requestParams = new HashMap();
        //公共参数
        requestParams.put("RequestId", String.valueOf(System.currentTimeMillis()));
        requestParams.put("AppId", removeUser.getTrtcProperties().getAppId());
        requestParams.put("Uin", removeUser.getTrtcProperties().getIn().getAccountId());
        requestParams.put("Action", "RemoveUser");
        //移除用户参数
        requestParams.put("SdkAppId", removeUser.getTrtcProperties().getSdkAppId());
        requestParams.put("RoomId", removeUser.getRoomId());
        requestParams.put("UserIds", removeUser.getAccidList());
        String query = requestParams.toString();
        log.info("发送到URL的报文为：{}, param:{}", removeUser.getTrtcProperties().getIn().getAddress(), query);
        try {
            URL url = new URL(removeUser.getTrtcProperties().getIn().getAddress());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            try (OutputStream os = connection.getOutputStream()) {
                os.write(query.getBytes(StandardCharsets.UTF_8));
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String lines;
                StringBuilder sbf = new StringBuilder();
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
                    sbf.append(lines);
                }
                log.info("移除用户返回来的报文：" + sbf);
            }
            connection.disconnect();

        } catch (Exception e) {
            log.error("移除用户失败：, e :{}", e);
        }
    }

    @Override
    public void dismissRoom(DissmissRoomDTO dismissRoom) {
        log.info("解散房间 RecordTrtcPrivateAdapter:{}", dismissRoom);
        Map<String, Object> requestParams = new HashMap();
        //公共参数
        requestParams.put("RequestId", String.valueOf(System.currentTimeMillis()));
        requestParams.put("AppId", dismissRoom.getTrtcProperties().getAppId());
        requestParams.put("Uin", dismissRoom.getTrtcProperties().getIn().getAccountId());
        requestParams.put("Action", "RemoveUser");
        //移除用户参数
        requestParams.put("SdkAppId", dismissRoom.getTrtcProperties().getSdkAppId());
        requestParams.put("RoomId", dismissRoom.getRoomId());
        String query = requestParams.toString();
        try {
            URL url = new URL(dismissRoom.getTrtcProperties().getIn().getAddress());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            try (OutputStream os = connection.getOutputStream()) {
                os.write(query.getBytes(StandardCharsets.UTF_8));
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String lines;
                StringBuilder sbf = new StringBuilder();
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
                    sbf.append(lines);
                }
                log.info("解散房间返回来的报文：" + sbf);
            }
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
