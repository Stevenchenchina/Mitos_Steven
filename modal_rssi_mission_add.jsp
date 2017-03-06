<%@ page contentType="text/html;charset=UTF-8" language="java"%>

  <div id="modal_rssi_task_add" class="modal fade" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-plus"></span> 添加显示 活动</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form id="form_addRssiTask" role="form">
            <div class="form-group">
              <label for="addRssiTask_id"><span class="glyphicon glyphicon-tags"></span> 目标活动号</label>
              <input type="text" class="form-control" id="addRssiTask_id" name="taskId" placeholder="输入：目标活动号">
            </div>
            <br>
            <button id="btn_addRssiTask" type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 添加显示 </button>
          </form>
          <div id="addRssiTask_succ" align="center" hidden="true">
          	<br>
          	<p style="color:#5cb85c">添加显示 成功！</p>
          </div>
          <div id="addRssiTask_fail" align="center" hidden="true">
          	<br>
          	<p style="color:#d9534f">活动不存在！</p>
          </div>
          <div id="addRssiTask_deny" align="center" hidden="true">
          	<br>
          	<p style="color:#d9534f">活动已经添加！</p>
          </div>          
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 关闭</button>          
        </div>
      </div>
      
    </div>
  </div>