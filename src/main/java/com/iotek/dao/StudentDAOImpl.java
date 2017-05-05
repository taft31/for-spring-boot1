package com.iotek.dao;

import com.iotek.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taft on 2017/5/3.
 */
@Repository("fakeDao")
public class StudentDAOImpl implements StudentDAO {
    public static Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<Integer, Student>() {
            {
                put(1,new Student(1,"刘德华",50,"男"));
                put(2,new Student(2,"张学友",50,"女"));
                put(3,new Student(3,"霍建华",30,"男"));
                put(4,new Student(4,"霍冬英",40,"女"));
                put(5,new Student(5,"霍去病",1500,"男"));
            }
        };
    }

    @Override
    public Collection getAllStudents() {
        return this.studentMap.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.studentMap.get(id);
    }

    @Override
    public void deleteStudentById(int id) {
        this.studentMap.remove(id);
    }

    @Override
    public void createStudent(Student student) {
        this.studentMap.put(student.getId(),student);
    }
}
