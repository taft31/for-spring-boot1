package com.iotek.controller;

import com.iotek.model.Student;
import com.iotek.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by taft on 2017/5/3.
 */
@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllStudents(ModelMap modelMap){
        modelMap.put("students",studentService.getAllStudents());
        return "showStudents";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable int id){//从url中取得对应的变量参数
         studentService.deleteStudentById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student){//自动把请求参数中的json转为对象
        studentService.createStudent(student);
    }

}
