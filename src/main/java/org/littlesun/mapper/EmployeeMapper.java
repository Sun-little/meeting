package org.littlesun.mapper;

import org.apache.ibatis.annotations.Param;
import org.littlesun.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee dologin(@Param("username")String username, @Param("password")String password);

    List<Employee> getEmpsByStatus(int status);

    /*分页操作*/
    Long getEmpsCount(@Param("employeename") String employeename, @Param("username") String username, @Param("status") String status);

    /*总数据量*/
    List<Employee> searchEmp(@Param("employeename") String employeename, @Param("username") String username, @Param("status") String status, @Param("start") int start, @Param("count") Integer count);
}