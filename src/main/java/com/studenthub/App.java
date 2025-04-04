package com.studenthub;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studenthub.dao.StudentDaoHelper;
import com.studenthub.dao.StudentDaoImpl;
import com.studenthub.dto.StudentDto;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("application context initialized");
        
        StudentDaoHelper studentDaoHelper = context.getBean("studentDaoHelper",StudentDaoHelper.class);
        studentDaoHelper.setupStudentTable();
      
        StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl",StudentDaoImpl.class);
        List<StudentDto> students =  studentDaoImpl.findAllStudents();
        System.out.println(students);
        
        System.out.println("retrieve student roll number 3");
        StudentDto getByRollNo = studentDaoImpl.findStudentByRollNo(003);
        System.out.println(getByRollNo);

        System.out.println("retrieve student by name");
        List<StudentDto> allstudents = studentDaoImpl.findStudentByName("sathya");
        System.out.println(allstudents);

        System.out.println("group student by address");
        Map<String, List<String>> groupStudentByAddress = studentDaoImpl.groupStudentByAddress();
        System.out.println(groupStudentByAddress);
        

        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("application context closed");
    }
}
