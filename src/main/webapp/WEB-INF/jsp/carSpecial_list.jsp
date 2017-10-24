<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
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
<table class="easyui-datagrid" id="carSpecialList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carSpecial/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carSpecial">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnumber',width:100,align:'center'">车牌号</th>
        	<th data-options="field:'typename3',align:'center',width:90,formatter:formatCarType3">车型名称</th>
            <th data-options="field:'departmentName',align:'center',width:100,formatter:formatDepartment">所属部门</th>
            <th data-options="field:'username',align:'center',width:100">机动车所有人</th>
            <th data-options="field:'jigan',align:'center',width:100">登记机关</th>
            <th data-options="field:'color',width:80,align:'center'">车辆颜色</th>
            <th data-options="field:'dengjitiem',width:100,align:'center',formatter:TAOTAO.formatDate">登记日期</th>
            <th data-options="field:'usenature',width:100,align:'center'">车辆性质</th>
            <th data-options="field:'formatCarList3',width:130,align:'center',formatter:formatCarList3">查看详细信息</th>
             <th data-options="field:'carSpecialEdit',align:'center',width:50,formatter:formatCarSpecialEdit">编辑</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carSpecial" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carSpecial:add' }" >
		    <div style="float: left;">  
		         <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="carSpecial_add()">新增</a> 
		    </div>  
		</c:if>
		<!-- 
		<c:if test="${per=='carSpecial:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="carSpecial_edit()">编辑</a>  
		    </div>  
		</c:if>
		 -->
		
		<c:if test="${per=='carSpecial:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="carSpecial_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carSpecial_reload()">刷新</a>  
	</div> 
	<div id="search_carSpecial" style="float: right;">
        <input id="search_text_carSpecial" class="easyui-searchbox"  
            data-options="searcher:doSearch_carSpecial,prompt:'请输入...',menu:'#menu_carSpecial'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_carSpecial" style="width:120px"> 
			<div data-options="name:'carnumber1'">车牌号</div>
			<div data-options="name:'departmentName1'">所在部门</div> 
			<div data-options="name:'username1'">机动车所有人</div>
		</div>     
    </div>
</div>  

<div id="carSpecialEditWindow" class="easyui-window" title="编辑车辆" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSpecial/edit'" style="width:800px;height:590px;padding:10px;">
</div>
<div id="carSpecialAddWindow" class="easyui-window" title="添加车辆" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'carSpecial/add'" style="width:800px;height:590px;padding:10px;">
</div>
<div id="carSpecialInfo" class="easyui-dialog" title="车型信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:770px;height:550px;padding:20px;">
	<form id="carTypeEditForm14" method="post">					
		<input type="hidden" name="typeid"/>
	    <center>
	    <table class="border-table" cellpadding="5" align="center">
		     <tr>
	    			<td width="auto"  bgcolor="#F0F8FF">车型名称</td>
		            <td width="auto"><input class="easyui-textbox" type="text" name="typename" data-options="required:true"> </td>
	        			<td  width="auto"  bgcolor="#F0F8FF">国产/进口</td>
		            	<td width="auto"><select id="cc" class="easyui-combobox" name="carcd" panelHeight="auto" data-options="required:true, width:150, editable:false">
		            		<option value="国产">国产</option>
		            		<option value="进口">进口</option>
		            	</select> </td>
		      </tr>
	         <tr>
    			<td bgcolor="#F0F8FF">车辆类型</td>
	             <td> <input class="easyui-textbox" type="text" name="ctype" data-options="required:true"></input>
	             </td>
        			<td bgcolor="#F0F8FF">车辆品牌</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="brand" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF">车辆型号</td>
	            <td><input class="easyui-textbox" type="text" name="carxh" data-options="required:true"> </td>
	       		<td bgcolor="#F0F8FF">驾驶室载客</td>
	            <td><input class="easyui-textbox" type="text" name="cabnums" size="17">&nbsp;人</td>
	        </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF">发动机号</td>
	            <td><input class="easyui-textbox" type="text" name="engineid"> </td>
        			<td  bgcolor="#F0F8FF">发动机型号</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="enginexh"></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF">燃料种类</td>
	            <td><input class="easyui-textbox" type="text" name="fueltype"> </td>
        		<td bgcolor="#F0F8FF">排量/功率</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="pailiang" size="4" >ml/&nbsp;</input>
	            	<input class="easyui-numberbox" type="text" name="power" size="4" >Kw</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">制造厂名称</td>
	            <td><input class="easyui-textbox" type="text" name="factory"> </td>
        		<td bgcolor="#F0F8FF">转向形式</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="turnxs" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td  bgcolor="#F0F8FF">轮距</td>
	            <td>前&nbsp;<input class="easyui-numberbox" type="text" name="frontlunju" size="4" ></input>
	            	后&nbsp;<input class="easyui-numberbox" type="text" name="afterlunju" size="4" >&nbsp;mm</input> </td>
        		<td width="auto"  bgcolor="#F0F8FF">轮胎数</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="tirenum" ></input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">轮胎规格</td>
	            <td><input class="easyui-textbox" type="text" name="fronttiregg"></input></td>
        		<td width="auto"  bgcolor="#F0F8FF">钢板弹簧片数数</td>
	            <td>
	            	&nbsp;后轴&nbsp;<input class="easyui-numberbox" type="text" name="gbthps" size="5" >&nbsp;数</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">轴距</td>
	            <td><input class="easyui-numberbox" type="text" name="zhouju" size="17">&nbsp;mm</td>
        		<td  bgcolor="#F0F8FF">轴数</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="zhoushu" ></input>
	            </td>
	        </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF">外廓尺寸</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-numberbox" type="text" name="carwlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-numberbox" type="text" name="carwwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-numberbox" type="text" name="carwhigh" size="14">&nbsp;mm</td>
	        </tr>
	         <tr>
    			<td  bgcolor="#F0F8FF">货箱内部尺寸</td>
	            <td colspan="3">&nbsp;长&nbsp;<input class="easyui-numberbox" type="text" name="carnlong" size="14" ></input>
	            	&nbsp;宽&nbsp;<input class="easyui-numberbox" type="text" name="carnwide" size="14" ></input> 
	            	&nbsp;高&nbsp;<input class="easyui-numberbox" type="text" name="carnhigh" size="14">&nbsp;mm</td>
	        </tr>
	       <tr>
    			<td  bgcolor="#F0F8FF">总质量</td>
	            <td><input class="easyui-numberbox" type="text" name="carquality" size="17">&nbsp;kg</td>
        		<td bgcolor="#F0F8FF">核定载质量</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="carcheckquality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	        <tr>
    			<td bgcolor="#F0F8FF">核定载客</td>
	            <td><input class="easyui-numberbox" type="text" name="checknums" size="17">&nbsp;人</td>
        		<td bgcolor="#F0F8FF">牵引总质量</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" name="tractionquality" size="17" >&nbsp;kg</input>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	
</div>
<div id="carListWindow3" class="easyui-dialog" title="车辆信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:800px;height:590px;padding:10px;">
	<div class="easyui-tabs" style="width:800px;height:560px;">
		<div title="车辆信息" style="width:800px;height:560px;">
	<form id="carSpecial1EditForm" method="post">					
		<input type="hidden" name="carId"/>
	    <center>
	   <table class="border-table" cellpadding="5" algin="center">
	         <tr>
	            <td width="auto"  bgcolor="#F0F8FF" align="right">机动车证书编号</td>
	            <td width="auto" >
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
	             <td bgcolor="#F0F8FF" align="right">车辆性质</td>
	            <td><input class="easyui-textbox" type="text" name="usenature" data-options="required:true,editable:false" value="专用汽车"></input>
	             </td>
	            <td bgcolor="#F0F8FF" align="right">登记机关</td>
	            <td>
	            	<input type="text" class="easyui-textbox" name="jigan"  data-options="required:true" />
    			</td>  
	        </tr>
	        <tr>
	    			<td bgcolor="#F0F8FF" align="right">车型名称</td>
		            <td>
	            	<input class="easyui-combobox" name="typeid"   panelHeight="200" 
    					data-options="valueField:'typeid',textField:'typename',
    						url:'carType/get_data', editable:false, required:true" />
    				</td> 
    				<td bgcolor="#F0F8FF" align="right">所属部门</td>
	            <td>
    				<input class="easyui-textbox" id="departmentqwe2" name="departmentName"  panelHeight="200" size="10px"/>  
    				<input name="departmentId" id="departmentId96" type="hidden"/>
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
	            	<input class="easyui-numberbox" type="text" name="phone"  ></input>
	            </td>
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF" align="right">车辆图片</td>
	            <td colspan="3">
	             <div style="padding-top: 12px"><span id="specialPicSpan"></span></div>
	                 <input type="hidden" class="easyui-linkbutton specialPic" name="image"/>
	            </td>
	        </tr>
	    </table>
	     </center>
	</form>
	</div>
	<div title="用油记录" style="width:800px;height:560px;">
			<form id="carYoukaFind2Form21" method="post">
			<center>
	    	<table  class="border-table" cellpadding="5" algin="center">
	        <tr>
	            <td bgcolor="#F0F8FF" width="120px">车辆性质及车辆</td>
	            <td width="250px">
	            	<input class="easyui-textbox" editable="false" name="usenature" panelHeight="auto" size="9px" />
	            	<input name="usenature" id="usenature523" type="hidden"/>
    				<input class="easyui-textbox" editable="false" name="carnumber" panelHeight="auto" size="10px"/>  
    				<input name="carId" type="hidden"/>
	            </td> 
	        </tr>
	        <tr>
	            <td bgcolor="#F0F8FF">油卡编号</td>
	            <td>
	            	<input  class="easyui-textbox" editable="false" name="younumber"  />
	            </td>
	         </tr>
	          <tr>
	            <td bgcolor="#F0F8FF">累计用油</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" editable="false" name="allyou">&nbsp;L</input>
	            </td>
	         </tr>
	          <tr>
	            <td bgcolor="#F0F8FF">累计金额</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" type="text" editable="false" name="alltomoney">&nbsp;元</input>
	            </td>
	         </tr>
	    </table>
	    </center>
	</form>
		</div>
		<div title="用车记录" style="width:800px;height:560px;">
		 <table id="carSend1Lists" class="easyui-datagrid">
		</table> 
		</div> 
		<div title="保养记录" style="width:800px;height:560px;">
		 <table id="carKeep1Lists" class="easyui-datagrid">
		</table> 
		</div> 
		<div title="维修记录" style="width:800px;height:560px;">
		 <table id="carKeepApply1Lists" class="easyui-datagrid">
		</table> 
		</div>  
		<div title="事故记录" style="width:800px;height:560px;">
		 <table id="carShigu1Lists" class="easyui-datagrid">
		</table> 
		</div> 
		<div title="违章记录" style="width:800px;height:560px;">
		 <table id="carWeizhang1Lists" class="easyui-datagrid">
		</table> 
		</div>
		<div title="运用记录" style="width:800px;height:560px;">
		 <table id="carUsing1Lists" class="easyui-datagrid">
		</table> 
		</div>
		<div title="月检记录" style="width:800px;height:560px;">
		 <table id="carCheck1Lists" class="easyui-datagrid">
		</table> 
		</div>
		<div title="所换大件记录" style="width:800px;height:560px;">
		 <table id="carBig1Lists" class="easyui-datagrid">
		</table> 
		</div>   
	</div>
</div>
<script>
function doSearch_carSpecial(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#carSpecialList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carSpecial", url:'carSpecial/list', method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'carnumber', width : 100, title : '车牌号', align:'center'},
	             	{field : 'typename3', width : 90, align:'center',title : '车型名称',formatter:formatCarType3},
	             	{field : 'departmentName', width : 100, align : 'center', title : '所属部门',formatter:formatDepartment},
	             	{field : 'username', width : 100, align : 'center', title : '机动车所有人'}, 
	             	{field : 'jigan', width : 100, title : '登记机关', align:'center'}, 
	            	{field : 'color', width : 80, title : '车辆颜色', align:'center'}, 
	             	{field : 'dengjitiem', width : 100, title : '登记日期', align:'center',formatter:TAOTAO.formatDate}, 
	             	{field : 'usenature', width : 100, title : '车辆性质', align:'center'},
	             	{field : 'formatCarList3', width : 130, title : '查看详细信息', align:'center',formatter:formatCarList3},
	             	{field : 'carSpecialEdit', width : 50, align:'center', title : '编辑',formatter:formatCarSpecialEdit}
	        ] ],  
	    });
	}else{
		$("#carSpecialList").datagrid({  
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carRegister", url:'carSpecial/search_carSpecial_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
	         	{field : 'carnumber', width : 100, title : '车牌号', align:'center'},
	         	{field : 'typename3', width : 90, align:'center',title : '车型名称',formatter:formatCarType3},
	         	{field : 'departmentName', width : 100, align : 'center', title : '所属部门',formatter:formatDepartment},
	         	{field : 'username', width : 100, align : 'center', title : '机动车所有人'}, 
	         	{field : 'jigan', width : 100, title : '登记机关', align:'center'}, 
	        	{field : 'color', width : 80, title : '车辆颜色', align:'center'}, 
	         	{field : 'dengjitiem', width : 100, title : '登记日期', align:'center',formatter:TAOTAO.formatDate}, 
	         	{field : 'usenature', width : 100, title : '车辆性质', align:'center'},
	         	{field : 'formatCarList3', width : 130, title : '查看详细信息', align:'center',formatter:formatCarList3},
             	{field : 'carSpecialEdit', width : 50, align:'center', title : '编辑',formatter:formatCarSpecialEdit}
	        ] ],  
	    });
	}
}
//编辑
function  formatCarSpecialEdit(value, row, index){ 
	return "<a herf='#' style='cursor:pointer' icon='icon-edit' onclick='carSpecial_edit()'><span style='color:blue'>编辑</span></a>";
};
  //格式化车型信息
    function  formatCarType3(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return "<a href=javascript:openCarType3("+index+")>"+row.carType.typename+"</a>";
    	}
	};
	function  formatDepartment(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.department.departmentName+"";
    	}
	};
	//格式化车辆信息
	 function  formatCarList3(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return "<a href=javascript:openCarList3("+index+")>"+"车辆详细信息"+"</a>";
	    	}
		};
	 //格式化部门信息
 //   function  formatDepartment(value, row, index){ 
  //  		return ""+row.department.departmentName+"";
//	};
	//根据index拿到该行值
	function onCarSpecialClickRow(index) {
		var rows = $('#carSpecialList').datagrid('getRows');
		return rows[index];
	}
	
	//打开车型信息对话框
	function  openCarType3(index){ 
		var row = onCarSpecialClickRow(index);
		$("#carSpecialInfo").dialog({
    		onOpen :function(){
    			$.get("carType/get/"+row.carType.typeid,'',function(data){
		    		//回显数据
		    		$("#carTypeEditForm14").form("load",data);
    	    	});
    		},
    	}).dialog("open");
	};
		 function  formatChepai(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		debugger;
		    		return ""+row.carRegister.carnumber+"";
		    	}
			};
			function  formatDep(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		debugger;
		    		return ""+row.department.departmentName+"";
		    	}
			};
			function  formatDriver(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		debugger;
		    		return ""+row.carDriver.drviername+"";
		    	}
			};
			function  formatKM(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		if(row.endkm==null || row.endkm=='' ){
		    			return '<span style="color:red;">派车未归或未填结束里程!</span>';
		    		}else{
		    			return ""+row.endkm-row.firstkm+"&nbsp;公里";
		    		}
		    	}
			};
	function  formatCarNum54(value, row, index){ 
		if(value ==null && value == ''){
			return '无';}
		else{
			return ""+row.carRegister.carnumber+"";
		}
	};
	    
	    function  formatDepartment54(value, row, index){ 
	    	if(value ==null && value == ''){
				return '无';}
	    	else{
	    		return ""+row.department.departmentName+"";
	    	}
		};
		 function  formatDepartment55(value, row, index){ 
		    	if(value ==null && value == ''){
					return '无';}
		    	else{
		    		return ""+row.department.departmentName+"";
		    	}
			};
			function  formatdr2(value, row, index){ 
				if(value ==null && value == ''){
					return '无';}
				else{
					return ""+row.carDriver.drviername+"";
				}
			};
			function  formatdr1(value, row, index){ 
				if(value ==null && value == ''){
					return '无';}
				else{
					return ""+row.carDriver.drviername+"";
				}
			};
			function  formatcar1(value, row, index){ 
				if(value ==null && value == ''){
					return '无';}
				else{
					return ""+row.carRegister.carnumber+"";
				}
			};
			function  formatCarNum66(value, row, index){ 
				if(value ==null && value == ''){
					return '无';}
				else{
					return ""+row.carRegister.carnumber+"";
				}
			};
			function  formatCarDriver(value, row, index){ 
				if(value ==null && value == ''){
					return '无';}
				else{
					return ""+row.carDriver.drviername+"";
				}
			};
			//格式化车型信息
			function  formatCarNumber61(value, row, index){ 
				debugger;
				if(value ==null && value ==''){
					return '无';}
				else{
					return ""+row.register.carnumber+"";
					//return '无';
				}
			};
			function  formatCarNumber62(value, row, index){ 
				debugger;
				if(value ==null && value ==''){
					return '无';}
				else{
					return ""+row.register.carnumber+"";
					//return '无';
				}
			};
	//打开车辆对话框
	function  openCarList3(index){ 
		var row = onCarSpecialClickRow(index);
		$("#carListWindow3").dialog({
    		onOpen :function(){
    			$.get("carSpecial/get/"+row.carId,'',function(data){
		    		//回显数据
		    		data.dengjitiem = TAOTAO.formatDateTime(data.dengjitiem);
		    		data.issuedate = TAOTAO.formatDateTime(data.issuedate);
		    		data.manufacturedate = TAOTAO.formatDateTime(data.manufacturedate);
		    		data.departmentId = data.department.departmentId;
    				data.departmentName = data.department.departmentName;
		    		data.typeid = data.carType.typeid; 
		    		$("#carSpecial1EditForm").form("load",data);
		    		//加载图片
		    		initSpecialPic({
		    			"pics" :data.image,
		    		});
    	    	});
    			//油卡信息
    			$.get("carYouka/get_car/"+row.carId,'',function(data){
		    		//回显数据manufacturedateissuedate dengjitiem
    				data.younumber = data.carYou.younumber; 
        			data.carnumber = data.carRegister.carnumber;
    				data.usenature = data.carRegister.usenature;
    				data.carId = data.carRegister.carId;
        			$("#carYoukaFind2Form21").form("load", data);
    	    	});
    			//派车单信息
				$("#carSend1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'carSend/byCarId/'+row.carId, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
		             	{field : 'sendnums', width : 80, title : '申批编号', align:'center'},
		             	{field : 'chepai', width : 80, align:'center',title : '车牌号',formatter:formatChepai},
		             	{field : 'usercarpeople', width : 100, align : 'center', title : '用车人'},
		             	{field : 'dep', width : 100, align : 'center', title : '用车单位',formatter:formatDep}, 
		             	{field : 'sdate', width : 100, title : '日期', align:'center',formatter:TAOTAO.formatDate}, 
		             	{field : 'formatKM',align:'center',width:80,title : '行走公里',formatter:formatKM}, 
		            	{field : 'drivername', width : 100, title : '驾驶员', align:'center',formatter:formatDriver}, 
			        ] ],  
			   	 });
				//保养信息
				$("#carKeep1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'carKeep/findKeep/'+row.carId, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field : 'carnum54', width : 100, align : 'center', title : '保养车辆',formatter:formatCarNum54},
		             	{field : 'intervalkm', width : 100, align : 'center', title : '当前里程(/公里)'},
		             	{field : 'departmentName54', width : 100, align : 'center', title : '所在部门',formatter:formatDepartment54},
		             	{field : 'startdate', width : 80, align : 'center', title : '开始日期',formatter:TAOTAO.formatDate},
		             	{field : 'enddate', width : 80, align:'center', title : '截止日期',formatter:TAOTAO.formatDate},
		             	{field : 'repairtype', width : 200, align : 'center', title : '保养级别或保养项目'},
		             	{field : 'suppliername', width : 80, align : 'center', title : '厂家名称'},
			        ] ],  
			   	 });
				//保养信息
				$("#carKeepApply1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'carKeepApply/findKeepApply/'+row.carnumber, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field : 'carnum', width : 80, align : 'center', title : '保养车辆'},
		             	{field : 'applyname', width : 70, align : 'center', title : '申请人'},
		             	{field : 'approve', width : 70, align : 'center', title : '审批人'},
		             	{field : 'intervalkm', width : 80, align : 'center', title : '当前里程(/公里)'},
		             	{field : 'dep55', width : 100, align : 'center', title : '所在部门',formatter:formatDepartment55},
		             	{field : 'startdate', width : 80, align : 'center', title : '开始日期',formatter:TAOTAO.formatDate},
		             	{field : 'enddate', width : 80, align:'center', title : '截止日期',formatter:TAOTAO.formatDate},
		             	{field : 'repairtype', width : 200, align : 'center', title : '维护级别或维护项目'},
		             	{field : 'stats', width : 60, align : 'center', title : '申请状态'}
			        ] ],  
			   	 });
				//事故记录
				$("#carShigu1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'shigu/findShigu/'+row.carnumber, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field : 'shigucode', width : 100, align:'center', title : '事故编号'},
		             	{field : 'shigutime', width : 100, align:'center', title : '事故时间',formatter:TAOTAO.formatDate},
		            	{field : 'place', width : 100, align : 'center', title : '事故地点'},
		             	{field : 'shigutype', width : 100, align : 'center', title : '事故类型'},
		             	{field : 'zeren', width : 100, align : 'center', title : '责任'}, 
		            	{field : 'carnumber', width : 100, title : '车牌号', align:'center'}, 
		            	{field : 'driver2', width : 100, title : '主车司机', align:'center',formatter:formatdr2},
			        ] ],  
			   	 });
				//违章记录
				$("#carWeizhang1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'weigui/findWeigui/'+row.carId, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field : 'car1', width : 100, align:'center', title : '车牌号',formatter:formatcar1},
		             	{field : 'weiguitime', width : 100, align:'center', title : '违规时间',formatter:TAOTAO.formatDate},
		             	{field : 'xingwei', width : 100, align : 'center', title : '违规行为'}, 
		             	{field : 'score', width : 100, title : '积分', align:'center'}, 
		            	{field : 'money', width : 100, title : '罚款金额', align:'center'},
		            	{field : 'driver1', width : 100, title : '主车司机', align:'center',formatter:formatdr1},
		             	{field : 'chuliname', width : 100, title : '处理人', align:'center'}, 
			        ] ],  
			   	 });
				//运用记录
				$("#carUsing1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'carUsing/findUsing/'+row.carId, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field : 'formatCarNum', width : 100, align:'center', title : '车牌号',formatter:formatCarNumber61},
		             	{field : 'usingyear', width : 100, align:'center', title : '运用年'},
		             	{field : 'usingmonth', width : 100, align : 'center', title : '运用月'},
		             	{field : 'monthnumbers', width : 120, align : 'center', title : '路码表月终读数'}, 
		             	{field : 'monthkm', width : 100, title : '月公里', align:'center'}, 
		            	{field : 'monthtime', width : 100, title : '趟数', align:'center'}, 
		             	{field : 'monthdays', width : 100, title : '天数', align:'center'}, 
		             	{field : 'haoyou', width : 100, title : '百公里耗油', align:'center'}, 
			        ] ],  
			   	 });
				//月检记录
				$("#carCheck1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'carCheck/findCheck/'+row.carId, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field : 'shebeiid', width : 100, align:'center', title : '车牌号',formatter:formatCarNumber62},
		             	{field : 'checkyear', width : 100, align:'center', title : '运用年'},
		             	{field : 'checkmonth', width : 100, align : 'center', title : '运用月'},
		             	{field : 'carscore', width : 100, align : 'center', title : '车况评分'}, 
		             	{field : 'carquestion', width : 150, title : '存在问题', align:'center'}, 
		            	{field : 'results', width : 150, title : '处理结果', align:'center'}
			        ] ],  
			   	 });
				//所换大件记录
				$("#carBig1Lists").datagrid({
			         singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true, 
			        url:'carBig/findBig/'+row.carId, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
			        columns : [ [ 
			        	{field :'num66',align:'center',width:150,formatter:formatCarNum66,title:'更换大件车辆'},
		             	{field : 'changedate', width : 100, title : '更换日期', align:'center',formatter:TAOTAO.formatDate}, 
		             	{field : 'drivername', width : 100, align:'center', title : '主车司机',formatter:formatCarDriver},
		             	{field : 'changbig', width : 200, align : 'center', title : '所换大件'},
		             	{field : 'why', width : 200, align : 'center', title : '原因'}
			        ] ],  
			   	 });
    		},
    		onclose :function(){
       			$(".picFileUpload").siblings("div.pics").find("ul > li").remove();
    		}
    	}).dialog("open");
		$('#carYoukaFind2Form21').form('reset');
	};
	 function initSpecialPic(data){
	    	$(".specialPic").each(function(i,e){
	    		var _ele = $(e);
	    		_ele.siblings("div.pics").remove();
	    		_ele.after('\
	    			<div class="pics">\
	        			<ul></ul>\
	        		</div>');
	    		// 回显图片
	    		var j = false;
	        	if(data && data.pics){
	        		var imgs = data.pics.split(",");
	        		for(var i in imgs){
	        			if($.trim(imgs[i]).length > 0){
	        				_ele.siblings(".pics").find("ul").append("<li><a id='img"+i+"' href='"+imgs[i]+"' target='_blank'>" +
	        						"<img src='"+imgs[i]+"' width='80' height='50' /></a> ");
	        				j = true;
	        			}
	        		}
	        	}
	        	if(!j){
	    			$("#specialPic").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
	    		}
	    	});
	    }
		
	function getCarSpecialSelectionsIds(){
    	var carSpecialList = $("#carSpecialList");
    	var sels = carSpecialList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	function submitCarTypeEditForm(){
		$.get("carType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#carTypeEditForm14').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("carType/update_all",$("#carTypeEditForm14").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改车型成功!','info',function(){
    						$("#carSpecialInfo").dialog("close");
    						$("#carSpecialList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	//修改车辆信息
	function submitCarEditForm(){
		$.get("carSpecial/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#carEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("carSpecial/update_all",$("#carEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改车辆成功!','info',function(){
    						$("#carListWindow3").dialog("close");
    						$("#carSpecialList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//更新信息要求
	function updateCarSpecialNote(){
		$.get("carSpecial/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			carSpecialNoteEditor.sync();
    			$.post("carSpecial/update_note",$("#carSpecialNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#carSpecialNoteDialog").dialog("close");
    					$("#carSpecialList").datagrid("reload");
    					$.messager.alert("操作提示", "更新信息要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新信息要求失败！");
    				}
    			});
    		}
    	});
	}
	
    
    
    function carSpecial_add(){
    	$.get("carSpecial/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#carSpecialAddWindow").window("open");
       		}
       	});
    }
    
    function carSpecial_edit(){
    	$.get("carSpecial/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCarSpecialSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个信息才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个信息!');
               		return ;
               	}
               	
               	$("#carSpecialEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#carSpecialList").datagrid("getSelections")[0];
               			data.dengjitiem = TAOTAO.formatDateTime(data.dengjitiem);
    		    		data.issuedate = TAOTAO.formatDateTime(data.issuedate);
    		    		data.manufacturedate = TAOTAO.formatDateTime(data.manufacturedate);
    		    		data.departmentId = data.department.departmentId;
    		    		//if(data.department.fatherdep=='0'){
            			//	data.fathername = data.department.departmentName;
            			//}else{
            				data.departmentName = data.department.departmentName;
            		//}
    		    		data.typeid = data.carType.typeid; 
               			$("#carSpecialEditForm").form("load", data);
               			TAOTAO.initSpecialPicFileUpload({
            				"pics" : data.image,
            			});
               		},
               		onclose :function(){
               			$(".specialPicFileUpload").siblings("div.pics").find("ul > li").remove();
            		}
               		
               	}).window("open");
       		}
       	});
    }
    function getCarSpecialSelectionsNames(){
    	var carSpecialList = $("#carSpecialList");
    	var sels = carSpecialList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carnumber);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carSpecial_delete(){
    	$.get("carSpecial/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var names = getCarSpecialSelectionsNames();
      			var ids = getCarSpecialSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中信息!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除车牌号为 '+names+' 的信息吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("carSpecial/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除信息成功!',undefined,function(){
                  					$("#carSpecialList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    $('#departmenComboxzxc1').combobox({  
        url: "department/get_data_first",  
        editable:false,  
        valueField:'departmentId',   
        textField:'departmentName',  
        panelHeight:'auto',  
        onSelect : function(data){  
            $('#departmentFrist').val(data.departmentId);  
            $('#departmentId95').val(data.departmentId);  
            var fatherdep= $('#departmentFrist').val();
          
            $('#departmentzxc1').combobox({  
               
                url:"department/get_data_second/"+fatherdep,  
                valueField:'departmentId',  
                textField:'departmentName' ,
                
                onSelect : function(data1){  
                  $('#departmentId95').val(data1.departmentId);  
                
                }
           
            }).combobox('clear');  
           
		
        }  
    });  
	
    function carSpecial_reload(){
    	$("#carSpecialList").datagrid("reload");
    }
</script>