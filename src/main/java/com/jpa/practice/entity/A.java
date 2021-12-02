package com.jpa.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class A {
    @Id
    @GeneratedValue
    private Long aId;
    private String title;

    @ManyToMany(mappedBy = "aList")
    private List<B> bList;

}
