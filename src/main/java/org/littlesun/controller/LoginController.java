package org.littlesun.controller;

import org.littlesun.bean.Employee;
import org.littlesun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpServletRequest req){
      Employee employee= employeeService.dologin(username,password);
      if (employee != null){
          if ("1".equals(employee.getStatus())) {
              req.getSession().setAttribute("loginUser",employee);
              /*redirect:重定向*/
              return "redirect:/notifications";
          }else if ("0".equals(employee.getStatus())){
              model.addAttribute("msg","账户未审批，请及时联系管理员o(*￣▽￣*)ブ~ ~");
          }else if("2".equals(employee.getStatus())){
              model.addAttribute("msg","审批未通过，请联系管理员处理！！");
          }else if("3".equals(employee.getStatus())){
              model.addAttribute("msg","账户已被冻结，请联系管理员确认情况(；′⌒`)~ ~");
          }
      }else {
          model.addAttribute("msg","用户名或者密码错误，登录失败，请重新登录 (；′⌒`)~ ~");
      }
        return "login";
    }
}
