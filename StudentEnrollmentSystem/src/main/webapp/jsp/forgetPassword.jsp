
<%@page import="in.co.student.enrollment.sys.ctl.ForgetPasswordCtl"%>
<%@page import="in.co.student.enrollment.sys.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
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
							class="text-white" href="#">Forget Password</a></li>
					</ol>
				</nav>
			</div>
		</nav>
		<hr>

		<br>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-6">
				<h3>Forget Password</h3>
				<b><font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font></b> <b><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font></b>
				<hr>
				<form method="post" action="<%=SESView.FORGET_PASSWORD_CTL%>">

					

					<!-- Email input -->
					<div class="form-outline mb-4">
					 <label
							class="form-label" >UserName</label>
						<input type="text" 
							placeholder="Enter UserName here.." class="form-control bd" name="userName"
							value="<%=ServletUtility.getParameter("userName", request)%>"> <font
							color="red"><%=ServletUtility.getErrorMessage("userName", request)%></font>
					</div>
					
					

					
					<!-- Submit button -->
					<input type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=ForgetPasswordCtl.OP_GO%>">
				</form>
			</div>
			<div class="col-5"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>