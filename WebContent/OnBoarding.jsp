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
	<!-- <script>
$(document).ready(function(){
    
        $("#current").hide();
         
    });
</script>
<script>
$(document).ready(function(){
    
        $("#release").hide();
         
    });
</script>
<script>
$(document).ready(function(){
    $("#current1").click(function(){
        $("#current").toggle();
         
    });
});
</script>
<script>
$(document).ready(function(){
    $("#release1").click(function(){
        $("#release").toggle();
         
    });
});
</script> -->
<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script type='text/javascript' src='search.js'></script>
</head>


<body>
	<jsp:include page="/ProjectCurrent"/>

 <%-- <% 
		HttpSession session1 = request.getSession(false);
 %>
		<%-- if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/*  || (String) session1.getAttribute("admin") != "admin" */ ) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		} 
	    
	< --%>
<%@ include file="header_users.jsp" %>  

	<div id="templatemo_content">
	
	<%@ include file="common_left.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">On Boarding</div>


				<div id="search" style="font-size: 14px;">     <h2><b>USEFUL LINKS</b></h2>
				<h3> VPN Access:</h3>
				1.Check Details</br>
				<a href="http://webphone.att.com/ "><u>http://webphone.att.com/ </u></a> 
				</br>
				2.Register Password</br>
				<a href="https://www.e-access.att.com/src "><u>https://www.e-access.att.com/src </u></a> 
				</br>
				<h3>RSA Mapping</h3>
				<a href=" https://www.e-access.att.com/src/RsaProvisioningServlet?submenu=SP:RT "><u> https://www.e-access.att.com/src/RsaProvisioningServlet?submenu=SP:RT </u></a>
				</br> 
				<h3>RSA Token Installation</h3>
				1.	Log in to <a href="https://www.e-access.att.com/stdm"><u> www.e-access.att.com/stdm</u> </a> </br>
				2.  IT Services password <a href=" https://www.toolsssl.sbc.com"> <u>https://www.toolsssl.sbc.com</u></a>
				</br>
				<h3>QC Access</h3>
				<a href=" https://www.e-access.att.com/idm/webapp//tticket/index.jsp"><u> https://www.e-access.att.com/idm/webapp//tticket/index.jsp</u></a>
				</br>
				<h3>Request Rally Access</h3>
				<a href="https://operations.web.att.com/sites/Agile-COE/Agile%20COE%20Library/Tools/Rally%20Dev/Ordering%20Rally%20Dev%20Licenses%20Job%20Aid.docx"><u>https://operations.web.att.com/sites/Agile-COE/Agile%20COE%20Library/Tools/Rally%20Dev/Ordering%20Rally%20Dev%20Licenses%20Job%20Aid.docx</u></a>
				</br>
				<h3>Getting the Admin Rights</h3>
				<a href="http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush"><u>http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush</u></a>
				</br>
				<h3>New software installation process - RAISE THE TICKET</h3>
				<a href="http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush"><u>http://ushportal.it.att.com/step2.cfm?proc_id=578054&app=681&home=ush</u></a>
				</br>
				<h3>CONFIGURE MACHINE</h3>
				<a href="ftp://bsdevprem01.edc.cingular.net/Windows/"><u>ftp://bsdevprem01.edc.cingular.net/Windows/</u></a>
				
				
				
				</div>
				<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			<%@ include file="footer.jsp"%>
			</div>
		</div></body>
</html>