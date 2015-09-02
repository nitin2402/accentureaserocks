<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"
		/>
		<title>Talent Management Tool</title>
		<meta name="keywords"
		content="" />
		<meta name="description" content="" />
		<link href="templatemo_style.css" rel="stylesheet"
		type="text/css" />
		<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"
		%>
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"
			/>
			<script src="//code.jquery.com/jquery-1.10.2.js"></script>
			<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
			<link rel="stylesheet" href="/resources/demos/style.css"
			/>
			<script type="text/javascript" src="js/jquery.validate.js"></script>
			<script type='text/javascript'
			src='date.js'></script>
			<script type="text/javascript"
			src="js/jquery.ui.datepicker.validation.js"></script>
			<link href="calendar.css" rel="stylesheet"
			/>
			<script type='text/javascript' src='admintool.js'></script>
			<script type='text/javascript'
			src='search.js'></script>
			<!-- <script type='text/javascript'
			src='action.js'></script> -->
			<script src="jquery.chained.js"></script>
			
	</head>

	<body>
		<%@ include file="header_admin.jsp" %>
		 <% HttpSession session1=request.getSession(false);
			if (session1==null || (String) session1.getAttribute(
			"user")==null || (String) session1.getAttribute(
			"admin") !="admin" ) { %>
				<jsp:forward page="login.jsp?msg=Please Login as an Admin"
				/>
				<% } %> 
					<div id="templatemo_content">
						<%@ include file="common_left.jsp" %>
							<div id="content_right">
								<div class="right_col_section_w650"
								 style="height:  480px">
									<div id="search">
										<!-- //accordian begins -->
										<div id="accordion" class="accordion_bg">
											<h4>ADD MODULE</h4>
											<div>
												<form name="radio1" action="AddModuleSelect"
												onsubmit="return validateform2()">
													<input type="radio" name="select"
													id="excel" value="addfromexcel"
													/>Add From Excel
													<br />
													<br />
													<br />
													<input type="radio" name="select"
													id="manually" value="addmanually"
													/>Add Manually
													<br />
													<input class="gobutton" type="submit"
													value="Submit" /> </form>
											</div>
											<h3>ADD TEAM</h3>
											<div>
												<form action="AddTeamSelect" onsubmit="return validateform1()">
													<input type="radio" name="select"
													value="addfromexcel" id="excel1"
													/>Add From Excel
													<br />
													<br />
													<br />
													<input type="radio" name="select"
													value="addmanually" id="manually1"
													/>Add Manually
													<br />
													<br />
													<input class="gobutton" type="submit"
													value="Submit" /> </form>
											</div>
											<h3>ADD EMPLOYEE/AUTHORIZE EMPLOYEE</h3>
											<div>
												<select id="select" name="select"
												onchange="changeTextBox();">
													<option value="default" selected>
													--Select to add/authorize employee--
														</option>
													<option value="employee">add employee(s)</option>
													<option
													value="authorize">authorize employee(s)</option>
												</select>
												<!--add employee  -->
												<div id="employee">
													<h3 style="color: black;">Add Employees</h3>
													<form action="AddEmpChoice"
													name="radio1" onsubmit="return validateform()">
														<input type="radio" name="select"
														value="addfromexcel" id="excel2"/>AddFrom Excel
														<br />
														<br />
														<br /> 
														<input type="radio"
														name="select" value="addmanually"
														id="manually2"/>AddManually
														<br />
														<br />
														<br /> 
														<input class="gobutton"
														type="submit" value="Submit"
														/> </form>
												</div>
												<!-- authorize employee -->
												<div id="authorize">
													<jsp:include page="/AuthorizeEmployeeServlet"
													/>
													<h3 style="color: black;">Unauthorized Employees</h3>
													<form name="authorizeForm"
													method="post" action="TypeOfUserServlet">
														<div id="scrollable" style="font-size: 14px; height: 200px;">
															<table class="table2">
																<thead style="font-weight: bold; position:">
																	<tr class="one" style="font-weight: bold;">
																		<td>Select</td>
																		<td>User Name</td>
																		<td>Type Of User</td>
																		<td>Employee Id</td>
																		<td>Employee Designation</td>
																	</tr>
																</thead>
																<tbody>
																	<jstlcore:forEach items="${unauthorized_employees}"
																	var="item">
																		<tr class="table_align">
																			<td>
																				<input type="radio" id="select"
																				name="select" value="${item.loginid}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.username}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.userType}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.employeeId}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.employeedesignation}"
																				/> </td>
																		</tr>
																		<input type="hidden" name="employeeid"
																		value="${item.loginid}"
																		/>
																		<input type="hidden" id="${item.loginid}"
																		value="${item.employeedesignation}"
																		/>
																		<input type="hidden" name="empid"
																		value="${item.employeeId}"
																		/> </jstlcore:forEach>
																</tbody>
															</table>
															<h3 style="color: black;">Choose an action to authorize employee</h3>
															<div>
																<input class="gobutton" type="submit"
																name="action" value="Admin"
																onclick="return validateAdmin()"
																/>
																<input class="gobutton"
																type="submit" name="action"
																value="User" onclick="return validateUser()"
																/>
																<input class="gobutton"
																type="submit" name="action"
																value="Viewer" onclick="return validateViewer()"
																/>
																<input class="gobutton"
																type="reset" value="Reset"
																name="clear"></input>
															</div>
														</div>
													</form>
												</div>
											</div>
											<h3>VIEW/EDIT/DELETE MODULE/TEAM/EMPLOYEE</h3>
											<div>
												<!--  select -->
												<select id="select1" name="select"
												onchange="changeTextBox();">
													<option value="default" selected>
													--Select to view module/team/employee--
														</option>
													<option value="modl1">view module(s)</option>
													<option
													value="team1">view team(s)</option>
														<option
														value="emp1">view employee(s)</option>
												</select>
												<!--view module  -->
												<div id="modl">
													<jsp:include page="/FetchModuleDetails"
													/>
													<h3 style="color: black;">View Module(s)</h3>
													<div>${module}</div>
												</div>
												<!--view team  -->
												<div id="team">
													<jsp:include page="/FetchTeamDetails"
													/>
													<h3 style="color: black;">View Team(s)</h3>
													<div>${team}</div>
												</div>
												<!-- view employee -->
												<div id="emp">
													<jsp:include page="/ViewEmployee"
													/>
													<h3 style="color: black;">View Employee(s)</h3>
													<form name="form" action="EditEmployeeFinal"
													method="post" onclick="return validateEmp()">
														<div id="scrollable" style="font-size: 14px;">
															<table class="table2">
																<thead style="font-weight: bold; position:">
																	<tr class="one table_align"
																	style="font-weight: bold;">
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
																		<!-- <td>Last Working Date</td>  -->
																		<td>Billable</td>
																		<!--  <td>Active User</td>  -->
																	</tr>
																</thead>
																<tbody>
																	<jstlcore:forEach items="${empList}"
																	var="item">
																		<tr class="table_align">
																			<td>
																				<input type="radio" name="employeeDetails"
																				value="${item.empId}"></input>
																			</td>
																			<td>
																				<jstlcore:out value="${item.empId}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.empName}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.designation}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.level}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.expertise}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.clientId}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.email}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.teamName}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.profCamps}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.profProject}"
																				/> </td>
																			<td>
																				<jstlcore:out value="${item.doj}"
																				/> </td>
																			<%-- <td>
																				<jstlcore:out value="${item.lastWD}"
																				/> </td> --%>
																				<td>
																					<jstlcore:out value="${item.isBillable}"
																					/> </td>
																				<%-- <td>
																					<jstlcore:out value="${item.isActive}"
																					/> </td> --%> </tr>
																	</jstlcore:forEach>
																</tbody>
															</table>
														</div>
														<div>
															<input type="submit" class="gobutton"
															id="editEmployee" name="editEmployee"
															onclick="return validateEmp()"
															value="Edit"></input>
															<input type="submit"
															class="gobutton" id="deleteEmployee"
															name="deleteEmployee" onclick="return validateEmp()"
															value="Delete"></input>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
									<div>
									<div id="ajaxResponse"></div>
									<p class="error" style="font-size: 20px; color: red;">${message}</p>
									</div>
									<div class="margin_bottom_20">&nbsp;</div>
								</div>
								<div class="cleaner">&nbsp;</div>
							</div>
							<%@ include file="footer.jsp" %>
					</div>
	</body>

	</html>