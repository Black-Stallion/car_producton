<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="userList" title="用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'user/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_user">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'username',align:'center',width:60">用户名</th>
            <th data-options="field:'roleName',align:'center',width:80,formatter:formatRole">角色</th>
             <th data-options="field:'departmentName',align:'center',width:70,formatter:formatDepartment">部门名称</th>
             <th data-options="field:'shenfen',align:'center',width:100">身份证号</th>
             <th data-options="field:'culte',align:'center',width:50">文化程度</th>
             <th data-options="field:'jiguan',align:'center',width:110">籍贯</th>
             <th data-options="field:'phone',align:'center',width:60">联系电话</th>
             <th data-options="field:'qq',align:'center',width:60">QQ/邮箱</th>
             <th data-options="field:'gongzuodanwei',align:'center',width:95">工作单位</th>
             <th data-options="field:'leveds',width:60,align:'center',formatter:formatLeve">操作权限</th>
            <th data-options="field:'locked',width:60,align:'center',formatter:formatUserStatus">状态</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_user" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='user:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="user_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='user:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="user_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='user:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="user_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="user_reload()">刷新</a>  
	</div>  
	
    <div id="search_user" style="float: right;">
        <input id="search_text_user" class="easyui-searchbox"  
            data-options="searcher:doSearch_user,prompt:'请输入...',menu:'#menu_user'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_user" style="width:120px"> 
			<div data-options="name:'userName'">用户名称</div>
			<div data-options="name:'roleName'">角色名称</div> 
			<div data-options="name:'departmentName'">部门名称</div> 
		</div>     
    </div>  

</div>  

<div id="userEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'user/edit'" style="width:600px;height:520px;padding:20px;">
</div>
<div id="userAddWindow" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'user/add'" style="width:600px;height:520px;padding:20px;">
</div>
<div id="userRoleWindow" class="easyui-window" title="用户权限" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'user/role'" style="width:45%;height:60%;padding:10px;">
</div>

<script>
function doSearch_user(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#userList").datagrid({
	        title:'用户列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_user", url:'user/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'username', width : 60, align : 'center', title : '用户名'},
	             	{field : 'roleName', width : 80, title : '角色', align:'center',formatter:formatRole}, 
	             	{field : 'departmentName', width : 70, title : '部门名称', align:'center',formatter:formatDepartment},
	             	{field : 'shenfen',align:'center',width:100,title : '身份证号'},
	             	{field : 'culte',align:'center',width:50,title : '文化程度'},
	             	{field : 'jiguan',align:'center',width:110,title : '籍贯'},
	             	{field : 'phone',align:'center',width:60,title :'联系电话'},
	             	{field : 'qq',align:'center',width:60,title :'QQ/邮箱'},
	             	{field : 'gongzuodanwei',align:'center',width:95,title : '工作单位'},
	             	{field : 'leveds', width : 60, title : '操作权限', align:'center', formatter:formatLeve}, 
	             	{field : 'locked', width : 60, title : '状态', align:'center', formatter:formatUserStatus}, 
	        ] ],  
	    });
	}else{
		$("#userList").datagrid({  
	        title:'用户列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_user", url:'user/search_user_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,  
	        columns : [ [ 
					{field : 'ck', checkbox:true }, 
					{field : 'username', width : 60, align : 'center', title : '用户名'},
	             	{field : 'roleName', width : 80, title : '角色', align:'center',formatter:formatRole}, 
	             	{field : 'departmentName', width : 70, title : '部门名称', align:'center',formatter:formatDepartment},
	             	{field : 'shenfen',align:'center',width:100,title : '身份证号'},
	             	{field : 'culte',align:'center',width:50,title : '文化程度'},
	             	{field : 'jiguan',align:'center',width:110,title : '籍贯'},
	             	{field : 'phone',align:'center',width:60,title :'联系电话'},
	             	{field : 'qq',align:'center',width:60,title :'QQ/邮箱'},
	             	{field : 'gongzuodanwei',align:'center',width:95,title : '工作单位'},
	             	{field : 'leveds', width : 60, title : '操作权限', align:'center', formatter:formatLeve}, 
	             	{field : 'locked', width : 60, title : '状态', align:'center', formatter:formatUserStatus}, 
	        ] ],  
	    });
	}
}

function formatUserStatus(value){
        if (value == 1){
            return '有效用户';
        }else if(value == 2){
        	return '<span style="color:red;">锁定</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态用户</span>';
        }
    }
function formatLeve(value, row, index){
	if(value ==null && value == ''){
		return '无';
	}else{
		if (row.leve == 1){
	        return '本部门';
	    }else if(row.leve == 2){
	    	return '<span style="color:red;">所有部门</span>';
	    }else {
	    	return '<span style="color:#E5B717;">未知</span>';
	    }
	}
    
}
	//根据index拿到该行值
	function onUserClickRow(index) {
		var rows = $('#userList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化角色信息
	function formatRole(value, row, index){ 
		return "<a href=javascript:openRole("+index+")>"+row.roleName+"</a>";
	};  
	
	//格式化部门信息
	function formatDepartment(value, row, index){
			return ""+row.department.departmentName+"";
	}; 
	
	//打开角色信息
	function  openRole(index){ 
		var row = onUserClickRow(index);
		$.get("role/get/"+row.roleId,'',function(data){
			$("#userRoleWindow").window({
	    		onLoad :function(){
	    			//回显数据
	    			$("#userRoleEditForm").form("load", data);
	    			userPermissionInit();
	    		}
	    	}).window("open");
    	});
	};
	
	
	
    function getUserSelectionsIds(){
    	var userList = $("#userList");
    	var sels = userList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function user_add(){
    	$.get("user/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#userAddWindow").window("open");
       		}
       	});
    }

    function user_edit(){
    	$.get("user/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getUserSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个用户才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个用户!');
            		return ;
            	}
            	
            	$("#userEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#userList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId;
            				data.departmentName = data.department.departmentName;
            			$("#userEditForm").form("load", data);
            		}
            	}).window("open");
       		}
       	});
    }
    
    function getUserSelectionsName(){
    	var userList = $("#userList");
    	var sels = userList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].username);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function user_delete(){
    	$.get("user/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getUserSelectionsIds();
      			var name = getUserSelectionsName();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中用户!');
            		return ;
            	}
            	if(ids.indexOf('001') >=0){
            		$.messager.alert('提示','ID为001的系统用户不能被删除!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除用户 '+name+' 吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("user/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除用户成功!',undefined,function(){
                					$("#userList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function user_reload(){
    	$("#userList").datagrid("reload");
    }
</script>