package com.springrest.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.demo.dao.CourseDao;
import com.springrest.demo.entities.Courses;
@Service
public class CourseSericeimpl implements CourseService {
   
	@Autowired
	private CourseDao coursesdao;
	//List<Courses> list;
	public CourseSericeimpl() {
//		list = new ArrayList<>();
//		list.add(new Courses(123,"java course","It is best"));
//		list.add(new Courses(121,"Spring course","It is aswm"));
//		list.add(new Courses(234,"Django course","It is for python"));
//		list.add(new Courses(231,"React course","It is for frontend"));
	}
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return coursesdao.findAll();
	}
	public Courses getCourse(long courseId)
	{
//		Courses c = null;
//		for(Courses courses:list)
//		{
//			 if(courses.getId()==courseId)
//			 {
//				 c = courses;
//				 break;
//			 }
//		}
		Courses f = coursesdao.getById(courseId);
		return f;
	}
	
	
	public Courses addCourse(Courses courses)
	{
		//list.add(courses);
		coursesdao.save(courses);
		return courses;
		
	}
	@Override
	public Courses updateCourse(Courses courses) {
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId()== courses.getId())
//			{
//				e.setId(courses.getId());
//				e.setTitle(courses.getTitle());
//				e.setDescription(courses.getDescription());
//			}
//			
//			
//		});
//		for(Courses cou:list)
//		{
//			if(cou.getId()== courses.getId())
//				{
//				cou.setId(courses.getId());
//				cou.setTitle(courses.getTitle());
//				cou.setDescription(courses.getDescription());
//					}
//		}
		coursesdao.save(courses);
		return courses;
	}
	
	@Override
	public void deleteCourse(long parseLong)
	{
		//list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Courses entity = coursesdao.getById(parseLong);
		coursesdao.delete(entity);
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
