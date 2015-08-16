
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<jsp:include page="/fetchmodule.jsp" />
<jsp:include page="/fetchproject.jsp" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='search.js'></script>
<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script>
	$(document).ready(function() {

		$("#ViewmodCss").css({

			"font-weight" : "bold",
			"text-decoration" : "underline"
		});
	});
</script>

<script type='text/javascript' src='search.js'></script>
<script type="text/javascript">
	function validate(e) {
		var modulename = document.forms["edit"]["modulename"].value;
		var moduledesc = document.forms["edit"]["moduledesc"].value;
		if (modulename == null || modulename == "" || moduledesc == null
				|| moduledesc == "") {
			alert("Please enter the required fields!");
			return false;
		}
	}
</script>


</head>
<body><%@ include file="header_admin.jsp"%>
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

				<div class="header_01">Edit Module</div>


				<div>


					<div id="search" style="font-size: 14px;">
						<jsp:include page="/fetchproject.jsp" />
						<form name="edit" action="EditModuleFinal" method="post"
							onsubmit="return validate()">
							<jstlcore:forEach items="${module}" var="list">
								<table>

									<tr>
										<td>Module Name :</td>
										<td><input type="text" name="modulename"
											value="${list.moduleName}"></input></td>
									</tr>
									<tr>
										<td>PROJECT:</td>
										<td><select name="project">
												<jstlcore:forEach var="proj" items="${project}">

													<option value="${proj}">${proj}</option>

												</jstlcore:forEach>
										</select></td>
									</tr>

									<tr>
										<td>Module Description :</td>
										<td><input type="text" name="moduledesc"
											value="${list.moduleDescription}"></input> <input
											type="hidden" name="moduleid" value="${list.moduleId}"></input></td>
									</tr>
								</table>
							</jstlcore:forEach>


							<input type="submit" value="Change" style="margin-left: 123px" />

							<br />
						</form>
					</div>

					<div id="ajaxResponse"></div>
					<p class="error" style="font-size: 14px; color: red;">${message}</p>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>






</body>
</html>