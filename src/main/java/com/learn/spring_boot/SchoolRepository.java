package com.learn.spring_boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Optional
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
