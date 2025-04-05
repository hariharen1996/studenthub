package com.studenthub.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studenthub.dto.StudentDto;
import com.studenthub.resultsetextractor.StudentAddrResultSetExtractor;
import com.studenthub.resultsetextractor.StudentResultSetExtractor;

@Repository
public class StudentDaoImpl implements StudentDao {
      
    private JdbcTemplate jdbcTemplate;

    @Autowired
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

    @Override
    public int deleteRecordByNameOrAddress(String name, String address) {
        String sql = "delete from student where name = ? or address = ?";
        int rowsDeleted = jdbcTemplate.update(sql,name,address);
        System.out.println("Number of rows deleted: " + rowsDeleted);
        return rowsDeleted;
    }

    public void cleanUp(){
        String sql = "truncate table student";
        jdbcTemplate.update(sql);
        System.out.println("data deleted from table --- cleaned up");
    }

    @Override
    public List<StudentDto> findAllStudents() {
       String sql = "select * from student";
       List<StudentDto> allStudents = jdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentDto>(StudentDto.class));
       return allStudents;
    }

    @Override
    public StudentDto findStudentByRollNo(int rollNo) {
       String sql = "select * from student where rollno = ?";
       StudentDto student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<StudentDto>(StudentDto.class),rollNo);
       return student;
    }

    @Override
    public List<StudentDto> findStudentByName(String name) {
       String sql = "select * from student where name = ?";
       List<StudentDto> student = jdbcTemplate.query(sql, new StudentResultSetExtractor(),name);
       return student;
    }

    @Override
    public Map<String, List<String>> groupStudentByAddress() {
        String sql = "select * from student";
        Map<String, List<String>> students = jdbcTemplate.query(sql, new StudentAddrResultSetExtractor());
        return students;
    }

    @Override
    public int updateStudent(StudentDto studentDto) {
        String sql = "update student set address = ? where rollno = ?";
        Object[] studentData = {studentDto.getAddress(),studentDto.getRollno()};
        int rowsUpdated = jdbcTemplate.update(sql, studentData);
        System.out.println("rows updated: " + rowsUpdated);
        return rowsUpdated;
    }

    @Transactional
    @Override
    public int updateStudent(List<StudentDto> studentLists) {
        String sql = "update student set address = ? where rollno = ?";
        jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, studentLists.get(i).getAddress());
                ps.setInt(2, studentLists.get(i).getRollno());
            }

            @Override
            public int getBatchSize() {
                return studentLists.size();
            } 
        });

        return 0;
    }
}
