package org.littlesun.controller;

import org.littlesun.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/*路径访问 Controller*/
@Controller
public class PagePathController {
    /*@GetMapping("/{path}")
    public String path(@PathVariable String path){
        System.out.println("前端访问的path==>"+ path);
        *//*@PathVariable:url地址映射占位符，前端路径访问什么就返回什么*//*
        return path;
    }

    @ModelAttribute("e")
    public Employee loginUser(HttpServletRequest req){
        return ((Employee) req.getSession().getAttribute("loginUser"));
    }*/

}
