package com.studenthub.dto;

import java.math.BigDecimal;

public class StudentDto {
    private int id;
    private String name;
    private String address;
    private BigDecimal cgpa;
    private int rollno;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public StudentDto() {
    }

    public StudentDto(int id, String name, String address, BigDecimal cgpa, int rollno, String department) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cgpa = cgpa;
        this.rollno = rollno;
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentDto [id=" + id + ", name=" + name + ", address=" + address + ", cgpa=" + cgpa + ", rollno="
                + rollno + ", department=" + department + "]";
    }

}
