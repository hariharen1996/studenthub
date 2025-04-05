package com.studenthub.repository;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studenthub.entity.Student;

@Component
public class StudentDaoHelper {

    private StudentRepository studentDao;

    @Autowired
    public void setStudentDao(StudentRepository studentDao){
        this.studentDao = studentDao;
    }

    public void setupStudentTable(){

        Student renu = new Student("renu","hyd",BigDecimal.valueOf(8.50),001,"IT");
        Student menu = new Student("menu","cmb",BigDecimal.valueOf(5.00),002,"CSE");
        Student banu = new Student("banu","blro",BigDecimal.valueOf(6.80),003,"Civil");
       
        ArrayList<Student> students = new ArrayList<>();

        students.add(renu);
        students.add(menu);
        students.add(banu);
    
        studentDao.insert(students);
    }
}
