package com.example.ffmpeg.avr.domain.record.repositories;

import com.example.ffmpeg.avr.domain.record.repositories.dto.*;

/**
 * 录制相关接口
 *
 * @author liuyanqun
 * @see
 */
public interface RecordThirdPartySysAdapter {

    /**
     * 开始录制
     *
     * @param startRecord
     * @throws Exception
     */
    //TODO 请求参数更新
    RecordResult startRecord(VideoStartRecordDTO startRecord)throws Exception;
    /**
     * 更新录制
     * @param modifyStream
     * @throws Exception
     */
    //TODO  请求参数更新
    void modifyStream(VideoModifyRecordDTO modifyStream)throws Exception;

    /**
     * 结束录制
     *
     * @param endRecord 用户参数
     * @throws Exception
     */
    void endStream(VideoEndRecordDTO endRecord)throws Exception ;

    /**
     * 监控录制状态
     * @param recordStatus
     * @throws Exception
     */
    void monitorRecordStatus(VideoRecordStatusDTO recordStatus)throws Exception;

    /**
     *  移除用户
     * @param removeUser
     * @throws Exception
     */
    void removeUser(RemoveUserDTO removeUser) throws Exception ;

    /**
     * 解散房间
     *
     * @param dismissRoom
     * @throws Exception
     */
    void dismissRoom(DissmissRoomDTO dismissRoom) throws Exception ;
}
