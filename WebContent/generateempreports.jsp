
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='searchAdmin.js'></script>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>


<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>


<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript"
	src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />


<script src="searchAdmin.js"></script>
<script src="generateempreports.js"></script>

</head>
<body>
	<%@ include file="header_admin.jsp"%>
	<jsp:include page="/ViewEmployee" />
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

		<%@ include file="common_left.jsp"%>

		<div id="content_right">
			<div class="right_col_section_w650" id="scrollable"
				style="height: 440px">

				<div class="header_01">Employee reports</div>

				<select id="select" name="select" onChange="changeTextBox();">
					<option value="default" selected>Select to generate
						reports on employee</option>
					<option value="employee">Generate report by Employee Name</option>
					<option value="designation">Generate report by
						Designation/Billability</option>
				</select>



				<div id="div1">
					<div id="search">
						<form action="EmployeeReportServlet" method="post">
							<!-- onsubmit ="return validateform()" -->
							<table>
								<tr>
									<td>EMPLOYEE NAME:</td>
									<td><select class="dropbox_size" type="text" id="empName"
										name="empname">
											<option value="">Enter a Name</option>
											<jstlcore:forEach items="${empList}" var="empList">
												<option value="${empList.empName}">
													<jstlcore:out value="${empList.empName}"></jstlcore:out>
												</option>
											</jstlcore:forEach>
											<option value="">None</option>
									</select></td>
								</tr>

								<tr>
									<td>ACTION :</td>
									<td><select class="dropbox_size" id="action" name="action">
											<option></option>
											<option>added</option>
											<option>edited</option>
											<option>deleted</option>
											<option>added by excel</option>
									</select></td>
								</tr>

								<tr>
									<td>START DATE:</td>
									<td><input class="textbox_size" type="text"
										name="startdate" id="calendar"></input></td>
								</tr>
								<tr>
									<td>END DATE:</td>
									<td><input class="textbox_size" type="text" name="enddate"
										id="calendar1"></input></td>
								</tr>
							</table>
							<br /> <br />
							<button type="submit" value="Submit" style="margin-left: 100px">Generate
								Report</button>
						</form>
						<br /> <br /> <br /> <br /> <br /> <br />
						<div class="notification">${message}</div>
						</table>
						<table>
							<tr>
								<td>
						</table>
					</div>
					<div id="ajaxResponse"></div>
				</div>
				<div id="div2">

					<div id="search">
						<form action="EmployeeReportServlet_bill" method="post">
							<!-- onsubmit ="return validateform()" -->
							<table>
								<tr>
									<td>BILLABILITY :</td>
									<td><select class="dropbox_size" id="bill" name="bill">
											<option></option>
											<option>YES</option>
											<option>NO</option>

									</select></td>
								</tr>

								<tr>
									<td>DESIGNATION</td>
									<td><select class="dropbox_size" id="desig" name="desg">
											<option></option>
											<option>ASE</option>
											<option>SE</option>
											<option>SSE</option>
											<option>TL</option>
											<option>AM</option>
											<option>M</option>
											<option>SM</option>
											<option>Leadership</option>
									</select></td>
								</tr>



								<tr>
									<td>ACTION :</td>
									<td><select class="dropbox_size" id="action" name="action">
											<option></option>
											<option>added</option>
											<option>edited</option>
											<option>deleted</option>
											<option>added by excel</option>
									</select></td>
								</tr>

								<tr>
									<td>START DATE:</td>
									<td><input class="textbox_size" type="text"
										name="startdate" id="calendar"></input></td>
								</tr>
								<tr>
									<td>END DATE:</td>
									<td><input class="textbox_size" type="text" name="enddate"
										id="calendar1"></input></td>
								</tr>
							</table>
							<br /> <br />
							<button type="submit" value="Submit" style="margin-left: 100px">Generate
								Report</button>
						</form>
						<br /> <br /> <br /> <br /> <br /> <br />
						<div class="notification">${message}</div>
						<table>




						</table>
					</div>
					<div id="ajaxResponse"></div>

				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>
			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>