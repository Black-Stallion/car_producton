<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carKeepApproveList" title="维护审批列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carKeepApprove/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carKeepApprove">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnum',align:'center',width:80">保养车辆</th>
        	<th data-options="field:'applyname',align:'center',width:70">申请人</th>
        	<th data-options="field:'approve',align:'center',width:70">审批人</th>
        	<th data-options="field:'intervalkm',align:'center',width:80">当前里程(/公里)</th>
        	<th data-options="field:'dep',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	<th data-options="field:'startdate',align:'center',width:80,formatter:TAOTAO.formatDate">开始日期</th>
        	<th data-options="field:'enddate',align:'center',width:80,formatter:TAOTAO.formatDate">截止日期</th>
            <th data-options="field:'repairtype',align:'center',width:200">维护级别或修理项目</th>
            <th data-options="field:'suppliername',align:'center',width:80">厂家名称</th>
           <th data-options="field:'beiyong1',align:'center',width:60">车辆性质</th>
           <th data-options="field:'stats',align:'center',width:60">申请状态</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carKeepApprove" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carKeepApprove:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carKeepApprove_edit()">审批</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carKeepApprove_reload()">刷新</a>  
	</div>  

</div>  

<div id="carKeepApproveEditWindow" class="easyui-window" title="审批维护信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'carKeepApprove/edit'" style="width:850px;height:600px;padding:10px;">
</div>

<script>
function doSearch_carKeepApprove(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#carKeepApproveList").datagrid({
	        title:'维护审批列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carKeepApprove", url:'carKeepApprove/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'applyId', type:'hidden'},
	             	{field : 'carnum', width : 80, align : 'center', title : '维护车辆'},
	             	{field : 'applyname', width : 70, align : 'center', title : '申请人'},
	             	{field : 'approve', width : 70, align : 'center', title : '审批人'},
	             	{field : 'intervalkm', width : 80, align : 'center', title : '当前里程(/公里)'},
	             	{field : 'dep', width : 100, align : 'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'startdate', width : 80, align : 'center', title : '开始日期',formatter:TAOTAO.formatDate},
	             	{field : 'enddate', width : 80, align:'center', title : '截止日期',formatter:TAOTAO.formatDate},
	             	{field : 'repairtype', width : 200, align : 'center', title : '维护级别或维护项目'},
	             	{field : 'suppliername', width : 80, align : 'center', title : '厂家名称'},
	             	{field : 'beiyong1', width : 60, align : 'center', title : '车辆性质'},
	             	{field : 'stats', width : 60, align : 'center', title : '审批状态'}
	        ] ],  
	    });
	}
}

    function getCarKeepApproveSelectionsIds(){
    	var carKeepApproveList = $("#carKeepApproveList");
    	var sels = carKeepApproveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].applyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function  formatDepartment(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.department.departmentName+"";
    	}
	};
    function carKeepApprove_add(){
    	$.get("carKeepApprove/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carKeepApproveAddWindow").window("open");
       		}
       	});
    }
    function getCarKeepApproveSelectionsnames(){
    	var carKeepApproveList = $("#carKeepApproveList");
    	var sels = carKeepApproveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carnum);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carKeepApprove_edit(){
    	$.get("carKeepApprove/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarKeepApproveSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一条信息才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一条信息编辑!');
            		return ;
            	}
            	
            	$("#carKeepApproveEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#carKeepApproveList").datagrid("getSelections")[0];
            			data.startdate = TAOTAO.formatDate(data.startdate);
            			data.enddate = TAOTAO.formatDate(data.enddate);
            			data.departmentId = data.department.departmentId;
        				data.departmentName = data.department.departmentName;
        				data.stats = '段内处理';
            			keep1approveEditor.html(data.repairtype);
            			$("#carKeepApproveEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function carKeepApprove_delete(){
    	$.get("carKeepApprove/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getCarKeepApproveSelectionsIds();
      			var name = getCarKeepApproveSelectionsnames();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中信息!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除为 '+name+' 的维护信息吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("carKeepApprove/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除信息成功!',undefined,function(){
                					$("#carKeepApproveList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function carKeepApprove_reload(){
    	$("#carKeepApproveList").datagrid("reload");
    }
</script>