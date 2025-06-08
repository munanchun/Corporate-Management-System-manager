package org.itsource.until;

import lombok.Data;

@Data
public class AjaxResult {//给前端开发人员判断我们后端成功与否
    //给前端判断我们后端程序是否运行成功
    private Boolean success=true;
    private String msg="操作成功";
    //全参构造
    public AjaxResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
    //无参构造
    public AjaxResult() {
    }
}
