google.setOnLoadCallback(initialize);
google.load("visualization", "1", {
	packages : [ "corechart" ]
});
// To underline the team/module which is clicked
tempModule = "dummy";
tempTeam = "dummy";

var data = new QueryData();
var id = data.projectId;
function populate() {

	$.ajax({
		url : '/TMT/DropDownDetails',
		type : 'POST',
		data : {
			projectId : id,
			tree : true
		},
		success : function(response) {

			a = JSON.parse(response);
			generateTree();

		}

	});
}
function generateTree() {
	var obj = {
		projectName : "",
		projectId : id,
		"moduleList" : []
	};

	var Array = [];
	Array.push(obj);

	for (i in a["module"]) {
		if ((a.module[i].projectId) == id) {
			var obj = {
				moduleName : a.module[i].moduleName,
				moduleId : a.module[i].moduleId,
				"teamList" : []
			};

			var length = Array[0]["moduleList"].push(obj);
			$("#tree").append(
					"<li><span class=\"moduleclick "
							+ Array[0]["moduleList"][length - 1].moduleId
							+ "\" onclick=\"fetchModuleEmp(" + "'"
							+ Array[0]["moduleList"][length - 1].moduleId + "'"
							+ ")\">"
							+ Array[0]["moduleList"][length - 1].moduleName
							+ "</span><ul id=\""
							+ Array[0]["moduleList"][length - 1].moduleId
							+ "\" ></ul></li>");
		}

	}
	for (j in a["team"]) {
		for (k in Array[0]["moduleList"]) {

			if (a["team"][j].moduleId == Array[0]["moduleList"][k].moduleId) {
				var obj = {
					teamName : a["team"][j].teamName,
					teamId : a["team"][j].teamId
				}
				var length = Array[0]["moduleList"][k]["teamList"].push(obj);
				$("#" + Array[0]["moduleList"][k].moduleId)
						.append(
								"<li id=\""
										+ Array[0]["moduleList"][k]["teamList"][length - 1].teamId
										+ "\"><span class=\"teamclick\" onclick=\"fetchTeamEmp("
										+ "'"
										+ Array[0]["moduleList"][k]["teamList"][length - 1].teamId
										+ "'"
										+ ")\">"
										+ Array[0]["moduleList"][k]["teamList"][length - 1].teamName
										+ "</span></li>");

			}
		}
	}

}

function fetchModuleEmp(moduleId) {
var lala =0;
	var count = [];

	$("." + moduleId).css({
		"text-decoration" : "underline"
	});
	if (tempModule != moduleId)
		$("." + tempModule).css({
			"text-decoration" : "none"
		});

	var teamArray = [];
	var teamNames = [];

	for (n in a["team"])
		if (a["team"][n].moduleId == moduleId) {
			teamArray.push(a["team"][n]["teamId"]);
			teamNames.push(a["team"][n]["teamName"]);
		}

	for (b in teamArray) {
		$.ajax({
			url : '/TMT/FetchTeamEmployees',
			type : 'POST',
			data : {
				teamId : teamArray[b],

			},
			success : function(response) {
				console.log(response);
				var res = JSON.parse(response);

				count.push({
					teamName : teamNames[lala++],
					ASE : res.ASE,
					SE : res.SE,
					SSE : res.SSE,
					TL : res.TL
				});
				
				defineStackData(count);
			
			},
			async:   false
			
			

		});
	}

	// For underline of selected module
	tempModule = moduleId;

}

function defineStackData(count){
	
	var teams = ["Designation"];
	var countASE = ["ASE"];
	var countSE = ["SE"];
	var countSSE = ["SSE"];
	var countTL = ["TL"];
	for(z in count){
		teams.push(count[z].teamName);
		countASE.push((parseInt)(count[z].ASE));
		countSE.push((parseInt)(count[z].SE));
		countSSE.push((parseInt)(count[z].SSE));
		countTL.push((parseInt)(count[z].TL));
	}
	data[1] = google.visualization.arrayToDataTable([teams,countASE,countSE,countSSE,countTL]);
	drawGraph(true);
}


function fetchTeamEmp(teamId) {

	$("#" + teamId).css({
		"text-decoration" : "underline"
	});
	if (tempTeam != teamId)
		$("#" + tempTeam).css({
			"text-decoration" : "none"
		});
	$.ajax({
		url : '/TMT/FetchTeamEmployees',
		type : 'POST',
		data : {
			teamId : teamId,

		},
		success : function(response) {

			var emplist = JSON.parse(response);
			var a=[ "ASE", emplist.ASE ];
			data[0] = google.visualization.arrayToDataTable([
					[ 'Designation', 'number' ], a,
					[ 'SE', emplist.SE ], [ 'SSE', emplist.SSE ],
					[ 'TL', emplist.TL ] ]);

			drawGraph(false);
		}

	});
	tempTeam = teamId;
}

function initialize() { 
	data = [];
	options = [];

	options[0] = {
		is3D : true,
		title : "Employees",
		width : 300,
		height : 300,
		chartArea : {
			left : 100,
			top : 50
		}
	};
	    options[1] = {
		        width: 380,
		        height: 300,
		        legend: { position: 'top', maxLines: 3 },
		        
		        bar: { groupWidth: '75%' },
		        isStacked: true
		      };

}

function drawGraph(isStacked) {

	var graph = new google.visualization.BarChart(document
			.getElementById('barGraph'));
	if(isStacked){
		graph.draw(data[1], options[1]);
	}
	else{
		graph.draw(data[0], options[0]);
	}
}
