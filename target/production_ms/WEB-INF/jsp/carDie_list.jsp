<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carDieList" title="车辆回收列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carDie/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carDie">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum',align:'center',width:120">车架号</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">填写人</th>
        	<th data-options="field:'depart',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	 <th data-options="field:'stats',align:'center',width:100">残值</th>
            <th data-options="field:'removenum',align:'center',width:150">分局批文</th>
             <th data-options="field:'inorgan',align:'center',width:150">回收证号</th>
             <th data-options="field:'removetime',align:'center',width:80,formatter:TAOTAO.formatDate">报废日期</th>
             <th data-options="field:'rbeiyong1',align:'center',width:60">车辆性质</th>
            <th data-options="field:'notes',align:'center',width:160,formatter:formatFile">回收证明附件</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carDie" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carDie:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carDie_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carDie:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carDie_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carDie:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carDie_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carDie_reload()">刷新</a>  
	</div>  
</div>  
<div id="carDieEditWindow" class="easyui-window" title="编辑车辆报废信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carDie/edit'" style="width:600px;height:450px;padding:10px;">
</div>
<div id="carDieAddWindow" class="easyui-window" title="添加车辆报废信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carDie/add'" style="width:600px;height:450px;padding:10px;">
</div>
<script>
function doSearch_carDie(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carDieList").datagrid({
	        title:'车辆回收列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carDie", url:'carDie/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum', width : 120, align : 'center', title : '车架号'},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '填写人'},
	             	{field : 'depart', width : 100, align : 'center', title : '回收部门',formatter:formatDepartment},
	             	{field : 'stats', width : 100, title : '残值', align:'center'},
	             	{field : 'removenum', width : 150, align : 'center', title : '分局批文'},
	             	{field : 'inorgan', width : 150, align : 'center', title : '回收证号'},
	             	{field : 'removetime', width : 120, align:'center', title : '报废日期',formatter:TAOTAO.formatDate},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'notes', width : 100, title : '回收证明附件', align:'center',formatter:formatFile}
	        ] ],  
	    });
	}
}


	function  formatDepartment(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.department.departmentName+"";
    	}
	};
	
	//根据index拿到该行值
	function onCarDieClickRow(index) {
		var rows = $('#carDieList').datagrid('getRows');
		return rows[index];
	}
	
    function getCarDieSelectionsIds(){
    	var carDieList = $("#carDieList");
    	var sels = carDieList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].dieId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carDie_add(){
    	$.get("carDie/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carDieAddWindow").window("open");
       		}
       	});
    }
    function getCarDieSelectionsnames(){
    	var carDieList = $("#carDieList");
    	var sels = carDieList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].newnum);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carDie_edit(){
    	$.get("carDie/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarDieSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carDieEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carDieList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            			//if(data.department.fatherdep=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else{
            				data.departmentName = data.department.departmentName;
            			//}
            			data.removetime = TAOTAO.formatDate(data.removetime);
            			$("#orderEditForm").form("load", data);
            			//加载文件上传插件
               			initOrderEditFileUpload();
               			//加载上传过的文件
               			initUploadedFile();
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carDie_delete(){
    	$.get("carDie/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarDieSelectionsIds();
      			var name = getCarDieSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除车架号为 '+name+' 的报废信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carDie/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carDieList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carDie_reload(){
    	$("#carDieList").datagrid("reload");
    }
</script>