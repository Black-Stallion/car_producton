<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYouList" title="油卡信息" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYou/list2',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYou2">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'younumber',align:'center',width:100">油卡号码</th>
        	<th data-options="field:'depart',align:'center',width:100,formatter:formatDepart">所在部门</th>
        	<th data-options="field:'stat',align:'center',width:100,formatter:youStat">油卡状态</th>
        	<th data-options="field:'money1',align:'center',width:100,formatter:youMoney1">余额(/元)</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYou2" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYou:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carYou_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carYou:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carYou_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carYou:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carYou_delete()">删除</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carYou:money' }">
			 <div style="float: left;">  
			       <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carYou_money()">油卡充值</a>  
		 	</div>  
		</c:if>
		<c:if test="${per=='carYou:money' }">
			 <div style="float: left;">  
			       <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carYou_allmoney()">批量充值</a>  
		 	</div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYou_reload()">刷新</a>  
	</div>  
<div id="search_carYou" style="float: right;">
        <input id="search_text_carYou" class="easyui-searchbox"  
            data-options="searcher:doSearch_carYou,prompt:'请输入...',menu:'#menu_carYou'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carYou" style="width:120px"> 
			<div data-options="name:'num'">油卡号</div>
		</div>     
    </div>
</div>  

<div id="carYouEditWindow" class="easyui-window" title="编辑油卡信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYou/edit'" style="width:550px;height:230px;padding:10px;">
</div>
<div id="carYouAddWindow" class="easyui-window" title="添加油卡信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYou/add'" style="width:550px;height:230px;padding:10px;">
</div>
<div id="carYouAllMoneyWindow" class="easyui-window" title="批量充值" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYou/allmoney'" style="width:650px;height:300px;padding:10px;">
</div>
<div id="carYouAddMoneyWindow" class="easyui-window" title="油卡充值" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carYou/money'" style="width:550px;height:230px;padding:10px;">
</div>
<script>
function doSearch_carYou(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carYouList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYou2", url:'carYou/list2', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'younumber', width : 100, align : 'center', title : '油卡号码'},
	             	{field : 'depart', width : 100, align : 'center', title : '所在部门',formatter:formatDepart},
	             	{field : 'stat', width : 100, align : 'center', title : '油卡状态',formatter:youStat},
	             	{field : 'money1', width : 100, align : 'center', title : '余额(/元)',formatter:youMoney1}
	        ] ],  
	    });
	}else{
		$("#carYouList").datagrid({
			 title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
		     toolbar:"toolbar_carYou2", url:'carYou/search_carYou_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'younumber', width : 100, align : 'center', title : '油卡号码'},
	             	{field : 'depart', width : 100, align : 'center', title : '所在部门',formatter:formatDepart},
	             	{field : 'stat', width : 100, align : 'center', title : '油卡状态',formatter:youStat},
	             	{field : 'money1', width : 100, align : 'center', title : '余额(/元)',formatter:youMoney1}
	        ] ],  
	    });
	}
}

function  formatDepart(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function youStat(value, row, index){ 
	if(row.beiyong1 == "2"){
		return '<span style="color:red;">停用</span>';}
	else{
		return "有效";
	}
	};
function youMoney1(value, row, index){
	
	if(row.beiyong2 <= 100){
		return '<span style="color:red;">'+row.beiyong2+'</span>';}
	else{
		return ""+row.beiyong2+"";
	}
};
    function getCarYouSelectionsIds(){
    	var carYouList = $("#carYouList");
    	var sels = carYouList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].youId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carYou_add(){
    	$.get("carYou/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carYouAddWindow").window("open");
       		}
       	});
    }
    function carYou_allmoney(){
    	$.get("carYou/add_judge1",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carYouAllMoneyWindow").window("open");
       		}
       	});
    }
   
    function getCarYouSelectionsnames(){
    	var carYouList = $("#carYouList");
    	var sels = carYouList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].beiyong1);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carYou_edit(){
    	$.get("carYou/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarYouSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	$("#carYouEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carYouList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            			//if(data.department.fatherdep=='0'){
            				data.fathername = data.department.departmentName;
            			//}else{
            				data.departmentName = data.department.departmentName;
            			//}
            			$("#carYouEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    function carYou_money(){
    	$.get("carYou/add_judge1",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarYouSelectionsIds();
       			var name = getCarYouSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能充值!');
            		return ;
            	}
            	if(ids.indexOf(',') >0){
            		$.messager.alert('提示','只能选择一条信息充值!');
            		return ;
            	}
            	if(name.indexOf('2')>=0){
            		$.messager.alert('提示','停用的油卡不能进行充值!');
            		return ;
            	}
            	$("#carYouAddMoneyWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carYouList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            			data.departmentName = data.department.departmentName;
            			$("#carYouEditMoneyForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    function carYou_delete(){
    	$.get("carYou/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarYouSelectionsIds();
      			var name = getCarYouSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	if(name.indexOf('2') >= 0){
            		$.messager.alert('提示','不能被删除已停用的油卡!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除该油卡信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carYou/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carYouList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carYou_reload(){
    	$("#carYouList").datagrid("reload");
    }
</script>