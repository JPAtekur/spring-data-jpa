package com.jpa.practice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@ToString(exclude = "teacher")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(
            name = "TEACHER_ID",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

//    @ManyToMany
//    @JoinTable(
//            name = "COURSES_STUDENTS",
//            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
//            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
//    )
//    private List<Student> students;
}
