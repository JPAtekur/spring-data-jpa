package com.jpa.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class B {
    @Id
    @GeneratedValue
    private Long bId;
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "a_b",
            joinColumns = @JoinColumn(name = "b_id", referencedColumnName = "bId"),
            inverseJoinColumns = @JoinColumn(name = "a_id", referencedColumnName = "aId")
    )
    private List<A> aList;

}
