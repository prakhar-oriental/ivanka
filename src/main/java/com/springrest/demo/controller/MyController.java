package com.springrest.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.demo.entities.Courses;
import com.springrest.demo.services.CourseService;




@RestController
public class MyController<Courses> {
	@Autowired
	   CourseService courseservice;
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to home";
	}
  // Get the Courses
	@GetMapping("/courses")
	 public List<Courses> getCourses()
	 {
		 return (List<Courses>) this.courseservice.getCourses();
	 }
	// Get the Courses
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId)
	{
		return (Courses) ((CourseService) this.courseservice).getCourse(Long.parseLong(courseId));
	}
	// Post the Courses
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody com.springrest.demo.entities.Courses courses)
	{
		return  (Courses) this.courseservice.addCourse(courses);
	}
	// update the Courses
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody com.springrest.demo.entities.Courses courses )
	{
		return (Courses) this.courseservice.updateCourse(courses);
	}
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
		this.courseservice.deleteCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
