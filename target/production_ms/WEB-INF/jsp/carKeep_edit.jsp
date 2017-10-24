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
	<form id="carKeepEditForm" class="carKeepForm" method="post">
		<input type="hidden" name="keepId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	      <td width="auto" bgcolor="#F0F8FF" align="right">保养车辆</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="41qkeep1carsCombox" name="beiyong2" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="beiyong254" type="hidden"/>
    				<input class="easyui-combobox" id="41qkeep1carNumbersCombox" name="carnumber"  data-options="required:true,editable:false" panelHeight="auto" size="10px"/>  
    				<input name="carId" id="carnum54" type="hidden"/>
    				</td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">所在部门</td>
	             <td>
	            	<input class="easyui-combobox" id="51qkeep1departmenComboxz188" name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId88" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="51qkeep1departmenComboxz188" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="51qkeep1departmentz188" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="departmentId88" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">当前里程</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="intervalkm" data-options="required:true" style="width: 200px;"></input>
	            </td>
	        </tr>
	        <tr> 
	            <td bgcolor="#F0F8FF" align="right">开始日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="startdate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">截止日期</td>
	            <td>
	            	<input class="easyui-datetimebox" name="enddate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">厂家名称</td>
	           <td>
	            	<input  class="easyui-combobox" name="suppliername" panelHeight="auto"
	            	data-options="valueField:'name',textField:'name',editable:false,
    						url:'carCompany/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
        			<td bgcolor="#F0F8FF" align="right">保养级别或保养项目</td>
	            	<td colspan="3">
	                <textarea width="100px" height="100px" visibility="hidden" name="repairtype"></textarea>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarKeepEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
var keep1Editor;
$(function(){
	keep1Editor = KindEditor.create("#carKeepEditForm [name=repairtype]",{
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
});
	function submitCarKeepEditForm(){
		if(!$('#carKeepEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		keep1Editor.sync();
		$.post("carKeep/update_all",$("#carKeepEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功'+data.msg,'info',function(){
					$("#carKeepEditWindow").window('close');
					$("#carKeepList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#51qkeep1departmenComboxz188').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId88').val(data.departmentId);  
      //      var fatherdep= $('#departmentFrist').val();
      //      $('#51qkeep1departmentz188').combobox({  
      //          url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName',
      //          editable:false,
      //          onSelect : function(data1){  
      //            $('#departmentId88').val(data1.departmentId);  
      //         }
      //      }).combobox('clear');  
        }  
    });  
	$('#41qkeep1carsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#beiyong254').val(data.usenature);  
            var fatherdep= $('#beiyong254').val();
          
            $('#41qkeep1carNumbersCombox').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                panelHeight:'auto',  
                editable:false,
                onSelect : function(data1){  
                  $('#carnum54').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
