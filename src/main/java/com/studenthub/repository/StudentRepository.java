package com.studenthub.repository;

import java.util.List;
import java.util.Map;

import com.studenthub.entity.Student;

public interface StudentRepository {
    void insert(Student students);
    void insert(List<Student> students);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByNameOrAddress(String name,String address);
    List<Student> findAllStudents();
    Student findStudentByRollNo(int rollNo);
    List<Student> findStudentByName(String name);
    Map<String,List<String>> groupStudentByAddress();
    int updateStudent(Student students);
    int updateStudent(List<Student> studentLists);   
}
