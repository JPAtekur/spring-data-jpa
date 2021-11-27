package com.practice.spring.data.jpa.repository;

import com.practice.spring.data.jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial,Long> {
}
