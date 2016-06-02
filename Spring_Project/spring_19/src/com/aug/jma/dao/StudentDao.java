package com.aug.jma.dao;

import java.util.List;

import javax.sql.DataSource;

import com.aug.jma.domain.Student;

public interface StudentDao {

    public void setDataSource(DataSource dataSource);

    public void create(String name, Integer age);

    public Student getStudent(Integer id);

    public List<Student> getStudents();

    public void deleteStudent(Integer id);

    public void updateStudent(Integer id, Integer age);
}
