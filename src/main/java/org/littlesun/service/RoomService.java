package org.littlesun.service;

import org.littlesun.bean.MeetingRoom;
import org.littlesun.mapper.MeetingRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;
    public int addRoom(MeetingRoom room) {
        return meetingRoomMapper.insertSelective(room);
    }

    /*查询所有会议室*/
    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRoomMapper.getAllMeetingRooms();
    }

    /*查询会议室信息并回显*/
    public MeetingRoom getRoomById(Integer roomid) {
        return meetingRoomMapper.selectByPrimaryKey(roomid);
    }

    /*修改会议室信息*/
    public int updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateByPrimaryKeySelective(meetingRoom);
    }
}
