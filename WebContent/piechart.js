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

	function getPieValue() {

		$.ajax({
			url : "/localTMT/GetPieChartValues",
			type : "POST",
			data : 'projectId=' + ('PR0' + (count + 1)),

			success : function(data) {
				a = JSON.parse(data);
				setPieValue();
			},
			error : function() {

			}
		});

	}

	function setPieValue() {

		nASE = parseInt(a.ASE);
		nSE = parseInt(a.SE);
		nSSE = parseInt(a.SSE);
		nTL = parseInt(a.TL);
		nAM = parseInt(a.AM);
		nM = parseInt(a.M);

		p0 = parseInt(a.p0);
		p1 = parseInt(a.p1);
		p2 = parseInt(a.p2);
		p3 = parseInt(a.p3);
		p4 = parseInt(a.p4);

		total = parseInt(a.total);
		billable = parseInt(a.billable);
		nonBillable = total - billable;

		angularJS = parseInt(a.angularJS);
		AT = parseInt(a.AT);
		C_UNIX = parseInt(a.C_UNIX);
		FST = parseInt(a.FST);
		HTML = parseInt(a.HTML);
		java = parseInt(a.java);
		JSP = parseInt(a.jsp);
		QA = parseInt(a.QA);
		TBD = parseInt(a.TBD);

		Name=a.name;
		drawChart(0);
	}

	function drawChart(type) {

		data[0] = google.visualization.arrayToDataTable([
				[ 'Designation', 'number' ], [ 'ASE', nASE ], [ 'SE', nSE ],
				[ 'SSE', nSSE ], [ 'TL', nTL ], [ 'AM', nAM ], [ 'M', nM ] ]);
		data[1] = google.visualization.arrayToDataTable([
				[ 'Billability', 'percentage' ], [ 'Billable', billable ],
				[ 'Non-Billable', nonBillable ] ]);
		data[2] = google.visualization.arrayToDataTable([
				[ 'Proficiency', 'percentage' ], [ 'P0', p0 ], [ 'P1', p1 ],
				[ 'P2', p2 ], [ 'P3', p3 ], [ 'P4', p4 ] ]);
		data[3] = google.visualization.arrayToDataTable([
				[ 'Expertise', 'percentage' ], [ 'AngularJS', angularJS ],
				[ 'AT', AT ], [ 'C/UNIX', C_UNIX ], [ 'FST', FST ],
				[ 'HTML', HTML ], [ 'JAVA', java ], [ 'JSP', JSP ],
				[ 'QA', QA ], [ 'TBD', TBD ] ]);

		options[0] = {
			is3D : true,
			backgroundColor : '#647a2f',
			title : Name,
			chartArea : {
				left : 100,
				top : 50
			}
		};

		chart = new google.visualization.PieChart(document
				.getElementById('piechart'));
		chart.draw(data[type], options[0]);

	}

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
		if (a == 'billability') {
			Name = "Billability";
			drawChart(1);
		
		}
		if (a == 'proficiency') {
			Name = "Proficiency";
			drawChart(2);
		
		}
		if (a == 'expertise') {
			Name = "Expertise";
			drawChart(3);
		
		}
	}
	var change = setInterval(next, 3000);

	function next() {
		if (count == 3)
			count = 0;
		if (count < 3) {

			getPieValue();
			

			count++;
		}
	}

}

function initialize() {
	$(".filter").hide();
	myfunction();

}

function clickk() {

	$(".filter").show();
	stop();
}
function filter(a) {
	filterChart(a);
}
