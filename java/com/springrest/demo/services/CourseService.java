package com.springrest.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.demo.entities.Courses;

public interface CourseService {
	
	public List<Courses> getCourses();
	public Courses getCourse(long courseId);
	public Courses addCourse(Courses courses);
	public Courses updateCourse(Courses courses);
    public void deleteCourse(long parseLong);
	
	
}
