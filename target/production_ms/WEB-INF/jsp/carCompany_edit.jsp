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
	<form id="carCompanyEditForm15" class="carCompanyForm" method="post">
		<input type="hidden" name="companyId"/>
	   <center>
	    <table class="border-table" cellpadding="5" align="center">
	   <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">使用单位</td>
	             <td width="auto" >
	            	<input class="easyui-combobox" id="partmenComboxz089" name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist089" id="departmentFrist089" type="hidden"/>
    				<input name="departmentId" id="dep089" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="partmenComboxz089" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist089" id="departmentFrist089" type="hidden"/>
    				<input class="easyui-combobox" id="partmentz089" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="dep089" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">车辆保养单位</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 200px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">地址</td>
	            <td>
	            	<input  class="easyui-textbox" precision="2" type="text" name="address"  style="width: 200px;"></input>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:15px 0 0 250px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarCompanyEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitCarCompanyEditForm(){
		if(!$('#carCompanyEditForm15').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("carCompany/update_all",$("#carCompanyEditForm15").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("#carCompanyEditWindow").window('close');
					$("#carCompanyList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#partmenComboxz089').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
        onSelect : function(data){  
            $('#departmentFrist089').val(data.departmentId);  
            $('#dep089').val(data.departmentId);  
          //  var fatherdep= $('#departmentFrist089').val();
          //  $('#partmentz089').combobox({  
          //      url:"department/get_data_second/"+fatherdep,  
          //      valueField:'departmentId',  
          //      textField:'departmentName' ,
          //      editable:false,
          //      onSelect : function(data1){  
          //        $('#dep089').val(data1.departmentId);  
          //      }
          //  }).combobox('clear');  
        }  
    });  
</script>
