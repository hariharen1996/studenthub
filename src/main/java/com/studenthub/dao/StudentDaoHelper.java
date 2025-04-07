package com.studenthub.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studenthub.dto.StudentDto;

@Component
public class StudentDaoHelper {

    private StudentDaoImpl studentDao;

    @Autowired
    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public void setupStudentTable() {
        studentDao.cleanUp();
        batchInsertStudents();        
        updateStudentRecords();
    }

   private void batchInsertStudents() {
        List<StudentDto> students = new ArrayList<>();
        
        students.add(new StudentDto("renu", "hyd", BigDecimal.valueOf(8.50), 1, "IT"));
        students.add(new StudentDto("menu", "cmb", BigDecimal.valueOf(5.00), 2, "CSE"));
        students.add(new StudentDto("banu", "blro", BigDecimal.valueOf(6.80), 3, "Civil"));
        students.add(new StudentDto("sathya", "chennai", BigDecimal.valueOf(9.20), 4, "IT"));
        students.add(new StudentDto("kumar", "delhi", BigDecimal.valueOf(7.80), 5, "ECE"));
        studentDao.insert(students);
        System.out.println("Inserted " + students.size() + " student records");
    }

    private void updateStudentRecords() {
        StudentDto updatedStudent = new StudentDto();
        updatedStudent.setRollno(1);
        updatedStudent.setAddress("new hyderabad");
        studentDao.updateStudent(updatedStudent);
        System.out.println("Updated address for rollno 1");

       List<StudentDto> studentsToUpdate = new ArrayList<>();
        
        StudentDto update1 = new StudentDto();
        update1.setRollno(2);
        update1.setAddress("new cmb");
        studentsToUpdate.add(update1);
        
        StudentDto update2 = new StudentDto();
        update2.setRollno(3);
        update2.setAddress("new blr");
        studentsToUpdate.add(update2);
        
        studentDao.updateStudent(studentsToUpdate);
        System.out.println("Performed batch update on " + studentsToUpdate.size() + " records");
    }
}