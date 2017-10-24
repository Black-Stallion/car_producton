<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="org.apache.shiro.session.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/index1.css">
<script src="js/echarts.min.js" type="text/javascript"></script>
<script src="js/echarts.js" type="text/javascript"></script>
<title>济南通信段机动车管理信息系统</title>
<style type="text/css">
.content {
	padding: 10px 10px 10px 10px;
}
.divNorth{
	background:url('image/TitleBackground.jpg') no-repeat center center;
	background-size:100% 100%;
}

#winpop { width:250px; height:0px; position:absolute; right:0; bottom:0; border:1px solid #87CEFA; margin:0; padding:1px; overflow:hidden; display:none;}
#winpop .title { width:100%; height:23px; line-height:23px;background:#87CEFA; font-weight:bold; text-align:center; font-size:12px;}
#winpop .con1 { width:100%; height:150px;line-height:20px;background:#FFF; font-weight:bold; font-size:12px; color:#FF0000;}
#silu { font-size:12px; color:#666; position:absolute; right:0; text-align:right; text-decoration:underline; line-height:22px;}
.close { position:absolute; right:4px; top:1px; color:#FFF; cursor:pointer}
</style>
</head>
<body class="easyui-layout">

	<!-- North Title -->
	<div class="divNorth" style="height:100px;" data-options="region:'north'" >
		<table id="_TableHeader" width="100%" border="0" cellpadding="0"
		cellspacing="0" class="bluebg">
		<tbody>
			<tr>
				<td valign="top">
					<div style="position:relative;">
						<div style="text-align:right;font-size:15px;margin:2px 0 0 0;">
							<br /><br />
							<span style="color:black;font-size:20px;font-family:Microsoft Yahei;">部门：${departmentname }</span>
							<br />
							<span style="color:black;font-size:20px;font-family:Microsoft Yahei;">${activeUser.rolename}:</span>
							<span style="color:black;font-size:20px;font-family:Microsoft Yahei;">${activeUser.username}</span>
						    &nbsp;<a href="logout" style="text-decoration:none;color:black;font-family:Microsoft Yahei;"> 退出</a>&nbsp;  &nbsp; 
						</div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	
	<!-- <div data-options="region:'west',title:'功能菜单',split:true"
		style="width:213px;"> -->
	<div id="HomeFuncAccordion" class="easyui-accordion" style="width:213px;"
		data-options="region:'west',title:'功能菜单',split:false">
		<!--<div title="功能搜索"
			data-options="iconCls:'icon-search',collapsed:false,collapsible:false"
			style="padding:10px;">
			<input id="HomeFuncSearch" class="easyui-searchbox" 
				data-options={prompt:'请输入想要搜索的功能'}
				searcher="doSearch" 
				style="width:178px;height:25px;">
				</div>-->
			<!---------------------------------------------------->
			<!-- http://www.jeasyui.net/demo/408.html#  ExpandTo-->
			<!---------------------------------------------------->
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='carMain:view' }">
		<div title="基本信息管理" data-options="selected:true" style="padding:10px;">
			<ul id="scheduleMonitor" class="easyui-tree" data-options="animate:true,lines:true">
				<li><span>基本信息</span>
					<ul>
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carSpecial:view' }">
						<li id=11 data-options="attributes:{'url':'carSpecial/find1'}">专用车管理</li>
						</c:if>
						<c:if test="${per2=='carPublic:view' }" >
						<li id=12 data-options="attributes:{'url':'carPublic/find'}">公务车管理</li>
						</c:if>
						<c:if test="${per2=='carSheng:view' }" >
						<li id=12 data-options="attributes:{'url':'carSheng/find1'}">生产车管理</li>
						</c:if>
						<c:if test="${per2=='carTool:view' }" >
						<li id=18 data-options="attributes:{'url':'department/dep'}">车辆运用台账</li>
						</c:if>
						<c:if test="${per2=='carTool:view' }" >
						<li id=13 data-options="attributes:{'url':'carTool/find'}">随车工具管理</li>
						</c:if>
						</c:forEach>
						<c:forEach items="${sessionScope.sysPermissionList}" var="per3" >
						<c:choose>
						<c:when test="${per3=='carMain1:view' }">
						<li id=14><span>车型管理</span>
							<ul>
							<c:forEach items="${sessionScope.sysPermissionList}" var="per4" >
							<c:if test="${per4=='carType:view' }" >
							<li id=15 data-options="attributes:{'url':'carType/find'}">车型</li>
							</c:if>
							<c:if test="${per4=='carTechnical:view' }" >
							<li id=16 data-options="attributes:{'url':'carTechnical/find'}">技术特性</li>
							</c:if>
							<c:if test="${per4=='maintenance:view' }" >
							<li id=17 data-options="attributes:{'url':'carMaintenance/find'}">维护要求</li>
							</c:if>
							</c:forEach>
							</ul>
						</li>
						</c:when>
						</c:choose>
						</c:forEach>
					</ul>
				</li>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='youMain:view' }">
		<div title="油卡管理" data-options="selected:true" style="padding:10px">
			<ul id="youkaMonitor" class="easyui-tree" data-options="animate:true,lines:true">
						<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carYou:view' }">
						<li id=121 data-options="attributes:{'url':'carYou/find2'}">油卡信息</li>
						</c:if>
						<c:if test="${per2=='carYou:money' }">
						<li id=122 data-options="attributes:{'url':'carYou/moneyfind'}">油卡充值记录</li>
						</c:if>
						<c:if test="${per2=='carYou:view' }">
						<li id=123 data-options="attributes:{'url':'carYou/find'}">油卡累计用油</li>
						</c:if>
						<c:if test="${per2=='carYouka:view' }">
						<li id=124 data-options="attributes:{'url':'carYouka/find'}">用油记录</li>
						</c:if>
						<c:if test="${per2=='carYouapply:view' }">
						<li id=125 data-options="attributes:{'url':'carYouapply/find'}">用油申请</li>
						</c:if>
						<c:if test="${per2=='carYouapprove:view' }">
						<li id=126 data-options="attributes:{'url':'carYouapprove/find'}">用油审批</li>
						</c:if>
					</c:forEach>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='removeMain:view' }">
		<div title="车辆异动管理" data-options="selected:true" style="padding:10px">
			<ul id="deviceMonitor" class="easyui-tree" data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carRemove:view' }">
						<li id=21 data-options="attributes:{'url':'carRemove/find'}">购入记录</li>
						</c:if>
						<c:if test="${per2=='carIn:view' }">
						<li id=22 data-options="attributes:{'url':'carIn/find'}">调入记录</li>
						</c:if>
						<c:if test="${per2=='carOut:view' }">
						<li id=23 data-options="attributes:{'url':'carOut/find'}">调出记录</li>
						</c:if>
						<c:if test="${per2=='carSelf:view' }">
						<li id=24 data-options="attributes:{'url':'carSelf/find'}">段内调配记录</li>
						</c:if>
						<c:if test="${per2=='carDie:view' }">
						<li id=25 data-options="attributes:{'url':'carDie/find'}">报废记录</li>
						</c:if>
						<c:if test="${per2=='carDeploy:view' }">
						<li id=26 data-options="attributes:{'url':'carDeploy/find'}">主车司机变动</li>
						</c:if>
					</c:forEach>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='useMain:view' }">
		<div title="用车管理" data-options="selected:true" style="padding:10px">
			<ul id="technologyMonitor" class="easyui-tree" data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carApply:view' }">
						<li id=31 data-options="attributes:{'url':'carApply/find'}">用车申请</li>
						</c:if>
						<c:if test="${per2=='carApprove:view' }">
						<li id=32 data-options="attributes:{'url':'carApprove/find'}">用车审批</li>
						</c:if>
						<c:if test="${per2=='carSend:view' }">
						<li id=33 data-options="attributes:{'url':'carSend/find'}">派车单</li>
						</c:if>
					</c:forEach>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='keepMain:view' }">
		<div title="车辆维保管理" data-options="selected:true" style="padding:10px;">
			<ul id="qualifyMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carKeep:view' }">
						<li id=41 data-options="attributes:{'url':'carKeep/find'}">保养</li>
						</c:if>
						<c:if test="${per2=='carKeepApply:view' }">
						<li id=42 data-options="attributes:{'url':'carKeepApply/find'}">维修申请</li>
						</c:if>
						<c:if test="${per2=='carKeepApprove:view' }">
						<li id=43 data-options="attributes:{'url':'carKeepApprove/find'}">维修审批</li>
						</c:if>
						<c:if test="${per2=='carTire:view' }">
						<li id=44 data-options="attributes:{'url':'carTire/find'}">轮胎使用</li>
						</c:if>
					</c:forEach>
					</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='yunMain:view' }">
		<div title="车辆运行管理" data-options="selected:true" style="padding:10px;">
			<ul id="runMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carUsing:view' }">
						<li id=51 data-options="attributes:{'url':'carUsing/find'}">运用记录</li>
						</c:if>
						<c:if test="${per2=='carCheck:view' }">
						<li id=52 data-options="attributes:{'url':'carCheck/find'}">月检记录</li>
						</c:if>
						<c:if test="${per2=='carBig:view' }">
						<li id=53 data-options="attributes:{'url':'carBig/find'}">所换大件记录</li>
						</c:if>
					</c:forEach>
					</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='driverMain:view' }">
		<div title="驾驶员管理" data-options="selected:true" style="padding:10px;">
			<ul id="driverMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carDriver:view' }">
						<li id=131 data-options="attributes:{'url':'carDriver/find '}">司机管理</li>
						</c:if>
						<c:if test="${per2=='driverStudey:view' }">
						<li id=132 data-options="attributes:{'url':'driverStudey/find '}">安全学习记录</li>
						</c:if>
						<c:if test="${per2=='driverRecord:view' }">
						<li id=133 data-options="attributes:{'url':'driverRecord/find'}">安全行驶里程记录</li>
						</c:if>
						<c:if test="${per2=='driverCheck:view' }">
						<li id=134 data-options="attributes:{'url':'driverCheck/find'}">月度考核表</li>
						</c:if>
					</c:forEach>
					</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='safeMain:view' }">
		<div title="安全管理" data-options="selected:true" style="padding:10px;">
			<ul id="safeMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='shigu:view' }">
						<li id=61 data-options="attributes:{'url':'shigu/find'}">交通事故管理</li>
						</c:if>
						<c:if test="${per2=='weigui:view' }">
						<li id=62 data-options="attributes:{'url':'weigui/find'}">违章记录管理</li>
						</c:if>
					</c:forEach>
					</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='tjMain:view' }">
		<div title="报表统计管理" data-options="selected:true" style="padding:10px;">
			<ul id="reportsMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
				<li><span>报表管理</span>
				<ul>
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carCtj:view' }">
						<li id=81 data-options="attributes:{'url':'carCtj/find1'}">车辆报表</li>
						</c:if>
						<c:if test="${per2=='carWbtj:view' }">
						<li id=82 data-options="attributes:{'url':'carWbtj/find1'}">车辆维护报表</li>
						</c:if>
						<c:if test="${per2=='carYdtjIn:view' }">
						<li id=83 data-options="attributes:{'url':'carYdtjIn/find1'}">车辆调入报表</li>
						</c:if>
						<c:if test="${per2=='carYdtjOut:view' }">
						<li id=84 data-options="attributes:{'url':'carYdtjOut/find1'}">车辆调出报表</li>
						</c:if>
						<c:if test="${per2=='carYdtjSelf:view' }">
						<li id=85 data-options="attributes:{'url':'carYdtjSelf/find1'}">车辆段内调配报表</li>
						</c:if>
						<c:if test="${per2=='carYdtjRemove:view' }">
						<li id=86 data-options="attributes:{'url':'carYdtjRemove/find1'}">车辆购入报表</li>
						</c:if>
					</c:forEach>
					</ul>
					</li>
					<li><span>统计分析管理</span>
					<ul>
					<c:if test="${leve==2 }">
						<li id=131 data-options="attributes:{'url':'carTongji/find1'}">车辆图形统计分析</li>
						<li id=132 data-options="attributes:{'url':'carTongji/find2'}">用油图形统计分析</li>
						</c:if>
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carCtj:view' }">
						<li id=133 data-options="attributes:{'url':'carTongji/find3'}">里程图形统计分析</li>
						</c:if>
					</c:forEach>
					</ul>
					</li>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='foldMain:view' }">
		<div title="公共文件管理" data-options="selected:true" style="padding:10px;">
			<ul id="foldMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carFold:view' }">
						<li id=111 data-options="attributes:{'url':'carFold/find'}">资料文件</li>
						</c:if>
					</c:forEach>
					</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='txMain:view' }">
		<div title="系统提醒" data-options="selected:true" style="padding:10px;">
			<ul id="installMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carBS:view' }">
						<li id=91 data-options="attributes:{'url':'carBS/find'}">车辆保养提醒</li>
						</c:if>
					</c:forEach>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='numMain:view' }">
		<div title="数据字典管理" data-options="selected:true" style="padding:10px;">
			<ul id="numberMonitor" class="easyui-tree"
				data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='carCompany:view' }">
						<li id=121 data-options="attributes:{'url':'carCompany/find'}">车辆保养单位</li>
						</c:if>
						<c:if test="${per2=='carCareful:view' }">
						<li id=122 data-options="attributes:{'url':'carCareful/find'}">派车注意事项</li>
						</c:if>
					</c:forEach>
			</ul>
		</div>
		</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach items="${sessionScope.sysPermissionList}" var="per1" >
		<c:choose>
		<c:when test="${per1=='systemMain:view' }">
			<div title="系统管理" style="padding:10px;">
				<ul id="sysManager" class="easyui-tree"
					data-options="animate:true,lines:true">
					<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
						<c:if test="${per2=='user:view' }">
							<li data-options="attributes:{'url':'user/find'}">用户管理</li>
						</c:if>
						<c:if test="${per2=='department:view' }">
						<li id=110 data-options="attributes:{'url':'department/find'}">部门信息</li>
						</c:if>
						<c:if test="${per2=='role:view' }">
							<li data-options="attributes:{'url':'role/find'}">角色管理</li>
						</c:if>
						</c:forEach>
				</ul>
			</div>
		</c:when>
		</c:choose>
		</c:forEach>
	</div>

	<!--<div style="width:42%;height:450px; border:1px solid #000;margin-top:2%;margin-left:5%"> <%@ include file="/WEB-INF/jsp/notice.jsp"%> </div> </div> -->
	<!-- </div> -->
	<div id="MainPage" data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs">
			<div title="首页" style="padding:20px;width:95%;hegith:90%;">
			<div style="width:45%;height:560px; border:1px solid #FFFFFF;float:left;margin-left:1px; overflow:auto">
		<div class="guide-slider" id="guideSlider" style="height:500px;">
		<ul class="guide-list">
		<c:forEach var="item" items="${lists }">
			<li class="guide">
				<div class="display">
					<div class="icon icon2 animated flipInY">${item.department.departmentName }</div>
					<div class="title">${item.carnumber }</div>
					<div class="introduction">${item.usenature }</div>
					<c:choose>
						<c:when test="${item.stat=='使用中' }">
						<div class="introduction"><span 

						style="color:red">${item.stat }</span></div>
						</c:when>
						<c:otherwise>
						<div class="introduction"><span 

						style="color:green">${item.stat }</span></div>
						</c:otherwise>
						</c:choose>
				</div>
				<div class="behind">
					<div class="function-list-wrap">
						<ul class="function-list">
							<li class="function"><a href="#" class="important" onclick="carSend_nowadds('${item.carId }','${item.carnumber }','${item.department.departmentName }','${item.department.departmentId }','${item.department.level }','${item.usenature }')">直接派车</a></li>
							<li class="function"><a href="#" class="important" onclick="carSend_adds('${item.carId }','${item.carnumber }','${item.department.departmentName }','${item.department.departmentId }','${item.department.level }','${item.usenature }')">审批派车</a></li>
							<li class="function"><a href="#" class="important" onclick="carApply_adds('${item.carId }','${item.carnumber }','${item.department.departmentName }','${item.department.departmentId }','${item.department.level }','${item.usenature }')">用车申请</a></li>
							<li class="function"><a href="#" class="important" onclick="carYouka_adds('${item.carId }','${item.carnumber }','${item.usenature }')">添加用油记录</a></li>
						</ul>
					</div>
				</div>
			</li>
			</c:forEach>
	</ul>
</div>
			</div>
			<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
				<c:if test="${per2=='carFold:view' }">
			<div style="width:53%;height:auto; border:1px solid #FFFFFF;float:right;margin-left:1%">
			<%@ include file="/WEB-INF/jsp/bandle.jsp"%>
			</div>
			</c:if>
			</c:forEach>
			<c:forEach items="${sessionScope.sysPermissionList}" var="per2" >
			<div id="winpop">
			<div class="title">车辆提醒通知<span class="close" onclick="tips_pop()">×</span></div>
			 <div class="con1">
			 <c:forEach var="item1" items="${listb }">
			<span style="color:black"> >> </span><span>车辆 ${item1.carnum } 已跑 ${item1.dd } 需要进行 ${item1.notes }.<br>
			 </c:forEach>
			 </div>
			</div>
			</c:forEach>
			</div>
		</div>
	</div>
<div id="carNowSendAddWindows" class="easyui-window" title="新增直接派车单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSend/nowadds'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="carSendAddWindows" class="easyui-window" title="新增审批派车单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSend/adds'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="carApplyAddWindows" class="easyui-window" title="新增用车申请" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carApply/adds'" style="width:800px;height:530px;padding:15px;">
</div>
<div id="carYoukaAddWindows" class="easyui-window" title="添加用油信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYouka/adds'" style="width:550px;height:300px;padding:20px;">
</div>
	<script type="text/javascript">

		function isContains(str, substr) {
		    return new RegExp(substr).test(str);
		}
		
		//HomeFuncSearch
		
		$(function() {
			/* Schedule Manager Tree onClick Event */
			$('#scheduleMonitor').tree({
				onClick : function(node) {
					if ($('#scheduleMonitor').tree("isLeaf", node.target)) {
						var tabs1 = $("#tabs");
						var tab1 = tabs1.tabs("getTab", node.text);
						if (tab1) {
							tabs1.tabs("select", node.text);
						} else {
							tabs1.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
	
			/* Device Manager Tree onClick Event */
			$('#deviceMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#deviceMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			
			/* Technology Manager Tree onClick Event */
			$('#technologyMonitor').tree({
				onClick : function(node) {
					if ($('#technologyMonitor').tree("isLeaf", node.target)) {
						var tabs3 = $("#tabs");
						var tab3 = tabs3.tabs("getTab", node.text);
						if (tab3) {
							tabs3.tabs("select", node.text);
						} else {
							tabs3.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			/* qualify Manager Tree onClick Event */
			$('#qualifyMonitor').tree({
				onClick : function(node) {
					if ($('#qualifyMonitor').tree("isLeaf", node.target)) {
						var tabs1 = $("#tabs");
						var tab1 = tabs1.tabs("getTab", node.text);
						if (tab1) {
							tabs1.tabs("select", node.text);
						} else {
							tabs1.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			$('#youkaMonitor').tree({
				onClick : function(node) {
					if ($('#youkaMonitor').tree("isLeaf", node.target)) {
						var tabs1 = $("#tabs");
						var tab1 = tabs1.tabs("getTab", node.text);
						if (tab1) {
							tabs1.tabs("select", node.text);
						} else {
							tabs1.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			/* Device Manager Tree onClick Event */
			$('#runMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#runMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			/* Device Manager Tree onClick Event */
			$('#driverMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#driverMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			/* Device Manager Tree onClick Event */
			$('#safeMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#safeMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			/* Device Manager Tree onClick Event */
			$('#reportsMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#reportsMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			/* Device Manager Tree onClick Event */
			$('#installMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#installMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			$('#numberMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#numberMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			/* Device Manager Tree onClick Event */
			$('#foldMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#foldMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			/* Device Manager Tree onClick Event */
			$('#employeeMonitor').tree({
				onClick : function(node) {
					/* debugger; */
					if ($('#employeeMonitor').tree("isLeaf", node.target)) {
						var tabs2 = $("#tabs");
						var tab2 = tabs2.tabs("getTab", node.text);
						if (tab2) {
							tabs2.tabs("select", node.text);
						} else {
							tabs2.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
			
			/* Sys Manager Tree onClick Event */
			$('#sysManager').tree({
				onClick : function(node) {
					if ($('#sysManager').tree("isLeaf", node.target)) {
						var tabs3 = $("#tabs");
						var tab3 = tabs3.tabs("getTab", node.text);
						if (tab3) {
							tabs3.tabs("select", node.text);
						} else {
							tabs3.tabs('add', {
								title : node.text,
								href : node.attributes.url,
								closable : true,
								bodyCls : "content"
							});
						}
					}
				}
			});
						
	});
		var $guideSlider = $("#guideSlider").eq(0);

		$guideSlider.find(".guide-list .guide").hover(function() {
		$(this).addClass("on").siblings().removeClass("on");
		});
		
		 function carSend_nowadds(carid,carnumber,departmentName,departmentId,level,usenature){
			 $("#carNowSendAddWindows").window({
            		onLoad :function(){
            			//回显数据
            			var data = new Object();
            			data.departmentId = departmentId;
            			data.carId = carid;
            			data.usenature = usenature;
            			data.carnumber = carnumber;
            			data.departmentName = departmentName;
            			
     				$("#carNowSendAddForms").form("load", data);
            		}
            	}).window("open");  			
			 
			// $("#carNowSendAddWindow").window("open");
		       
		    }
		 function carSend_adds(carid,carnumber,departmentName,departmentId,level,usenature){
			 $("#carSendAddWindows").window({
         		onLoad :function(){
         			//回显数据
         			var data = new Object();
         			data.departmentId = departmentId;
         			data.carId = carid;
         			data.usenature = usenature;
         			data.carnumber = carnumber;
         			data.departmentName = departmentName;
         			
  				$("#carSendAddForms").form("load", data);
         		}
         	}).window("open");  
		    }
		 function carApply_adds(carid,carnumber,departmentName,departmentId,level,usenature){
			 $("#carApplyAddWindows").window({
	         		onLoad :function(){
	         			//回显数据
	         			var data = new Object();
	         			data.departmentId = departmentId;
	         			data.carId = carid;
	         			data.usenature = usenature;
	         			data.usenature1 = usenature;
	         			data.carnumber = carnumber;
	         			data.departmentName = departmentName;
	  				$("#carApplyAddForms").form("load", data);
	         		}
	         	}).window("open");    			
		    }
		 function carYouka_adds(carid,carnumber,usenature){
			 $("#carYoukaAddWindows").window({
	         		onLoad :function(){
	         			//回显数据
	         			var data = new Object();
	         			data.carId = carid;
	         			data.usenature = usenature;
	         			data.carnumber = carnumber;
	  				$("#carYoukaAddForms").form("load", data);
	         		}
	         	}).window("open");    	  			
		    }
		 
		//右下角弹出框;
	
	
	function tips_pop(){
		  var MsgPop=document.getElementById("winpop");
		  var popH=parseInt(MsgPop.style.height);//将对象的高度转化为数字
		   if (popH==0){
		   MsgPop.style.display="block";//显示隐藏的窗口
		  show=setInterval("changeH('up')",2);
		   }
		  else { 
		   hide=setInterval("changeH('down')",2);
		  }
		}
		function changeH(str) {
		 var MsgPop=document.getElementById("winpop");
		 var popH=parseInt(MsgPop.style.height);
		 if(str=="up"){
		  if (popH<=150){
		  MsgPop.style.height=(popH+4).toString()+"px";
		  }
		  else{  
		  clearInterval(show);
		  }
		 }
		 if(str=="down"){ 
		  if (popH>=4){  
		  MsgPop.style.height=(popH-4).toString()+"px";
		  }
		  else{ 
		  clearInterval(hide);   
		  MsgPop.style.display="none";  //隐藏DIV
		  }
		 }
		}
		window.onload=function(){//加载
		document.getElementById('winpop').style.height='0px';
		setTimeout("tips_pop()",800);//3秒后调用tips_pop()这个函数
		}
	</script>
</body>
</html>