package com.aug.jma.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aug.jma.dao.StudentDao;
import com.aug.jma.domain.StudentMarks;
import com.aug.jma.mapping.StudentMarkMapper;

public class StudentTemplate implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age, Integer marks, Integer year) {

        try {
            String SQL = "insert into student(name,age) values(?,?);";
            jdbcTemplate.update(SQL, name, age);

            String SQL2 = "select MAX(id) from student;";
            int sid = jdbcTemplate.queryForObject(SQL2, null, Integer.class);
            String SQL3 = "insert into marks(sid, marks, year) values(?,?,?);";
            jdbcTemplate.update(SQL3, sid, marks, year);
            throw new RuntimeException("test add exception");

        } catch (Exception e) {
            throw e;
        }
        // System.out.println("Create Student, name -> " + name + " age -> " +
        // age);
    }

    @Override
    public List<StudentMarks> getStudents() {
        String SQL = "select * from student, marks where student.id = marks.sid;";
        List<StudentMarks> students = jdbcTemplate.query(SQL, new StudentMarkMapper());
        return students;
    }

}
