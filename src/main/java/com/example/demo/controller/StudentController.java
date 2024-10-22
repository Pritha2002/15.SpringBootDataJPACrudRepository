package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;

@Controller
public class StudentController {

	@Autowired
	private IStudentService service;
	
	public Student singleInsert(Student s) throws Exception {
		return service.singleInsert(s);
	}
	public List<Student> multipleInsert(List<Student> s) throws Exception {
		return service.multipleInsert(s);
	}
	public Optional<Student> selectById(int id) throws Exception {
		return service.selectById(id);
	}
	public boolean studentExist(int id) throws Exception {
		return service.studentExist(id);
	}
	public List<Student> selectAll() throws Exception {
		return service.selectAll();
	}
	public List<Student> selectAllById(List<Integer> id) throws Exception {
		return service.selectAllById(id);
	}
	
	public void removeID(int id) throws Exception {
		service.removeID(id);
	}
	public void removeAll() throws Exception {
		service.removeAll();
	}
	public void removeEntity(Student s) throws Exception {
		service.removeEntity(s);
	}
	public void removeAllById(List<Integer> id) throws Exception {
		service.removeAllById(id);
	}
	public void removeAll(List<Student> s) throws Exception {
		service.removeAll(s);
	}
}
