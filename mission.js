/*  对tb_mission表的增，改，删  */
var mission_table = $('#tb_mission').DataTable({
	"data": null,
	select: true,
    columns: [
              { data: 'id' },
              { data: 'alias' },
              { data: 'status' },	              
          	  { data: 'description' },
          	  { data: 'datecreated',
          	    render: function ( data, type, row ) {
          	    	return _getDateTimeString(data);
          	    }},
          ],
     "language": g_dataTableLanguage
});

mission_table.on('select', function (e, dt, type, indexes) {
	var count = mission_table.rows('.selected').data().length;
	updateMissionOpButtons(count);
}).on('deselect', function (e, dt, type, indexes) {
	var count = mission_table.rows('.selected').data().length;
	updateMissionOpButtons(count);	
});

function updateMissionTable(){
	var rspData = null;
	
	_ajax_post_json({
		url: "./web/pro/organization/get/members.do",
		data: {"organizationid" : g_orgaId}, 
		func: function(status, data, jqXHR){
			if (status == 200) {
				rspData = data;
			}
			else{
				alert("获取数据失败");
			}
		}
	});
	
	updateMissionOpButtons(0);

	if (rspData == null){
		return;
	}
	
	mission_table.clear();
	mission_table.rows.add(rspData).draw();	
}

function updateMissionOpButtons(selcount){
	if (selcount > 0){
		$("#btn_mission_remove").removeAttr("disabled");
		
		if (selcount == 1){
			$("#btn_mission_edit").removeAttr("disabled");
		}
		else{
			$("#btn_mission_edit").attr("disabled", "true");
		}
	}
	else{
		$("#btn_mission_edit").attr("disabled", "true");
		$("#btn_mission_remove").attr("disabled", "true");
	}
}

$("body").delegate("button", "click", function(){
	if ($(this).attr("id") == "btn_user_refresh"){
		updateUserTable();
	}
	else if ($(this).attr("id") == "btn_mission_add"){
		$("#modal_mission_add").modal('show');
	}
	else if ($(this).attr("id") == "btn_mission_remove"){
		removeMission();
	}
	else if ($(this).attr("id") == "btn_mission_query"){
		queryMission();
	}
});

$("#form_addmission").bootstrapValidator({
    message: "This value is not valid",
    feedbackIcons: {
        valid: "glyphicon glyphicon-ok",
        invalid: "glyphicon glyphicon-remove",
        validating: "glyphicon glyphicon-refresh"
    },
    fields: {
    	alias: {
            validators: {
                notEmpty: {
                    message: "活动名称不能为空"
                }
            }
        },
        description: {
            validators: {
                notEmpty: {
                    message: "活动描述不能为空"
                }
            }
        },
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
		url: "./web/pro/mission/create.do",
		data: $form.serialize(), 
		func: function(status, data, jqXHR){
			if (status == 200) {
				mission_table.row.add(data).draw();
				$("#addmission_succ").show(300).delay(5000).hide(300);				
			}
			else if (status == 400){
				$("#addmission_deny").show(300).delay(5000).hide(300);
			}
			else{
				$("#addmission_fail").show(300).delay(5000).hide(300);
			}
		}
	});
});

function removeMission(){
	var obj = mission_table.rows('.selected').data();
	var strMsg = "<h4>选中的" + obj.length + "个活动将删除</h4><h4>删除操作将不可撤销，请确认后操作。<h4>";
	BootstrapDialog.show({
    	title: "<span class='glyphicon glyphicon-alert' aria-hidden='true'></span><label id='missionname_infotext' class='control-label'>&nbsp;&nbsp;提醒</label>",
        message: strMsg,
        closable: true,
        buttons: [{
            label: '确定删除',
            cssClass: 'btn-danger',
            action: function(dialogRef){
            	var ids = "";
            	var length = mission_table.rows('.selected').data().length;
            	for (var i = 0; i < length; i++){
            		ids += mission_table.rows('.selected').data()[i].id;
            		if (i < length - 1){
            			ids += ",";
            		}		
            	}
            	_ajax_post_text({
               		url: "./web/pro/account/mission/delete.do",
            		data: {
            				"ids" : ids,
            				"orgId" : g_orgaId
            			}, 
            		func: function(status, data, jqXHR){
            			if (status == 200) {
            				mission_table.rows('.selected').remove().draw();
            			}
            			else{
            				alert("操作失败");
            			}
            		}
            	});
            	dialogRef.close();
            }
        }, {
            label: '放弃操作',
            cssClass: 'btn-success',
            action: function(dialogRef){
            dialogRef.close();
            }
        }]
    });
}

function queryMission(){
	alert(queryMission);
};
