package com.studenthub.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studenthub.dto.StudentDto;

@Component
public class StudentDaoHelper {

    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void setupStudentTable(){

        StudentDto renu = new StudentDto("renu","hyd",BigDecimal.valueOf(8.50),001,"IT");
        StudentDto menu = new StudentDto("menu","cmb",BigDecimal.valueOf(5.00),002,"CSE");
        StudentDto banu = new StudentDto("banu","blro",BigDecimal.valueOf(6.80),003,"Civil");
       
        ArrayList<StudentDto> students = new ArrayList<>();

        students.add(renu);
        students.add(menu);
        students.add(banu);
    
        studentDao.insert(students);
    }
}
