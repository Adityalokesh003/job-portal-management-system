package com.jpms.service;

import java.util.List;
import java.util.Optional;

import com.jpms.entity.Recruiter;

public interface RecruiterService {
	List<Recruiter> findAll();

	Optional<Recruiter> findById(Long recruiterId);

	Recruiter save(Recruiter recruiter);

	Recruiter findByUserId(Long id);

}
