package com.jpa.practice.repository;

import com.jpa.practice.entity.Course;
import com.jpa.practice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void saveTeacher(){
        Course course1 = Course.builder()
                .title("Java programming")
                .build();
        Course course2 = Course.builder()
                .title("C++ programming")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Mohammad")
                .lastName("Asif")
                .build();
//        teacher.setTeacherCourse(course1);
//        teacher.setTeacherCourse(course2);

        teacherRepo.save(teacher);

    }

    @Test
    @Transactional
    public void getTeacherWithCourses(){
        Teacher teacher = teacherRepo.getById(1L);
        System.out.println("teacher = " + teacher);
        assertEquals(teacher.getTeacherId(),1L);
        assertEquals(teacher.getFirstName(),"Mohammad");
        assertEquals(teacher.getLastName(),"Asif");
//        assertEquals(teacher.getCourses().get(0).getTitle(),"Java programming");
//        assertEquals(teacher.getCourses().get(1).getTitle(),"C++ programming");
    }

    @Test
    public void saveTeacherWithCourse(){
        Course course = Course.builder().title("Spring data jpa").build();
        Teacher teacher = Teacher.builder().firstName("Amir").lastName("Hossen").build();

        course.setTeacher(teacher);
        teacher.setCourses(Arrays.asList(course));

        teacherRepo.save(teacher);
    }

    @Test
    @Transactional
    public void saveExistringTeacherAndCourse(){
        Course savedCourse = courseRepo.getById(16L);
        Teacher savedTeacher = savedCourse.getTeacher();

        savedTeacher.setLastName("Hassan");
        savedCourse.setTitle("Spring boot");

        teacherRepo.save(savedTeacher);
        teacherRepo.flush();
    }

    @Test
    public void removeTeacher(){
        teacherRepo.deleteById(4L);
    }


}
