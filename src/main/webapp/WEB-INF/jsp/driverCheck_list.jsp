<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="driverCheckList" title="司机月度考核表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'driverCheck/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_driverCheck">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
	      	<th data-options="field:'drivernum',align:'center',width:100">驾驶证编号</th>
        	<th data-options="field:'d1',align:'center',width:80,formatter:formatD1">驾驶员姓名</th>
            <th data-options="field:'formatDsp3',align:'center',width:100,formatter:formatDsp3">所在部门</th>
            <th data-options="field:'carnumber',align:'center',width:80">车牌号</th>
            <th data-options="field:'kaohetime',align:'center',width:100,formatter:TAOTAO.formatDateTime">考核时间</th>
            <th data-options="field:'kaohescore',align:'center',width:80">考核得分</th>
            <th data-options="field:'koufenyinsu',width:160,align:'center'">扣分因素</th>
            <th data-options="field:'driverCheckEdit',align:'center',width:50,formatter:formatDriverCheckEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_driverCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='driverCheck:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="driverCheck_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='driverCheck:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="driverCheck_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='driverCheck:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="driverCheck_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="driverCheck_reload()">刷新</a>  
	</div> 
</div>  

<div id="driverCheckEditWindow" class="easyui-window" title="编辑司机考核信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'driverCheck/edit'" style="width:850px;height:450px;padding:10px;">
</div>
<div id="driverCheckAddWindow" class="easyui-window" title="添加司机考核信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'driverCheck/add'" style="width:850px;height:450px;padding:10px;">
</div>

<script>
function doSearch_driverCheck(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#driverCheckList").datagrid({
	        title:'司机月度考核表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_driverCheck", url:'driverCheck/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [
	             	{field : 'ck', checkbox:true }, 
	             	{field :'driveCheckId', type:'hidden'},
	             	{field : 'drivernum', width : 100, align:'center', title : '驾驶证编号'},
	             	{field : 'drivername', width : 100, align:'center', title : '驾驶员姓名'},
	             	{field : 'carnumber', width : 100, align : 'center', title : '车牌号'},
	             	{field : 'kaohetime', width : 100, align : 'center', title : '考核时间',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'kaohescore', width : 100, title : '考核分数', align:'center'}, 
	            	{field : 'koufenyinsu', width : 100, title : '扣分因素', align:'center'}
	        ] ],  
	    });
	}
}
var send1AddEditor;

var send2AddEditor;

function  formatDriverCheckEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='driverCheck_edit()'><span style='color:blue'>编辑</span></a>";
};
//根据index拿到该行值
function ondriverCheckClickRow(index) {
	var rows = $('#driverCheckList').datagrid('getRows');
	return rows[index];
}
function  formatDsp3(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function  formatD1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drviername+"";
		//return '0';
	}
};
//打开行驶里程记录记录信息对话框
function  opendriverCheck(index){ 
	var row = ondriverCheckClickRow(index);
	$("#driverCheckListWindow").dialog({
		onOpen :function(){
			$.get("driverCheck/get/"+row.driveCheckId,'',function(data){
	    		//回显数据
	    		send1AddEditor = KindEditor.create("#driverCheckEditForm [name=koufenyinsu]", TT.kingEditorParams);
    			send1AddEditor.html(data.koufenyinsu);
    			data.drivername = data.carDriver.driverId;
	    		data.kaohetime = TAOTAO.formatDateTime(data.kaohetime);
	    		$("#driverCheckEditForm").form("load",data);
	    	});
		},
		onBeforeClose: function (event, ui) {
		  	KindEditor.remove("#driverCheckEditForm [name=koufenyinsu]");
			
		}
	}).dialog("open");
};

	//更新订单要求
	function updatedriverCheckNote(){
		$.get("driverCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("driverCheck/update_note",$("#driverCheckNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#driverCheckNoteDialog").dialog("close");
    					$("#driverCheckList").datagrid("reload");
    					$.messager.alert("操作提示", "更新司机考核信息成功！");
    				}else{
    					$.messager.alert("操作提示", "更新司机考核信息失败！");
    				}
    			});
    		}
    	});
	}
	
    function getdriverCheckSelectionsIds(){
    	var driverCheckList = $("#driverCheckList");
    	var sels = driverCheckList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].driveCheckId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function driverCheck_add(){
    	$.get("driverCheck/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#driverCheckAddWindow").window("open");
       		}
       	});
    }
    
    function driverCheck_edit(){
    	$.get("driverCheck/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getdriverCheckSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一条月度考核信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一条月度考核信息!');
               		return ;
               	}
               	$("#driverCheckEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#driverCheckList").datagrid("getSelections")[0];
               			send2AddEditor = KindEditor.create("#driverCheckEditForm1 [name=koufenyinsu]", {
            				resizeType : 1,
            				allowPreviewEmoticons : false,
            				allowImageUpload : false,
            				items : [
            					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
            					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
            			});
            			send2AddEditor.html(data.koufenyinsu);
            			data.drivername = data.carDriver.driverId;
               			data.kaohetime = TAOTAO.formatDateTime(data.kaohetime);
               			$("#driverCheckEditForm1").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getdriverCheckSelectionsNames(){
    	var driverCheckList = $("#driverCheckList");
    	var sels = driverCheckList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].drivername);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function driverCheck_delete(){
    	$.get("driverCheck/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getdriverCheckSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中行驶里程记录记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该条考核信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("driverCheck/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除考核信息成功!',undefined,function(){
                  					$("#driverCheckList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closedriverCheckEditForm(){
					$("#driverCheckListWindow").window('close');
					$("#driverCheckEditForm").datagrid("reload");
	}
    
    function driverCheck_reload(){
    	$("#driverCheckList").datagrid("reload");
    }
    
 
</script>