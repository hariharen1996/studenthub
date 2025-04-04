package com.studenthub;

import java.util.List;

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
        
        System.out.println("retrieve student roll number 5");
        StudentDto getByRollNo = studentDaoImpl.findStudentByRollNo(005);
        System.out.println(getByRollNo);

        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("application context closed");
    }
}
