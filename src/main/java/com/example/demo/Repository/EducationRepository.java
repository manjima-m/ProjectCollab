package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {

@SuppressWarnings({ "unchecked", "null" })
Education save(Education edu);

}

