<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="orderList" title="机动车信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'order/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_order">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'dengJiZSID',align:'center',width:100">机动车证书编号</th>
            <th data-options="field:'sheBeiID',align:'center',width:100,formatter:formatCustom">设备编号</th>
            <th data-options="field:'username',align:'center',width:100,formatter:formatProduct">机动车所有人</th>
            <th data-options="field:'jiGan',align:'center',width:100">登记机关</th>
            <th data-options="field:'dengjiTiem',width:100,align:'center'">登记日期</th>
            <th data-options="field:'dengjiID',width:100,align:'center'">机动车登记编号</th>
            <th data-options="field:'carType',width:100,align:'center'">车辆型号</th>
            <th data-options="field:'brand',width:60,align:'center',formatter:TAOTAO.formatOrderStatus">车辆品牌</th>
            <th data-options="field:'carXH',width:130,align:'center'">车辆型号</th>
            <th data-options="field:'checkNums',width:70,align:'center'">核定载客(位)</th>
            <th data-options="field:'orderList',width:130,align:'center', formatter:orderList">机动车详细信息</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_order" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='order:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="order_add()">新增</a> 
		    </div>  
		</c:if>
		<c:if test="${per=='order:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="order_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='order:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="order_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
    <div id="search_order" style="float: right;">
        <input id="search_text_order" class="easyui-searchbox"  
            data-options="searcher:doSearch_order,prompt:'请输入...',menu:'#menu_order'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_order" style="width:120px"> 
			<div data-options="name:'orderId'">机动车证书编号</div> 
			<div data-options="name:'orderCustom'">设备编号</div>
			<div data-options="name:'orderProduct'">机动车登记编号</div> 
		</div>     
    </div>  
</div>  

<div id="orderEditWindow" class="easyui-window" title="编辑车辆信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'order/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="orderAddWindow" class="easyui-window" title="添加车辆信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'order/add'" style="width:50%;height:80%;padding:10px;">
</div>
<div id="orderList" class="easyui-dialog" title="机动车详细信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="orderCustomEditForm" method="post">
		<input type="hidden" name="carId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>客户名称:</td>
	            <td><input class="easyui-textbox" type="text" name="customName" data-options="required:true"></input></td>
	        </tr>
	        <tr>
	            <td>客户全称:</td>
	            <td><input class="easyui-textbox" type="text" name="fullName" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>地址:</td>
	            <td><input class="easyui-textbox" type="text" name="address" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>传真:</td>
	            <td><input class="easyui-textbox" type="text" name="fax"></input></td>
	        </tr>
	        <tr>
	            <td>邮箱:</td>
	            <td><input class="easyui-textbox" type="text" name="email"></input></td>
	        </tr>
	        <tr>
	            <td>经理姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="ownerName"></input></td>
	        </tr>
	        <tr>
	            <td>联系电话:</td>
	            <td><input class="easyui-textbox" type="text" name="ownerTel"></input></td>
	        </tr>
	        <tr>
	            <td>客户状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" style="width:200px;" data-options="width:150">
						<option value="1">有效客户</option>
						<option value="2">无效客户</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td><textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOrderCustomEditForm()">提交</a>
	</div>
</div>
<script>
function doSearch_order(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#orderList").datagrid({
	        title:'机动车信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_order", url:'order/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'dengJiZSID', width : 100, align:'center', title : '机动车证书编号'},
	             	{field : 'sheBeiID', width : 100, align : 'center', title : '设备编号'},
	             	{field : 'username', width : 100, align : 'center', title : '机动车所有人'}, 
	             	{field : 'jiGan', width : 100, title : '登记机关', align:'center'}, 
	             	{field : 'dengjiTiem', width : 100, title : '登记日期', align:'center',formatter:TAOTAO.formatDateTime}, 
	            	{field : 'dengjiID', width : 100, title : '机动车登记编号', align:'center'}, 
	             	{field : 'carType', width : 60, title : '车辆型号', align:'center'}, 
	             	{field : 'brand', width : 130, title : '车辆品牌', align:'center'}, 
	             	{field : 'carXH', width : 70, title : '车辆型号', align:'center'}, 
	             	{field : 'checkNums', width : 100, title : '核定载客', align:'center'}, 
	             	{field : 'orderList',  width : 100, title : '机动车详细信息', align:'center', formatter:orderList}
	        ] ],  
	    });
	}else{
		$("#orderList").datagrid({  
	        title:'机动车信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_order", url:'order/search_order_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'dengJiZSID', width : 100, align:'center', title : '机动车证书编号'},
	             	{field : 'sheBeiID', width : 100, align : 'center', title : '设备编号'},
	             	{field : 'username', width : 100, align : 'center', title : '机动车所有人'}, 
	             	{field : 'jiGan', width : 100, title : '登记机关', align:'center'}, 
	             	{field : 'dengjiTiem', width : 100, title : '登记日期', align:'center'}, 
	            	{field : 'dengjiID', width : 100, title : '机动车登记编号', align:'center'}, 
	             	{field : 'carType', width : 60, title : '车辆型号', align:'center'}, 
	             	{field : 'brand', width : 130, title : '车辆品牌', align:'center'}, 
	             	{field : 'carXH', width : 70, title : '车辆识别代号', align:'center'}, 
	             	{field : 'checkNums', width : 100, title : '核定载客', align:'center'}, 
	             	{field : 'orderList',  width : 100, title : '机动车详细信息', align:'center', formatter:orderList}
	        ] ],  
	    });
	}
}
	var orderNoteEditor ;
	
	var orderProductEditor;
	
	var orderCustomEditor;
	
	//格式化产品信息
	function  formatProduct(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openOrderProduct("+index+")>"+value.productName+"</a>";
		}else{
			return "无";
		}
	};

	//根据index拿到该行值
	function onOrderClickRow(index) {
		var rows = $('#orderList').datagrid('getRows');
		return rows[index];
		
	}
	
	
	//打开产品信息对话框
	function  openOrderProduct(index){ 
		var row = onOrderClickRow(index);
		$("#orderProductInfo").dialog({
    		onOpen :function(){
    			$.get("product/get/"+row.product.productId,'',function(data){
    				
    				orderProductEditor = TAOTAO.createEditor("#orderProductEditForm [name=note]");	
		    		//回显数据
		    		$("#orderProductEditForm").form("load", data);
		    		orderProductEditor.html(data.note);
		    		
		    		//加载图片
 	        		initOrderProductPic({
           				"pics" : data.image,
           			});
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#orderProductEditForm [name=note]");
			   	clearManuSpan();
			}
    	}).dialog("open");
	};
	
	// 加载图片
    function initOrderProductPic(data){
    	$(".orderProductPic").each(function(i,e){
    		var _ele = $(e);
    		_ele.siblings("div.pics").remove();
    		_ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
    		// 回显图片
    		var j = false;
        	if(data && data.pics){
        		var imgs = data.pics.split(",");
        		for(var i in imgs){
        			if($.trim(imgs[i]).length > 0){
        				_ele.siblings(".pics").find("ul").append("<li><a id='img"+i+"' href='"+imgs[i]+"' target='_blank'>" +
        						"<img src='"+imgs[i]+"' width='80' height='50' /></a> ");
        				j = true;
        			}
        		}
        	}
        	if(!j){
    			$("#orderProductPic").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
    		}
    	});
    }
	
    function clearManuSpan(){
		$("#orderProductPic").html('');
	}
    
	function submitOrderProductEditForm(){
		$.get("product/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#orderProductEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			orderProductEditor.sync();
    			
    			$.post("product/update_all",$("#orderProductEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改产品成功!','info',function(){
    						$("#orderProductInfo").dialog("close");
    						$("#orderList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//打开订单要求富文本编辑器对话框
	function  openOrderNote(index){ 
		var row = onOrderClickRow(index);
		$("#orderNoteDialog").dialog({
    		onOpen :function(){
    			$("#orderNoteForm [name=orderId]").val(row.orderId);
    			orderNoteEditor = TAOTAO.createEditor("#orderNoteForm [name=note]");
    			orderNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#orderNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新订单要求
	function updateOrderNote(){
		$.get("order/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			orderNoteEditor.sync();
    			$.post("order/update_note",$("#orderNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#orderNoteDialog").dialog("close");
    					$("#orderList").datagrid("reload");
    					$.messager.alert("操作提示", "更新订单要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新订单要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getOrderSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function order_add(){
    	$.get("order/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#orderAddWindow").window("open");
       		}
       	});
    }
    
    function order_edit(){
    	$.get("order/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getOrderSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个订单才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个订单!');
               		return ;
               	}
               	
               	$("#orderEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#orderList").datagrid("getSelections")[0];
               			data.customId = data.custom.customId; 
               			data.productId = data.product.productId; 
               			data.orderDate = TAOTAO.formatDateTime(data.orderDate);
               			data.requestDate = TAOTAO.formatDateTime(data.requestDate);
               			$("#orderEditForm").form("load", data);
               			orderEditEditor.html(data.note);
               			
               			TAOTAO.init({
               				"pics" : data.image,
               			});
               			
               			//加载文件上传插件
               			initOrderEditFileUpload();
               			//加载上传过的文件
               			initUploadedFile();
               		}
               	}).window("open");
       		}
       	});
    }
    
    function order_delete(){
    	$.get("order/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getOrderSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中订单!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("order/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除订单成功!',undefined,function(){
                  					$("#orderList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    
    function order_reload(){
    	$("#orderList").datagrid("reload");
    }
</script>