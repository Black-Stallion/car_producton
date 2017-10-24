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
	<form id="carSendEditForm" method="post">
	<input type="hidden" name="sendId"/>
	   <center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
					<td colspan="4"  align="center">
						<h3>济南铁路局济南通信段派车单</h3>
					</td>
				</tr>
				<tr>
					<td width="auto" bgcolor="#F0F8FF" align="right">派车编号</td>
					<td width="auto"><input class="easyui-textbox" editable="false" type="text" name="sendnums"></input>
					</td>
					<td width="auto" bgcolor="#F0F8FF" align="right">日期</td>
					<td width="auto"><input class="easyui-datebox" name="sdates"
						value="yyyy-MM-dd" style="width: 150px"></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">用车单位</td>
					<td><input class="easyui-combobox" id="6departmenCombox669" value="${departmentname }" name="departmentName" panelHeight="200" size="15px" /> 
						<input name="departmentFrist" id="departmentFrist" type="hidden" /> 
						<input class="easyui-combobox" id="6xxdepartment669" panelHeight="200" name="fdepartmentName" size="15px" /> 
						<input name="departmentId669" id="departmentId669" type="hidden" />
						<input name="departmentId" id="departmentId726" type="hidden" />
						<!-- 
						<input class="easyui-combobox" id="6departmenCombox669" value="${fathername }" name="fathername"
						 panelHeight="auto" size="10px" /> <input
						name="departmentFrist" id="departmentFrist" type="hidden" /> <input
						class="easyui-combobox" id="6xxdepartment669" panelHeight="200" value="${departmentNames1 }"
						name="departmentName" size="12px" /> <input name="departmentId669" id="departmentId669"
						type="hidden" />
						<input
						class="easyui-combobox" id="xxdepartment726" panelHeight="auto" name="fdepartmentName"
						size="10px" /> <input name="departmentId" id="departmentId726"
						type="hidden" />
						 -->
						</td>

					<td bgcolor="#F0F8FF" align="right">车牌号</td>
					<td><input class="easyui-combobox"
						id="xjzcarCombox669" data-options="required:true" name="usenature"
						panelHeight="auto" size="9px" /> <input id="usenature669" type="hidden" /> 
						<input class="easyui-combobox"
						id="xjzcarNumberCombox669" data-options="required:true" name="carnumber"
						panelHeight="100" size="10px" /> <input name="carId" id="carId669"
						type="hidden" /></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">派车人</td>
					<td><input class="easyui-combobox" name="senduser"
						panelHeight="150"
						data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep', required:true" />
					</td>
					<td bgcolor="#F0F8FF" align="right">用车人</td>
					<td><input class="easyui-combobox" name="usercarpeople"
						panelHeight="150"
						data-options="valueField:'username',textField:'username',multiple:true,
    						url:'user/find_dataByDep',required:true,width:220" />
					</td>

				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">汽车驾驶员</td>
					<td><input class="easyui-combobox" name="driverId"
						panelHeight="150"
						data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data',required:true,editable:false" />
					</td>
					<td bgcolor="#F0F8FF" align="right">第一责任人</td>
					<td><input class="easyui-combobox" name="firstduty"
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
					<td colspan="3"><input class="easyui-combobox" name="note"
						panelHeight="auto"
						data-options="valueField:'name',textField:'name',
    						url:'carCareful/get_data',width:600,height:45, editable:false, required:true,multiple:true,multiline:true"/>
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
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarSendEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
		var send2AddEditor3;
		$(function(){
			//加载文件上传插件
			//send2AddEditor = TAOTAO.createEditor("#send2AddForm [name=file]");
			send2AddEditor3 = KindEditor.create("#carSendEditForm [name=road]", {
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
	function submitCarSendEditForm(){
		if(!$('#carSendEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		send2AddEditor3.sync();
		$.post("carSend/update_all",$("#carSendEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改派车单成功!','info',function(){
					$("#carSendEditWindow").window('close');
					$("#carSendList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#xjzcarCombox669').combobox({
		url : "carPublic/get_data",
		editable : false,
		valueField : 'usenature',
		textField : 'usenature',
		panelHeight : 'auto',
		editable : false,
		onSelect : function(data) {
			$('#usenature669').val(data.usenature);
			var fatherdep = $('#usenature669').val();
			$('#xjzcarNumberCombox669').combobox({
				url : "carPublic/find_nature/" + fatherdep,
				valueField : 'carId',
				textField : 'carnumber',
				editable : false,
				onSelect : function(data1) {
					$('#carId669').val(data1.carId);
				}
			}).combobox('clear');
		}
	});
	$('#6departmenCombox669').combobox({
		url : "department/get_data_first",
		editable : false,
		valueField : 'departmentId',
		textField : 'departmentName',
	//	panelHeight : 'auto',
		onSelect : function(data) {
			$('#departmentFrist').val(data.departmentId);
			$('#departmentId669').val(data.departmentId)
			$('#departmentId726').val(data.departmentId);;
			var fatherdep = $('#departmentFrist').val();

			$('#6xxdepartment669').combobox({

				url : "department/get_data_second/" + fatherdep,
				valueField : 'departmentId',
				textField : 'departmentName',
				onSelect : function(data1) {
					$('#departmentId669').val(data1.departmentId);
					$('#departmentId726').val(data1.departmentId);
				//	var fatherdep = $('#departmentId669').val();
				//	$('#xxdepartment726').combobox({
				//		url : "department/get_data_third/" + fatherdep,
				//		valueField : 'departmentId',
				//		textField : 'departmentName',
				//		editable : false,
				//		onSelect : function(data2) {
				//			$('#departmentId726').val(data2.departmentId);
				//		}
				//	}).combobox('clear');
				}
			}).combobox('clear');
		}
	});
	
</script>
