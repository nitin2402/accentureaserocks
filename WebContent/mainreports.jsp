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
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='searchAdmin.js'></script>
<script type='text/javascript' src='search.js'></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/> 
 <script src="//code.jquery.com/jquery-1.10.2.js"></script> 
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 
 <link rel="stylesheet" href="/resources/demos/style.css"/>  
 <script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript"
	src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />


<script src="searchAdmin.js"></script>
<script src="generateempreports.js"></script>

<script src="jquery.chained.js"></script>

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
 <jsp:include page="/DropDownDetails" />
	<jsp:include page="/ViewEmployee" />
<%@ include file="common_left.jsp" %>
			<div id="content_right">
			<div class="right_col_section_w650" style="height: auto;">
				<div class="header_01">Reports</div>
                 <div id="search" style="font-size:13px">
				 
					<div id="accordion" class="accordion_bg">
						<h3>Reports Generated for Requests</h3>
						<div>
							<form name="request" action="RequestReportServlet" method="post"
								onsubmit="return validateform()">
								<table>
									<tr >
										<td>PLEASE SELECT THE STATUS &nbsp;&nbsp;</td>
										<td><select name="status" class="dropbox_size">
												<option value="">--Please select--</option>
												<option value="pending">Pending</option>
												<option value="onhold">OnHold</option>
												<option value="accepted">Accepted</option>
												<option value="rejected">Rejected</option>
										</select></td>
									</tr>
									<tr>
										<td>START DATE:
									 		</td>
												<td><input type="text" class="datepicker textbox_size" id="calendar" name="startdate" /></td>
																					
									</tr>
									<tr>
										<td>END DATE:
											
										</td>
										<td><input type="text" class="datepicker textbox_size" id="calendar1" name="enddate" /></td>
									</tr>
								</table>
								<br /> <br />
								<button type="submit" value="Submit" style="margin-left: 100px">Generate
									Report</button>
							</form>
						</div>
					 	<h3>Reports Generated for Module</h3>
						<div>
						
							<form name="modulereport" action="ModuleReportServlet"
								method="post" onsubmit="return validateform()">
								<table>
									<tr>
										<td>PROJECT :</td>
										<td><select id="prj" class="chain dropbox_size" name="project"
											>
												<option value="">--Please select--</option>
												<jstlcore:forEach items="${project}" var="prj_item">

													<option value="${prj_item.projectId}">
														<jstlcore:out value="${prj_item.projectName}"></jstlcore:out></option>


												</jstlcore:forEach>

										</select></td>
									</tr>

									<tr>
										<td>MODULE :</td>
										<td><select id="mdl" class="chain dropbox_size" name="module"
											>
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
										<td><select id="action" name="action" class="dropbox_size">
												<option></option>
												<option>added</option>
												<option>edited</option>
												<option>deleted</option>
										</select></td>
									</tr>



									<tr>
										<td>START DATE :</td>
										<td><input type="text" class="datepicker textbox_size" id="calendar4" name="startDate" /></td>
									</tr>
									<tr>
										<td>END DATE :</td>
										<td><input type="text" class="datepicker textbox_size" id="calendar5" name="endDate" /></td>
									</tr>
								</table>
								<br />

								<button type="submit" value="Submit" style="margin-left: 100px">Generate
									Report</button>

							</form>
						</div>
					<h3>Reports Generated for Team</h3>
						<div>
							
							<form name="teamreport" action="TeamReport" method="post"
								onsubmit="return validateform()">
								
								<table>
									<tr>
										<td>&nbsp; PROJECT</td>
										<td><select id="prj" class="chain dropbox_size" name="project"
											>
												<option value="">--Please select--</option>
												<jstlcore:forEach items="${project}" var="prj_item">

													<option value="${prj_item.projectId}">
														<jstlcore:out value="${prj_item.projectName}"></jstlcore:out></option>


												</jstlcore:forEach>

										</select></td>
									</tr>

									<tr>
										<td>&nbsp; MODULE</td>
										<td><select id="mdl" class="chain dropbox_size" name="module"
											>
												<option value="">--Please select--</option>
												<jstlcore:forEach items="${module}" var="mod_item">

													<option value="${mod_item.moduleId}"
														class="${mod_item.projectId}">
														<jstlcore:out value="${mod_item.moduleName}"></jstlcore:out></option>


												</jstlcore:forEach>

										</select></td>
									</tr>
									<tr>
										<td>&nbsp; TEAM</td>
										<td><select name="Team" 
											class="chain dropbox_size" id="tem">
												<option value="">--Please select--</option>
												<jstlcore:forEach items="${team}" var="item">

													<option value="${item.teamName}" class="${item.moduleId}">
														<jstlcore:out value="${item.teamName}"></jstlcore:out></option>


												</jstlcore:forEach>

										</select></td>
									</tr>
									<tr>
										<td>ACTION :</td>
										<td><select id="action" name="action" class="dropbox_size">
												<option></option>
												<option>added</option>
												<option>edited</option>
												<option>deleted</option>
												<option>added by excel</option>

										</select></td>
									</tr>

									<tr>
										<td>START DATE :</td>
										<td><input type="text" class="datepicker textbox_size" id="calendar2" name="startDate"  /></td>
									</tr>
									<tr>
										<td>END DATE :</td>
										<td><input type="text" class="datepicker textbox_size" id="calendar3" name="endDate" /></td>
									</tr>

								</table>
								<button type="submit" value="Submit">Generate Report</button>


							</form>
						</div>
					
						<h3>Reports Generated for Employee</h3>
						<div>					
							<select id="select" name="select" onChange="changeTextBox();">
								<option value="default" selected>Select to generate
									reports on employee</option>
								<option value="employee">Generate report by Employee
									Name</option>
								<option value="designation">Generate report by
									Designation/Billability</option>
							</select>
								<div id="div1">							
								<form action="EmployeeReportServlet" method="post" onsubmit="return validateform()">
								
										<table >
											<tr>
												<td>EMPLOYEE NAME:</td>
												<td><select class="dropbox_size"
													id="empName" name="empname">
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
												<td><select class="dropbox_size" id="action"
													name="action">
														<option></option>
														<option>added</option>
														<option>edited</option>
														<option>deleted</option>
														<option>added by excel</option>
												</select></td>
											</tr>

											<tr>
												<td>START DATE:</td>
												<td><input  type="text"
													name="startdate" class="datepicker textbox_size" id="calendar6"></input></td>
											</tr>
											<tr>
												<td>END DATE:</td>
												<td><input  type="text"
													name="enddate" class="datepicker textbox_size" id="calendar7"></input></td>
											</tr>
										</table>
										<br /> <br />
										<button id="buttonName" type="submit" value="Submit"
											style="margin-left: 100px">Generate Report</button>
										
									</form>					
											</div>				
									<form action="EmployeeReportServlet_bill" method="post" onsubmit="return validateform()">
										<div id="div2">
										<table >
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
												<td><select class="dropbox_size" id="action"
													name="action">
														<option></option>
														<option>added</option>
														<option>edited</option>
														<option>deleted</option>
														<option>added by excel</option>
												</select></td>
											</tr>

											<tr>
												<td>START DATE:</td>
												<td><input  type="text"
													name="startdate" class="datepicker textbox_size" id="calendar8"></input></td>
											</tr>
											<tr>
												<td>END DATE:</td>
												<td><input  type="text"
													name="enddate" class="datepicker textbox_size" id="calendar9"></input></td>
											</tr>
										</table>
										<br /> <br />
										<button id="buttonBillability" type="submit" value="Submit"
											style="margin-left: 100px">Generate Report</button>
											</div>
									</form>
									<br /> <br /> <br /> <br /> <br /> <br />
									<div class="notification">${message}</div>									
							
								
							
						</div> 
					</div>
				</div>
                <div id="ajaxResponse"></div>
                <p class="error" style="font-size: 14px; color: red;">${message1}</p>
				<div class="margin_bottom_20">&nbsp;</div>
			</div>
			<div class="cleaner">&nbsp;</div>
		</div>
	<%@ include file="footer.jsp" %> 
	</div>
</body>
</html>
