
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='searchAdmin.js'></script>
<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script type="text/javascript">
	$(function() {
		$('.last').click(
				function(event) {
					var email = 'chinu.mohanty@accenture.com';
					var subject = 'Feedback';
					var emailBody = 'Hi Chinu,';
					window.location = 'mailto:' + email + '?subject=' + subject
							+ '&body=' + emailBody;
				});
	});
</script>
<script>
	$(document).ready(function() {

		$("#ViewempCss").css({

			"font-weight" : "bold",
			"text-decoration" : "underline"
		});
	});
</script>


</head>
<body><%@ include file="header_admin.jsp"%>


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

		<%@ include file="common_left_admintool.jsp"%>

		<div id="content_right">

			<div id="search" class="right_col_section_w650">

				<div class="header_01">Edit Employee</div>




				<form action="EditEmployee" method="post">

					<jstlcore:forEach items="${editemp}" var="list">


						<table>
							<tr>
								<td>EMPLOYEE ID:</td>
								<td><input type="text" value="${list.empId}"
									disabled="disabled" style="width: 200px;" /> <input
									type="hidden" name="EmployeeId" value="${list.empId}" /></td>

							</tr>
							<tr>
								<td>EMPLOYEE NAME:</td>
								<td><input type="text" name="EmployeeName"
									value="${list.empName}" style="width: 200px;" /></td>

							</tr>

							<tr>
								<td>DESIGNATION:</td>
								<td><input type="text" name="EmployeeDesignation"
									value="${list.designation}" style="width: 200px;" /></td>
							</tr>

							<tr>
								<td>LEVEL:</td>
								<td><input type="text" name="EmployeeLevel"
									value="${list.level}" style="width: 200px;" /></td>
							</tr>

							<tr>
								<td>EXPERTISE:</td>

								<td><input type="text" name="EmployeeExpertise"
									value="${list.expertise}" style="width: 200px;" /></td>
							</tr>
							<tr>
								<td>CLIENT ID:</td>
								<td><input type="text" name="EmployeeClientId"
									value="${list.clientId}" style="width: 200px;" /></td>

							</tr>
							<tr>
								<td>EMAIL:</td>
								<td><input type="text" name="EmployeeEmail"
									value="${list.email}" style="width: 200px;" /></td>

							</tr>

							<tr>
								<td>TEAM NAME:</td>
								<td><input type="text" name="TeamName"
									value="${list.teamName}" disabled="disabled"
									style="width: 200px;" /></td>
								<td><input type="hidden" name="TeamName"
									value="${list.teamName}" /></td>
							</tr>

							<tr>
								<td>PROFICIENCY CAMS:</td>
								<td><input type="text" name="ProficiencyCams"
									value="${list.profCamps}" style="width: 200px;" /></td>

							</tr>

							<tr>
								<td>PROFICIENCY PROJECT:</td>
								<td><input type="text" name="ProficiencyProject"
									value="${list.profProject}" style="width: 200px;" /></td>

							</tr>

							<tr>
								<td>DATE OF JOINING:</td>
								<td><input type="text" name="DateofJoining"
									value="${list.doj}" style="width: 200px;" /></td>

							</tr>

							<tr>
								<td>BILLABILITY:</td>
								<td><input type="text" name="Billable"
									value="${list.isBillable}" style="width: 200px;" /></td>

							</tr>


							<tr>
								<td><input type="submit" value="Change" /></td>
							</tr>
						</table>

					</jstlcore:forEach>


				</form>

				<div class="cleaner">&nbsp;</div>


				<div class="margin_bottom_20">&nbsp;</div>
			</div>



		</div>
		<div class="cleaner">&nbsp;</div>

		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>





