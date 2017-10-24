<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">

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
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding: 10px 10px 10px 10px">
	<form id="carYouEditMoneyForm" class="carYouForm" method="post">
		<input type="hidden" name="youId" />
		<input type="hidden" name="departmentId" />
		<input type="hidden" name="departmentName" />
		<center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">油卡号码</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="younumber" data-options="required:true,editable:false"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">油卡余额</td>
	            <td >
	            	<input class="easyui-numberbox" precision="2" name="beiyong2" value="0.00" data-options="required:true,editable:false"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">充值金额</td>
	            <td >
	            	<input class="easyui-numberbox" precision="2" name="bei1" value="0.00" data-options="required:true"></input>
	            </td>
	        </tr>
	       
			</table>
		</center>
	</form>
	<div style="padding:5px 0 0 400px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitCarYouEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">


function btnDelete_onclick(obj) {
	$(obj).parent().remove();
}
	function submitCarYouEditForm() {
		if (!$('#carYouEditMoneyForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		$.post("carYou/update_money", $("#carYouEditMoneyForm").serialize(),
				function(data) {
					if (data.status == 200) {
						$.messager.alert('提示', '油卡充值成功!', 'info', function() {
							$("#carYouAddMoneyWindow").window('close');
							$("#carYouList").datagrid("reload");
						});
					} else {
						$.messager.alert('提示', data.msg);
					}
				});
	}

</script>
