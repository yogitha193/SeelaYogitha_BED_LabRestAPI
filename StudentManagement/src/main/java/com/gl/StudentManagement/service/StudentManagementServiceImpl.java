package com.gl.StudentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.StudentManagement.entity.Student;
import com.gl.StudentManagement.repository.StudentManagementRepository;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {

	@Autowired
	private StudentManagementRepository studentRepository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).get();
		if (student == null)
			throw new RuntimeException("Did not find the student id: " + id);
		else
			return student;
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}
