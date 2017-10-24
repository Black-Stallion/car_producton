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
	<form id="driverStudeyEditForm1" class="driverStudeyForm" method="post">
		<input type="hidden" name="studyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	     <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">学习部门</td>
	            <td colspan="3" width="auto" >
	            	<input class="easyui-combobox" id="departmenCombox5661" name="departmentName" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId5661" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox5661" value="${fathername }" panelHeight="auto" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department5661" name="departmentName" panelHeight="200"/>  
    				<input name="departmentId" id="departmentId5661" type="hidden"/>
    				 -->
	            </td>
	        </tr>
		      <tr>
	    		<td  bgcolor="#F0F8FF" align="right">时间</td>
	            <td>
	            	<input class="easyui-datetimebox" name="stutime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
	            	
	            </td>
        			<td bgcolor="#F0F8FF" align="right">主持人</td>
	            	<td> <input class="easyui-textbox" type="text" name="zhuchiren" data-options="required:true"></td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">应到人数</td>
	            <td>
	            <input class="easyui-numberbox" type="text" name="yingdao" >
	             </td>
        			<td bgcolor="#F0F8FF" align="right">实到人数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="shidao" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">实到人员</td>
	            <td colspan="3"> <textarea style="width:200px;height:100px;visibility:hidden;" name="shidaoname"></textarea></td>
	       		
	        </tr>
	         <tr>
    		
	       		<td  bgcolor="#F0F8FF" align="right">未到人员</td>
	            <td colspan="3"><textarea style="width:200px;height:100px;visibility:hidden;" name="weidaoname"></textarea></td>
	        </tr>
	         <tr>
    		
	       		<td  bgcolor="#F0F8FF" align="right">学习内容</td>
	            <td colspan="3"><textarea style="width:200px;height:200px;visibility:hidden;" name="content"></textarea></td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDriverStudeyEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">


	function submitDriverStudeyEditForm(){
		if(!$('#driverStudeyEditForm1').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		send2AddEditor.sync();
		send2AddEditor1.sync();
		send2AddEditor2.sync();
		$.post("driverStudey/update_all",$("#driverStudeyEditForm1").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("#driverStudeyEditWindow").window('close');
					$("#driverStudeyList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	$('#departmenCombox5661').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
    //    panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId5661').val(data.departmentId);  
          //  var fatherdep= $('#departmentFrist').val();
         //   $('#department5661').combobox({  
         //       url:"department/get_data_second/"+fatherdep,  
         //       valueField:'departmentId',  
         //       textField:'departmentName',
         //       editable:false,  
          //      onSelect : function(data1){  
         //         $('#departmentId5661').val(data1.departmentId);  
          //      }
         //   }).combobox('clear');  
        }  
    }); 

</script>
