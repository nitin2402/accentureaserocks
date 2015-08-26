/**
 * 
 */

function validateForm() {

		var numbers = /^[0-9]+$/; 
		var nase = document.forms["requestForm"]["NASE"].value;
		var nse = document.forms["requestForm"]["NSE"].value;
		var nsse = document.forms["requestForm"]["NSSE"].value;
		var comment = document.forms["requestForm"]["comment"].value;
		var specificComment = document.forms["requestForm"]["specificComment"].value;
		
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
		if (document.getElementById('isSpecific').checked) 
		  {
			if (specificComment == null || specificComment == "") {
				alert("Please provide specific comment");
				return false;
			}
		  }
		
	}

function setTenure(){
	var str = $('#emp').val();
	 var res = str.split("_");
	 var date = res[1].split("-");
	 var months = -1;
	 switch (date[1]) {
	  case "Jan":
		  	months = 0 ;
	        break;
	  case "Feb": 
		  	months = 1 ;
	        break;
	  case "Mar":
		  	months = 2 ;
		  	break;
	  case "Apr":
		  	months = 3 ;
		  	break;
	  case "May":  
		  	months = 4 ;      
	        break;
	  case "Jun":
		  	months = 5 ;
	        break;
	  case "Jul": 
		  	months = 6 ;
	        break;
	  case "Aug":
		  	months = 7 ;
		  	break;
	  case "Sep":  
		  	months = 8 ;
	        break;
	  case "Oct":
		  	months = 9 ;
		  	break;
	  case "Nov":  
		  	months = 10 ;
	        break;
	  case "Dec":
		  	months = 11 ;
		  	break;
	}
	 var d1 = new Date(date[2],months,date[0]);			//Date of Joining
	 var d2 = new Date();								// Current Date
	 var oneMonth = 30*24*60*60*1000; 					// days*hours*minutes*seconds*milliseconds
	 var diffDays = Math.round(Math.abs((d1.getTime() - d2.getTime())/(oneMonth)));
	 $('#tenure').text(diffDays+" Months");
}

function setInfo(){
	var str = $('#emp').val();
	 var res = str.split("_");
		 if(res[2] == "YES"){
			 $('#info').text("Resource Billable in " + res[3] + " team");
		 } else{
			 $('#info').text("Resource is free");
		 }
}

function calc()
{
  if (document.getElementById('isSpecific').checked) 
  {
	  $('#isSpecific').val("True");
	  $('#level').attr("disabled", false);
	  $('#emp').attr("disabled", false);
	  $('#specificComment').attr("disabled", false);
	 
  } else{
	  $('#isSpecific').val("False");
	  $('#level').attr("disabled", true);
	  $('#emp').attr("disabled", true);
	  $('#specificComment').attr("disabled", true);
  }
}

function myFunction(){
	 $('#isSpecific').val("False");
	 $('#level').attr("disabled", true);
	 $('#emp').attr("disabled", true);
	 $('#specificComment').attr("disabled", true);
}




