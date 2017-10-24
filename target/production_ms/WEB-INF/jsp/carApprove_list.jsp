<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carApproveList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carApprove/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carApprove">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'bianhao',width:90,align:'center'">申请编号</th>
        	<th data-options="field:'carnumber10',width:50,align:'center',formatter:formatCarNumber10">申请车辆</th>
        	<th data-options="field:'applyname',align:'center',width:50">申请人</th>
            <th data-options="field:'departmentName',align:'center',width:60,formatter:formatDepartment">用车部门</th>
            <th data-options="field:'days',align:'center',width:50">天数(/天)</th>
            <th data-options="field:'outdriver',align:'center',width:40,formatter:formatCarDriver">出车司机</th>
            <th data-options="field:'people',align:'center',width:40">人数(/位)</th>
            <th data-options="field:'outtime',width:80,align:'center',formatter:TAOTAO.formatDate">出车时间</th>
            <th data-options="field:'applytime',width:80,align:'center',formatter:TAOTAO.formatDate">申请时间</th>
            <th data-options="field:'thing',width:130,align:'center',formatter:formatCarThing">用车理由</th>
            <th data-options="field:'stats',width:100,align:'center'">审批状态</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carApprove" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carApprove:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carApprove_edit()">审批</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carApprove_reload()">刷新</a>  
	</div> 
   
</div>  

<div id="carApproveEditWindow" class="easyui-window" title="用车审批" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carApprove/edit'" style="width:800px;height:530px;padding:10px;">
</div>

<script>
function doSearch_carApprove(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carApproveList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carApprove", url:'carApprove/list/', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'bianhao', width : 90, title : '申请编号', align:'center'},
	             	{field : 'carnumber10', width : 50, title : '申请车辆', align:'center',formatter:formatCarNumber10},
	             	{field : 'applyname', width : 50, align:'center',title : '申请人'},
	             	{field : 'departmentName', width : 60, align : 'center', title : '用车部门',formatter:formatDepartment},
	             	{field : 'days', width : 60, align : 'center', title : '天数(/天)'}, 
	             	{field : 'outdriver', width : 40, align : 'center', title : '出车司机',formatter:formatCarDriver}, 
	             	{field : 'people', width : 40, align : 'center', title : '人数(/位)'}, 
	             	{field : 'outtime', width : 80, title : '出车时间', align:'center',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'applytime', width : 80, title : '申请时间', align:'center',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'usenature', width : 50, title : '车辆性质', align:'center'},
	             	{field : 'thing', width : 130, title : '携带货物', align:'center',formatter:formatCarThing},
	             	{field : 'stats', width : 40, title : '审批状态', align:'center'}
	        ] ],  
	    });
	}
}

  //格式化车型信息
    function  formatCarNumber10(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		debugger;
    		return ""+row.carRegister.carnumber+"</a>";
    	}
	};
	 function  formatDepartment(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.department.departmentName+"";
	    	}
		};
		
		 function  formatCarDriver(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		return ""+row.carDriver.drviername+"</a>";
		    	}
			};
			function  formatCarThing(value, row, index){ 
			    	if(value !=null && value != ''){
						return ""+row.thing+"</a>";
						}
			    	else{
			    		return '无';
			    	}
				};
	 //格式化部门信息
 //   function  formatDepartment(value, row, index){ 
  //  		return ""+row.department.departmentName+"";
//	};
	//根据index拿到该行值
	function onCarApproveClickRow(index) {
		var rows = $('#carApproveList').datagrid('getRows');
		return rows[index];
	}
	
	function getCarApproveSelectionsIds(){
    	var carApproveList = $("#carApproveList");
    	var sels = carApproveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].applyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	
	
	//更新信息要求
	function updateCarApproveNote(){
		$.get("carApprove/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carApproveNoteEditor.sync();
    			$.post("carApprove/update_note",$("#carApproveNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carApproveNoteDialog").dialog("close");
    					$("#carApproveList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
 
    function carApprove_edit(){
    	$.get("carApprove/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarApproveSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carApproveEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carApproveList").datagrid("getSelections")[0];
        				data.applytime = TAOTAO.formatDateTime(data.applytime);
        				data.outtime = TAOTAO.formatDateTime(data.outtime);
        				data.carnumber = data.carRegister.carnumber;
        				data.usenature = data.carRegister.usenature;
        				data.carId = data.carRegister.carId;
        				data.departmentId = data.department.departmentId;
        				data.departmentName = data.department.departmentName;
        				data.driverId = data.carDriver.driverId;
        				data.stats = '通过';
        				data.applyname = data.applyname;
        				approve1Editor.html(data.thing);
               			$("#carApproveEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarApproveSelectionsNames(){
    	var carApproveList = $("#carApproveList");
    	var sels = carApproveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].applyname);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
   
    function carApprove_reload(){
    	$("#carApproveList").datagrid("reload");
    }
</script>