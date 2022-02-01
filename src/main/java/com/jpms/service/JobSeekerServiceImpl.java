package com.jpms.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpms.dao.JobSeekerRepository;
import com.jpms.dao.UserRepository;
import com.jpms.entity.JobSeeker;
import com.jpms.entity.User;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public JobSeeker save(JobSeeker jobSeeker, long userId) {
		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(jobSeeker);
		// session.saveOrUpdate(user);

		return jobSeeker;
	}

	@Override
	public JobSeeker findByUserId(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.getById(userId);

		return user.getJobSeeker();
	}

	@Override
	public Optional<JobSeeker> findById(Long recruiterId) {
		return jobSeekerRepository.findById(recruiterId);
	}

}
