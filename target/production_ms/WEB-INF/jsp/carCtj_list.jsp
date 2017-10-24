<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="carCtjList" title="信息列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carCtj/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carCtj">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnumber',width:100,align:'center'">车牌号</th>
        	<th data-options="field:'typename',align:'center',width:90,formatter:formatCarType">车型名称</th>
            <th data-options="field:'departmentName',align:'center',width:100,formatter:formatDepartment">所属部门</th>
            <th data-options="field:'username',align:'center',width:100">机动车所有人</th>
            <th data-options="field:'jigan',align:'center',width:100">登记机关</th>
            <th data-options="field:'usenature',width:80,align:'center'">车辆类型</th>
            <th data-options="field:'dengjitiem',width:100,align:'center',formatter:TAOTAO.formatDate">登记日期</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_carCtj" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
	
		<c:if test="${per=='carCtj:add' }" >
		    <div style="float: left;">  
		         <a href="carCtj/get_down" class="easyui-linkbutton" plain="true" icon="icon-add">导出报表</a> 
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carCtj_reload()">刷新</a>  
	</div> 
	<div style="float:left;">
	<div id="carCtjFind">
		&nbsp;&nbsp;日期：<select name="year" id="year5" style="width:70px;">
										<option value="0">全部</option>
								</select> &nbsp;&nbsp;&nbsp; 
								<select name="month" id="month5" style="width:70px;">
										<option value="0">全部</option>
								</select>&nbsp;&nbsp;
								类型：<select name="ctype" id="ctype" style="width:90px;">
										<option value="0">全部</option>
										<option value="专用汽车">专用汽车</option>
										<option value="公务用车">公务用车</option>
										<option value="生产用车">生产用车</option>
								</select>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarCtjFind()">查询</a>
	</div>
	</div>
</div>  

<script>
function submitCarCtjFind(){ //用户输入用户名,点击搜素,触发此函数  
	var year = document.getElementById("year5").value;
	var month = document.getElementById("month5").value;
	var ctype = document.getElementById("ctype").value;
	if(year=="0" && month!="0"){
		$.messager.alert('提示',"请先输入年份在输入月份查询！");
	}else{
		$("#carCtjList").datagrid({
	        title:'信息列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carCtj", url:'carCtj/search_carCtj?year5='+year+'&month5='+month+'&ctype='+ctype, method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'carnumber', width : 100, title : '车牌号', align:'center'},
	             	{field : 'typename', width : 90, align:'center',title : '车型名称',formatter:formatCarType},
	             	{field : 'departmentName', width : 100, align : 'center', title : '所属部门',formatter:formatDepartment},
	             	{field : 'username', width : 100, align : 'center', title : '机动车所有人'}, 
	             	{field : 'jigan', width : 100, title : '登记机关', align:'center'}, 
	            	{field : 'usenature', width : 80, title : '车辆类型', align:'center'}, 
	             	{field : 'dengjitiem', width : 100, title : '登记日期', align:'center',formatter:TAOTAO.formatDate}, 
	        ] ],  
	    });
	}
}
	
  //格式化车型信息
    function  formatCarType(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.carType.typename+"";
    	}
	};
	function  formatDepartment(value, row, index){ 
    	if(value ==null && value == ''){
			return '无';}
    	else{
    		return ""+row.department.departmentName+"";
    	}
	};
	 //格式化部门信息
 //   function  formatDepartment(value, row, index){ 
  //  		return ""+row.department.departmentName+"";
//	};
	//根据index拿到该行值
	function onCarCtjClickRow(index) {
		var rows = $('#carCtjList').datagrid('getRows');
		return rows[index];
	}
	function getCarCtjSelectionsIds(){
    	var carCtjList = $("#carCtjList");
    	var sels = carCtjList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].carId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	
    
    function carCtj_reload(){
    	$("#carCtjList").datagrid("reload");
    }
    $(function(){
        var $_year=$("#year5");
        for(var i= new Date().getFullYear();i>=2007 ;i--){
          var element = document.createElement("OPTION");
  		$_year[0].add(element);
  		element.value =i;
  		element.innerText = i;
        
           }
           //为了解决查询保存状态
  		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
           var $_month=$("#month5");
        for(var i=1;i<=12;i++){
          var element = document.createElement("OPTION");
  		$_month[0].add(element);
  		element.value =i;
  		element.innerText = i;
           }
           $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
       });
</script>