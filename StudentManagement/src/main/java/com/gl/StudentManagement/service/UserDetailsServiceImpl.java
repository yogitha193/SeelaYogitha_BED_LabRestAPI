package com.gl.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.StudentManagement.entity.User;
import com.gl.StudentManagement.repository.UserRepository;
import com.gl.StudentManagement.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Could not find user");
		return new MyUserDetails(user);
	}

}
