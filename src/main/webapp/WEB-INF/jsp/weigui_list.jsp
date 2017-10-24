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
<table class="easyui-datagrid" id="weiguiList" title="违规记录表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'weigui/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_weigui">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
	      	<th data-options="field:'car1',align:'center',width:100,formatter:formatcar1">车牌号</th>
	      	<th data-options="field:'formatdsp1',align:'center',width:100,formatter:formatDsp1">所在部门</th>
        	<th data-options="field:'weiguitime',align:'center',width:100,formatter:TAOTAO.formatDate">违规时间</th>
            <th data-options="field:'xingwei',width:100,align:'center'">违规行为</th>
            <th data-options="field:'score',align:'center',width:100">积分</th>
            <th data-options="field:'money',align:'center',width:100">罚款金额</th>
            <th data-options="field:'driver1',align:'center',width:100,formatter:formatdr1">主车司机</th>
            <th data-options="field:'chuliname',width:100,align:'center'">处理人</th>
            <th data-options="field:'formatweiguiList',width:100,align:'center',formatter:formatweiguiList">详细信息</th>
            <th data-options="field:'weiguiEdit',align:'center',width:50,formatter:formatWeiguiEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_weigui" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='weigui:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="weigui_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='weigui:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="weigui_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='weigui:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="weigui_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="weigui_reload()">刷新</a>  
	</div> 
</div>  

<div id="weiguiEditWindow" class="easyui-window" title="编辑违规记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'weigui/edit'" style="width:500px;height:480px;padding:25px;">
</div>
<div id="weiguiAddWindow" class="easyui-window" title="添加违规记录信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'weigui/add'" style="width:500px;height:480px;padding:25px;">
</div>
<div id="weiguiListWindow" class="easyui-dialog" title="违规记录详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:500px;height:480px;padding:25px;">
	<form id="weiguiEditForm" method="post">
		<input type="hidden" name="weiguiId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
		      <tr>
	            <td width="110px" bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td width="auto" >
	             	<input class="easyui-combobox" id="carCombox3510" name="usenature" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input  id="usenature567" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox3510" name="carnumber1" data-options="required:true" panelHeight="auto" size="10px"/>  
    				<input name="carnumber" id="carId567" type="hidden"/>
	             </td>
	             </tr>
        		<tr>
        		<td  bgcolor="#F0F8FF" align="right">违规时间</td>
	       		<td>
	       			<input class="easyui-datetimebox" name="weiguitime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">违规地点</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="place"></input>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">违规行为</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="xingwei"></input>
	            </td>
	        </tr>
	        <tr>
    		
    			<td bgcolor="#F0F8FF" align="right">积分</td>
	            <td>
	            	<input class="easyui-numberbox" precision="1" type="text" name="score"></input>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">罚款金额</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="money"></input>
	            </td>
	             
	       		
	        </tr>
	         <tr>
    		
    			<td bgcolor="#F0F8FF" align="right">是否交款</td>
	            <td>
	            	<select id="issend" class="easyui-combobox" name="issend" panelHeight="auto" 
	            		data-options="required:true,width:150, editable:false">
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">主车司机</td>
	            <td>
	            	<input class="easyui-textbox" name="drivername"   editable="false" />
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">处理人</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="chuliname" ></input>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">处理时间</td>
	            <td>
	       			<input class="easyui-datetimebox" name="chulitime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 380px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeweiguiEditForm()">关闭</a>
	</div>
</div>
<script>
function doSearch_weigui(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#weiguiList").datagrid({
	        title:'违规记录表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_weigui", url:'weigui/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'car1', width : 100, align:'center', title : '车牌号',formatter:formatcar1},
	             	{field : 'weiguitime', width : 100, align:'center', title : '违规时间',formatter:TAOTAO.formatDateTime},
	             	{field : 'xingwei', width : 100, align : 'center', title : '违规行为'}, 
	             	{field : 'score', width : 100, title : '积分', align:'center'}, 
	            	{field : 'money', width : 100, title : '罚款金额', align:'center'},
	            	{field : 'driver1', width : 100, title : '主车司机', align:'center',formatter:formatdr1},
	             	{field : 'chuliname', width : 100, title : '处理人', align:'center'}, 
	            	{field : 'formatweiguiList', width : 100, title : '违规记录详细信息', align:'center',formatter:formatweiguiList}
	         ],  
	    });
	}
}

function  formatWeiguiEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='weigui_edit()'><span style='color:blue'>编辑</span></a>";
};
//格式化违规记录记录信息
function  formatweiguiList(value, row, index){ 
		return "<a href=javascript:openweigui("+index+")>"+"违规记录详细信息"+"</a>";
};
function  formatdr1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carDriver.drviername+"";
	}
};
function  formatDsp1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function  formatcar1(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
//根据index拿到该行值
function onweiguiClickRow(index) {
	var rows = $('#weiguiList').datagrid('getRows');
	return rows[index];
}

//打开违规记录记录信息对话框
function  openweigui(index){ 
	var row = onweiguiClickRow(index);
	$("#weiguiListWindow").dialog({
		onOpen :function(){
			$.get("weigui/get/"+row.weiguiId,'',function(data){
	    		//回显数据
    			data.weiguitime = TAOTAO.formatDateTime(data.weiguitime);
	    		data.chulitime = TAOTAO.formatDateTime(data.chulitime);
	    		data.drivername = data.carDriver.drviername;
	    		data.carnumber1 = data.carRegister.carnumber;
				data.usenature = data.carRegister.usenature;
				data.carId = data.carRegister.carId;
	    		$("#weiguiEditForm").form("load",data);
	    	});
		},
		onBeforeClose: function (event, ui) {
			
			
		}
	}).dialog("open");
};

	//更新订单要求
	function updateweiguiNote(){
		$.get("weigui/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("weigui/update_note",$("#weiguiNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#weiguiNoteDialog").dialog("close");
    					$("#weiguiList").datagrid("reload");
    					$.messager.alert("操作提示", "更新违规记录信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新违规记录信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getweiguiSelectionsIds(){
    	var weiguiList = $("#weiguiList");
    	var sels = weiguiList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].weiguiId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function weigui_add(){
    	$.get("weigui/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#weiguiAddWindow").window("open");
       		}
       	});
    }
    
    function weigui_edit(){
    	$.get("weigui/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getweiguiSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个违规记录信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个违规记录信息!');
               		return ;
               	}
               	$("#weiguiEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#weiguiList").datagrid("getSelections")[0];
               			data.weiguitime = TAOTAO.formatDateTime(data.weiguitime);
        	    		data.chulitime = TAOTAO.formatDateTime(data.chulitime);
        	    		data.drivername = data.carDriver.driverId;
        	    		data.carnumber1 = data.carRegister.carnumber;
        				data.usenature = data.carRegister.usenature;
        				data.carnumber = data.carRegister.carId;
               			$("#weiguiEditForm1").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getweiguiSelectionsNames(){
    	var weiguiList = $("#weiguiList");
    	var sels = weiguiList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].typename);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function weigui_delete(){
    	$.get("weigui/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getweiguiSelectionsNames();
      			var ids = getweiguiSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中违规记录!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除该违规记录信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("weigui/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除违规记录成功!',undefined,function(){
                  					$("#weiguiList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closeweiguiEditForm(){
					$("#weiguiListWindow").window('close');
					$("#weiguiEditForm").datagrid("reload");
	}
    
    function weigui_reload(){
    	$("#weiguiList").datagrid("reload");
    }
    
 
</script>