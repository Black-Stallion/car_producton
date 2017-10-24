<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="fCountCheckAddForm" class="fCountChecktForm" method="post">
	    <center>
	    <table cellpadding="5" border="1px">
	        <tr>
	            <td width="100px">编号:</td>
	            <td width="150px">
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
	            <td width="100px">用车单位:</td>
	            <td  width="150px">
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td width="100px">派车人:</td>
	            <td width="150px">
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
	            <td width="100px">地点及路线:</td>
	            <td  width="150px">
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td  width="100px">驾驶员:</td>
	            <td>
	            	<input id="custom" type="text" class="easyui-textbox" name="customId"  data-options="required:true" />  
	            </td>
	            <td width="100px">用车人:</td>
	            <td>
	            	<input id="product" type="text" class="easyui-textbox" name="productId"  data-options="required:true" />
    			</td>  
	        </tr>
	        <tr>
	        <td>车牌号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
    			<td>派单日期:</td>
	            <td><input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
        			
	        </tr>
	         <tr>
    			<td>出车日期:</td>
	            <td><input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
        			<td>返回日期:</td>
	            <td><input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
	        </tr>
	        <tr>
    			<td>第一责任人:</td>
	            <td><input class="easyui-textbox" type="text" name="orderId" data-options="required:true"> </td>
        			<td>安全监督岗:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td>注意事项:</td>
	            <td><input class="easyui-textbox" type="text" name="orderId"> </td>
        			<td>领导审批:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="orderId"></input>
	            </td>
	        </tr>
	        <tr>
    			<td>行走公里:</td>
	            <td colspan="3">
	            	开始&nbsp;<input class="easyui-textbox" type="text" name="orderId" size="4" >KM&nbsp;</input>
	            	结束&nbsp;<input class="easyui-textbox" type="text" name="orderId" size="4" >KM</input>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="productParams"/>
	   </center>
	</form>
	<div style="padding:5px 0 0 30px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="fCountCheckSubmitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearFCountCheckAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var fCountCheckAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//加载文件上传插件
		
		//创建富文本编辑器
		//productAddEditor = TAOTAO.createEditor("#fCountCheckAddForm [name=file]");
		fCountCheckAddEditor = KindEditor.create("#fCountCheckAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据产品的分类id取产品 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "fCountCheckAddForm");
		}});
	});
	
	//提交表单
	function fCountCheckSubmitForm(){
		//有效性验证
		if(!$('#fCountCheckAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		fCountCheckAddEditor.sync(); 
		$.post("f_count_check/insert",$("#fCountCheckAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成品计数质检成功!');
				clearFCountCheckAddForm();
				$("#fCountCheckAddWindow").window('close');
				$("#fCountCheckList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearFCountCheckAddForm(){
		$('#fCountCheckAddForm').form('reset');
		fCountCheckAddEditor.html('');
	}
</script>
