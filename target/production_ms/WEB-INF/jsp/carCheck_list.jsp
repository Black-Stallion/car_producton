<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carCheckList" title="月检记录表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carCheck/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carCheck">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
	      	<th data-options="field:'shebeiid',align:'center',width:100,formatter:formatCarNumber">车牌号</th>
	      	<th data-options="field:'formatDepartment',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	<th data-options="field:'checkyear',align:'center',width:100">运用年</th>
            <th data-options="field:'checkmonth',align:'center',width:100">运用月</th>
            <th data-options="field:'carscore',align:'center',width:100">车况评分</th>
            <th data-options="field:'carquestion',align:'center',width:150">存在问题</th>
            <th data-options="field:'results',width:150,align:'center'">处理结果</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carCheck:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carCheck_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carCheck:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carCheck_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carCheck:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carCheck_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carCheck_reload()">刷新</a>  
	</div> 
	<div id="search_carCheck" style="float: right;">
        <input id="search_text_carCheck" class="easyui-searchbox"  
            data-options="searcher:doSearch_carCheck,prompt:'请输入...',menu:'#menu_carCheck'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carCheck" style="width:120px"> 
			<div data-options="name:'carid'">车牌号</div>
			<div data-options="name:'depname'">部门名称</div> 
		</div>     
    </div>
</div>  

<div id="carCheckEditWindow" class="easyui-window" title="编辑月检记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carCheck/edit'" style="width:850px;height:550px;padding:10px;">
</div>
<div id="carCheckAddWindow" class="easyui-window" title="添加月检记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carCheck/add'" style="width:850px;height:550px;padding:10px;">
</div>
<script>
function doSearch_carCheck(value,name){ 
	if(value == null || value == ''){
		$("#carCheckList").datagrid({
	        title:'月检记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carCheck", url:'carCheck/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'shebeiid', width : 100, align:'center', title : '车牌号',formatter:formatCarNumber},
	             	{field : 'formatDepartment', width : 100, align:'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'checkyear', width : 100, align:'center', title : '运用年'},
	             	{field : 'checkmonth', width : 100, align : 'center', title : '运用月'},
	             	{field : 'carscore', width : 100, align : 'center', title : '车况评分'}, 
	             	{field : 'carquestion', width : 150, title : '存在问题', align:'center'}, 
	            	{field : 'results', width : 150, title : '处理结果', align:'center'}
	             	 ] ],  
	    });
	}else{
		$("#carCheckList").datagrid({
	        title:'月检记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carCheck",url:'carCheck/search_carCheck_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'shebeiid', width : 100, align:'center', title : '车牌号',formatter:formatCarNumber},
	             	{field : 'formatDepartment', width : 100, align:'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'checkyear', width : 100, align:'center', title : '运用年'},
	             	{field : 'checkmonth', width : 100, align : 'center', title : '运用月'},
	             	{field : 'carscore', width : 100, align : 'center', title : '车况评分'}, 
	             	{field : 'carquestion', width : 150, title : '存在问题', align:'center'}, 
	            	{field : 'results', width : 150, title : '处理结果', align:'center'}
	             	 ]],  
	    });
	}
}
var send1AddEditor;
var send1AddEditor1;
var send2AddEditor;
var send2AddEditor1;

//格式化车型信息
function  formatCarNumber(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.register.carnumber+"</a>";
		//return '无';
	}
};
function  formatDepartment(value, row, index){ 
	debugger;
	if(value ==null && value ==''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
		//return '无';
	}
};
//根据index拿到该行值
function oncarCheckClickRow(index) {
	var rows = $('#carCheckList').datagrid('getRows');
	return rows[index];
}

//打开月检记录信息对话框
function  opencarCheck(index){ 
	var row = oncarCheckClickRow(index);
	$("#carCheckListWindow").dialog({
		onOpen :function(){
			$.get("carCheck/get/"+row.checkId,'',function(data){
	    		//回显数据
	    		send1AddEditor = KindEditor.create("#carCheckEditForm1 [name=carquestion]", TT.kingEditorParams);
    			send1AddEditor.html(data.carquestion);
    			send1AddEditor1 = KindEditor.create("#carCheckEditForm1 [name=results]", TT.kingEditorParams);
    			send1AddEditor1.html(data.results);
	    		$("#carCheckEditForm1").form("load",data);
	    	});
		},
		onBeforeClose: function (event, ui) {
			// 关闭Dialog前移除编辑器
		   	KindEditor.remove("#carCheckEditForm1 [name=carquestion]");
			KindEditor.remove("#carCheckEditForm1[name=results]");
			
		}
	}).dialog("open");
};

	//更新订单要求
	function updatecarCheckNote(){
		$.get("carCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("carCheck/update_note",$("#carCheckNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carCheckNoteDialog").dialog("close");
    					$("#carCheckList").datagrid("reload");
    					$.messager.alert("操作提示", "更新月检记录信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新月检记录信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getcarCheckSelectionsIds(){
    	var carCheckList = $("#carCheckList");
    	var sels = carCheckList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].checkId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function carCheck_add(){
    	$.get("carCheck/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carCheckAddWindow").window("open");
       		}
       	});
    }
    
    function carCheck_edit(){
    	$.get("carCheck/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getcarCheckSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个月检记录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个月检记录信息!');
               		return ;
               	}
               	$("#carCheckEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carCheckList").datagrid("getSelections")[0];
               			data.carnumber = data.register.carnumber;
               			data.carId = data.register.carId;
        				data.usenature = data.register.usenature;
               			send2AddEditor1.html(data.carquestion);
               			send2AddEditor1.html(data.results);
               			$("#carCheckEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getcarCheckSelectionsNames(){
    	var carCheckList = $("#carCheckList");
    	var sels = carCheckList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].register.carnumber);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carCheck_delete(){
    	$.get("carCheck/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getcarCheckSelectionsNames();
      			var ids = getcarCheckSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中月检记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除 '+names+' 的月检记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carCheck/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除月检记录成功!',undefined,function(){
                  					$("#carCheckList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closecarCheckEditForm(){
					$("#carCheckListWindow").window('close');
					$("#carCheckEditForm").datagrid("reload");
	}
    
    function carCheck_reload(){
    	$("#carCheckList").datagrid("reload");
    }
    
   
</script>