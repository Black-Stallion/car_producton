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
	<form id="carShengAddForm" class="carShengForm" method="post">
	 <center>
	    <table  class="border-table" cellpadding="5" algin="center">
	         <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">机动车证书编号</td>
	            <td width="auto">
	            	<input class="easyui-textbox" type="text" name="dengjizsid" data-options="required:true"></input>
	            </td>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">设备编号</td>
	            <td width="auto" >
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
	            <td><input class="easyui-textbox" type="text" name="usenature" data-options="required:true,editable:false" value="生产用车"></input>
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
    					data-options="valueField:'typeid',textField:'typename',
    						url:'carType/get_data', required:true,editable:false" />
    				</td> 
    				<td bgcolor="#F0F8FF" align="right">所属部门</td>
	            <td>
	            	<input class="easyui-combobox" id="departmenCombox15zx" data-options="required:true" panelHeight="150"/>
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input name="departmentId" id="departmentId11" type="hidden"/>
    				<!-- 
    				<input class="easyui-combobox" id="departmenCombox15zx" data-options="required:true" panelHeight="auto" size="8px" />
	            	<input name="departmentFrist" id="departmentFrist" type="hidden"/>
    				<input class="easyui-combobox" id="department15zx"  panelHeight="200" size="11px"/>  
    				<input name="departmentId" id="departmentId11" type="hidden"/>
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
    			<td bgcolor="#F0F8FF" align="right">购车批文</td>
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
	            	 <a href="javascript:void(0)" class="easyui-linkbutton shengPicFileUpload">上传图片</a>
	                 <input type="hidden" id="shengimage" name="image"/>
	            </td>
	        </tr>
	    </table>
	     </center>
	    <input type="hidden" name="carShengParams"/>
	</form>
	<div style="padding:5px 0 0 650px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarShengAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearCarShengADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//创建富文本编辑器
	//productAddEditor = TAOTAO.createEditor("#productAddForm [name=file]");
	//productAddEditor = KindEditor.create("#productAddForm [name=note]", TT.kingEditorParams);
	//初始化类目选择和图片上传器
	TAOTAO.initShengPicFileUpload({fun:function(node){
		//根据产品的分类id取产品 的规格模板，生成规格信息。第四天内容。
		TAOTAO.changeItemParam(node, "carShengAddForm");
	}});
});
	
	//提交表单
	function submitCarShengAddForm(){
		//有效性验证
		if(!$('#carShengAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("carPublic/check",$("#carShengAddForm").serialize(),function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
		$.post("carSheng/insert",$("#carShengAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增车辆成功!');
				$("input[name='image']").val(null);
				clearCarShengADDForm();
				$("#carShengAddWindow").window('close');
				$(".shengPicFileUpload").siblings("div.pics").find("ul > li").remove();
				$("#carShengList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
       		}
	 	});
	}
	$('#departmenCombox15zx').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
    //    panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId11').val(data.departmentId);  
    //        var fatherdep= $('#departmentFrist').val();
     //       $('#department15zx').combobox({  
     //           url:"department/get_data_second/"+fatherdep,  
     //           editable:false,  
     //           valueField:'departmentId',  
      //          textField:'departmentName' ,
     //           onSelect : function(data1){  
      //            $('#departmentId11').val(data1.departmentId);  
      //          }
      //      }).combobox('clear');  
        }  
    });  
	
	function clearCarShengADDForm(){
		$('#carShengAddForm').form('reset');
	}
	
</script>
