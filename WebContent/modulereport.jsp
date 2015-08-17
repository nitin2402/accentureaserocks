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

<script src="modulereport.js"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='search.js'></script>

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>



<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>


<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript"
	src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />
<script src="jquery.chained.js"></script>
<script>
	$(function(){$("#mdl").chained("#prj");
	$("#tem").chained("#mdl")});
</script>
</head>

<body>
	<jsp:include page="/DropDownDetails" />

	<%@ include file="header_admin.jsp"%>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null || (String) session1.getAttribute("user") == null
				|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
		}
	%>
	<div id="templatemo_content">

		<%@ include file="common_left.jsp"%>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Reports Generated for Module</div>


				<div id="search">
					<form name="modulereport" action="ModuleReportServlet"
						method="post" onsubmit="return validateform()" >
						<table>
							<tr>
								<td> PROJECT :</td>
								<td><select id="prj" class="chain" name="project"
									style="width: 143px">
									<option value="">--Please select--</option>
										<jstlcore:forEach items="${project}" var="prj_item">

											<option value="${prj_item.projectId}">
												<jstlcore:out value="${prj_item.projectName}"></jstlcore:out></option>


										</jstlcore:forEach>

								</select></td>
							</tr>

							<tr>
								<td> MODULE :</td>
								<td><select id="mdl" class="chain" name="module"
									style="width: 143px">
									<option value="">--Please select--</option>
										<jstlcore:forEach items="${module}" var="mod_item">

											<option value="${mod_item.moduleName}"
												class="${mod_item.projectId}">
												<jstlcore:out value="${mod_item.moduleName}"></jstlcore:out></option>


										</jstlcore:forEach>

								</select></td>
							</tr>
							<tr>
								<td>ACTION :</td>
								<td>
								<select  id="action" name="action">
										<option ></option>
										<option >added</option>
										<option >edited</option>
										<option >deleted</option>
								</select></td>
							</tr>



							<tr>
								<td>START DATE :</td>
								<td><input type="text" id="calendar" name="startDate" /></td>
							</tr>
							<tr>
								<td>END DATE :</td>
								<td><input type="text" id="calendar1" name="endDate" /></td>
							</tr>
						</table>
						<br />

						<button type="submit" value="Submit" style="margin-left: 100px">Generate
							Report</button>

					</form>
					<br /> <br /> <br /> <br /> <br /> <br />
					<div class="notification">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>
				<div id="ajaxResponse"></div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>