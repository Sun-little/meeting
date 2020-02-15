package org.littlesun.mapper;

import org.littlesun.bean.Meetingparticipants;

public interface MeetingparticipantsMapper {
    int insert(Meetingparticipants record);

    int insertSelective(Meetingparticipants record);
}