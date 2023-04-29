package com.gl.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.StudentManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
