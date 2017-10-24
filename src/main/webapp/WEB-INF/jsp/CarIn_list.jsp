<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carInList" title="车辆调入列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carIn/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carIn">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum1',align:'center',width:150,formatter:formatCarNum">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">调入人</th>
        	<th data-options="field:'dep1',align:'center',width:100,formatter:formatDepartment1">调入部门</th>
        	<th data-options="field:'dep2',align:'center',width:100,formatter:formatDepartment2">调出部门</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">调入日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
             <th data-options="field:'rbeiyong1',align:'center',width:80">车辆性质</th>
            <th data-options="field:'stats',align:'center',width:100">类型</th>
            <th data-options="field:'inEdit',align:'center',width:50,formatter:formatInEdit">编辑</th>
        </tr>
    </thead>
</table>
<div  id="toolbar_carIn" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carIn:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carIn_add()">新增</a>  
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carIn:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carIn_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carIn:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carIn_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carIn_reload()">刷新</a>  
	</div> 
	<div id="search_carIn" style="float: right;">
        <input id="search_text_carIn" class="easyui-searchbox"  
            data-options="searcher:doSearch_carIn,prompt:'请输入...',menu:'#menu_carIn'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carIn" style="width:120px"> 
			<div data-options="name:'i1'">车牌号</div>
			<div data-options="name:'i2'">调入人</div> 
		</div>     
    </div> 

</div>  

<div id="carInEditWindow" class="easyui-window" title="编辑车辆调入信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carIn/edit'" style="width:600px;height:370px;padding:10px;">
</div>
<div id="carInAddWindow" class="easyui-window" title="添加车辆调入信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carIn/add'" style="width:600px;height:370px;padding:10px;">
</div>
<script>
function doSearch_carIn(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carInList").datagrid({
	        title:'车辆调入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carIn", url:'carIn/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum1', width : 150, align : 'center', title : '车辆牌照',formatter:formatCarNum},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调入人'},
	             	{field : 'dep1', width : 100, align : 'center', title : '调入部门',formatter:formatDepartment1},
	             	{field : 'dep2', width : 100, align : 'center', title : '调出部门',formatter:formatDepartment2},
	             	{field : 'removetime', width : 120, align:'center', title : '调入日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'},
	             	{field : 'inEdit', width : 50, align:'center', title : '编辑',formatter:formatInEdit}
	        ] ],  
	    });
	}else{
		$("#carInList").datagrid({
	        title:'车辆调入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carIn", url:'carIn/search_carIn_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum1', width : 150, align : 'center', title : '车辆牌照',formatter:formatCarNum},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调入人'},
	             	{field : 'dep1', width : 100, align : 'center', title : '调入部门',formatter:formatDepartment1},
	             	{field : 'dep2', width : 100, align : 'center', title : '调出部门',formatter:formatDepartment2},
	             	{field : 'removetime', width : 120, align:'center', title : '调入日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'},
	             	{field : 'inEdit', width : 50, align:'center', title : '编辑',formatter:formatInEdit}
	        ] ],  
	    });
	}
}
function  formatInEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carIn_edit()'><span style='color:blue'>编辑</span></a>";
};
function  formatCarNum(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function  formatDepartment2(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department1.departmentName+"";
	}
};
    function getCarInSelectionsIds(){
    	var carInList = $("#carInList");
    	var sels = carInList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].inId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carIn_add(){
    	$.get("carIn/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carInAddWindow").window("open");
       		}
       	});
    }
    function getCarInSelectionsnames(){
    	var carInList = $("#carInList");
    	var sels = carInList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].rbieyong2);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carIn_edit(){
    	$.get("carIn/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarInSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carInEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carInList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            			//if(data.department.fatherdep=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else{
            				data.departmentName = data.department.departmentName;
            			//}
            			//if(data.department1.fatherdep=='0'){
            			//	data.fathername = data.department1.departmentName;
            			//}else{
            				data.departmentName1 = data.department1.departmentName;
            			//}
        				data.outorgan = data.department1.departmentId;
        				data.carnumber = data.carRegister.carnumber;
        				data.carId = data.carRegister.carId;
            			data.removetime = TAOTAO.formatDate(data.removetime);
            			$("#carInEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carIn_delete(){
    	$.get("carIn/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarInSelectionsIds();
      			var name = getCarInSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除 '+name+' 的调入信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carIn/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carInList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carIn_reload(){
    	$("#carInList").datagrid("reload");
    }
</script>