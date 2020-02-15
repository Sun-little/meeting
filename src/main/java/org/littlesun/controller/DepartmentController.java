package org.littlesun.controller;


import org.littlesun.bean.Department;
import org.littlesun.bean.Employee;
import org.littlesun.bean.RespBean;
import org.littlesun.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DepartmentController {
    @Autowired
    DepService depService;
    /*查询所有 部门信息*/
    @GetMapping("/departments")
    public String departments(Model model){
        model.addAttribute("deps",depService.getAllDeps());
        return "departments";
    }

    /*添加部门*/
    @PostMapping("/dep")
    public String addDep(String depName, Model model) {
        String msg = depService.addDep(depName);
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        model.addAttribute("deps", depService.getAllDeps());
        return "departments";
    }

    @GetMapping("/dep")
    public String deleteById(Integer id, Model model) {
        depService.deleteById(id);
        model.addAttribute("deps", depService.getAllDeps());
        return "departments";
    }

    /*修改操作*/
    @PostMapping("/updateDep")
    @ResponseBody
    public RespBean updateDep(Department department){
       int result= depService.updateDep(department);
       if (result == 1){
           return RespBean.ok("修改成功o(*￣▽￣*)ブ~ ~");
       }
           return RespBean.error("修改失败(；′⌒`)~ ~");
    }

    @ModelAttribute("e")
    public Employee loginUser(HttpServletRequest req){
        return (Employee) req.getSession().getAttribute("loginUser");
    }
}
