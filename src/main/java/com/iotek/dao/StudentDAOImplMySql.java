package com.iotek.dao;

import com.iotek.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by taft on 2017/5/3.
 */
@Repository("mysqlDAO")
public class StudentDAOImplMySql implements StudentDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Collection getAllStudents() {

        String sql = "select stu.id id,stu.name name,stu.age age,stu.gender gender from student stu";
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                return student;
            }
        });
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        String sql = "delete from student where id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void createStudent(Student student) {
        String sql = "insert into student (name,age,gender) values(?,?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getAge(),student.getGender());
    }
}
