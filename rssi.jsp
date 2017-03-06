<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div id="page_rssi" data-func="updateRssiInfo()" hidden="true">
	<h1 class="page-header">信号强度态势图</h1>
	<br>
	<div class="row">

	   	<div class="col-md-4">

	   		<table id="tb_task_rssi" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>显示 </th>
						<th>活动号</th>
						<th>活动名</th>
						<th>状态</th>
					</tr>
				</thead>
			</table>
			<hr>
			<div class="btn-group">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				  添加活动
				  <span class="caret"></span>
				</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
				  <li><a data-op="a_task_rssi_add_one" tabindex="-1" href="#">输入活动</a></li>
				</ul>
			</div>
			<br><br><br>
			<div>
                <div id="container_rssi_chart" style="min-width: 400px; height: 400px; max-width: 600px; margin: 0 auto"></div>
            </div>
            
	   	</div>
	   	<div class="col-md-8">
		   	<div id="container_rssi_map" style=width:100%;height:600px;></div>
	   	</div>
	</div>

</div>     		