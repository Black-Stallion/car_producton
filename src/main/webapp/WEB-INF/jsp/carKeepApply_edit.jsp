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
	<form id="carKeepApplyEditForm" class="carKeepApplyForm" method="post">
		<input type="hidden" name="applyId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	      <td width="auto" bgcolor="#F0F8FF" align="right">维护车辆</td>
	            <td width="auto">
	            	<input class="easyui-combobox" id="41xkeepcarsCombox" name="beiyong1" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="beiyong1" type="hidden"/>
    				<input class="easyui-combobox" id="41xkeepcarNumbersCombox" name="carnum"  data-options="required:true,editable:false" panelHeight="150" size="10px"/>  
    				<input id="carnum" type="hidden"/>
    				</td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">选择申请人</td>
	            <td>
	            	<input  class="easyui-combobox" name="applyname" panelHeight="150"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep',required:true,editable:false" />
	            </td>
	            </tr>
	         <td bgcolor="#F0F8FF" align="right">选择审批人</td> 
    				<td>
	            	<input class="easyui-combobox" name="approve"   panelHeight="150" 
    					data-options="valueField:'username',textField:'username',
    						url:'user/find_data',required:true" />
    			</td> 
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">所在部门</td>
	             <td>
	            	<input class="easyui-combobox" id="51xkeepdepartmenComboxz186"  name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId86" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="51xkeepdepartmenComboxz186" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="51xkeepdepartmentz186" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="departmentId86" type="hidden"/>
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
	            <td bgcolor="#F0F8FF" align="right">开始日期</td>
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
	            	data-options="valueField:'name',textField:'name',
    						url:'carCompany/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
        			<td bgcolor="#F0F8FF" align="right">维护级别或修理项目</td>
	            	<td colspan="3">
	                <textarea style="width:200px;height:100px;visibility:hidden;" name="repairtype"></textarea>
	            </td>
	        </tr>
	        <input type="hidden" name="stats" value="未审批"/>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 700px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarKeepApplyEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
var keep1applyEditor;
$(function(){
	keep1applyEditor = KindEditor.create("#carKeepApplyEditForm [name=repairtype]", {
		resizeType : 1,
		allowPreviewEmoticons : false,
		allowImageUpload : false,
		items : [
			'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
			'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
			'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
	});
});
	function submitCarKeepApplyEditForm(){
		if(!$('#carKeepApplyEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		keep1applyEditor.sync();
		$.post("carKeepApply/update_all",$("#carKeepApplyEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("#carKeepApplyEditWindow").window('close');
					$("#carKeepApplyList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#51xkeepdepartmenComboxz186').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
     //   panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId86').val(data.departmentId);  
    //        var fatherdep= $('#departmentFrist').val();
    //        $('#51xkeepdepartmentz186').combobox({  
    //            url:"department/get_data_second/"+fatherdep,  
    //            valueField:'departmentId',  
    //            textField:'departmentName' ,
    //            editable:false,
    //            onSelect : function(data1){  
    //              $('#departmentId86').val(data1.departmentId);  
    //            }
    //        }).combobox('clear');  
        }  
    });  
	$('#41xkeepcarsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#beiyong1').val(data.usenature);  
            var fatherdep= $('#beiyong1').val();
            $('#41xkeepcarNumbersCombox').combobox({  
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carnumber',  
                textField:'carnumber' ,
                panelHeight:'auto',  
                editable:false,
                onSelect : function(data1){  
                  $('#carnum').val(data1.carnumber);  
                }
            }).combobox('clear');  
        }  
    });  
</script>
