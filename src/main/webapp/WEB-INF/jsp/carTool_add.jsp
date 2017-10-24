<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">
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
<link href="css/uploadfile.css" rel="stylesheet">
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding: 10px 10px 10px 10px">
	<form id="carToolAddForm" class="carToolForm" method="post">
		<center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
				<td width="auto" bgcolor="#F0F8FF" align="right">车牌号</td>
				<td width="auto" colspan="3">
	            	<input class="easyui-combobox" id="carCombox93" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="usenature" id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox93" data-options="required:true" panelHeight="150px" size="10px"/>  
    				<input name="carId" id="carId93" type="hidden"/>
	            </td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">工具(备品)名称</td>
					<td><input class="easyui-textbox" type="text" name="toolname"></input>
					</td>
					<td bgcolor="#F0F8FF" align="right">规格/数量</td>
					<td width="auto" ><input class="easyui-textbox" type="text" name="norms"
						szie="7">规格</input> <input class="easyui-textbox" type="text"
						name="nums" szie="5">数量</input></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">备注</td>
					<td><input class="easyui-textbox" type="text" name="notes"
						szie="7"></input></td>
					<td colspan="2"><input type="button" id="btnAdd"
						class="easyui-linkbutton" size="30px" name="btnAdd" value="添加" />
						<br /></td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">证件(资料)名称</td>
					<td><input class="easyui-textbox" type="text" name="toolzj"></input>
					</td>
					<td bgcolor="#F0F8FF" align="right">数量</td>
					<td><input class="easyui-textbox" type="text" name="nums1"></input>
					</td>
				</tr>
				<tr>
					<td bgcolor="#F0F8FF" align="right">备注</td>
					<td><input class="easyui-textbox" type="text" name="notes1"></input>
					</td>
					<td colspan="2"><input type="button" id="btnAdds"
						class="easyui-linkbutton" size="30px" name="btnAdds" value="添加" />
						<br /></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="divOverTimes"></div>
						<div id="divOverTimes1"></div>
					</td>
				</tr>
			</table>
			<input type="hidden" name="carToolParams" />
		</center>
	</form>
	<div style="padding: 5px 0 0 700px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitCarToolAddForm()">提交</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" onclick="clearCarToolADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$("#btnAdd")
				.click(
						function() {

							var text = "<span><br/>工具(备品)名称<input type=\"text\" class=\"easyui-textbox\" data-options=\"required:true\" name=\"toolname\"></input>&nbsp;&nbsp;";
							text = text
									+ "规格<input type=\"text\" class=\"easyui-textbox\" data-options=\"required:true\" name=\"norms\" size=\"5\"></input>&nbsp;&nbsp;";
							text = text
									+ "数量<input type=\"text\" class=\"easyui-textbox\" name=\"nums\" size=\"5\"></input>&nbsp;&nbsp;";
							text = text
									+ "备注<input type=\"text\" class=\"easyui-textbox\" data-options=\"required:true\" name=\"notes\"></input>&nbsp;&nbsp;&nbsp;";
							text = text
									+ "<input type=\"button\" onclick=\"btnDelete_onclick(this)\" class=\"easyui-linkbutton\" id=\"btnDelete\" name=\"btnDelete\" value=\"删除\" />";
							text = text + "<br/></span>";
							$("#divOverTimes").append(text);

						});
	});
	$(function() {
		$("#btnAdds")
				.click(
						function() {
							var text = "<span><br/>证件(资料)名称<input type=\"text\" class=\"easyui-textbox\" data-options=\"required:true\" name=\"toolzj\"></input>&nbsp;&nbsp; ";
							text = text
									+ "数量<input type=\"text\" class=\"easyui-textbox\" name=\"nums1\" size=\"5\"></input>&nbsp;&nbsp;";
							text = text
									+ "备注<input type=\"text\" class=\"easyui-textbox\" data-options=\"required:true\" name=\"notes1\"></input>&nbsp;&nbsp;&nbsp;";
							text = text
									+ "<input type=\"button\" onclick=\"btnDelete_onclick(this)\" class=\"easyui-linkbutton\" id=\"btnDelete\" name=\"btnDelete\" value=\"删除\" />";
							text = text + "<br/></span>";
							$("#divOverTimes1").append(text);

						});
	});

	function btnDelete_onclick(obj) {
		$(obj).parent().remove();
	}
	//提交表单
	function submitCarToolAddForm() {
		//有效性验证
		if (!$('#carToolAddForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}
		//ajax的post方式提交表单
		//$("#carToolAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carTool/insert", $("#carToolAddForm").serialize(), function(
				data) {
			if (data.status == 200) {
				$.messager.alert('提示', '新增随车物品成功!');
				clearCarToolADDForm();
				$("#carToolAddWindow").window('close');
				$("#carToolList").datagrid("reload");
			} else {
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#carCombox93').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox93').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                
                onSelect : function(data1){  
                  $('#carId93').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
	
	function clearCarToolADDForm() {
		$('#carToolAddForm').form('reset');
	}
</script>
