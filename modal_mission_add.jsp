<%@ page contentType="text/html;charset=UTF-8" language="java"%>

  <div id="modal_mission_add" class="modal fade" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-mission"></span> 添加新活动</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form id="form_addmission" role="form">
            <div class="form-group">
              <label for="addalias"><span class="glyphicon glyphicon-mission"></span> 活动名称</label>
              <input type="text" class="form-control" id="addalias" name="alias" placeholder="输入：活动名称">
            </div>
            <div class="form-group">
              <label for="adddescription"><span class="glyphicon glyphicon-phone"></span> 活动描述</label>
              <input type="text" class="form-control" id="adddescription" name="description" placeholder="输入：活动描述">
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 注册活动</button>
          </form>
          <div id="addmission_succ" align="center" hidden="true">
          	<br>
          	<p style="color:#5cb85c">新活动添加成功！</p>
          </div>
          <div id="addmission_fail" align="center" hidden="true">
          	<br>
          	<p style="color:#d9534f">新活动添加失败！</p>
          </div>       
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 关闭</button>          
        </div>
      </div>
      
    </div>
  </div>