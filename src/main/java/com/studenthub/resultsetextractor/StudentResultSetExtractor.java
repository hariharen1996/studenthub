package com.studenthub.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.studenthub.dto.StudentDto;

public class StudentResultSetExtractor implements ResultSetExtractor<List<StudentDto>> {

    @Override
    public List<StudentDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<StudentDto> students = new ArrayList<>();
        while(rs.next()){
            StudentDto studentDto = new StudentDto();
            studentDto.setName(rs.getString("name"));
            studentDto.setAddress(rs.getString("address"));
            studentDto.setCgpa(rs.getBigDecimal("cgpa"));
            studentDto.setRollno(rs.getInt("rollno"));
            studentDto.setDepartment(rs.getString("department"));
            students.add(studentDto);
        }

        return students;
    }
    
}
