<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Job - at ${job.postedBy.companyName }</title>
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
	<ul class="nav">
			<c:if test="${recruiterId!=null }">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="${pageContext.request.contextPath}/recruiters/${recruiterId}">Home</a></li>

				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="${pageContext.request.contextPath}/recruiters/${recruiterId }/showUpdateProfileForm">Recruiter
						Profile</a></li>





				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/recruiters/${recruiterId }/jobs/">
						Jobs </a></li>
			</c:if>
			<li><form:form
					action="${pageContext.request.contextPath }/logout" method="POST">
					<input type="submit" value="Logout">
				</form:form></li>



		</ul>
	 
		<h1 style="padding-left: 100px;">Job Details Form</h1>
		<p style="padding-left: 100px;">Please Fill all details and Submit</p>
		<form:form method="POST"
			action="${pageContext.request.contextPath }/recruiters/${recruiterId }/jobs/add"
			modelAttribute="job">
			<form:hidden path="id"/>
			<div class="mb-3 custom-input">
				<label class="form-label">Job Role</label> <br>
				<form:errors path="jobRole" class="error" />
				<form:input path="jobRole"
					placeholder="Enter Job Role (*)" class="form-control" />
			</div>

			<div class="mb-3 custom-input">
				<label class="form-label">Job Description</label> <br>
				<form:errors path="jobDescription" class="error" />
				<form:input path="jobDescription"
					placeholder="Enter job description (*)" class="form-control" />
			</div>
			
			<div class="mb-3 custom-input">
				<label class="form-label">Locations</label> <br>
				<form:errors path="locations" class="error" />
				<form:input path="locations"
					placeholder="Enter locations (ex: Pune, Delhi) (*)" class="form-control" />
			</div>
			
			<div class="mb-3 custom-input">
				<label class="form-label">Required Experience</label> <br>
				<form:errors path="requiredExperience" class="error" />
				<form:input path="requiredExperience"
					placeholder="Enter required experience (*)" class="form-control" />
			</div>
			
			<div class="mb-3 custom-input">
				<label class="form-label">Salary Information</label> <br>
				<form:errors path="salaryInfo" class="error" />
				<form:input path="salaryInfo"
					placeholder="Enter Salary Range (*)" class="form-control" />
			</div>
			<div class="mb-3 custom-input">
				<label class="form-label">Skills Required</label> <br>
				<form:errors path="skillsRequired" class="error" />
				<form:input path="skillsRequired"
					placeholder="Enter Skills Required (*)" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary custom-input">Save</button>
		</form:form>

	</div>


</body>
</html>