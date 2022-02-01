package com.jpms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);

	User findByEmail(String email);

}
