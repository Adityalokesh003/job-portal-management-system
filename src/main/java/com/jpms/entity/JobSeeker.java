package com.jpms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "job_seeker")
public class JobSeeker {
	@Id
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "profile_headline", nullable = false)
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String profileHeadline;

	@Column(name = "educational_info")
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String educationalInfo;

	@Column(name = "employment_details")
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String employmentDetails;

	@Column(name = "skills")
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String skills;

	@Column(name = "experience", nullable = true)
	@NotNull(message = "Cannot be blank")
	@Pattern(regexp = "^[0-9]{1,3}", message = "enter number on months")
	private String experienceInMonths;

	@Column(name = "job_designation", nullable = true)
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String jobDesignation;

	@Column(name = "location", nullable = false)
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String location;

	@Column(name = "contact_number", nullable = false)
	@NotNull(message = "Cannot be blank")
	@Size(min = 1, message = "required field")
	private String contactNumber;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "jobSeeker")
	private List<JobApplication> jobApplications;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id")
	private Job job;

	public JobSeeker() {

	}

	public JobSeeker(String profileHeadline, String educationalInfo, String employmentDetails, String skills,
			String experienceInMonths, String jobDesignation, String location, String contactNumber) {
		this.profileHeadline = profileHeadline;
		this.educationalInfo = educationalInfo;
		this.employmentDetails = employmentDetails;
		this.skills = skills;
		this.experienceInMonths = experienceInMonths;
		this.jobDesignation = jobDesignation;
		this.location = location;
		this.contactNumber = contactNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.user.setJobSeeker(this);
	}

	public String getProfileHeadline() {
		return profileHeadline;
	}

	public void setProfileHeadline(String profileHeadline) {
		this.profileHeadline = profileHeadline;
	}

	public String getEducationalInfo() {
		return educationalInfo;
	}

	public void setEducationalInfo(String educationalInfo) {
		this.educationalInfo = educationalInfo;
	}

	public String getEmploymentDetails() {
		return employmentDetails;
	}

	public void setEmploymentDetails(String employmentDetails) {
		this.employmentDetails = employmentDetails;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(String experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", profileHeadline=" + profileHeadline + ", educationalInfo=" + educationalInfo
				+ ", employmentDetails=" + employmentDetails + ", skills=" + skills + ", experienceInMonths="
				+ experienceInMonths + ", jobDesignation=" + jobDesignation + ", location=" + location
				+ ", contactNumber=" + contactNumber + "]";
	}

}
