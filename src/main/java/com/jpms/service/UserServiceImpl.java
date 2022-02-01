package com.jpms.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpms.dao.RoleDao;
import com.jpms.dao.UserRepository;
import com.jpms.dto.UserDTO;
import com.jpms.entity.Role;
import com.jpms.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	// @Transactional
	public User findByUserName(String userName) {
		// check the database if the user already exists
		return userRepository.findByUserName(userName);
	}

	@Override
	// @Transactional
	public User findByEmail(String email) {
		// check the database if the user already exists
		return userRepository.findByEmail(email);
	}

	@Override
	// @Transactional
	public void save(UserDTO userDTO) {
		// System.out.println(userDTO);
		User user = new User(); //
		// assign user details to the user object
		user.setUserName(userDTO.getUserName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName(userDTO.getRole())));
		// save user in the database
		userRepository.save(user);
	}

	@Override
	// @Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
