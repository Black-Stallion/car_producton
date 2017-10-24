<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<style type="text/css">   
    .border-table {   
        border-collapse: collapse;   
         border: solid #87CEFA 1px;   
    }   
    .border-table td {   
        border: solid #87CEFA 1px;
        color:#4682B4; 
        font-size:13px;
    }  
</style>
<table class="easyui-datagrid" id="carUsingList" title="运用记录表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carUsing/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carUsing">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
	      	<th data-options="field:'formatCarNum',align:'center',width:100,formatter:formatCarNumber">车牌号</th>
        	<th data-options="field:'formatDepartment',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	<th data-options="field:'usingyear',align:'center',width:100">运用年</th>
            <th data-options="field:'usingmonth',align:'center',width:100">运用月</th>
            <th data-options="field:'monthnumbers',align:'center',width:120">路码表月终读数</th>
            <th data-options="field:'monthkm',align:'center',width:100">月公里</th>
            <th data-options="field:'monthtime',width:100,align:'center'">趟数</th>
            <th data-options="field:'monthdays',width:100,align:'center'">天数</th>
            <th data-options="field:'haoyou',width:100,align:'center'">升/百公里</th>
            <th data-options="field:'formatcarUsingList',width:100,align:'center',formatter:formatcarUsingList">详细信息</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carUsing" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carUsing:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carUsing_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carUsing:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carUsing_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carUsing:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carUsing_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carUsing_reload()">刷新</a>  
	</div> 
	<div id="search_carUsing" style="float: right;">
        <input id="search_text_carUsing" class="easyui-searchbox"  
            data-options="searcher:doSearch_carUsing,prompt:'请输入...',menu:'#menu_carUsing'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carUsing" style="width:120px"> 
			<div data-options="name:'carid'">车牌号</div>
			<div data-options="name:'depname'">部门名称</div> 
		</div>     
    </div>
</div>  

<div id="carUsingEditWindow" class="easyui-window" title="编辑运行记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carUsing/edit'" style="width:750px;height:370px;padding:30px;">
</div>
<div id="carUsingAddWindow" class="easyui-window" title="添加运行记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carUsing/add'" style="width:750px;height:370px;padding:30px;">
</div>
<div id="carUsingListWindow" class="easyui-dialog" title="运行记录详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:750px;height:370px;padding:30px;">
	<form id="carUsingEditForm1" method="post">
	<input type="hidden" name="usingId"/>
		 <center>
	     <table class="border-table" cellpadding="5" align="center">
		    <tr>
	    		<td width="auto" bgcolor="#F0F8FF" align="right">设备编号</td>
	            <td width="auto">
	            	<input class="easyui-combobox" id="carCombox105" data-options="required:true" name="usenature" panelHeight="auto" size="9px" />
	            	<input  id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox105" name="carnumber" data-options="required:true" panelHeight="auto" size="10px"/>  
    				<input name="carId" id="carId105" type="hidden"/>
	            	
	            </td>
        			<td width="auto" bgcolor="#F0F8FF" align="right">运用年</td>
	            	<td width="auto"> <input class="easyui-numberbox" type="text" name="usingyear" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">运用月</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="usingmonth" data-options="required:true">
	             </td>
        			<td bgcolor="#F0F8FF" align="right">路码表月终读数</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="monthnumbers" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">月公里</td>
	            <td><input class="easyui-textbox" type="text" name="monthkm" > </td>
	       		<td bgcolor="#F0F8FF" align="right">趟数</td>
	            <td><input class="easyui-textbox" type="text" name="monthtime" ></td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">天数</td>
	            <td><input class="easyui-textbox" type="text" name="monthdays" data-options="required:true"> </td>
        		<td bgcolor="#F0F8FF" align="right">燃油</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="monthry"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">润滑油</td>
	            <td><input class="easyui-textbox" type="text" name="monthrhy"> </td>
        		<td bgcolor="#F0F8FF" align="right">百公里耗油</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="haoyou">
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">过路，桥，停车费用</td>
	            <td><input class="easyui-textbox" type="text" name="kindscost"> </td>
        		<td bgcolor="#F0F8FF" align="right">备注</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="note" ></texarea>
	            </td>
	        </tr>
	    </table>
	    </center>
	</form>
	<div style="padding:5px 0 0 55px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closecarUsingEditForm1()">关闭</a>
	</div>
</div>
<script>
function doSearch_carUsing(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carUsingList").datagrid({
	        title:'运用记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carUsing", url:'carUsing/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'formatCarNum', width : 100, align:'center', title : '车牌号',formatter:formatCarNumber},
	             	{field : 'formatDepartment', width : 100, align:'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'usingyear', width : 100, align:'center', title : '运用年'},
	             	{field : 'usingmonth', width : 100, align : 'center', title : '运用月'},
	             	{field : 'monthnumbers', width : 120, align : 'center', title : '路码表月终读数'}, 
	             	{field : 'monthkm', width : 100, title : '月公里', align:'center'}, 
	            	{field : 'monthtime', width : 100, title : '趟数', align:'center'}, 
	             	{field : 'monthdays', width : 100, title : '天数', align:'center'}, 
	             	{field : 'haoyou', width : 100, title : '百公里耗油', align:'center'}, 
	             	{field : 'formatcarUsingList', width : 100, title : '运行记录详细信息', align:'center',formatter:formatcarUsingList}
	        ] ], 
	    });
	}else{
		$("#carUsingList").datagrid({
	        title:'运用记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carUsing",url:'carUsing/search_carUsing_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'formatCarNum', width : 100, align:'center', title : '车牌号',formatter:formatCarNumber},
	             	{field : 'formatDepartment', width : 100, align:'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'usingyear', width : 100, align:'center', title : '运用年'},
	             	{field : 'usingmonth', width : 100, align : 'center', title : '运用月'},
	             	{field : 'monthnumbers', width : 120, align : 'center', title : '路码表月终读数'}, 
	             	{field : 'monthkm', width : 100, title : '月公里', align:'center'}, 
	            	{field : 'monthtime', width : 100, title : '趟数', align:'center'}, 
	             	{field : 'monthdays', width : 100, title : '天数', align:'center'}, 
	             	{field : 'haoyou', width : 100, title : '百公里耗油', align:'center'}, 
	             	{field : 'formatcarUsingList', width : 100, title : '运行记录详细信息', align:'center',formatter:formatcarUsingList}
	        ] ],  
	    });
	}
}
//格式化车型信息
function  formatCarNumber(value, row, index){ 
	if(value ==null && value ==''){
		return '无';}
	else{
		return ""+row.register.carnumber+"";
		//return '无';
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

//格式化运行记录信息
function  formatcarUsingList(value, row, index){ 
		return "<a href=javascript:opencarUsing("+index+")>"+"运行记录详细信息"+"</a>";
};

//根据index拿到该行值
function oncarUsingClickRow(index) {
	var rows = $('#carUsingList').datagrid('getRows');
	return rows[index];
}

//打开运行记录信息对话框
function  opencarUsing(index){ 
	var row = oncarUsingClickRow(index);
	$("#carUsingListWindow").dialog({
		onOpen :function(){
			$.get("carUsing/get/"+row.usingId,'',function(data){
				data.carnumber = data.register.carnumber;
       			data.carId = data.register.carId;
				data.usenature = data.register.usenature;
	    		//回显数据
	    		$("#carUsingEditForm1").form("load",data);
	    	});
		},
	}).dialog("open");
};

	
    function getcarUsingSelectionsIds(){
    	var carUsingList = $("#carUsingList");
    	var sels = carUsingList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].usingId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function carUsing_add(){
    	$.get("carUsing/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carUsingAddWindow").window("open");
       		}
       	});
    }
    
    function carUsing_edit(){
    	$.get("carUsing/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getcarUsingSelectionsIds();
       			
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个运行记录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个运行记录信息!');
               		return ;
               	}
               	$("#carUsingEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carUsingList").datagrid("getSelections")[0];
               			data.carnumber = data.register.carnumber;
               			data.carId = data.register.carId;
        				data.usenature = data.register.usenature;
               			$("#carUsingEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
  
    
    function carUsing_delete(){
    	$.get("carUsing/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      		
      			var ids = getcarUsingSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中运行记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除运行记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carUsing/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除运行记录成功!',undefined,function(){
                  					$("#carUsingList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closecarUsingEditForm1(){
					$("#carUsingListWindow").window('close');
					$("#carUsingEditForm").datagrid("reload");
	}
    
    function carUsing_reload(){
    	$("#carUsingList").datagrid("reload");
    }
    
	
</script>