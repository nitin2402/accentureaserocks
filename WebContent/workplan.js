/**
 * 
 */

function validateForm() {

		var numbers = /^[0-9]+$/; 
		var nase = document.forms["requestForm"]["NASE"].value;
		var nse = document.forms["requestForm"]["NSE"].value;
		var nsse = document.forms["requestForm"]["NSSE"].value;
		var comment = document.forms["requestForm"]["comment"].value;
		
		if (nase == null || nase == "") {
			alert("Please provide no of ASE");
			return false;
		}
		if(!nase.match(numbers))  
		{  
		alert("Please input positive numeric integers only");  
		return false;  
		} 
		if(!nse.match(numbers))  
		{  
		alert("Please input positive numeric integers only");  
		return false;  
		} 
		if(!nsse.match(numbers))  
		{  
		alert("Please input positive numeric integers only");  
		return false;  
		} 
		if (nse == null || nse == "") {
			alert("Please provide no of SE");
			return false;
		}
		if (nsse == null || nsse == "") {
			alert("Please provide no of SSE");
			return false;
		}
		if (comment == null || comment == "") {
			alert("Please provide comment");
			return false;
		}
		if (nase < 0 || nsse < 0 || nse < 0) {
			alert("Please provide valid number");
			return false;
		}
		if (nase > 15 || nsse > 15 || nse > 15) {
			alert("Number of resources can't exceeed 15");
			return false;
		}
		if (nase + nsse + nse == 0) {
			alert("For raising a request you must request for one resource at least.");
			return false;
		}
		
	}