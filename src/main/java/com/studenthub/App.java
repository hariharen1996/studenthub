package com.studenthub;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studenthub.dao.StudentDaoImpl;
import com.studenthub.dto.StudentDto;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("application context initialized");
        StudentDto hari = new StudentDto("hari","chn",BigDecimal.valueOf(7.89),001,"CSE");
        
        StudentDaoImpl daoImpl = context.getBean("studentDaoImpl",StudentDaoImpl.class);
        daoImpl.insert(hari);

        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("application context closed");
    }
}
