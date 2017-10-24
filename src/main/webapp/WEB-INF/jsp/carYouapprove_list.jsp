<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYouapproveList" title="申请列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYouapprove/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYouapprove">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'applyname',align:'center',width:100">申请人</th>
        	<th data-options="field:'approvename',align:'center',width:100">审批人</th>
        	<th data-options="field:'dep66',align:'center',width:100,formatter:formatDep66">所在单位</th>
            <th data-options="field:'dtime',align:'center',width:100,formatter:TAOTAO.formatDate">申请日期</th>
            <th data-options="field:'folds',align:'center',width:300,formatter:formatFile">文件名称</th>
            <th data-options="field:'stat',align:'center',width:220">申请状态</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYouapprove" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		
		<c:if test="${per=='carYouapprove:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carYouapprove_edit()">审批</a>  
		    </div>  
		</c:if>
		
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYouapprove_reload()">刷新</a>  
	</div>  
	<div id="search_carYouapprove" style="float: right;">
        <input id="search_text_carYouapprove" class="easyui-searchbox"  
            data-options="searcher:doSearch_carYouapprove,prompt:'请输入...',menu:'#menu_carYouapprove'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carYouapprove" style="width:120px"> 
			<div data-options="name:'p1'">申请人</div>
			<div data-options="name:'p2'">文件名称</div> 
		</div>     
    </div>
</div>  

<div id="carYouapproveEditWindow" class="easyui-window" title="审批申请信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYouapprove/edit'" style="width:550px;height:370px;padding:10px;">
</div>


<script>
function doSearch_carYouapprove(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carYouapproveList").datagrid({
	        title:'申请列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYouapprove", url:'carYouapprove/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'applyname', width : 100, align : 'center', title : '申请人'},
	             	{field : 'approvename', width : 100, align : 'center', title : '审批人'},
	             	{field : 'dep66', width : 100, align : 'center', title : '所在单位',formatter:formatDep66},
	             	{field : 'dtime', width : 100, align:'center', title : '申请时间',formatter:TAOTAO.formatDate},
	             	{field : 'folds', width : 300, title : '文件名称', align:'center',formatter:formatFile},
	             	{field : 'stat', width : 200, title : '申请状态', align:'center'}
	        ] ],  
	    });
	}else{
		$("#carYouapproveList").datagrid({
	        title:'申请列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYouapprove", url:'carYouapprove/search_carYouapprove_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
             	{field : 'applyname', width : 100, align : 'center', title : '申请人'},
             	{field : 'approvename', width : 100, align : 'center', title : '审批人'},
             	{field : 'dep66', width : 100, align : 'center', title : '所在单位',formatter:formatDep66},
             	{field : 'dtime', width : 100, align:'center', title : '申请时间',formatter:TAOTAO.formatDate},
             	{field : 'folds', width : 300, title : '文件名称', align:'center',formatter:formatFile},
             	{field : 'stat', width : 200, title : '申请状态', align:'center'}
	        ] ],  
	    });
	}
}
function  formatDep66(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};

	//根据index拿到该行值
	function onCarYouapproveClickRow(index) {
		var rows = $('#carYouapproveList').datagrid('getRows');
		return rows[index];
	}
	
    function getCarYouapproveSelectionsIds(){
    	var carYouapproveList = $("#carYouapproveList");
    	var sels = carYouapproveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].yapplyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carYouapprove_add(){
    	$.get("carYouapprove/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carYouapproveAddWindow").window("open");
       		}
       	});
    }
    function carYouapprove_edit(){
    	$.get("carYouapprove/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarYouapproveSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能审批!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息审批!');
            		return ;
            	}
            	
            	$("#carYouapproveEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carYouapproveList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            			data.departmentName = data.department.departmentName;
            			data.dtime = TAOTAO.formatDate(data.dtime);
            			data.stat = '通过';
            			$("#youaEditForm").form("load", data);
            		
               			//加载上传过的文件
               			initUploadedFile3();
            		}
            	}).window("open");
       		}
       	});
    }
    
    
    
    function carYouapprove_reload(){
    	$("#carYouapproveList").datagrid("reload");
    }
</script>