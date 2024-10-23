package com.example.SpringBootManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootManyToMany.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
