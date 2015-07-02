/**
 * 
 */
function validateForm() {

		var numbers = /^[0-9]+$/; 
		var total_budget = document.forms["calculateForm"]["total_budget"].value;
		if (total_budget == null || total_budget == "") {
			alert("Please provide total budget");
			return false;
		}
		else if(!total_budget.match(numbers))  
		{  
		alert('Please input numeric characters only');  
		return false;  
		}
		else{
			populateState();
		}
		
}

    
function populateState(){
	var xmlhttp = null;
	// TODO 1 - Create an XMLHttpRequest object and assign it to the variable xmlhttp
	xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState == 4){
			document.getElementById("balance").value = xmlhttp.responseText;
		}
	}
    
    var total_budget = document.getElementById("total_budget") ;
    var sum = document.getElementById("sum") ;
    // TODO 2 - Create a request to the server by using the open(method, url, [async])method of the XMLhttpRequest object, where method = "GET", url = "/ADFExtensionCodebaseM12Ajax_Faculty/AjaxStateandCapital?state="+str.value
    
   xmlhttp.open("GET","http://localhost:8080/TMT/BudgetServlet?total_budget="+total_budget.value+"&sum="+sum.value);

    //TODO 3 - Send the request
   xmlhttp.send();
}