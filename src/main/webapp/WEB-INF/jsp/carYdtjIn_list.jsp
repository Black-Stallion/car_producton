<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYdtjInList" title="车辆调入列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYdtjIn/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYdtjIn">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum71',align:'center',width:100,formatter:formatCarNum71">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">调入人</th>
        	<th data-options="field:'dep71',align:'center',width:110,formatter:formatDepartment71">调入部门</th>
        	<th data-options="field:'deep71',align:'center',width:110,formatter:formatDepartment711">调出部门</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">调入日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
            <th data-options="field:'rbeiyong1',align:'center',width:100">车辆性质</th>
        </tr>
    </thead>
</table>
<div  id="toolbar_carYdtjIn" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYdtj:add' }" >
		    <div style="float: left;">  
		        <a href="carYdtjIn/get_down" class="easyui-linkbutton" plain="true" icon="icon-add">导出报表</a>   
		    </div>  
		</c:if>
		
	</c:forEach>
	
	 
	
	<div style="float:left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYdtjIn_reload()">刷新</a>  
	</div>  
	<div style="float:left;">
	<div id="carYdtjInFind">
		&nbsp;&nbsp;日期<select name="year" id="year" style="width:120px;">
										<option value="0">全部</option>
								</select> &nbsp;&nbsp;&nbsp; 
								<select name="month" id="month" style="width:120px;">
										<option value="0">全部</option>
								</select>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYdtjIn()">查询</a>
	</div>
	</div> 
</div>  
<script>
function submitCarYdtjIn(){
		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		if(year=="0" && month!="0"){
			$.messager.alert('提示',"请先输入年份在输入月份查询！");
		}else{
		$("#carYdtjInList").datagrid({
	        title:'车辆调入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYdtjIn", url:'carYdtjIn/search_carYdtj?year='+year+'&month='+month, method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum71', width : 100, align : 'center', title : '调入车辆',formatter:formatCarNum71},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调入人'},
	             	{field : 'dep71', width : 110, align : 'center', title : '调入部门',formatter:formatDepartment71},
	             	{field : 'deep71', width : 110, align : 'center', title : '调出部门',formatter:formatDepartment711},
	             	{field : 'removetime', width : 120, align:'center', title : '调入日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 100, align : 'center', title : '车辆性质'}
	             
	        ] ],  
	    });
		}
}
function  formatCarNum71(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment71(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
function  formatDepartment711(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department1.departmentName+"";
	}
};
    function getCarYdtjInSelectionsIds(){
    	var carYdtjInList = $("#carYdtjInList");
    	var sels = carYdtjInList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].inId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    } 

    function carYdtjIn_reload(){
    	$("#carYdtjInList").datagrid("reload");
    }
    
  
    $(function(){
        var $_year=$("#year");
        for(var i= new Date().getFullYear();i>=2007 ;i--){
          var element = document.createElement("OPTION");
  		$_year[0].add(element);
  		element.value =i;
  		element.innerText = i;
        
           }
           //为了解决查询保存状态
  		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
           var $_month=$("#month");
        for(var i=1;i<=12;i++){
          var element = document.createElement("OPTION");
  		$_month[0].add(element);
  		element.value =i;
  		element.innerText = i;
           }
           $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
       });
</script>