<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript" src="workplan.js"></script>

</head>
<body>
	 <jsp:include page="/TeamListServlet" /> 
	<input type="hidden" id="backup" name="backup" value="0"></input>

	<%
		HttpSession session1 = request.getSession();
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}
	%> 
	
	<%@ include file="header_admin.jsp" %> 

	<div id="templatemo_content">

		<div id="content_left">


			<div class="margin_bottom_20">&nbsp;</div> 
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="viewEStrategy.jsp">E-Strategy</a></li>
						<li><a href="viewr3.jsp">R3</a></li>
						<li><a href="viewprimier.jsp">Primier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto;">

				<div class="header_01">Request</div>


				<div>
				Insert the number of resources you required.

					<div style="font-size: 14px;">
						<form name="requestForm" action="workplanServlet" onsubmit="return validateForm()"  method="post">
							<table>
								<tr>
									<td>

										<table>
											
											<tr style="height: 10px">
												<td></td>
											</tr>
											
											<tr>

												<td>PLEASE SELECT THE TEAM</td>
												<td><select name="teamName">
												<jstlcore:forEach items="${teamList}" var="item">
							
								<option	value="${item}" > <jstlcore:out value="${item}" ></jstlcore:out></option>
									
							
							</jstlcore:forEach>
														
												</select></td>
											</tr>
											<tr>
											<td>No Of ASE</td><td><input type="text" id="NASE" name="NASE" value="0"/></td>
											</tr>
											
											<tr>
											<td>No Of SE</td><td><input type="text" id="NSE" name="NSE" value="0"/></td>
											</tr>
							
											<tr>
											<td>No Of SSE</td><td><input type="text" id="NSSE" name="NSSE" value="0"/></td>
											</tr>
											
											<tr><td>Comment</td><td><textarea rows="5" cols="25" id="comment" name="comment"></textarea></td></tr>
											
											<tr style="height: 10px">
												<td />
											</tr>
											
										</table>
									</td>
									<td style="width: 60px"></td>
									<td>

									</td>
								</tr>
								
								<tr>
								<td></td><input type = "hidden" name ="userName" value ="${user}"/>
								</tr>
								<tr>
								<td><input type="submit" value="Submit" ></input>
								<input type="reset" value="Reset" ></input></td>
								</tr>
							</table>
							
						</form>
					</div>



					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
</body>
</html>