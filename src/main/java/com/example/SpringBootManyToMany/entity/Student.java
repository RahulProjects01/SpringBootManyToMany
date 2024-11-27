package com.example.SpringBootManyToMany.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;

	@JsonIgnoreProperties(value = "likes")
	@ManyToMany
	@JoinTable(name = "student_courses", joinColumns = {
			@JoinColumn(name = "student_id", referencedColumnName = "studentId") }, inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
	private List<Course> likedCourse;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getLikedCourse() {
		return likedCourse;
	}

	public void setLikedCourse(List<Course> likedCourse) {
		this.likedCourse = likedCourse;
	}
}
