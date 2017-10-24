<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="materialAddForm" class="userForm" method="post">
	<center>
	    <table cellpadding="5" >
	     <tr>
	            <td>时间:</td>
	            <td>
		            <select class="easyui-combobox" name="locked" panelHeight="auto" data-options="width:80, editable:false">
						<option value="1">2017</option>
						<option value="2">2016</option>
						<option value="1">2015</option>
						<option value="2">2014</option>
						<option value="1">2013</option>
						<option value="2">2012</option>
						<option value="1">2011</option>
						<option value="2">2010</option>
					</select>&nbsp;年&nbsp;
					 <select class="easyui-combobox" name="locked" panelHeight="auto" data-options="width:60, editable:false">
						<option value="1">12</option>
						<option value="2">11</option>
						<option value="1">10</option>
						<option value="2">09</option>
						<option value="1">08</option>
						<option value="2">07</option>
						<option value="1">06</option>
						<option value="2">05</option>
						<option value="1">04</option>
						<option value="2">03</option>
						<option value="1">02</option>
						<option value="2">01</option>
					</select>&nbsp;月
				</td>
	        </tr>
	        <tr>
	            <td>车况评分:</td>
	            <td>
	            	<input id="id" class="easyui-textbox" type="text" name="id" data-options="required:true"></input>
	            </td>
	        </tr>
	        
	        <tr>
	            <td>存在问题:</td>
	            <td>
	             	<textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>处理结果:</td>
	            <td>
	            	<textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    </center>
	</form>
	<br><br>
	<div style="padding:5px 0 0 35px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitUserAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearUserAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
var departmentAddEditor ;
//页面初始化完毕后执行此方法
$(function(){
	//创建富文本编辑器
	//departmentAddEditor = TAOTAO.createEditor("#departmentAddForm [name=file]");
	materialAddForm = KindEditor.create("#materialAddForm [name=note]", TT.kingEditorParams);
});

	//提交表单
	function submitUserAddForm(){
		//有效性验证
		if(!$('#userAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//ajax的post方式提交表单
		//$("#userAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("user/insert",$("#userAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', data.msg);
				clearUserAddForm();
				$("#userAddWindow").window('close');
				$("#userList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearUserAddForm(){
		$('#userAddForm').form('reset');
	}
</script>
