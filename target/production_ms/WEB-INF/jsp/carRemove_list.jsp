<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carRemoveList" title="车辆异动列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carRemove/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carRemove">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum4',align:'center',width:100,formatter:formatCarNum4">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">购入人</th>
        	<th data-options="field:'dep',align:'center',width:100,formatter:formatDepartment">购入部门</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">购入日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
             <th data-options="field:'rbeiyong1',align:'center',width:80">车辆性质</th>
            <th data-options="field:'stats',align:'center',width:100">类型</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carRemove" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carRemove:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carRemove_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carRemove:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carRemove_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carRemove:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carRemove_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carRemove_reload()">刷新</a>  
	</div>  
	<div id="search_carRemove" style="float: right;">
        <input id="search_text_carRemove" class="easyui-searchbox"  
            data-options="searcher:doSearch_carRemove,prompt:'请输入...',menu:'#menu_carRemove'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carRemove" style="width:120px"> 
			<div data-options="name:'r1'">车牌号</div>
			<div data-options="name:'r2'">购入人</div> 
		</div>     
    </div>
</div>  

<div id="carRemoveEditWindow" class="easyui-window" title="编辑车辆购入信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carRemove/edit'" style="width:600px;height:350px;padding:10px;">
</div>
<div id="carRemoveAddWindow" class="easyui-window" title="添加车辆购入信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carRemove/add'" style="width:600px;height:350px;padding:10px;">
</div>
<script>
function doSearch_carRemove(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carRemoveList").datagrid({
	        title:'异动车辆列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carRemove", url:'carRemove/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum4', width : 100, align : 'center', title : '购入车辆',formatter:formatCarNum4},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '购入人'},
	             	{field : 'dep', width : 100, align : 'center', title : '购入部门',formatter:formatDepartment},
	             	{field : 'removetime', width : 120, align:'center', title : '购入日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'}
	        ] ],  
	    });
	}else{
		$("#carRemoveList").datagrid({
	        title:'异动车辆列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carRemove", url:'carRemove/search_carRemove_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
             	{field : 'newnum4', width : 100, align : 'center', title : '购入车辆',formatter:formatCarNum4},
             	{field : 'rbieyong2', width : 80, align : 'center', title : '购入人'},
             	{field : 'dep', width : 100, align : 'center', title : '购入部门',formatter:formatDepartment},
             	{field : 'removetime', width : 120, align:'center', title : '购入日期',formatter:TAOTAO.formatDate},
             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
             	{field : 'stats', width : 100, title : '类型', align:'center'}
        ] ],  
    	});
	}
}
function  formatCarNum4(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};

    function getCarRemoveSelectionsIds(){
    	var carRemoveList = $("#carRemoveList");
    	var sels = carRemoveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].removeId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carRemove_add(){
    	$.get("carRemove/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carRemoveAddWindow").window("open");
       		}
       	});
    }
    function getCarRemoveSelectionsnames(){
    	var carRemoveList = $("#carRemoveList");
    	var sels = carRemoveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].rbieyong2);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carRemove_edit(){
    	$.get("carRemove/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarRemoveSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carRemoveEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carRemoveList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            			//if(data.department.fatherdep=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else{
            			//	
            				data.departmentName = data.department.departmentName;
            			//}
        				data.carnumber = data.carRegister.carnumber;
        				data.carId = data.carRegister.carId;
            			data.removetime = TAOTAO.formatDate(data.removetime);
            			$("#carRemoveEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carRemove_delete(){
    	$.get("carRemove/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarRemoveSelectionsIds();
      			var name = getCarRemoveSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除 '+name+' 的购入信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carRemove/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carRemoveList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carRemove_reload(){
    	$("#carRemoveList").datagrid("reload");
    }
</script>