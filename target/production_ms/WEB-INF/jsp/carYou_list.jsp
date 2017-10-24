<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYouList2" title="油卡信息" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYou/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYou">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'younumber',align:'center',width:100">油卡号码</th>
        	<th data-options="field:'depart',align:'center',width:100,formatter:formatDepart">所在部门</th>
            <th data-options="field:'you',align:'center',width:100,formatter:formatYou">累计用油(/L)</th>
            <th data-options="field:'money',align:'center',width:100,formatter:formatMoney">累计金额(/元)</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYou" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	<div class="datagrid-btn-separator"></div>  
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYou_reload()">刷新</a>  
	</div>  
<div id="search_carYou2" style="float: right;">
        <input id="search_text_carYou2" class="easyui-searchbox"  
            data-options="searcher:doSearch_carYou2,prompt:'请输入...',menu:'#menu_carYou2'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carYou2" style="width:120px"> 
			<div data-options="name:'num'">油卡号</div>
		</div>     
    </div>
</div>  
<script>
function doSearch_carYou2(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carYouList2").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYou", url:'carYou/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'younumber', width : 100, align : 'center', title : '油卡号码'},
	             	{field : 'depart', width : 100, align : 'center', title : '所在部门',formatter:formatDepart},
	             	{field : 'you', width : 100, title : '累计用油(/L)', align:'center',formatter:formatYou},
	             	{field : 'money', width : 100, title : '累计金额(/元)', align:'center',formatter:formatMoney}
	        ] ],  
	    });
	}else{
		$("#carYouList2").datagrid({
			 title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
		     toolbar:"toolbar_carYou", url:'carYou/search_carYou_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'younumber', width : 100, align : 'center', title : '油卡号码'},
	             	{field : 'depart', width : 100, align : 'center', title : '所在部门',formatter:formatDepart},
	             	{field : 'you', width : 100, title : '累计用油(/L)', align:'center',formatter:formatYou},
	             	{field : 'money', width : 100, title : '累计金额(/元)', align:'center',formatter:formatMoney}
	        ] ],  
	    });
	}
}
function  formatYou(value, row, index){ 
	if(value ==null && value == ''){
		return '0';}
	else{
		return ""+row.you+"";
	}
};
function  formatMoney(value, row, index){ 
	if(value ==null && value == ''){
		return '0';}
	else{
		return ""+row.money+"";
	}
};
function  formatDepart(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function carYou_reload(){
	$("#carYouList2").datagrid("reload");
}

</script>