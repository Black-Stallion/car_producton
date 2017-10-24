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
<table class="easyui-datagrid" id="carTechnicalList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carTechnical/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carTechnical">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'driverfrom',width:100,align:'center'">驱动形式</th>
        	<th data-options="field:'typename',align:'center',width:100,formatter:formatCarType">车型名称</th>
            <th data-options="field:'highpapo',align:'center',width:100">最大爬坡能力</th>
            <th data-options="field:'dianhuocx',align:'center',width:100">点火次序</th>
            <th data-options="field:'yasuobi',align:'center',width:100">压缩比</th>
            <th data-options="field:'ranyoucl',width:100,align:'center'">燃油贮油量</th>
            <th data-options="field:'dianchixh',width:60,align:'center'">电池型号</th>
            <th data-options="field:'hundredsfuel',width:130,align:'center'">百公里耗油</th>
            <th data-options="field:'formatTList',width:130,align:'center',formatter:formatTList">查看详细信息</th>
            <th data-options="field:'carTechnicalEdit',align:'center',width:50,formatter:formatCarTechnicalEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carTechnical" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carTechnical:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carTechnical_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carTechnical:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carTechnical_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carTechnical:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carTechnical_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carTechnical_reload()">刷新</a>  
	</div> 
</div>  

<div id="carTechnicalEditWindow" class="easyui-window" title="编辑信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carTechnical/edit'" style="width:660px;height:380px;padding:10px;">
</div>
<div id="carTechnicalAddWindow" class="easyui-window" title="添加信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carTechnical/add'" style="width:660px;height:380px;padding:10px;">
</div>

<div id="TWindow1" class="easyui-dialog" title="技术特性信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:660px;height:350px;padding:10px;">
	<form id="TForm" method="post">					
		<input type="hidden" name="technicalId"/>
		<center>
	     <table class="border-table" cellpadding="5" align="center">
		     <tr>
	    			<td width="auto"  bgcolor="#F0F8FF">车型名称</td>
		            <td width="auto" colspan="3">
	            	<input class="easyui-combobox" name="typeid"   panelHeight="auto" 
    					data-options="valueField:'typeid',textField:'typename',
    						url:'carType/get_data', editable:false, required:true" />
    			</td>  
		      </tr>
	          <tr>
    			<td width="auto"  bgcolor="#F0F8FF">驱动形式</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="driverfrom" data-options="required:true"></input>
	             </td>
        			<td width="auto"  bgcolor="#F0F8FF">离地间隙</td>
	            <td width="auto" >
	            	<input class="easyui-numberbox" precision="2" type="text" name="lidijianxi" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">接近角</td>
	            <td><input class="easyui-textbox" type="text" name="jiejinjiao" data-options="required:true"> </td>
	       		<td bgcolor="#F0F8FF">离去角</td>
	            <td><input class="easyui-textbox" type="text" name="liqujiao" size="17">&nbsp;人</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF">最高车速</td>
	            <td><input class="easyui-numberbox" type="text" name="highspeed" size="15">  &nbsp;Km/n</td>
        			<td bgcolor="#F0F8FF">最大爬坡能力</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="highpapo"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">点火次序</td>
	            <td><input class="easyui-textbox" type="text" name="dianhuocx"> </td>
        		<td bgcolor="#F0F8FF">最小转弯半径</td>
	            	<td>车身<input class="easyui-numberbox" precision="2" type="text" name="turnbody" size="4" >&nbsp;m</input>
	            	车轮<input class="easyui-numberbox" precision="2" type="text" name="turntire" size="4" >&nbsp;m</input> </td>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">压缩比</td>
	            <td><input class="easyui-textbox" type="text" name="yasuobi"> </td>
        		<td bgcolor="#F0F8FF">轮胎气压</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tireqy" ></input>
	            </td>
	        </tr>
	       
	        <tr>
    			<td bgcolor="#F0F8FF">燃油箱贮油量</td>
	            <td><input class="easyui-textbox" type="text" name="ranyoucl" ></td>
        		<td bgcolor="#F0F8FF">蓄电池型号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="dianchixh" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">燃油标号</td>
	            <td><input class="easyui-textbox" type="text" name="ranyoubh" ></td>
        		<td bgcolor="#F0F8FF">百公里耗油</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="hundredsfuel" ></input>
	            </td>
	        </tr>
	    </table>
	     </center>
	    
	</form>
</div>
<script>
function doSearch_carTechnical(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carTechnicalList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carTechnical", url:'carTechnical/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field :'technicalId', type:'hidden'},
	             	{field : 'driverfrom', width : 100, title : '驱动形式', align:'center'},
	             	{field : 'typename', width : 100, align:'center',title : '车型名称',formatter:formatCarType},
	             	{field : 'highpapo', width : 100, align : 'center', title : '最大爬坡能力'},
	             	{field : 'dianhuocx', width : 100, align : 'center', title : '点火次序'}, 
	             	{field : 'yasuobi', width : 100, title : '压缩比', align:'center'}, 
	            	{field : 'ranyoucl', width : 100, title : '燃油贮油量', align:'center'}, 
	             	{field : 'dianchixh', width : 60, title : '电池型号', align:'center'}, 
	             	{field : 'hundredsfuel', width : 130, title : '百公里耗油', align:'center'},
	             	{field : 'formatTList', width : 100, title : '查看详细信息', align:'center',formatter:formatTList}
	        ] ],  
	    });
	}
}
function  formatCarTechnicalEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carTechnical_edit()'><span style='color:blue'>编辑</span></a>";
};
  //格式化车型信息
    function  formatCarType(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.carType.typename+"";
    	}
	};
	 //格式化车型信息
    function  formatTList(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return "<a href=javascript:openTechnical("+index+")>"+"查看详细信息"+"</a>";
    	}
	};
	
	//根据index拿到该行值
	function onCarTechnicalClickRow(index) {
		var rows = $('#carTechnicalList').datagrid('getRows');
		return rows[index];
	}
	
	
	function  openTechnical(index){ 
		var row = onCarTechnicalClickRow(index);
		$("#TWindow1").dialog({
    		onOpen :function(){
    			$.get("carTechnical/get/"+row.technicalId,'',function(data){
    				data.typeid = data.carType.typeid; 
		    		//回显数据
		    		$("#TForm").form("load",data);
    	    	});
    		},
    	}).dialog("open");
	};
	function submitCarTypeEditForm(){
		$.get("carType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#carTypeEditForm3').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("carType/update_all",$("#carTypeEditForm3").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改车型成功!','info',function(){
    						$("#carTechnicalInfo").dialog("close");
    						$("#carTechnicalList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//更新信息要求
	function updateCarTechnicalNote(){
		$.get("carTechnical/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carTechnicalNoteEditor.sync();
    			$.post("carTechnical/update_note",$("#carTechnicalNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carTechnicalNoteDialog").dialog("close");
    					$("#carTechnicalList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getCarTechnicalSelectionsIds(){
    	var carTechnicalList = $("#carTechnicalList");
    	var sels = carTechnicalList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].technicalId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carTechnical_add(){
    	$.get("carTechnical/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carTechnicalAddWindow").window("open");
       		}
       	});
    }
    
    function carTechnical_edit(){
    	$.get("carTechnical/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarTechnicalSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carTechnicalEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carTechnicalList").datagrid("getSelections")[0];
               			data.typeid = data.carType.typeid; 
               			$("#carTechnicalEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarTechnicalSelectionsNames(){
    	var carTechnicalList = $("#carTechnicalList");
    	var sels = carTechnicalList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].driverfrom);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carTechnical_delete(){
    	$.get("carTechnical/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarTechnicalSelectionsNames();
      			var ids = getCarTechnicalSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除驱动形式为 '+names+' 的信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carTechnical/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carTechnicalList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    
    function carTechnical_reload(){
    	$("#carTechnicalList").datagrid("reload");
    }
</script>