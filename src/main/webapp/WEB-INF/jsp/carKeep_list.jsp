<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carKeepList" title="车辆保养列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carKeep/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carKeep">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnum54',align:'center',width:100,formatter:formatCarNum54">保养车辆</th>
        	<th data-options="field:'intervalkm',align:'center',width:100">当前里程(/公里)</th>
        	<th data-options="field:'departmentName',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	<th data-options="field:'startdate',align:'center',width:80,formatter:TAOTAO.formatDate">开始日期</th>
        	<th data-options="field:'enddate',align:'center',width:80,formatter:TAOTAO.formatDate">截止日期</th>
            <th data-options="field:'repairtype',align:'center',width:200">保养级别或保养项目</th>
            <th data-options="field:'suppliername',align:'center',width:80">厂家名称</th>
            <th data-options="field:'beiyong2',align:'center',width:80">车辆性质</th>
            <th data-options="field:'carKeepEdit',align:'center',width:50,formatter:formatCarKeepEdit">编辑</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carKeep" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carKeep:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carKeep_add()">新增</a>  
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carKeep:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carKeep_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carKeep:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carKeep_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carKeep_reload()">刷新</a>  
	</div>  
	<div id="search_carKeep" style="float: right;">
        <input id="search_text_carKeep" class="easyui-searchbox"  
            data-options="searcher:doSearch_carKeep,prompt:'请输入...',menu:'#menu_carKeep'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carKeep" style="width:120px"> 
			<div data-options="name:'k1'">车牌号</div>
			<div data-options="name:'k2'">厂家名称</div> 
		</div>     
    </div>
</div>  

<div id="carKeepEditWindow" class="easyui-window" title="编辑保养信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carKeep/edit'" style="width:850px;height:550px;padding:10px;">
</div>
<div id="carKeepAddWindow" class="easyui-window" title="添加保养信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carKeep/add'" style="width:850px;height:550px;padding:10px;">
</div>
<script>
function doSearch_carKeep(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carKeepList").datagrid({
	        title:'车辆保养列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carKeep", url:'carKeep/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'carnum54', width : 100, align : 'center', title : '保养车辆',formatter:formatCarNum54},
	             	{field : 'intervalkm', width : 100, align : 'center', title : '当前里程(/公里)'},
	             	{field : 'departmentName', width : 100, align : 'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'startdate', width : 80, align : 'center', title : '开始日期',formatter:TAOTAO.formatDate},
	             	{field : 'enddate', width : 80, align:'center', title : '截止日期',formatter:TAOTAO.formatDate},
	             	{field : 'repairtype', width : 200, align : 'center', title : '保养级别或保养项目'},
	             	{field : 'suppliername', width : 80, align : 'center', title : '厂家名称'},
	             	{field : 'beiyong2', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'carKeepEdit', width : 50, align:'center', title : '编辑',formatter:formatCarKeepEdit}
	        ] ],  
	    });
	}else{
		$("#carKeepList").datagrid({
	        title:'车辆保养列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carKeep", url:'carKeep/search_carKeep_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'carnum54', width : 100, align : 'center', title : '保养车辆',formatter:formatCarNum54},
	             	{field : 'intervalkm', width : 100, align : 'center', title : '当前里程(/公里)'},
	             	{field : 'departmentName', width : 100, align : 'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'startdate', width : 80, align : 'center', title : '开始日期',formatter:TAOTAO.formatDate},
	             	{field : 'enddate', width : 80, align:'center', title : '截止日期',formatter:TAOTAO.formatDate},
	             	{field : 'repairtype', width : 200, align : 'center', title : '保养级别或保养项目'},
	             	{field : 'suppliername', width : 80, align : 'center', title : '厂家名称'},
	             	{field : 'beiyong2', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'carKeepEdit', width : 50, align:'center', title : '编辑',formatter:formatCarKeepEdit}
	        ] ],  
	    });
	}
}

function  formatCarKeepEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carKeep_edit()'><span style='color:blue'>编辑</span></a>";
};

function  formatCarNum54(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
    function getCarKeepSelectionsIds(){
    	var carKeepList = $("#carKeepList");
    	var sels = carKeepList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].keepId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function  formatDepartment(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.department.departmentName+"";
    	}
	};
    function carKeep_add(){
    	$.get("carKeep/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carKeepAddWindow").window("open");
       		}
       	});
    }
    function getCarKeepSelectionsnames(){
    	var carKeepList = $("#carKeepList");
    	var sels = carKeepList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carRegister.carnumber);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carKeep_edit(){
    	$.get("carKeep/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarKeepSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carKeepEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carKeepList").datagrid("getSelections")[0];
            			data.startdate = TAOTAO.formatDate(data.startdate);
            			data.enddate = TAOTAO.formatDate(data.enddate);
            			data.departmentId = data.department.departmentId;
            			//if(data.department.fatherdep=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else{
            				data.departmentName = data.department.departmentName;
            			//}
        				data.carnumber = data.carRegister.carnumber;
        				data.carId = data.carRegister.carId;
            			keep1Editor.html(data.repairtype);
            			$("#carKeepEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carKeep_delete(){
    	$.get("carKeep/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarKeepSelectionsIds();
      			var name = getCarKeepSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除车牌号为 '+name+' 的保养信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carKeep/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carKeepList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carKeep_reload(){
    	$("#carKeepList").datagrid("reload");
    }
</script>