package com.example.SpringBootManyToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootManyToMany.entity.Course;
import com.example.SpringBootManyToMany.entity.Student;
import com.example.SpringBootManyToMany.repository.CourseRepository;
import com.example.SpringBootManyToMany.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	
	@PostMapping("/course")
	 public Course addCourses(@RequestBody Course course) {
		 return courseRepository.save(course);
	 }
}
