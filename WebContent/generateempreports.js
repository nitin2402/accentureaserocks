	$(document).ready(function() {
		$("#div2,#div1").hide();
	});

	function changeTextBox() {
		var val = $('#select').val();

		if (val === 'default') {
			$("#div2,#div1").hide();
		}

		else if (val === 'employee') {
			$("#div2").hide();
			$("#div1").show();
		}

		else if (val === 'designation') {
			$("#div2").show();
			$("#div1").hide();
		}
	}