package com.studenthub;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studenthub.dao.StudentDaoHelper;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("application context initialized");
        
        StudentDaoHelper daoHelper = context.getBean("studentDaoHelper",StudentDaoHelper.class);
        daoHelper.setupStudentTable();

        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("application context closed");
    }
}
