<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carSendListPublic" title="信息列表" 
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
            <th data-options="field:'sendList',width:130,align:'center',formatter:formatSendList">派车单详细信息</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carSend" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	<!--  
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carSend_print()">打印</a>  
		    </div>  -->
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carSend_reload()">刷新</a>  
	</div> 
</div>  

<script type="text/javascript">
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
	function  formatSendList(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return "<a href=javascript:openSendList("+index+")>"+"派车单详细信息"+"</a>";
    	}
	};
	function  formatKM(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.endkm-row.firstkm+"&nbsp;公里";
    	}
	};

   
   
   
    function carSend_reload(){
    	$("#carSendList").datagrid("reload");
    }
</script>