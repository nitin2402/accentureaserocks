function validateform2() {

	if ( ( !document.getElementById('excel').checked  ) && ( !document.getElementById('manually').checked  ) ) 
	{
	 alert ( "Please choose one option" );
	 return false;
	}
}



