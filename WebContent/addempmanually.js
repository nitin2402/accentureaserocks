     
$(document).ready(function(){

        $("#empCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });


$(function(){$("#mdl").chained("#prj");
$("#tem").chained("#mdl")});

$(function(){$("#desig").chained("#level");
$("#tem12").chained("#desig");
});

var specialKeys = new Array();

        specialKeys.push(8); //Backspace

        function IsNumeric1(e) {

            var keyCode = e.which ? e.which : e.keyCode

            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);

            document.getElementById("error").style.display = ret ? "none" : "inline";

            return ret;

        }
        function validateform()
    	{
    	
    	var name=document.forms["add"]["name"].value;
    	var id=document.forms["add"]["idno"].value;
    	var level=document.forms["add"]["level"].value;
    	var designation=document.forms["add"]["desig"].value;
    	var expertise=document.forms["add"]["area"].value;

    	var email=document.forms["add"]["email"].value;

    	var cams=document.forms["add"]["camps"].value;
    	var cost=document.forms["add"]["cost"].value;
    	var from = $("#calendar").val(); 
    	var to = $("#calendar1").val();
    	
      if (name==null || name=="")
    	  {
    	  alert("Please provide Name");
    	  return false;
    	  }
    		if (id==null || id=="")
    	  {
    	  alert("Please provide Employee ID");
    	  return false;
    	  }
    	if (level==null || level=="")
    	  {
    	  alert("Please provide level");s
    	  return false;
    	  }
    	if (designation==null || designation=="")
    	  {
    	  alert("Please provide designation");
    	  return false;
    	  }
    	if (expertise==null || expertise=="")
    	  {
    	  alert("Please provide Expertise");
    	  return false;	
    	  }
    	if (email==null || email=="")
    	  {
    	  alert("Please provide Email");
    	  return false;
    	  } 
    	if (cams==null || cams=="")
    	  {
    	  alert("Please provide Proficiency in CAMS");
    	  return false;
    	  }  
    	if (cost==null || cost=="")
    	  {
    	  alert("Please provide cost of the employee");
    	  return false;
    	  }  
    	if (from == "" || from == null){
    		alert("Please enter Date Of joining");
    		return false;
    	}

    	if(Date.parse(from) > Date.parse(to)){
    	   alert("Last Date Of Working must be after Date Of Joining");
    	   return false;
    	}
    	 
    	
    	    var filter = /^[a-zA-Z0-9._-]+@accenture.com$/;
    	    var filter2 = /^[0-9]{8}$/;
    	    var filter3 = /^[0-9]{1,2}$/;
    	if (filter.test(email)) {
    	       
    	    }
    	    else {
    	    	alert("Enter Valid Email");
    	        return false;
    	    }
    	    if (client.length == 6) {
    	        
    	    }
    	    else {
    	    	alert("Enter Valid Client Id ");
    	        return false;
    	    }
    	    if (filter2.test(id)) {
    	      
    	    }
    	    else {
    	    	alert("Enter Valid Employee Id");
    	        return false;
    	    }
    	    if (filter3.test(level)) {
    		       
    	    }
    	    else {
    	    	alert("Enter Valid Level");
    	        return false;
    	    } 

    	    
    	
    	}