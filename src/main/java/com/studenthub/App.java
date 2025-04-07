package com.studenthub;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.studenthub.config.AppConfig;
import com.studenthub.dao.StudentDaoHelper;
import com.studenthub.dao.StudentDaoImpl;
import com.studenthub.dto.StudentDto;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("AnnotationConfig initialized");

        System.out.println("Initialized helper and setup table");
        StudentDaoHelper studentDaoHelper = context.getBean("studentDaoHelper", StudentDaoHelper.class);
        studentDaoHelper.setupStudentTable();

        StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);

        System.out.println("*****findAllStudents()*****");
        List<StudentDto> allStudents = studentDaoImpl.findAllStudents();
        System.out.println("All students: " + allStudents);

        System.out.println("*****findStudentByRollNo()*****");
        StudentDto studentByRollNo = studentDaoImpl.findStudentByRollNo(1);
        System.out.println("Student with rollno 1: " + studentByRollNo);

        System.out.println("*****findStudentByName()*****");
        List<StudentDto> studentsByName = studentDaoImpl.findStudentByName("renu");
        System.out.println("Students named 'renu': " + studentsByName);

        System.out.println("*****groupStudentByAddress()*****");
        Map<String, List<String>> studentsByAddress = studentDaoImpl.groupStudentByAddress();
        System.out.println("Students grouped by address: " + studentsByAddress);

        System.out.println("*****insert() single student*****");
        StudentDto newStudent = new StudentDto("sathya", "chennai", BigDecimal.valueOf(9.2), 4, "IT");
        studentDaoImpl.insert(newStudent);
        System.out.println("Inserted new student. All students now: " + studentDaoImpl.findAllStudents());

        System.out.println("*****insert() multiple students*****");
        List<StudentDto> newStudents = new ArrayList<>();
        newStudents.add(new StudentDto("kumar", "delhi", BigDecimal.valueOf(7.8), 5, "ECE"));
        newStudents.add(new StudentDto("priya", "mumbai", BigDecimal.valueOf(8.3), 6, "EEE"));
        studentDaoImpl.insert(newStudents);
        System.out.println("Inserted multiple students. All students now: " + studentDaoImpl.findAllStudents());

        System.out.println("*****updateStudent()*****");
        StudentDto updateStudent = new StudentDto();
        updateStudent.setRollno(1);
        updateStudent.setAddress("new hyderabad");
        int updatedRows = studentDaoImpl.updateStudent(updateStudent);
        System.out.println("Updated " + updatedRows + " rows. Student with rollno 1 now: " + 
        studentDaoImpl.findStudentByRollNo(1));

        System.out.println("*****updateStudent() multiple*****");
        List<StudentDto> studentsToUpdate = new ArrayList<>();
        StudentDto update1 = new StudentDto();
        update1.setRollno(2);
        update1.setAddress("new cmb");
        studentsToUpdate.add(update1);
        
        StudentDto update2 = new StudentDto();
        update2.setRollno(3);
        update2.setAddress("new blr");
        studentsToUpdate.add(update2);
        
        studentDaoImpl.updateStudent(studentsToUpdate);
        System.out.println("Batch update completed. Students now: " + studentDaoImpl.findAllStudents());

        System.out.println("*****deleteRecordByRollNo()*****");
        boolean deleted = studentDaoImpl.deleteRecordByRollNo(6);
        System.out.println("Deleted student with rollno 6: " + deleted);
        System.out.println("All students after deletion: " + studentDaoImpl.findAllStudents());

        System.out.println("*****deleteRecordByNameOrAddress()*****");
        int deletedCount = studentDaoImpl.deleteRecordByNameOrAddress("kumar", "new hyderabad");
        System.out.println("Deleted " + deletedCount + " students");
        System.out.println("All students after deletion: " + studentDaoImpl.findAllStudents());

        System.out.println("*****cleanUp()*****");
        studentDaoImpl.cleanUp();
        System.out.println("Table cleaned. All students now: " + studentDaoImpl.findAllStudents());

        context.close();
        System.out.println("AnnotationConfig closed");
    }
}