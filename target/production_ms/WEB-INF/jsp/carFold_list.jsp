<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carFoldList" title="文件列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carFold/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carFold">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'user',align:'center',width:80">发布人</th>
        	<th data-options="field:'deo',align:'center',width:100,formatter:formatdep">发布部门</th>
        	<th data-options="field:'bei',align:'center',width:80">文件来源</th>
            <th data-options="field:'datetime',align:'center',width:120,formatter:TAOTAO.formatDate">发布日期</th>
            <th data-options="field:'fold',align:'center',width:400,formatter:formatFile">文件名称</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carFold" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carFold:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carFold_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carFold:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carFold_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carFold:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carFold_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carFold_reload()">刷新</a>  
	</div>  
	<div id="search_carFold" style="float: right;">
        <input id="search_text_carFold" class="easyui-searchbox"  
            data-options="searcher:doSearch_carFold,prompt:'请输入...',menu:'#menu_carFold'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carFold" style="width:120px"> 
			<div data-options="name:'f1'">发布人</div>
			<div data-options="name:'f2'">文件名称</div> 
		</div>     
    </div>
</div>  

<div id="carFoldEditWindow" class="easyui-window" title="编辑文件信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carFold/edit'" style="width:800px;height:400px;padding:10px;">
</div>
<div id="carFoldAddWindow" class="easyui-window" title="添加文件信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carFold/add'" style="width:800px;height:400px;padding:10px;">
</div>

<script>
function doSearch_carFold(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carFoldList").datagrid({
	        title:'文件列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carFold", url:'carFold/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'user', width : 80, align : 'center', title : '发布人'},
	             	{field : 'deo', width : 100, align : 'center', title : '发布部门',formatter:formatdep},
	             	{field : 'bei', width : 80, align : 'center', title : '文件来源'},
	             	{field : 'datetime', width : 120, align:'center', title : '发布时间',formatter:TAOTAO.formatDate},
	             	{field : 'fold', width : 400, title : '文件名称', align:'center',formatter:formatFile}
	        ] ],  
	    });
	}else{
		$("#carFoldList").datagrid({
	        title:'文件列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carFold", url:'carFold/search_carFold_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'user', width : 80, align : 'center', title : '发布人'},
	             	{field : 'deo', width : 100, align : 'center', title : '发布部门',formatter:formatdep},
	             	{field : 'bei', width : 80, align : 'center', title : '文件来源'},
	             	{field : 'datetime', width : 120, align:'center', title : '发布时间',formatter:TAOTAO.formatDate},
	             	{field : 'fold', width : 400, title : '文件名称', align:'center',formatter:formatFile}
	        ] ],  
	    });
	}
}
function  formatdep(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
	//根据index拿到该行值
	function onCarFoldClickRow(index) {
		var rows = $('#carFoldList').datagrid('getRows');
		return rows[index];
	}
	
    function getCarFoldSelectionsIds(){
    	var carFoldList = $("#carFoldList");
    	var sels = carFoldList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].foldId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carFold_add(){
    	$.get("carFold/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carFoldAddWindow").window("open");
       		}
       	});
    }
    function carFold_edit(){
    	$.get("carFold/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarFoldSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carFoldEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carFoldList").datagrid("getSelections")[0];
            			data.bei2 = data.department.departmentId;
            			data.departmentName = data.department.departmentName;
            			data.datetime = TAOTAO.formatDateTime(data.datetime);
            			$("#foldEditForm").form("load", data);
            			//加载文件上传插件
               			initFoldEditFileUpload();
               			//加载上传过的文件
               			initUploadedFile1();
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carFold_delete(){
    	$.get("carFold/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarFoldSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除该条文件信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carFold/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carFoldList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carFold_reload(){
    	$("#carFoldList").datagrid("reload");
    }
</script>