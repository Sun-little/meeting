package org.littlesun.service;

import org.littlesun.bean.Meeting;
import org.littlesun.mapper.MeetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MeetingService {

    /*日期格式 */
  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    MeetingMapper meetingMapper;
    public boolean addMeeting(Meeting meeting, Integer[] selEmpIds) {
      int result = meetingMapper.insertSelective(meeting);
     int result2= meetingMapper.addParticipant(meeting.getMeetingid(),selEmpIds);
        return result ==1 && result2==selEmpIds.length;
    }

    /*搜索会议分页*/
    public List<Meeting> getMeetingByPage(String meetingname, String roomname, String employeename, Date startReser, Date endReser, Date meetingStart, Date meetingEnd, Integer page, Integer count) {

        String startReserStr = "";
        String endReserStr = "";
        String meetingStartStr = "";
        String meetingEndStr = "";
        if (startReser != null) {
            startReserStr = sdf.format(startReser);
        }
        if (endReser != null) {
            endReserStr = sdf.format(endReser);
        }
        if (meetingStart != null) {
            meetingStartStr = sdf.format(meetingStart);
        }
        if (meetingEnd != null) {
            meetingEndStr = sdf.format(meetingEnd);
        }

        return meetingMapper.getMeetingByPage( meetingname,roomname,employeename,startReserStr,endReserStr,meetingStartStr,meetingEndStr,(page - 1)*count,count);
    }

    /*分页总页数*/
    public int getTotal(String meetingname, String roomname, String employeename, Date startReser, Date endReser, Date meetingStart, Date meetingEnd) {

        String startReserStr = "";
        String endReserStr = "";
        String meetingStartStr = "";
        String meetingEndStr = "";
        if (startReser != null) {
            startReserStr = sdf.format(startReser);
        }
        if (endReser != null) {
            endReserStr = sdf.format(endReser);
        }
        if (meetingStart != null) {
            meetingStartStr = sdf.format(meetingStart);
        }
        if (meetingEnd != null) {
            meetingEndStr = sdf.format(meetingEnd);
        }

        return meetingMapper.getTotal(meetingname,roomname,employeename,startReserStr,endReserStr,meetingStartStr,meetingEndStr);
    }
}
