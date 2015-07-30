$(document).ready(function(){

        $("#empCss").css({
           
            	"font-weight": "bold",
            	"text-decoration": "underline"
        });
    });


	function SelectSheetNo(e) {
		var sheet = prompt("please enter sheet number", "1");

		$("#sheetno").val(sheet);

		if (sheet == null || sheet == "") {
			alert("please enter sheet number");
			return false;
		} else {
			 alert("PLEASE ENSURE THAT THE PROJECT,MODULE,TEAM names are correct.YOU MAY REFER TO SHEET 2,3,4 OF THE ABOVE LINK."); 
			return true;
		}
	}
	
	var validFileExtensions = [".xlsx", ".xls"];    
	function Validate(vaildateObj) {
	    var getFileName = vaildateObj.getElementsByTagName("input");
	  
	    for (var i = 0; i < getFileName.length; i++) {
	        var fileInput = getFileName[i];
	        if (fileInput.type == "file")
	        	  var fileName = fileInput.value;
	        {
	        	  if (fileName == "" ||fileName==null || fileName==0)  
	                  
	              {
	              	alert("please select a excel file to upload");
	              		return false;
	              } 
	        	  else{
	          
	            if (fileName.length > 0) {
	                var isValid = false;
	                for (var j = 0; j < validFileExtensions.length; j++) {
	                    var extensions = validFileExtensions[j];
	                    if (fileName.substr(fileName.length - extensions.length, extensions.length).toLowerCase() == extensions.toLowerCase()) {
	                        isValid = true;
	                       
	                        return SelectSheetNo();
	                    }
	                }  
	                if (!isValid) {
	                    alert("Sorry " + fileName + " is invalid, allowed extensions are: " + validFileExtensions.join(", "));
	                    return false;
	                }
	                
	            }
	            
	            
	            }
	          
	        }
	    }
	  
	    
	}