<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carBigList" title="所换大件记录表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carBig/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carBig">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'num66',align:'center',width:80,formatter:formatCarNum66">更换大件车辆</th>
        	<th data-options="field:'formatDepartment',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	<th data-options="field:'changedate',width:100,align:'center',formatter:TAOTAO.formatDate">更换日期</th>
        	<th data-options="field:'drivername',align:'center',width:100,formatter:formatCarDriver">主车司机</th>
            <th data-options="field:'changbig',align:'center',width:150">所换大件</th>
            <th data-options="field:'why',align:'center',width:220">原因</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carBig" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carBig:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carBig_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carBig:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carBig_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carBig:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carBig_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carBig_reload()">刷新</a>  
	</div> 
	<div id="search_carBig" style="float: right;">
        <input id="search_text_carBig" class="easyui-searchbox"  
            data-options="searcher:doSearch_carBig,prompt:'请输入...',menu:'#menu_carBig'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carBig" style="width:120px"> 
			<div data-options="name:'carid'">车牌号</div>
			<div data-options="name:'depname'">部门名称</div> 
		</div>     
    </div>
</div>  

<div id="carBigEditWindow" class="easyui-window" title="编辑大件记录" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carBig/edit'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="carBigAddWindow" class="easyui-window" title="添加大件记录" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carBig/add'" style="width:850px;height:600px;padding:10px;">
</div>

<script>
function doSearch_carBig(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carBigList").datagrid({
	        title:'所换大件记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carBig", url:'carBig/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	            	{field :'num66',align:'center',width:80,formatter:formatCarNum66,title:'更换大件车辆'},
	            	{field : 'formatDepartment', width : 100, align:'center', title : '所在部门',formatter:formatDepartment},
	            	{field : 'changedate', width : 100, title : '更换日期', align:'center',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'drivername', width : 100, align:'center', title : '主车司机',formatter:formatCarDriver},
	             	{field : 'changbig', width : 150, align : 'center', title : '所换大件'},
	             	{field : 'why', width : 220, align : 'center', title : '原因'}
	        ] ],  
	    });
	}else{
		$("#carBigList").datagrid({
	        title:'所换大件记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carBig", url:'carBig/search_carBig_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'num66',align:'center',width:80,formatter:formatCarNum66,title:'更换大件车辆'},
	             	{field : 'formatDepartment', width : 100, align:'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'changedate', width : 100, title : '更换日期', align:'center',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'drivername', width : 100, align:'center', title : '主车司机',formatter:formatCarDriver},
	             	{field : 'changbig', width : 150, align : 'center', title : '所换大件'},
	             	{field : 'why', width : 220, align : 'center', title : '原因'}
	        ] ],  
	    });
	}
}
function  formatCarNum66(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment(value, row, index){ 
	if(value ==null && value ==''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
		//return '无';
	}
};
function  formatCarDriver(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drviername+"";
	}
};
//根据index拿到该行值
function onCarBigClickRow(index) {
	var rows = $('#carBigList').datagrid('getRows');
	return rows[index];
}


	//更新订单要求
	function updateCarBigNote(){
		$.get("carBig/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("carBig/update_note",$("#carBigNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carBigNoteDialog").dialog("close");
    					$("#carBigList").datagrid("reload");
    					$.messager.alert("操作提示", "更新车型信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新车型信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getCarBigSelectionsIds(){
    	var carBigList = $("#carBigList");
    	var sels = carBigList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].bigId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function carBig_add(){
    	$.get("carBig/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carBigAddWindow").window("open");
       		}
       	});
    }
    
    function carBig_edit(){
    	$.get("carBig/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarBigSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个车型信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个车型信息!');
               		return ;
               	}
               	$("#carBigEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carBigList").datagrid("getSelections")[0];
               			data.driverId = data.carDriver.driverId; 
               			data.changedate = TAOTAO.formatDateTime(data.changedate);
               			data.carnumber = data.carRegister.carnumber;
        				data.carId = data.carRegister.carId;
        				data.nature = data.carRegister.usenature;
        				bigEditor.html(data.why);
        				big1Editor.html(data.changbig);
               			$("#carBigEditForm15").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    
    function carBig_delete(){
    	$.get("carBig/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarBigSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中车型!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除记录吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carBig/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除记录成功!',undefined,function(){
                  					$("#carBigList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closeCarBigEditForm(){
					$("#carBigListWindow").window('close');
					$("#carBigEditForm41").datagrid("reload");
	}
    
    function carBig_reload(){
    	$("#carBigList").datagrid("reload");
    }
</script>