package org.littlesun.controller;

import org.littlesun.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserCenterController {

    @GetMapping("/notifications")
    public String notifications(Model model, HttpServletRequest req){
        model.addAttribute("e", ((Employee) req.getSession().getAttribute("loginUser")));
        return "notifications";
    }
}
