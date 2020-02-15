package org.littlesun.controller;

import org.littlesun.bean.Employee;
import org.littlesun.service.DepService;
import org.littlesun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*员工注册Controller*/
@Controller
public class EmployeeController {
    @Autowired  /*对象注入注解*/
    DepService depService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/register")
    public String register(Model model){
        List<DepService> allDeps = depService.getAllDeps();
        model.addAttribute("deps",allDeps);
        return "register";
    }

    /*注册审批 Controller*/
    @GetMapping("/approveaccount")
    public String approveaccount(Model model){
        model.addAttribute("emps",employeeService.getEmpsByStatus(0));
        return "approveaccount";
    }


    /*员工注册操作*/
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
      int result= employeeService.addEmp(employee);
      if (result == 1){
          /*重定向*/
          return "redirect:/approveaccount";
      }
        return "register";
    }

    /*员工审批*/
    @GetMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return "redirect:/approveaccount";
    }



    //员工搜索
    /*
    *       @RequestParam：将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
    * 语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)

            value：参数名

            required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。

            defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
    * */
    @GetMapping("/searchemployees")
    public String searchemployees(@RequestParam(defaultValue = "") String employeename, @RequestParam(defaultValue = "")String username, @RequestParam(defaultValue = "1")String status,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "5")Integer count,Model model){
        /*查询的信息*/
       List<Employee> emps = employeeService.searchEmp(employeename,username,status,page,count);

       //分页操作
       /*数据的总记录数*/
       Long total = employeeService.getEmpsCount(employeename,username,status);
       /*pageCount:总数 一页分几条数据*/
       Long pageCount= total % count ==0 ? total / count:total / + 1;
       /*将数据添加 model 数据模型中*/
       model.addAttribute("emps",emps);
       /*总记录数*/
       model.addAttribute("total",total);
       /*分页数据一页多少条数据*/
       model.addAttribute("pageCount",pageCount);
       /*当前页数*/
       model.addAttribute("page",page);
       model.addAttribute("employeename",employeename);
       model.addAttribute("username",username);
       model.addAttribute("count",count);
       model.addAttribute("status",status);
        return "searchemployees";
    }

    @ModelAttribute("e")
    public Employee loginUser(HttpServletRequest req){
        return (Employee) req.getSession().getAttribute("loginUser");
    }
}
