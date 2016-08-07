package com.aug.jma.dao;

import java.util.List;

import javax.sql.DataSource;

import com.aug.jma.domain.StudentMarks;

public interface StudentDao {

    public void setDataSource(DataSource dataSource);

    public void create(String name, Integer age, Integer marks, Integer year);

    public List<StudentMarks> getStudents();

}
