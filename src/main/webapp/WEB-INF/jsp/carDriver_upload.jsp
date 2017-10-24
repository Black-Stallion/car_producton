<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id=carDriverUploadForm class="carDriverForm" method="post">
	<center>
	    <table cellpadding="5">
	    <tr>
	          <tr>
        	<td>上传司机数据</td>
	            <td>
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="uploadFileUploader">上传司机数据</div>
	                 <input type="hidden" id="uploadFile" name="upload"/>
	            </td>
	        </tr>
	    </table>
	    </center>
	    <input type="hidden" name="carDriverParams"/>
	</form>
	<div style="padding:5px 0 0 530px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitorderAddForm()">导入</a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//加载文件上传插件
	initCUploadFileUpload();
	TAOTAO.init({fun:function(node){
		TAOTAO.changeItemParam(node,"carDriverUploadForm");
	}});
});
	//提交表单
	function submitorderAddForm(){
		
		if(!$('#carDriverUploadForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("carDriver/upload",$("#carDriverUploadForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','司机导入成功!');
				clearorder1AddForm();
				$("#carDriverUploadWindow").window('close');
				$(".ajax-file-upload-container > .ajax-file-upload-statusbar").remove();
				$("#carDriverList").datagrid("reload");
				initCUploadFileUpload().remove();
			}else{
				$.messager.alert('提示',data.msg);
				$("input[name='upload']").val(null);
				$("#carDriverUploadWindow").window('close');
				$(".ajax-file-upload-container > .ajax-file-upload-statusbar").remove();
				$("#carDriverList").datagrid("reload");
				initCUploadFileUpload().remove();
			}
		});
	}
	
	function clearorder1AddForm(){
		$('#carDriverUploadForm').form('reset');
		$("input[name='upload']").val(null);
	}
</script>
