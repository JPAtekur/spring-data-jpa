package com.practice.spring.data.jpa.repository;

import com.practice.spring.data.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;
    
    @Test
    public void getAllCourses(){
        List<Course> courseList = courseRepo.findAll();
        System.out.println("courseList = " + courseList);
    }
}