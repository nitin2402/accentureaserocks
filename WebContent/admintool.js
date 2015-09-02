
$(document).ready(function(){
	  $("#accordion").show().accordion({
	        active: false,
	        autoHeight: false,
	        navigation: true,
	        collapsible: true
	    });
		$("#employee,#authorize,#modl,#team,#emp").hide();
	  collapsible: true;
        $("#empCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

function changeTextBox() {
	var val = $('#select').val();
	var val1 = $('#select1').val();
	/*var val = $('#select1').val();*/
	if (val === 'default') {
		$("#employee,#authorize").hide();
		
	}

	else if (val === 'employee') {
		$("#authorize").hide();
		$("#employee").show();
	}

	else if (val === 'authorize') {
		$("#authorize").show();
		$("#employee").hide();
	}
	
	if (val1 === 'default') {
		$("#modl,#team,#emp").hide();
		
	}else if (val1 === 'modl1') {
		$("#modl").show();
		$("#emp,#team").hide();
	}else if (val1 === 'team1') {
		$("#team").show();
		$("#emp,#modl").hide();
	}else if (val1 === 'emp1') {
		$("#emp").show();
		$("#modl,#team").hide();
	}

}


function validateform2() {

	if ( ( !document.getElementById('excel').checked  ) && ( !document.getElementById('manually').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}}
function validateform1() {
	if ( ( !document.getElementById('excel1').checked  ) && ( !document.getElementById('manually1').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}}
function validateform() {
	if ( ( !document.getElementById('excel2').checked  ) && ( !document.getElementById('manually2').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}
}


	function validateAdmin(){
		

		 if ($("input[name=select]").is(":checked")) {
			 
			var id = $("input[name=select]:checked").val();
		   var desig = $('#'+id).val();
	 
		if(desig == 'ASE' || desig == 'SE' || desig == 'SSE' || desig == 'TL'){
		    var answer = confirm('Designation Mismatch !!! Do you want to approve?');
			if (answer)
			{
			  return true;
			}
			else
			{
				  return false;
			}
			 
		}
		else if(desig == 'AM' || desig == 'M' || desig == 'SM' || desig == 'Accenture Leadership'){
			return true;
		}
		 }else{
			   alert("Nothing is checked");
			   return false;
			 }
	}
		
		


	function validateUser(){
		if ($("input[name=select]").is(":checked")) {
		var id = $("input[name=select]:checked").val();
		var desig = $('#'+id).val();
		
		if(desig == 'ASE' || desig == 'SE' || desig == 'SSE' ){
		    var answer = confirm('Designation Mismatch !!! Do you want to approve?');
			if (answer)
			{
			  return true;
			}
			else
			{
				  return false;
			}
			 
		}
		else if( desig == 'TL'|| desig == 'AM' || desig == 'M' || desig == 'SM' || desig == 'Accenture Leadership'){
			return true;
		}
		}else{
			   alert("nothing is checked");
			   return false;
			 }
		
	}

	function validateViewer(){
		if ($("input[name=select]").is(":checked")) {
		var id = $("input[name=select]:checked").val();
		var desig = $('#'+id).val();
		 if( desig == 'TL'|| desig == 'AM' || desig == 'M' || desig == 'SM' || desig == 'Accenture Leadership'){
			var answer = confirm('Designation Mismatch !!! Do you want to approve?');
			if (answer)
			{
			  return true;
			}
			else
			{
		      return false;
			}
		 }
			else if(desig == 'ASE' || desig == 'SE' || desig == 'SSE' ){
			    return true;
			}
		}else{
				   alert("nothing is checked");
				   return false;
				 }
			 
		
	}

	function validateEmp() {

		  var chx = document.getElementsByTagName('input');
		  for (var i=0; i<chx.length; i++) {
		   
		    if (chx[i].type == 'radio' && chx[i].checked) {
		      return true;
		    } 
		  }
		  alert("Please select a radio button");
		  return false;
					
	}
	function validation() {
		  var chx = document.getElementsByTagName('input');
		  for (var i=0; i<chx.length; i++) {
		   
		    if (chx[i].type == 'radio' && chx[i].checked) {
		      return true;
		    } 
		  }
		  alert("Please select a radio button");
		  return false;	
		}
	