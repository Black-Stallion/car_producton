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
	<form id="carTireEditForm15" class="carTireForm" method="post">
		<input type="hidden" name="tireId"/>
	    <table class="border-table" cellpadding="5" align="center">
		       <tr>
        		<td width="100px" bgcolor="#F0F8FF" align="right">厂牌</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="changpai" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">规格</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="guige" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">胎号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="taihao" data-options="required:true"></input>
	            </td>
	        </tr> 
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">所在部门</td>
	             <td>
	            	<input class="easyui-combobox" id="departmenComboxz661" name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="checkrecord1" id="departmentId661" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenComboxz661" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="departmentz661" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="checkrecord1" id="departmentId661" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">装车日期</td>
	            <td><input class="easyui-datetimebox" name="startdate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        			</td>
        			  </tr> <tr>
        			<td bgcolor="#F0F8FF" align="right">换下日期</td>
	            <td><input class="easyui-datetimebox" name="enddate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        			</td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">累计公里</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="addkm" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">更换原因</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="why"></input>
	            </td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">检查记录</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="checkrecord"></input>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px 0 0 320px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarTireEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarTireEditForm(){
		if(!$('#carTireEditForm15').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carTire/update_all",$("#carTireEditForm15").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改轮胎记录成功!','info',function(){
					$("#carTireEditWindow").window('close');
					$("#carTireList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#departmenComboxz661').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId661').val(data.departmentId);  
      //      var fatherdep= $('#departmentFrist').val();
      //      $('#departmentz661').combobox({  
      //          url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName' ,
      //          editable:false,
      //          onSelect : function(data1){  
      //            $('#departmentId661').val(data1.departmentId);  
      //          }
      //      }).combobox('clear');  
        }  
    });  
</script>
