<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carApplyList" title="用车申请列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carApply/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carApply">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'bianhao',width:100,align:'center'">申请编号</th>
        	<th data-options="field:'car773',align:'center',width:50,formatter:formatCarNumber">申请车辆</th>
        	<th data-options="field:'applyname',align:'center',width:50">申请人</th>
        	<th data-options="field:'approve',align:'center',width:50">审批人</th>
            <th data-options="field:'departmentName',align:'center',width:60,formatter:formatDepartment">用车部门</th>
            <th data-options="field:'days',align:'center',width:50">天数(/天)</th>
            <th data-options="field:'outdriver',align:'center',width:40,formatter:formatCarDriver">出车司机</th>
            <th data-options="field:'people',align:'center',width:40">人数(/位)</th>
            <th data-options="field:'outtime',width:60,align:'center',formatter:TAOTAO.formatDate">出车时间</th>
            <th data-options="field:'thing',width:160,align:'center',formatter:formatCarThing">用车理由</th>
            <th data-options="field:'sta',width:60,align:'center',formatter:formatSN">申请结果</th>
            <th data-options="field:'applyEdit',width:50,align:'center',formatter:formatApplyEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carApply" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carApply:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carApply_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carApply:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carApply_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carApply:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carApply_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carApply_reload()">刷新</a>  
	</div> 
	<div id="search_carApply" style="float: right;">
        <input id="search_text_carApply" class="easyui-searchbox"  
            data-options="searcher:doSearch_carApply,prompt:'请输入...',menu:'#menu_carApply'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carApply" style="width:120px"> 
			<div data-options="name:'applyname'">申请人</div>
			<div data-options="name:'bianhao'">申请编号</div> 
			<div data-options="name:'dep'">所在部门</div>
		</div>     
    </div>
</div>  

<div id="carApplyEditWindow" class="easyui-window" title="修改用车申请" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carApply/edit'" style="width:800px;height:490px;padding:15px;">
</div>
<div id="carApplyAddWindow" class="easyui-window" title="新增用车申请" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carApply/add'" style="width:800px;height:490px;padding:15px;">
</div>

<script>
function doSearch_carApply(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carApplyList").datagrid({
	        title:'用车申请列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carApply", url:'carApply/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'bianhao', width : 100, title : '申请编号', align:'center'},
	             	{field : 'car773', width :50, title : '申请车辆', align:'center',formatter:formatCarNumber},
	             	{field : 'applyname', width : 50, align:'center',title : '申请人'},
	             	{field : 'approve', width : 50, align:'center',title : '审批人'},
	             	{field : 'departmentName', width : 60, align : 'center', title : '用车部门',formatter:formatDepartment},
	             	{field : 'days', width : 50, align : 'center', title : '天数(/天)'}, 
	             	{field : 'outdriver', width : 40, align : 'center', title : '出车司机',formatter:formatCarDriver}, 
	             	{field : 'people', width : 40, align : 'center', title : '人数(/位)'}, 
	             	{field : 'outtime', width : 60, title : '出车时间', align:'center',formatter:TAOTAO.formatDate}, 
	             	{field : 'thing', width : 160, title : '携带货物', align:'center',formatter:formatCarThing},
	             	{field : 'sta', width : 60, title : '申请结果', align:'center',formatter:formatSN},
	             	{field : 'applyEdit', width : 50, title : '编辑', align:'center',formatter:formatApplyEdit}
	        ] ],  
	    });
	}else{
		$("#carApplyList").datagrid({
	        title:'用车申请列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carApply", url:'carApply/search_carApply_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'bianhao', width : 100, title : '申请编号', align:'center'},
	             	{field : 'car773', width :50, title : '申请车辆', align:'center',formatter:formatCarNumber},
	             	{field : 'applyname', width : 50, align:'center',title : '申请人'},
	             	{field : 'approve', width : 50, align:'center',title : '审批人'},
	             	{field : 'departmentName', width : 60, align : 'center', title : '用车部门',formatter:formatDepartment},
	             	{field : 'days', width : 50, align : 'center', title : '天数(/天)'}, 
	             	{field : 'outdriver', width : 40, align : 'center', title : '出车司机',formatter:formatCarDriver}, 
	             	{field : 'people', width : 40, align : 'center', title : '人数(/位)'}, 
	             	{field : 'outtime', width : 60, title : '出车时间', align:'center',formatter:TAOTAO.formatDate}, 
	             	{field : 'thing', width : 160, title : '携带货物', align:'center',formatter:formatCarThing},
	             	{field : 'sta', width : 60, title : '申请结果', align:'center',formatter:formatSN},
	             	{field : 'applyEdit', width : 50, title : '编辑', align:'center',formatter:formatApplyEdit}
	        ] ],  
	    });
	}
}

  //格式化车型信息
    function  formatCarNumber(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.carRegister.carnumber+"";
    	}
	};
	 function  formatApplyEdit(value, row, index){ 
		 return "<a herf='#' style='cursor:pointer' plain='true' icon='icon-edit' onclick='carApply_edit()'><span style='color:blue'>编辑</span></a>";
		};
	//格式化车型信息
    function  formatNature(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.carRegister.usenature+"";
    	}
	};
	 function  formatDepartment(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.department.departmentName+"";
	    	}
		};
		
		 function  formatCarDriver(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		return ""+row.carDriver.drviername+"";
		    	}
			};
			function  formatCarThing(value, row, index){ 
			    	if(value !=null && value != ''){
						return ""+row.thing+"";
						}
			    	else{
			    		return '无';
			    	}
				};
				function  formatSN(value, row, index){ 
					if(value ==null && value == ''){
						return '无';}
					else{
						if(row.stats=="未通过" ){
							if(row.notes==null || row.notes==""){
								return '<span style="color:red;">'+row.stats+'(原因:无)'+'</span>';
							}else{
								return '<span style="color:red;">'+row.stats+'(原因：'+row.notes+')'+'</span>';
							}
							
						}else if(row.stats=="未审批"){
							return '<span style="color:red;">'+row.stats+'</span>';
						}else{
							return '<span style="color:green;">'+row.stats+'</span>';
						}
					}
				};
	 //格式化部门信息
 //   function  formatDepartment(value, row, index){ 
  //  		return ""+row.department.departmentName+"";
//	};
	//根据index拿到该行值
	function onCarApplyClickRow(index) {
		var rows = $('#carApplyList').datagrid('getRows');
		return rows[index];
	}
	
	function getCarApplySelectionsIds(){
    	var carApplyList = $("#carApplyList");
    	var sels = carApplyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].applyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	
	
	//更新信息要求
	function updateCarApplyNote(){
		$.get("carApply/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carApplyNoteEditor.sync();
    			$.post("carApply/update_note",$("#carApplyNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carApplyNoteDialog").dialog("close");
    					$("#carApplyList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    
    
    function carApply_add(){
    	$.get("carApply/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carApplyAddWindow").window("open");
       		}
       	});
    }
    function getSelectionsName(){
    	var carApplyList = $("#carApplyList");
    	var sels = carApplyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].stats);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carApply_edit(){
    	$.get("carApply/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var name = getSelectionsName();
       			var ids = getCarApplySelectionsIds();
       			
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}if(name==("通过")){
               		$.messager.alert('提示','该条信息已通过审核，不能被编辑!');
               		return;
               	}
               	$("#carApplyEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carApplyList").datagrid("getSelections")[0];
               			data.driverId = data.carDriver.driverId; 
               			data.applytime = TAOTAO.formatDateTime(data.applytime);
        				data.outtime = TAOTAO.formatDateTime(data.outtime);
        				data.carnumber = data.carRegister.carnumber;
        				data.usenature = data.carRegister.usenature;
        				data.carId = data.carRegister.carId;
        				data.departmentId = data.department.departmentId;
        				data.stats = '未审批';
        				//if(data.department.level=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else if(data.department.level=='2'){
            			if(data.department.level=='2'){
            				//data.fathername="汽车队";
            				data.fdepartmentName = data.department.departmentName;
            			}else{
            				data.departmentName = data.department.departmentName;
            			}
        				apply12Editor.html(data.thing);
               			$("#carApplyEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarApplySelectionsNames(){
    	var carApplyList = $("#carApplyList");
    	var sels = carApplyList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].applyname);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
   
    function carApply_delete(){
    	$.get("carApply/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarApplySelectionsNames();
      			var name = getSelectionsName();
      			var ids = getCarApplySelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	if(name.indexOf("通过")>=0){
               		$.messager.alert('提示','已通过申请的不能被删除!');
               		return;
               	}
              	$.messager.confirm('确认','确定删除 '+names+' 的申请吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carApply/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carApplyList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
	
    function carApply_reload(){
    	$("#carApplyList").datagrid("reload");
    }
</script>