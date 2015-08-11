/**
 * 
 */

function validateForm() {
	  var chx = document.getElementsByTagName('input');
	  for (var i=0; i<chx.length; i++) {
	   
	    if (chx[i].type == 'radio' && chx[i].checked) {
	      return true;
	    } 
	  }
	  alert("Please select a request");
	  return false;	
	}
	
function validateButtonRejected() {

	var chx = document.getElementsByTagName('input');
	var reason = document.forms["actionForm"]["reason"].value;
	var isChecked = false ;
	  for (var i=0; i<chx.length; i++) {
	   
	    if (chx[i].type == 'radio' && chx[i].checked) {
	    	isChecked = true ;
	    	break;
	    } 
	  }
	  
	  if(!isChecked){
		  alert("Please select a request");
		  return false;	
	  }
	  else if (reason == null || reason == "") {
			alert("Please provide reason.");
			return false;
		}
}
	
		function validateButtonOnHold() {

			var chx = document.getElementsByTagName('input');
			var reason = document.forms["actionForm"]["reason"].value;
			var isChecked = false ;
			  for (var i=0; i<chx.length; i++) {
			   
			    if (chx[i].type == 'radio' && chx[i].checked) {
			    	isChecked = true ;
			    	break;
			    } 
			  }
			  
			  if(!isChecked){
				  alert("Please select a request");
				  return false;	
			  }
			
			  else if (reason == null || reason == "") {
					alert("Please provide reason.");
					return false;
				}
		}
		
		
		

