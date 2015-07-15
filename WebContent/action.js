/**
 * 
 */
function setLCR_ASE(a){
	var str = $('#a'+a).val();
	 var res = str.split("_");
	$('#ase'+a).val(res[0]);
}

function setLCR_SE(a){
	var str = $('#b'+a).val();
	 var res = str.split("_");
	$('#se'+a).val(res[0]);
}

function setLCR_SSE(a){
	var str = $('#c'+a).val();
	 var res = str.split("_");
	$('#sse'+a).val(res[0]);
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
	var vals = 0;
	var newAverage = 0;
	var count = 0;
	for (var i=0, n=checkboxes1.length;i<n;i++) {
	  if (checkboxes1[i].checked) 
	  {
		  var res = (checkboxes1[i].value).split("_");
		  vals += parseFloat(res[0]);
		  count++;
	  }
	}
	for (var i=0, n=checkboxes2.length;i<n;i++) {
		  if (checkboxes2[i].checked) 
		  {
			  var res = (checkboxes2[i].value).split("_");
			  vals += parseFloat(res[0]);
			  count++;
		  }
		}
	for (var i=0, n=checkboxes3.length;i<n;i++) {
		  if (checkboxes3[i].checked) 
		  {
			  var res = (checkboxes3[i].value).split("_");
			  vals += parseFloat(res[0]);
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
	
	if(count == 0){
		alert("For accepting the request " + "\n" + " you must assign atlest one resource.");
		return false ;
	}
	
	else if (reason == null || reason == "") {
		alert("Please provide reason");
		return false;
	}
	
	else {
		var r = confirm("Are you sure ?");
		return r ;
	}
}

