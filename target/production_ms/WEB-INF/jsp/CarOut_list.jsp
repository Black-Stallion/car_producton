<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carOutList" title="车辆调出列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carOut/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carOut">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum2',align:'center',width:100,formatter:formatCarNum2">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">调出人</th>
        	<th data-options="field:'dep3',align:'center',width:100,formatter:formatDepartment3">调入部门</th>
        	<th data-options="field:'dep4',align:'center',width:100,formatter:formatDepartment4">调出部门</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">调出日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
            <th data-options="field:'rbeiyong1',align:'center',width:80">车辆性质</th>
            <th data-options="field:'stats',align:'center',width:100">类型</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carOut" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carOut:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carOut_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carOut:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carOut_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carOut:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carOut_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carOut_reload()">刷新</a>  
	</div>
	<div id="search_carOut" style="float: right;">
        <input id="search_text_carOut" class="easyui-searchbox"  
            data-options="searcher:doSearch_carOut,prompt:'请输入...',menu:'#menu_carOut'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carOut" style="width:120px"> 
			<div data-options="name:'o1'">车牌号</div>
			<div data-options="name:'o2'">调出人</div> 
		</div>     
    </div>   

</div>  

<div id="carOutEditWindow" class="easyui-window" title="编辑车辆调出信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carOut/edit'" style="width:600px;height:380px;padding:10px;">
</div>
<div id="carOutAddWindow" class="easyui-window" title="添加车辆调出信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carOut/add'" style="width:600px;height:380px;padding:10px;">
</div>
<script>
function doSearch_carOut(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carOutList").datagrid({
	        title:'车辆调出列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carOut", url:'carOut/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum2', width : 100, align : 'center', title : '车辆牌照',formatter:formatCarNum2},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调出人'},
	             	{field : 'dep3', width : 100, align : 'center', title : '调入部门',formatter:formatDepartment3},
	             	{field : 'dep4', width : 100, align : 'center', title : '调出部门',formatter:formatDepartment4},
	             	{field : 'removetime', width : 120, align:'center', title : '调出日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'}
	        ] ],  
	    });
	}else{
		$("#carOutList").datagrid({
	        title:'车辆调出列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carOut", url:'carOut/search_carOut_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
		        	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum2', width : 100, align : 'center', title : '车辆牌照',formatter:formatCarNum2},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调出人'},
	             	{field : 'dep3', width : 100, align : 'center', title : '调入部门',formatter:formatDepartment3},
	             	{field : 'dep4', width : 100, align : 'center', title : '调出部门',formatter:formatDepartment4},
	             	{field : 'removetime', width : 120, align:'center', title : '调出日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'}
	        ] ],  
	    });
	}
}
function  formatCarNum2(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment3(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department2.departmentName+"";
	}
};
function  formatDepartment4(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department3.departmentName+"";
	}
};

    function getCarOutSelectionsIds(){
    	var carOutList = $("#carOutList");
    	var sels = carOutList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].outId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carOut_add(){
    	$.get("carOut/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carOutAddWindow").window("open");
       		}
       	});
    }
    function getCarOutSelectionsnames(){
    	var carOutList = $("#carOutList");
    	var sels = carOutList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].rbieyong2);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carOut_edit(){
    	$.get("carOut/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarOutSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carOutEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carOutList").datagrid("getSelections")[0];
            			data.departmentId = data.department2.departmentId;
            			//if(data.department2.fatherdep=='0'){
            			//	data.fathername = data.department2.departmentName;
            			//}else{
            				data.departmentName = data.department2.departmentName;
            			//}
        				data.outorgan = data.department3.departmentId;
        				//if(data.department3.fatherdep=='0'){
            			//	data.fathername = data.department3.departmentName;
            			//}else{
            				data.departmentName1 = data.department3.departmentName;
            			//}
        				data.carnumber = data.carRegister.carnumber;
        				data.carId = data.carRegister.carId;
            			data.removetime = TAOTAO.formatDate(data.removetime);
            			$("#carOutEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carOut_delete(){
    	$.get("carOut/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarOutSelectionsIds();
      			var name = getCarOutSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除 '+name+' 的调出信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carOut/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carOutList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carOut_reload(){
    	$("#carOutList").datagrid("reload");
    }
</script>