package com.gl.StudentManagement.service;

import java.util.List;

import com.gl.StudentManagement.entity.Student;

public interface StudentManagementService {

	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student theStudent);

	public void deleteById(int id);

}
