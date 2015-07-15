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

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>

<script>

	function SelectSheetNo() {
		var sheet = prompt("please enter sheet number", "1");

		$("#sheetno").val(sheet);

		if (sheet == null || sheet == "") {
			alert("please enter sheet number");
			return false;
		} else {

			return true;
		}
	}
</script> 

 <script >
var validFileExtensions = [".xlsx", ".xls"];    
function Validate(vaildateObj) {
    var getFileName = vaildateObj.getElementsByTagName("input");
  
    for (var i = 0; i < getFileName.length; i++) {
        var fileInput = getFileName[i];
        if (fileInput.type == "file")
        	  var fileName = fileInput.value;
        {
        	  if (fileName == "" ||fileName==null || fileName==0)  
                  
              {
              	alert("please select a excel file to upload");
              		return false;
              } 
        	  else{
          
            if (fileName.length > 0) {
                var isValid = false;
                for (var j = 0; j < validFileExtensions.length; j++) {
                    var extensions = validFileExtensions[j];
                    if (fileName.substr(fileName.length - extensions.length, extensions.length).toLowerCase() == extensions.toLowerCase()) {
                        isValid = true;
                       /*  alert("success"); */
                        return SelectSheetNo();
                    }
                }  
                if (!isValid) {
                    alert("Sorry " + fileName + " is invalid, allowed extensions are: " + validFileExtensions.join(", "));
                    return false;
                }
                
            }
            
            
            }
          
        }
    }
  
    
}
</script> 

<script type='text/javascript' src='search.js'></script>
</head>
<body>
<%@ include file="header_admin.jsp" %>  
	
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
			

						<form action=" AddTeamExcel" method="post" onsubmit="return Validate(this);">
						
						Choose the Excel File to Upload:-
						<input type="file" name="file1" size="50" /> <br /> <br /> <br />
						<input type="hidden" id="sheetno" name="sheetno" />
						<br /> <input type="submit" value="SUBMIT" />
						</form>
						<br />
						
					</div>
					<div id="ajaxResponse"></div>



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