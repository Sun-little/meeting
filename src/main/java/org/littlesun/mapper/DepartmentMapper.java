package org.littlesun.mapper;

import org.littlesun.bean.Department;
import org.littlesun.service.DepService;

import java.util.List;

public interface DepartmentMapper {
    /*删除操作*/
    int deleteByPrimaryKey(Integer departmentid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer departmentid);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /*查询所有部门*/
    List<DepService> getAllDeps();

    /*添加部门*/
    Department getDepByName(String depName);

    /*一对多查询  部门对员工*/
    List<Department> getAllDepsWithEmps();
}