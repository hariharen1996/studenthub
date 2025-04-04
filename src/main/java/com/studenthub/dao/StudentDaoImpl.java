package com.studenthub.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.studenthub.dto.StudentDto;

public class StudentDaoImpl implements StudentDao {
      
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insert(StudentDto studentDto){
        String sql = "insert into student(name,address,cgpa,rollno,department) values(?,?,?,?,?)";
        Object[] args = {studentDto.getName(),studentDto.getAddress(),studentDto.getCgpa(),studentDto.getRollno(),studentDto.getDepartment()};
        int rowsInserted = jdbcTemplate.update(sql, args);
        System.out.println("rows inserted: " + rowsInserted);
    }
}
