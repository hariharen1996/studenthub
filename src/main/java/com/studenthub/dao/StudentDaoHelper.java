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

        StudentDto ganesh = new StudentDto("ram","mdu",BigDecimal.valueOf(8.00),6,"IT");
        StudentDto baran = new StudentDto("raghu","cmb",BigDecimal.valueOf(8.50),7,"CSE");
        StudentDto sathya = new StudentDto("vishak","mdu",BigDecimal.valueOf(8.70),8,"CIVIl");
        
        ArrayList<StudentDto> students = new ArrayList<>();
        students.add(ganesh);
        students.add(baran);
        students.add(sathya);

        studentDao.insert(students);
    }
}
