<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='admintool.js'></script>
<script type='text/javascript' src='search.js'></script>
  <script type='text/javascript' src='authorizeemployee.js'></script> 
</head>
<body>

<jsp:include page="/AuthorizeEmployeeServlet" />
	<%@ include file="header_admin.jsp" %>
	<%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />

	<%
		}
	%>




	<div id="templatemo_content">

	
<%@ include file="common_left_admintool.jsp" %>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Authorize Employee</div>
				<h2 style="color:white;">Unauthorized Employees</h2>
				<form name="authorizeForm" method="post" action="TypeOfUserServlet" >
				<div id="scrollable"   style="font-size: 14px; height:165px;">
						
						
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr  class="one" style="font-weight:bold;">
								<td>Select</td>
								<td>User Name</td>
								<td>Type Of User</td>
								<td>Employee Id</td>
								<td>Employee Designation</td>	
							</tr>
							</thead>
						
							<tbody>
							
							<jstlcore:forEach items="${unauthorized_employees}" var="item" >
								<tr class="table_align">
									 <td><input type="radio" id="select" name="select" value="${item.loginid}"/></td>
									 
									<td><jstlcore:out  value="${item.username}" /></td>
									<td><jstlcore:out  value="${item.userType}" /></td>
									<td><jstlcore:out  value="${item.employeeId}" /></td>
									<td><jstlcore:out value="${item.employeedesignation}"/></td>
									</tr>
									<input type="hidden" name="employeeid" value="${item.loginid}"/> 
									<input type="hidden" id="${item.loginid}" value="${item.employeedesignation}" />
										
							</jstlcore:forEach></tbody></table>
							</div>
							<input type="submit"  name="action" value="Admin" onclick="return validateAdmin()"/>
							<input type="submit" name="action" value="User" onclick="return validateUser()" />
							<input type="submit" name="action" value="Viewer" onclick="return validateViewer()" />
							 <a href="admintool.jsp"style="font-size:14px;border: medium none;background-color: transparent;padding-top: 0px;position: relative;top: 7px;
    text-decoration: underline;font-weight:normal;" >Cancel</a>
							
						
				</form>


				<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;line-height:75px;">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>
		</div>
			</div>
			<%@ include file="footer.jsp" %> 
			 
			</body>  
</html>