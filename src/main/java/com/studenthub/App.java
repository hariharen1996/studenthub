package com.studenthub;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.studenthub.config.AppConfig;
import com.studenthub.entity.Student;
import com.studenthub.repository.StudentDaoHelper;
import com.studenthub.repository.StudentRepositoryImpl;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("annotationconfig initialized");

        StudentDaoHelper studentDaoHelper = context.getBean("studentDaoHelper", StudentDaoHelper.class);
        studentDaoHelper.setupStudentTable();

        StudentRepositoryImpl studentDaoImpl = context.getBean("studentDaoImpl", StudentRepositoryImpl.class);
        List<Student> students = studentDaoImpl.findAllStudents();
        System.out.println(students);

        System.out.println("retrieve student by name");
        List<Student> allstudents = studentDaoImpl.findStudentByName("sathya");
        System.out.println(allstudents);

        System.out.println("group student by address");
        Map<String, List<String>> groupStudentByAddress = studentDaoImpl.groupStudentByAddress();
        System.out.println(groupStudentByAddress);

        context.close();
        System.out.println("annotation config closed");
    }
}
