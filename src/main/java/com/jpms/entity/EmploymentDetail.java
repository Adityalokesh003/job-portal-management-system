package com.jpms.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
//@Table(name = "employment_detail")
public class EmploymentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "job_designation", nullable = false)
	private String jobDesignation;

	@Column(name = "joining_date", nullable = false)
	private String joiningDate;

	@Column(name = "end_date", nullable = true)
	private String endDate;

	@Column(name = "tech_stack_used")
	private String techStackUsed;

	public EmploymentDetail() {

	}

	public EmploymentDetail(String companyName, String jobDesignation, String joiningDate, String endDate,
			String techStackUsed) {
		this.companyName = companyName;
		this.jobDesignation = jobDesignation;
		this.joiningDate = joiningDate;
		this.endDate = endDate;
		this.techStackUsed = techStackUsed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobDesignation() {
		return jobDesignation;
	}

	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTechStackUsed() {
		return techStackUsed;
	}

	public void setTechStackUsed(String techStackUsed) {
		this.techStackUsed = techStackUsed;
	}

	@Override
	public String toString() {
		return "EmploymentDetail [id=" + id + ", companyName=" + companyName + ", jobDesignation=" + jobDesignation
				+ ", joiningDate=" + joiningDate + ", endDate=" + endDate + ", techStackUsed=" + techStackUsed + "]";
	}

}
