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
	<form id="carTechnicalAddForm" class="carTechnicalForm" method="post">
	 <center>
	    <table  class="border-table" cellpadding="5" align="center">
		     <tr>
	    			<td width="auto"  bgcolor="#F0F8FF" align="right">车型名称</td>
		            <td width="auto" colspan="3">
	            	<input class="easyui-combobox" name="typeid"   panelHeight="auto" 
    					data-options="valueField:'typeid',textField:'typename',
    						url:'carType/get_data', required:true" />
    			</td>  
		      </tr>
	          <tr>
    			<td width="auto"  bgcolor="#F0F8FF" align="right">驱动形式</td>
	            <td width="auto" >
	            	<input class="easyui-textbox" type="text" name="driverfrom" data-options="required:true"></input>
	             </td>
        			<td width="auto"  bgcolor="#F0F8FF" align="right">离地间隙</td>
	            <td width="auto" >
	            	<input class="easyui-numberbox" precision="2" type="text" name="lidijianxi" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">接近角</td>
	            <td><input class="easyui-textbox" type="text" name="jiejinjiao" data-options="required:true"> </td>
	       		<td bgcolor="#F0F8FF" align="right">离去角</td>
	            <td><input class="easyui-textbox" type="text" name="liqujiao" size="17">&nbsp;人</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">最高车速</td>
	            <td><input class="easyui-numberbox" type="text" name="highspeed" size="15">  &nbsp;Km/n</td>
        			<td bgcolor="#F0F8FF" align="right">最大爬坡能力</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="highpapo"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">点火次序</td>
	            <td><input class="easyui-textbox" type="text" name="dianhuocx"> </td>
        		<td bgcolor="#F0F8FF" align="right">最小转弯半径</td>
	            	<td>车身<input class="easyui-numberbox" precision="2" type="text" name="turnbody" size="4" >&nbsp;m</input>
	            	车轮<input class="easyui-numberbox" precision="2" type="text" name="turntire" size="4" >&nbsp;m</input> </td>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">压缩比</td>
	            <td><input class="easyui-textbox" type="text" name="yasuobi"> </td>
        		<td bgcolor="#F0F8FF" align="right">轮胎气压</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tireqy" ></input>
	            </td>
	        </tr>
	       
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">燃油箱贮油量</td>
	            <td><input class="easyui-textbox" type="text" name="ranyoucl" ></td>
        		<td bgcolor="#F0F8FF" align="right">蓄电池型号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="dianchixh" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">燃油标号</td>
	            <td><input class="easyui-textbox" type="text" name="ranyoubh" ></td>
        		<td bgcolor="#F0F8FF" align="right">百公里耗油</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="hundredsfuel" ></input>
	            </td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="carTechnicalParams"/>
	</form>
	<div style="padding:5px 0 0 510px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarTechnicalAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarTechnicalADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitCarTechnicalAddForm(){
		//有效性验证
		if(!$('#carTechnicalAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		$.post("carTechnical/insert",$("#carTechnicalAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增技术特性成功!');
				clearCarTechnicalADDForm();
				$("#carTechnicalAddWindow").window('close');
				$("#carTechnicalList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearCarTechnicalADDForm(){
		$('#carTechnicalAddForm').form('reset');
	}
	
</script>
