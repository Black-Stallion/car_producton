<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
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
	<form id="departmentEditForm" class="departmentForm" method="post">
		<input type="hidden" name="departmentId"/>
		<input type="hidden" name="fatherdep"/>
	    <table class="border-table" cellpadding="5" align="center">
	        <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">部门名称</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="departmentName" data-options="required:true"></input>
    			</td>  
	        </tr>
	        <tr>
	         <td bgcolor="#F0F8FF" align="right">部门级别</td>
	            <td>
	            	<select id="cc33" onchange="SelectModelChange1()" name="level">
						<option value="1">一级</option>
						<option value="2">二级</option>
					</select><span style="color:red">(注:车间为一级，工区为二级)</span>
    			</td> 
    		</tr>
    		<tr id="divOverTime3">
    		
    		</tr>
	        <tr >
	            <td bgcolor="#F0F8FF" align="right">部门职责</td>
	            <td>
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	         
	    </table>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDepartmentEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var departmentEditEditor ;
	
	$(function(){
		//实例化富文本编辑器
		departmentEditEditor = TAOTAO.createEditor("#departmentEditForm [name=note]",{
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [
				'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
		});
	});
	//同步kindeditor中的内容
	departmentEditEditor.sync();
	
	function submitDepartmentEditForm(){
		$.get("department/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#departmentEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			departmentEditEditor.sync();
    			
    			$.post("department/update_all",$("#departmentEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改部门成功!','info',function(){
    						$("#departmentEditWindow").window('close');
    						$("#qwe").parent().remove();
    				    	$("#123").remove();
    						$("#departmentList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	function SelectModelChange1()
	{
	        var sel = document.getElementById("cc33").value;
	        // if(sel=="1" || sel=="2"){
	    	   if(sel=="2"){
	        	$("#qwe").parent().remove();
	        	$("#123").remove();
	        	var text = "<td id=\"123\" bgcolor=\"#F0F8FF\" align=\"right\">上级部门名称</td><td><input id=\"qwe\" name=\"fathername\"/></td>";
				$("#divOverTime3").append(text);
	        }else{
	        	$("#qwe").parent().remove();
	        	$("#123").remove();
	        }
	}
</script>
