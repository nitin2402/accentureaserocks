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
<script src="jquery.chained.js"></script>


<link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type='text/javascript' src='addempmanually.js'></script>

<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript"
	src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />
<script type='text/javascript' src='search.js'></script>
</head>
<body>
	<jsp:include page="/DropDownDetails" />

	<%@ include file="header_admin.jsp"%>
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

				<div class="header_01">Employee Addition</div>


				<div id="search">

					<div style="font-size: 14px;">

						<form name="add" action="AddEmployeeManual" method="post"
							onsubmit="return validateform()">
							<table>
								<tr>
									<td><span style="color: Red;">* </span>EMPLOYEE NAME :</td>
									<td><input type="text" name="name"></input></td>

								</tr>
								<tr>
									<td><span style="color: Red;">* </span>EMPLOYEE ID:</td>
									<td><input type="text" name="idno"onkeypress="return IsNumeric1(event);"></input></td>
									<span id="error" style="color: Black; display: none">
										*Input digits (0 - 9)</span>

								</tr>
								
								<tr>
									<td><span style="color: Red;">* </span>EMPLOYEE LEVEL:</td>
									<td><select type="text" name="level" id="level">
										 
										  <option value="12">12</option>
										  <option value="11">11</option>
										  <option value="10">10</option>
										  <option value="09">09</option>
										  <option value="08">08</option>
										  <option value="07">07</option>
										  <option value="06">06</option>
										  <option value="Leadership">Leadership</option>
										</select></td>
								</tr>
								
								<tr>
									<td><span style="color: Red;">* </span>EMPLOYEE	DESIGNATION:</td>
									<td><select type="text" name="desig" id="desig">
										 
										  <option value="ASE" class="12">ASE</option>
										  <option value="SE" class="11">SE</option>
										  <option value="SSE" class="10">SSE</option>
										  <option value="TL" class="09">TL</option>
										  <option value="AM" class="08">AM</option>
										  <option value="Manager" class="07">Manager</option>
										  <option value="Senior Manager" class="06">Senior Manager</option>
										  <option value="Leadership" class="Leadership">Leadership</option>
										</select></td>
								</tr>
								<tr>
													
									<td><span style="color: Red;">* </span>EMPLOYEE EXPERTISE:</td>

									<td><input type="text" name="area"></input></td>
								</tr>
								<tr>
									<td>&nbsp; CLIENT ID:</td>
									<td><input type="text" name="client"></input></td>
								</tr>
								<tr>
									<td><span style="color: Red;">* </span>EMAIL:</td>
									<td><input type="text" name="email"></input></td>
								</tr>
								<tr>
									<td>&nbsp; PROJECT</td>
									<td><select id="prj" class="chain" name="project"
										style="width: 143px">
											<jstlcore:forEach items="${project}" var="prj_item">

												<option value="${prj_item.projectId}">
													<jstlcore:out value="${prj_item.projectName}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr>

								<tr>
									<td>&nbsp; MODULE</td>
									<td><select id="mdl" class="chain" name="module"
										style="width: 143px">
											<jstlcore:forEach items="${module}" var="mod_item">

												<option value="${mod_item.moduleId}"
													class="${mod_item.projectId}">
													<jstlcore:out value="${mod_item.moduleName}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr>
								<tr>
									<td>&nbsp; TEAM</td>
									<td><select name="Team" style="width: 143px" class="chain"
										id="tem">
											<jstlcore:forEach items="${team}" var="item">

												<option value="${item.teamId}" class="${item.moduleId}">
													<jstlcore:out value="${item.teamName}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr>
								<tr>
									<td><span style="color: Red;">* </span>PROFICIENCY CAMS:</td>
									<td><input type="text" name="camps"></input></td>
								</tr>
								<tr>
									<td>&nbsp; PROFICIENCY PROJECT:</td>
									<td><input type="text" name="Project"></input></td>
								</tr>
								<tr>
									<td><span style="color: Red;">* </span>DATE OF JOINING:</td>
									<td><input type="text" name="doj" id="calendar"></input></td>
								</tr>
								<tr>
									<td>&nbsp; LAST WORKING DATE:</td>
									<td><input type="text" name="last" id="calendar1"></input></td>
								</tr>
								<tr>
									<td>&nbsp; BILLABLE:</td>
									<td><select type="text" name="bill" style="width: 143px">
											<option value="" disabled="disabled" selected="selected">Select</option>
											<option value="YES">YES</option>
											<option value="NO">NO</option>
											<option value="NA">NA</option>
									</select></td>
								</tr>
								<tr>
									<td>&nbsp; ACITVE USER:</td>
									<td><input type="text" name="active" value="YES"></input></td>
								</tr>

								<tr>
									<td><span style="color: Red;">* </span>LCR:</td>
									<td><input type="text" name="cost"></input></td>
								</tr>

							</table>
								<br></br><br></br>
						<div>
								<input class="gobutton" type="submit" value="Submit" />	
								 <input class="gobutton" type="reset" value="Reset" id="clear" name="clear"></input>
								<div style="padding-left: 229px; margin-top: -23px;">
									<a class="gobutton" href="admintool.jsp">Back</a>
								</div>
							</div>

						</form>
						<div style="color: Red;">* Mandatory Fields</div>

					</div>


					<div class="cleaner">&nbsp;</div>
				</div>

				<div id="ajaxResponse"></div>
				<p class="error message">${message}</p>
				<div class="cleaner">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
		</div>

		<div class="cleaner">&nbsp;</div>
	</div>
	<%@ include file="footer.jsp"%>


</body>
</html>