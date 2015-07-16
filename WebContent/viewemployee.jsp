
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!-- <script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script> -->


<script type='text/javascript' src='search.js'></script>

</head>
<body>

<%@ include file="header_admin.jsp" %>  
	<jsp:include page="/ViewEmployee"/>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/* || (Boolean) session1.getAttribute("admin") != true */) {
	%><jsp:forward page="home.jsp?msg=Please Login as an Admin" />
	<%
		}
	%>
	
	
	<div id="templatemo_content">
	<%@ include file="common_left_admintool.jsp"%>
		
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Employee Details</div>


				<div id="search">


					<div id="scrollable"   style="font-size: 14px;">
						<table class="table2" >
							
							<thead style="font-weight:bold;position: ">
							<tr class="one table_align" style="font-weight:bold;">
								<td></td>
								<td>Employee Id</td>
								<td>Employee Name</td>
								<td>Employee Designation</td>
								<td>Employee Level</td>
								<td>Employee Expertise</td>
								<td>Employee Client Id</td>
								<td>Employee Email</td>
								<td>Team Name</td>
								<td>Proficiency CAMS</td>
								<td>Proficiency Project</td>
								<td>Date of Joining</td>
								<!-- <td>Last Working Date</td> -->
								<td>Billable</td>
								<!-- <td>Active User</td> -->
								
							
							</tr>
							</thead>
						
							<tbody>
							<jstlcore:forEach items="${empList}" var="item" >
								<tr class="table_align">
									<td><input type="radio" name="employeeDetails" value=""></input></td>
									
								
									<td><jstlcore:out value="${item.empId}" /></td>
									<td><jstlcore:out value="${item.empName}" /></td>
									<td><jstlcore:out value="${item.designation}" /></td>
									<td><jstlcore:out value="${item.level}" /></td>
									<td><jstlcore:out value="${item.expertise}" /></td>
									<td><jstlcore:out value="${item.clientId}" /></td>
									<td><jstlcore:out value="${item.email}" /></td>
									<td><jstlcore:out value="${item.teamName}" /></td>
									<td><jstlcore:out value="${item.profCamps}" /></td>
									<td><jstlcore:out value="${item.profProject}" /></td>
									<td><jstlcore:out value="${item.doj}" /></td>
									<%-- <td><jstlcore:out value="${item.lastWD}" /></td> --%>
									<td><jstlcore:out value="${item.isBillable}" /></td>
									<%-- <td><jstlcore:out value="${item.isActive}" /></td> --%>
								</tr>
							</jstlcore:forEach></tbody></table>
							
						


					</div>
					
<br></br>
				<div>
				
				<!-- <input type="submit" id="" onclick="" value="Edit"></input>
				<input type="submit" id="" onclick="" value="Delete"></input> -->
				</div>

					<div>${msg1}</div>
				
					<p class="error" style="font-size: 14px; color: red;">${message}</p>

					<div class="cleaner">&nbsp;</div>
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