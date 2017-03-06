<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div id="page_mission" data-func="updateMissionInfo()" hidden="true">
	<h1 class="page-header">活动管理</h1>
	<table id="tb_mission" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>活动号</th>
				<th>活动名</th>
				<th>状态</th>
				<th>活动描述</th>
				<th>开始时间</th>
			</tr>
		</thead>
	</table>
    <br><br>
   	<div class="row">
		<div class="col-md-6" align="left">
			<button id="btn_mission_add" type="button" class="btn btn-success "><span class="glyphicon glyphicon-plus"></span>添加新活动</button>
	    	<button id="btn_mission_edit" type="button" class="btn btn-warning "><span class="glyphicon glyphicon-pencil"></span>编辑活动</button>
	    	<button id="btn_mission_remove" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>删除活动</button>
	        <button id="btn_mission_query" type="button" class="btn btn-infor"><span class="glyphicon glyphicon-pencil"></span>显示所有活动</button>
	  	</div>
	  	<div class="col-md-6" align="right">
			<button id="btn_mission_refresh" type="button" class="btn btn-primary "><span class="glyphicon glyphicon-refresh"></span>刷新活动列表</button>
		</div>
	</div>  	
</div>