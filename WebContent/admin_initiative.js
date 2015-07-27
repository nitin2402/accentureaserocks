/**
 * 
 */
 
 var extension = ".pdf";    
	function Validate(vaildateObj) {
		
		var dataFile=document.forms["upload"]["dataFile"].value;
		if (dataFile == null || dataFile == ""){
			alert("Please select a file");
			return false;
		}
		
	    var getFileName = vaildateObj.getElementsByTagName("input");
	  
	    
	        var fileInput = getFileName[0];
	        if (fileInput.type == "file"){
	         var fileName = fileInput.value;
	        
	            if (fileName.length > 0) {
	                var isValid = false;
	                 
	                    if (fileName.substr(fileName.length - extension.length, extension.length).toLowerCase() == extension.toLowerCase()) {
	                        isValid = true;
	                    }
	                 
	                if (!isValid) {
	                    alert("Only " + extension + " extension can be uploaded " );
	                    return false;
	                }
	                
	            }
	        }
	        
	}
	            
	    
  
 





