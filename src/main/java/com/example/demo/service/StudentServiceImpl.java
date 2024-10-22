package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IStudentDAO;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDAO dao;
	
	@Override
	public Student singleInsert(Student s) throws Exception {
		return dao.save(s);
	}

	@Override
	public List<Student> multipleInsert(List<Student> s) throws Exception {
		return (List<Student>) dao.saveAll(s);
	}

	@Override
	public Optional<Student> selectById(int id) throws Exception {
		return dao.findById(id);
	}

	@Override
	public boolean studentExist(int id) throws Exception {
		return dao.existsById(id);
	}

	@Override
	public List<Student> selectAll() throws Exception {
		return (List<Student>) dao.findAll();
	}

	@Override
	public List<Student> selectAllById(List<Integer> id) throws Exception {
		return (List<Student>) dao.findAllById(id);
	}

	@Override
	public void removeID(int id) throws Exception {
		dao.deleteById(id);
	}

	@Override
	public void removeAll() throws Exception {
		dao.deleteAll();
	}

	@Override
	public void removeEntity(Student s) throws Exception {
		dao.delete(s);
	}

	@Override
	public void removeAllById(List<Integer> id) throws Exception {
		dao.deleteAllById(id);
	}

	@Override
	public void removeAll(List<Student> s) throws Exception {
		dao.deleteAll(s);
	}
}
