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
	<form id="carInEditForm" class="carInForm" method="post">
		<input type="hidden" name="inId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	     <tr>
	            <td width="100px" bgcolor="#F0F8FF" align="right">调入车辆</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="1fcarsCombox" name="rbeiyong1" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="rbeiyong1" type="hidden"/>
    				<input class="easyui-combobox" id="1fcarNumbersCombox" name="carnumber" data-options="required:true" panelHeight="auto" size="10px"/>  
    				<input  id="newnum2" name="carId" type="hidden"/>
    				</td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">调入人</td>
	            <td>
	            	<input  class="easyui-combobox" name="rbieyong2" panelHeight="150"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">接收单位</td>
	             <td>
	            	<input class="easyui-combobox" id="1departmenComboxz1" name="departmentName"  panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="1inorgan" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="1departmenComboxz1" value="${fathername }"  panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="1departmentz1" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="1inorgan" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">调出单位</td>
	             <td>
	            	<input class="easyui-combobox" id="21departmenComboxz1" name="departmentName1" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="outorgan" id="1outorgan" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="21departmenComboxz1" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="21departmentz1" name="departmentName1" panelHeight="200" size="13px"/>  
    				<input name="outorgan" id="1outorgan" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">调拨文号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="removenum" style="width: 200px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">调入日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="removetime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">类型</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="stats" data-options="required:true,editable:false" value="调入"></input>
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
		if(!$('#carInEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carIn/update_all",$("#carInEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("#carInEditWindow").window('close');
					$("#carInList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#1departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#1inorgan').val(data.departmentId);  
       //     var fatherdep= $('#departmentFrist').val();
       //     $('#1departmentz1').combobox({  
       //         url:"department/get_data_second/"+fatherdep,  
       //         valueField:'departmentId',  
       //         textField:'departmentName' ,
       ///         editable:false,
       //         onSelect : function(data1){  
       //           $('#1inorgan').val(data1.departmentId);  
       //         }
       //     }).combobox('clear');  
        }  
    });  
	$('#21departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
     //   panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#1outorgan').val(data.departmentId);  
     //       var fatherdep= $('#departmentFrist').val();
     //       $('#21departmentz1').combobox({  
     //           url:"department/get_data_second/"+fatherdep,  
     //           valueField:'departmentId',  
     //           textField:'departmentName' ,
     //           editable:false,
     //           onSelect : function(data1){  
     //             $('#1outorgan').val(data1.departmentId);  
     //           }
     //       }).combobox('clear');  
        }  
    });  
	$('#1fcarsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#rbeiyong1').val(data.usenature);  
            var fatherdep= $('#rbeiyong1').val();
            $('#1fcarNumbersCombox').combobox({  
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                onSelect : function(data1){  
                  $('#newnum2').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
