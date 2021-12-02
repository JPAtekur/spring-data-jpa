package com.jpa.practice.repository;

import com.jpa.practice.entity.B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRepo extends JpaRepository<B,Long> {
}
