<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
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
<div style="padding:10px 10px 10px 10px">
	<form id="carTypeAddForm31" class="carTypeForm" method="post">
	 <center>
	    <table class="border-table" cellpadding="5" align="center">
		     <tr>
	    			<td width="auto"  bgcolor="#F0F8FF" align="right">车型名称</td>
		            <td width="auto" ><input class="easyui-textbox" type="text" name="typename" data-options="required:true"> </td>
	        			<td width="auto"  bgcolor="#F0F8FF" align="right">国产/进口</td>
		            	<td width="auto"  ><select id="cc" class="easyui-combobox" name="carcd" panelHeight="auto" data-options="required:true, width:150, editable:false">
		            		<option value="国产">国产</option>
		            		<option value="进口">进口</option>
		            	</select> </td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">车辆类型</td>
	            <td> <input class="easyui-textbox" type="text" name="ctype" data-options="required:true"></input>
	             </td>
        		<td bgcolor="#F0F8FF" align="right">车辆品牌</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="brand" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">车辆型号</td>
	            <td><input class="easyui-textbox" type="text" name="carxh" data-options="required:true"> </td>
	       		<td bgcolor="#F0F8FF" align="right">驾驶室载客:</td>
	            <td><input class="easyui-textbox" type="text" name="cabnums" size="17">&nbsp;人</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">发动机号</td>
	            <td><input class="easyui-textbox" type="text" name="engineid"> </td>
        			<td bgcolor="#F0F8FF" align="right">发动机型号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="enginexh"></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">燃料种类</td>
	            <td><input class="easyui-textbox" type="text" name="fueltype"> </td>
        		<td bgcolor="#F0F8FF" align="right">排量/功率</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="pailiang" size="4" >ml/&nbsp;</input>
	            	<input class="easyui-numberbox" type="text" name="power" size="4" >Kw</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">制造厂名称</td>
	            <td><input class="easyui-textbox" type="text" name="factory"> </td>
        		<td bgcolor="#F0F8FF" align="right">转向形式</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="turnxs" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">轮距</td>
	            <td>前&nbsp;<input class="easyui-numberbox" type="text" name="frontlunju" size="4" ></input>
	            	后&nbsp;<input class="easyui-numberbox" type="text" name="afterlunju" size="4" >&nbsp;mm</input> </td>
        		<td bgcolor="#F0F8FF" align="right">轮胎数</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tirenum" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">轮胎规格</td>
	            <td><input class="easyui-textbox" type="text" name="fronttiregg"></input></td>
        		<td bgcolor="#F0F8FF" align="right">钢板弹簧片数数</td>
	            <td>
	            	&nbsp;后轴&nbsp;<input class="easyui-numberbox" type="text" name="gbthps" size="5" >&nbsp;数</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF" align="right">轴距</td>
	            <td><input class="easyui-numberbox" type="text" name="zhouju" size="17">&nbsp;mm</td>
        		<td bgcolor="#F0F8FF" align="right">轴数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="zhoushu" ></input>
	            </td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">外廓尺寸</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-numberbox" type="text" name="carwlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-numberbox" type="text" name="carwwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-numberbox" type="text" name="carwhigh" size="14">&nbsp;mm</td>
	        </tr>
	         <tr>
    			<td bgcolor="#F0F8FF" align="right">货箱内部尺寸</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-numberbox" type="text" name="carnlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-numberbox" type="text" name="carnwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-numberbox" type="text" name="carnhigh" size="14">&nbsp;mm</td>
	        </tr>
	       <tr>
    			<td bgcolor="#F0F8FF" align="right">总质量</td>
	            <td><input class="easyui-numberbox" type="text" name="carquality" size="17">&nbsp;kg</td>
        		<td bgcolor="#F0F8FF" align="right">核定载质量</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="carcheckquality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	        <tr> 
    			<td bgcolor="#F0F8FF" align="right">核定载客</td>
	            <td><input class="easyui-numberbox" type="text" name="checknums" size="17">&nbsp;人</td>
        		<td bgcolor="#F0F8FF" align="right">牵引总质量</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="tractionquality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="carTypeParams"/>
	</form>
	<div style="padding:5px 0 0 550px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarTypeAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarTypeADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitCarTypeAddForm(){
		//有效性验证
		if(!$('#carTypeAddForm31').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		//$("#carTypeAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("carType/insert",$("#carTypeAddForm31").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增车型信息成功!');
				clearCarTypeADDForm();
				$("#carTypeAddWindow").window('close');
				$("#carTypeList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearCarTypeADDForm(){
		$('#carTypeAddForm31').form('reset');
	}
	
</script>
