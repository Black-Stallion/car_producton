<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carFoldList1" title="文件信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carFold/list1',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carFold1">
    <thead>
        <tr>
        	<th data-options="field:'user',align:'center',width:200">发布人</th>
        	<th data-options="field:'deo',align:'center',width:270,formatter:formatdep">发布部门</th>
        	<th data-options="field:'bei',align:'center',width:200">文件来源</th>
            <th data-options="field:'datetime',align:'center',width:260,formatter:TAOTAO.formatDate">发布日期</th>
            <th data-options="field:'fold',align:'center',width:600,formatter:formatFile">文件名称</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carFold1" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carFold_reload1()">刷新</a>  
	</div>  
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
    
    function carFold_reload1(){
    	$("#carFoldList1").datagrid("reload");
    }
</script>