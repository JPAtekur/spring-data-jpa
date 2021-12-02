package com.jpa.practice.repository;

import com.jpa.practice.entity.A;
import com.jpa.practice.entity.B;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ARepoTest {

    @Autowired
    private ARepo aRepo;

    @Test
    public void saveAWithB(){

        B b1 = new B();
        b1.setTitle("B title");
        B b2 = new B();
        b2.setTitle("B title 2");

        List<B> list = new ArrayList<>();
        list.add(b1);
//        list.add(a2);

        List<B> list2 = new ArrayList<>();
//        list.add(a1);
        list2.add(b2);

        A a1 = new A();
        a1.setTitle("A title");
        a1.setBList(list);
        A a2 = new A();
        a2.setTitle("A title 2");
        a2.setBList(list2);

        aRepo.save(a1);
        aRepo.save(a2);
    }
}