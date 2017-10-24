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
	<form id="carUsingEditForm" class="carUsingForm" method="post">
		<input type="hidden" name="usingId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
		    <tr>
	    		<td width="auto" bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td width="auto">
	            	<input class="easyui-combobox" id="carCombox105" data-options="required:true" name="usenature" panelHeight="auto" size="9px" />
	            	<input  id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox105" name="carnumber" data-options="required:true" panelHeight="150" size="10px"/>  
    				<input name="carId" id="carId105" type="hidden"/>
	            	
	            </td>
        			<td width="auto" bgcolor="#F0F8FF" align="right">运用年</td>
	            	<td width="auto"> <input class="easyui-numberbox" type="text" name="usingyear" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">运用月</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="usingmonth" data-options="required:true">
	             </td>
        			<td bgcolor="#F0F8FF" align="right">路码表月终读数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="monthnumbers"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">月公里数</td>
	            <td><input class="easyui-numberbox" type="text" name="monthkm" data-options="required:true"> </td>
	            <td bgcolor="#F0F8FF" align="right">月燃油数</td>
	       		<td>
	            	<input class="easyui-numberbox" type="text" name="monthry" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">天数</td>
	            <td><input class="easyui-numberbox" precision="1" type="text" name="monthdays"> </td>
        		
	            <td bgcolor="#F0F8FF" align="right">趟数</td>
	            <td><input class="easyui-numberbox" type="text" name="monthtime" ></td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">润滑油</td>
	            <td><input class="easyui-textbox" type="text" name="monthrhy"> </td>
	            <td bgcolor="#F0F8FF" align="right">过路，桥，停车费用</td>
	            <td><input class="easyui-textbox" type="text" name="kindscost"> </td>
	        </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">备注</td>
	            <td colspan="3">
	            	<input class="easyui-textbox" type="text" name="note" size="78" ></texarea>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 550px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarUsingEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarUsingEditForm(){
		if(!$('#carUsingEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carUsing/update_all",$("#carUsingEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改记录成功!','info',function(){
					$("#carUsingEditWindow").window('close');
					$("#carUsingList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	$('#carCombox105').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox105').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId105').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
