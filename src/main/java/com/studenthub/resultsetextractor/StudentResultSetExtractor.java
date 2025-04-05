package com.studenthub.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.studenthub.entity.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Student> students = new ArrayList<>();
        while(rs.next()){
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setAddress(rs.getString("address"));
            student.setCgpa(rs.getBigDecimal("cgpa"));
            student.setRollno(rs.getInt("rollno"));
            student.setDepartment(rs.getString("department"));
            students.add(student);
        }

        return students;
    }
    
}
