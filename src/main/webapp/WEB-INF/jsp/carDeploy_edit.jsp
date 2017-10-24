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
	<form id="carDeployEditForm1" class="carDeployForm1" method="post">
		<input type="hidden" name="deployId" />
		<table class="border-table" cellpadding="5" align="center">
			<tr>
				<td width="100px" bgcolor="#F0F8FF" align="right">变动时间</td>
				<td width="auto"><input class="easyui-datetimebox" name="deploy"
					data-options="required:true,showSeconds:true"
					value="date.format('yyyy-MM-dd')" style="width: 150px"></td>
			</tr>
			<tr>
				<td bgcolor="#F0F8FF" align="right">车牌号</td>
				<td><input class="easyui-combobox" id="carCombox671"
					name="usenature" data-options="required:true" panelHeight="auto"
					size="9px" /> <input id="usenature671" type="hidden" /> <input
					class="easyui-combobox" id="carNumberCombox671" name="carnumber"
					data-options="required:true" panelHeight="150px" size="10px" /> <input
					name="carId" id="carId671" type="hidden" /></td>
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
	</form>
	<div style="padding: 5px 0 0 290px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitCarDeployEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitCarDeployEditForm() {
		if (!$('#carDeployEditForm1').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		$.post("carDeploy/update_all", $("#carDeployEditForm1").serialize(),
				function(data) {
					if (data.status == 200) {
						$.messager.alert('提示', '修改变动记录成功!', 'info', function() {
							$("#carDeployEditWindow").window('close');
							$("#carDeployList").datagrid("reload");
						});
					} else {
						$.messager.alert('提示', data.msg);
					}
				});
	}

	$('#carCombox671').combobox({
		url : "carPublic/get_data",
		editable : false,
		valueField : 'usenature',
		textField : 'usenature',
		panelHeight : 'auto',
		onSelect : function(data) {
			$('#usenature671').val(data.usenature);
			var fatherdep = $('#usenature671').val();

			$('#carNumberCombox671').combobox({

				url : "carPublic/find_nature/" + fatherdep,
				valueField : 'carId',
				textField : 'carnumber',
				editable : false,
				onSelect : function(data1) {
					$('#carId671').val(data1.carId);

				}

			}).combobox('clear');
		}
	});
</script>
