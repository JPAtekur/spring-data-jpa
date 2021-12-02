//package com.jpa.practice.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Data @AllArgsConstructor @NoArgsConstructor @Builder
//public class Student {
//
//    @Id
//    @GeneratedValue
//    private Long studentId;
//    private String name;
//
//    @ManyToMany
//    @JoinTable(
//            name = "COURSES_STUDENTS",
//            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
//            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
//    )
//    private List<Course> courses;
//
//}
