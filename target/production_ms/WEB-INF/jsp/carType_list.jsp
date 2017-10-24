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
<table class="easyui-datagrid" id="carTypeList" title="车型列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carType/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carType">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'typename',width:100,align:'center'">车型名称</th>
        	<th data-options="field:'brand',align:'center',width:100">车辆品牌</th>
            <th data-options="field:'carxh',align:'center',width:100">车辆型号</th>
            <th data-options="field:'engineid',align:'center',width:100">发动机号</th>
            <th data-options="field:'carcd',align:'center',width:100">车辆产地</th>
            <th data-options="field:'factory',width:100,align:'center'">制造厂名称</th>
            <th data-options="field:'fueltype',width:60,align:'center'">燃料种类</th>
            <th data-options="field:'carquality',width:130,align:'center'">总质量</th>
            <th data-options="field:'checknums',width:70,align:'center'">核定载客(位)</th>
            <th data-options="field:'formatCarTypeList',width:130,align:'center',formatter:formatCarTypeList">车型详细信息</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carType" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carType:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carType_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carType:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carType_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carType:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carType_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carType_reload()">刷新</a>  
	</div> 
</div>  

<div id="carTypeEditWindow" class="easyui-window" title="编辑车型信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carType/edit'" style="width:700px;height:550px;padding:10px;">
</div>
<div id="carTypeAddWindow" class="easyui-window" title="添加车型信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carType/add'" style="width:700px;height:550px;padding:10px;">
</div>
<div id="carTypeListWindow" class="easyui-dialog" title="车型详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:700px;height:550px;padding:10px;">
	<form id="carTypeEditForm41" method="post">
		<input type="hidden" name="typeid"/>
	    <center>
	   	<table class="border-table" cellpadding="5" align="center">
		     <tr>
	    			<td width="auto"  bgcolor="#F0F8FF" align="right">车型名称</td>
		            <td width="auto" ><input class="easyui-textbox" type="text" name="typename" data-options="required:true"> </td>
	        			<td width="auto"  bgcolor="#F0F8FF" align="right">国产/进口:</td>
		            	<td width="auto"  ><select id="cc" class="easyui-combobox" name="carcd" panelHeight="auto" data-options="required:true, width:150, editable:false">
		            		<option value="国产">国产</option>
		            		<option value="进口">进口</option>
		            	</select> </td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">车辆类型</td>
	           <td> <input class="easyui-textbox" type="text" name="ctype" data-options="required:true"></input>
	              </td>
        			<td bgcolor="#F0F8FF" align="right">车辆品牌</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="brand" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">车辆型号</td>
	            <td><input class="easyui-textbox" type="text" name="carxh" data-options="required:true"> </td>
	       		<td bgcolor="#F0F8FF" align="right">驾驶室载客</td>
	            <td><input class="easyui-textbox" type="text" name="cabnums" size="17">&nbsp;人</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">发动机号</td>
	            <td><input class="easyui-textbox" type="text" name="engineid"> </td>
        			<td bgcolor="#F0F8FF" align="right">发动机型号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="enginexh"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">燃料种类</td>
	            <td><input class="easyui-textbox" type="text" name="fueltype"> </td>
        		<td bgcolor="#F0F8FF" align="right">排量/功率</td>
	            <td>
	            	<input class="easyui-numberbox"  type="text" name="pailiang" size="4" >ml/&nbsp;</input>
	            	<input class="easyui-numberbox" type="text" name="power" size="4" >Kw</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">制造厂名称</td>
	            <td><input class="easyui-textbox" type="text" name="factory"> </td>
        		<td bgcolor="#F0F8FF" align="right">转向形式</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="turnxs" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">轮距</td>
	            <td>前&nbsp;<input class="easyui-numberbox" type="text" name="frontlunju" size="4" ></input>
	            	后&nbsp;<input class="easyui-numberbox" type="text" name="afterlunju" size="4" >&nbsp;mm</input> </td>
        		<td bgcolor="#F0F8FF" align="right">轮胎数</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tirenum" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">轮胎规格</td>
	           <td><input class="easyui-textbox" type="text" name="fronttiregg"></input></td>
        		<td bgcolor="#F0F8FF" align="right">钢板弹簧片数数</td>
	            <td>
	            	&nbsp;后轴&nbsp;<input class="easyui-numberbox" type="text" name="gbthps" size="5" >&nbsp;数</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">轴距</td>
	            <td><input class="easyui-numberbox" type="text" name="zhouju" size="17">&nbsp;mm</td>
        		<td bgcolor="#F0F8FF" align="right">轴数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="zhoushu" ></input>
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">外廓尺寸</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-numberbox" type="text" name="carwlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-numberbox" type="text" name="carwwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-numberbox" type="text" name="carwhigh" size="14">&nbsp;mm</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">货箱内部尺寸</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-numberbox" type="text" name="carnlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-numberbox" type="text" name="carnwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-numberbox" type="text" name="carnhigh" size="14">&nbsp;mm</td>
	        </tr>
	       <tr>
    			<td bgcolor="#F0F8FF" align="right">总质量</td>
	            <td><input class="easyui-numberbox" type="text" name="carquality" size="17">&nbsp;kg</td>
        		<td bgcolor="#F0F8FF" align="right">核定载质量</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="carcheckquality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	        <tr> 
    			<td bgcolor="#F0F8FF" align="right">核定载客</td>
	            <td><input class="easyui-numberbox" type="text" name="checknums" size="17">&nbsp;人</td>
        		<td bgcolor="#F0F8FF" align="right">牵引总质量</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="tractionquality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 55px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeCarTypeEditForm()">关闭</a>
	</div>
</div>
<script>
function doSearch_carType(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carTypeList").datagrid({
	        title:'车型列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carType", url:'carType/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'typeid', type:'hidden'},
	             	{field : 'typename', width : 100, title : '车型名称', align:'center'}, 
	             	{field : 'brand', width : 100, align:'center', title : '车辆品牌'},
	             	{field : 'carxh', width : 100, align : 'center', title : '车辆型号'},
	             	{field : 'engineid', width : 100, align : 'center', title : '发动机号'}, 
	             	{field : 'carcd', width : 100, title : '车辆产地', align:'center'}, 
	            	{field : 'factory', width : 100, title : '制造厂名称', align:'center'}, 
	             	{field : 'fueltype', width : 60, title : '燃料种类', align:'center'}, 
	             	{field : 'carquality', width : 130, title : '总质量', align:'center'}, 
	             	{field : 'checknums', width : 70, title : '核定载客(位)', align:'center'}, 
	             	{field : 'formatCarTypeList', width : 100, title : '车型详细信息', align:'center',formatter:formatCarTypeList}
	        ] ],  
	    });
	}
}

//格式化车型信息
function  formatCarTypeList(value, row, index){ 
		return "<a href=javascript:openCarType("+index+")>"+"车型详细信息"+"</a>";
};

//根据index拿到该行值
function onCarTypeClickRow(index) {
	var rows = $('#carTypeList').datagrid('getRows');
	return rows[index];
}

//打开车型信息对话框
function  openCarType(index){ 
	var row = onCarTypeClickRow(index);
	$("#carTypeListWindow").dialog({
		onOpen :function(){
			$.get("carType/get/"+row.typeid,'',function(data){
	    		//回显数据
	    		$("#carTypeEditForm41").form("load",data);
	    	});
		},
	}).dialog("open");
};

	//更新订单要求
	function updateCarTypeNote(){
		$.get("carType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			$.post("carType/update_note",$("#carTypeNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carTypeNoteDialog").dialog("close");
    					$("#carTypeList").datagrid("reload");
    					$.messager.alert("操作提示", "更新车型信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新车型信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getCarTypeSelectionsIds(){
    	var carTypeList = $("#carTypeList");
    	var sels = carTypeList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].typeid);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function carType_add(){
    	$.get("carType/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carTypeAddWindow").window("open");
       		}
       	});
    }
    
    function carType_edit(){
    	$.get("carType/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarTypeSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个车型信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个车型信息!');
               		return ;
               	}
               	$("#carTypeEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carTypeList").datagrid("getSelections")[0];
               			$("#carTypeEditForm15").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarTypeSelectionsNames(){
    	var carTypeList = $("#carTypeList");
    	var sels = carTypeList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].typename);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carType_delete(){
    	$.get("carType/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarTypeSelectionsNames();
      			var ids = getCarTypeSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中车型!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除车型为 '+names+' 的车型信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carType/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除车型成功!',undefined,function(){
                  					$("#carTypeList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    function closeCarTypeEditForm(){
					$("#carTypeListWindow").window('close');
					$("#carTypeEditForm41").datagrid("reload");
	}
    
    function carType_reload(){
    	$("#carTypeList").datagrid("reload");
    }
</script>