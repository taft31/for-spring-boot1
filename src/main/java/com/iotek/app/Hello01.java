package com.iotek.app;

import com.iotek.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by taft on 2017/5/3.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Hello01 {
    public static void main(String[] args) {
        SpringApplication.run(StudentController.class, args);
    }
}
//
