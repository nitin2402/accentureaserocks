<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="admintool.js"></script> 

 <script type='text/javascript' src='search.js'></script>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>

<body>

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
			
			<%@ include file="common_left.jsp" %>
			
			<div id="content_right">
				<div class="right_col_section_w650" style="height: 500px">
				
  					<div id = "search">
  					<div id="scrollable" style="font-size: 14px;height: 450px;">
  					<table class="table2 table_align" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>EMPLOYEE ID</td>
								<td>EMPLOYEE NAME</td>
								
								<td>EMPLOYEE DESIGNATION</td>
								<td>EMPLOYEE EXPERTISE</td>
								<td>EMPLOYEE LEVEL</td>
								<td>CLIENT ID</td>
								<td>EMAIL</td>
								<td>TEAM </td>
								<td>PROFICIENCY CAMS</td>
								<td>PROFICIENCY PROJECT</td>
								<td>DATE OF JOINING</td>
								<td>LAST WORKING DATE</td>
								<td>BILLABLE</td>
								<td>ACITVE USER</td>
								<td>LCR</td>
								<td>USERNAME</td>
								<td>ACTION</td>
								<td>AUTHORIZED AS</td>
								<td>TIMESTAMP</td>
							</tr>
							</thead>
							<tbody  >
				<jstlcore:forEach items="${EmpList}" var="item">
								<tr>
									<td><jstlcore:out value="${item.empId}" /></td>
									<td><jstlcore:out value="${item.empName}" /></td>
									<td><jstlcore:out value="${item.designation}" /></td>
									<td><jstlcore:out value="${item.expertise}" /></td>
									<td><jstlcore:out value="${item.level}" /></td>
									<td><jstlcore:out value="${item.clientId}" /></td>
									<td><jstlcore:out value="${item.email}" /></td> 
									<%-- <td><jstlcore:out value="${item.teamId}" /></td>  --%>
									<td><jstlcore:out value="${item.teamName}" /></td> 
									<td><jstlcore:out value="${item.profCamps}" /></td> 
									<td><jstlcore:out value="${item.profProject}" /></td>
									<td><jstlcore:out value="${item.doj}" /></td>
									<td><jstlcore:out value="${item.lastWD}" /></td>
									<td><jstlcore:out value="${item.isBillable}" /></td>
									<td><jstlcore:out value="${item.isActive}" /></td>
									<td><jstlcore:out value="${item.cost}" /></td>
									<td><jstlcore:out value="${item.userName}" /></td> 
									<td><jstlcore:out value="${item.action}" /></td> 
									<td><jstlcore:out value="${item.authorizedAs}" /></td> 
									<td><jstlcore:out value="${item.timeStamp}" /></td> 
									
								</tr>
				</jstlcore:forEach></tbody></table>
					
				</div>
				<div align="center"><a href="mainreports.jsp" style="color : yellow ;">BACK</a></div>
				<p style="font-size: 14px; color: white; margin:22px"><%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%></p>
				<div>
				<br />
				<br />
					<br />
					<br />
					<br />
					<br />
					<div class="notification">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>
			
				</div>
				<div id="ajaxResponse"></div>
				<div class="margin_bottom_20">&nbsp;</div>
				
			</div>
			<div class="cleaner">&nbsp;</div>
		</div>
	
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>