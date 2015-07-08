<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="searchrequest.js"></script> 
<script type="text/javascript" src="action.js"></script> 

<script src="https://www.google.com/jsapi"></script>

</head>
<body>

<jsp:include page="/SearchRequestServlet" />

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

			<div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Budget Calculation</div>
				<h2 style="color:white;">Current Team Budget</h2>
				
				<form name="calculateForm"  >
						<div id="scrollable"   style="font-size: 14px;">
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>Number of Resources</td>
								<td>Designation</td>
								<td>Amount</td>
							</tr>
							</thead>
						
							<tbody  >
							
							<tr>
									<td>${workplanAdminDTO.currentASE} </td>
									<td>ASE </td>
									<td>${workplanAdminDTO.currentASEValue} ${workplanAdminDTO.aseCurrency } </td>
									
							</tr>
							
							<tr>
									<td>${workplanAdminDTO.currentSE} </td>
									<td>SE </td>
									<td>${workplanAdminDTO.currentSEValue} ${workplanAdminDTO.seCurrency }</td>
									
							</tr>
							
							<tr>
									<td>${workplanAdminDTO.currentSSE} </td>
									<td>SSE </td>
									<td>${workplanAdminDTO.currentSSEValue} ${workplanAdminDTO.sseCurrency }</td>
									
							</tr>
							
							<tr>
									<td>${workplanAdminDTO.currentTL} </td>
									<td>TL </td>
									<td>${workplanAdminDTO.currentTLValue} ${workplanAdminDTO.tlCurrency }</td>
									
							</tr>
							</tbody>
							</table>
							<p style="color:black">Sum : ${workplanAdminDTO.totalCurrentValue } ${workplanAdminDTO.tlCurrency }</p>
							
                        </div>
						<div>
						<input type="hidden" id="sum" name="sum" value="${workplanAdminDTO.totalCurrentValue }"/>
						Total Budget &nbsp; <input type="text" id="total_budget" name="total_budget" onblur="validateForm()"/>
						Balance &nbsp; <input type="text" id="balance" disabled="disabled" name="balance"/>
						</div>
						
						<h2 style="color:white;">Requested Resource Budget</h2>
				        <div id="scrollable"   style="font-size: 14px;">
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>Number of Resources</td>
								<td>Designation</td>
								<td>Amount</td>
							</tr>
							</thead>
						
							<tbody  >
							
							<tr>
									<td>${workplanAdminDTO.aseRequested} </td>
									<td>ASE </td>
									<td>${workplanAdminDTO.aseRequestedValue} ${workplanAdminDTO.aseCurrency } </td>
									
							</tr>
							
							<tr>
									<td>${workplanAdminDTO.seRequested} </td>
									<td>SE </td>
									<td>${workplanAdminDTO.seRequestedValue} ${workplanAdminDTO.seCurrency }</td>
									
							</tr>
							
							<tr>
									<td>${workplanAdminDTO.sseRequested} </td>
									<td>SSE </td>
									<td>${workplanAdminDTO.sseRequestedValue} ${workplanAdminDTO.sseCurrency }</td>
									
							</tr>
							
							</tbody>
							</table>
							<p style="color:black">Sum : ${workplanAdminDTO.totalRequestedValue } ${workplanAdminDTO.tlCurrency }</p>
							
                        </div>
						
                        </form>
                       <center> <a href="searchrequest.jsp">OK</a></center>
					</div>
					<br/><br/>
					<div style="color: red;font-size: 12px">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>

			</div>

</body>
</html>