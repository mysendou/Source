package com.aug.jma.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aug.jma.domain.StudentMarks;

public class StudentMarkMapper implements RowMapper<StudentMarks> {

    @Override
    public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setId(rs.getInt("id"));
        studentMarks.setName(rs.getString("name"));
        studentMarks.setAge(rs.getInt("age"));
        studentMarks.setMarks(rs.getInt("marks"));
        studentMarks.setYear(rs.getInt("year"));
        studentMarks.setsId(rs.getInt("sid"));

        return studentMarks;
    }

}
