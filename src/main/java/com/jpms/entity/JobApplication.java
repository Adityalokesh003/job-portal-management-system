package com.jpms.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_application")
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinColumn(name = "job_id")
	private Job job;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	private LocalDateTime appliedDate = LocalDateTime.now();

	public JobApplication() {
	}

	public JobApplication(Job job, JobSeeker jobSeeker, LocalDateTime appliedDate) {
		this.job = job;
		this.jobSeeker = jobSeeker;
		this.appliedDate = appliedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}

	@Override
	public String toString() {
		return "JobApplication [id=" + id + ", appliedDate=" + appliedDate + "]";
	}

}
