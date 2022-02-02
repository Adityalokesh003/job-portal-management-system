package com.jpms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpms.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	List<Job> findByLocationsContainingAndActive(String str, int active);

}
