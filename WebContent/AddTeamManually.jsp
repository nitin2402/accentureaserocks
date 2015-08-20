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
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='search.js'></script>
<script src="jquery.chained.js"></script>
<script src="addteamvia.js"></script>
</head>
<body>
<jsp:include page="/DropDownDetails" />
<%@ include file="header_admin.jsp" %>  
	<div id="templatemo_content">
	<%@ include file="common_left_admintool.jsp"%>
		<div id="content_right" >
			<div class="right_col_section_w650" style="height: 300px">
				<div class="header_01">Team Addition</div>
				<div id="search">
					<div id="scrollable"   style="font-size: 14px;">
						<form name="add" action="AddTeamManual" method="post" onsubmit="return validateform()">
							<table>
								<tr>
									<td><span style="color: Red;">* </span>TEAM NAME:</td>
									<td><input type="text" name="tname"></input></td>
								</tr>
								<tr>
									<td>&nbsp; PROJECT:</td>
									<td><select id="prj" class="chain" name="project" style="width: 143px">
											<jstlcore:forEach items="${project}" var="prj_item">
												<option value="${prj_item.projectId}">
													<jstlcore:out value="${prj_item.projectName}"></jstlcore:out></option>
											</jstlcore:forEach>
									</select></td>
								</tr> 
                          		<tr>
									<td>&nbsp; MODULE:</td>
									<td><select id="mdl" class="chain" name="module" style="width: 143px">
											<jstlcore:forEach items="${module}" var="mod_item">
												<option value="${mod_item.moduleId}" class="${mod_item.projectId}">
													<jstlcore:out value="${mod_item.moduleName}"></jstlcore:out></option>
											</jstlcore:forEach>
									</select></td>
								</tr> 
								<td><span style="color: Red;">* </span>TEAM DESCRIPTION:</td>
									<td><input type="text" name="desc"></input></td>
								</tr>
								<tr>
									<td>&nbsp; STATUS:</td>
									<td><input type="text" name="status" value="YES"></input></td>
								</tr>
								</table>
							<input class="submit" type="submit" value="Submit"></input> <input
								type="reset" value="Reset" id="clear" name="clear"></input><br />
							<br /> <span style="color: green"> <%-- <%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%> --%></span><br />
						</form>
					</div>
					<div class="cleaner">&nbsp;</div>
					<div class="message" style="color: Red;"> * Mandatory Fields</div>
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