<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carDriverList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carDriver/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carDriver">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'drviername',width:100,align:'center'">姓名</th>
        	<th data-options="field:'sex',align:'center',width:90,formatter:TAOTAO.formatSex">性别</th>
        	<th data-options="field:'birthday',align:'center',width:90,formatter:TAOTAO.formatDate">出生年月</th>
            <th data-options="field:'culture',align:'center',width:100">文化程度</th>
            <th data-options="field:'department31',align:'center',width:100,formatter:formatDepartment">所属部门</th>
            <th data-options="field:'cartype',align:'center',width:100">准驾车型</th>
            <th data-options="field:'drivernum',align:'center',width:100">驾驶证号</th>
            <th data-options="field:'worktime',width:80,align:'center',formatter:TAOTAO.formatDate">任职时间</th>
            <th data-options="field:'issueorgan',width:100,align:'center'">发证机关</th>
            <th data-options="field:'firstzheng',width:100,align:'center'">初次领证</th>
            <th data-options="field:'checktime',width:100,align:'center',formatter:TAOTAO.formatDate">通过考核时间</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carDriver" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carDriver:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carDriver_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='carDriver:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carDriver_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carDriver:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carDriver_delete()">删除</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='carDriver:upload' }" >
		<div style="float: left;">  
	 	 <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carDriver_upload()">导入数据</a>  
		    </div>  
		    </c:if>
	</c:forEach>
	 	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carDriver_reload()">刷新</a>  
	</div> 
	<div id="search_carDriver" style="float: right;">
        <input id="search_text_carDriver" class="easyui-searchbox"  
            data-options="searcher:doSearch_carDriver,prompt:'请输入...',menu:'#menu_carDriver'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carDriver" style="width:120px"> 
			<div data-options="name:'dd1'">司机名称</div>
			<div data-options="name:'dd2'">驾驶证号</div> 
		</div>     
    </div>
</div>  

<div id="carDriverEditWindow" class="easyui-window" title="编辑司机" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carDriver/edit'" style="width:700px;height:380px;padding:30px;">
</div>
<div id="carDriverAddWindow" class="easyui-window" title="添加司机" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carDriver/add'" style="width:700px;height:380px;padding:30px;">
</div>
<div id="carDriverUploadWindow" class="easyui-window" title="导入司机" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carDriver/upload1'" style="width:700px;height:380px;padding:30px;">
</div>

<script>
function doSearch_carDriver(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carDriverList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carDriver", url:'carDriver/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'drviername', width : 100, title : '姓名', align:'center'},
	             	{field : 'sex', width : 90, align:'center',title : '性别',formatter:TAOTAO.formatSex},
	             	{field : 'birthday', width : 90, align : 'center', title : '出生年月',formatter:TAOTAO.formatDate},
	             	{field : 'culture', width : 100, align : 'center', title : '文化程度'}, 
	             	{field : 'department31', width : 100, title : '所属部门', align:'center',formatter:formatDepartment}, 
	             	{field : 'cartype', width : 100, title : '准驾车型', align:'center'}, 
	            	{field : 'drivernum', width : 100, title : '驾驶证号', align:'center'}, 
	             	{field : 'worktime', width : 130, title : '任职时间', align:'center',formatter:TAOTAO.formatDate},
	             	{field : 'issueorgan', width : 130, title : '发证机关', align:'center'},
	             	{field : 'firstzheng', width : 130, title : '初次领证', align:'center'},
	             	{field : 'checktime', width : 130, title : '通过考核时间', align:'center',formatter:TAOTAO.formatDate}
	        ] ],  
	    });
	}else{
		$("#carDriverList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carDriver", url:'carDriver/search_carDriver_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'drviername', width : 100, title : '姓名', align:'center'},
	             	{field : 'sex', width : 100, align:'center',title : '性别',formatter:TAOTAO.formatSex},
	             	{field : 'birthday', width : 100, align : 'center', title : '出生年月',formatter:TAOTAO.formatDate},
	             	{field : 'culture', width : 100, align : 'center', title : '文化程度'},
	             	{field : 'department31', width : 60, title : '所属部门', align:'center',formatter:formatDepartment}, 
	             	{field : 'cartype', width : 100, title : '准驾车型', align:'center'}, 
	            	{field : 'drivernum', width : 100, title : '驾驶证号', align:'center'}, 
	             	{field : 'worktime', width : 130, title : '任职时间', align:'center',formatter:TAOTAO.formatDate},
	             	{field : 'issueorgan', width : 130, title : '发证机关', align:'center'},
	             	{field : 'firstzheng', width : 130, title : '初次领证', align:'center'},
	             	{field : 'checktime', width : 130, title : '通过考核时间', align:'center',formatter:TAOTAO.formatDate}
	        ] ],  
	    });	
	}
}

 
	 function  formatDepartment(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.department.departmentName+"";
	    	}
		};
	 //格式化部门信息
 //   function  formatDepartment(value, row, index){ 
  //  		return ""+row.department.departmentName+"";
//	};
	//根据index拿到该行值
	function onCarDriverClickRow(index) {
		var rows = $('#carDriverList').datagrid('getRows');
		return rows[index];
	}
	
	
	//打开车辆对话框
	function  openCarList(index){ 
		var row = onCarDriverClickRow(index);
		$("#carListWindow").dialog({
    		onOpen :function(){
    			$.get("carDriver/get/"+row.driverId,'',function(data){
		    		//回显数据
		    		data.birthday = TAOTAO.formatDateTime(data.birthday);
        			data.worktime = TAOTAO.formatDateTime(data.worktime);
        			data.checktime = TAOTAO.formatDateTime(data.checktime);
		    		$("#carDriver1EditForm").form("load",data);
    	    	});
    		},
    	}).dialog("open");
	};
	function getCarDriverSelectionsIds(){
    	var carDriverList = $("#carDriverList");
    	var sels = carDriverList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].driverId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	function submitCarTypeEditForm(){
		$.get("carType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#carTypeEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("carType/update_all",$("#carTypeEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改司机成功!','info',function(){
    						$("#carDriverInfo").dialog("close");
    						$("#carDriverList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	//修改车辆信息
	function submitCarEditForm(){
		$.get("carDriver/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#carEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("carDriver/update_all",$("#carEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改车辆成功!','info',function(){
    						$("#carListWindow").dialog("close");
    						$("#carDriverList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//更新信息要求
	function updateCarDriverNote(){
		$.get("carDriver/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carDriverNoteEditor.sync();
    			$.post("carDriver/update_note",$("#carDriverNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carDriverNoteDialog").dialog("close");
    					$("#carDriverList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    
    
    function carDriver_add(){
    	$.get("carDriver/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carDriverAddWindow").window("open");
       		}
       	});
    }
    function carDriver_upload(){
       			$("#carDriverUploadWindow").window("open");
    }
    
    function carDriver_edit(){
    	$.get("carDriver/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarDriverSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carDriverEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carDriverList").datagrid("getSelections")[0];
               			data.departmentId = data.department.departmentId;
               		//	if(data.department.fatherdep=='0'){
            		//		data.fathername = data.department.departmentName;
            		//	}else{
            				data.departmentName = data.department.departmentName;
            		//	}
               			data.birthday = TAOTAO.formatDateTime(data.birthday);
        				data.worktime = TAOTAO.formatDateTime(data.worktime);
        				data.checktime = TAOTAO.formatDateTime(data.checktime);
               			$("#carDriverEditForm").form("load", data);
               		}
               	}).window("open");
       		}
       	});
    }
    function getCarDriverSelectionsNames(){
    	var carDriverList = $("#carDriverList");
    	var sels = carDriverList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].drviername);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carDriver_delete(){
    	$.get("carDriver/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarDriverSelectionsNames();
      			var ids = getCarDriverSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定要删除 '+names+' 司机的信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carDriver/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carDriverList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    $(function(){
    	//创建富文本编辑器
    	//productAddEditor = TAOTAO.createEditor("#productAddForm [name=file]");
    	//productAddEditor = KindEditor.create("#productAddForm [name=note]", TT.kingEditorParams);
    	//初始化类目选择和图片上传器
    	TAOTAO.initProductPicUpload({fun:function(node){
    		//根据产品的分类id取产品 的规格模板，生成规格信息。第四天内容。
    		TAOTAO.changeItemParam(node, "carDriverAddForm");
    	}});
    });
    $('#departmenCombox').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId').val(data.departmentId);  
            var fatherdep= $('#departmentFrist').val();
          
            $('#department').combobox({  
               
                url:"department/get_data_second/"+fatherdep,  
                valueField:'departmentId',  
                textField:'departmentName' ,
                
                onSelect : function(data1){  
                  $('#departmentId').val(data1.departmentId);  
                
                }
           
            }).combobox('clear');  
           
		
        }  
    });  
	
    function carDriver_reload(){
    	$("#carDriverList").datagrid("reload");
    }
</script>