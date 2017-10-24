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
	<form id="driverCheckAddForm" class="driverCheckForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
		         <tr>
	    		<td width="auto" bgcolor="#F0F8FF" align="right">驾驶证编号</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" name="drivernum"   panelHeight="150" 
    					data-options="valueField:'drivernum',textField:'drivernum',
    						url:'carDriver/get_data', editable:false, required:true" />
	            	
	            </td>
	            </tr>
	             <tr>
	    		<td bgcolor="#F0F8FF" align="right">驾驶员姓名</td>
	            <td>
	            	<input class="easyui-combobox" name="drivername"   panelHeight="150" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', editable:false, required:true" />
	            </td>
	            </tr>
	            <tr>
        		<td bgcolor="#F0F8FF" align="right">考核时间</td>
	       		<td>
	       			<input class="easyui-datetimebox" name="kaohetime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td>
	            <input class="easyui-combobox" id="carCombox359" name="usenature" data-options="required:true" panelHeight="auto" size="9px" />
	            <input class="easyui-combobox" id="carNumberCombox359" name="carnumber" data-options="required:true" panelHeight="150" size="10px"/>  
	             </td>
	              </tr>
	            <tr>
        		<td bgcolor="#F0F8FF" align="right">考核得分</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" data-options="required:true" name="kaohescore"></input>
	            </td>
	        </tr>
	        <tr>
    		<td bgcolor="#F0F8FF" align="right">扣分因素</td>
    			<td colspan="3">
    				<textarea style="width:100px;height:100px;visibility:hidden;" name="koufenyinsu"></textarea>
    			</td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="driverCheckParams"/>
	</form>
	<di<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDriverCheckAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearDriverCheckADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
var orderAddEditor;


		$(function(){
			//加载文件上传插件
			orderAddEditor = KindEditor.create("#driverCheckAddForm [name=koufenyinsu]", {
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
	function submitDriverCheckAddForm(){
		//有效性验证
		if(!$('#driverCheckAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		orderAddEditor.sync();
	
		//ajax的post方式提交表单
		//$("#driverCheckAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("driverCheck/insert",$("#driverCheckAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增考核信息成功!');
				clearDriverCheckADDForm();
				$("#driverCheckAddWindow").window('close');
				$("#driverCheckList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearDriverCheckADDForm(){
		$('#driverCheckAddForm').form('reset');
	}
	
	 $('#carCombox359').combobox({  
	        url: "carPublic/get_data",  
	        editable:false,  
	        valueField:'usenature',   
	        textField:'usenature',  
	        panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#carCombox359').val(data.usenature);  
	            var fatherdep= $('#carCombox359').val();
	         
	            $('#carNumberCombox359').combobox({  
	               
	                url:"carPublic/find_nature/"+fatherdep,  
	                valueField:'carnumber',  
	                textField:'carnumber' ,
	                editable:false,
	                onSelect : function(data1){  
	                  $('#carNumberCombox359').val(data1.carnumber); 
	                
	                }
	           
	            }).combobox('clear');  
	        }  
	    });  
	
</script>
