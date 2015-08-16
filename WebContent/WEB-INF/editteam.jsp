
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
	$(document).ready(
			function() {
				$("#show1").hide();

				$('#s_module').change(
						function(event) {

							var dropDownValue = $("#s_module").children(
									"option").filter(":selected").text();

							$.ajax({
								url : "/TMT/FetchTeam",
								type : "POST",
								data : 'moduleName=' + dropDownValue,

								success : function(data) {
									$("#hide1").hide();
									$("#show1").show();
									$("#ajaxResponse").html(data);

								},
								error : function() {

								}
							});

						});
			});
</script>

<script type="text/javascript">
	function validate(e) {
		var teamname = document.forms["edit"]["teamname"].value;
		var teamdesc = document.forms["edit"]["teamdesc"].value;
		if (teamname == null || teamname == "" || teamdesc == null
				|| teamdesc == "") {
			alert("Please enter the required fields!");
			return false;
		}
	}
</script>
<script>
	$(document).ready(function() {

		$("#ViewteamCss").css({

			"font-weight" : "bold",
			"text-decoration" : "underline"
		});
	});
</script>

</head>
<body>
	<%@ include file="header_admin.jsp"%>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null /* || (String)session1.getAttribute("user") == null || (Boolean)session1.getAttribute("admin") != true */) {
	%><jsp:forward page="home.jsp?msg=Please Login as an Admin" />
	<%
		}
	%>
	<div id="templatemo_content">

		<%@ include file="common_left_admintool.jsp"%>


		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Edit Team</div>


				<div>


					<div id="search" style="font-size: 14px;">
						<form name="edit" action="EditTeamFinal" method="post"
							onsubmit="return validate()">

							<jstlcore:forEach items="${team}" var="list">
								<table>

									<tr>
										<td>Team Name :</td>
										<td><input type="text" name="teamname"
											value="${list.teamName}"></input></td>
									</tr>
									<tr>
										<td>Module:</td>
										<td><input type="text" value="${list.moduleName}"
											disabled="disabled"></input></td>
									</tr>
									<tr>
										<td>New Module:</td>
										<td><select name="module" id="module"><jstlcore:forEach
													var="aff" items="${modu}">

													<option value="${aff}">${aff}</option>
												</jstlcore:forEach></select></td>
									</tr>
									<tr>
										<td>Team Description :</td>
										<td><input type="text" name="teamdesc"
											value="${list.teamDescription}"></input> <input type="hidden"
											name="teamid" value="${list.teamId}"></input></td>
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