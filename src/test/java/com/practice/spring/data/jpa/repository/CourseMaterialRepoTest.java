package com.practice.spring.data.jpa.repository;

import com.practice.spring.data.jpa.entity.Course;
import com.practice.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {
    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .credit(3)
                .title("Data structure and algorithm")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        courseMaterialRepo.save(courseMaterial);
    }
}