<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYdtjSelfList" title="段内调配列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYdtjSelf/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYdtjSelf">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum70',align:'center',width:100,formatter:formatCarNum70">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">调配人</th>
        	<th data-options="field:'dep70',align:'center',width:110,formatter:formatDepartment70">调入车间</th>
        	<th data-options="field:'deep70',align:'center',width:110,formatter:formatDepartment701">调出车间</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">调出日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
             <th data-options="field:'rbeiyong1',align:'center',width:100">车辆性质</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYdtjSelf" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYdtj:add' }" >
		    <div style="float: left;">  
		        <a href="carYdtjSelf/get_down" class="easyui-linkbutton" plain="true" icon="icon-add">导出报表</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYdtjSelf_reload()">刷新</a>  
	</div>  
	<div style="float:left;">
	<div id="carYdtjSelfFind">
		&nbsp;&nbsp;日期<select name="year" id="year3" style="width:120px;">
										<option value="0">全部</option>
								</select> &nbsp;&nbsp;&nbsp; 
								<select name="month" id="month3" style="width:120px;">
										<option value="0">全部</option>
								</select>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYdtjSelf()">查询</a>
	</div>
	</div>

</div>  

<script>
function submitCarYdtjSelf(){ //用户输入用户名,点击搜素,触发此函数  
	var year = document.getElementById("year3").value;
	var month = document.getElementById("month3").value;
	if(year=="0" && month!="0"){
		$.messager.alert('提示',"请先输入年份在输入月份查询！");
	}else{
		$("#carYdtjSelfList").datagrid({
	        title:'段内调配列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYdtjSelf", url:'carYdtjSelf/search_carYdtjSelf?year3='+year+'&month3='+month, method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum70', width : 100, align : 'center', title : '调出车辆',formatter:formatCarNum70},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '调配人'},
	             	{field : 'dep70', width : 110, align : 'center', title : '调入车间',formatter:formatDepartment70},
	             	{field : 'deep70', width : 110, align : 'center', title : '调出车间',formatter:formatDepartment701},
	             	{field : 'removetime', width : 120, align:'center', title : '调出日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 100, align : 'center', title : '车辆性质'}
	        ] ],  
	    });
	}
}
function  formatCarNum70(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment70(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department5.departmentName+"";
	}
};
function  formatDepartment701(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department6.departmentName+"";
	}
};
    function getCarYdtjSelfSelectionsIds(){
    	var carYdtjSelfList = $("#carYdtjSelfList");
    	var sels = carYdtjSelfList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].selfId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function carYdtjSelf_reload(){
    	$("#carYdtjSelfList").datagrid("reload");
    }
    
  
    $(function(){
        var $_year=$("#year3");
        for(var i= new Date().getFullYear();i>=2007 ;i--){
          var element = document.createElement("OPTION");
  		$_year[0].add(element);
  		element.value =i;
  		element.innerText = i;
        
           }
           //为了解决查询保存状态
  		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
           var $_month=$("#month3");
        for(var i=1;i<=12;i++){
          var element = document.createElement("OPTION");
  		$_month[0].add(element);
  		element.value =i;
  		element.innerText = i;
           }
           $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
       });
</script>