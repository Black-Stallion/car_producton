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
	<form id="carSelfAddForm" class="carSelfForm" method="post">
	<center>
	    <table class="border-table" cellpadding="5" align="center">
	    <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">调配车辆</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="self4carsCombox"  data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input  id="rbeiyong180" name="rbeiyong1" type="hidden"/>
    				<input class="easyui-combobox" id="self4carNumbersCombox"  data-options="required:true" panelHeight="150" size="10px"/>  
    				<input name="carId" id="newnum80" type="hidden"/>
    				</td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">调配人</td>
	            <td>
	            	<input  class="easyui-combobox" name="rbieyong2" panelHeight="150" value="${username }"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_data',required:true,editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">接收车间</td>
	             <td>
	            	<input class="easyui-combobox" id="self4departmenComboxz1" data-options="required:true" panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="inorgan80" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="self4departmenComboxz1" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="self4departmentz1" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="inorgan80" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">调出车间</td>
	             <td>
	            	<input class="easyui-combobox" id="self5departmenComboxz1" data-options="required:true" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="outorgan" id="outorgan80" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="self5departmenComboxz1" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="self5departmentz1" panelHeight="200" size="13px"/>  
    				<input name="outorgan" id="outorgan80" type="hidden"/>
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
	            	<input class="easyui-textbox" type="text" name="stats" data-options="required:true,editable:false" value="段内调配"></input>
	            </td>
	        </tr>
	    </table>
	    </center>
	    <input type="hidden" name="carSelfParams"/>
	</form>
	<div style="padding:5px 0 0 450px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitcarSelfAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearcarSelfAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitcarSelfAddForm(){
		//有效性验证
		if(!$('#carSelfAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		//ajax的post方式提交表单
		//$("#carSelfAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carSelf/insert",$("#carSelfAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增段内调配信息成功!');
				clearcarSelfAddForm();
				$("#carSelfAddWindow").window('close');
				$("#carSelfList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	$('#self4departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#inorgan80').val(data.departmentId);  
      //      var fatherdep= $('#departmentFrist').val();
      //      $('#self4departmentz1').combobox({  
      //          url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName' ,
      //          editable:false,
      //          onSelect : function(data1){  
      //            $('#inorgan80').val(data1.departmentId);  
      //          }
      //      }).combobox('clear');  
        }  
    });  
	$('#self5departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
      //  panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#outorgan80').val(data.departmentId);  
      //      var fatherdep= $('#departmentFrist').val();
      //      self5departmentz1
      //      $('#self5departmentz1').combobox({  
      //          url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName' ,
     //           editable:false,
     //          onSelect : function(data1){  
     //             $('#outorgan80').val(data1.departmentId);  
     //           }
     //       }).combobox('clear');  
        }  
    });  
	$('#self4carsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#rbeiyong180').val(data.usenature);  
            var fatherdep= $('#rbeiyong180').val();
            $('#self4carNumbersCombox').combobox({  
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                onSelect : function(data1){  
                  $('#newnum80').val(data1.carId);  
                }
            }).combobox('clear');  
        }  
    });  
	function clearcarSelfAddForm(){
		$('#carSelfAddForm').form('reset');
	}
</script>
