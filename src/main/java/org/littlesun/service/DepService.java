package org.littlesun.service;

import org.littlesun.bean.Department;
import org.littlesun.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<DepService> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    /*添加部门操作*/
    public String addDep(String depName) {
        Department dep = departmentMapper.getDepByName(depName);
        if (dep != null) {
            return "部门已存在，添加失败(；′⌒`)!";
        }
        Department record = new Department();
        record.setDepartmentname(depName);
        departmentMapper.insertSelective(record);
        return null;
    }


    public void deleteById(Integer id) {
        departmentMapper.deleteByPrimaryKey(id);
    }

    public int updateDep(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    public List<Department> getAllDepsWithEmps() {
        return departmentMapper.getAllDepsWithEmps();
    }
}
