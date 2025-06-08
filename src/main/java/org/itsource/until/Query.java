package org.itsource.until;

import lombok.Data;

@Data
public class Query {
    //用户查询当前字段
    private Integer currentPage;
    //每页显示条数
    private Integer pageSize;
    public Integer getStart(){
        return (this.currentPage-1)*pageSize;
    }
    //关键字
    private String keyword;
}
