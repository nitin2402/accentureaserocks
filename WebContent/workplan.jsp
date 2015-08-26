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
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript" src='search.js'></script>
	<script src="jquery.chained.js"></script>
	
<script type="text/javascript" src="workplan.js"></script>
<script>
$(function(){$("#mdl").chained("#prj");
$("#tem").chained("#mdl");});
 
$(function(){$("#emp").chained("#level");});
</script>
</head>

<body onload="myFunction()">
	<jsp:include page="/DropDownDetails" />  
	<jsp:include page="/ViewEmployee" />  
	<input type="hidden" id="backup" name="backup" value="0"></input>

	<%
		HttpSession session1 = request.getSession();
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}
	%>
	<%@ include file="header_users.jsp"%>

	<div id="templatemo_content">

		<%@ include file="common_left.jsp"%>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 600px">

				<div class="header_01">Work Plan</div>

				<div id="search">

					<div style="font-size: 14px;">
						Insert the number of resources you required.

						<div>
							<form name="requestForm" action="workplanServlet"
								onsubmit="return validateForm()" method="post">
								<table>
									<tr>
										<td>

											<table width="400">

												<tr style="height: 10px">
													<td></td>
												</tr>

								
												<tr>
									<td width="75%">*PROJECT</td>
									<td><select id="prj" class="chain" name="project" style="width: 210px">
											<jstlcore:forEach items="${project}" var="prj_item">

												<option value="${prj_item.projectId}">
													<jstlcore:out value="${prj_item.projectName}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr> 

                           <tr>
									<td>*MODULE</td>
									<td><select id="mdl" class="rfgd" name="module" style="width: 210px">
											<jstlcore:forEach items="${module}" var="mod_item">

												<option value="${mod_item.moduleId}" class="${mod_item.projectId}">
													<jstlcore:out value="${mod_item.moduleName}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr> 
								<tr>
									<td>*TEAM</td>
									<td><select name="teamId" style="width: 210px" class="chain" id="tem">
											<jstlcore:forEach items="${team}" var="item">

												<option value="${item.teamId}" class="${item.moduleId}">
													<jstlcore:out value="${item.teamName}"></jstlcore:out></option>


											</jstlcore:forEach>

									</select></td>
								</tr>
												<tr>
													<td style="width:250px">*No. of ASE Required &nbsp;</td>
													<td style="width:100px"><input type="text" id="NASE" name="NASE" value="0"
														class="dropbox_size" /></td>
												</tr>

												<tr>
													<td style="width:250px">*No. of SE Required &nbsp;</td>
													<td style="width:100px"><input type="text" id="NSE" name="NSE" value="0"
														class="dropbox_size" /></td>
												</tr>

												<tr>
													<td style="width:250px">*No. of SSE Required &nbsp;</td>
													<td style="width:100px"><input type="text" id="NSSE" name="NSSE" value="0"
														class="dropbox_size" /></td>
												</tr>

												<tr>
													<td>*Comment</td>
													<td><textarea rows="5" cols="25" id="comment"
															name="comment" class="dropbox_size"></textarea></td>
												</tr>
												
												<tr><td></td></tr>
												
												<tr>
													<td colspan="2">
														<input type="checkbox" id="isSpecific" name="isSpecific" onclick="calc()"></input> Specific Requirement for particular Resource
													</td>
												</tr>

												<tr>
													<td>*Level</td>
													<td><select id="level" name="level" style="width: 210px">
															<option value="ASE">ASE</option>
															<option value="SE">SE</option>
															<option value="SSE">SSE</option>
														</select>
													</td>
												</tr>
												
												<tr>
													<td>*Employee</td>
													<td><select id="emp" name="emp" style="width: 210px"  onchange="setTenure();setInfo();">
															<jstlcore:forEach items="${empList}" var="emp_item">

																<option value="${emp_item.empId}_${emp_item.doj}_${emp_item.isBillable}_${emp_item.teamName}" class="${emp_item.designation}">
																		<jstlcore:out value="${emp_item.empName}"></jstlcore:out></option>
															</jstlcore:forEach>
														</select>
													</td>
												</tr>
												
												<tr>
													<td>*Tenure</td>
													<td id="tenure"></td>
												</tr>
												
												<tr>
													<td>*Detail Info</td>
													<td id="info"></td>
												</tr>
												
												<tr>
													<td>*Specific Requirement <br /> &nbsp; Comment</td>
													<td><textarea rows="5" cols="25" id="specificComment" name="specificComment"
															 class="dropbox_size"></textarea></td>
												</tr>

											</table>
										</td>
										<td style="width: 60px"></td>
										<td></td>
									</tr>
									
									<tr>
										<td><input type="hidden" name="userName" value="${user}" />
											<input type="submit" value="Submit"></input> 
											<input type="reset" value="Reset"></input>
										</td>
									</tr>
								</table>

							</form>
						</div>



						<div class="cleaner">&nbsp;</div>
					</div>

				</div>
				<div id="ajaxResponse"></div>

				<div class="cleaner">&nbsp;</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>