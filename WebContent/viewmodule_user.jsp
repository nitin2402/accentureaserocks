

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!-- <script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script> -->


<script type='text/javascript' src='search.js'></script>
<script >$(document).ready(function(){

        $("#ViewmodCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

	</script>
</head>
<body>


<jsp:include page="/FetchModuleForUser" />  
	
	
	
	
	<%
              HttpSession session1 = request.getSession(false);
              if (session1 == null
                           || (String) session1.getAttribute("user") == null
                           || (String) session1.getAttribute("admin") == "admin") {
       %><jsp:forward page="login.jsp?msg=Please Login" />
       <%
              }
       %> 
       

       <%
              if (((String) session.getAttribute("admin") == "user")) {
       %>



       <%@ include file="header_users.jsp"%>
       <div id="templatemo_content"/>

              <%@ include file="common_left_userview.jsp"%>
              <%
                     }
              %>


              <%
                     if (((String) session.getAttribute("admin") == "viewer")) {
              %>



              <%@ include file="header_viewer.jsp"%>
              <div id="templatemo_content"/>

                     <%@ include file="common_left.jsp"%>
                     <%
                           }
                     %>
	

		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto">
			<div class="header_01" >Module Details</div>
<div id="search">
				<div id="scrollable"   style="font-size: 14px;">
						<table class="table2 table_align" >
							
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								
								<td>Module Name</td>
								<td>Module Description</td>
								
								<td>Project</td>
							</tr>
							</thead>
						
							<tbody>
							<jstlcore:forEach items="${ModuleList}" var="item">
								<tr>
									<td><jstlcore:out value="${item.moduleName}" /></td>
									
									<td><jstlcore:out value="${item.moduleDescription}" /></td>
									<td><jstlcore:out value="${item.projectId}" /></td>
								</tr>
							</jstlcore:forEach></tbody></table>
							
					</div>
<br/><br/>
<div style="color: red;font-size: 12px">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>
				</div>
<div id="ajaxResponse"></div>
				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
	
			<%@ include file="footer.jsp" %>   


  

</body>
</html>