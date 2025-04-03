package com.studenthub;

import com.studenthub.dto.StudentDto;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("studenthub");
        StudentDto dto = new StudentDto(1,"hari","chn",7.89,001,"CSE");
        System.out.println(dto);
    }
}
