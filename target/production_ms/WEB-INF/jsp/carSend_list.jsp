<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" src="js/jquery.jqprint-0.3.js"></script> 
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
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>  
<script type="text/javascript" src="js/LodopFuncs.js"></script>
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	    <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop32.exe"/>
	</object>
	<span id="install"></span>
<table class="easyui-datagrid" id="carSendList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carSend/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carSend">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'sendnums',width:100,align:'center'">派车编号</th>
        	<th data-options="field:'chepai',align:'center',width:70,formatter:formatChepai">车牌号</th>
            <th data-options="field:'usercarpeople',align:'center',width:110">用车人</th>
            <th data-options="field:'dep',align:'center',width:100,formatter:formatDep">用车单位</th>
            <th data-options="field:'sdate',align:'center',width:80,formatter:TAOTAO.formatDate">日期</th>
            <th data-options="field:'formatKM',align:'center',width:100,formatter:formatKM">行走公里</th>
            <th data-options="field:'drivername',align:'center',width:80,formatter:formatDriver">驾驶员</th>
            <th data-options="field:'sendList',width:130,align:'center',formatter:formatSendList">派车单详细信息</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carSend" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carSend:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carSend_add()">审批派单</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carSend:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carSend_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carSend:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carSend_delete()">删除</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carSend:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carSend_nowadd()">直接派单</a>  
		    </div>  
		</c:if>
	</c:forEach>
	  
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carSend_print()">打印</a>  
		    </div>  
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carSend_reload()">刷新</a>  
	</div> 
	<div id="search_carSend" style="float: right;">
        <input id="search_text_carSend" class="easyui-searchbox"  
            data-options="searcher:doSearch_carSend,prompt:'请输入...',menu:'#menu_carSend'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carSend" style="width:120px"> 
			<div data-options="name:'s1'">车牌号</div>
			<div data-options="name:'s2'">审核编号</div> 
			<div data-options="name:'s3'">驾驶员</div>
		</div>     
    </div>  
</div>  

<div id="carSendEditWindow" class="easyui-window" title="修改派车单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSend/edit'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="carSendAddWindow" class="easyui-window" title="新增审批派车单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSend/add'" style="width:850px;height:600px;padding:10px;">
</div>
<div id="carNowSendAddWindow" class="easyui-window" title="新增直接派车单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSend/nowadd'" style="width:850px;height:600px;padding:10px;">
</div>

<div id="carSendInfo1" class="easyui-dialog" title="派车单详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:850px;height:600px;padding:10px;">
	<form id="sendEditForm1" method="post">					
		<input type="hidden" name="sendId"/>
	   <center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
					<td colspan="4" style="text-align:center">
						<h3>济南铁路局济南通信段派车单</h3>
					</td>
				</tr>
				<tr>
					<td width="auto" bgcolor="#F0F8FF" align="right">派车编号</td>
					<td width="auto"><input class="easyui-textbox" editable="false" type="text" name="sendnums"></input>
					</td>
					<td width="auto" bgcolor="#F0F8FF" align="right">日期</td>
					<td width="auto"><input class="easyui-datebox" name="sdate"
						data-options="required:true,showSeconds:true"
						value="date.format('yyyy-MM-dd hh:mm:ss')" style="width: 150px"></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">用车单位</td>
					<td><input
						class="easyui-textbox" id="6xxdepartment669" panelHeight="auto" name="departmentName" editable="false"
						 /> <input name="departmentId" id="departmentId669"
						type="hidden" /></td>

					<td bgcolor="#F0F8FF" align="right">车牌号</td>
					<td><input class="easyui-textbox"
						id="xjzcarCombox669" data-options="required:true" name="usenature" editable="false"
						panelHeight="auto" size="9px" /> <input id="usenature669" type="hidden" /> 
						<input class="easyui-textbox"
						id="xjzcarNumberCombox669" data-options="required:true" name="carnumber" editable="false"
						panelHeight="auto" size="10px" /> <input name="carId" id="carId669"
						type="hidden" /></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">派车人</td>
					<td><input class="easyui-textbox" name="senduser" editable="false"/>
					</td>
					<td bgcolor="#F0F8FF" align="right">用车人</td>
					<td><input class="easyui-textbox" name="usercarpeople" editable="false"/>
					</td>

				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">汽车驾驶员</td>
					<td><input class="easyui-textbox" name="drviername" editable="false"/></td>
					<td bgcolor="#F0F8FF" align="right">第一责任人</td>
					<td><input class="easyui-textbox" name="firstduty" editable="false" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">特殊情况领导审批</td>
					<td><input class="easyui-textbox" type="text" name="notes" editable="false"></input>
					</td>
					<td bgcolor="#F0F8FF" align="right">安全监督岗</td>
					<td><input class="easyui-textbox" type="text" name="safe" editable="false"></input>
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">出车时间</td>
					<td><input class="easyui-datetimebox" name="senddate"
						data-options="required:true,showSeconds:true"
						value="date.format('yyyy-MM-dd')" style="width: 150px"></td>
					<td bgcolor="#F0F8FF" align="right">返回时间</td>
					<td><input class="easyui-datetimebox" name="endcardate"
						data-options="required:true,showSeconds:true"
						value="date.format('yyyy-MM-dd')" style="width: 150px">
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">行走公里</td>
					<td colspan="3">开始&nbsp;<input class="easyui-numberbox"
						 name="firstkm" data-options="required:true"
						size="25">&nbsp;公里 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						结束&nbsp;<input class="easyui-numberbox" 
						name="endkm" size="25">公里
					</td>
				</tr>

					<tr rowspan="2">
					<td bgcolor="#F0F8FF" align="right">注意事项</td>
					<td colspan="3"><textarea 
							style="width:500px; height:50px;" editable="false"
							  name="note"></textarea></td>
				</tr>

				<tr>
					<td bgcolor="#F0F8FF" align="right">任务地点及路线</td>
					 <td colspan="3"><textarea 
							style="width:500px; height:100px;" editable="false"
							  name="road"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align:center">
						<h3>驾驶员三检记录</h3>
					</td>
				</tr>
				<tr>
						<td bgcolor="#F0F8FF" align="right">天气</td>
					<td colspan="3"><input class="easyui-textbox" type="text" name="tianqi" editable="false"></input>
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">出车</td>
					<td colspan="3">出车前<input class="easyui-textbox"
						name="chucheq" size="16" editable="false">
						&nbsp;行驶中<input class="easyui-textbox" name="xingshiz"
						size="16" editable="false"> &nbsp;收车后<input
						class="easyui-textbox" name="shoucheh" editable="false"
						 size="16"></td>
				</tr>
			</table>
		</center>
	</form>
</div>
<script type="text/javascript">
function doSearch_carSend(value,name){ //用户输入用户名,点击搜素,触发此函数  
	
	if(value == null || value == ''){
		$("#carSendList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSend", url:'carSend/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'sendnums', width : 100, title : '派车编号', align:'center'},
	             	{field : 'chepai', width : 70, align:'center',title : '车牌号',formatter:formatChepai},
	             	{field : 'usercarpeople', width : 110, align : 'center', title : '用车人'},
	             	{field : 'dep', width : 100, align : 'center', title : '用车单位',formatter:formatDep}, 
	             	{field : 'sdate', width : 80, title : '日期', align:'center',formatter:TAOTAO.formatDate}, 
	             	{field : 'formatKM',align:'center',width:100,title : '行走公里',formatter:formatKM}, 
	            	{field : 'drivername', width : 80, title : '驾驶员', align:'center',formatter:formatDriver}, 
	             	{field : 'sendList', width : 130, title : '派车单详细信息', align:'center',formatter:formatSendList}
	        ] ],  
	    });
	}else{
		$("#carSendList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSend", url:'carSend/search_carSend_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
             	{field : 'sendnums', width : 100, title : '派车编号', align:'center'},
             	{field : 'chepai', width : 70, align:'center',title : '车牌号',formatter:formatChepai},
             	{field : 'usercarpeople', width : 110, align : 'center', title : '用车人'},
             	{field : 'dep', width : 100, align : 'center', title : '用车单位',formatter:formatDep}, 
             	{field : 'sdate', width : 80, title : '日期', align:'center',formatter:TAOTAO.formatDate}, 
             	{field : 'formatKM',align:'center',width:100,title : '行走公里',formatter:formatKM}, 
            	{field : 'drivername', width : 80, title : '驾驶员', align:'center',formatter:formatDriver}, 
             	{field : 'sendList', width : 130, title : '派车单详细信息', align:'center',formatter:formatSendList}
	        ] ],  
	    });
	}

}
				var send1AddEditor3;
				var send2AddEditor3;
	 function  formatChepai(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.carRegister.carnumber+"";
	    	}
		};
		function  formatDep(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.department.departmentName+"";
	    	}
		};
		function  formatDriver(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.carDriver.drviername+"";
	    	}
		};
	function  formatSendList(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return "<a href=javascript:openSendList("+index+")>"+"派车单详细信息"+"</a>";
    	}
	};
	function  formatKM(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		if(row.endkm==null || row.endkm=='' ){
    			return '<span style="color:red;">派车未归或未填结束里程</span>';
    		}else{
    			return ""+row.endkm-row.firstkm+"&nbsp;公里";
    		}
    	}
	};
	  function getCarSendSelectionsIds(){
	    	var carSendList = $("#carSendList");
	    	var sels = carSendList.datagrid("getSelections");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].sendId);
	    	}
	    	ids = ids.join(","); 
	    	
	    	return ids;
	    }
	    
	//根据index拿到该行值
	function onCarSendClickRow(index) {
		var rows = $('#carSendList').datagrid('getRows');
		return rows[index];
	}
	
	function  openSendList(index){ 
		var row = onCarSendClickRow(index);
		$("#carSendInfo1").dialog({
    		onOpen :function(){
    			$.get("carSend/get/"+row.sendId,'',function(data){
    				
    				data.carId = data.carRegister.carId;
    				data.usenature = data.carRegister.usenature;
    				data.carnumber = data.carRegister.carnumber;
    				data.departmentId = data.department.departmentId;
    				data.departmentName = data.department.departmentName;
    				data.drviername = data.carDriver.drviername;
    				data.senddate = TAOTAO.formatDateTime(data.senddate);
    				data.endcardate = TAOTAO.formatDateTime(data.endcardate);
    				data.sdate = TAOTAO.formatDateTime(data.sdate);
		    		//回显数据
		    		$("#sendEditForm1").form("load",data);
    	    	});
    		},
    	}).dialog("open");
	};
	
	//更新信息要求
	function updateCarSendNote(){
		$.get("carSend/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carSendNoteEditor.sync();
    			$.post("carSend/update_note",$("#carSendNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carSendNoteDialog").dialog("close");
    					$("#carSendList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
			
  
    function carSend_add(){
    	$.get("carSend/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carSendAddWindow").window("open");
       		}
       	});
    }
    
    function carSend_nowadd(){
    	$.get("carSend/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carNowSendAddWindow").window("open");
       		}
       	});
    }
    
    function carSend_edit(){
    	$.get("carSend/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarSendSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carSendEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			debugger;
               			var data = $("#carSendList").datagrid("getSelections")[0];
               			data.carId = data.carRegister.carId;
        				data.usenature = data.carRegister.usenature;
        				data.carnumber = data.carRegister.carnumber;
        				data.departmentId = data.department.departmentId;
        				//if(data.department.level=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else if(data.department.level=='2'){
            				if(data.department.level=='2'){
            			//	data.fathername="汽车队";
            				data.fdepartmentName = data.department.departmentName;
            			}else{
            				data.departmentName = data.department.departmentName;
            			}
        				data.driverId = data.carDriver.driverId;
        				data.senddate = TAOTAO.formatDateTime(data.senddate);
        				data.endcardate = TAOTAO.formatDateTime(data.endcardate);
        				data.sdates = TAOTAO.formatDateTime(data.sdate);
        				send2AddEditor3.html(data.road);
        				$("#carSendEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    /*
   function carSend_print(){
       			var ids = getCarSendSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能打印!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	$("#carSendPrintWindow11").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carSendList").datagrid("getSelections")[0];
               			data.applyId = data.carApply.applyId;
               			data.carId = data.carRegister.carId;
        				data.usenature = data.carRegister.usenature;
        				data.carnumber = data.carRegister.carnumber;
        				data.departmentId = data.department.departmentId;
        				data.departmentName = data.department.departmentName;
        				data.driverId = data.carDriver.driverId;
        				data.senddate = TAOTAO.formatDateTime(data.senddate);
        				data.endcardate = TAOTAO.formatDateTime(data.endcardate);
        				data.sdate = TAOTAO.formatDateTime(data.sdate);
        				$("#carSendPrintForm11").form("load", data);
               		}
               	}).window("open");
        	}*/
    function getCarSendSelectionsNames(){
    	var carSendList = $("#carSendList");
    	var sels = carSendList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carRegister.carnumber);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carSend_delete(){
    	$.get("carSend/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarSendSelectionsNames();
      			var ids = getCarSendSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除车牌号 '+names+'的派车信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carSend/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carSendList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
   
    function carSend_reload(){
    	$("#carSendList").datagrid("reload");
    }

//打印
function carSend_print(){
	var ids = getCarSendSelectionsIds();
   	if(ids.length == 0){
   		$.messager.alert('提示','必须选择一个信息才能打印!');
   		return ;
   	}
   	if(ids.indexOf(',') > 0){
   		$.messager.alert('提示','只能选择一个信息!');
   		return ;
   	}
		//window.location="${ctx}/src/contract/dayin?remId="+remId+"&agrType=${agrType}";
		LODOP = getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
		LODOP.PRINT_INIT("派车单信息");
		LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
		LODOP.ADD_PRINT_URL(20,50,1000,700,"carSend/get1/"+ids);
		LODOP.SET_SHOW_MODE("LANDSCAPE_DEFROTATED",1);//横向时的正向显示
		LODOP.SET_PREVIEW_WINDOW(2,0,0,0,0,""); //按适宽模式显示
		LODOP.PREVIEW();
}


</script>

