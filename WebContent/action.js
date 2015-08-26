/**
 * 
 */
function setLCR_ASE(a){
	var str = $('#a'+a).val();
	 var res = str.split("_");
	$('#ase'+a).val(res[1]);
}

function setLCR_SE(a){
	var str = $('#b'+a).val();
	 var res = str.split("_");
	$('#se'+a).val(res[1]);
}

function setLCR_SSE(a){
	var str = $('#c'+a).val();
	 var res = str.split("_");
	$('#sse'+a).val(res[1]);
}

function inputUpdateASE(id){
	var str = $('#a'+ id).val();
	document.getElementById("asebx_"+ id).value = str;
}

function inputUpdateSE(id){
	var str = $('#b'+ id).val();
	document.getElementById("sebx_"+ id).value = str;
}

function inputUpdateSSE(id){
	var str = $('#c'+ id).val();
	document.getElementById("ssebx_"+ id).value = str;
}

function cal(total, numberOfEmployee){
	
	var checkboxes1 = document.getElementsByName('empASE[]');
	var checkboxes2 = document.getElementsByName('empSE[]');
	var checkboxes3 = document.getElementsByName('empSSE[]');
	
	var isDuplicate = false;
	var nameOfAse = {};
	var nameOfSe = {};
	var nameOfSse = {};
	
	var vals = 0;
	var newAverage = 0;
	var count = 0;
	
	var specificReq = document.getElementById("specificReq");
	 if (specificReq.checked) 
	  {
		 var specificReqDetails = (specificReq.value).split("_");
		  if(specificReqDetails[2] == "ASE"){
			  nameOfAse[specificReqDetails[0]] = 1 ;
		  } else if(specificReqDetails[2] == "SE"){
			  nameOfSe[specificReqDetails[0]] = 1 ;
		  } else if(specificReqDetails[2] == "SSE"){
			  nameOfSse[specificReqDetails[0]] = 1 ;
		  }
		  vals += parseFloat(specificReqDetails[1]);
		  count++;
	  }

	for (var i=0, n=checkboxes1.length;i<n;i++) {
		  if (checkboxes1[i].checked) 
		  {
			  
			  var res = (checkboxes1[i].value).split("_");
			  
			  if(nameOfAse[res[0]] == null){
				  nameOfAse[res[0]] = 1;
			  }else{
				  var count1 = nameOfAse[res[0]];
				  nameOfAse[res[0]]= ++count1;
			  }
		  }
		}
	
	for (var k in nameOfAse){
	         if(nameOfAse[k] > 1){
	        	 isDuplicate = true ;
	        	 break;
	         }
	}
	
	if(isDuplicate){
		alert("You can't calculate LCR "+ "\n" +"by assigning same resource more than once.");
		return false;
	}
	
	for (var i=0, n=checkboxes2.length;i<n;i++) {
		  if (checkboxes2[i].checked) 
		  {
			  var res = (checkboxes2[i].value).split("_");
			  
			  if(nameOfSe[res[0]] == null){
				  nameOfSe[res[0]] = 1;
			  }else{
				  var count1 = nameOfSe[res[0]];
				  nameOfSe[res[0]]= ++count1;
			  }
		  }
		}
	
	for (var k in nameOfSe){
	         if(nameOfSe[k] > 1){
	        	 isDuplicate = true ;
	        	 break;
	         }
	}
	
	if(isDuplicate){
		alert("You can't calculate LCR "+ "\n" +"by assigning same resource more than once.");
		return false;
	}
	
	for (var i=0, n=checkboxes3.length;i<n;i++) {
		  if (checkboxes3[i].checked) 
		  {
			  var res = (checkboxes3[i].value).split("_");
			  
			  if(nameOfSse[res[0]] == null){
				  nameOfSse[res[0]] = 1;
			  }else{
				  var count1 = nameOfSse[res[0]];
				  nameOfSse[res[0]]= ++count1;
			  }
		  }
		}
	
	for (var k in nameOfSse){
	         if(nameOfSse[k] > 1){
	        	 isDuplicate = true ;
	        	 break;
	         }
	}
	
	if(isDuplicate){
		alert("You can't calculate LCR "+ "\n" +"by assigning same resource more than once.");
		return false;
	}
	
	for (var i=0, n=checkboxes1.length;i<n;i++) {
	  if (checkboxes1[i].checked) 
	  {
		  var res = (checkboxes1[i].value).split("_");
		  vals += parseFloat(res[1]);
		  count++;
	  }
	}
	for (var i=0, n=checkboxes2.length;i<n;i++) {
		  if (checkboxes2[i].checked) 
		  {
			  var res = (checkboxes2[i].value).split("_");
			  vals += parseFloat(res[1]);
			  count++;
		  }
		}
	for (var i=0, n=checkboxes3.length;i<n;i++) {
		  if (checkboxes3[i].checked) 
		  {
			  var res = (checkboxes3[i].value).split("_");
			  vals += parseFloat(res[1]);
			  count++;
		  }
		}
	newAverage = (total + vals)/(numberOfEmployee + count);
	document.getElementById("newAverage").value = newAverage ;
}

function validateForm(){

	var reason = document.forms["calculateForm"]["reason"].value;
	var checkboxes1 = document.getElementsByName('empASE[]');
	var checkboxes2 = document.getElementsByName('empSE[]');
	var checkboxes3 = document.getElementsByName('empSSE[]');
	var count = 0;
	var isDuplicate = false;
	var nameOfAse = {};
	var nameOfSe = {};
	var nameOfSse = {};
	
	var specificReq = document.getElementById("specificReq");
	 if (specificReq.checked) 
	  {
		 var specificReqDetails = (specificReq.value).split("_");
		  if(specificReqDetails[2] == "ASE"){
			  nameOfAse[specificReqDetails[0]] = 1 ;
		  } else if(specificReqDetails[2] == "SE"){
			  nameOfSe[specificReqDetails[0]] = 1 ;
		  } else if(specificReqDetails[2] == "SSE"){
			  nameOfSse[specificReqDetails[0]] = 1 ;
		  }
		  count++;
	  }
	
	for (var i=0, n=checkboxes1.length;i<n;i++) {
		  if (checkboxes1[i].checked) 
		  {
			  count++;
		  }
		}
	for (var i=0, n=checkboxes2.length;i<n;i++) {
		  if (checkboxes2[i].checked) 
		  {
			  count++;
		  }
		}
	for (var i=0, n=checkboxes3.length;i<n;i++) {
		  if (checkboxes3[i].checked) 
		  {
			  count++;
		  }
		}

	for (var i=0, n=checkboxes1.length;i<n;i++) {
		  if (checkboxes1[i].checked) 
		  {
			  var res = (checkboxes1[i].value).split("_");
			  
			  if(nameOfAse[res[0]] == null){
				  nameOfAse[res[0]] = 1;
			  }else{
				  var count1 = nameOfAse[res[0]];
				  nameOfAse[res[0]]= ++count1;
			  }
		  }
		}
	
	for (var k in nameOfAse){
	         if(nameOfAse[k] > 1){
	        	 isDuplicate = true ;
	        	 break;
	         }
	}
	
	if(isDuplicate){
		alert("You can't assign same resource more than once.");
		return false;
	}
	
	for (var i=0, n=checkboxes2.length;i<n;i++) {
		  if (checkboxes2[i].checked) 
		  {
			  var res = (checkboxes2[i].value).split("_");
			  
			  if(nameOfSe[res[0]] == null){
				  nameOfSe[res[0]] = 1;
			  }else{
				  var count1 = nameOfSe[res[0]];
				  nameOfSe[res[0]]= ++count1;
			  }
		  }
		}
	
	for (var k in nameOfSe){
	         if(nameOfSe[k] > 1){
	        	 isDuplicate = true ;
	        	 break;
	         }
	}
	
	if(isDuplicate){
		alert("You can't assign same resource more than once.");
		return false;
	}
	
	for (var i=0, n=checkboxes3.length;i<n;i++) {
		  if (checkboxes3[i].checked) 
		  {
			  var res = (checkboxes3[i].value).split("_");
			  
			  if(nameOfSse[res[0]] == null){
				  nameOfSse[res[0]] = 1;
			  }else{
				  var count1 = nameOfSse[res[0]];
				  nameOfSse[res[0]]= ++count1;
			  }
		  }
		}
	
	for (var k in nameOfSse){
	         if(nameOfSse[k] > 1){
	        	 isDuplicate = true ;
	        	 break;
	         }
	}
	
	if(isDuplicate){
		alert("You can't assign same resource more than once.");
		return false;
	}
	else if(count == 0){
		alert("For accepting the request " + "\n" + " you must assign atlest one.");
		return false ;
	} 
	else if(reason == null || reason == "") {
		alert("Please provide reason");
		return false;
	}
	
	else {
		var r = confirm("Are you sure ?");
		return r ;
	}
	
}

