package com.cg.module03casestudy.model;

public class Student {
    private Integer stuID;
    private String namestu;
    private String dateofbirth;
    private String email;
    private String address;

    public Student() {
    }

    public Student(Integer stuID, String namestu, String dateofbirth, String email, String address) {
        this.stuID = stuID;
        this.namestu = namestu;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.address = address;
    }

    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    public String getNamestu() {
        return namestu;
    }

    public void setNamestu(String namestu) {
        this.namestu = namestu;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}