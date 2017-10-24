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
	<form id="carDriverEditForm" class="carDriverForm" method="post">
		<input type="hidden" name="driverId"/>
		<center>
	    <table class="border-table" cellpadding="5" align="center">
	        <tr>
	         	 <td width="auto" bgcolor="#F0F8FF" align="right">司机姓名</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="drviername" data-options="required:true"></input>
    			</td>  
	             <td width="auto" bgcolor="#F0F8FF" align="right">性别</td>
	            <td width="auto" >
	            	<select id="cc" class="easyui-combobox" name="sex" panelHeight="auto" 
	            		data-options="required:true,width:150, editable:false">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
    			</td>  
	        </tr>
	        <tr>
	           <td bgcolor="#F0F8FF" align="right">出生年月</td>
	            <td><input class="easyui-datetimebox" name="birthday"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        		</td>
        		 <td bgcolor="#F0F8FF" align="right">文化程度</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="culture" data-options="required:true"></input>
    			</td>  
        		
	        </tr>
	        <tr>
	        	 <td bgcolor="#F0F8FF" align="right">所属部门</td>
	            <td>
	            	<input class="easyui-combobox" id="departmenCombox059"  name="departmentName" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId623" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox059" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department059" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="departmentId623" type="hidden"/>
    				 -->
    			</td>  
    			 <td bgcolor="#F0F8FF" align="right">初次领证</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="firstzheng"></input>
    			</td>  
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">准驾车型</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="cartype" data-options="required:true"></input>
    			</td>  
    			 <td bgcolor="#F0F8FF" align="right">驾驶证号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="drivernum" data-options="required:true"></input>
    			</td>  
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">任职时间</td>
	            <td>
	            	<input class="easyui-datetimebox" name="worktime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
    			</td>  
    			 <td bgcolor="#F0F8FF" align="right">发证机关</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="issueorgan"></input>
    			</td>  
	        </tr>
	          <tr>
	            <td bgcolor="#F0F8FF" align="right">通过安全委员会考核时间</td>
	            <td colspan="3">
	            	<input class="easyui-datetimebox" name="checktime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
    			</td>  
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 500px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarDriverEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarDriverEditForm(){
		if(!$('#carDriverEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carDriver/update_all",$("#carDriverEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改司机信息成功!','info',function(){
					$("#carDriverEditWindow").window('close');
					$("#carDriverList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	
	
	    $('#departmenCombox059').combobox({  
	        url: "department/get_data_first",  
	        editable:false,  
	        valueField:'departmentId',   
	        textField:'departmentName',  
	      //  panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#departmentFrist').val(data.departmentId);  
	            $('#departmentId623').val(data.departmentId);  
	      //      var fatherdep= $('#departmentFrist').val();
	      //      $('#department059').combobox({  
	      //          url:"department/get_data_second/"+fatherdep,  
	      //          valueField:'departmentId',  
	      //          textField:'departmentName' ,
	      //          editable:false,  
	      //          onSelect : function(data1){  
	      //            $('#departmentId623').val(data1.departmentId);  
	      //          }
	     //       }).combobox('clear');  
	        }  
	    });  
</script>
