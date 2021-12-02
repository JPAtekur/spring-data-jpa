package com.jpa.practice.repository;

import com.jpa.practice.entity.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepo extends JpaRepository<A,Long> {
}
