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
<script type="text/javascript">
	$(function() {
		$('.last').click(
				function(event) {
					var email = 'tmt_group@accenture.com';
					var subject = 'Feedback';
					var emailBody = 'Hi,';
					window.location = 'mailto:' + email + '?subject=' + subject
							+ '&body=' + emailBody;
				});
	});
</script>

</head>
<body>
<%

   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>
<div id="templatemo_container" />
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Talent Management Tool</div>
			<div id="slogan">Plan, Organize, Budget, Schedule</div>
			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;margin-right:20px;">
			Welcome ${user}&nbsp;|<a href="logout.jsp">&nbsp;Logout</a>
		</div>
		<div id="header_section_code">"The talent management tool is an integrated software tool that addresses the four pillars of talent management: plan, organize, budget and schedule talents"</div>
	</div>
 
	<div id="templatemo_menu">
		<ul>
			<li><a href="viewerhome.jsp">Home</a></li>
						<li><a href="viewer_initiative.jsp">Initiatives</a></li>
			<li><a href="aboutus.jsp">About Us</a></li>
			<li><a href="#" class="last">Contact Us</a></li>

		</ul>
	</div>
</body>
</html>