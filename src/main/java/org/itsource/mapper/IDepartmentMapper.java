package org.itsource.mapper;

import org.itsource.domain.Department;
import org.itsource.domain.Employee;
import org.itsource.until.Query;

import java.util.List;

public interface IDepartmentMapper {
    //查询所有数据的方法
    List<Department>selectAll();
    //根据id查询数据
    Department selectById(Long id);
    //新增
    void insert(Department department);
    //修改
    void update(Department department);
    //删除
    void deletById(Long id);

    //分页查询
    List<Department>selectByPage(Query query);
    //统计条数
    Integer count();

    void batchDelete(List<Long> ids);

    Employee selectByUsername(String usernaem);
}
