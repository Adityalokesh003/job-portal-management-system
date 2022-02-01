package com.jpms.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpms.dao.RecruiterRepository;
import com.jpms.dao.UserRepository;
import com.jpms.entity.Recruiter;
import com.jpms.entity.User;

@Service
public class RecruiterServiceImpl implements RecruiterService {
	@Autowired
	private RecruiterRepository recruiterRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public Recruiter save(Recruiter recruiter) {
		entityManager.unwrap(Session.class).saveOrUpdate(recruiter);
		return recruiter;
	}

	@Override
	public List<Recruiter> findAll() {
		// TODO Auto-generated method stub

		return recruiterRepository.findAll();
	}

	@Override
	public Optional<Recruiter> findById(Long recruiterId) {
		// TODO Auto-generated method stub
		return recruiterRepository.findById(recruiterId);
	}

	@Override
	public Recruiter findByUserId(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.getById(userId);

		return user.getRecruiter();
	}

}
