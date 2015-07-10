/**
 * 
 */
var sum=0;
function setLCR_ASE(a){
	$('#ase'+a).val($('#a'+a).val());
}

function setLCR_SE(a){
	$('#se'+a).val($('#b'+a).val());
}

function setLCR_SSE(a){
	$('#sse'+a).val($('#c'+a).val());
}
function calculate(){
	var checkboxes = document.getElementsByName('empASE');
	var vals = "";
	for (var i=0, n=checkboxes.length;i<n;i++) {
	  if (checkboxes[i].checked) 
	  {
	  vals += ","+checkboxes[i].value;
	  }
	}

}

