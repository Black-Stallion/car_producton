<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carMaintenanceList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carMaintenance/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carMaintenance">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'mname',width:100,align:'center'">维护名称</th>
        	<th data-options="field:'typename',align:'center',width:100,formatter:formatCarType">车型名称</th>
            <th data-options="field:'kilometre',align:'center',width:100">维护要求</th>
            <th data-options="field:'mproject',align:'center',width:400">维护项目</th>
            <th data-options="field:'edit',align:'center',width:60,formatter:formatCarEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carMaintenance" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='maintenance:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carMaintenance_add()">新增</a> 
		    </div>  
		</c:if>
		<!--  <c:if test="${per=='maintenance:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carMaintenance_edit()">编辑</a>  
		    </div>  
		</c:if>-->
		
		<c:if test="${per=='maintenance:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carMaintenance_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carMaintenance_reload()">刷新</a>  
	</div> 
</div>  

<div id="carMaintenanceEditWindow" class="easyui-window" title="编辑维护要求" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carMaintenance/edit'" style="width:500px;height:280px;padding:10px;">
</div>
<div id="carMaintenanceAddWindow" class="easyui-window" title="添加维护要求" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carMaintenance/add'" style="width:500px;height:280px;padding:10px;">
</div>

<script>
function doSearch_carMaintenance(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carMaintenanceList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carMaintenance", url:'carMaintenance/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'maintenanceId', type:'hidden'},
	             	{field : 'mname', width : 100, title : '维护名称', align:'center'},
	             	{field : 'typename', width : 100, align:'center',title : '车型名称',formatter:formatCarType},
	             	{field : 'kilometre', width : 100, align : 'center', title : '维护规则'},
	             	{field : 'mproject', width : 400, align : 'center', title : '维护项目'}
	        ] ],  
	    });
	}
}
	var CarTypeEditor ;

  //格式化车型信息
    function  formatCarType(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.carType.typename+"";
    	}
	};
    function  formatCarEdit(value, row, index){ 
    	return "<a herf='#' style='cursor:pointer' onclick='carMaintenance_edit()'><span style='color:blue'>编辑</span></a>";
    	//carMaintenance_edit();
	};
	
	//根据index拿到该行值
	function onCarMainTenanceClickRow(index) {
		var rows = $('#carMaintenanceList').datagrid('getRows');
		return rows[index];
		
	}
	
	
	
	//更新信息要求
	function updateCarMainTenanceNote(){
		$.get("carMaintenance/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carMaintenanceNoteEditor.sync();
    			$.post("carMaintenance/update_note",$("#carMaintenanceNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carMaintenanceNoteDialog").dialog("close");
    					$("#carMaintenanceList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getCarMainTenanceSelectionsIds(){
    	var carMaintenanceList = $("#carMaintenanceList");
    	var sels = carMaintenanceList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].maintenanceId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carMaintenance_add(){
    	$.get("carMaintenance/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carMaintenanceAddWindow").window("open");
       		}
       	});
    }
    
    function carMaintenance_edit(){
    	$.get("carMaintenance/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarMainTenanceSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carMaintenanceEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carMaintenanceList").datagrid("getSelections")[0];
               			data.typeid = data.carType.typeid; 
               			$("#carMaintenanceEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarMainTenanceSelectionsNames(){
    	var carMaintenanceList = $("#carMaintenanceList");
    	var sels = carMaintenanceList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].mname);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carMaintenance_delete(){
    	$.get("carMaintenance/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarMainTenanceSelectionsNames();
      			var ids = getCarMainTenanceSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除 '+names+' 的维修信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carMaintenance/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carMaintenanceList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    
    function carMaintenance_reload(){
    	$("#carMaintenanceList").datagrid("reload");
    }
</script>