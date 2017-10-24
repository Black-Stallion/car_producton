<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="orderAddForm" class="orderForm" method="post">
	 <center>
	    <table cellpadding="5" border="1px">
	    <center>
	        <tr>
	            <td width="100px">机动车证书编号:</td>
	            <td width="150px">
	            	<input class="easyui-textbox" type="text" name="dengJiZSID" data-options="required:true"></input>
	            </td>
	            <td width="100px">设备编号:</td>
	            <td  width="150px">
	            	<input class="easyui-textbox" type="text" name="sheBeiID" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td  width="100px">机动车所有人/身份证明名称/号码:</td>
	            <td>
	            	<input type="text" class="easyui-textbox" name="username"  data-options="required:true" />  
	            </td>
	            <td width="100px">登记机关:</td>
	            <td>
	            	<input type="text" class="easyui-textbox" name="jiGan"  data-options="required:true" />
    			</td>  
	        </tr>
	        <tr>
    			<td>登记日期:</td>
	            <td><input class="easyui-datetimebox" name="dengjiTiem"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
        			<td>机动车登记编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="dengjiID" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td>车辆类型:</td>
	            <td>
	            <select id="cc" class="easyui-combobox" name="carType" panelHeight="auto" data-options="required:true, width:150, editable:false">
	            		<option>双人座</option>
	            		<option>四人座</option>
	            	</select>
	             </td>
        			<td>车辆品牌:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="brand" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td>车辆型号:</td>
	            <td><input class="easyui-textbox" type="text" name="carXH" data-options="required:true"> </td>
        			<td>车身颜色:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="color" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td>车辆识别代/车架号:</td>
	            <td><input class="easyui-textbox" type="text" name="carCJH" data-options="required:true"> </td>
        			<td>国产/进口:</td>
	            	<td><select id="cc" class="easyui-combobox" name="carCD" panelHeight="auto" data-options="required:true, width:150, editable:false">
	            		<option name="国产">国产</option>
	            		<option name="进口">进口</option>
	            	</select> </td>
	        </tr>
	         <tr>
    			<td>发动机号:</td>
	            <td><input class="easyui-textbox" type="text" name="engineID"> </td>
        			<td>发动机型号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="engineXH"></input>
	            </td>
	        </tr>
	        <tr>
    			<td>燃料种类:</td>
	            <td><input class="easyui-textbox" type="text" name="fuelType"> </td>
        		<td>排量/功率:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="paiLiang" size="4" >ml/&nbsp;</input>
	            	<input class="easyui-textbox" type="text" name="power" size="4" >Kw</input>
	            </td>
	        </tr>
	        <tr>
    			<td>制造厂名称:</td>
	            <td><input class="easyui-textbox" type="text" name="factory"> </td>
        		<td>转向形式:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="turnXS" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td>轮距:</td>
	            <td>前&nbsp;<input class="easyui-textbox" type="text" name="frontLunJu" size="4" ></input>
	            	后&nbsp;<input class="easyui-textbox" type="text" name="afterLunJu" size="4" >&nbsp;mm</input> </td>
        		<td>轮胎数:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tireNum" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td>轮胎规格:</td>
	            <td>前&nbsp;<input class="easyui-textbox" type="text" name="frontTireGG" size="4" ></input>
	            	后&nbsp;<input class="easyui-textbox" type="text" name="afterTireGG" size="4" ></input> </td>
        		<td>钢板弹簧片数数:</td>
	            <td>
	            	&nbsp;后轴&nbsp;<input class="easyui-textbox" type="text" name="GBTHPS" size="5" >&nbsp;数</input>
	            </td>
	        </tr>
	        <tr>
    			<td>轴距:</td>
	            <td><input class="easyui-textbox" type="text" name="zhouju" size="17">&nbsp;mm</td>
        		<td>轴数:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="zhoushu" ></input>
	            </td>
	        </tr>
	         <tr>
    			<td>外廓尺寸:</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-textbox" type="text" name="carWlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-textbox" type="text" name="carWwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-textbox" type="text" name="carWhigh" size="14">&nbsp;mm</td>
	        </tr>
	         <tr>
    			<td>货箱内部尺寸:</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-textbox" type="text" name="carNlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-textbox" type="text" name="carNwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-textbox" type="text" name="carNhigh" size="14">&nbsp;mm</td>
	        </tr>
	       <tr>
    			<td>总质量:</td>
	            <td><input class="easyui-textbox" type="text" name="carQuality" size="17">&nbsp;kg</td>
        		<td>核定载质量:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="carCheckQuality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	        <tr>
    			<td>核定载客:</td>
	            <td><input class="easyui-textbox" type="text" name="checkNums" size="17">&nbsp;人</td>
        		<td>牵引总质量:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tractionQuality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	         <tr>
    			<td>驾驶室载客:</td>
	            <td><input class="easyui-textbox" type="text" name="cabNums" size="17">&nbsp;人</td>
        		<td>使用性质:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="useNature" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td>车辆获得方式:</td>
	            <td><input class="easyui-textbox" type="text" name="carWay" ></td>
	             <td>车辆出厂日期:</td>
	            <td><input class="easyui-datetimebox" name="manufactureDate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
	        </tr>
	        <tr>
    			<td>发证机关:</td>
	            <td><input class="easyui-textbox" type="text" name="issueOrgan" ></td>
	             <td>发证日期:</td>
	            <td><input class="easyui-datetimebox" name="issueDate"     
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd')" style="width:150px"> </td>
	        </tr>
	        <tr>
    			<td colspan="4"><font color="red">注:上述各栏均按中华人民共和国机动车登记证书所记填写</font></td>
	        </tr>
	         <tr>
    			<td>购车批文:</td>
	            <td><input class="easyui-textbox" type="text" name="buycarapproval" data-options="required:true"></td>
        		<td>款源:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="newSource" data-options="required:true"></input>
	            </td>
	        </tr>
	         <tr>
    			<td>购车价:</td>
	            <td><input class="easyui-textbox" type="text" name="carPrice" ></td>
        		<td>组资后价值:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="oldcarPrice"  ></input>
	            </td>
	        </tr>
	         <tr>
    			<td>供货商:</td>
	            <td><input class="easyui-textbox" type="text" name="supplier" ></td>
        		<td>电话:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="phone"  ></input>
	            </td>
	        </tr>
	        <tr>
	            <td rowspan="4">上传车辆图片:</td>
	            <td colspan="3" rowspan="4">
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" id="image" name="image"/>
	            </td>
	        </tr>
	       </center>
	    </table>
	     </center>
	    <input type="hidden" name="orderParams"/>
	</form>
	<div style="padding:5px 0 0 35px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOrderAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearOrderADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var orderAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//加载文件上传插件
		initOrderAddFileUpload();
		//创建富文本编辑器
		//orderAddEditor = TAOTAO.createEditor("#orderAddForm [name=file]");
		orderAddEditor = KindEditor.create("#orderAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据机动车信息的分类id取机动车信息 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "orderAddForm");
		}});
	});
	
	//提交表单
	function submitOrderAddForm(){
		//有效性验证
		if(!$('#orderAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的机动车信息要求
		orderAddEditor.sync();
		
		//ajax的post方式提交表单
		//$("#orderAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("order/insert",$("#orderAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增机动车信息成功!');
				clearOrderADDForm();
				$("#orderAddWindow").window('close');
				$(".picFileUpload").siblings("div.pics").find("ul > li").remove();
				$(".ajax-file-upload-container > .ajax-file-upload-statusbar").remove();
				$("#orderList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearOrderADDForm(){
		$('#orderAddForm').form('reset');
		orderAddEditor.html('');
	}
</script>
