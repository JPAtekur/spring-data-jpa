package com.practice.spring.data.jpa.repository;

import com.practice.spring.data.jpa.entity.Guardian;
import com.practice.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Atekur")
                .lastName("Rahman")
                .emailId("atekur.rm1@gmail.com")
//                .guardianName("Fardows Hossen")
//                .guardianMobile("0173454569")
//                .guardianEmail("fardows@gmail.com")
                .build();
        studentRepo.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Nadira")
                .email("nadira@gmail.com")
                .mobile("0184730232")
                .build();

        Student student = Student.builder()
                .firstName("Nirob")
                .lastName("Ahmed")
                .emailId("nirob@gmail.com")
                .guardian(guardian)
                .build();
        studentRepo.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepo.findAll();
        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepo.findByFirstName("Nirob");
        System.out.println("Student list: " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepo.findByFirstNameContaining("ku");
        System.out.println("Student list: " + studentList);
    }
    
    @Test
    public void findByLastNameNotNull(){
        List<Student> studentList = studentRepo.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findByGuardianName(){
        List<Student> studentList = studentRepo.findByGuardianName("nadira");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void getStudentByEmailId(){
        Student student = studentRepo.getStudentByEmailId("atekur.rm@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void getStudentFirstNameByEmailId(){
        String firstName = studentRepo.getStudentFirstNameByEmailId("atekur.rm@gmail.com");
        System.out.println("firstName = " + firstName);
    }
}