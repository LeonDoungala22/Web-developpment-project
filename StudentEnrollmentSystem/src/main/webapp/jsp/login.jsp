<%@page import="in.co.student.enrollment.sys.util.DataUtility"%>
<%@page import="in.co.student.enrollment.sys.ctl.LoginCtl"%>
<%@page import="in.co.student.enrollment.sys.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
	<br />
	<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #1266f1;">
		<div class="container-fluid">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a class="text-white" href="<%=SESView.WELCOME_CTL%>">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page"><a
					class="text-white"	href="#">Login</a></li>
				</ol>
			</nav>
		</div>
	</nav>
	<hr>
	<div class="container-fluid h-custom">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-md-9 col-lg-6 col-xl-5">
				<img
					src="https://mdbootstrap.com/img/Photos/new-templates/bootstrap-login-form/draw2.png"
					class="img-fluid" alt="Sample image">
			</div>
			<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
				<form method="post" action="<%=SESView.LOGIN_CTL%>">
					<jsp:useBean id="bean"
								class="in.co.student.enrollment.sys.bean.UserBean"
								scope="request"></jsp:useBean>
								
								
								<%
							String uri = (String) request.getAttribute("uri");
							%>

							<input type="hidden" name="uri" value="<%=uri%>"> <input
								type="hidden" name="id" value="<%=bean.getId()%>"> <input
								type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
							<input type="hidden" name="modifiedBy"
								value="<%=bean.getModifiedBy()%>"> <input type="hidden"
								name="createdDatetime"
								value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
							<input type="hidden" name="modifiedDatetime"
								value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
								
					
					<div
						class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
						<p class="lead fw-normal mb-0 me-3">Sign in with</p>
						<button type="button" class="btn btn-primary btn-floating mx-1">
							<i class="fab fa-facebook-f"></i>
						</button>

						<button type="button" class="btn btn-primary btn-floating mx-1">
							<i class="fab fa-twitter"></i>
						</button>

						<button type="button" class="btn btn-primary btn-floating mx-1">
							<i class="fab fa-linkedin-in"></i>
						</button>
					</div>
					
					<b><font color="red" size="2px"> <%=ServletUtility.getErrorMessage(request)%>
					</font></b> <b><font color="Green" size="2px"> <%=ServletUtility.getSuccessMessage(request)%>
					</font></b>

					<div class="divider d-flex align-items-center my-4">
						<p class="text-center fw-bold mx-3 mb-0">Or</p>
					</div>

					<!-- Email input -->
					<div class="form-outline mb-4">
					<label
							class="form-label" for="form3Example3">UserName</label>
						<input type="text" id="form3Example3" name="userName"
							class="form-control bd"
							placeholder="Enter UserName" value="<%=DataUtility.getStringData(bean.getUserName())%>" /> 
							<font color="red"><%=ServletUtility.getErrorMessage("userName", request)%></font>
					</div>

					<!-- Password input -->
					<div class="form-outline mb-3">
					<label class="form-label" for="form3Example4">Password</label>
						<input type="password" id="form3Example4" name="password"
							class="form-control  bd" placeholder="Enter password" value="<%=DataUtility.getStringData(bean.getPassword())%>" />
						
						<font color="red"><%=ServletUtility.getErrorMessage("password", request)%></font>
					</div>

					<div class="d-flex justify-content-between align-items-center">
						<!-- Checkbox -->
						<input type="submit" class="btn btn-primary btn-lg" name="operation"
									value="<%=LoginCtl.OP_SIGN_IN%>"
							style="padding-left: 2.5rem; padding-right: 2.5rem;">
						
					</div>

				

				</form>
			</div>
		</div>
	</div>
	</div>
	<br />
	<br />
	<%@ include file="footer.jsp"%>
</body>
</html>