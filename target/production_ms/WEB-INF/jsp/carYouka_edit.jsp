<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css"
	type="text/css" rel="stylesheet">

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
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding: 10px 10px 10px 10px">
	<form id="carYoukaEditForm" class="carYoukaForm" method="post">
		<input type="hidden" name="youkaId" />
		<center>
			<table class="border-table" cellpadding="5" align="center">
				 <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">车辆性质及车辆</td>
	            <td width="auto">
	            	<input class="easyui-combobox" id="xjzcarCombox524" name="usenature" data-options="required:true" panelHeight="auto" size="9px" />
	            	<input  id="usenature524" type="hidden"/>
    				<input class="easyui-combobox" id="xjzcarNumberCombox524" name="carnumber" data-options="required:true" panelHeight="150px" size="10px"/>  
    				<input name="carId" id="carId524" type="hidden"/>
	            </td> 
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">油卡编号</td>
	            <td>
	            	<input  class="easyui-combobox" name="youId" panelHeight="auto"
	            	data-options="valueField:'youId',textField:'younumber',
    						url:'carYou/get_data', required:true,editable:false" />
	            </td>
	         </tr>
	          <tr>
	            <td bgcolor="#F0F8FF" align="right">本次加油</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="yongyou" data-options="required:true">&nbsp;L</input>
	            </td>
	         </tr>
	          <tr>
	            <td  bgcolor="#F0F8FF" align="right">本次加油金额</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="totlyou" data-options="required:true">&nbsp;元</input>
	            </td>
	         </tr>
	          <tr>
	        <td  bgcolor="#F0F8FF" align="right">填写日期</td>
	            <td><input class="easyui-datetimebox" name="beiyong1"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> 
        		</td>
	        </tr>
			</table>
		</center>
	</form>
	<div style="padding: 5px 0 0 380px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitCarYoukaEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">


function btnDelete_onclick(obj) {
	$(obj).parent().remove();
}
	function submitCarYoukaEditForm() {
		if (!$('#carYoukaEditForm').form('validate')) {
			$.messager.alert('提示', '表单还未填写完成!');
			return;
		}

		$.post("carYouka/update_all", $("#carYoukaEditForm").serialize(),
				function(data) {
					if (data.status == 200) {
						$.messager.alert('提示', '修改用油记录成功!', 'info', function() {
							$("#carYoukaEditWindow").window('close');
							$("#carYoukaList").datagrid("reload");
						});
					} else {
						$.messager.alert('提示', data.msg);
					}
				});
	}
	$('#xjzcarCombox524').combobox({  
        url: "carPublic/get_data",  
        editable:false,  
        valueField:'usenature',   
        textField:'usenature',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#usenature524').val(data.usenature);  
            var fatherdep= $('#usenature524').val();
          
            $('#xjzcarNumberCombox524').combobox({  
               
                url:"carPublic/find_nature/"+fatherdep,  
                valueField:'carId',  
                textField:'carnumber' ,
                editable:false,
                onSelect : function(data1){  
                  $('#carId524').val(data1.carId);  
                }
           
            }).combobox('clear');  
        }  
    });  
</script>
