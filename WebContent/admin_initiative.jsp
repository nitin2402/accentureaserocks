<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="searchrequest.js"></script>
<script type='text/javascript' src='searchAdmin.js'></script>
<script type='text/javascript' src='admin_initiative.js'></script>

</head>
<body>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
		|| (String) session1.getAttribute("admin") != "admin" ) {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />
	<%
		}
	%>
	
	
	<%@ include file="header_admin.jsp"%>

	<div id="templatemo_content">

		<%@ include file="common_left.jsp"%>
		<div id="content_right">

			<div class="right_col_section_w650" style="height:auto">
				<div id="search" style="font-size: 14px;">

					<div class="header_01">Initiatives</div>
					<div>
					<form method="post" name="upload" action="InitiativeUploadServlet"
						onsubmit="return Validate(this);" enctype="multipart/form-data"  >
						Select file to upload: <input type="file" name="dataFile"
							id="fileUpload" /><br /> <br /> <input type="submit"
							id="upload" value="Upload" />
					</form>
					</div>
					<br />
					<div>
						<p id="error" class="error message">${sessionScope.message}</p>
						
					</div>
					
					<div style="height: 350px">
					<% if( session.getAttribute("message") == null) { %>
				<object data='Docs/Sample3.pdf#' 
       					 type='application/pdf' 
       					 width='100%' 
      					  height='100%'>
				</object>
				<% } else { %>
				<p>No file uploaded.</p>
				<% } %>
				</div>
				<% session.removeAttribute("message"); %>
				</div>
			
				<div id="ajaxResponse"></div>
				<div class="cleaner">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>
		<%
					if (session1.getAttribute("reload") != null) {
						Object a = session1.getAttribute("reload");
						{
							int b = (Integer) (a);
							if (b > (0)) {
								b--;
								session1.setAttribute("reload", b);
				%>
				<script>
				document.getElementById("error").innerHTML = "File Uploading....";
				setTimeout(function(){
					location.reload();
				},6000);
					
				</script>
				<%
					}
						}
					}
				%>
</body>

</html>