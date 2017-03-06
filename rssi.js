/*需要从后台取得：task_id, task_alias, status, rssi, latitude, longitude,timestamp, task_alais, task_id, 有空的话提供数据导出功能*/
var rssi_map = new AMap.Map('container_rssi_map', {
	      resizeEnable: true,
	      zoom:13,
	      center: [116.397428, 39.90923]
	    });
	AMap.plugin(['AMap.ToolBar','AMap.Scale','AMap.OverView'],
		    function(){
			rssi_map.addControl(new AMap.ToolBar());		 
			rssi_map.addControl(new AMap.Scale());
			rssi_map.addControl(new AMap.OverView({isOpen:true}));
		});

/*	rssi_map.setMapStyle("blue_night");*/
	
var task_table_rssi = $('#tb_task_rssi').DataTable({
	select: true,
    columns: [
    	{ data: 'onwatch'},
        { data: 'taskId' },
        { data: 'taskAlias' },
        { data: 'status' },
    ],
     "language": g_dataTableLanguage
});

$("body").delegate("a", "click", function(){
	if ($(this).data("op") == "a_task_rssi_add_one"){
		$("#modal_rssi_task_add").modal('show');
	}
});

$("#form_addRssiTask").bootstrapValidator({
    message: "This value is not valid",
    feedbackIcons: {
        valid: "glyphicon glyphicon-ok",
        invalid: "glyphicon glyphicon-remove",
        validating: "glyphicon glyphicon-refresh"
    },
    fields: {
        taskid: {
            validators: {
                notEmpty: {
                    message: "活动号不能为空"
                }
            }        
        }
    }
}).on("success.form.bv", function(e) {
    // Prevent form submission
    e.preventDefault();
    // Get the form instance
    var $form = $(e.target);
    // Get the BootstrapValidator instance
    var bv = $form.data("bootstrapValidator");
    // Use Ajax to submit form data
    
	_ajax_post_json({
		url: "./web/app/task/get/by/taskid.do", 
		data: $form.serialize(), 
		func: function(status, data, jqXHR){
			if (status == 200) {
				if (data != null){
					var isRepeated = false;
					task_table_rssi.data().each( function (d) {
					    if (d.taskId == data.taskId ){
					    	isRepeated = true;
					    	return false;
					    }
					} );
					
					if (isRepeated == false){
						task_table_rssi.row.add({	
							"onwatch" : "<input type='checkbox' data-type='rssi-mark' id='rssi_mark_id_" + data.task_id + "' data-taskId='" + data.task_id + "' data-taskAlias='" + data.task_alias+ "' data-status='" + data.status + "'> 显示",
							"taskId" : data.task_id,
							"taskAlias" : data.task_alias,
							"status" : data.status,
						}).draw();
						$("#addRssiTask_succ").show(300).delay(5000).hide(300);
					}
					else {
						$("#addRssiTask_deny").show(300).delay(5000).hide(300);
					}
				}
				else{
					
					$("#addRssiTask_fail").show(300).delay(5000).hide(300);
				}
			}
			else{
				alert("网络错误");
			}
		}
	});
});

var task_array = new Array;
var rssi_chart3 = 70;
var rssi_chart2 = 10;
var rssi_chart1 = 10;
var rssi_chart0 = 10;
var markObj = {
		"noteid" : 123,
		"taskId" : 123,
		"taskAlias" : 'test',
	}


$("body").delegate("input[type='checkbox']", "click", function(){
	if($(this).data("type") == "rssi-mark"){
		if ($(this).is(":checked")){
			var markObj = {
				"noteid" : $(this).attr("id"),
				"taskId" : $(this).data("taskId"),
				"taskAlias" : $(this).data("taskAlias"),
			}
			addMarks([markObj]);
		}
		else {
			removeMarks([$(this).data("taskId")]);
		}		
	}	
});



var markers_1 = new Array;

function addMarks(markObjs){	
	for (var i = 0; i < markObjs.length; i++){
		var markObj = markObjs[i];
		var marker1 = new AMap.Marker({
	        position: null,
	        map : null,
	        title:markObj.taskId + ":" + markObj.taskAlias,
	        extData : markObj
		});
		markers_1.push(marker1);
	}
}

function removeMarks(idArry){
	for (var i = 0; i < idArry.length; i++){
		var id = idArry[i];
		for (var j = markers_1.length - 1; j >= 0; j--){
			var obj = markers_1[j];
			if (id == obj.getExtData().taskId){
				markers_1[j].setMap(null);
				markers_1.splice(j, 1);
			}
		}		
	}
}

function udpateRssiView(){

}

/*
var data2 = new Array;

for (var i = 0; i < 10000; i++) {
	data2.push({name:i,rssi:2,lnglat:new AMap.LngLat((Math.random()*90+116.396574),(Math.random()*40+39.992706))});
}
var mass = new AMap.MassMarks(data2, {
    url: 'http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png',
    anchor: new AMap.Pixel(3, 7),
    size: new AMap.Size(22, 33),
    opacity:0.7,
    cursor:'pointer',
    zIndex: 1
});

var marker = new AMap.Marker({
	content:' ',
    map:rssi_map
});
mass.on('mouseover',function(e){
  marker.setPosition(e.data.lnglat);
  marker.setLabel({content:(e.data.name+e.data.rssi)})
});
mass.setMap(rssi_map);

,
	                     {lnglat:[116.405267, 39.907761]},
	                     {lnglat:[116.405437, 39.907761]},
	                     {lnglat:[116.405417, 39.907761]},
	                     {lnglat:[116.405464, 39.907761]},
	                     {lnglat:[116.405462, 39.907761]},
	                     {lnglat:[116.405461, 39.907761]},
	                     {lnglat:[116.405465, 39.907761]},
	                     {lnglat:[116.405468, 39.907761]}
            
*/
var data = new Array;
data.push(new AMap.LngLat(116.405267, 39.927761));
data.push(new AMap.LngLat(116.415468, 39.907761));
data.push(new AMap.LngLat(116.405417, 39.917761));
var cluster;
var markers = new Array;

var swlng = 116.356877;
var nelat = 39.919552;
var lngSpan = 0.071068;
var latspan = 0.041352;

var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});
for (var i = 0, marker; i < 600; i++) {
	var tmplng = swlng+lngSpan*(Math.random()*1);
	var tmplat = nelat-latspan*(Math.random()*1);
	var marker = new AMap.Marker({
        position: [tmplng,tmplat],
        map: null,
		title: 'test' + i,
		icon: new AMap.Icon({            
	        size: new AMap.Size(40, 50),  //图标大小
	        image: "http://webapi.amap.com/theme/v1.3/images/newpc/way_btn2.png",
	        imageOffset: new AMap.Pixel(0, -60)
	    }),
    });
    marker.content = '我是第' + (i + 1) + '个Marker';
    marker.on('click', markerClick);
    marker.emit('click', {target: marker});
    markers.push(marker);
}
addCluster();


function addCluster() {
    if (cluster) {
        cluster.setMap(null);
    }
    AMap.plugin(["AMap.MarkerClusterer"], function() {
        cluster = new AMap.MarkerClusterer(rssi_map, markers);
    });
}

function markerClick(e) {
    infoWindow.setContent(e.target.content);
    infoWindow.open(rssi_map, e.target.getPosition());
}


setInterval(function(){ 
	var reqTaskIds = "";
	for (var i = 0; i < markers_1.length; i++){
		reqTaskIds += markers_1[i].taskId;
		if (i < markers_1.length -1)
			reqTaskIds += ",";		
	}
	if (reqTaskIds == "")
		return;	
	_ajax_post_json({
		url: "./web/pro/account/get/tasks/by/taskids.do", 
		data: { "TaskIds" : reqTaskIds }, 
		func: function(status, data, jqXHR){
			if (status == 200) {
				if (data != null){
					
					/*
					for (var i = 0; i < data.length; i++){
						var locObj = data[i].latestLocation;
						if (locObj == null)
							continue;
						for (var j = 0; j < markers_1.length; j++){
							if (locObj.taskId == markers_1[j].getExtData().taskId){	
								markers_1[j].setPosition([locObj.longitude, locObj.latitude]);
								markers_1[j].setMap(rssi_map);							
								break;
							}
						}
					} */	
				}			
			}
			else {
				alert("获取RSSI数据失败!");
			}
		}
	});

}, 5000);



$('#container_rssi_chart').highcharts({
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: ' 信号强度数据分析 '
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        name: '百分比',
        colorByPoint: true,
        data: [{
            name: '大于3',
            color:'#32cd32',
            y: rssi_chart3,
            sliced: true,
            selected: true
        },
        {
            name: '强度2',
            color: '#4876ff',
            y: rssi_chart2
        },
        {
            name: '强度1',
            color: '#FFC125',
            y: rssi_chart1
        },
        {
            name: '强度0',
            color: '#FF3E96',
            y: rssi_chart0
        }]
    }]
});

