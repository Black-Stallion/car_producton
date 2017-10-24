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
	<form id="carBigEditForm15" class="carBigForm" method="post">
		<input type="hidden" name="bigId"/>
	   <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">所换大件车辆</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="4carsCombox661" name="nature" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="rbeiyong661" type="hidden"/>
    				<input class="easyui-combobox" id="4carNumbersCombox661" name="carnumber" data-options="required:true,editable:false" panelHeight="150" size="10px"/>  
    				<input name="carId" id="newnum661" type="hidden"/>
    				</td>
	        </tr>
	    <tr>
	            <td bgcolor="#F0F8FF" align="right">日期</td>
	            <td>
	            	<input class="easyui-datetimebox" name="changedate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"></input>
	            </td>
	            </tr>
	             <tr>
        			<td bgcolor="#F0F8FF" align="right">所换大件</td>
	            	<td colspan="3">
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="changbig"></textarea>
	            </td>
	        </tr>
	         <tr>
        			<td bgcolor="#F0F8FF" align="right">原因</td>
	            	<td colspan="3">
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="why"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td  bgcolor="#F0F8FF" align="right">选择主车司机</td>
	            <td><input class="easyui-combobox" name="driverId" panelHeight="auto" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', required:true,editable:false" />
	             </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:15px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarBigEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
var bigEditor;
var big1Editor;
$(function(){
	bigEditor = KindEditor.create("#carBigEditForm15 [name=changbig]", {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
	big1Editor = KindEditor.create("#carBigEditForm15 [name=why]", {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
});
	function submitCarBigEditForm(){
		if(!$('#carBigEditForm15').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		bigEditor.sync();
		big1Editor.sync();
		$.post("carBig/update_all",$("#carBigEditForm15").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改记录成功!','info',function(){
					$("#carBigEditWindow").window('close');
					$("#carBigList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#4carsCombox661').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#rbeiyong661').val(data.usenature);  
            var fatherdep= $('#rbeiyong661').val();
          
            $('#4carNumbersCombox661').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#newnum661').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
