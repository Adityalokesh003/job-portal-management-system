package com.jpms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jpms.dto.UserDTO;
import com.jpms.entity.User;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	void save(UserDTO userDTO);

	User findByEmail(String email);
}
