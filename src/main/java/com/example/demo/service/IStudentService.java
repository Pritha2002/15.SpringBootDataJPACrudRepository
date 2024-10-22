package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Student;

public interface IStudentService {
	public Student singleInsert(Student s) throws Exception;
	public List<Student> multipleInsert(List<Student> s) throws Exception;
	public Optional<Student>  selectById(int id) throws Exception;
	public boolean studentExist(int id) throws Exception;
	public List<Student> selectAll() throws Exception;
	public List<Student> selectAllById(List<Integer> id) throws Exception;
	public void removeID(int id) throws Exception;
	public void removeAll() throws Exception;
	public void removeEntity(Student s) throws Exception;
	public void removeAllById(List<Integer> id) throws Exception;
	public void removeAll(List<Student> s) throws Exception;
}
