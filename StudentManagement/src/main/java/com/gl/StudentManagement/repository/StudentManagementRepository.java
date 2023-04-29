package com.gl.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.StudentManagement.entity.Student;

@Repository
public interface StudentManagementRepository extends JpaRepository<Student, Integer> {

}
