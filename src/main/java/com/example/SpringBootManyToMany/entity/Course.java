package com.example.SpringBootManyToMany.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String name;
	

	@JsonIgnoreProperties(value = "likedCourse")
	@ManyToMany(mappedBy = "likedCourse")
	private List<Student> likes;


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Student> getLikes() {
		return likes;
	}


	public void setLikes(List<Student> likes) {
		this.likes = likes;
	}
	
	
}
