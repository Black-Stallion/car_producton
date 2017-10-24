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
	<form id="carYouEditForm" class="carYouForm" method="post">
		<input type="hidden" name="youId" />
		<input type="hidden" name="beiyong2" value="0.00">
		<center>
			<table class="border-table" cellpadding="5" align="center">
				<tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">油卡号码</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="younumber" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">部门</td>
	            <td>
	            	<input class="easyui-combobox" id="departmenCombox521" name="departmentName" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId521" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox521" value="${fathername }" panelHeight="auto" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department521" name="departmentName"  panelHeight="200"/>  
    				<input name="departmentId" id="departmentId521" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">油卡状态</td>
	            <td>
		            <select class="easyui-combobox" name="beiyong1" panelHeight="auto" data-options="width:150,editable:false">
						<option value="1">有效</option>
						<option value="2">停用</option>
					</select>
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
		if (!$('#carYouEditForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		$.post("carYou/update_all", $("#carYouEditForm").serialize(),
				function(data) {
					if (data.status == 200) {
						$.messager.alert('提示', '修改油卡信息成功!', 'info', function() {
							$("#carYouEditWindow").window('close');
							$("#carYouList").datagrid("reload");
						});
					} else {
						$.messager.alert('提示', data.msg);
					}
				});
	}
	  $('#departmenCombox521').combobox({  
	        url: "department/get_data_first",  
	        editable:false,  
	        valueField:'departmentId',   
	        textField:'departmentName',  
	      //  panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#departmentFrist').val(data.departmentId);  
	            $('#departmentId521').val(data.departmentId);  
	      //      var fatherdep= $('#departmentFrist').val();
	      //      $('#department521').combobox({  
	      //          url:"department/get_data_second/"+fatherdep, 
	      //          editable:false, 
	      //          valueField:'departmentId',  
	      //          textField:'departmentName',
	      //          onSelect : function(data1){  
	      //            $('#departmentId521').val(data1.departmentId);  
	      //          }
	      //      }).combobox('clear');  
	        }  
	    });  
</script>
