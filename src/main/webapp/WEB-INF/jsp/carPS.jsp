<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carSendList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carSend/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carSend">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'sendnums1',width:100,align:'center',formatter:formatBian">审批编号</th>
        	<th data-options="field:'chepai',align:'center',width:100,formatter:formatChepai">车牌号</th>
            <th data-options="field:'usercarpeople',align:'center',width:100">用车人</th>
            <th data-options="field:'dep',align:'center',width:100,formatter:formatDep">用车单位</th>
            <th data-options="field:'sdate',align:'center',width:100,formatter:TAOTAO.formatDate">日期</th>
            <th data-options="field:'formatKM',align:'center',width:100,formatter:formatKM">行走公里</th>
            <th data-options="field:'drivername',align:'center',width:100,formatter:formatDriver">驾驶员</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carSend" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	<div class="datagrid-btn-separator"></div> 
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carSend_reload()">刷新</a>  
	</div> 
	
</div>  


<script type="text/javascript">
function doSearch_carSend(value,name){ //用户输入用户名,点击搜素,触发此函数  
	
	if(value == null || value == ''){
		$("#carSendList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSend", url:'carSend/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'sendnums1', width : 100, title : '申批编号', align:'center',formatter:formatBian},
	             	{field : 'chepai', width : 100, align:'center',title : '车牌号',formatter:formatChepai},
	             	{field : 'usercarpeople', width : 100, align : 'center', title : '用车人'},
	             	{field : 'dep', width : 100, align : 'center', title : '用车单位',formatter:formatDep}, 
	             	{field : 'sdate', width : 100, title : '日期', align:'center',formatter:TAOTAO.formatDate}, 
	             	{field : 'formatKM',align:'center',width:100,title : '行走公里',formatter:formatKM}, 
	            	{field : 'drivername', width : 100, title : '驾驶员', align:'center',formatter:formatDriver}, 
	        ] ],  
	    });
	}else{
		$("#carSendList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSend", url:'carSend/search_carSend_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
             	{field : 'sendnums1', width : 100, title : '申批编号', align:'center',formatter:formatBian},
             	{field : 'chepai', width : 100, align:'center',title : '车牌号',formatter:formatChepai},
             	{field : 'usercarpeople', width : 100, align : 'center', title : '用车人'},
             	{field : 'dep', width : 100, align : 'center', title : '用车单位',formatter:formatDep}, 
             	{field : 'sdate', width : 100, title : '日期', align:'center',formatter:TAOTAO.formatDate}, 
             	{field : 'formatKM',align:'center',width:100,title : '行走公里',formatter:formatKM}, 
            	{field : 'drivername', width : 100, title : '驾驶员', align:'center',formatter:formatDriver}, 
	        ] ],  
	    });
	}

}

    function  formatBian(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		debugger;
    		return ""+row.carApply.bianhao+"";
    	}
	};
	 function  formatChepai(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		debugger;
	    		return ""+row.carRegister.carnumber+"";
	    	}
		};
		function  formatDep(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		debugger;
	    		return ""+row.department.departmentName+"";
	    	}
		};
		function  formatDriver(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		debugger;
	    		return ""+row.carDriver.drviername+"";
	    	}
		};
	function  formatKM(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.endkm-row.firstkm+"&nbsp;公里";
    	}
	};
	  function getCarSendSelectionsIds(){
	    	var carSendList = $("#carSendList");
	    	var sels = carSendList.datagrid("getSelections");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].sendId);
	    	}
	    	ids = ids.join(","); 
	    	
	    	return ids;
	    }
	    
	//根据index拿到该行值
	function onCarSendClickRow(index) {
		var rows = $('#carSendList').datagrid('getRows');
		return rows[index];
	}
	
	
	

  
    
 


    function carSend_reload(){
    	$("#carSendList").datagrid("reload");
    }
</script>