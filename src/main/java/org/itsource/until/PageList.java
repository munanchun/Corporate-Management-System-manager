package org.itsource.until;
import lombok.Data;
import org.itsource.domain.Department;

import java.util.ArrayList;
import java.util.List;
@Data
public class PageList<T>{
    //这个字段用来接收分页查到的数据
    private List<T> rows=new ArrayList<>();
    //这个字段用来接收总条数
    private Integer totals;

}
