package org.itsource.mapper;

import org.itsource.App;
import org.itsource.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class IDepartmentMapperTest {
    @Autowired
    private IDepartmentMapper departmentMapper;

    @Test
    public void selectAll() {
        List<Department> departments = departmentMapper.selectAll();
        for (Department department : departments) {
            System.out.println(department);

        }
        }


    @Test
    public void selectById() {
    }

    @Test
    public void insert() {
        Department department =new Department();
        department.setName("李");
        department.setState(1);
        departmentMapper.insert(department);
    }

    @Test
    public void update() {
        Department department = departmentMapper.selectById(1L);
        department.setName("铅球社");
        departmentMapper.update(department);

    }

    @Test
    public void deletById() {
    }
}