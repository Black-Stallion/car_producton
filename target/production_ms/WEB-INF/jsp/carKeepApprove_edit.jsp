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
	<form id="carKeepApproveEditForm" class="carKeepApproveForm" method="post">
		<input type="hidden" name="applyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	      <td width="auto" bgcolor="#F0F8FF" align="right">维护车辆</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" id="41xjkeepcarsCombox" name="beiyong1" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="beiyong1" type="hidden"/>
    				<input class="easyui-textbox" id="41xjkeepcarNumbersCombox" name="carnum"  data-options="required:true,editable:false" panelHeight="150" size="10px"/>  
    				<input id="carnum" type="hidden"/>
    				</td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">申请人</td>
	            <td>
	            	<input  class="easyui-textbox" name="applyname" panelHeight="auto"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep',required:true,editable:false" />
	            </td>
	            </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">所在部门</td>
	             <td>
    				<input class="easyui-textbox" id="51xjkeepdepartmentz185" name="departmentName"/>  
    				<input name="departmentId" id="departmentId85" type="hidden"/>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">当前里程</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" editable="false" type="text" name="intervalkm" data-options="required:true" style="width: 200px;"></input>
	            </td>
	        </tr>
	        <tr> 
	            <td bgcolor="#F0F8FF" align="right">开始日期</td>
	            <td>
	            	<input class="easyui-datetimebox" name="startdate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">截止日期</td>
	            <td>
	            	<input class="easyui-datetimebox" name="enddate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">厂家名称</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="suppliername" editable="false"></input>
	            </td>
	        </tr>
	        <tr>
        			<td bgcolor="#F0F8FF" align="right">维护级别或修理项目</td>
	            	<td colspan="3">
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="repairtype"></textarea>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">审批</td>
	            <td>
	            <select id="cc" name="stats" class="easyui-combobox" panelHeight="auto" data-options="required:true, width:150, editable:false">
		            		<option value="段内处理">段内处理</option>
		            		<option value="上报处理">上报处理</option>
		        </select> </td>
	        </tr>
	         <input type="hidden" name="approve"/>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarKeepApproveEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
var keep1applyEditor;
$(function(){
	keep1approveEditor = KindEditor.create("#carKeepApproveEditForm [name=repairtype]", {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
});
	function submitCarKeepApproveEditForm(){
		if(!$('#carKeepApproveEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		keep1approveEditor.sync();
		$.post("carKeepApprove/update_all",$("#carKeepApproveEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','审批成功!','info',function(){
					$("#carKeepApproveEditWindow").window('close');
					$("#carKeepApplyList").datagrid("reload");
					$("#carKeepApproveList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
</script>
