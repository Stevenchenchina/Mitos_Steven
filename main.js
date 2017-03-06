$(function(){
	
	resetVars();
	getServiceRoot();
	getCurrUserInfo();
	
	setCurrentPage("page_rssi", "li_1");
	
	$("body").delegate("a", "click", function(){	
		if ($(this).data('type') == 'page_switch'){
			setCurrentPage($(this).data('goto'), $(this).data('li'));
		}
	});
	
	function setCurrentPage(page, li){
		if (page != g_currPage){
			$("#" + g_currPage).attr("hidden", "true");
			$("#" + page).removeAttr("hidden");			
			$("#" + g_currLi).removeClass("active");			
			$("#" + li).addClass("active");
			g_currPage = page;
			g_currLi = li;
			
			eval($("#" + page).data("func"));
		}
	}
	
	function getServiceRoot(){
		_ajax_get_text({
			url:"./web/system/context/root/get/.do",
			data:{"type" : "uss"},
			func: function(status, data, jqXHR){
				if (status == 200) {
					g_context_root_uss = data;
				}
				else{
					alert("获取数据失败");
				}
			}
		});
		_ajax_get_text({
			url:"./web/system/context/root/get/.do",
			data:{"type" : "rms"},
			func: function(status, data, jqXHR){
				if (status == 200) {
					g_context_root_rms = data;
				}
				else{
					alert("获取数据失败");
				}
			}
		});
		_ajax_get_text({
			url:"./web/system/context/root/get/.do",
			data:{"type" : "srs"},
			func: function(status, data, jqXHR){
				if (status == 200) {
					g_context_root_srs = data;
				}
				else{
					alert("获取数据失败");
				}
			}
		});
		_ajax_get_text({
			url:"./web/system/context/root/get/.do",
			data:{"type" : "gis"},
			func: function(status, data, jqXHR){
				if (status == 200) {
					g_context_root_gis = data;
				}
				else{
					alert("获取数据失败");
				}
			}
		});
		_ajax_get_text({
			url:"./web/system/context/root/get/.do",
			data:{"type" : "irs"},
			func: function(status, data, jqXHR){
				if (status == 200) {
					g_context_root_irs = data;
				}
				else{
					alert("获取数据失败");
				}
			}
		});
		_ajax_get_text({
			url:"./web/system/context/root/get/.do",
			data:{"type" : "gis"},
			func: function(status, data, jqXHR){
				if (status == 200) {
					g_context_root_rssi = data;
				}
				else{
					alert("获取数据失败");
				}
			}
		});
	}

	function getCurrUserInfo(){
		ajaxPost("./web/app/user/get/my/info.do", null, function succ(data) {
			g_currUserId = data.id;
			g_currUserAlias = data.alias;
			$("#currUser").text("当前登录：" + g_currUserAlias);
		});	
	}
	
	function updateRssiInfo(){
		udpateRssiView();
	}
	
	function updateUserInfo(){
		updateUserTable();
	}
	
	function updateGroupInfo(){
		updateGroupTable();
	}
	
	function updateGatewayInfo(){
		updateGatewayTable();
	}
	
	function updateVoiceRecordInfo(){
		updateVoiceRecordTable();
	}
	
	function updateSystemInfo(){
		updateSyetemTable();
	}
	
	function updateLogInfo(){
		updateLogTable(0, "root");
	}
	
	function updateGisInfo(){
		udpateGisView();
	}
	
	function updateMissionInfo(){
		udpateMissionView();
	}
});