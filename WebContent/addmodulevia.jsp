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

<script type="text/javascript" src="addmodulevia.js"></script> 
<script type='text/javascript' src='search.js'></script>
<script >
$(document).ready(function(){

        $("#modCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

	</script>
</head>
<body>
<%@ include file="header_admin.jsp" %>
	<%

	

HttpSession session1 = request.getSession(false);
if (session1 == null || (String)session1.getAttribute("user") == null || (String)session1.getAttribute("admin") != "admin") 
{
    %><jsp:forward page="login.jsp?msg=Please Login as an Admin" /><%
}
%>
<div id="templatemo_content">

		<%@ include file="common_left_admintool.jsp" %>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Module Addition</div>


				<div id="search">


					<div style="font-size: 14px;">
						<form name="radio1" action="AddModuleSelect" onsubmit="return validateform2()">
							<input type="radio" name="select"  id= "excel" value="addfromexcel"/>Add
								From Excel<br />
							<br />
							<br /><input type="radio" name="select"  id="manually" value="addmanually"/>Add
								Manually<br />
							
								
							<br/><input type="submit" value="Select" />
						</form>
					</div>
					<br />
					<br />
					

					<div class="cleaner">&nbsp;</div>
					<div class="notification">${message}</div>
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