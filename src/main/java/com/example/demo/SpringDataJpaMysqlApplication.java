package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaMysqlApplication.class, args);
        List<String> list = new ArrayList<>();
    }
}
