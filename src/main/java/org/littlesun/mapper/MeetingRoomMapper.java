package org.littlesun.mapper;

import org.littlesun.bean.MeetingRoom;

import java.util.List;

public interface MeetingRoomMapper {
    int deleteByPrimaryKey(Integer roomid);

    int insert(MeetingRoom record);

    int insertSelective(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(MeetingRoom record);

    int updateByPrimaryKey(MeetingRoom record);

    /*查询所有会议室*/
    List<MeetingRoom> getAllMeetingRooms();
}