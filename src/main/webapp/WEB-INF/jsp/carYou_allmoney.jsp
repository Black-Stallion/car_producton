<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="carYouUploadForm" class="carYouForm" method="post">
	<center>
	    <table cellpadding="5">
	    <tr>
	          <tr>
        	<td>上传油卡充值文档</td>
	            <td>
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="uploadYouUploader">上传油卡充值文档</div>
	                 <input type="hidden" id="uploadYoumoney" name="uploadyou"/>
	            </td>
	        </tr>
	    </table>
	    </center>
	<div style="padding:20px 0 0 500px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitYouUpAddForm()">数据导入</a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//加载文件上传插件
	initYouUploadFileUpload();
	TAOTAO.init({fun:function(node){
		TAOTAO.changeItemParam(node,"carYouUploadForm");
	}});
});
	//提交表单
	function submitYouUpAddForm(){
		
		if(!$('#carYouUploadForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("carYou/upload",$("#carYouUploadForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','油卡批量充值成功！');
				clearordermoneyAddForm();
				$("#carYouAllMoneyWindow").window('close');
				$(".ajax-file-upload-container > .ajax-file-upload-statusbar").remove();
				$("#carYouList").datagrid("reload");
				initCUploadFileUpload().remove();
			}else{
				$.messager.alert('提示',data.msg);
				$("input[name='uploadyou']").val(null);
				$("#carYouAllMoneyWindow").window('close');
				$(".ajax-file-upload-container > .ajax-file-upload-statusbar").remove();
				$("#carYouList").datagrid("reload");
				initCUploadFileUpload().remove();
			}
		});
	}
	
	function clearordermoneyAddForm(){
		$('#carYouUploadForm').form('reset');
		$("input[name='uploadyou']").val(null);
	}
</script>
