package com.jpa.practice.repository;

import com.jpa.practice.entity.Course;
import com.jpa.practice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder().teacherId(1L).firstName("Atik").lastName("Ahmed").build();
        Course course = Course.builder()
                .title("C programming")
                .teacher(teacher)
                .courseId(1L)
                .build();
        courseRepo.save(course);
    }

    @Test
    @Transactional()
    public void saveCoursesWithExistingTeacher(){
        Course exCourse = courseRepo.getById(1L);
        System.out.println("exCourse = " + exCourse);
        exCourse.setTitle("C programming");
//        Course course = Course.builder()
//                .title("Python programming")
//                .teacher(exCourse.getTeacher())
//                .build();
//        Course newCourse = exCourse;
//
        courseRepo.save(exCourse);
    }

    // course will not save without teacher. because optional = false
    @Test
    public void saveCourseWithoutTeacher(){
//        Teacher teacher = Teacher.builder()
//                .firstName("Nagibul")
//                .lastName("Haque")
//                .build();
        Course course = Course.builder().title("Data structure")
//                .teacher(teacher)
                .build();
        courseRepo.save(course);
    }
}