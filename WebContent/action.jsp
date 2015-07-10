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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	

	
	
<script type="text/javascript" src="action.js"></script> 

<script src="https://www.google.com/jsapi"></script>

</head>
<body>


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

		<%@ include file="common_left.jsp"%>
		
		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Assign Resources </div>
				<h2 style="color:white;">Request - ${reqId} FOR Team - ${teamName} </h2>
				[ASE - ${workplanAdminDTO.aseRequested}, SE - ${workplanAdminDTO.seRequested}, SSE -${workplanAdminDTO.sseRequested}]
					<br/>
				<form name="calculateForm"  >
						
						<div id="scrollable"   style="font-size: 14px;">
						
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one" style="font-weight:bold;">
								<td>Designation</td>
								<td>Select</td>
								<td>Employee Name</td>
								<td>LCR</td>
							</tr>
							</thead>
						
							<tbody  >
							 <jstlcore:forEach var="i" begin="1" end="${workplanAdminDTO.aseRequested }">

								<tr>
									<td>ASE</td>
									<td class = "devraj"><input  type="checkbox" name="empASE[]" /></td>
									<td>
											<select name="employeeNameASE" id="a${i}" onchange="setLCR_ASE(${i})">
												<option value=""></option>
												<jstlcore:forEach items="${workplanAdminDTO.freeASEList}" var="item">
														<option	value="${item.value}" > 
															<jstlcore:out value="${item.key}" ></jstlcore:out>
														</option>
												</jstlcore:forEach>			
											</select>
									</td>
									<td>
											<input type="text" disabled="disabled" name="mytext" id="ase${i}"/>
									</td>
								</tr>
							</jstlcore:forEach>
							
							<jstlcore:forEach var="i" begin="1" end="${workplanAdminDTO.seRequested }">

								<tr>
									<td>SE</td>
									<td><input type="checkbox" name="empSE[]" value="document.getElementByName(employeeNameSE)" /></td>
									<td>
											<select name="employeeNameSE" id="b${i}" onchange="setLCR_SE(${i})">
											<option value=""></option>
												<jstlcore:forEach items="${workplanAdminDTO.freeSEList}" var="item1">
														<option	value="${item1.value}" > <jstlcore:out value="${item1.key}" ></jstlcore:out></option>
												</jstlcore:forEach>			
											</select>
									</td>
									<td>
											<input type="text" disabled="disabled" name="mytext" id="se${i}" value=""/>
									</td>
								</tr>
							</jstlcore:forEach>
							
							<jstlcore:forEach var="i" begin="1" end="${workplanAdminDTO.sseRequested }">

								<tr>
									<td>SSE</td>
									<td><input type="checkbox" name="empSSE[]" value="" /></td>
									<td>
											<select name="employeeNameSSE" id="c${i}" onchange="setLCR_SSE(${i})">
											<option value=""></option>
												<jstlcore:forEach items="${workplanAdminDTO.freeSSEList}" var="item1">
														<option	value="${item1.value}" > <jstlcore:out value="${item1.key}" ></jstlcore:out></option>
												</jstlcore:forEach>			
											</select>
												
									</td>
									<td>
											<input type="text" disabled="disabled" name="mytext" id="sse${i}"/>
									</td>
								</tr>
							</jstlcore:forEach>
							
							</tbody></table>
							</div>
							
							<div>
									Current Average LCR - ${workplanAdminDTO.currentAvg}
									<!-- Total Budget &nbsp; <input type="text" id="total_budget" name="total_budget" onblur="validateForm()"/>
						Balance &nbsp; <input type="text" id="balance" disabled="disabled" name="balance"/> -->
						<br />
						<input type="submit"  name="calculate" value="Calculate" /> &nbsp; 
						<input type="text" name="newAverage" disabled="disabled" id="newAverage"/>
						<br /><br />
						*Reason &nbsp; <textarea rows="3" cols="25" id="reason" name="reason"></textarea>
						
						
						<br />
							<input type="submit"  name="action" value="Assign"  onclick="calculate()"/>
									
							</div>
						
                        </form>
					</div>
					<br/><br/>
					<div style="color: red;font-size: 12px">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>

			</div>

</body>
</html>