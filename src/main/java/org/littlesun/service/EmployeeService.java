package org.littlesun.service;

import org.littlesun.bean.Employee;
import org.littlesun.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee dologin(String username, String password) {
        return employeeMapper.dologin(username,password);
    }

    public int addEmp(Employee employee) {
        employee.setStatus("0");
        employee.setRole("2");
        return employeeMapper.insertSelective(employee);
    }

    public List<Employee> getEmpsByStatus(int status) {
        return employeeMapper.getEmpsByStatus(status);
    }

    /*员工搜索*/
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /*员工搜素模块*/
    public List<Employee> searchEmp(String employeename, String username, String status, Integer page, Integer count) {
        return employeeMapper.searchEmp(employeename,username,status,(page -1)*count,count);
    }

    public Long getEmpsCount(String employeename, String username, String status) {
        return employeeMapper.getEmpsCount(employeename,username,status);
    }


}
