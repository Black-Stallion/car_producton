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
	<form id="carSelfEditForm" class="carSelfForm" method="post">
		<input type="hidden" name="selfId"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
	     <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">调入车辆</td>
	            <td width="auto" >
	            	<input class="easyui-combobox" id="self3carsCombox" name="rbeiyong1" data-options="required:true,editable:false" panelHeight="auto" size="9px" />
	            	<input id="rbeiyong181" type="hidden"/>
    				<input class="easyui-combobox" id="self3carNumbersCombox" name="carnumber" data-options="required:true" panelHeight="150" size="10px"/>  
    				<input name="carId" id="newnum81" type="hidden"/>
    				</td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">调配人</td>
	            <td>
	            	<input  class="easyui-combobox" name="rbieyong2" panelHeight="150"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_data',required:true,editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">接收车间</td>
	             <td>
	            	<input class="easyui-combobox" id="self31departmenComboxz1" name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="inorgan81" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="self31departmenComboxz1" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="self31departmentz1" name="departmentName" panelHeight="200" size="13px"/>  
    				<input name="departmentId" id="inorgan81" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	       <tr>
	            <td bgcolor="#F0F8FF" align="right">调出车间</td>
	             <td>
	            	<input class="easyui-combobox" id="self41departmenComboxz1" name="departmentName1" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="outorgan" id="outorgan81" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="self41departmenComboxz1" value="${fathername }" panelHeight="auto" size="9px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="self41departmentz1" name="departmentName1" panelHeight="200" size="13px"/>  
    				<input name="outorgan" id="outorgan81" type="hidden"/>
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
	            <td bgcolor="#F0F8FF" align="right">调出日期:</td>
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
	</form>
	<div style="padding:5px 0 0 450px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarInEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarInEditForm(){
		if(!$('#carSelfEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("carSelf/update_all",$("#carSelfEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改信息成功!','info',function(){
					$("#carSelfEditWindow").window('close');
					$("#carSelfList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	$('#self31departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
     //   panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#inorgan81').val(data.departmentId);  
      //      var fatherdep= $('#departmentFrist').val();
      //      $('#self31departmentz1').combobox({  
      //          url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName' ,
      //          editable:false,
      //          onSelect : function(data1){  
      //            $('#inorgan81').val(data1.departmentId);  
      //          }
       //     }).combobox('clear');  
        }  
    });  
	$('#self41departmenComboxz1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
    //    panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#outorgan81').val(data.departmentId);  
     //       var fatherdep= $('#departmentFrist').val();
     //       $('#self41departmentz1').combobox({  
      //          url:"department/get_data_second/"+fatherdep,  
      //          valueField:'departmentId',  
      //          textField:'departmentName' ,
      //          editable:false,
      //          onSelect : function(data1){  
      //            $('#outorgan81').val(data1.departmentId);  
      //          }
      //      }).combobox('clear');  
        }  
    });  
	$('#self3carsCombox').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#rbeiyong181').val(data.usenature);  
            var fatherdep= $('#rbeiyong181').val();
            $('#self3carNumbersCombox').combobox({  
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                onSelect : function(data1){  
                  $('#newnum81').val(data1.carId);  
                }
            }).combobox('clear');  
        }  
    });  
</script>
