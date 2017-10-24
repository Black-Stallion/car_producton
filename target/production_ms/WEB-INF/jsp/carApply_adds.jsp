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
	<form id="carApplyAddForms" class="carApplyForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
	         <tr>
	            <td width="auto" bgcolor="#F0F8FF" align="right">申请编号</td>
	            <td width="auto" >
	            	<span style="color:red">自动生成编号(格式:jntxd+时间)</span>
	            </td>
	            <td width="auto" bgcolor="#F0F8FF" align="right">车辆性质及车辆</td>
	            <td width="auto">
	            	<input class="easyui-combobox" id="xjzcarCombox7831" data-options="required:true" name="usenature1" panelHeight="auto" size="9px" />
	            	<input name="usenature" id="usenature8831" type="hidden"/>
    				<input class="easyui-combobox" id="xjzcarNumberCombox7831" data-options="required:true" name="carnumber" panelHeight="100" size="10px"/>  
    				<input name="carId" id="carId983" type="hidden"/>
	            </td>
	        </tr>
	        <tr>
	            <td  bgcolor="#F0F8FF" align="right">选择申请人</td>
	            <td>
	            	<input  class="easyui-combobox" name="applyname" panelHeight="150" value="${username }"
	            	data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep', required:true,editable:false" />
	            </td>
	             <td  bgcolor="#F0F8FF" align="right">选择审批人</td> 
    				<td>
	            	<input class="easyui-combobox" name="approve"   panelHeight="150" 
    					data-options="valueField:'username',textField:'username',
    						url:'user/find_dataByDep', required:true,editable:false" />
    			</td> 
	        </tr>
	        <tr>
	            <td  bgcolor="#F0F8FF" align="right">选择驾驶员</td>
	            <td><input class="easyui-combobox" name="driverId"   panelHeight="150" 
    					data-options="valueField:'driverId',textField:'drviername',
    						url:'carDriver/get_data', required:true,editable:false" />
	             </td>
	            <td  bgcolor="#F0F8FF" align="right">选择用车单位</td>
	            <td>
	            	<input class="easyui-combobox" id="xxdepartmenCombox7831" data-options="required:true" name="departmentName" panelHeight="200" size="15px" />
	            	<input id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="xxdepartment7831"  panelHeight="200" size="12px"/>  
    				<input id="departmentId3" type="hidden"/>
    				<input name="departmentId" id="departmentId0725" type="hidden" />
    				<!-- 
    				<input class="easyui-combobox" id="xxdepartmenCombox7831" data-options="required:true" panelHeight="auto" size="7px" />
	            	<input id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="xxdepartment7831"  panelHeight="200" size="12px"/>  
    				<input id="departmentId3" type="hidden"/>
    				<input class="easyui-combobox" id="xxdepartment0725" panelHeight="auto" size="10px" name="departmentName" /> 
    				<input name="departmentId" id="departmentId0725" type="hidden" />
    				 -->
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF" align="right">出车天数</td>
	            <td><input class="easyui-numberbox" precision="1" name="days" data-options="required:true"> </td>
        			<td bgcolor="#F0F8FF" align="right">出车人数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="people" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	        <td bgcolor="#F0F8FF" align="right">出车日期</td>
	            <td><input class="easyui-datetimebox" name="outtime"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        		</td>
	        <td bgcolor="#F0F8FF" align="right">申请时间</td>
	        	<td>
	        	<input class="easyui-datetimebox"  name="applytime"   
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px">
	        	</td>
	        </tr>
	          <tr>
        			<td bgcolor="#F0F8FF" align="right">用车理由</td>
	            	<td colspan="3">
	                <textarea style="width:160px;height:100px;visibility:hidden;" name="thing"></textarea>
	            </td>
	        </tr>
	        <input type="hidden" name="stats" value="未审批"/>
	    </table>
	     </center>
	    <input type="hidden" name="carApplyParams"/>
	</form>
	<div style="padding:5px 0 0 650px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarApplyAddForms()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarApplyADDForms()">重置</a>
	</div>
</div>
<script type="text/javascript">
		var apply1Editor831;
		$(function(){
			apply1Editor831 = KindEditor.create("#carApplyAddForms [name=thing]", {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link','map']
			});
		});
	
	//提交表单
	function submitCarApplyAddForms(){
		//有效性验证
		if(!$('#carApplyAddForms').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		apply1Editor831.sync();
		//ajax的post方式提交表单
		//$("#carApplyAddForms").serialize()将表单序列号为key-value形式的字符串
		$.post("carApply/insert",$("#carApplyAddForms").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','申请成功,请等待审批!');
				clearCarApplyADDForms();
				$("#carApplyAddWindows").window('close');
				$("#carApplyList").datagrid("reload");
			}else{
				clearCarApplyADDForms();
				$.messager.alert('提示',data.msg);
			}
		});
	}
	$('#xxdepartmenCombox7831').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
       // panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId3').val(data.departmentId); 
            $('#departmentId0725').val(data.departmentId);
            var fatherdep= $('#departmentFrist').val();
            $('#xxdepartment7831').combobox({  
                url:"department/get_data_second/"+fatherdep,  
                valueField:'departmentId',  
                textField:'departmentName' ,
                editable:false,
                onSelect : function(data1){ 
                  $('#departmentId3').val(data1.departmentId);
                  $('#departmentId0725').val(data1.departmentId);
				//	var fatherdep = $('#departmentId3').val();
				//	$('#xxdepartment0725').combobox({
				//		url : "department/get_data_third/" + fatherdep,
				//		valueField : 'departmentId',
				//		textField : 'departmentName',
				//		editable : false,
				//		onSelect : function(data2) {
				//			$('#departmentId0725').val(data2.departmentId);
				//		}
				//	}).combobox('clear');
                }
           
            }).combobox('clear');  
        }  
    });  
	$('#xjzcarCombox7831').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature8831').val(data.usenature);  
            var fatherdep= $('#usenature8831').val();
            $('#xjzcarNumberCombox7831').combobox({  
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId983').val(data1.carId);  
                }
            }).combobox('clear');  
        }  
    });  
	
	function clearCarApplyADDForms(){
		$('#carApplyAddForms').form('reset');
	}
</script>
