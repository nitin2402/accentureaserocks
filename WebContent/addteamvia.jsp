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

<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script >
$(document).ready(function(){

        $("#teamCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

	</script>
<script type="text/javascript" src="addteamvia.js"></script> 
<script type='text/javascript' src='searchAdmin.js'></script>
<script type='text/javascript' src='search.js'></script>
</head>
<body>
<%@ include file="header_admin.jsp" %>
	<%


HttpSession session1 = request.getSession(false);
if (session1 == null   || (String)session1.getAttribute("user") == null /* || (Boolean)session1.getAttribute("admin") != true  */){
    %><jsp:forward page="home.jsp?msg=Please Login as an Admin" /><%
}
%>


	<div id="templatemo_content">

		<%@ include file="common_left_admintool.jsp" %>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Team Addition</div>


				<div id="search">


					<div style="font-size: 14px;">
						<form action="AddTeamSelect"  onsubmit="return validateformteam()">
							<input type="radio" name="select" value="addfromexcel" id= "excel1" />Add
								From Excel <br />
							<br />
							<br /><input type="radio" name="select" value="addmanually" id="manually1" />Add
								Manually<br />
							<br/><input type="submit" value="Select"> </input>
						</form>
					</div>



					<div class="cleaner">&nbsp;</div>
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