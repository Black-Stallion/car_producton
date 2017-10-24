<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding: 10px 10px 10px 10px">
	<form id="carNowSendAddForms" class="carNowSendForm" method="post">
		<center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
					<td colspan="4" width="auto" align="center">
						<h3>济南铁路局济南通信段派车单</h3>
					</td>
				</tr>
				<tr>
					<td width="auto" bgcolor="#F0F8FF" align="right">派车编号</td>
					<td width="auto">
					<span style="color:red">自动生成编号(格式:jntxd+时间)</span>
					</td>
					<td width="auto" bgcolor="#F0F8FF" align="right">日期</td>
					<td width="auto"><input class="easyui-datebox" name="sdates"
						value="yyyy-MM-dd" style="width:150px"></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">用车单位</td>
					<td><input class="easyui-combobox" id="departmenCombox1831" name="departmentName" data-options="required:true" panelHeight="200" size="15px" /> 
						<input id="departmentFrist0831" type="hidden" /> 
						<input class="easyui-combobox" id="xxdepartment1831" panelHeight="200"  size="15px" /> 
						<input id="departmentId1831" type="hidden" />
						<input name="departmentId" id="departmentId2831" type="hidden" />
						<!-- 
						<input class="easyui-combobox" id="departmenCombox1831" 
						data-options="required:true" panelHeight="auto" size="7px" /> <input
						id="departmentFrist0831" type="hidden" /> <input
						class="easyui-combobox" id="xxdepartment1831" panelHeight="200" name="departmentName"
						size="12px" /> <input id="departmentId1831"
						type="hidden" />
						<input
						class="easyui-combobox" id="xxdepartment2831" panelHeight="auto"
						size="10px" /> <input name="departmentId" id="departmentId2831"
						type="hidden" />
						 -->
						</td>

					<td bgcolor="#F0F8FF" align="right">车牌号</td>
					<td><input class="easyui-combobox"
						id="xjzcarCombox3831" data-options="required:true" name="usenature"
						panelHeight="auto" size="9px" /> <input name="usenature"
						id="usenature3831" type="hidden" /> <input class="easyui-combobox" name="carnumber"
						id="xjzcarNumberCombox3831" data-options="required:true"
						panelHeight="100" size="10px" /> <input name="carId" id="carId3831"
						type="hidden" /></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">派车人</td>
					<td><input class="easyui-combobox" name="senduser" value="${username }"
						panelHeight="150"
						data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep',required:true" />
					</td>
					<td bgcolor="#F0F8FF" align="right">用车人</td>
					<td><input class="easyui-combobox" name="usercarpeople" value="${username }"
						panelHeight="150"
						data-options="valueField:'username',textField:'username',multiple:true,
    						url:'user/find_dataByDep',required:true,width:220"/>
					</td>

				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">汽车驾驶员</td>
					<td><input class="easyui-combobox" name="driverId"
						panelHeight="150"
						data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data',required:true, editable:false" />
					</td>
					<td bgcolor="#F0F8FF" align="right">第一责任人</td>
					<td><input class="easyui-combobox" name="firstduty" value="${username }"
						panelHeight="150"
						data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep',required:true" />
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">特殊情况领导审批</td>
					<td><input class="easyui-textbox" type="text" name="notes"></input>
					</td>
					<td bgcolor="#F0F8FF" align="right">安全监督岗</td>
					<td><input class="easyui-textbox" type="text" name="safe"></input>
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">出车时间</td>
					<td><input class="easyui-datetimebox" name="senddate"
						data-options="required:true,showSeconds:true"
						value="date.format('yyyy-MM-dd')" style="width: 150px"></td>
					<td bgcolor="#F0F8FF" align="right">返回时间</td>
					<td><input class="easyui-datetimebox" name="endcardate"
						data-options="required:true,showSeconds:true"
						value="date.format('yyyy-MM-dd')" style="width: 150px">
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">行走公里</td>
					<td colspan="3">开始&nbsp;<input class="easyui-numberbox"
						 name="firstkm" data-options="required:true"
						size="25">&nbsp;公里 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						结束&nbsp;<input class="easyui-numberbox"
						name="endkm" size="25">公里
					</td>
				</tr>

				<tr rowspan="2">
					<td bgcolor="#F0F8FF" align="right">注意事项</td>
					<td colspan="3"><input class="easyui-combobox" name="note" value=""
						panelHeight="auto"
						data-options="valueField:'name',textField:'name',
    						url:'carCareful/get_data',width:600, editable:false,height:45, required:true,multiple:true,multiline:true" />
					</td>
				</tr>

				<tr>
					<td bgcolor="#F0F8FF" align="right">任务地点及路线</td>
					<td colspan="3"><textarea
							style="width: 150px; height: 10px; visibility: hidden;"
							name="road"></textarea></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align:center">
						<h3>驾驶员三检记录</h3>
					</td>
				</tr>
				<tr>
						<td bgcolor="#F0F8FF" align="right">天气</td>
					<td colspan="3"><input class="easyui-textbox" type="text" name="tianqi"></input>
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">出车</td>
					<td colspan="3">出车前<input class="easyui-textbox"
						name="chucheq" size="16">
						&nbsp;行驶中<input class="easyui-textbox" name="xingshiz"
						 size="16"> &nbsp;收车后<input
						class="easyui-textbox" name="shoucheh"
						 size="16"></td>
				</tr>
			</table>
		</center>
		<input type="hidden" name="carSendParams" />
	</form>
	<div style="padding: 5px 0 0 700px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitCarSendAddForms()">提交</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="clearCarSendADDForms()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var orderAddEditor83;
	$(function() {
		//加载文件上传插件

		orderAddEditor83 = KindEditor.create("#carNowSendAddForms [name=road]",{
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
	function submitCarSendAddForms() {
		//有效性验证
		if (!$('#carNowSendAddForms').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}
		orderAddEditor83.sync();

		//ajax的post方式提交表单
		//$("#carNowSendAddForms").serialize()将表单序列号为key-value形式的字符串
		$.post("carSend/insertnow", $("#carNowSendAddForms").serialize(), function(
				data) {
			if (data.status == 200) {
				$.messager.alert('提示', '新增派车单成功'+data.msg);
				clearCarSendADDForms();
				$("#carNowSendAddWindows").window('close');
				$("#carSendList").datagrid("reload");
			} else {
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#xjzcarCombox3831').combobox({
		url : "carPublic/get_data",
		editable : false,
		valueField : 'usenature',
		textField : 'usenature',
		panelHeight : 'auto',
		onSelect : function(data) {
			$('#usenature3831').val(data.usenature);
			var fatherdep = $('#usenature3831').val();

			$('#xjzcarNumberCombox3831').combobox({

				url : "carPublic/find_nature/" + fatherdep,
				valueField : 'carId',
				textField : 'carnumber',
				editable :false,
				onSelect : function(data1) {
					$('#carId3831').val(data1.carId);
				}

			}).combobox('clear');
		}
	});
	$('#departmenCombox1831').combobox({
		url : "department/get_data_first",
		editable : false,
		valueField : 'departmentId',
		textField : 'departmentName',
	//	panelHeight : 'auto',
		onSelect : function(data) {
			$('#departmentFrist0831').val(data.departmentId);
			$('#departmentId1831').val(data.departmentId);
			$('#departmentId2831').val(data.departmentId);
			var fatherdep = $('#departmentFrist0831').val();
			$('#xxdepartment1831').combobox({
				url : "department/get_data_second/" + fatherdep,
				valueField : 'departmentId',
				textField : 'departmentName',
				editable : false,
				onSelect : function(data1) {
					$('#departmentId1831').val(data1.departmentId);
					$('#departmentId2831').val(data1.departmentId);
				//	var fatherdep = $('#departmentId1831').val();
				//	$('#xxdepartment2831').combobox({
				//		url : "department/get_data_third/" + fatherdep,
				//		valueField : 'departmentId',
				//		textField : 'departmentName',
				//		editable : false,
				//		onSelect : function(data2) {
				//			$('#departmentId2831').val(data2.departmentId);
				//		}
				//	}).combobox('clear');
				}

			}).combobox('clear');
		}
	});
	
	function clearCarSendADDForms() {
		$('#carNowSendAddForms').form('reset');
	}
	
</script>

