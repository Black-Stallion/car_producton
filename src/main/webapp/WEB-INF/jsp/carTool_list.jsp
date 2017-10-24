<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carToolList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carTool/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carTool">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnumber',width:90,align:'center',formatter:formatCarNumber">车牌号</th>
        	<th data-options="field:'toolname',align:'center',width:200">工具(备品)</th>
            <th data-options="field:'norms',align:'center',width:100">规格</th>
            <th data-options="field:'nums',align:'center',width:60">数量</th>
            <th data-options="field:'notes',align:'center',width:150">备注</th>
            <th data-options="field:'toolzj',align:'center',width:200">证件(资料)</th>
            <th data-options="field:'nums1',align:'center',width:60">数量</th>
            <th data-options="field:'notes1',align:'center',width:150">备注</th>
            <th data-options="field:'carToolEdit',align:'center',width:50,formatter:formatCarToolEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carTool" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carTool:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carTool_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carTool:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carTool_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carTool:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carTool_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carTool_reload()">刷新</a>  
	</div> 
	<div id="search_carTool" style="float: right;">
        <input id="search_text_carTool" class="easyui-searchbox"  
            data-options="searcher:doSearch_carTool,prompt:'请输入...',menu:'#menu_carTool'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carTool" style="width:120px"> 
			<div data-options="name:'carnumber'">车牌号</div>
		</div>     
    </div>
</div>  

<div id="carToolEditWindow" class="easyui-window" title="编辑随车物品信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carTool/edit'" style="width:850px;height:350px;padding:10px;">
</div>
<div id="carToolAddWindow" class="easyui-window" title="添加随车物品信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carTool/add'" style="width:850px;height:350px;padding:10px;">
</div>

<script>
function doSearch_carTool(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carToolList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carTool", url:'carTool/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'toolId', type:'hidden'},
	             	{field : 'carnumber', width : 90, title : '车牌号', align:'center',formatter:formatCarNumber},
	             	{field : 'toolname', width : 200, align:'center',title : '工具(备品)'},
	             	{field : 'norms', width : 100, align : 'center', title : '规格'}, 
	             	{field : 'nums', width : 60, title : '数量', align:'center'}, 
	            	{field : 'notes', width : 150, title : '备注', align:'center'},
	             	{field : 'toolzj', width : 200, align : 'center', title : '证件(资料)'},
	             	{field : 'nums1', width : 60, title : '数量', align:'center'}, 
	            	{field : 'notes1', width : 150, title : '备注', align:'center'},
	            	{field : 'carToolEdit', width : 50, align:'center', title : '编辑',formatter:formatCarToolEdit}
	        ] ],  
	    });
	}else{
		$("#carToolList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carTool", url:'carTool/search_carTool_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'toolId', type:'hidden'},
	             	{field : 'carnumber', width : 90, title : '车牌号', align:'center',formatter:formatCarNumber},
	             	{field : 'toolname', width : 200, align:'center',title : '工具(备品)'},
	             	{field : 'norms', width : 100, align : 'center', title : '规格'}, 
	             	{field : 'nums', width : 60, title : '数量', align:'center'}, 
	            	{field : 'notes', width : 150, title : '备注', align:'center'},
	             	{field : 'toolzj', width : 200, align : 'center', title : '证件(资料)'},
	             	{field : 'nums1', width : 60, title : '数量', align:'center'}, 
	            	{field : 'notes1', width : 150, title : '备注', align:'center'},
	            	{field : 'carToolEdit', width : 50, align:'center', title : '编辑',formatter:formatCarToolEdit}
	        ] ],  
	    });
	}
}
function  formatCarToolEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carTool_edit()'><span style='color:blue'>编辑</span></a>";
};
  //格式化车型信息
    function  formatCarNumber(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.carRegister.carnumber+"";
    	}
	};
	
	//根据index拿到该行值
	function onCarToolClickRow(index) {
		var rows = $('#carToolList').datagrid('getRows');
		return rows[index];
	}
	
	//更新信息要求
	function updateCarToolNote(){
		$.get("carTool/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carToolNoteEditor.sync();
    			$.post("carTool/update_note",$("#carToolNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carToolNoteDialog").dialog("close");
    					$("#carToolList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getCarToolSelectionsIds(){
    	var carToolList = $("#carToolList");
    	var sels = carToolList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].toolId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carTool_add(){
    	$.get("carTool/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carToolAddWindow").window("open");
       		}
       	});
    }
    
    function carTool_edit(){
    	$.get("carTool/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarToolSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carToolEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carToolList").datagrid("getSelections")[0];
               			data.carnumber = data.carRegister.carnumber;
               			data.carId = data.carRegister.carId;
               			data.usenature = data.carRegister.usenature;
               			$("#carToolEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarToolSelectionsNames(){
    	var carToolList = $("#carToolList");
    	var sels = carToolList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carRegister.carnumber);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carTool_delete(){
    	$.get("carTool/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarToolSelectionsNames();
      			var ids = getCarToolSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除车牌号为 '+names+' 的随车信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carTool/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carToolList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    
    function carTool_reload(){
    	$("#carToolList").datagrid("reload");
    }
</script>