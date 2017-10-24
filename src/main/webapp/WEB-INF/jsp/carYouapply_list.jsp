<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYouapplyList" title="申请列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYouapply/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYouapply">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'applyname',align:'center',width:100">申请人</th>
        	<th data-options="field:'approvename',align:'center',width:100">审批人</th>
        	<th data-options="field:'dep65',align:'center',width:100,formatter:formatDep65">所在单位</th>
            <th data-options="field:'dtime',align:'center',width:100,formatter:TAOTAO.formatDate">申请日期</th>
            <th data-options="field:'folds',align:'center',width:300,formatter:formatFile">文件名称</th>
            <th data-options="field:'sn',align:'center',width:220,formatter:formatSN">申请结果</th>
            <th data-options="field:'carYouApplyEdit',align:'center',width:50,formatter:formatCarYouApplyEdit">编辑</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYouapply" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYouapply:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carYouapply_add()">新增</a>  
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carYouapply:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carYouapply_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carYouapply:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carYouapply_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYouapply_reload()">刷新</a>  
	</div>  
	<div id="search_carYouapply" style="float: right;">
        <input id="search_text_carYouapply" class="easyui-searchbox"  
            data-options="searcher:doSearch_carYouapply,prompt:'请输入...',menu:'#menu_carYouapply'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carYouapply" style="width:120px"> 
			<div data-options="name:'y1'">申请人</div>
			<div data-options="name:'y2'">文件名称</div> 
		</div>     
    </div>
</div>  

<div id="carYouapplyEditWindow" class="easyui-window" title="编辑申请信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYouapply/edit'" style="width:600px;height:400px;padding:10px;">
</div>
<div id="carYouapplyAddWindow" class="easyui-window" title="添加申请信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYouapply/add'" style="width:600px;height:400px;padding:10px;">
</div>

<script>
function doSearch_carYouapply(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carYouapplyList").datagrid({
	        title:'申请列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYouapply", url:'carYouapply/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'applyname', width : 100, align : 'center', title : '申请人'},
	             	{field : 'approvename', width : 100, align : 'center', title : '审批人'},
	             	{field : 'dep65', width : 100, align : 'center', title : '所在单位',formatter:formatDep65},
	             	{field : 'dtime', width : 100, align:'center', title : '申请时间',formatter:TAOTAO.formatDate},
	             	{field : 'folds', width : 300, title : '文件名称', align:'center',formatter:formatFile},
	             	{field : 'sn', width : 200, title : '申请结果', align:'center',formatter:formatSN},
	             	{field : 'carYouApplyEdit', width : 50, align:'center', title : '编辑',formatter:formatCarYouApplyEdit}
	        ] ],  
	    });
	}else{
		$("#carYouapplyList").datagrid({
	        title:'申请列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYouapply", url:'carYouapply/search_carYouapply_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
             	{field : 'applyname', width : 100, align : 'center', title : '申请人'},
             	{field : 'approvename', width : 100, align : 'center', title : '审批人'},
             	{field : 'dep65', width : 100, align : 'center', title : '所在单位',formatter:formatDep65},
             	{field : 'dtime', width : 100, align:'center', title : '申请时间',formatter:TAOTAO.formatDate},
             	{field : 'folds', width : 300, title : '文件名称', align:'center',formatter:formatFile},
             	{field : 'sn', width : 200, title : '申请结果', align:'center',formatter:formatSN},
             	{field : 'carYouApplyEdit', width : 50, align:'center', title : '编辑',formatter:formatCarYouApplyEdit}
	        ] ],  
	    });
	}
}

function  formatCarYouApplyEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carYouapply_edit()'><span style='color:blue'>编辑</span></a>";
};

function  formatDep65(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function  formatSN(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		if(row.stat=="未通过" ){
			return '<span style="color:red;">'+row.stat+'(原因：'+row.bei+')'+'</span>';
		}else if(row.stat=="未审批"){
			return '<span style="color:red;">'+row.stat+'</span>';
		}else{
			return '<span style="color:green;">'+row.stat+'</span>';
		}
	}
};
	//根据index拿到该行值
	function onCarYouapplyClickRow(index) {
		var rows = $('#carYouapplyList').datagrid('getRows');
		return rows[index];
	}
	
    function getCarYouapplySelectionsIds(){
    	var carYouapplyList = $("#carYouapplyList");
    	var sels = carYouapplyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].yapplyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carYouapply_add(){
    	$.get("carYouapply/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carYouapplyAddWindow").window("open");
       		}
       	});
    }
    function getSelectionsName(){
    	var carApplyList = $("#carYouapplyList");
    	var sels = carApplyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].stat);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carYouapply_edit(){
    	$.get("carYouapply/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var name = getSelectionsName();
       			var ids = getCarYouapplySelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}if(name==("通过")){
               		$.messager.alert('提示','该条信息已通过审核，不能被编辑!');
               		return;
               	}
            	
            	$("#carYouapplyEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carYouapplyList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            		//	if(data.department.fatherdep=='0'){
            				data.fathername = data.department.departmentName;
            		//	}else{
            				data.departmentName = data.department.departmentName;
            		//	}
            			data.dtime = TAOTAO.formatDate(data.dtime);
            			data.stat = '未审批';
            			$("#youEditForm").form("load", data);
            			//加载文件上传插件
               			initYouEditFileUpload();
               			//加载上传过的文件
               			initUploadedFile2();
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carYouapply_delete(){
    	$.get("carYouapply/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var name = getSelectionsName();
      			var ids = getCarYouapplySelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	if(name.indexOf('通过') >= 0){
            		$.messager.alert('提示','已通过的申请不能被删除!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除该条信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carYouapply/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carYouapplyList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carYouapply_reload(){
    	$("#carYouapplyList").datagrid("reload");
    }
</script>