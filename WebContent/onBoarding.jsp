<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
<script type='text/javascript' src='search.js'></script>
</head>


<body>
	<jsp:include page="/ProjectCurrent"/>
	<%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") == "viewer") {
	%><jsp:forward page="login.jsp?msg=Please Login " />

	<%
		}
	%>
	<%
	if ((String) session1.getAttribute("admin") == "admin") {
%>
<%@ include file="header_admin.jsp" %>  
<%
	}
%>
<%
	if ((String) session1.getAttribute("admin") == "user") {
%>
<%@ include file="header_users.jsp" %> 
<%
	}
%>
	<div id="templatemo_content">
	
	<%@ include file="common_left.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">
<div class="header_01">On Boarding</div>


				<div id="search" style="font-size: 14px;">     <h2><b>USEFUL LINKS</b></h2>
				<h3> <u class="tooltip" title="VPN means Virtual Private Network.Employees at different geographical locations can access the intranet and work in a single cohesive network.AT&T has its own VPN and to access please click on the following link and follow the steps.">VPN Access</u></h3>
				1.Check Details</br>
				<a href="http://webphone.att.com/ "><u>http://webphone.att.com/ </u></a> 
				</br>
				2.Register Password</br>
				<a href="https://www.e-access.att.com/src "><u>https://www.e-access.att.com/src </u></a> 
				</br>
				<h3><u class="tooltip" title="For VPN connection, RSA token is required and generated. a new token is generated every minute for authentication and security reasons.">RSA Mapping</u></h3>
				<a href=" https://www.e-access.att.com/src/RsaProvisioningServlet?submenu=SP:RT "><u> https://www.e-access.att.com/src/RsaProvisioningServlet?submenu=SP:RT </u></a>
				</br> 
				<h3><u class="tooltip" title="RSA tokens are generated every minute for authentication purposesfor the VPN connection(No VPN required)">RSA Token Installation</u></h3>
				1.	Log in to <a href="https://www.e-access.att.com/stdm"><u> www.e-access.att.com/stdm</u> </a> </br>
				2.  IT Services password <a href=" https://www.toolsssl.sbc.com"> <u>https://www.toolsssl.sbc.com</u></a>
				</br>
				<h3><u class="tooltip" title="Quality Center is designed to cover all the quality activities including requirements , test management, defect tracking, as well as areas like business process testing.For accessing QC in this project please refer the following link">QC Access</u></h3>
				<a href=" https://www.e-access.att.com/idm/webapp//tticket/index.jsp"><u> https://www.e-access.att.com/idm/webapp//tticket/index.jsp</u></a>
				</br>
				<h3><u class="tooltip" title="You should receive a 'Welcome to Rally' email in about a week">Request Rally Access</u></h3>
				<a href="https://operations.web.att.com/sites/Agile-COE/Agile%20COE%20Library/Tools/Rally%20Dev/Ordering%20Rally%20Dev%20Licenses%20Job%20Aid.docx"><u>https://operations.web.att.com/sites/Agile-COE/Agile%20COE%20Library/Tools/Rally%20Dev/Ordering%20Rally%20Dev%20Licenses%20Job%20Aid.docx</u></a>
				</br>
				<h3><u class="tooltip" title="To get the Admin rights, we need Approval from OOT/OCE team (like for java David bates(DB3434) and JSP scott p Abernathy (sa7972)- ">Getting the Admin Rights</u></h3>
				<a href="http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush"><u>http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush</u></a>
				</br>
				<h3><u class="tooltip" title="Kindly follow same process for HVD/Remote machine related issue by changing drop down to HVD connection error (Single User)">New software installation process - RAISE THE TICKET</u></h3>
				<a href="http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush"><u>http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush</u></a>
				</br>
				<h3><u class="tooltip" title="After getting Admin rights configure your machine by installing all required softwares.">CONFIGURE MACHINE</u></h3>
				<a href="ftp://bsdevprem01.edc.cingular.net/Windows/"><u>ftp://bsdevprem01.edc.cingular.net/Windows/</u></a>
				
				
				
				</div>
				<div id="ajaxResponse"></div>
				<p class="error message">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			</div>
			<%@ include file="footer.jsp"%>
			
		</div></body>
</html>