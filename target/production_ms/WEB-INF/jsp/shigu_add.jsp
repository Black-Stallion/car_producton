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
	<form id="shiguAddForm1" class="shiguEditForm1" method="post">
	    <table class="border-table" cellpadding="5" align="center">
	    	<tr>
	    	    <td width="auto" bgcolor="#F0F8FF" align="right">事故编号</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="shigucode" data-options="required:true"></input>
	            </td>
	    	  	<td width="auto" bgcolor="#F0F8FF" align="right">事故时间</td>
	       		<td width="auto">
	       			<input class="easyui-datetimebox" name="shigutime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
	    	 </tr>
	    	 <tr>
	    	 	<td bgcolor="#F0F8FF" align="right">事故地点</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="place" data-options="required:true"></input>
	            </td>
	            <td bgcolor="#F0F8FF" align="right">事故类型</td>
	            <td>
	            	<select id="shigutype" class="easyui-combobox" name="shigutype" panelHeight="auto" 
	            		data-options="required:true,width:150, editable:false">
						<option value="正面碰撞">正面碰撞</option>
						<option value="一侧刮伤">一侧刮伤</option>
						<option value="其他">其他</option>
					</select>
	            </td>
	    	 </tr>
		     <tr>
	    		<td bgcolor="#F0F8FF" align="right">主车司机</td>
	            <td>
	            	<input class="easyui-combobox" name="drivername"   panelHeight="auto" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', required:true,editable:false" />
	            </td>
        		<td bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td>
	            <input class="easyui-combobox" id="carCombox1459" name="usenature" data-options="required:true" panelHeight="auto" size="9px" />
	            <input class="easyui-combobox" id="carNumberCombox1459" name="carnumber" data-options="required:true" panelHeight="150" size="10px"/>  
	             </td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">责任</td>
	            <td colspan="3">
	            <input class="easyui-textbox" type="text" name="zeren" size="90px"></input>
    			
	             </td>
        	
	        </tr>
	        <tr>
    		<td bgcolor="#F0F8FF" align="right">原因</td>
    			<td colspan="3">
    				<textarea style="width:200px;height:100px;visibility:hidden;" name="yuanyin"></textarea>
    			</td>
	             
	       		
	        </tr>
	        <tr>
    		<td  bgcolor="#F0F8FF" align="right">损失情况</td>
    			<td colspan="3">
    				<textarea style="width:200px;height:100px;visibility:hidden;" name="sunshi"></textarea>
    			</td>
	        </tr>
	    </table>
	    <input type="hidden" name="shiguParams"/>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitShiguAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearShiguADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var orderAddEditor;
	var orderAddEditor1;


		$(function(){
			//加载文件上传插件
			orderAddEditor = KindEditor.create("#shiguAddForm1 [name=yuanyin]", {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
			});
			orderAddEditor1 = KindEditor.create("#shiguAddForm1 [name=sunshi]",{
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
	function submitShiguAddForm(){
		//有效性验证
		if(!$('#shiguAddForm1').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		orderAddEditor.sync();
		orderAddEditor1.sync();
		//ajax的post方式提交表单
		//$("#shiguEditForm1").serialize()将表单序列号为key-value形式的字符串
		$.post("shigu/insert",$("#shiguAddForm1").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增事故记录信息成功!');
				clearShiguADDForm();
				$("#shiguAddWindow").window('close');
				$("#shiguList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearShiguADDForm(){
		$('#shiguAddForm1').form('reset');
	}
	
	 $('#carCombox1459').combobox({  
	        url: "carPublic/get_data",  
	        editable:false,  
	        valueField:'usenature',   
	        textField:'usenature',  
	        panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#carCombox1459').val(data.usenature);  
	            var fatherdep= $('#carCombox1459').val();
	         
	            $('#carNumberCombox1459').combobox({  
	               
	                url:"carPublic/find_nature/"+fatherdep,  
	                valueField:'carnumber',  
	                textField:'carnumber' ,
	                editable:false,
	                onSelect : function(data1){  
	                  $('#carNumberCombox1459').val(data1.carnumber); 
	                
	                }
	           
	            }).combobox('clear');  
	        }  
	    });  
	
</script>
