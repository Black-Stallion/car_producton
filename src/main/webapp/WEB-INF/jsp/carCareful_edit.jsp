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
	<form id="carCarefulEditForm15" class="carCarefulForm" method="post">
		<input type="hidden" name="carefulId"/>
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
	</form>
	<div style="padding:15px 0 0 250px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarCarefulEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitCarCarefulEditForm(){
		if(!$('#carCarefulEditForm15').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("carCareful/update_all",$("#carCarefulEditForm15").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("#carCarefulEditWindow").window('close');
					$("#carCarefulList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
  
</script>
