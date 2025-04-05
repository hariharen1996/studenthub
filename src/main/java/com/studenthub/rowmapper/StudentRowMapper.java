package com.studenthub.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.studenthub.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setName(rs.getString("name"));
        student.setAddress(rs.getString("address"));
        student.setCgpa(rs.getBigDecimal("cgpa"));
        student.setRollno(rs.getInt("rollno"));
        student.setDepartment(rs.getString("department"));

        System.out.println("rowmapper");
        
        return student;
    }
    
}
