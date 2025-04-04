package com.studenthub.dao;

import java.util.List;

import com.studenthub.dto.StudentDto;

public interface StudentDao {
    void insert(StudentDto studentDto);
    void insert(List<StudentDto> students);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByNameOrAddress(String name,String address);
}
