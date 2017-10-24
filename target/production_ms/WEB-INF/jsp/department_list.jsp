<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="departmentList" title="部门列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'department/list',method:'get',pageSize:20,fitColumns:true,toolbar:toolbar_department">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'departmentName',align:'center',width:150">部门名称</th>
            <th data-options="field:'lev',align:'center',width:150, formatter:formatlevel">部门级别</th>
            <th data-options="field:'note',width:150,align:'center', formatter:formatDepartmentNote">部门职责</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_department" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='department:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="department_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='department:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="department_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='department:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="department_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="department_reload()">刷新</a>  
	</div>  
	
    <div id="search_department" style="float: right;">
        <input id="search_text_department" class="easyui-searchbox"  
            data-options="searcher:doSearch_department,prompt:'请输入...',menu:'#menu_department'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_department" style="width:120px"> 
			
			<div data-options="name:'departmentName'">部门名称</div>
		</div>     
    </div>  

</div>  

<div id="departmentEditWindow" class="easyui-window" title="编辑部门" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'department/edit'" style="width:850px;height:400px;padding:10px;">
</div>

<div id="departmentAddWindow" class="easyui-window" title="添加部门" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'department/add'" style="width:850px;height:400px;padding:10px;">
</div>

<div id="departmentNoteDialog" class="easyui-dialog" title="部门职责" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:850px;height:350px;padding:10px">
	<form id="departmentNoteForm" class="itemForm" method="post">
		<input type="hidden" name="departmentId"/>
	    <table class="border-table" cellpadding="5" align="center">
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">备注:</td>
	            <td>
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateDepartmentNote()">保存</a>
	</div>
</div>
<script>
function doSearch_department(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#departmentList").datagrid({
	        title:'部门列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_department", url:'department/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'departmentName', width : 150, align : 'center', title : '部门名称'},
	             	{field : 'lev', width : 150, align : 'center', title : '部门级别',formatter:formatlevel},
	             	{field : 'note', width : 150, align : 'center', title : '部门职责', formatter:formatDepartmentNote}, 
	        ] ],  
	    });
	}else{
		$("#departmentList").datagrid({  
	        title:'部门列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_department", url:'department/search_department_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
					{field : 'ck', checkbox:true }, 
					{field : 'departmentName', width : 150, align : 'center', title : '部门名称'},
					{field : 'lev', width : 150, align : 'center', title : '部门级别',formatter:formatlevel},
					{field : 'note', width : 150, align : 'center', title : '部门职责', formatter:formatDepartmentNote},
	        ] ],  
	    });
	}
} 

	var departmentNoteEditor ;
	
	//格式化车间职责
	function formatDepartmentNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDepartmentNote("+index+")>"+"部门职责"+"</a>";
		}else{
			return "无";
		}
	}
	function formatlevel(value, row, index){ 
		if(row.level==1){
			return "<span style='color:red'>一级部门</span>";
		}else if(row.level==2){
			return "<span style='color:blue'>二级部门</span>";
		}else{
			return "未知";
		}
	}

	//根据index拿到该行值
	function onDepartmentClickRow(index) {
		var rows = $('#departmentList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开车间要求富文本编辑器对话框
	function  openDepartmentNote(index){ 
		var row = onDepartmentClickRow(index);
		$("#departmentNoteDialog").dialog({
    		onOpen :function(){
    			$("#departmentNoteForm [name=departmentId]").val(row.departmentId);
    			departmentNoteEditor = TAOTAO.createEditor("#departmentNoteForm [name=note]");
    			departmentNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#departmentNoteForm [name=note]",{
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
				});
			}
    	}).dialog("open");
		
	};
	
	//更新车间要求
	function updateDepartmentNote(){
		$.get("department/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			departmentNoteEditor.sync();
    			$.post("department/update_note",$("#departmentNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#departmentNoteDialog").dialog("close");
    					$("#departmentList").datagrid("reload");
    					$.messager.alert("操作提示", "更新部门职责成功！");
    				}else{
    					$.messager.alert("操作提示", "更新部门职责失败！");
    				}
    			});
    		}
    	});
	}
	
    function getDepartmentSelectionsIds(){
    	var departmentList = $("#departmentList");
    	var sels = departmentList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].departmentId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function getDepartmentSelectionsName(){
    	var departmentList = $("#departmentList");
    	var sels = departmentList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].departmentName);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function getDepartmentSelectionsFahter(){
    	var departmentList = $("#departmentList");
    	var sels = departmentList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].fatherdep);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function getDepartmentSelectionsLevel(){
    	var departmentList = $("#departmentList");
    	var sels = departmentList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].level);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function department_add(){
    	$.get("department/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#departmentAddWindow").window("open");
       		}
       	});
    }
    
    function department_edit(){
    	$.get("department/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDepartmentSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个部门才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个部门!');
            		return ;
            	}
            	$("#departmentEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#departmentList").datagrid("getSelections")[0];
            			$("#departmentEditForm").form("load", data);
            			departmentEditEditor.html(data.note);
            			
            			TAOTAO.init({
            				"pics" : data.image,
            			});
            		}
            	}).window("open");
       		}
       	});
    }
    
    function department_delete(){
    	$.get("department/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			debugger;
      			var ids = getDepartmentSelectionsIds();
      			var name = getDepartmentSelectionsName();
      			var father = getDepartmentSelectionsFahter();
      			var level = getDepartmentSelectionsLevel();
      			var n=(level.split('1')).length-1;
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中部门!');
            		return ;
            	}if(ids.indexOf('001') >=0){
            		$.messager.alert('提示','第一位的部门不能删除!');
            		return ;
            	}if(n>1){
            		$.messager.alert('提示','一级部门仅支持单条删除，二级部门支持批量删除!');
            		return ;
            	}if(n == 1 && ids.indexOf(',') >0){
            		$.messager.alert('提示','一级部门仅支持单条删除，二级部门支持批量删除!');
            		return ;
            	}
            	$.get("department/father_judge/"+ids,'',function(data){
            		if(data.msg !=null){
            			$.messager.alert('提示','该部门含有子部门，请先删除子部门，在来删除该部门!');
            		}else{
            			$.messager.confirm('确认','确定删除部门  '+name+' 吗？',function(r){
                    	    if (r){
                    	    	var params = {"ids":ids};
                            	$.post("department/delete_batch",params, function(data){
                        			if(data.status == 200){
                        				$.messager.alert('提示','删除部门成功!',undefined,function(){
                        					$("#departmentList").datagrid("reload");
                        				});
                        			}
                        		});
                    	    }
                    	});
            		}
            		
            	});
      		}
      	});
    }   
    function department_reload(){
    	$("#departmentList").datagrid("reload");
    }
</script>