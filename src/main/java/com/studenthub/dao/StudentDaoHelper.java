package com.studenthub.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.studenthub.dto.StudentDto;

public class StudentDaoHelper {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void setupStudentTable(){

        StudentDto renu = new StudentDto("renu","hyd",BigDecimal.valueOf(8.50),9,"IT");
        StudentDto menu = new StudentDto("menu","cmb",BigDecimal.valueOf(5.00),10,"CSE");
        StudentDto banu = new StudentDto("banu","blro",BigDecimal.valueOf(6.80),11,"Civil");
       
        ArrayList<StudentDto> students = new ArrayList<>();

        students.add(renu);
        students.add(menu);
        students.add(banu);
    
        studentDao.updateStudent(students);
    }
}
