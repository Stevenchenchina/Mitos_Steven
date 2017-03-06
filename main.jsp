<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="old cat">

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./bootstrap-3.3.7-dist/css/bootstrap-dialog.min.css" rel="stylesheet">
    <link href="./bootstrap-3.3.7-dist/css/bootstrapValidator.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/dashboard.css" rel="stylesheet">
    <link href="./DataTables-1.10.12/css/jquery.dataTables.css" rel="stylesheet">
    <link href="./DataTables-1.10.12/css/select.dataTables.min.css" rel="stylesheet">

    <link href="./css/basic.css" rel="stylesheet">
</head>
<body style="font-family:'微软雅黑'">
	<jsp:include page="./widgets/nav.jsp" flush= "true"/>
    
    <div class="container-fluid">
      <div class="row">
      	<div class="col-md-1 sidebar">
      		<jsp:include page="./widgets/menu.jsp" flush= "true"/>
      	</div>
      	<div class="col-md-11 col-md-offset-1 main"> 			
 			<jsp:include page="./widgets/dashboard/rssi/rssi.jsp" flush= "true"/>
 			<jsp:include page="./widgets/dashboard/overview/overview.jsp" flush= "true"/>
 			<jsp:include page="./widgets/dashboard/mission/mission.jsp" flush= "true"/>
 			<jsp:include page="./widgets/dashboard/system/system.jsp" flush= "true"/>
      	</div>      	
      </div>      
    </div>
    
    <jsp:include page="./widgets/dashboard/mission/modal/modal_mission_add.jsp" flush= "true"/>  
	<jsp:include page="./widgets/dashboard/rssi/modal/modal_rssi_mission_add.jsp" flush= "true"/>


 </body>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./js/jquery.min.js"></script>
    <script src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="./bootstrap-3.3.7-dist/js/bootstrapValidator.min.js"></script>
    <script src="./bootstrap-3.3.7-dist/js/bootstrap-dialog.min.js"></script>
    <script src="./DataTables-1.10.12/js/jquery.dataTables.js"></script>
    <script src="./DataTables-1.10.12/js/dataTables.select.js"></script>
    
    
    <script src="./Highcharts-4.2.6/highcharts.js"></script>
    <script src="./Highcharts-4.2.6/exporting.js"></script>
    
    <script src="https://webapi.amap.com/maps?v=1.3&key=ea1d697604e968c7f14c9469151db258&plugin=AMap.AdvancedInfoWindow"></script>
    
    <script src="./js/util.js"></script>
    <script src="./js/webmanager/vars.js"></script>
    <script src="./js/webmanager/widgets/dashboard/rssi/rssi.js"></script>
    <script src="./js/webmanager/widgets/dashboard/overview/overview.js"></script>
    <script src="./js/webmanager/widgets/dashboard/mission/mission.js"></script>
    <script src="./js/webmanager/widgets/dashboard/system/system.js"></script>
    <script src="./js/webmanager/main.js"></script>    
</html>