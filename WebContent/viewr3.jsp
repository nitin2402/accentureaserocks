<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<title>E-Strategy</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	function validate() {
		var regExp = /^[a-zA-Z]{1,100}$/;

		var msg1 = document.getElementById("msg1");

		msg1.innerHTML = "";

		if (!regExp.test(form1.search_field.value)) {
			msg1.innerHTML = "Name should be in alpha !";
			return false;
		}

	}
</script>
<script >
$(document).ready(function(){

        $("#R3Css").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
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

		/* $("#clickk").hide(); */

		$('li.teamclick').on('click', function() {
			var team = $(this).text();
			var module = $(this).attr('id');

			$("#ajaxResponse1").show();
			/* $("#piechart").hide(); */

			$.ajax({

				url : "/TMT/FetchTeamEmployees",
				type : "POST",
				data : {
					'teamName' : team,
					'moduleName' : module
				},

				success : function(data) {

					$("empclick").show();
					$("#ajaxResponse1").html(data);
					/* 	$("#clickk").show(); */
					$("#teamnam").val(team);

				},
				error : function() {

				}
			});

		});
	});
</script>
<%
	HttpSession session1 = request.getSession(false);
if (session1 == null

|| (String) session1.getAttribute("user") == null) {
%><jsp:forward page="login.jsp?msg=Please Login" />

<%
}
%>

<%
	if ((String) session1.getAttribute("admin") == "admin") {
%>

<script type='text/javascript' src='searchAdmin.js'></script>
<%
	}
%>

<%
	if ((String) session1.getAttribute("admin") == "user") {
%>
<script type='text/javascript' src='search.js'></script>
<%
	}
%>
</head>
<body>
	<%
		HttpSession session2 = request.getSession(false);
	if (session2 == null

			|| (String) session2.getAttribute("user") == null) {
			%><jsp:forward page="login.jsp?msg=Please Login" />

			<%
			}
	%> 
	<jsp:include page="/ViewReportR3" />

	<div id="templatemo_container">
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Talent Management Tool</div>
			<div id="slogan">Plan, Organize, Budget, Schedule</div>
			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;">
			Welcome ${user}&nbsp;<a href="logout.jsp">Logout</a>
		</div>
		<div id="header_section_code">"The talent management tool is an integrated software tool that addresses the four pillars of talent management: plan, organize, budget and schedule talents"</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<%
				 if ((String) session2.getAttribute("admin") == "admin") { 
			%>
				<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="admintool.jsp">Admin Tools</a></li>
			<li><a href="searchrequest.jsp">Workplan</a></li>
			<li><a href="ProjectAdmin.jsp">Projects</a></li>
			<li><a href="mainreports.jsp">Reports</a></li>
			<li><a href="admin_initiative.jsp">Initiatives</a></li>
			<li><a href="aboutus.jsp">About Us</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
			  
			<%
				 }
			%>
			<%
				 if ((String) session2.getAttribute("admin") == "user") { 
			%>

			<li><a href="userhome.jsp">Home</a></li>
			<li><a href="workplanvia.jsp">Workplan</a></li>
			<li><a href="ProjectUser.jsp">Projects</a></li>
				<li><a href="user_initiative.jsp">Initiatives</a></li>
			<li><a href="about_us_users.jsp">About Us</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
			
			<%
				 } 
			%>
			<%
				 if ((String) session2.getAttribute("admin") == "viewer") { 
			%>
			
			<li><a href="viewerhome.jsp">Home</a></li>
			<li><a href="viewer_initiative.jsp">Initiatives</a></li>
			<li><a href="about_us_viewer.jsp">About Us</a></li>
			<li><a href="#" class="last">Contact Us</a></li>

		<%
				 }
			%>
			
			
		</ul>
	</div>

	<div id="templatemo_content">
	
			<%@ include file="common_left.jsp" %>
			
			
		
		<!-- <input type="hidden" id="teamname" name="teamname"></input> -->
		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Top view of R3</div>
				<div id="search">

				<div>

					<div id="projchart" style="height: auto; width: 1000px">
						<%-- 	<div class="tree">${html1}</div> --%>
						<table>
							<tr>
								<td class="tree">${html1}</td>
								<td />
								<td />
								<td />
								<td id="ajaxResponse1"></td>
							</tr>
						</table>
					</div>

					
					<div id="emplist"></div>
					
				</div>	
			
		</div>
			 <div id="ajaxResponse"></div>

                           <div class="margin_bottom_20">&nbsp;</div>
                     </div>

                     <div class="cleaner">&nbsp;</div>
              </div>
              <%@ include file="footer.jsp" %>   
</div>
</div>

</body>
</html>