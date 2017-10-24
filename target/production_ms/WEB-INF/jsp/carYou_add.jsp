<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
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
	<form id="carYouAddForm" class="carYouForm" method="post">
	<center>
	    <table class="border-table" cellpadding="5" align="center">
	        <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">油卡号码</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="younumber" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">部门</td>
	            <td>
	            	<input class="easyui-combobox" id="departmenCombox522" panelHeight="200" data-options="required:true" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId522" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox522" panelHeight="auto" data-options="required:true" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department522"  panelHeight="200"/>  
    				<input name="departmentId" id="departmentId522" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">油卡状态</td>
	            <td>
		            <select class="easyui-combobox" name="beiyong1" panelHeight="auto" data-options="width:150,editable:false">
						<option value="1">有效</option>
						<option value="2">停用</option>
					</select>
				</td>
	        </tr>
	        <input type="hidden" name="beiyong2" value="0.00">
	    </table>
	    </center>
	</form>
	<div style="padding:5px 0 0 400px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYouAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarYouAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitCarYouAddForm(){
		//有效性验证
		if(!$('#carYouAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//$("#carYouAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carYou/insert",$("#carYouAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', '新增油卡成功!');
				clearCarYouAddForm();
				$("#carYouAddWindow").window('close');
				$("#carYouList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearCarYouAddForm(){
		$('#carYouAddForm').form('reset');
	}
	
    $('#departmenCombox522').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
       // panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId522').val(data.departmentId);  
       //     var fatherdep= $('#departmentFrist').val();
       //     $('#department522').combobox({  
       //         url:"department/get_data_second/"+fatherdep, 
       //         editable:false, 
       //         valueField:'departmentId',  
       //         textField:'departmentName',
       //         onSelect : function(data1){  
       //           $('#departmentId522').val(data1.departmentId);  
       //         }
       //     }).combobox('clear');  
        }  
    });  
	
</script>
