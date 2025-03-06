package com.learn.spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Optional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstnameContaining(String firstname);
}
