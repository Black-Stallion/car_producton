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
	<form id="youaEditForm" class="carYouapproveForm" method="post">
		<input type="hidden" name="yapplyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">申请人</td>
	            <td width="auto" >
	            	<input  class="easyui-textbox" name="applyname" panelHeight="150"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep', required:true,editable:false" />
	            </td>
	             </tr> 
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">申请单位</td>
	            <td>
    				<input class="easyui-textbox" id="xxdepartment652" name="departmentName" editable="false"/>  
    				<input name="departmentId" id="departmentId652" type="hidden"/>
	            </td>
	        </tr>
	        <tr>
	        <td bgcolor="#F0F8FF" align="right">申请日期</td>
	            <td><input class="easyui-datetimebox" name="dtime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        		</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">上传的文件</td>
    			 <td>
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="youaEditFileUploader"></div>
	                 <input type="hidden" id="youaEditFile" name="folds"/>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">审批</td>
	            <td>
	            <select id="cc223" onchange="SelectModelChange()"  name="stat">
		            		<option selected="selected" value="通过">通过</option>
		            		<option value="未通过">未通过</option>
		        </select> </td>
	        </tr>
	       <tr>
					<td colspan="4">
						<div id="divOverTime2"></div>
					</td>
				</tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 400px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYouapproveEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
function SelectModelChange()
{
        var sel = document.getElementById("cc223").value;
        if(sel=="未通过"){
        	var text = "<span><br/>填写原因:<textarea id=\"qwe1\" rows=\"4\" cols=\"48\" name=\"bei\"></textarea></span>";
			$("#divOverTime2").append(text);
        }else{
        	$("#qwe1").parent().remove();
        }
}
	function submitCarYouapproveEditForm(){
		if(!$('#youaEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carYouapprove/update_id",$("#youaEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','审批成功!','info',function(){
					$("input[name='folds']").val(null);
					$("#carYouapproveEditWindow").window('close');
					$("#carYouapproveList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#xxdepartmenCombox652').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId652').val(data.departmentId);  
            var fatherdep= $('#departmentFrist').val();
          
            $('#xxdepartment652').combobox({  
               
                url:"department/get_data_second/"+fatherdep,  
                valueField:'departmentId',  
                textField:'departmentName' ,
                editable:false,
                onSelect : function(data1){ 
                  $('#departmentId652').val(data1.departmentId);  
                }
           
            }).combobox('clear');  
        }  
    });  
	
</script>
