package com.studenthub;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studenthub.dao.StudentDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("application context initialized");
        
        StudentDaoImpl studentDaoImpl = context.getBean("studentDaoImpl",StudentDaoImpl.class);
        studentDaoImpl.deleteRecordByNameOrAddress("sathya","blrr");

        studentDaoImpl.cleanUp();
        

        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("application context closed");
    }
}
