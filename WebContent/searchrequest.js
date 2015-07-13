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
			
			
	
		}
		

