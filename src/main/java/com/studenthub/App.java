package com.studenthub;

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
        System.out.println("annotationconfig initialized");

        StudentDaoHelper studentDaoHelper = context.getBean("studentDaoHelper", StudentDaoHelper.class);
        studentDaoHelper.setupStudentTable();

        StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentDaoImpl.class);
        List<StudentDto> students = studentDaoImpl.findAllStudents();
        System.out.println(students);

        System.out.println("retrieve student by name");
        List<StudentDto> allstudents = studentDaoImpl.findStudentByName("sathya");
        System.out.println(allstudents);

        System.out.println("group student by address");
        Map<String, List<String>> groupStudentByAddress = studentDaoImpl.groupStudentByAddress();
        System.out.println(groupStudentByAddress);

        context.close();
        System.out.println("annotation config closed");
    }
}
