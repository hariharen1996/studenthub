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

        StudentDto ram = new StudentDto("ram","madurai",BigDecimal.valueOf(8.00),6,"IT");
        System.out.println("updating single students data");
        studentDao.updateStudent(ram);
    }
}
