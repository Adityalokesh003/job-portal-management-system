<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker Profile Form</title>
<style type="text/css">
.error {
	color: red;
}

.custom-input {
	margin: 20px 100px;
	width: 400px
}
</style>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		 
		<form:form action="${pageContext.request.contextPath }/logout"
			method="POST">
			<input type="submit" value="Logout">
		</form:form>
		<h1 style="padding-left: 100px;">Job Seeker Profile</h1>
		<p style="padding-left: 100px;">Please Fill all details and Submit</p>
		<form:form method="POST"
			action="${pageContext.request.contextPath }/jobseekers/save"
			modelAttribute="jobSeeker">
			<form:hidden path="id" />
			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Profile Headline</label> <br>
				<form:errors path="profileHeadline" class="error" />
				<form:input path="profileHeadline"
					placeholder="Enter Profile Headline (*)" class="form-control" />
			</div>

			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Job Designation</label> <br>
				<form:errors path="jobDesignation" class="error" />
				<form:input path="jobDesignation"
					placeholder="Enter Your Job Designation (*)" class="form-control" />
			</div>
			
			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Location</label> <br>
				<form:errors path="location" class="error" />
				<form:input path="location"
					placeholder="Enter your location (*)" class="form-control" />
			</div>

			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Contact Number</label> <br>
				<form:errors path="contactNumber" class="error" />
				<form:input path="contactNumber"
					placeholder="Enter Your Contact Number (*)" class="form-control" />
			</div>
			
			
			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Educational Info</label> <br>
				<form:errors path="educationalInfo" class="error" />
				<form:input path="educationalInfo"
					placeholder="Enter your educational info (*)" class="form-control" />
			</div>

			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Employment Details</label> <br>
				<form:errors path="employmentDetails" class="error" />
				<form:input path="employmentDetails"
					placeholder="Enter Your Employment Details (*)" class="form-control" />
			</div>
			
						<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Skills</label> <br>
				<form:errors path="skills" class="error" />
				<form:input path="skills"
					placeholder="Enter your skills (*)" class="form-control" />
			</div>

			<div class="mb-3 custom-input">
				<label for="exampleInputEmail1" class="form-label">Experience(in months)</label> <br>
				<form:errors path="experienceInMonths" class="error" />
				<form:input path="experienceInMonths"
					placeholder="Enter Your Experience (*)" class="form-control" />
			</div>


			<button type="submit" class="btn btn-primary custom-input">Save</button>
		</form:form>

	</div>


</body>
</html>