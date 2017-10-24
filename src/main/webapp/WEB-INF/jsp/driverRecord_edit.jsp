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
	<form id="driverRecordEditForm" class="driverRecordForm" method="post">
		<input type="hidden" name="driveRecordId"/>
		<center>
	    <table class="border-table" cellpadding="5" align="center">
		    <tr>
	    		<td width="120px" bgcolor="#F0F8FF" align="right">驾驶证编号</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" name="drivernum"   panelHeight="100" 
    					data-options="valueField:'drivernum',textField:'drivernum',
    						url:'carDriver/get_data',editable:false" />
	            	
	            </td>
	             </tr>
	             <tr>
	    		<td bgcolor="#F0F8FF" align="right">驾驶员姓名</td>
	            <td>
	            	<input class="easyui-combobox" name="drivername"   panelHeight="100" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', required:true,editable:false" />
	            </td>
	            </tr>
	            <tr>
        		<td  bgcolor="#F0F8FF" align="right">考核时间</td>
	       		<td>
	       			<input class="easyui-datetimebox" name="kaohetime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">起</td>
	            <td>
	            <input class="easyui-textbox" type="text" name="drivestart" >
	             </td>
	              </tr>
	         <tr>
        			<td bgcolor="#F0F8FF" align="right">止</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="driveend"  ></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">累计</td>
    				<td >
    					 <input class="easyui-textbox" type="text" name="total" ></input>
    				</td>
	        </tr>
	    </table>
	    </center>
	</form>
	<div style="padding:5px 0 0 250px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDriverRecordEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">

	function submitDriverRecordEditForm(){
		if(!$('#driverRecordEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("driverRecord/update_all",$("#driverRecordEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改里程信息成功!','info',function(){
					$("#driverRecordEditWindow").window('close');
					$("#driverRecordList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	
	

	
</script>
