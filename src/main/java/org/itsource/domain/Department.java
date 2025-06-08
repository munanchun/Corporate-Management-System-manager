package org.itsource.domain;
import lombok.Data;
@Data //自动生成javabean所需方法
public class Department {
    private Long id;
    private String sn;//部门编号
    private String name;//部门名称
    private String dirPath;//部门上级指令id
    private  Integer state;//部门状态
    private Long manager_id;
    private Employee manager;
    private Long parent_id;
    private Department parent;
}
