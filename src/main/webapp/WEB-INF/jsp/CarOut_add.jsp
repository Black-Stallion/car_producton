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
	<form id="carOutAddForm" class="carOutForm" method="post">
	<center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	            <td width="100px" bgcolor="#F0F8FF" align="right">调出车辆</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="4carsCombox"  data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input name="rbeiyong1" id="rbeiyong85" type="hidden"/>
    				<input class="easyui-combobox" id="4carNumbersCombox"  data-options="required:true" panelHeight="150px" size="10px"/>  
    				<input name="carId" id="newnum85" type="hidden"/>
    				</td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">调出人</td>
	            <td>
	            	<input  class="easyui-combobox" name="rbieyong2" panelHeight="150"value="${username }"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_data',required:true,editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">接收单位</td>
	             <td>
	            	<input class="easyui-combobox" id="4departmenComboxz1" data-options="required:true" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="inorgan85" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="4departmenComboxz1" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="4departmentz1" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="inorgan85" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">调出单位</td>
	             <td>
	            	<input class="easyui-combobox" id="5departmenComboxz1" data-options="required:true" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="outorgan" id="outorgan85" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="5departmenComboxz1" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="5departmentz1" panelHeight="200" size="13px"/>  
    				<input name="outorgan" id="outorgan85" type="hidden"/>
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
	            <td bgcolor="#F0F8FF" align="right">调出日期</td>
	            <td>
	            	<input class="easyui-datetimebox" name="removetime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">类型</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="stats" data-options="required:true,editable:false" value="调出"></input>
	            </td>
	        </tr>
	    </table>
	    </center>
	    <input type="hidden" name="carOutParams"/>
	</form>
	<div style="padding:5px 0 0 450px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitcarOutAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearcarOutAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitcarOutAddForm(){
		//有效性验证
		if(!$('#carOutAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		//ajax的post方式提交表单
		//$("#carOutAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carOut/insert",$("#carOutAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增调出车辆信息成功!');
				clearcarOutAddForm();
				$("#carOutAddWindow").window('close');
				$("#carOutList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	$('#4departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#inorgan85').val(data.departmentId);  
         //   var fatherdep= $('#departmentFrist').val();
         //   $('#4departmentz1').combobox({  
         //       url:"department/get_data_second/"+fatherdep,  
         //       valueField:'departmentId',  
         //       textField:'departmentName' ,
         //       editable:false,
         //       onSelect : function(data1){  
         //         $('#inorgan85').val(data1.departmentId);  
         //       }
         //   }).combobox('clear');  
        }  
    });  
	$('#5departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#outorgan85').val(data.departmentId);  
      //      var fatherdep= $('#departmentFrist').val();
      //      $('#5departmentz1').combobox({  
     //           url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName' ,
      //          editable:false,
       //         onSelect : function(data1){  
       //           $('#outorgan85').val(data1.departmentId);  
       //         }
       //     }).combobox('clear');  
        }  
    });  
	$('#4carsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#rbeiyong85').val(data.usenature);  
            var fatherdep= $('#rbeiyong85').val();
            $('#4carNumbersCombox').combobox({  
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                onSelect : function(data1){  
                  $('#newnum85').val(data1.carId);  
                }
            }).combobox('clear');  
        }  
    });  
	function clearcarOutAddForm(){
		$('#carOutAddForm').form('reset');
	}
</script>
