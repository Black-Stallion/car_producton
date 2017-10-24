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
	<form id="weiguiAddForm" class="weiguiForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
		              <tr>
	            <td width="110px" bgcolor="#F0F8FF" align="right">车牌号</td>
	            <td width="auto" >
	            <input class="easyui-combobox" id="carCombox3511" name="usenature" data-options="" panelHeight="auto" size="9px" />
	            <input class="easyui-combobox" id="carNumberCombox3511" name="carnumb" data-options="required:true" panelHeight="150" size="13px"/>  
	             </td>
	             </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">违规时间</td>
	       		<td>
	       			<input class="easyui-datetimebox" name="weiguitime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">违规地点</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="place"></input>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">违规行为</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="xingwei"></input>
	            </td>
	        </tr>
	        <tr>
    		
    			<td bgcolor="#F0F8FF" align="right">积分</td>
	            <td>
	            	<input class="easyui-numberbox" precision="1" type="text" name="score"></input>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">罚款金额</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="money"></input>
	            </td>
	             
	       		
	        </tr>
	         <tr>
    		
    			<td bgcolor="#F0F8FF" align="right">是否交款</td>
	            <td>
	            	<select id="issend" class="easyui-combobox" name="issend" panelHeight="auto" 
	            		data-options="required:true,width:150, editable:false">
						<option value="是">是</option>
						<option value="否">否</option>
					</select>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">主车司机</td>
	            <td>
	            	<input class="easyui-combobox" name="drivername"   panelHeight="150" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data',required:true,editable:false" />
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">处理人</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="chuliname"></input>
	            </td>  </tr>
        		<tr>
        		<td bgcolor="#F0F8FF" align="right">处理时间</td>
	            <td>
	       			<input class="easyui-datetimebox" name="chulitime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	       		</td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="weiguiParams"/>
	</form>
	<div style="padding:5px 0 0 300px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitWeiguiAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearWeiguiADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">

	//提交表单
	function submitWeiguiAddForm(){
		//有效性验证
		if(!$('#weiguiAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
	
		//ajax的post方式提交表单
		//$("#weiguiAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("weigui/insert",$("#weiguiAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增违规记录成功!');
				clearWeiguiADDForm();
				$("#weiguiAddWindow").window('close');
				$("#weiguiList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearWeiguiADDForm(){
		$('#weiguiAddForm').form('reset');
	}
	
	 $('#carCombox3511').combobox({  
	        url: "carPublic/get_data",  
	        editable:false,  
	        valueField:'usenature',   
	        textField:'usenature',  
	        panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#carCombox3511').val(data.usenature);  
	            var fatherdep= $('#carCombox3511').val();
	         
	            $('#carNumberCombox3511').combobox({  
	               
	                url:"carPublic/find_nature/"+fatherdep,  
	                valueField:'carId',  
	                textField:'carnumber' ,
	                editable:false,
	                onSelect : function(data1){  
	                  $('#carNumberCombox3511').val(data1.carId); 
	                
	                }
	           
	            }).combobox('clear');  
	        }  
	    });  
	
</script>
