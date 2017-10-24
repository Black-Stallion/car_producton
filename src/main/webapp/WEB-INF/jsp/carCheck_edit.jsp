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
	<form id="carCheckEditForm" class="carCheckForm" method="post">
		<input type="hidden" name="checkId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
		   <tr>
	    		<td width="auto" bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="carCombox92" name="usenature" name data-options="required:true" panelHeight="auto" size="9px" />
	            	<input id="usenature" type="hidden"/>
    				<input class="easyui-combobox" id="carNumberCombox92" name="carnumber"data-options="required:true" panelHeight="150" size="10px"/>  
    				<input name="carId" id="carId92" type="hidden"/>
	            	
	            </td>
        			<td width="auto" bgcolor="#F0F8FF" align="right">运用年</td>
	            	<td width="auto" > <input class="easyui-numberbox" type="text" name="checkyear" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF" align="right">运用月</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="checkmonth" data-options="required:true">
	             </td>
        			<td bgcolor="#F0F8FF" align="right">车况评分</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="carscore"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">存在问题</td>
	            <td colspan="3"> <textarea style="width:200px;height:100px;visibility:hidden;" name="carquestion"></textarea></td>
	       		
	        </tr>
	         <tr>
    		
	       		<td bgcolor="#F0F8FF" align="right">处理结果</td>
	            <td colspan="3"><textarea style="width:200px;height:100px;visibility:hidden;" name="results"></textarea></td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarCheckEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
var send2AddEditor;
var send2AddEditor1;

$(function(){
	//加载文件上传插件

	send2AddEditor = KindEditor.create("#carCheckEditForm [name=carquestion]", {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
	send2AddEditor1 = KindEditor.create("#carCheckEditForm [name=results]", {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
});

	function submitCarCheckEditForm(){
		if(!$('#carCheckEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		send2AddEditor.sync();
		send2AddEditor1.sync();
		$.post("carCheck/update_all",$("#carCheckEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改记录成功!','info',function(){
					$("#carCheckEditWindow").window('close');
					$("#carCheckList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	$('#carCombox92').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox92').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId92').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
	

	$('#carCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature').val(data.usenature);  
            var fatherdep= $('#usenature').val();
          
            $('#carNumberCombox').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
