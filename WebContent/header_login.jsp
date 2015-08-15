<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


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

		<div id="templatemo_header">
			<div id="site_title_section">
				<div id="site_title">Talent Management Tool</div>
				<div id="slogan">Plan, Organize, Budget, Schedule</div>
				<div class="cleaner">&nbsp;</div>
			</div>
		<div id="header_section_code">"The talent management tool is an integrated software tool that addresses the four pillars of talent management: plan, organize, budget and schedule talents"</div>
	</div>
		<!-- end of header -->
		<div id="templatemo_menu">
			<ul>
			<li><a href="about_us_common.jsp">About Us</a></li>
				<li><a href="#" class="last" onclick="myfunction()">Contact
						Us</a></li>
			</ul>
		</div>
</body>
</html>