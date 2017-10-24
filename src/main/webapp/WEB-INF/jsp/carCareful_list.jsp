<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carCarefulList" title="出车注意事项表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carCareful/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carCareful">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'name',width:400,align:'center'">注意事项名称</th>
            <th data-options="field:'yong',align:'center',width:400">参数</th>
            <th data-options="field:'carefulEdit',align:'center',width:50,formatter:formatCarefulEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carCareful" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carCareful:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carCareful_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carCareful:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carCareful_edit()">编辑</a> 
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carCareful:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carCareful_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carCareful_reload()">刷新</a>  
	</div> 
</div>  
<div id="carCarefulEditWindow" class="easyui-window" title="修改注意事项" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carCareful/edit'" style="width:450px;height:240px;padding:30px;">
</div>
<div id="carCarefulAddWindow" class="easyui-window" title="添加注意事项" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carCareful/add'" style="width:450px;height:240px;padding:30px;">
</div>
<script>
function doSearch_carCareful(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carCarefulList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carCareful", url:'carCareful/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'carefulId', type:'hidden'},
	             	{field : 'mname', width : 100, title : '维护名称', align:'center'},
	             	{field : 'typename', width : 100, align:'center',title : '车型名称',formatter:formatCarType},
	             	{field : 'kilometre', width : 100, align : 'center', title : '维护规则'},
	             	{field : 'mproject', width : 400, align : 'center', title : '维护项目'}
	        ] ],  
	    });
	}
}
	
	//根据index拿到该行值
	function onCarCarefulClickRow(index) {
		var rows = $('#carCarefulList').datagrid('getRows');
		return rows[index];
	}
	
	function  formatCarefulEdit(value, row, index){ 
		return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carCareful_edit()'><span style='color:blue'>编辑</span></a>";
	};
	
	
    function getCarCarefulSelectionsIds(){
    	var carCarefulList = $("#carCarefulList");
    	var sels = carCarefulList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carefulId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carCareful_add(){
    	$.get("carCareful/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carCarefulAddWindow").window("open");
       		}
       	});
    }
    function carCareful_edit(){
    	$.get("carCareful/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarCarefulSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一条信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一条信息!');
               		return ;
               	}
               	$("#carCarefulEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carCarefulList").datagrid("getSelections")[0];
               			$("#carCarefulEditForm15").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
   
    function carCareful_delete(){
    	$.get("carCareful/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarCarefulSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该条信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carCareful/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carCarefulList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    
    function carCareful_reload(){
    	$("#carCarefulList").datagrid("reload");
    }
</script>