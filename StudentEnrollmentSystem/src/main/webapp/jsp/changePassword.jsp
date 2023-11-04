<%@page import="in.co.student.enrollment.sys.ctl.ChangePasswordCtl"%>
<%@page import="in.co.student.enrollment.sys.util.DataUtility"%>
<%@page import="in.co.student.enrollment.sys.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChangePassword</title>
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
							class="text-white" href="#">ChangePassword</a></li>
					</ol>
				</nav>
			</div>
		</nav>
		<hr>

		<br>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-6">
				<h3>ChangePassword</h3>
				<b><font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font></b> <b><font color="Green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font></b>
				<hr>
				<form method="post" action="<%=SESView.CHANGE_PASSWORD_CTL%>">

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
							class="form-label" >Old Password</label>
						<input type="password" 
							placeholder="Enter Old Password here.." class="form-control bd" name="oldPassword"
							value=<%=DataUtility
                    .getString(request.getParameter("oldPassword") == null ? ""
                            : DataUtility.getString(request
                                    .getParameter("oldPassword")))%>> <font
							color="red"><%=ServletUtility.getErrorMessage("oldPassword", request)%></font>
					</div>
					
						<div class="form-outline mb-4">
					 <label
							class="form-label" >New Password</label>
						<input type="password" 
							placeholder="Enter New Password here.." class="form-control bd" name="newPassword"
							value=<%=DataUtility.getString(request.getParameter("newPassword") == null ? ""
                            : DataUtility.getString(request.getParameter("newPassword")))%>> <font
							color="red"><%=ServletUtility.getErrorMessage("newPassword", request)%></font>
					</div>
					
						<div class="form-outline mb-4">
					 <label
							class="form-label" >Confirm Password</label>
						<input type="password" 
							placeholder="Enter Confirm Password here.." class="form-control bd" name="confirmPassword"
							value=<%=DataUtility.getString(request
                    .getParameter("confirmPassword") == null ? "" : DataUtility
                    .getString(request.getParameter("confirmPassword")))%>> <font
							color="red"><%=ServletUtility.getErrorMessage("confirmPassword", request)%></font>
					</div>

					
					<!-- Submit button -->
					<input type="submit" class="btn btn-primary  mb-4" name="operation"
						value="<%=ChangePasswordCtl.OP_SAVE%>">
				</form>
			</div>
			<div class="col-5"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>