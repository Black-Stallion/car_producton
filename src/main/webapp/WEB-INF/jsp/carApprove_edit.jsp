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
	<form id="carApproveEditForm" class="carApproveForm" method="post">
		<input type="hidden" name="applyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">申请编号</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="bianhao" data-options="required:true,editable:false"></input>
	            </td>
	            <td width="auto" bgcolor="#F0F8FF" align="right">车辆性质及车辆</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" id="zzcarCombox84" name="usenature"  data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input id="usenature97" type="hidden"/>
    				<input class="easyui-textbox" id="zzcarNumberCombox84" name="carnumber" data-options="required:true,editable:false" panelHeight="auto" size="10px"/>  
    				<input name="carId" id="carId84" type="hidden"/>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">申请人</td>
	            <td>
	            	<input  class="easyui-textbox" name="applyname" panelHeight="auto"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep', required:true,editable:false" />
	            </td>
	            <td bgcolor="#F0F8FF" align="right">出车天数</td>
	            <td><input class="easyui-numberbox" precision="1" name="days" data-options="required:true,editable:false"> </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">选择驾驶员:</td>
	            <td><input class="easyui-textbox" name="driverId"   panelHeight="auto" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', editable:false, required:true" />
	             </td>
	            <td bgcolor="#F0F8FF" align="right">用车单位</td>
	            <td>
    				<input class="easyui-textbox" id="zzdepartment89" name="departmentName" editable="false" panelHeight="200"/>  
    				<input name="departmentId" id="departmentId89" type="hidden"/>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">出车日期</td>
	            <td><input class="easyui-datetimebox" name="outtime"     
        			data-options="required:true,showSeconds:true,editable:false" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        			</td>
        			<td bgcolor="#F0F8FF" align="right">出车人数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="people" data-options="required:true,editable:false"></input>
	            </td>
	        </tr>
	        <tr>
        			<td bgcolor="#F0F8FF" align="right">用车理由</td>
	            	<td colspan="3">
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="thing"></textarea>
	            </td>
	        </tr>
	        	<tr>
    			<td bgcolor="#F0F8FF" align="right">用车审批</td>
	            <td colspan="3">
	            <select id="cc22" onchange="SelectModelChange()" name="stats">
		            		<option selected = "selected" value="通过">通过</option>
		            		<option value="未通过">未通过</option>
		        </select> </td>
	        </tr>
	       <tr>
					<td colspan="4">
						<div id="divOverTime1"></div>
					</td>
				</tr>
				<input type="hidden" name="approve"/>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 650px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarApproveEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">

		var approve1Editor;
		$(function(){
			approve1Editor = KindEditor.create("#carApproveEditForm [name=thing]",{
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
			});
		});
function SelectModelChange()
{
        var sel = document.getElementById("cc22").value;
        if(sel=="未通过"){
        	var text = "<span><br/>驳回理由<textarea id=\"qwe\" rows=\"4\" cols=\"48\" name=\"notes\"></textarea></span>";
			$("#divOverTime1").append(text);
        }else{
        	$("#qwe").parent().remove();
        }
}
	function submitCarApproveEditForm(){
		if(!$('#carApproveEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carApprove/update_id",$("#carApproveEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','审批成功!','info',function(){
					$("#carApproveEditWindow").window('close');
					$("#carApproveList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
</script>
