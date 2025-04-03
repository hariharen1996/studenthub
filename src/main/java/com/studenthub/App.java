package com.studenthub;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studenthub.dto.StudentDto;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("application context initialized");
        StudentDto dto = new StudentDto(1,"hari","chn",7.89,001,"CSE");
        System.out.println(dto);
        ((ClassPathXmlApplicationContext)context).close();
        System.out.println("application context closed");
    }
}
