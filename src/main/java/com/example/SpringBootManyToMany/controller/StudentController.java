package com.example.SpringBootManyToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootManyToMany.entity.Course;
import com.example.SpringBootManyToMany.entity.Student;
import com.example.SpringBootManyToMany.repository.CourseRepository;
import com.example.SpringBootManyToMany.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	
	@PostMapping("/student")
	 public Student addStudent(@RequestBody Student student) {
		 return studentRepository.save(student);
	 }
	
	
	@PutMapping("/student-like-course")
	public Student updateStudent(@RequestParam int studentId, @RequestParam int courseId) {
		Student student = studentRepository.findById(studentId)
		 .orElseThrow(()-> new RuntimeException("Student not found"));
	 Course course = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course not found"));
		
	 student.getLikedCourse().add(course);
	 
	 
	 return studentRepository.save(student);
		
		
	}
}
