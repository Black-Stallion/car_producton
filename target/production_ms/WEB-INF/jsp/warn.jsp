<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carBS1List" title="需保养车辆列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carBS/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carBS1">
    <thead>
        <tr>
        	<th data-options="field:'carnum',align:'center'">需保养车辆</th>
        	<th data-options="field:'dd',align:'center'">已跑里程</th>
        	<th data-options="field:'notes',align:'center',width:100">保养项目</th>
        	<th data-options="field:'lm',align:'center'">需保养里程</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carBS1" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carBS1_reload()">刷新</a>  
	</div>  
	
   
</div>  

<script>
function doSearch_carBS1(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carBS1List").datagrid({
	        title:'车辆维保提醒列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carBS1", url:'carBS/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'baoyangId', type:'hidden'},
	             	{field : 'id', width : 100, align : 'center', title : '车辆ID'},
	             	{field : 'dd', width : 80, align : 'center', title : '车辆已跑里程'},
	             	{field : 'notes', width : 100, align : 'center', title : '保养项目'},
	             	{field : 'lm', width : 100, align : 'center', title : '应该保养里程'}
	             	
	        ] ],  
	    });
	}
}


    function carBS1_reload(){
    	$("#carBS1List").datagrid("reload");
    }
</script>