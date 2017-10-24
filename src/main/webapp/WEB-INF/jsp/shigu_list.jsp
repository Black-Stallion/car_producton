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
<table class="easyui-datagrid" id="shiguList" title="事故管理表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'shigu/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_shigu">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
	      	<th data-options="field:'shigucode',align:'center',width:100">事故编号</th>
	      	<th data-options="field:'carnumber',align:'center',width:100">车牌号</th>
            <th data-options="field:'driver2',align:'center',width:100,formatter:formatdr2">主车司机</th>
	      	<th data-options="field:'formatdsp6',align:'center',width:100,formatter:formatDsp6">所在部门</th>
        	<th data-options="field:'shigutime',align:'center',width:100,formatter:TAOTAO.formatDate">事故时间</th>
            <th data-options="field:'place',align:'center',width:100">事故地点</th>
            <th data-options="field:'shigutype',align:'center',width:100">事故类型</th>
            <th data-options="field:'formatshiguList',width:100,align:'center',formatter:formatshiguList">详细信息</th>
            <th data-options="field:'shiguEdit',align:'center',width:50,formatter:formatShiguEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_shigu" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='shigu:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="shigu_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='shigu:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="shigu_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='shigu:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="shigu_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="shigu_reload()">刷新</a>  
	</div> 
</div>  

<div id="shiguEditWindow" class="easyui-window" title="编辑交通事故记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'shigu/edit'" style="width:850px;height:540px;padding:10px;">
</div>
<div id="shiguAddWindow" class="easyui-window" title="添加交通事故记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'shigu/add'" style="width:850px;height:540px;padding:10px;">
</div>
<div id="shiguListWindow" class="easyui-dialog" title="交通事故记录详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:850px;height:600px;padding:10px;">
	<form id="shigu1EditForm" method="post">
		<input type="hidden" name="shiguId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
		      <tr>
	    	    <td width="auto" bgcolor="#F0F8FF" align="right">事故编号</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="shigucode" data-options="required:true"></input>
	            </td>
	    	  	<td width="auto" bgcolor="#F0F8FF" align="right">事故时间</td>
	       		<td width="auto">
	       			<input class="easyui-datetimebox" name="shigutime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
	    	 </tr>
	    	 <tr>
	    	 	<td bgcolor="#F0F8FF" align="right">事故地点</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="place" data-options="required:true"></input>
	            </td>
	            <td bgcolor="#F0F8FF" align="right">事故类型</td>
	            <td>
	            <input class="easyui-textbox" name="shigutype"   editable="false"/>
	            </td>
	    	 </tr>
		     <tr>
	    		<td bgcolor="#F0F8FF" align="right">主车司机</td>
	            <td>
	            	<input class="easyui-textbox" name="drivername"   editable="false"/>
	            	
	            </td>
        		<td bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td>
	            <input class="easyui-combobox" id="carNumberCombox459" name="carnumber" data-options="required:true" panelHeight="auto" size="13px"/>  
	             </td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">责任</td>
	            <td colspan="3">
	            <input class="easyui-textbox" type="text" name="zeren" size="100px"></input>
    			
	             </td>
        	
	        </tr>
	        <tr>
    		<td bgcolor="#F0F8FF" align="right">原因</td>
    		 <td colspan="3"><textarea 
							style="width:620px; height:150px;" editable="false"
							  name="yuanyin"></textarea></td>
	        </tr>
	        <tr>
    		<td bgcolor="#F0F8FF" align="right">损失情况</td>
    		<td colspan="3"><textarea 
					style="width:620px; height:150px;" editable="false"
							  name="sunshi"></textarea></td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 35px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeDriverCheckEditForm()">关闭</a>
	</div>
</div>
<script>
function doSearch_shigu(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#shiguList").datagrid({
	        title:'交通事录记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_shigu", url:'shigu/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'shigucode', width : 100, align:'center', title : '事故编号'},
	             	{field : 'shigutime', width : 100, align:'center', title : '事故时间',formatter:TAOTAO.formatDateTime},
	            	{field : 'place', width : 100, align : 'center', title : '事故地点'},
	             	{field : 'shigutype', width : 100, align : 'center', title : '事故类型'},
	             	{field : 'zeren', width : 100, align : 'center', title : '责任'}, 
	            	{field : 'carnumber', width : 100, title : '车牌号', align:'center'}, 
	            	{field : 'driver2', width : 100, title : '主车司机', align:'center',formatter:formatdr2},
	             	{field : 'formatshiguList', width : 100, title : '交通事故记录详细信息', align:'center',formatter:formatshiguList}
	         ],  
	    });
	}
}

var send2AddEditor;
var send2AddEditor1;

function  formatShiguEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='shigu_edit()'><span style='color:blue'>编辑</span></a>";
};

//格式化交通事故记录记录信息
function  formatshiguList(value, row, index){ 
		return "<a href=javascript:openshigu("+index+")>"+"交通事故记录详细信息"+"</a>";
};
function formatDsp6(value, row, index){ 
	debugger;
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
//根据index拿到该行值
function onshiguClickRow(index) {
	var rows = $('#shiguList').datagrid('getRows');
	return rows[index];
}
function  formatdr2(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drviername+"";
	}
};
//打开交通事故记录记录信息对话框
function  openshigu(index){ 
	var row = onshiguClickRow(index);
	$("#shiguListWindow").dialog({
		onOpen :function(){
			$.get("shigu/get/"+row.shiguId,'',function(data){
	    		//回显数据
    			data.drivername = data.carDriver.drviername;
	    		data.shigutime = TAOTAO.formatDateTime(data.shigutime);
	    		$("#shigu1EditForm").form("load",data);
	    	});
		},
	}).dialog("open");
};

	//更新订单要求
	function updateshiguNote(){
		$.get("shigu/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("shigu/update_note",$("#shiguNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#shiguNoteDialog").dialog("close");
    					$("#shiguList").datagrid("reload");
    					$.messager.alert("操作提示", "更新交通事故记录信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新交通事故记录信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getshiguSelectionsIds(){
    	var shiguList = $("#shiguList");
    	var sels = shiguList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].shiguId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function shigu_add(){
    	$.get("shigu/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#shiguAddWindow").window("open");
       		}
       	});
    }
    
    function shigu_edit(){
    	$.get("shigu/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getshiguSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个交通事故记录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个交通事故记录信息!');
               		return ;
               	}
               	$("#shiguEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#shiguList").datagrid("getSelections")[0];
               			data.shigutime = TAOTAO.formatDateTime(data.shigutime);
               			send2AddEditor = KindEditor.create("#shiguEditForm1 [name=yuanyin]", {
            				resizeType : 1,
            				allowPreviewEmoticons : false,
            				allowImageUpload : false,
            				items : [
            					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
            			});
            			send2AddEditor1 = KindEditor.create("#shiguEditForm1 [name=sunshi]",{
            				resizeType : 1,
            				allowPreviewEmoticons : false,
            				allowImageUpload : false,
            				items : [
            					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
            			});
            			data.drivername = data.carDriver.driverId;
            			send2AddEditor.html(data.yuanyin);
            			send2AddEditor1.html(data.sunshi);
               			$("#shiguEditForm1").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getshiguSelectionsNames(){
    	var shiguList = $("#shiguList");
    	var sels = shiguList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].drivername);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function shigu_delete(){
    	$.get("shigu/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getshiguSelectionsNames();
      			var ids = getshiguSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中交通事故记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该交通事故记录吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("shigu/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除交通事故记录成功!',undefined,function(){
                  					$("#shiguList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closeDriverCheckEditForm(){
					$("#shiguListWindow").window('close');
					$("#").datagrid("reload");
	}
    
    function shigu_reload(){
    	$("#shiguList").datagrid("reload");
    }
    
 
</script>