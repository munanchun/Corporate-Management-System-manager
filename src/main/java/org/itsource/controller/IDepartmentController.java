package org.itsource.controller;

import org.itsource.domain.Department;
import org.itsource.mapper.IDepartmentMapper;
import org.itsource.service.IDepartmentService;
import org.itsource.until.AjaxResult;
import org.itsource.until.PageList;
import org.itsource.until.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController//标注我们是控制层
@RequestMapping("/dept")//前端发送请求的 接口地址;类在外面的主地址
public class IDepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @GetMapping
    public List<Department>queryAll(){
        return  departmentService.selectAll();
    }
    @PostMapping
    public PageList<Department> queryByPage(@RequestBody Query query){ //如果接收一个对象 要写是注解
        System.out.println(query);
        return departmentService.queryByPage(query);

    }
    @DeleteMapping("/{id}")
    public AjaxResult deleteById(@PathVariable Long id) {
        try{
            departmentService.delecteById(id);
            return new AjaxResult(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
    @PatchMapping
    public AjaxResult batchRemove(@RequestBody List<Long>ids){
        try{
            departmentService.batchDelete(ids);
            return new AjaxResult(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new AjaxResult(false,"删除失败");
        }
    }
    @PutMapping
    public AjaxResult addOrUpdate(@RequestBody Department department){
        try{
            if(department.getId()==null){
                departmentService.insert(department);
            }else {
                departmentService.update(department);
            }
        }catch (Exception e){
            return  new AjaxResult(false,"操作失败，请重试！");

        }
        return new AjaxResult(true,"操作成功！");
    }
    }

