
	$("#ajaxResponse").hide();
	$(".filter").hide();
	$("#header_02").hide();
	google.setOnLoadCallback(initialize);
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	function myfunction() {
		firstClick=true;
		
		var myFunctionObj = new Object();
		
		 count = 0;
		var data = [];
		var options = [];
		
		var nASE = 10;
		var nSE = 7;
		var nSSE = 5;
	
		var nTL = 3;
		var nAM = 2;
		var nM = 1;
		
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
				[ 'SSE', nSSE ], [ 'TL', nTL ], [ 'AM', nAM ], [ 'M', nM ] ]);

		data[1] = google.visualization.arrayToDataTable([
				[ 'Designation', 'number' ], [ 'ASE', rASE ], [ 'SE', rSE ],
				[ 'SSE', rSSE ], [ 'TL', rTL ], [ 'AM', rAM ], [ 'M', rM ] ]);

		data[2] = google.visualization.arrayToDataTable([
				[ 'Designation', 'number' ], [ 'ASE', pASE ], [ 'SE', pSE ],
				[ 'SSE', pSSE ], [ 'TL', pTL ], [ 'AM', pAM ], [ 'M', pM ] ]);
	

		data[5] = google.visualization.arrayToDataTable([
		                                 				[ 'Designation', 'number' ], [ 'ASE', nASE ], [ 'SE', nSE ],
		                                 				[ 'SSE', nSSE ], [ 'TL', nTL ], [ 'AM', nAM ], [ 'M', nM ] ]);

		
		data[6] = google.visualization.arrayToDataTable([[ 'Billability', 'percentage' ], [ 'Billable', 90 ], [ 'Non-Billable', 10 ]]);
		options[6] = {
				is3D : true,
				backgroundColor : '#647a2f',
				title : 'Billability',
				chartArea : {
					left : 100,
					top : 50
				}
			};
		
		data[7] = google.visualization.arrayToDataTable([[ 'Proficiency', 'percentage' ], [ 'P0', 40 ], [ 'P1', 30 ],['P2',20],['P3',8],['P4',2]]);
		options[7] = {
				is3D : true,
				backgroundColor : '#647a2f',
				title : 'Proficiency',
				chartArea : {
					left : 100,
					top : 50
				}
			};
		data[8] = google.visualization.arrayToDataTable([[ 'Expertise', 'percentage' ], [ 'FED', 60 ], [ 'BED', 40 ]]);
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
			title : 'Primier',
			chartArea : {
				left : 100,
				top : 50
			}
		};
		
		var chart = new google.visualization.PieChart(document
				.getElementById('piechart'));
		
		this.stop = function() {
			if(firstClick){
			firstClick=false;
			count=4;
			}
			else{
				firstClick=true;
				count=0;
				$(".filter").hide();
			}
		}
		this.filterChart=function (a){
			var chart = new google.visualization.PieChart(document
					.getElementById('piechart'));
		    if (a=='billability')
			chart.draw(data[6], options[6]);
		    if (a=='proficiency')
				chart.draw(data[7], options[7]); 
		    if (a=='expertise')
				chart.draw(data[8], options[8]);
		}
		var change = setInterval(next, 3000);
	
		/*window.clearInterval(change);*/
	
		
		function next() {
			if (count == 3)
				count = 0;
if(count < 3){
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
	
	function clickk(){
		
				
			/*		var searchvalue = 
					$(".error").hide();
					$.ajax({
						url : "/EmployeeMSAccessDB/SearchEmployee",
						type : "POST",
						data : 'searchName=' + searchvalue,

						success : function(data) {

							if (data != "") {
								
							} else {

							

							}

						},
						error : function() {

						}
					});*/

		$(".filter").show();
		stop();
		}
	function filter(a){
		filterChart(a);
	}
	
	

