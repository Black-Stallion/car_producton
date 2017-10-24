<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYouMoneyList" title="油卡充值记录" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYou/listmoney',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYoumoney">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnum',align:'center',width:100">油卡号码</th>
        	<th data-options="field:'depatmentname',align:'center',width:100">所在部门</th>
        	<th data-options="field:'datatime',align:'center',width:100,formatter:TAOTAO.formatDate">充值日期</th>
        	<th data-options="field:'money',align:'center',width:100">充值金额(/元)</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYoumoney" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYouMoney_reload()">刷新</a>  
	</div>  

</div>  


<script>

    function carYouMoney_reload(){
    	$("#carYouMoneyList").datagrid("reload");
    }
</script>