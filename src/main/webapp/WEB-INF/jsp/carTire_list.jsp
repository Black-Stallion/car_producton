<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carTireList" title="轮胎档案表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carTire/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carTire">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field : 'changpai', width : 100, align:'center'">厂牌</th>
           	<th data-options="field : 'guige', width : 80, align:'center'">规格</th>
           	<th data-options="field : 'taihao', width : 80, align : 'center'">胎号</th>
           	<th data-options="field : 'dep66', width : 80, align : 'center',formatter:formatDep66">部门</th>
           	<th data-options="field : 'startdate', width : 80, align : 'center',formatter:TAOTAO.formatDate">装车日期</th>
           	<th data-options="field : 'enddate', width : 80, align:'center',formatter:TAOTAO.formatDate">换下日期</th>
          	<th data-options="field : 'addkm', width : 80,  align:'center'">累计公里</th>
           	<th data-options="field : 'why', width : 130,align:'center'">更换原因</th>
           	<th data-options="field : 'checkrecord', width : 130,align:'center'">检查记录</th>
           	<th data-options="field:'carTireEdit',align:'center',width:50,formatter:formatCarTireEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carTire" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carTire:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carTire_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carTire:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carTire_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carTire:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carTire_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carTire_reload()">刷新</a>  
	</div> 
</div>  

<div id="carTireEditWindow" class="easyui-window" title="编辑轮胎信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carTire/edit'" style="width:520px;height:470px;padding:40px;">
</div>
<div id="carTireAddWindow" class="easyui-window" title="增添轮胎信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carTire/add'" style="width:520px;height:470px;padding:40px;">
</div>

<script>
function doSearch_carTire(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carTireList").datagrid({
	        title:'轮胎档案表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carTire", url:'carTire/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'tireId', type:'hidden'},
	             	{field : 'changpai', width : 100, title : '厂牌', align:'center'}, 
	             	{field : 'guige', width : 80, align:'center', title : '规格'},
	             	{field : 'taihao', width : 80, align : 'center', title : '胎号'},
	             	{field : 'startdate', width : 100, align : 'center', title : '装车日期',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'enddate', width : 100, title : '换下日期', align:'center',formatter:TAOTAO.formatDateTime}, 
	            	{field : 'addkm', width : 100, title : '累计公里', align:'center'}, 
	             	{field : 'why', width : 13, title : '更换原因 ', align:'center'}, 
	             	{field : 'checkrecord', width : 130, title : '检查记录', align:'center'}
	        ] ],  
	    });
	}
}
function  formatCarTireEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carTire_edit()'><span style='color:blue'>编辑</span></a>";
};
function  formatDep66(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
//根据index拿到该行值
function onCarTireClickRow(index) {
	var rows = $('#carTireList').datagrid('getRows');
	return rows[index];
}
	
    function getCarTireSelectionsIds(){
    	var carTireList = $("#carTireList");
    	var sels = carTireList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].tireId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function carTire_add(){
    	$.get("carTire/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carTireAddWindow").window("open");
       		}
       	});
    }
    
    function carTire_edit(){
    	$.get("carTire/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarTireSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一条信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一条信息!');
               		return ;
               	}
               	$("#carTireEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carTireList").datagrid("getSelections")[0];
               			data.startdate = TAOTAO.formatDate(data.startdate);
               			data.enddate = TAOTAO.formatDate(data.enddate);
               			data.checkrecord1 = data.department.departmentId;
               		//	if(data.department.fatherdep=='0'){
            		//		data.fathername = data.department.departmentName;
            		//	}else{
            				data.departmentName = data.department.departmentName;
            		//	}
               			$("#carTireEditForm15").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    
    function carTire_delete(){
    	$.get("carTire/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarTireSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中车型!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该轮胎记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carTire/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除车型成功!',undefined,function(){
                  					$("#carTireList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closeCarTireEditForm(){
					$("#carTireListWindow").window('close');
					$("#carTireEditForm41").datagrid("reload");
	}
    
    function carTire_reload(){
    	$("#carTireList").datagrid("reload");
    }
</script>