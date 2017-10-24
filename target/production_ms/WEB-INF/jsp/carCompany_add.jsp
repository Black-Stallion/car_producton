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
	<form id="carCompanyAddForm" class="carCompanyForm" method="post">
	<center>
	    <table class="border-table" cellpadding="5" align="center">
	        <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">使用单位</td>
	             <td width="auto" >
	            	<input class="easyui-combobox" id="2departmenComboxz68" data-options="required:true" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="dep68" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="2departmenComboxz68" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="2departmentz68"  panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="dep68" type="hidden"/>
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
	    <input type="hidden" name="carCompanyParams"/>
	</form>
	<div style="padding:15px 0 0 250px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitcarCompanyAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearcarCompanyAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitcarCompanyAddForm(){
		//有效性验证
		if(!$('#carCompanyAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		//ajax的post方式提交表单
		//$("#carCompanyAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carCompany/insert",$("#carCompanyAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增信息成功!');
				clearcarCompanyAddForm();
				$("#carCompanyAddWindow").window('close');
				$("#carCompanyList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	$('#2departmenComboxz68').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#dep68').val(data.departmentId);  
           // var fatherdep= $('#departmentFrist').val();
           // $('#2departmentz68').combobox({  
            //    url:"department/get_data_second/"+fatherdep,  
           //     valueField:'departmentId',  
           //     textField:'departmentName' ,
           //     editable:false,
          //      onSelect : function(data1){  
          //        $('#dep68').val(data1.departmentId);  
          //      }
          //  }).combobox('clear');  
        }  
    });  
	function clearcarCompanyAddForm(){
		$('#carCompanyAddForm').form('reset');
	}
</script>
