<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="customAddForm" class="customForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>司机编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="customId" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>司机名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="customName" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>司机全称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="fullName" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>地址:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="address" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>传真:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="fax"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>邮箱:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="email"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>经理姓名:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="ownerName"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>联系电话:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="ownerTel"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>司机状态:</td>
	            <td>
		            <select class="easyui-combobox" name="status" panelHeight="auto" data-options="width:150, editable:false">
						<option value="1">有效司机</option>
						<option value="2">无效司机</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>司机介绍:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="customParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCustomAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCustomAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var customAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//customAddEditor = TAOTAO.createEditor("#customAddForm [name=file]");
		customAddEditor = KindEditor.create("#customAddForm [name=note]", TT.kingEditorParams);
	});
	//提交表单
	function submitCustomAddForm(){
		//有效性验证
		if(!$('#customAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		customAddEditor.sync();
		//ajax的post方式提交表单
		//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("custom/insert",$("#customAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增司机成功!');
				clearCustomAddForm();
				$("#customAddWindow").window('close');
				$("#customList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearCustomAddForm(){
		$('#customAddForm').form('reset');
		customAddEditor.html('');
	}
</script>
