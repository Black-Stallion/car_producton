<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carCompanyList" title="定点保养单位表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carCompany/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carCompany">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'name',align:'center',width:170">保养单位</th>
        	<th data-options="field:'dep1',align:'center',width:130,formatter:formatDepartment1">使用部门</th>
        	<th data-options="field:'address',align:'center',width:200">地址</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carCompany" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carCompany:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carCompany_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carCompany:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carCompany_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carCompany:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carCompany_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carCompany_reload()">刷新</a>  
	</div>  

</div>  
<div id="carCompanyAddWindow" class="easyui-window" title="添加维护单位" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carCompany/add'" style="width:450px;height:270px;padding:30px;">
</div>
<div id="carCompanyEditWindow" class="easyui-window" title="修改维护单位" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carCompany/edit'" style="width:450px;height:270px;padding:30px;">
</div>
<script>
function doSearch_carCompany(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carCompanyList").datagrid({
	        title:'车辆调入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carCompany", url:'carCompany/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum1', width : 100, align : 'center', title : '调入车辆',formatter:formatCarNum},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调入人'},
	             	{field : 'dep1', width : 100, align : 'center', title : '调入部门',formatter:formatDepartment1},
	             	{field : 'dep2', width : 100, align : 'center', title : '调出部门',formatter:formatDepartment2},
	             	{field : 'removetime', width : 100, align:'center', title : '调入日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 80, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 150, title : '类型', align:'center'}
	        ] ],  
	    });
	}
}
function  formatDepartment1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
    function getCarCompanySelectionsIds(){
    	var carCompanyList = $("#carCompanyList");
    	var sels = carCompanyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].companyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carCompany_add(){
    	$.get("carCompany/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carCompanyAddWindow").window("open");
       		}
       	});
    }

    function carCompany_delete(){
    	$.get("carCompany/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarCompanySelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除 该条信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carCompany/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carCompanyList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    function carCompany_edit(){
    	$.get("carCompany/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarCompanySelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一条信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一条信息!');
               		return ;
               	}
               	$("#carCompanyEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carCompanyList").datagrid("getSelections")[0];
               			//if(data.department.fatherdep=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else{
            				data.departmentName = data.department.departmentName;
            			//}
        				data.departmentId = data.department.departmentId;
               			$("#carCompanyEditForm15").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function carCompany_reload(){
    	$("#carCompanyList").datagrid("reload");
    }
</script>