<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
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
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="departmentAddForm" class="departmentForm" method="post">
	    <table class="border-table" cellpadding="5" align="center">
	        
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">部门名称</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="departmentName" data-options="required:true"></input>
    			</td>  
	        </tr>
	       
	        <tr>
	         <td bgcolor="#F0F8FF" align="right">部门级别</td>
	            <td>
	            	<select id="cc34" onchange="SelectModelChange()" name="level">
						<option selected = "selected" value="1">一级</option>
						<option value="2">二级</option>
					</select><span style="color:red">(注:车间为一级，工区为二级)</span>
    			</td> 
    		</tr> 
    		<tr id="divOverTime2">
    		</tr>
				 <tr>
	            <td  bgcolor="#F0F8FF" align="right">部门职责</td>
	            <td>
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="departmentParams"/>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDepartmentAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearDepartmentAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var departmentAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//departmentAddEditor = TAOTAO.createEditor("#departmentAddForm [name=file]");
		departmentAddEditor = KindEditor.create("#departmentAddForm [name=note]",{
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
				'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
		});
	});
	
	//提交表单
	function submitDepartmentAddForm(){
		//有效性验证
		if(!$('#departmentAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的车间要求
		departmentAddEditor.sync();
		
		//ajax的post方式提交表单
		//$("#departmentAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("department/insert",$("#departmentAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增部门成功!');
				clearDepartmentAddForm();
				$("#departmentAddWindow").window('close');
				$("#departmentList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	function SelectModelChange()
	{
	        var sel = document.getElementById("cc34").value;
	       // if(sel=="1" || sel=="2"){
	    	   if(sel=="2"){
	        	$("#qwe").parent().remove();
	        	$("#123").remove();
	        	var text = "<td id=\"123\" bgcolor=\"#F0F8FF\" align=\"right\">上级部门名称</td><td><input id=\"qwe\" name=\"fathername\"/></td>";
				$("#divOverTime2").append(text);
	        }else{
	        	$("#qwe").parent().remove();
	        	$("#123").remove();
	        }
	}
	function clearDepartmentAddForm(){
		$('#departmentAddForm').form('reset');
		departmentAddEditor.html('');
		$("#qwe").parent().remove();
    	$("#123").remove();
	}
</script>
