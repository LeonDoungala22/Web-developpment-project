
<%@page import="in.co.student.enrollment.sys.ctl.UserRegistrationCtl"%>
<%@page import="in.co.student.enrollment.sys.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.student.enrollment.sys.util.DataUtility"%>
<%@page import="in.co.student.enrollment.sys.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<br />
		<nav class="navbar navbar-expand-lg navbar-light "
			style="background-color: #1266f1;">
			<div class="container-fluid">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a class="text-white"
							href="<%=SESView.WELCOME_CTL%>">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page"><a
							class="text-white" href="#">User Registration</a></li>
					</ol>
				</nav>
			</div>
		</nav>
		<hr>

		<br>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-6">
				<h3>User Registration</h3>
				<b><font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font></b> <b><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font></b>
				<hr>
				<form method="post" action="<%=SESView.USER_REGISTRATION_CTL%>">

					<jsp:useBean id="bean" class="in.co.student.enrollment.sys.bean.UserBean"
						scope="request"></jsp:useBean>

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedBy()%>"> <input type="hidden"
						name="createdDatetime"
						value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
					<input type="hidden" name="modifiedDatetime"
						value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

					<!-- Email input -->
					<div class="form-outline mb-4">
					 <label
							class="form-label" >Name</label>
						<input type="text" 
							placeholder="Enter Name here.." class="form-control bd" name="name"
							value="<%=DataUtility.getStringData(bean.getName())%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("name", request)%></font>
					</div>
					
					<div class="row mb-4">
						<div class="col">
						
							<div class="form-outline">
							<label class="form-label" for="form3Example3">User Name</label>
								<input type="text" id="form3Example3"
									placeholder="Enter User Name here.." class="form-control bd"
									name="userName" 
									value="<%=DataUtility.getStringData(bean.getUserName())%>">
								
								<font color="red"><%=ServletUtility.getErrorMessage("userName", request)%></font>
							</div>
						</div>
						<div class="col">
							<div class="form-outline">
							<label class="form-label" >Password</label> 
								<input type="password"
									placeholder="Enter Password here.." class="form-control bd"
									name="password"
									value="<%=DataUtility.getStringData(bean.getPassword())%>">
								<font
									color="red"><%=ServletUtility.getErrorMessage("password", request)%></font>
							</div>
						</div>
					</div>

					<div class="row mb-4">
						<div class="col">
							<div class="form-outline">
							<label class="form-label" >Email Id</label> 
								<input type="text" 
									placeholder="Enter Email Id here.." class="form-control bd"
									name="email" 
									value="<%=DataUtility.getStringData(bean.getEmail())%>">
								<font
									color="red"><%=ServletUtility.getErrorMessage("email", request)%></font>
							</div>
						</div>

						<div class="col">
							<div class="form-outline">
							<label class="form-label" >Contact No</label>
								<input type="text" 
									placeholder="Enter Contact No here.." class="form-control bd"
									name="contactNo" 
									value="<%=DataUtility.getStringData(bean.getContactNo())%>">
								
								<font color="red"><%=ServletUtility.getErrorMessage("contactNo", request)%></font>
							</div>
						</div>
					</div>
					
					<% 
						
						HashMap<String,String> genderMap= new HashMap<String,String>();
						genderMap.put("Male","Male");
						genderMap.put("Female","Female");
					
					%>

					<div class="row mb-4">
						<div class="col">
							<div class="form-outline">
							<label class="form-label" >DOB</label>
								<input type="text" 
									placeholder="Enter DOB here.." class="form-control bd"
									name="dob" id="datepicker"
									value="<%=DataUtility.getDateString(bean.getDob())%>">
								<font color="red"><%=ServletUtility.getErrorMessage("dob", request)%></font>
							</div>
						</div>

						<div class="col">
							<div class="form-outline">
							<label class="form-label" >Gender</label> 
							<%=HTMLUtility.getList("gender",String.valueOf(bean.getGender()), genderMap) %>
								<font
									color="red"><%=ServletUtility.getErrorMessage("gender", request)%></font>
							</div>
						</div>
					</div>

					<!-- Submit button -->
					<input type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=UserRegistrationCtl.OP_SIGN_UP%>">&nbsp;&nbsp; <input
						type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=UserRegistrationCtl.OP_RESET%>">
				</form>
			</div>
			<div class="col-5"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>