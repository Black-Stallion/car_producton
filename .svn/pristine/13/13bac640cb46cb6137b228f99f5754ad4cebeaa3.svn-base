<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="technologyAddForm" class="customForm" method="post">
	<center>
	    <table cellpadding="5" >
	        <tr>
	            <td>编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" data-options="required:true" name="address" style="width: 180px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>事故日期:</td>
	            <td>
	            <input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:180px">
	            </td>
	        </tr>
	        <tr>
	            <td>地点:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="address" data-options="required:true" style="width: 180px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>事故类别:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" data-options="required:true" name="address" style="width: 180px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>责任:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="address" style="width: 180px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>原因:</td>
	            <td>
	            	 <textarea style="width:400px;height:200px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>损失情况:</td>
	            <td>
	            	<textarea style="width:400px;height:200px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>主车司机:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="address" data-options="required:true" style="width: 180px;"></input>
	            </td>
	        </tr>
	    </table>
	    </center>
	    <input type="hidden" name="customParams"/>
	</form>
	<div style="padding:5px 0 0 35px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCustomAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCustomAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var technologyAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//customAddEditor = TAOTAO.createEditor("#customAddForm [name=file]");
		technologyAddEditor = KindEditor.create("#technologyAddForm [name=note]", TT.kingEditorParams);
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
