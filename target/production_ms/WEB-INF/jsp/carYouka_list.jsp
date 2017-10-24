<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYoukaList" title="车辆用油信息" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYouka/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYouka">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'number',align:'center',width:100,formatter:formatYouId">油卡号码</th>
        	<th data-options="field:'carnumber',align:'center',width:100,formatter:formatCarNumber">用油车辆</th>
        	<th data-options="field:'depart1',align:'center',width:100,formatter:formatDepart1">所在部门</th>
            <th data-options="field:'yongyou',align:'center',width:100">本次用油(/L)</th>
            <th data-options="field:'totlyou',align:'center',width:100">本次用油金额(/元)</th>
            <th data-options="field:'beiyong1',align:'center',width:100,formatter:TAOTAO.formatDate">填写日期</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYouka" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYouka:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carYouka_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carYouka:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carYouka_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carYouka:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carYouka_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYouka_reload()">刷新</a>  
	</div>  
	<div id="search_carYouka" style="float: right;">
        <input id="search_text_carYouka" class="easyui-searchbox"  
            data-options="searcher:doSearch_carYouka,prompt:'请输入...',menu:'#menu_carYouka'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carYouka" style="width:120px"> 
			<div data-options="name:'carnum'">车牌号</div>
			<div data-options="name:'younum'">油卡号</div>
		</div>     
    </div>
</div>  

<div id="carYoukaEditWindow" class="easyui-window" title="编辑用油信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYouka/edit'" style="width:550px;height:300px;padding:20px;">
</div>
<div id="carYoukaAddWindow" class="easyui-window" title="添加用油信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYouka/add'" style="width:550px;height:300px;padding:20px;">
</div>
<script>
function doSearch_carYouka(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carYoukaList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYouka", url:'carYouka/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'number', width : 100, align : 'center', title : '油卡号码',formatter:formatYouId},
	             	{field : 'carnumber', width :100, align : 'center', title : '用油车辆',formatter:formatCarNumber},
	             	{field : 'depart1', width : 100, align : 'center', title : '所在部门',formatter:formatDepart1},
	             	{field : 'yongyou', width : 100, title : '本次用油(/L)', align:'center'},
	             	{field : 'totlyou', width : 100, title : '本次用油金额(/元)', align:'center'},
	             	{field : 'beiyong1', width : 100, title : '填写日期', align:'center',formatter:TAOTAO.formatDate}
	        ] ],  
	    });
	}else{
		$("#carYoukaList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYouka",url:'carYouka/search_carYouka_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'number', width : 100, align : 'center', title : '油卡号码',formatter:formatYouId},
	             	{field : 'carnumber', width :100, align : 'center', title : '用油车辆',formatter:formatCarNumber},
	             	{field : 'depart1', width : 100, align : 'center', title : '所在部门',formatter:formatDepart1},
	             	{field : 'yongyou', width : 100, title : '本次用油(/L)', align:'center'},
	             	{field : 'totlyou', width : 100, title : '本次用油金额(/元)', align:'center'},
	             	{field : 'beiyong1', width : 100, title : '填写日期', align:'center',formatter:TAOTAO.formatDate}
	        ] ],  
	    });
	}
}
function  formatYouId(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carYou.younumber+"";
	}
};
function  formatCarNumber(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepart1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
		//return '0';
	}
};
    function getCarYoukaSelectionsIds(){
    	var carYoukaList = $("#carYoukaList");
    	var sels = carYoukaList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].youkaId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carYouka_add(){
    	$.get("carYouka/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carYoukaAddWindow").window("open");
       		}
       	});
    }
    function carYouka_edit(){
    	$.get("carYouka/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarYoukaSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carYoukaEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carYoukaList").datagrid("getSelections")[0];
            			data.youId = data.carYou.youId; 
            			data.carnumber = data.carRegister.carnumber;
        				data.usenature = data.carRegister.usenature;
        				data.carId = data.carRegister.carId;
        				data.beiyong1 = TAOTAO.formatDate(data.beiyong1);
            			$("#carYoukaEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carYouka_delete(){
    	$.get("carYouka/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarYoukaSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除该信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carYouka/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carYoukaList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carYouka_reload(){
    	$("#carYoukaList").datagrid("reload");
    }
</script>