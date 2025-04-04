package com.studenthub.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.studenthub.dto.StudentDto;

public class StudentRowMapper implements RowMapper<StudentDto> {

    @Override
    public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(rs.getString("name"));
        studentDto.setAddress(rs.getString("address"));
        studentDto.setCgpa(rs.getBigDecimal("cgpa"));
        studentDto.setRollno(rs.getInt("rollno"));
        studentDto.setDepartment(rs.getString("department"));

        System.out.println("rowmapper");
        
        return studentDto;
    }
    
}
