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
<script type='text/javascript' src='searchAdmin.js'></script>
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

			<div class="right_col_section_w650" style="height: 500px" >
					<div id="search" style="font-size: 14px;">

			
				<div class="header_01" >Assign Resources </div>
				<h2 style="color:white;">Request - <font color="#00FFFF">${reqId}</font> &nbsp; for Team - <font color="#00FFFF">${workplanAdminDTO.teamName}</font> </h2>
			<font size="3" color="#00FFFF">	[ASE - ${workplanAdminDTO.aseRequested}, SE - ${workplanAdminDTO.seRequested}, SSE -${workplanAdminDTO.sseRequested}]</font>
					<br/>
				<form name="calculateForm" action="AcceptRequestServlet"  onsubmit="return validateForm()"  method="post">
						<br/>
						<div id="scrollable"   style="font-size: 14px;">
						
						<table class="table2" > 
							<thead style="font-weight:bold;position: ">
							<tr class="one table_align" style="font-weight:bold;">
								<td>Designation</td>
								<td>Select</td>
								<td>Employee Name</td>
								<td>LCR</td>
							</tr>
							</thead>
						
							<tbody  >
							 <jstlcore:forEach var="i" begin="1" end="${workplanAdminDTO.aseRequested }">

								<tr class="table_align">
									<td>ASE</td> 
									<td class = "devraj"><input  type="checkbox" name="empASE[]" id="asebx_${i}"/></td> 
									<td>
											<select name="employeeNameASE" id="a${i}" onchange="setLCR_ASE(${i});inputUpdateASE(${i});" class="dropbox_size">
												<option value=""></option>
												<jstlcore:forEach items="${workplanAdminDTO.freeASEList}" var="item">
												        <option	value="${item.key}_${item.value[1]}_${item.value[0]}" > 
																<jstlcore:out value="${item.value[0]}" ></jstlcore:out>
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

								<tr class="table_align">
									<td>SE</td>
									<td><input type="checkbox" name="empSE[]" id="sebx_${i}" /></td>
									<td>
											<select name="employeeNameSE" id="b${i}" onchange="setLCR_SE(${i});inputUpdateSE(${i});" class="dropbox_size">
											<option value=""></option>
												<jstlcore:forEach items="${workplanAdminDTO.freeSEList}" var="item">
 														<option	value="${item.key}_${item.value[1]}_${item.value[0]}" > 
																<jstlcore:out value="${item.value[0]}" ></jstlcore:out>
												        </option>
												</jstlcore:forEach>			
											</select>
									</td>
									<td>
											<input type="text" disabled="disabled" name="mytext" id="se${i}" value=""/>
									</td>
								</tr>
							</jstlcore:forEach>
							
							<jstlcore:forEach var="i" begin="1" end="${workplanAdminDTO.sseRequested }">

								<tr class="table_align">
									<td>SSE</td>
									<td><input type="checkbox" name="empSSE[]" id="ssebx_${i}"/></td>
									<td>
											<select name="employeeNameSSE" id="c${i}" onchange="setLCR_SSE(${i});inputUpdateSSE(${i});" class="dropbox_size">
											<option value=""></option>
												<jstlcore:forEach items="${workplanAdminDTO.freeSSEList}" var="item">
														 <option	value="${item.key}_${item.value[1]}_${item.value[0]}" > 
																<jstlcore:out value="${item.value[0]}" ></jstlcore:out>
												        </option>
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
							<br/>
								<font size="4">	Current Average LCR</font> -<font color="blue" size="4"> ${workplanAdminDTO.currentAvg}</font>
								
						<br/><br/>
						<font size="4">	New Average LCR</font> - 
						<input type="text" name="newAverage" disabled="disabled" id="newAverage"/>
						<input type="button"  name="calculate" value="Calculate"  onclick="cal(${workplanAdminDTO.total}, ${workplanAdminDTO.numberOfEmployee})"/> &nbsp; 
						
						<br /><br />
						<font size="2">*Reason</font> &nbsp; <textarea rows="3" cols="25" id="reason" name="reason"></textarea>
						
						<input type="hidden" name="reqId" value="${reqId }"/>
						<br />
							<input type="submit"  name="action" value="Assign"/>
							<input type="reset" value="Reset"/>
							</div>
						
                        </form>
					</div>
					<div id="ajaxResponse"></div>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="margin_bottom_20">&nbsp;</div>
				</div>
<%@ include file="footer.jsp" %> 
			</div>

</body>
</html>