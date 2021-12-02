package com.jpa.practice.repository;

import com.jpa.practice.entity.A;
import com.jpa.practice.entity.B;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BRepoTest {

    @Autowired
    private BRepo bRepo;

    @Test
    public void saveBWithA(){
        A a1 = new A();
        a1.setTitle("A title");
        A a2 = new A();
        a2.setTitle("A title 2");

        List<A> list = new ArrayList<>();
        list.add(a1);
//        list.add(a2);

        List<A> list2 = new ArrayList<>();
//        list.add(a1);
        list2.add(a2);

        B b1 = new B();
        b1.setTitle("B title");
        b1.setAList(list);
        B b2 = new B();
        b2.setTitle("B title 2");
        b2.setAList(list2);

        bRepo.save(b1);
        bRepo.save(b2);

    }
}