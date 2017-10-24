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
	<form id="carMaintenanceEditForm" class="carMaintenanceForm" method="post">
		<input type="hidden" name="maintenanceId"/>
		<center>
	    <table class="border-table" cellpadding="5" align="center">
	         <tr>
    			<td width="auto"  bgcolor="#F0F8FF" align="right">维护名称</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="mname" data-options="required:true"></input>
	             </td>  </tr>
	        <tr>
	             <td bgcolor="#F0F8FF" align="right">车型名称</td>
		            <td>
	            	<input class="easyui-combobox" name="typeid"   panelHeight="auto" 
    					data-options="valueField:'typeid',textField:'typename',
    						url:'carType/get_data', required:true,editable:false" />
    			</td>  
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">行驶公里</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="kilometre" data-options="required:true"></input>
	             </td>  </tr>
	        <tr>
	             <td bgcolor="#F0F8FF" align="right">维护项目</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="mproject" data-options="required:true"></input>
	             </td>
	        </tr>
	    <input type="hidden" name="carMaintenanceParams"/>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 350px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarMaintenanceEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">

	function submitCarMaintenanceEditForm(){
		if(!$('#carMaintenanceEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carMaintenance/update_all",$("#carMaintenanceEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改维护要求成功!','info',function(){
					$("#carMaintenanceEditWindow").window('close');
					$("#carMaintenanceList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
</script>
