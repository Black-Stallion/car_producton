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
	<form id="orderEditForm" class="carDieForm" method="post">
		<input type="hidden" name="dieId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	     <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">车架号</td>
	            <td width="auto">
	            	<input class="easyui-combobox" id="41diecarsCombox" name="rbeiyong1" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="rbeiyong1" type="hidden"/>
    				<input class="easyui-combobox" id="41diecarNumbersCombox" name="newnum"  data-options="required:true" panelHeight="150px" size="18px"/>  
    				<input id="newnum" type="hidden"/>
    				</td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">填写人</td>
	            <td>
	            	<input  class="easyui-combobox" name="rbieyong2" panelHeight="150"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_data', required:true,editable:false" />
	            </td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">回收单位</td>
	             <td>
	            	<input class="easyui-combobox" id="51diedepartmenComboxz1" name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId4" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="51diedepartmenComboxz1" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="51diedepartmentz1" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="departmentId4" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">残值</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="stats"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">分局批文</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="removenum" style="width: 200px;"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">回收证号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="inorgan" style="width: 200px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">报废日期</td>
	            <td>
	            	<input class="easyui-datetimebox" name="removetime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	        
	          <tr>
        	<td bgcolor="#F0F8FF" align="right">回收证明附件</td>
	            <td>
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="orderEditFileUploader">上传文件</div>
	                 <input type="hidden" id="orderEditFile" name="notes"/>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 450px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarInEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarInEditForm(){
		if(!$('#orderEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carDie/update_all",$("#orderEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("input[name='notes']").val(null);
					$("#carDieEditWindow").window('close');
					$("#carDieList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#51diedepartmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
    //    panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId4').val(data.departmentId);  
    //        var fatherdep= $('#departmentFrist').val();
    //        $('#51diedepartmentz1').combobox({  
    //            url:"department/get_data_second/"+fatherdep,  
    //            valueField:'departmentId',  
    //            textField:'departmentName' ,
    //            editable:false,
    //            onSelect : function(data1){  
    //              $('#departmentId4').val(data1.departmentId);  
    //            }
    //        }).combobox('clear');  
        }  
    });  
	$('#41diecarsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#rbeiyong1').val(data.usenature);  
            var fatherdep= $('#rbeiyong1').val();
          
            $('#41diecarNumbersCombox').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carcjh',  
                textField:'carcjh' ,
                onSelect : function(data1){  
                  $('#newnum').val(data1.carnumber);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
