<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<form id="userAddForm" class="userForm" method="post">
	<center>
	    <table class="border-table" cellpadding="5" align="center" >
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">用户名</td>
	            <td>
	            	<input id="username" class="easyui-textbox" type="text" name="username" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">密码</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="password" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
	            <td bgcolor="#F0F8FF" align="right">部门</td>
	            <td>
	            	<input class="easyui-combobox" id="departmenCombox0508" panelHeight="200" data-options="required:true"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId0508" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox0508" panelHeight="auto" data-options="required:true"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department0508"  panelHeight="200"/>  
    				<input name="departmentId" id="departmentId0508" type="hidden"/>
    				 -->
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">角色</td>
	            <td>
	            	<input class="easyui-combobox" name="roleId"  panelHeight="auto"
    					data-options="valueField:'roleId',textField:'roleName',url:'role/get_data',required:true, editable:false" />  
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
	            <td bgcolor="#F0F8FF" align="right">操作权限:</td>
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
		            <select class="easyui-combobox" name="locked" panelHeight="auto" data-options="width:150, editable:false">
						<option value="1">有效用户</option>
						<option value="2">锁定</option>
					</select>
				</td>
	        </tr>
	    </table>
	    </center>
	</form>
	<div style="padding:5px 0 0 400px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitUserAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearUserAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitUserAddForm(){
		//有效性验证
		if(!$('#userAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		//$("#userAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("user/insert",$("#userAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', data.msg);
				clearUserAddForm();
				$("#userAddWindow").window('close');
				$("#userList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearUserAddForm(){
		$('#userAddForm').form('reset');
	}
	
    $('#departmenCombox0508').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId0508').val(data.departmentId);  
 //           var fatherdep= $('#departmentFrist').val();
          
//            $('#department0508').combobox({  
               
 //               url:"department/get_data_second/"+fatherdep,  
 //               valueField:'departmentId',  
 //               textField:'departmentName',
//                onSelect : function(data1){  
//                  $('#departmentId0508').val(data1.departmentId);  
//                }
           
//            }).combobox('clear');  
        }  
    });  
	
</script>
