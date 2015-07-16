$("#ajaxResponse").hide();
$(".filter").hide();
$("#header_02").hide();
google.setOnLoadCallback(initialize);
google.load("visualization", "1", {
	packages : [ "corechart" ]
});
function myfunction() {
	firstClick = true;

	var myFunctionObj = new Object();

	count = 0;
	var data = [];
	var options = [];

	var nASE = parseInt($("#ASE").val());
	var nSE = parseInt($("#SE").val());
	var nSSE = parseInt($("#SSE").val());

	var nTL = parseInt($("#TL").val());
	var nAM = parseInt($("#AM").val());
	var p0 = parseInt($("#p0").val());
	var p1 = parseInt($("#p1").val());
	var p2 = parseInt($("#p2").val());
	var p3 = parseInt($("#p3").val());
	var p4 = parseInt($("#p4").val());
	var nM = 1;
	var billable = parseInt($("#billable").val());
	var total = parseInt($("#count").val());
	var nonBillable = total - billable;
	var angularJS = parseInt($("#angularJS").val());
	var AT = parseInt($("#AT").val());
	var C_UNIX = parseInt($("#C_UNIX").val());
	var FST = parseInt($("#FST").val());
	var HTML = parseInt($("#HTML").val());
	var java = parseInt($("#java").val());
	var JSP = parseInt($("#JSP").val());
	var QA = parseInt($("#QA").val());
	var TBD = parseInt($("#TBD").val());
	var rASE = 310;
	var rSE = 30;
	var rSSE = 30;

	var rTL = 13;
	var rAM = 02;
	var rM = 1;

	var pASE = 110;
	var pSE = 17;
	var pSSE = 15;

	var pTL = 13;
	var pAM = 12;
	var pM = 11;

	data[0] = google.visualization.arrayToDataTable([
			[ 'Designation', 'number' ], [ 'ASE', nASE ], [ 'SE', nSE ],
			[ 'SSE', nSSE ], [ 'TL', nTL ], [ 'AM', nAM ] ]);

	data[1] = google.visualization.arrayToDataTable([
			[ 'Designation', 'number' ], [ 'ASE', rASE ], [ 'SE', rSE ],
			[ 'SSE', rSSE ], [ 'TL', rTL ], [ 'AM', rAM ], [ 'M', rM ] ]);

	data[2] = google.visualization.arrayToDataTable([
			[ 'Designation', 'number' ], [ 'ASE', pASE ], [ 'SE', pSE ],
			[ 'SSE', pSSE ], [ 'TL', pTL ], [ 'AM', pAM ], [ 'M', pM ] ]);

	data[5] = google.visualization.arrayToDataTable([
			[ 'Designation', 'number' ], [ 'ASE', nASE ], [ 'SE', nSE ],
			[ 'SSE', nSSE ], [ 'TL', nTL ], [ 'AM', nAM ], [ 'M', nM ] ]);

	data[6] = google.visualization.arrayToDataTable([
			[ 'Billability', 'percentage' ], [ 'Billable', billable ],
			[ 'Non-Billable', nonBillable ] ]);
	options[6] = {
		is3D : true,
		backgroundColor : '#647a2f',
		title : 'Billability',
		chartArea : {
			left : 100,
			top : 50
		}
	};

	data[7] = google.visualization.arrayToDataTable([
			[ 'Proficiency', 'percentage' ], [ 'P0', p0 ], [ 'P1', p1 ],
			[ 'P2', p2 ], [ 'P3', p3 ], [ 'P4', p4 ] ]);
	options[7] = {
		is3D : true,
		backgroundColor : '#647a2f',
		title : 'Proficiency',
		chartArea : {
			left : 100,
			top : 50
		}
	};

	data[8] = google.visualization.arrayToDataTable([
			[ 'Expertise', 'percentage' ], [ 'AngularJS', angularJS ],
			[ 'AT', AT ], [ 'C/UNIX', C_UNIX ], [ 'FST', FST ], [ 'HTML', HTML ],
			[ 'JAVA', java ], [ 'JSP', JSP ], [ 'QA', QA ], [ 'TBD', TBD ] ]);
	options[8] = {
		is3D : true,
		backgroundColor : '#647a2f',
		title : 'Expertise',
		chartArea : {
			left : 100,
			top : 50
		}
	};
	var chart = new google.visualization.PieChart(document
			.getElementById('piechart'));

	options[0] = {
		is3D : true,
		backgroundColor : '#647a2f',
		title : 'E-Strategy',
		chartArea : {
			left : 100,
			top : 50
		}
	};
	options[1] = {
		is3D : true,
		backgroundColor : '#647a2f',
		title : 'R3',
		chartArea : {
			left : 100,
			top : 50
		}
	};
	options[2] = {
		is3D : true,
		backgroundColor : '#647a2f',
		title : 'Premier',
		chartArea : {
			left : 100,
			top : 50
		}
	};

	var chart = new google.visualization.PieChart(document
			.getElementById('piechart'));

	this.stop = function() {
		if (firstClick) {
			firstClick = false;
			count = 4;
		} else {
			firstClick = true;
			count = 0;
			$(".filter").hide();
		}
	}
	this.filterChart = function(a) {
		var chart = new google.visualization.PieChart(document
				.getElementById('piechart'));
		if (a == 'billability')
			chart.draw(data[6], options[6]);
		if (a == 'proficiency')
			chart.draw(data[7], options[7]);
		if (a == 'expertise')
			chart.draw(data[8], options[8]);
	}
	var change = setInterval(next, 3000);

	/* window.clearInterval(change); */

	function next() {
		if (count == 3)
			count = 0;
		if (count < 3) {
			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));
			chart.draw(data[count], options[count]);
			count++;
		}
	}

}

function initialize() {
	$(".filter").hide();
	myfunction();

}

function clickk() {

	/*
	 * var searchvalue = $(".error").hide(); $.ajax({ url :
	 * "/EmployeeMSAccessDB/SearchEmployee", type : "POST", data : 'searchName=' +
	 * searchvalue,
	 * 
	 * success : function(data) {
	 * 
	 * if (data != "") {
	 *  } else {
	 * 
	 * 
	 *  }
	 *  }, error : function() {
	 *  } });
	 */

	$(".filter").show();
	stop();
}
function filter(a) {
	filterChart(a);
}
