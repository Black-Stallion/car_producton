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
	<form id="youEditForm" class="carYouapplyForm" method="post">
		<input type="hidden" name="yapplyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">选择申请人</td>
	            <td width="auto" >
	            	<input  class="easyui-combobox" name="applyname" panelHeight="150"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep',required:true,editable:false" />
	            </td>
	             </tr> 
	           <tr>
	             <td bgcolor="#F0F8FF" align="right">选择审批人</td> 
    				<td>
	            	<input class="easyui-combobox" name="approvename"   panelHeight="150" 
    					data-options="valueField:'username',textField:'username',
    						url:'user/find_data', required:true" />
    			</td> 
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">申请单位</td>
	            <td>
	            	<input class="easyui-combobox" id="xxdepartmenCombox651"  name="departmentName" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId651" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="xxdepartmenCombox651"  value="${fathername }"panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="xxdepartment651" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="departmentId651" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	        <td bgcolor="#F0F8FF" align="right">申请日期</td>
	            <td><input class="easyui-datetimebox" name="dtime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        		</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">文件上传</td>
    			 <td>
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="youEditFileUploader">上传文件</div>
	                 <input type="hidden" id="youEditFile" name="folds"/>
	            </td>
	        </tr>
	        <input type="hidden" name="stat" value="未审批"/>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 400px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYouapplyEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarYouapplyEditForm(){
		if(!$('#youEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carYouapply/update_all",$("#youEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("input[name='folds']").val(null);
					$("#carYouapplyEditWindow").window('close');
					$("#carYouapplyList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
				$("input[name='folds']").val(null);
				$("#carYouapplyEditWindow").window('close');
				$("#carYouapplyList").datagrid("reload");
			}
		});
	}
	$('#xxdepartmenCombox651').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
     //   panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId651').val(data.departmentId);  
      //     var fatherdep= $('#departmentFrist').val();
     //       $('#xxdepartment651').combobox({  
     //           url:"department/get_data_second/"+fatherdep,  
     //           valueField:'departmentId',  
     //           textField:'departmentName' ,
     //           editable:false,
     //           onSelect : function(data1){ 
     //             $('#departmentId651').val(data1.departmentId);  
     //           }
     //       }).combobox('clear');  
        }  
    });  
	
</script>
