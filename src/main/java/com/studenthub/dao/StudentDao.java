package com.studenthub.dao;

import java.util.List;
import java.util.Map;

import com.studenthub.dto.StudentDto;

public interface StudentDao {
    void insert(StudentDto studentDto);
    void insert(List<StudentDto> students);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByNameOrAddress(String name,String address);
    List<StudentDto> findAllStudents();
    StudentDto findStudentByRollNo(int rollNo);
    List<StudentDto> findStudentByName(String name);
    Map<String,List<String>> groupStudentByAddress();
}
