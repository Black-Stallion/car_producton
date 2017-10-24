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
<table class="easyui-datagrid" id="driverStudeyList" title="司机学习记录表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'driverStudey/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_driverStudey">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deps',align:'center',width:100,formatter:formatdeps">部门</th>
	      	<th data-options="field:'stutime',align:'center',width:100,formatter:TAOTAO.formatDateTime">时间</th>
        	<th data-options="field:'zhuchiren',align:'center',width:100">主持人</th>
            <th data-options="field:'yingdao',align:'center',width:100">应到人数</th>
            <th data-options="field:'shidao',align:'center',width:100">实到人数</th>
            <th data-options="field:'weidaoname',width:100,align:'center'">未到人员</th>
            <th data-options="field:'formatdriverStudeyList',width:100,align:'center',formatter:formatdriverStudeyList">详细信息</th>
            <th data-options="field:'driverStudyEdit',align:'center',width:50,formatter:formatDriverStudyEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_driverStudey" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='driverStudey:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="driverStudey_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='driverStudey:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="driverStudey_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='driverStudey:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="driverStudey_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="driverStudey_reload()">刷新</a>  
	</div> 
</div>  

<div id="driverStudeyEditWindow" class="easyui-window" title="编辑学习记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'driverStudey/edit'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="driverStudeyAddWindow" class="easyui-window" title="添加学习记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'driverStudey/add'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="driverStudeyListWindow" class="easyui-dialog" title="学习记录详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:850px;height:600px;padding:10px;">
	<form id="driverStudeyEditForm" method="post">
		<input type="hidden" name="studyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	     <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">学习部门</td>
	            <td colspan="3" width="auto" >
    				<input class="easyui-combobox" id="department5661" name="departmentName" panelHeight="auto"/>  
    				<input name="departmentId" id="departmentId5661" type="hidden"/>
	            </td>
	        </tr>
		      <tr>
	    		<td  bgcolor="#F0F8FF" align="right">时间</td>
	            <td>
	            	<input class="easyui-datetimebox" name="stutime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	            	
	            </td>
        			<td bgcolor="#F0F8FF" align="right">主持人</td>
	            	<td> <input class="easyui-textbox" type="text" name="zhuchiren" editable="false" ></td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">应到人数</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="yingdao" editable="false">
	             </td>
        			<td bgcolor="#F0F8FF" align="right">实到人数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="shidao" editable="false"></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">实到人员</td>
	       		<td colspan="3"><textarea 
							style="width:500px; height:100px;" editable="false"
							  name="shidaoname"></textarea></td>
	        </tr>
	         <tr>
    		
	       		<td  bgcolor="#F0F8FF" align="right">未到人员</td>
	            <td colspan="3"><textarea 
							style="width:500px; height:100px;" editable="false"
							  name="weidaoname"></textarea></td>
	        </tr>
	         <tr>
    		
	       		<td  bgcolor="#F0F8FF" align="right">学习内容</td>
	       		 <td colspan="3"><textarea 
							style="width:500px; height:100px;" editable="false"
							  name="content"></textarea></td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 55px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closedriverStudeyEditForm()">关闭</a>
	</div>
</div>
<script>
function doSearch_driverStudey(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#driverStudeyList").datagrid({
	        title:'司机学习记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_driverStudey", url:'driverStudey/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'stutime', width : 100, align:'center', title : '时间',formatter:TAOTAO.formatDateTime},
	             	{field : 'zhuchiren', width : 100, align:'center', title : '主持人'},
	             	{field : 'yingdao', width : 100, align : 'center', title : '应到人数'},
	             	{field : 'shidao', width : 100, align : 'center', title : '实到人数'}, 
	            	{field : 'weidaoname', width : 100, title : '未到人员', align:'center'},
	             	{field : 'formatdriverStudeyList', width : 100, title : '学习记录详细信息', align:'center',formatter:formatdriverStudeyList}
	         ],  
	    });
	}
}
var send1AddEditor;
var send1AddEditor1;
var send1AddEditor2;
var send2AddEditor;
var send2AddEditor1;
var send2AddEditor2;

function  formatDriverStudyEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='driverStudey_edit()'><span style='color:blue'>编辑</span></a>";
};

//格式化学习记录信息
function  formatdriverStudeyList(value, row, index){ 
		return "<a href=javascript:opendriverStudey("+index+")>"+"学习记录详细信息"+"</a>";
};
function  formatdeps(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
		//return '0';
	}
};
//根据index拿到该行值
function ondriverStudeyClickRow(index) {
	var rows = $('#driverStudeyList').datagrid('getRows');
	return rows[index];
}

//打开学习记录信息对话框
function  opendriverStudey(index){ 
	var row = ondriverStudeyClickRow(index);
	$("#driverStudeyListWindow").dialog({
		onOpen :function(){
			$.get("driverStudey/get/"+row.studyId,'',function(data){
	    		//回显数据
    			data.departmentId = data.department.departmentId;
    			data.departmentName = data.department.departmentName;
    			data.stutime = TAOTAO.formatDateTime(data.stutime);
	    		$("#driverStudeyEditForm").form("load",data);
	    	});
		},
	}).dialog("open");
};

	//更新订单要求
	function updatedriverStudeyNote(){
		$.get("driverStudey/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("driverStudey/update_note",$("#driverStudeyNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#driverStudeyNoteDialog").dialog("close");
    					$("#driverStudeyList").datagrid("reload");
    					$.messager.alert("操作提示", "更新学习记录信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新学习记录信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getdriverStudeySelectionsIds(){
    	var driverStudeyList = $("#driverStudeyList");
    	var sels = driverStudeyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].studyId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function driverStudey_add(){
    	$.get("driverStudey/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#driverStudeyAddWindow").window("open");
       		}
       	});
    }
    
    function driverStudey_edit(){
    	$.get("driverStudey/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getdriverStudeySelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个学习记录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个学习记录信息!');
               		return ;
               	}
               	$("#driverStudeyEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#driverStudeyList").datagrid("getSelections")[0];
               			//回显数据
        	    		send2AddEditor = KindEditor.create("#driverStudeyEditForm1 [name=shidaoname]", {
        					resizeType : 1,
        					allowPreviewEmoticons : false,
        					allowImageUpload : false,
        					items : [
        						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
        						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        						'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
        				});
            			send2AddEditor.html(data.shidaoname);
            			send2AddEditor1 = KindEditor.create("#driverStudeyEditForm1 [name=weidaoname]", {
            				resizeType : 1,
            				allowPreviewEmoticons : false,
            				allowImageUpload : false,
            				items : [
            					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
            			});
            			send2AddEditor1.html(data.weidaoname);
            			send2AddEditor2 = KindEditor.create("#driverStudeyEditForm1 [name=content]", {
            				resizeType : 1,
            				allowPreviewEmoticons : false,
            				allowImageUpload : false,
            				items : [
            					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
            			});
            			send2AddEditor2.html(data.content);
            			data.departmentId = data.department.departmentId;
            		//	if(data.department.fatherdep=='0'){
            		//		data.fathername = data.department.departmentName;
            		//	}else{
            				data.departmentName = data.department.departmentName;
            		//	}
            			data.stutime = TAOTAO.formatDateTime(data.stutime);
               			$("#driverStudeyEditForm1").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getdriverStudeySelectionsNames(){
    	var driverStudeyList = $("#driverStudeyList");
    	var sels = driverStudeyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].zhuchiren);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function driverStudey_delete(){
    	$.get("driverStudey/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getdriverStudeySelectionsNames();
      			var ids = getdriverStudeySelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中学习记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除主持人 '+names+' 的学习记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("driverStudey/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除学习记录成功!',undefined,function(){
                  					$("#driverStudeyList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closedriverStudeyEditForm(){
					$("#driverStudeyListWindow").window('close');
					$("#driverStudeyEditForm").datagrid("reload");
	}
    
    function driverStudey_reload(){
    	$("#driverStudeyList").datagrid("reload");
    }
    
</script>