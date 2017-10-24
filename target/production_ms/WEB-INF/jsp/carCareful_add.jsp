<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>
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
	<form id="carCarefulAddForm31" class="carCarefulForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
	     <tr>
    			<td width="auto" bgcolor="#F0F8FF" align="right">注意事项</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="name" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">参数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="yong" data-options="required:true"></input>
	            </td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="carCarefulParams"/>
	</form>
	<div style="padding:15px 0 0 250px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarCarefulAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarCarefulADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">

	//提交表单
	function submitCarCarefulAddForm(){
		//有效性验证
		if(!$('#carCarefulAddForm31').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		//$("#carCarefulAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carCareful/insert",$("#carCarefulAddForm31").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增信息成功!');
				clearCarCarefulADDForm();
				$("#carCarefulAddWindow").window('close');
				$("#carCarefulList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}

	function clearCarCarefulADDForm(){
		$('#carCarefulAddForm31').form('reset');
	}
	
</script>
