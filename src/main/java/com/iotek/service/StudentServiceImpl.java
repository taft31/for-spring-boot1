package com.iotek.service;

import com.iotek.dao.StudentDAO;
import com.iotek.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by taft on 2017/5/3.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("mysqlDAO")//指定特定的dao来注入
    private StudentDAO studentDAO;

    @Override
    public Collection getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDAO.deleteStudentById(id);
    }

    @Override
    public void createStudent(Student student) {
        studentDAO.createStudent(student);
    }
}
