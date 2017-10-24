<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="driverRecordList" title="司机行驶里程表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'driverRecord/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_driverRecord">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        		
	      	<th data-options="field:'drivernum',align:'center',width:100">驾驶证编号</th>
        	<th data-options="field:'d2',align:'center',width:100,formatter:formatD2">驾驶员姓名</th>
            <th data-options="field:'formatdsp2',align:'center',width:100,formatter:formatDsp2">所在部门</th>
            <th data-options="field:'drivestart',align:'center',width:100">起</th>
            <th data-options="field:'driveend',align:'center',width:100">止</th>
            <th data-options="field:'total',align:'center',width:100">累计</th>
            <th data-options="field:'kaohetime',width:100,align:'center',formatter:TAOTAO.formatDateTime">考核时间</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_driverRecord" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='driverRecord:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="driverRecord_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='driverRecord:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="driverRecord_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='driverRecord:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="driverRecord_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="driverRecord_reload()">刷新</a>  
	</div> 
   
</div>  

<div id="driverRecordEditWindow" class="easyui-window" title="编辑行驶里程记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'driverRecord/edit'" style="width:450px;height:350px;padding:30px;">
</div>
<div id="driverRecordAddWindow" class="easyui-window" title="添加行驶里程记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'driverRecord/add'" style="width:450px;height:350px;padding:30px;">
</div>
<script>
function doSearch_driverRecord(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#driverRecordList").datagrid({
	        title:'司机行驶里程表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_driverRecord", url:'driverRecord/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field :'driveRecordId', type:'hidden'},
	             	{field : 'drivernum', width : 100, align:'center', title : '驾驶证编号'},
	             	{field : 'drivername', width : 100, align:'center', title : '驾驶员姓名'},
	             	{field : 'drivestart', width : 100, align : 'center', title : '起'},
	             	{field : 'driveend', width : 100, align : 'center', title : '止'}, 
	             	{field : 'total', width : 100, title : '累计', align:'center'}, 
	            	{field : 'kaohetime', width : 100, title : '考核时间', align:'center',formatter:TAOTAO.formatDateTime}
	         ]],  
	    });
	}
}

//格式化行驶里程记录记录信息
function  formatdriverRecordList(value, row, index){ 
		return "<a href=javascript:opendriverRecord("+index+")>"+"行驶里程记录记录详细信息"+"</a>";
};
function  formatDsp2(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function  formatD2(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drviername+"";
		//return '0';
	}
};
//根据index拿到该行值
function ondriverRecordClickRow(index) {
	var rows = $('#driverRecordList').datagrid('getRows');
	return rows[index];
}

//打开行驶里程记录记录信息对话框
function  opendriverRecord(index){ 
	var row = ondriverRecordClickRow(index);
	$("#driverRecordListWindow").dialog({
		onOpen :function(){
			$.get("driverRecord/get/"+row.driveRecordId,'',function(data){
	    		//回显数据
	    		data.kaohetime = TAOTAO.formatDateTime(data.kaohetime);
	    		data.drivername = data.carDriver.driverId;
	    		$("#driverRecordEditForm1").form("load",data);
	    	});
		},
		onBeforeClose: function (event, ui) {
			
			
		}
	}).dialog("open");
};

	//更新订单要求
	function updatedriverRecordNote(){
		$.get("driverRecord/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("driverRecord/update_note",$("#driverRecordNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#driverRecordNoteDialog").dialog("close");
    					$("#driverRecordList").datagrid("reload");
    					$.messager.alert("操作提示", "更新行驶里程记录信息成功！");
    				}else{
    					$.messager.alert("操作提示", "更新行驶里程记录信息失败！");
    				}
    			});
    		}
    	});
	}
	
    function getdriverRecordSelectionsIds(){
    	var driverRecordList = $("#driverRecordList");
    	var sels = driverRecordList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].driveRecordId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function driverRecord_add(){
    	$.get("driverRecord/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#driverRecordAddWindow").window("open");
       		}
       	});
    }
    
    function driverRecord_edit(){
    	$.get("driverRecord/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getdriverRecordSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个行驶里程记录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个行驶里程记录信息!');
               		return ;
               	}
               	$("#driverRecordEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#driverRecordList").datagrid("getSelections")[0];
               			data.kaohetime = TAOTAO.formatDateTime(data.kaohetime);
               			data.drivername = data.carDriver.driverId;
               			$("#driverRecordEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getdriverRecordSelectionsNames(){
    	var driverRecordList = $("#driverRecordList");
    	var sels = driverRecordList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].drivername);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function driverRecord_delete(){
    	$.get("driverRecord/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getdriverRecordSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中行驶里程记录记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该条行驶里程记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("driverRecord/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除行驶里程记录成功!',undefined,function(){
                  					$("#driverRecordList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closedriverRecordEditForm(){
					$("#driverRecordListWindow").window('close');
					$("#driverRecordEditForm").datagrid("reload");
	}
    
    function driverRecord_reload(){
    	$("#driverRecordList").datagrid("reload");
    }
    
 
</script>