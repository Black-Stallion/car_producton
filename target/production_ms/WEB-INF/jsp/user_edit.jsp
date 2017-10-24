<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
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
	<form id="userEditForm" class="userForm" method="post">
		<input type="hidden" name="id"/>
		<input type="hidden" id="xfather" name="fatherdep"/>
		<input type="hidden" name="password"/>
		<center>
	    <table class="border-table" cellpadding="5" align="center">
	        <tr>
	            <td width="110px" bgcolor="#F0F8FF" align="right">用户名</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="username" data-options="required:true" ></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">部门</td>
	            <td>
	            <input class="easyui-combobox" id="departmenCombox058" name="departmentName"panelHeight="200" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId058" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox058" name="departmentName"name="fathername"panelHeight="auto" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department058" name="departmentName" panelHeight="200"/>  
    				<input name="departmentId" id="departmentId058" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">角色</td>
	            <td>
	            	<input class="easyui-combobox" name="roleId"  panelHeight="auto" 
    					data-options="valueField:'roleId',textField:'roleName',url:'role/get_data',required:true,
    						 editable:false" />  
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">身份证号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="shenfen" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">文化程度</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="culte" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">籍贯</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="jiguan" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">手机号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="phone"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">联系方式(QQ或邮箱)</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="qq"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">工作单位</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="gongzuodanwei" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">操作权限</td>
	            <td>
		            <select class="easyui-combobox" name="leve" panelHeight="auto" data-options="width:150, editable:false">
						<option value="1">本部门</option>
						<option value="2">所有部门</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">用户状态</td>
	            <td>
		            <select id="cc" class="easyui-combobox" panelHeight="auto" name="locked" data-options="width:150, 
		            	editable:false">
						<option value="1">有效用户</option>
						<option value="2">锁定</option>
					</select>
				</td>
	        </tr>
	    </table>
	    </center>
	</form>
	<div style="padding:5px 0 0 400px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitUserEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitUserEditForm(){
		if(!$('#userEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("user/update_all",$("#userEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', data.msg);
				$("#userEditWindow").window('close');
				$("#userList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	 $('#departmenCombox058').combobox({  
	        url: "department/get_data_first",  
	        editable:false,  
	        valueField:'departmentId',   
	        textField:'departmentName',  
	        onSelect : function(data){  
	            $('#departmentFrist').val(data.departmentId);  
	            $('#departmentId058').val(data.departmentId);  
	 //           var fatherdep= $('#departmentFrist').val();
	//            $('#department058').combobox({  
	  //              url:"department/get_data_second/"+fatherdep,  
	  //              valueField:'departmentId',  
	  //              textField:'departmentName' ,
	  //              onSelect : function(data1){  
	  //                $('#departmentId058').val(data1.departmentId);  
	  //              }
	  //          }).combobox('clear');  
	        }  
	    }); 
</script>
