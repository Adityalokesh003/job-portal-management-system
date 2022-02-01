package com.jpms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpms.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}
