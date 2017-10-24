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
	<form id="carDeployAddForm" class="carDeployForm" method="post">
		<center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
					<td width="100px" bgcolor="#F0F8FF" align="right">变动时间</td>
					<td width="auto"><input class="easyui-datetimebox" name="deploy"
						data-options="required:true,showSeconds:true"
						value="date.format('yyyy-MM-dd')" style="width: 150px"></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">车牌号</td>
					<td><input class="easyui-combobox" id="carCombox67"
						name="usenature" panelHeight="auto" size="9px" />
						<input class="easyui-combobox" id="carNumberCombox67" name="carId"
						data-options="required:true" panelHeight="150px" size="10px" /></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">主车司机</td>
					<td><input class="easyui-combobox" name="driverId"
						panelHeight="150"
						data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', required:true,editable:false" />
					</td>
				</tr>
			</table>
		</center>
		<input type="hidden" name="carDeployParams" />
	</form>
	<div style="padding: 5px 0 0 270px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitCarDeployAddForm()">提交</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="clearCarDeployADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitCarDeployAddForm() {
		//有效性验证
		if (!$('#carDeployAddForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		//ajax的post方式提交表单
		//$("#carDeployAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carDeploy/insert", $("#carDeployAddForm").serialize(),
				function(data) {
					if (data.status == 200) {
						$.messager.alert('提示', '新增变动记录成功!');
						clearCarDeployADDForm();
						$("#carDeployAddWindow").window('close');
						$("#carDeployList").datagrid("reload");
					} else {
						$.messager.alert('提示', data.msg);
					}
				});
	}

	function clearCarDeployADDForm() {
		$('#carDeployAddForm').form('reset');
	}

	$('#carCombox67').combobox({
		url : "carPublic/get_data",
		editable : false,
		valueField : 'usenature',
		textField : 'usenature',
		panelHeight : 'auto',
		onSelect : function(data) {
			$('#carCombox67').val(data.usenature);
			var fatherdep = $('#carCombox67').val();
			$('#carNumberCombox67').combobox({
				url : "carPublic/find_nature/" + fatherdep,
				valueField : 'carId',
				textField : 'carnumber',
				onSelect : function(data1) {
					$('#carNumberCombox67').val(data1.carId);
				}
			}).combobox('clear');
		}
	});
</script>
