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
	<form id="carCheckAddForm" class="carCheckForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
		       <tr>
	    		<td width="auto" bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="carCombox91" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="usenature" id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox91" data-options="required:true" panelHeight="150" size="10px"/>  
    				<input name="carId" id="carId91" type="hidden"/>
	            	
	            </td>
        			<td width="auto" bgcolor="#F0F8FF" align="right">运用年</td>
	            	<td width="auto"> <input class="easyui-numberbox" type="text" name="checkyear" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">运用月</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="checkmonth" data-options="required:true">
	             </td>
        			<td bgcolor="#F0F8FF" align="right">车况评分</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="carscore"></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">存在问题</td>
	            <td colspan="3"> <textarea style="width:200px;height:100px;visibility:hidden;" name="carquestion"></textarea></td>
	       		
	        </tr>
	         <tr>
    		
	       		<td  bgcolor="#F0F8FF" align="right">处理结果</td>
	            <td colspan="3"><textarea style="width:200px;height:100px;visibility:hidden;" name="results"></textarea></td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="carCheckParams"/>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarCheckAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarCheckADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
var orderAddEditor;
var orderAddEditor1;

		$(function(){
			//加载文件上传插件
			orderAddEditor = KindEditor.create("#carCheckAddForm [name=carquestion]", {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
			});
			orderAddEditor1 = KindEditor.create("#carCheckAddForm [name=results]", {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
			});
		
		});
	//提交表单
	function submitCarCheckAddForm(){
		//有效性验证
		if(!$('#carCheckAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		orderAddEditor.sync();
		orderAddEditor1.sync();
		//ajax的post方式提交表单
		//$("#carCheckAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carCheck/insert",$("#carCheckAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增运用记录信息成功!');
				clearCarCheckADDForm();
				$("#carCheckAddWindow").window('close');
				$("#carCheckList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearCarCheckADDForm(){
		$('#carCheckAddForm').form('reset');
	}
	
	$('#carCombox91').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox91').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId91').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
	
</script>
