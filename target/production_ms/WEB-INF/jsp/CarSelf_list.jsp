<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carSelfList" title="段内调配列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carSelf/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carSelf">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum3',align:'center',width:100,formatter:formatCarNum3">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">调配人</th>
        	<th data-options="field:'dep5',align:'center',width:100,formatter:formatDepartment5">调入车间</th>
        	<th data-options="field:'dep6',align:'center',width:100,formatter:formatDepartment6">调出车间</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">调出日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
            <th data-options="field:'rbeiyong1',align:'center',width:80">车辆性质</th>
            <th data-options="field:'stats',align:'center',width:100">类型</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carSelf" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carSelf:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carSelf_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carSelf:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carSelf_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carSelf:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carSelf_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carSelf_reload()">刷新</a>  
	</div>  
	<div id="search_carSelf" style="float: right;">
        <input id="search_text_carSelf" class="easyui-searchbox"  
            data-options="searcher:doSearch_carSelf,prompt:'请输入...',menu:'#menu_carSelf'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carSelf" style="width:120px"> 
			<div data-options="name:'s1'">车牌号</div>
			<div data-options="name:'s2'">调配人</div> 
		</div>     
    </div>   
</div>  
<div id="carSelfEditWindow" class="easyui-window" title="编辑车辆调配信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carSelf/edit'" style="width:600px;height:380px;padding:10px;">
</div>
<div id="carSelfAddWindow" class="easyui-window" title="添加车辆调配信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carSelf/add'" style="width:600px;height:380px;padding:10px;">
</div>
<script>
function doSearch_carSelf(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carSelfList").datagrid({
	        title:'段内调配列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSelf", url:'carSelf/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum3', width : 100, align : 'center', title : '车辆牌照',formatter:formatCarNum3},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调配人'},
	             	{field : 'dep5', width : 100, align : 'center', title : '调入车间',formatter:formatDepartment5},
	             	{field : 'dep6', width : 100, align : 'center', title : '调出车间',formatter:formatDepartment6},
	             	{field : 'removetime', width : 100, align:'center', title : '调出日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'}
	        ] ],  
	    });
	}else{
		$("#carSelfList").datagrid({
	        title:'段内调配列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSelf", url:'carSelf/search_carSelf_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum3', width : 100, align : 'center', title : '车辆牌照',formatter:formatCarNum3},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调配人'},
	             	{field : 'dep5', width : 100, align : 'center', title : '调入车间',formatter:formatDepartment5},
	             	{field : 'dep6', width : 100, align : 'center', title : '调出车间',formatter:formatDepartment6},
	             	{field : 'removetime', width : 100, align:'center', title : '调出日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 100, title : '类型', align:'center'}
	        ] ],  
	    });
	}
}
function  formatCarNum3(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment5(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department5.departmentName+"";
	}
};
function  formatDepartment6(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department6.departmentName+"";
	}
};
    function getCarSelfSelectionsIds(){
    	var carSelfList = $("#carSelfList");
    	var sels = carSelfList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].selfId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carSelf_add(){
    	$.get("carSelf/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carSelfAddWindow").window("open");
       		}
       	});
    }
    function getCarSelfSelectionsnames(){
    	var carSelfList = $("#carSelfList");
    	var sels = carSelfList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].rbieyong2);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carSelf_edit(){
    	$.get("carSelf/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarSelfSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carSelfEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carSelfList").datagrid("getSelections")[0];
            			data.departmentId = data.department5.departmentId;
            			//if(data.department5.fatherdep=='0'){
            			//	data.fathername = data.department5.departmentName;
            			//}else{
            				data.departmentName = data.department5.departmentName;
            			//}
        				data.outorgan = data.department6.departmentId;
        				//if(data.department6.fatherdep=='0'){
            			//	data.fathername = data.department6.departmentName;
            			//}else{
            				data.departmentName1 = data.department6.departmentName;
            			//}
        				data.carnumber = data.carRegister.carnumber;
        				data.carId = data.carRegister.carId;
            			data.removetime = TAOTAO.formatDate(data.removetime);
            			$("#carSelfEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carSelf_delete(){
    	$.get("carSelf/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarSelfSelectionsIds();
      			var name = getCarSelfSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除'+name+'的调配信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carSelf/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carSelfList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carSelf_reload(){
    	$("#carSelfList").datagrid("reload");
    }
</script>