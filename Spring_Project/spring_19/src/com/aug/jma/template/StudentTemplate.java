package com.aug.jma.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aug.jma.dao.StudentDao;
import com.aug.jma.domain.Student;
import com.aug.jma.mapping.StudentMapper;

public class StudentTemplate implements StudentDao{

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age) {
        String SQL = "insert into student(name,age) values(?,?);";
        jdbcTemplate.update(SQL,name,age);
        System.out.println("Create Student, name -> " + name + " age -> " + age);
        return;
    }

    @Override
    public Student getStudent(Integer id) {
        String SQL = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> getStudents() {
        String SQL = "select * from student;";
        List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
        return students;
    }

    @Override
    public void deleteStudent(Integer id) {
        String SQL = "delete from student where id = ?;";
        jdbcTemplate.update(SQL,id);
        System.out.println("Delete student student id -> " + id);
        return;
    }

    @Override
    public void updateStudent(Integer id, Integer age) {
        String SQL = "update student set age = ? where id = ?";
        jdbcTemplate.update(SQL,age,id);
        System.out.println("Update the student, student id -> " + id);
    }

}
