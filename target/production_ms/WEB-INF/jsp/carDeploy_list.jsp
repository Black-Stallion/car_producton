<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carDeployList" title="变动记录信息" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carDeploy/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carDeploy">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deploy',align:'center',width:100,formatter:TAOTAO.formatDate">变动时间</th>
	      	<th data-options="field:'car3',align:'center',width:100,formatter:formatcar3">车牌号</th>
        	<th data-options="field:'driver3',align:'center',width:100,formatter:formatdr3">主车司机</th>
        	<th data-options="field:'age',align:'center',width:60,formatter:formatdrage">年龄(/岁)</th>
            <th data-options="field:'type1',width:100,align:'center',formatter:formatdrtype">准驾车型</th>
            <th data-options="field:'carnum1',align:'center',width:200,formatter:formatdrcarnum">驾驶证号</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carDeploy" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carDeploy:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carDeploy_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carDeploy:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carDeploy_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carDeploy:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carDeploy_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carDeploy_reload()">刷新</a>  
	</div>
	<div id="search_carDeploy" style="float: right;">
        <input id="search_text_carDeploy" class="easyui-searchbox"  
            data-options="searcher:doSearch_carDeploy,prompt:'请输入...',menu:'#menu_carDeploy'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carDeploy" style="width:120px"> 
			<div data-options="name:'d1'">车牌号</div>
			<div data-options="name:'d2'">司机名称</div> 
		</div>     
    </div>  
</div>  

<div id="carDeployEditWindow" class="easyui-window" title="编辑变动记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carDeploy/edit'" style="width:500px;height:350px;padding:60px;">
</div>
<div id="carDeployAddWindow" class="easyui-window" title="添加变动记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carDeploy/add'" style="width:500px;height:350px;padding:60px;">
</div>

<script>
function doSearch_carDeploy(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carDeployList").datagrid({
	        title:'变动记录信息', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carDeploy", url:'carDeploy/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'deploy', width : 100, align:'center', title : '变动时间',formatter:TAOTAO.formatDate},
	             	{field : 'car3', width : 100, align:'center', title : '车牌号',formatter:formatcar3},
	             	{field : 'driver3', width : 100, align : 'center', title : '主车司机',formatter:formatdr3}, 
	             	{field : 'age', width : 60, title : '年龄(/岁)', align:'center',formatter:formatdrage}, 
	            	{field : 'type1', width : 100, title : '准驾车型', align:'center',formatter:formatdrtype},
	            	{field : 'carnum1', width : 200, title : '驾驶证号', align:'center',formatter:formatdrcarnum},
	       ]  ],  
	    });
	}else{
		$("#carDeployList").datagrid({
	        title:'变动记录信息', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carDeploy", url:'carDeploy/search_carDeploy_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	        	{field : 'ck', checkbox:true }, 
             	{field : 'deploy', width : 100, align:'center', title : '变动时间',formatter:TAOTAO.formatDate},
             	{field : 'car3', width : 100, align:'center', title : '车牌号',formatter:formatcar3},
             	{field : 'driver3', width : 100, align : 'center', title : '主车司机',formatter:formatdr3}, 
             	{field : 'age', width : 60, title : '年龄(/岁)', align:'center',formatter:formatdrage}, 
            	{field : 'type1', width : 100, title : '准驾车型', align:'center',formatter:formatdrtype},
            	{field : 'carnum1', width : 200, title : '驾驶证号', align:'center',formatter:formatdrcarnum},
	        ] ],  
	    });	
	}
}


//格式化违规记录记录信息
function  formatdr3(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drviername+"";
	}
};
function  formatcar3(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatdrage(value, row, index){ 
	var date = new Date();
	var year = date.getFullYear();
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+(year-row.carDriver.ye)+"";
	}
};
function  formatdrtype(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.cartype+"";
	}
};
function  formatdrcarnum(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drivernum+"";
	}
};
//根据index拿到该行值
function oncarDeployClickRow(index) {
	var rows = $('#carDeployList').datagrid('getRows');
	return rows[index];
}



	//更新订单要求
	function updatecarDeployNote(){
		$.get("carDeploy/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("carDeploy/update_note",$("#carDeployNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carDeployNoteDialog").dialog("close");
    					$("#carDeployList").datagrid("reload");
    					$.messager.alert("操作提示", "更新变动记录信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新变动记录信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getcarDeploySelectionsIds(){
    	var carDeployList = $("#carDeployList");
    	var sels = carDeployList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].deployId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function carDeploy_add(){
    	$.get("carDeploy/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carDeployAddWindow").window("open");
       		}
       	});
    }
    
    function carDeploy_edit(){
    	$.get("carDeploy/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getcarDeploySelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一条录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一条记录信息!');
               		return ;
               	}
               	$("#carDeployEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carDeployList").datagrid("getSelections")[0];
               			data.deploy = TAOTAO.formatDateTime(data.deploy);
        	    		data.driverId = data.carDriver.driverId;
        	    		data.carnumber = data.carRegister.carnumber;
        				data.usenature = data.carRegister.usenature;
        				data.carId = data.carRegister.carId;
               			$("#carDeployEditForm1").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getcarDeploySelectionsNames(){
    	var carDeployList = $("#carDeployList");
    	var sels = carDeployList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].typename);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carDeploy_delete(){
    	$.get("carDeploy/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getcarDeploySelectionsNames();
      			var ids = getcarDeploySelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该条变动记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carDeploy/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除变动记录成功!',undefined,function(){
                  					$("#carDeployList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closecarDeployEditForm(){
					$("#carDeployListWindow").window('close');
					$("#carDeployEditForm").datagrid("reload");
	}
    
    function carDeploy_reload(){
    	$("#carDeployList").datagrid("reload");
    }
    
 
</script>