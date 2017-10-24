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
	<form id="carUsingAddForm" class="carUsingForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
		     <tr>
	    		<td width="auto" bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="carCombox931" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="usenature" id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox931" data-options="required:true" panelHeight="150" size="10px"/>  
    				<input name="carId" id="carId931" type="hidden"/>
	            	
	            </td>
        			<td width="auto" bgcolor="#F0F8FF" align="right">运用年</td>
	            	<td width="auto"> <input class="easyui-numberbox" type="text" name="usingyear" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF" align="right">运用月</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="usingmonth" data-options="required:true">
	             </td>
        			<td  bgcolor="#F0F8FF" align="right">路码表月终读数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="monthnumbers"></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">月公里数</td>
	            <td><input class="easyui-numberbox" type="text" name="monthkm" data-options="required:true"> </td>
	       		<td  bgcolor="#F0F8FF" align="right">月燃油数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="monthry" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF" align="right">天数</td>
	            <td><input class="easyui-numberbox" precision="1" type="text" name="monthdays"> </td>
        		<td  bgcolor="#F0F8FF" align="right">趟数</td>
	            <td><input class="easyui-numberbox" type="text" name="monthtime" ></td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">润滑油</td>
	            <td><input class="easyui-textbox" type="text" name="monthrhy"> </td>
	            <td  bgcolor="#F0F8FF" align="right">过路，桥，停车费用</td>
	            <td><input class="easyui-textbox" type="text" name="kindscost" > </td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">备注</td>
	            <td colspan="3">
	            	<input class="easyui-textbox" type="text" name="note" size="78" ></texarea>
	            </td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="carUsingParams"/>
	</form>
	<div style="padding:5px 0 0 550px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarUsingAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarUsingADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitCarUsingAddForm(){
		//有效性验证
		if(!$('#carUsingAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		//$("#carUsingAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carUsing/insert",$("#carUsingAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增运用记录信息成功!');
				clearCarUsingADDForm();
				$("#carUsingAddWindow").window('close');
				$("#carUsingList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearCarUsingADDForm(){
		$('#carUsingAddForm').form('reset');
	}
	
	$('#carCombox931').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox931').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId931').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
	
</script>
