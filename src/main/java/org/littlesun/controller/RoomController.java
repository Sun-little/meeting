package org.littlesun.controller;

import org.littlesun.bean.Department;
import org.littlesun.bean.Employee;
import org.littlesun.bean.Meeting;
import org.littlesun.bean.MeetingRoom;
import org.littlesun.service.DepService;
import org.littlesun.service.MeetingService;
import org.littlesun.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    DepService depService;

    @Autowired
    MeetingService meetingService;


    /*会议室模块*/
    @GetMapping ("/addmeetingroom")
    public String addmeetingroom() {
        return "addmeetingroom";
    }

    @GetMapping("/meetingrooms")
    public String meetingrooms(Model model) {
        model.addAttribute("ms", roomService.getAllMeetingRooms());
        return "meetingrooms";
    }

    @PostMapping("/addMeetingRoom")
    public String addMeetingRoom(MeetingRoom room) {
        int result = roomService.addRoom(room);
        if (result == 1) {
            return "redirect:/meetingrooms";
        }
        return "addmeetingroom";
    }

    @GetMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model) {
        model.addAttribute("mr", roomService.getRoomById(roomid));
        return "roomdetails";
    }

    @PostMapping("/updateRoom")
    public String updateRoom(MeetingRoom meetingRoom) {
        int result = roomService.updateRoom(meetingRoom);
        if (result == 1) {
            return "redirect:/meetingrooms";
        }
        return "roomdetails";
    }


    /*预定会议模块*/
    @GetMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        model.addAttribute("rs", roomService.getAllMeetingRooms());
        return "bookmeeting";
    }

    @GetMapping("/allDeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        return depService.getAllDepsWithEmps();
    }

    /*添加预定会议*/
    @PostMapping("/addMeeting")
    public String addMeeting(Meeting meeting, Integer[] selEmpIds, HttpSession session) {
        meeting.setReservationistid(((Employee) session.getAttribute("loginUser")).getEmployeeid());
        meeting.setReservationtime(new Date());
        boolean result = meetingService.addMeeting(meeting, selEmpIds);
        if (result) {
            return "redirect:/searchmeetings";
        }
        return "bookmeeting";
    }

    @GetMapping("/searchmeetings")
    public String searchMeetings(@RequestParam(defaultValue = "") String meetingname, @RequestParam(defaultValue = "") String roomname, @RequestParam(defaultValue = "") String employeename, Date startReser, Date endReser, Date meetingStart, Date meetingEnd, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer count, Model model) {

        model.addAttribute("data", meetingService.getMeetingByPage(meetingname, roomname, employeename, startReser, endReser, meetingStart, meetingEnd, page, count));

        /*总页数的数据*/
        int total = meetingService.getTotal(meetingname, roomname, employeename, startReser, endReser, meetingStart, meetingEnd);
        model.addAttribute("total", total);
        /*第几页*/
        model.addAttribute("page", page);
        /*分多少页*/
        model.addAttribute("pageCount", total % count == 0 ? total / count : total / count + 1);
        model.addAttribute("meetingname", meetingname);
        model.addAttribute("roomname", roomname);
        model.addAttribute("employeename", employeename);
        model.addAttribute("count", count);
        return "searchmeetings";
    }
}
