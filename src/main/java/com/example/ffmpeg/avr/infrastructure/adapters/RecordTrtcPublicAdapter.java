package com.example.ffmpeg.avr.infrastructure.adapters;

import com.example.ffmpeg.avr.domain.record.repositories.RecordThirdPartySysAdapter;
import com.example.ffmpeg.avr.domain.record.repositories.dto.*;
import com.tencentcloudapi.trtc.v20190722.TrtcClient;
import com.tencentcloudapi.trtc.v20190722.models.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 腾讯云端录制适配器
 *
 * @author liuyanqun
 * @version TODO
 * @see
 */
@Slf4j
public class RecordTrtcPublicAdapter extends AbstractRecordThirdSysAdapter implements RecordThirdPartySysAdapter {

    @Override
    public RecordResult startRecord(VideoStartRecordDTO startRecord)throws Exception {
        TrtcClient trtcClient = this.CloudRecord(startRecord);
        CreateCloudRecordingRequest request = new CreateCloudRecordingRequest();
        //TODO 开始录制参数封装
        CreateCloudRecordingResponse resp = trtcClient.CreateCloudRecording(request);
        log.info("开始云端录制，请求参数：{}，resp:{}",request,resp.toString());
        RecordResult result = new RecordResult();
        result.setTaskId(resp.getTaskId());
        return result;
    }

    @Override
    public void modifyStream(VideoModifyRecordDTO modifyStream) throws Exception {
        TrtcClient trtcClient = this.CloudRecord(modifyStream);
        ModifyCloudRecordingRequest modify = new ModifyCloudRecordingRequest();
        modify.setTaskId(modifyStream.getTaskId());
        modify.setSdkAppId(modifyStream.getTrtcProperties().getSdkAppId());
        //TODO 布局参数设置
        modify.setMixLayoutParams(null);
        ModifyCloudRecordingResponse response = trtcClient.ModifyCloudRecording(modify);
        log.info("更新云端录制 taskId:{} resp:{}", modify.getTaskId(), response.toString());
    }

    @Override
    public void endStream(VideoEndRecordDTO endRecord) throws Exception {
        TrtcClient trtcClient = this.CloudRecord(endRecord);
        //结束云端录制
        DeleteCloudRecordingRequest delete = new DeleteCloudRecordingRequest();
        delete.setSdkAppId(endRecord.getTrtcProperties().getSdkAppId());
        delete.setTaskId(endRecord.getTaskId());
        DeleteCloudRecordingResponse response = trtcClient.DeleteCloudRecording(delete);
        log.info("结束云端录制 ,taskid:{},resp:{}", endRecord.getTaskId(), response.toString());
    }

    @Override
    public void monitorRecordStatus(VideoRecordStatusDTO recordStatus) throws Exception {
        TrtcClient trtcClient = this.CloudRecord(recordStatus);
        //查询云端录制状态
        DescribeCloudRecordingRequest query = new DescribeCloudRecordingRequest();
        query.setSdkAppId(recordStatus.getTrtcProperties().getSdkAppId());
        query.setTaskId(recordStatus.getTaskId());
        DescribeCloudRecordingResponse resp = trtcClient.DescribeCloudRecording(query);
        log.info("查询云端录制状态 ,taskid:{},resp:{}", recordStatus.getTaskId(), resp.toString());
    }

    @Override
    public void removeUser(RemoveUserDTO removeUser) throws Exception {
        TrtcClient trtcClient = this.CloudRecord(removeUser);
        //移除用户
        RemoveUserRequest removeUserRequest = new RemoveUserRequest();
        removeUserRequest.setRoomId(Long.parseLong(removeUser.getRoomId()));
        removeUserRequest.setSdkAppId(removeUser.getTrtcProperties().getSdkAppId());
        List<String> userIds = removeUser.getAccidList();
        removeUserRequest.setUserIds(userIds.toArray(new String[userIds.size()]));
        RemoveUserResponse removeUserResponse = trtcClient.RemoveUser(removeUserRequest);
        log.info("移除用户,roomId:{},resp:{}", removeUser.getRoomId(), removeUserResponse);
    }

    @Override
    public void dismissRoom(DissmissRoomDTO dismissRoom) throws Exception {
        TrtcClient trtcClient = this.CloudRecord(dismissRoom);
        //解散房间
        DismissRoomRequest dismissRoomRequest = new DismissRoomRequest();
        dismissRoomRequest.setRoomId(Long.parseLong(dismissRoom.getRoomId()));
        dismissRoomRequest.setSdkAppId(dismissRoom.getTrtcProperties().getSdkAppId());
        DismissRoomResponse dismissRoomResponse = trtcClient.DismissRoom(dismissRoomRequest);
        log.info("解散房间,roomId:{},resp:{}", dismissRoom.getRoomId(), dismissRoomResponse);
    }

}
