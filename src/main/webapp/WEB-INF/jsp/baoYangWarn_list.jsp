<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="baoYangWarnList" title="运用记录表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'baoYangWarn/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_baoYangWarn">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        		
	      	<th data-options="field:'carnumber',align:'center',width:100">车牌号</th>
        	<th data-options="field:'total',align:'center',width:100">行驶总里程</th>
            <th data-options="field:'weihuname',align:'center',width:100">维护项目</th>
            <th data-options="field:'status',align:'center',width:100">状态</th>
        
            <th data-options="field:'formatbaoYangWarnList',width:100,align:'center',formatter:formatbaoYangWarnList">详细信息</th>
             <th data-options="field:'formatbaoYangedit',width:60,align:'center',formatter:formatbaoYangEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_baoYangWarn" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='baoYangWarn:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="baoYangWarn_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='baoYangWarn:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="baoYangWarn_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='baoYangWarn:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="baoYangWarn_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="baoYangWarn_reload()">刷新</a>  
	</div> 
</div>  

<div id="baoYangWarnEditWindow" class="easyui-window" title="编辑车辆保养提醒信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'baoYangWarn/edit'" style="width:60%;height:90%;padding:10px;">
</div>
<div id="baoYangWarnAddWindow" class="easyui-window" title="添加车辆保养提醒信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'baoYangWarn/add'" style="width:60%;height:90%;padding:10px;">
</div>
<div id="baoYangWarnListWindow" class="easyui-dialog" title="车辆保养提醒详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:60%;height:90%;padding:10px;">
	<form id="baoYangWarnEditForm1" method="post">
		<input type="hidden" name="warnId"/>
	    <center>
	    <table cellpadding="5" border="1px">
		       <tr>
	    		<td>车牌号</td>
	            <td>
	            	<input class="easyui-combobox" id="carCombox" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="usenature" id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox" data-options="required:true" panelHeight="auto" size="10px"/>  
    				<input name="carId" id="carId" type="hidden"/>
	            	
	            </td>
        			<td>运用年</td>
	            	<td> <input class="easyui-textbox" type="text" name="checkyear" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td>运用月</td>
	            <td>
	            <input class="easyui-textbox" type="text" name="checkmonth" data-options="required:true">
	             </td>
        			<td>车况评分</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="carscore" data-options="required:true"></input>
	            </td>
	        </tr>
	       <tr>
    			<td >存在问题</td>
	            <td colspan="3"> <textarea style="width:200px;height:100px;visibility:hidden;" name="carquestion"></textarea></td>
	       		
	        </tr>
	         <tr>
    		
	       		<td >处理结果</td>
	            <td colspan="3"><textarea style="width:200px;height:100px;visibility:hidden;" name="results"></textarea></td>
	        </tr>
	         
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 55px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closebaoYangWarnEditForm1()">关闭</a>
	</div>
</div>
<script>
function doSearch_baoYangWarn(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#baoYangWarnList").datagrid({
	        title:'车辆保养提醒表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_baoYangWarn", url:'baoYangWarn/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'warnId', type:'hidden'},
	             	{field : 'carnumber', width : 100, align:'center', title : '车牌号'},
	             	{field : 'total', width : 100, align:'center', title : '行驶总里程'},
	             	{field : 'weihuname', width : 100, align : 'center', title : '维修项目'},
	             	{field : 'status', width : 100, align : 'center', title : '状态'}, 
	             	{field : 'formatbaoYangWarnList', width : 100, title : '车辆保养提醒详细信息', align:'center',formatter:formatbaoYangWarnList},
	             	{field : 'formatbaoYangedit', width : 60, title : '编辑', align:'center',formatter:formatbaoYangEdit}
	         ],  
	    });
	}
}
var send1AddEditor;
var send1AddEditor1;
var send2AddEditor;
var send2AddEditor1;
//格式化车辆保养提醒信息
function  formatbaoYangWarnList(value, row, index){ 
		return "<a href=javascript:openbaoYangWarn("+index+")>"+"车辆保养提醒详细信息"+"</a>";
};

function  formatbaoYangEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='baoYangWarn_edit()'><span style='color:blue'>编辑</span></a>";
};

//根据index拿到该行值
function onbaoYangWarnClickRow(index) {
	var rows = $('#baoYangWarnList').datagrid('getRows');
	return rows[index];
}

//打开车辆保养提醒信息对话框
function  openbaoYangWarn(index){ 
	var row = onbaoYangWarnClickRow(index);
	/* $("#baoYangWarnListWindow").dialog({
		onOpen :function(){
			$.get("baoYangWarn/get/"+row.warnId,'',function(data){
	    		//回显数据
	    		send1AddEditor = KindEditor.create("#baoYangWarnEditForm1 [name=carquestion]", TT.kingEditorParams);
    			send1AddEditor.html(data.carquestion);
    			send1AddEditor1 = KindEditor.create("#baoYangWarnEditForm1 [name=results]", TT.kingEditorParams);
    			send1AddEditor1.html(data.results);
	    		$("#baoYangWarnEditForm1").form("load",data);
	    	});
		},
		onBeforeClose: function (event, ui) {
			// 关闭Dialog前移除编辑器
		   	KindEditor.remove("#baoYangWarnEditForm1 [name=carquestion]");
			KindEditor.remove("#baoYangWarnEditForm1[name=results]");
			
		}
	}).dialog("open"); */
	$.get("baoYangWarn/updateStatus/"+row.warnId,'',function(data){
		$("#baoYangWarnList").datagrid("reload");
	});
};

/* 	function formatStatus(index){
		var row = onbaoYangWarnClickRow(index);
		$.get("baoYangWarn/updateStatus"+row.warnId,'',function(data){
			$("#baoYangWarnList").datagrid("reload");
		});
	} */
	//更新订单要求
	function updatebaoYangWarnNote(){
		$.get("baoYangWarn/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("baoYangWarn/update_note",$("#baoYangWarnNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#baoYangWarnNoteDialog").dialog("close");
    					$("#baoYangWarnList").datagrid("reload");
    					$.messager.alert("操作提示", "更新车辆保养提醒信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新车辆保养提醒信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getbaoYangWarnSelectionsIds(){
    	var baoYangWarnList = $("#baoYangWarnList");
    	var sels = baoYangWarnList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].warnId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function baoYangWarn_add(){
    	$.get("baoYangWarn/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#baoYangWarnAddWindow").window("open");
       		}
       	});
    }
    
    function baoYangWarn_edit(){
    	$.get("baoYangWarn/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getbaoYangWarnSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个车辆保养提醒信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个车辆保养提醒信息!');
               		return ;
               	}
               	$("#baoYangWarnEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#baoYangWarnList").datagrid("getSelections")[0];
               			send2AddEditor1.html(data.carquestion);
               			send2AddEditor1.html(data.results);
               			$("#baoYangWarnEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getbaoYangWarnSelectionsNames(){
    	var baoYangWarnList = $("#baoYangWarnList");
    	var sels = baoYangWarnList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].typename);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function baoYangWarn_delete(){
    	$.get("baoYangWarn/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getbaoYangWarnSelectionsNames();
      			var ids = getbaoYangWarnSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中车辆保养提醒!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除车辆保养提醒为 '+names+' 的车辆保养提醒信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("baoYangWarn/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除车辆保养提醒成功!',undefined,function(){
                  					$("#baoYangWarnList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closebaoYangWarnEditForm(){
					$("#baoYangWarnListWindow").window('close');
					$("#baoYangWarnEditForm").datagrid("reload");
	}
    
    function baoYangWarn_reload(){
    	$("#baoYangWarnList").datagrid("reload");
    }
    
    $('#carCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>