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

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script>
$(document).ready(function(){

    $("#empCss").css({
       
        	"font-weight": "bold",
        	"text-decoration": "underline"
    });
});
</script>


<script type='text/javascript' src='search.js'></script>
<script type='text/javascript' src='addempexcel.js'></script>
</head>
<body>



	<%@ include file="header_admin.jsp"%>

	<%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />

	<%
		}
	%>
	<div id="templatemo_content">

		<%@ include file="common_left_admintool.jsp"%>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Select File to upload</div>


				<div>


					<div id="search" style="font-size: 14px;">
						<div>
							<a href="template/employee_excel.xlsx"> This link will open
								the Excel Sheet Template </a> <br /> <br /> <br />
						</div>
							<form action="AddEmployeeExcel" method="post"
							onsubmit="return Validate(this);" enctype="multipart/form-data">


							Choose the Excel File to Upload:- <input type="file" name="file1"
								size="50"
								style="border: solid 1px #D7C89D; background-color: #D7C89D; width: 50%; color: #8D5B13;" />



							<br /> <br /> <br /> <input type="hidden" id="sheetno"
								name="sheetno" /> <br /> <input type="submit" value="Submit" />
						</form>
						<br />

					</div>

					<div id="ajaxResponse"></div>
					<p class="error message">${message}</p>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>


</body>
</html>