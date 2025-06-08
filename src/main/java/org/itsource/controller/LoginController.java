
package org.itsource.controller;


import org.itsource.domain.Employee;
import org.itsource.domain.Login;
import org.itsource.service.IDepartmentService;
import org.itsource.until.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//标注我们是控制层
@RequestMapping("/login")//前端
public class LoginController {
    @Autowired
    private IDepartmentService departmentService;
    @PostMapping
    public AjaxResult checkPassword(@RequestBody Login login){
        if(login==null){
            return new AjaxResult(false,"账号密码不能为空");
        }
        AjaxResult ajaxResult= departmentService.checkPassword(login);
        if(ajaxResult.getSuccess()){
            return new AjaxResult(true,"用户名密码正确！");
        }
        return new AjaxResult(false,"账号密码有误！");
    }
}

