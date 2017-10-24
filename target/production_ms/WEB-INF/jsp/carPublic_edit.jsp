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
	<form id="carRegisterEditForm" class="carRegisterForm" method="post">
		<input type="hidden" name="carId"/>
		<center>
	    <table class="border-table" cellpadding="5" algin="center">
	         <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">机动车证书编号</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="dengjizsid" data-options="required:true"></input>
	            </td>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">设备编号</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="shebeiid" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">机动车所有人/身份证明名称/号码</td>
	            <td colspan="3">
	            	<input type="text" class="easyui-textbox" name="username"  data-options="required:true" size="68"/>  
	            </td>
	             
	        </tr>
	         <tr>
	        <td bgcolor="#F0F8FF" align="right">车牌号(机动车登记编号)</td> 
    				<td><input class="easyui-textbox" type="text" name="carnumber" data-options="required:true"></input>
    			</td>
    			<td bgcolor="#F0F8FF" align="right">登记日期</td>
	            <td><input class="easyui-datetimebox" name="dengjitiem"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
        			
	        </tr>
	        <tr>
	            <td  bgcolor="#F0F8FF" align="right">车辆性质</td>
	            <td><input class="easyui-textbox" type="text" name="usenature" data-options="required:true,editable:false" value="公务用车"></input>
	             </td>
	            <td  bgcolor="#F0F8FF" align="right">登记机关</td>
	            <td>
	            	<input type="text" class="easyui-textbox" name="jigan"  data-options="required:true" />
    			</td>  
	        </tr>
	       
	        <tr>
	    			<td bgcolor="#F0F8FF" align="right">车型名称</td>
		            <td>
	            	<input class="easyui-combobox" name="typeid"   panelHeight="200" 
    					data-options="valueField:'typeid',textField:'typename',editable:false,
    						url:'carType/get_data', required:true" />
    				</td> 
    				<td bgcolor="#F0F8FF" align="right">所属部门</td>
	            <td>
	            	<input class="easyui-combobox" id="departmenCombox0059" name="departmentName" panelHeight="200"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId9" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox0059" value="${fathername }" panelHeight="auto" size="8px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department0059"  name="departmentName" panelHeight="200" size="11px"/>  
    				<input name="departmentId" id="departmentId9" type="hidden"/>
    				 -->
	            </td>
		      </tr>
	        <tr>
        		<td bgcolor="#F0F8FF" align="right">车身颜色</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="color" data-options="required:true"></input>
	            </td>
    			<td bgcolor="#F0F8FF" align="right">车辆识别代/车架号</td>
	            <td><input class="easyui-textbox" type="text" name="carcjh" data-options="required:true"> </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">车辆获得方式</td>
	            <td><input class="easyui-textbox" type="text" name="carway" ></td>
	             <td bgcolor="#F0F8FF" align="right">车辆出厂日期</td>
	            <td><input class="easyui-datetimebox" name="manufacturedate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
	        </tr>
	        <tr>
	         <td  bgcolor="#F0F8FF" align="right">使用性质</td>
	            <td><input class="easyui-textbox" type="text" name="dengjiid" data-options="required:true"></input>
	             </td>
	             <td bgcolor="#F0F8FF" align="right">发证日期</td>
	            <td><input class="easyui-datetimebox" name="issuedate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">发证机关</td>
	            <td colspan="3">
	            <input class="easyui-textbox" type="text" name="issueorgan" size="68"/> 
	            </td>
	             
	        </tr>
	        <tr>
    			<td colspan="4" style="text-align:center"><font color="gray">注:上述各栏均按中华人民共和国机动车登记证书所记填写</font></td>
	        </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF" align="right">购车批文</td>
	            <td><input class="easyui-textbox" type="text" name="buycarapproval"></td>
        		<td bgcolor="#F0F8FF" align="right">款源</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="newsource"></input>
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">购车价</td>
	            <td><input class="easyui-numberbox" precision="2" type="text" name="carprice" ></td>
        		<td bgcolor="#F0F8FF" align="right">组资后价值</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="oldcarprice"  ></input>
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">供货商</td>
	            <td><input class="easyui-textbox" type="text" name="supplier" ></td>
        		<td bgcolor="#F0F8FF" align="right">电话</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="phone"  ></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">上传机动车行驶证图片</td>
	            <td colspan="3">
	            	 <a href="javascript:void(0)" class="easyui-linkbutton productPicFileUpload">上传图片</a>
	                 <input type="hidden" id="image" name="image"/>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	<div style="padding:5px 0 0 650px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarRegisterEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitCarRegisterEditForm(){
		if(!$('#carRegisterEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("carPublic/update_all",$("#carRegisterEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改车辆信息成功!','info',function(){
					$("input[name='image']").val(null);
					$("#carRegisterEditWindow").window('close');
					$("#carRegisterList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
       		
	}
	    $('#departmenCombox0059').combobox({  
	        url: "department/get_data_first",  
	        editable:false,  
	        valueField:'departmentId',   
	        textField:'departmentName',  
	      //  panelHeight:'auto',  
	        onSelect : function(data){  
	            $('#departmentFrist').val(data.departmentId);  
	            $('#departmentId9').val(data.departmentId);  
	     //       var fatherdep= $('#departmentFrist').val();
	     //       $('#department0059').combobox({  
	     //           url:"department/get_data_second/"+fatherdep,  
	     //           editable:false,  
	     //           valueField:'departmentId',  
	     //           textField:'departmentName' ,
	     //           onSelect : function(data1){  
	     //             $('#departmentId9').val(data1.departmentId);  
	    //           }
	     //       }).combobox('clear');  
	        }  
	    });  
</script>
