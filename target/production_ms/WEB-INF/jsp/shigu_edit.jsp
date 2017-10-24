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
	<form id="shiguEditForm1" class="shiguForm" method="post">
		<input type="hidden" name="shiguId"/>
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
    						url:'carDriver/get_data',required:true,editable:false" />
	            	
	            </td>
        		<td bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td>
	            <input class="easyui-combobox" id="carCombox459" name="usenature" panelHeight="auto" size="9px" />
	            <input class="easyui-combobox" id="carNumberCombox459" name="carnumber" data-options="required:true" panelHeight="150" size="10px"/>  
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
    		<td bgcolor="#F0F8FF" align="right">损失情况</td>
    			<td colspan="3">
    				<textarea style="width:200px;height:100px;visibility:hidden;" name="sunshi"></textarea>
    			</td>
	             
	       		
	        </tr>
	    </table>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitShiguEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitShiguEditForm(){
		if(!$('#shiguEditForm1').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		send2AddEditor.sync();
		send2AddEditor1.sync();
		$.post("shigu/update_all",$("#shiguEditForm1").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改事故记录成功!','info',function(){
					clearShiguEditForm();
					$("#shiguEditWindow").window('close');
					$("#shiguList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	function clearShiguEditForm(){
		$('#shiguEditForm1').form('reset');
	}
	 $('#carCombox459').combobox({  
	        url: "carPublic/get_data",  
	        editable:false,  
	        valueField:'usenature',   
	        textField:'usenature',  
	        panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#carCombox459').val(data.usenature);  
	            var fatherdep= $('#carCombox459').val();
	         
	            $('#carNumberCombox459').combobox({  
	               
	                url:"carPublic/find_nature/"+fatherdep,  
	                valueField:'carnumber',  
	                textField:'carnumber' ,
	                editable:false,
	                onSelect : function(data1){  
	                  $('#carNumberCombox459').val(data1.carnumber); 
	                }
	           
	            }).combobox('clear');  
	        }  
	    });  

</script>
