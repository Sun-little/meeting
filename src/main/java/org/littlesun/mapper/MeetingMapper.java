package org.littlesun.mapper;

import org.apache.ibatis.annotations.Param;
import org.littlesun.bean.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingMapper {
    int deleteByPrimaryKey(Integer meetingid);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingid);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);

    /*会议添加*/
    int addParticipant(@Param("mid") Integer meetingid, @Param("ids") Integer[] selEmpIds);

    /*分页总页数 mapper接口*/
    int getTotal(@Param("meetingname") String meetingname, @Param("roomname") String roomname, @Param("employeename") String employeename, @Param("startReser") String startReser, @Param("endReser") String endReser, @Param("meetingStart") String meetingStart, @Param("meetingEnd") String meetingEnd);

    List<Meeting> getMeetingByPage(@Param("meetingname") String meetingname, @Param("roomname") String roomname, @Param("employeename") String employeename, @Param("startReser") String startReser, @Param("endReser") String endReser, @Param("meetingStart") String meetingStart, @Param("meetingEnd") String meetingEnd, @Param("start") int i, @Param("count") Integer count);

    /*搜索会议的分页数据源 mapper接口*/




}