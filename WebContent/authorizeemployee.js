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
		   alert("nothing is checked");
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

$(document).ready(function(){

        $("#authCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });

	
	

