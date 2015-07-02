/**
 * 
 */

function validateForm() {

		var myOption = -1;
		for (var i=actionForm.select.length-1; i > -1; i--) {
		if (actionForm.select[i].checked) {
		myOption = i; i = -1;
		}
		}
		if (myOption == -1) {
		alert("Please select a request.");
		return false;
		}
					
	}

function validateButtonAccepted() {

	var myOption = -1;
	for (var i=actionForm.select.length-1; i > -1; i--) {
	if (actionForm.select[i].checked) {
	myOption = i; i = -1;
	}
	}
	if (myOption == -1) {
	alert("Please select a request.");
	return false;
	}
	
	var reason = document.forms["actionForm"]["reason"].value;
	
		if (reason == null || reason == "") {
			alert("Please provide reason.");
			return false;
		}
		else{
		alert("accepted");
		return true;
		}
	
	
		}
	
function validateButtonRejected() {

	var myOption = -1;
	for (var i=actionForm.select.length-1; i > -1; i--) {
	if (actionForm.select[i].checked) {
	myOption = i; i = -1;
	}
	}
	if (myOption == -1) {
	alert("Please select a request.");
	return false;
	}
	
	var reason = document.forms["actionForm"]["reason"].value;
	
		if (reason == null || reason == "") {
			alert("Please provide reason.");
			return false;
		}
		else{
		alert("rejected");
		return true;
		}
}
	
		function validateButtonOnHold() {

			var myOption = -1;
			for (var i=actionForm.select.length-1; i > -1; i--) {
			if (actionForm.select[i].checked) {
			myOption = i; i = -1;
			}
			}
			if (myOption == -1) {
			alert("Please select a request.");
			return false;
			}
			
			var reason = document.forms["actionForm"]["reason"].value;
			
				if (reason == null || reason == "") {
					alert("Please provide reason.");
					return false;
				}
				else{
				alert("On Hold");
				return true;
				}
			
			
	
		}
		

