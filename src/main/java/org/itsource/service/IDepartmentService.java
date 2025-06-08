package org.itsource.service;
import  org.itsource.domain.Department;
import org.itsource.domain.Login;
import org.itsource.until.AjaxResult;
import org.itsource.until.PageList;
import org.itsource.until.Query;

import java.util.List;

public interface IDepartmentService {
    List<Department> selectAll();
    Department selectByID(Long id);
    void insert (Department department);
    void update(Department department);
    void delecteById(Long id);
    //分页查询+统计条数
    PageList<Department> queryByPage(Query query);

    void batchDelete(List<Long> ids);

    AjaxResult checkPassword(Login login);
}
