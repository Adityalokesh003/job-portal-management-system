package com.jpms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Recruiter {

	private Long id;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String companyName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@Pattern(regexp = "^+91[0-9]{10}", message = "Enter valid phone number")
	private String contactNumber;

	public Recruiter() {

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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
