package org.itsource.service.impl;

import org.itsource.domain.Department;
import org.itsource.domain.Employee;
import org.itsource.domain.Login;
import org.itsource.mapper.IDepartmentMapper;
import org.itsource.service.IDepartmentService;
import org.itsource.until.AjaxResult;
import org.itsource.until.MD5Utils;
import org.itsource.until.PageList;
import org.itsource.until.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //必须要加 当前类 业务层
public class IDepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentMapper departmentMapper;
    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
    @Override
    public Department selectByID(Long id) {
        return departmentMapper.selectById(id);
    }
    @Override
    public void insert(Department department) {
        departmentMapper.insert(department);
    }
    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public void delecteById(Long id) {
        departmentMapper.deletById(id);
    }

    @Override
    public PageList<Department> queryByPage(Query query) {
        //先创建pagelist对象
        PageList<Department> pageList = new PageList<>();
        //然后分调用mapper 分页查询和统计条数方法 拿到数据后赋值给paperlist对象里面的字段
        List<Department> rows = departmentMapper.selectByPage(query);
        pageList.setRows(rows);
        //查询系统totals赋值
        Integer totals =departmentMapper.count();
        pageList.setTotals(totals);
        return pageList;
    }
    @Override
    public void batchDelete(List<Long> ids) {
        departmentMapper.batchDelete(ids);
    }

    @Override
    public AjaxResult checkPassword(Login login) {
        //1.首先要根据前端传过来的用户去查询数据库里有没有这个用户名
        Employee  employee =   departmentMapper.selectByUsername(login.getUsername());
        //2.如果数据库里面没有这个用户名那就直接返回false给前端
        if (employee==null){
            return new AjaxResult(false,"账号不存在,请联系管理员");
        }
        if (employee.getPassword().equals(MD5Utils.string2MD5(login.getPassword()))){
            return new AjaxResult(true,"登陆成功");
        }
        return new AjaxResult(false,"账号密码有误，请重试！！");
    }
}
