package com.cg.module03casestudy.service;

import com.cg.module03casestudy.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(int stuID);

    void update(int stuID, Student student);

    void remove(int stuID);
}