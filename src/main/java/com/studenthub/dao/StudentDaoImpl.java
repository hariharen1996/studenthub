package com.studenthub.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.studenthub.dto.StudentDto;

public class StudentDaoImpl implements StudentDao {
      
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void insert(StudentDto studentDto){
        String sql = "insert into student(name,address,cgpa,rollno,department) values(?,?,?,?,?)";
        Object[] args = {studentDto.getName(),studentDto.getAddress(),studentDto.getCgpa(),studentDto.getRollno(),studentDto.getDepartment()};
        int rowsInserted = jdbcTemplate.update(sql, args);
        System.out.println("rows inserted: " + rowsInserted);
    }

    @Override
    public void insert(List<StudentDto> students){
        String sql = "insert into student(name,address,cgpa,rollno,department) values(?,?,?,?,?)";
        ArrayList<Object[]> studenList = new ArrayList<>();
        
        for(StudentDto studentDto: students){
            Object[] studentData = {studentDto.getName(),studentDto.getAddress(),studentDto.getCgpa(),studentDto.getRollno(),studentDto.getDepartment()};
            studenList.add(studentData);
        }

        jdbcTemplate.batchUpdate(sql,studenList);

        System.out.println("batch update completed");
    }

    @Override
    public boolean deleteRecordByRollNo(int rollNo){
        String sql = "delete from student where rollno = ?";
        int rowsDeleted = jdbcTemplate.update(sql,rollNo);
        System.out.println("Number of rows deleted: " + rowsDeleted);
        return rowsDeleted == 1;
    }
}
