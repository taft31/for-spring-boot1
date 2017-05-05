package com.iotek.service;

import com.iotek.model.Student;

import java.util.Collection;

/**
 * Created by taft on 2017/5/3.
 */
public interface StudentService {
    Collection getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    void createStudent(Student student);
}
