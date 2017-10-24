<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYdtjOutList" title="车辆调入列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYdtjOut/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYdtjOut">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum72',align:'center',width:100,formatter:formatCarNum72">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">调出人</th>
        	<th data-options="field:'dep72',align:'center',width:110,formatter:formatDepartment72">调入部门</th>
        	<th data-options="field:'deep72',align:'center',width:110,formatter:formatDepartment721">调出部门</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">调出日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
            <th data-options="field:'rbeiyong1',align:'center',width:100">车辆性质</th>
        </tr>
    </thead>
</table>
<div  id="toolbar_carYdtjOut" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYdtj:add' }" >
		    <div style="float: left;">  
		       <a href="carYdtjOut/get_down" class="easyui-linkbutton" plain="true" icon="icon-add">导出报表</a>  
		    </div>  
		</c:if>
		
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYdtjOut_reload()">刷新</a>  
	</div>  
	<div style="float:left;">
	<div id="carYdtjOutFind">
		&nbsp;&nbsp;日期<select name="year" id="year1" style="width:120px;">
										<option value="0">全部</option>
								</select> &nbsp;&nbsp;&nbsp; 
								<select name="month" id="month1" style="width:120px;">
										<option value="0">全部</option>
								</select>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYdtjOut()">查询</a>
	</div>
	</div> 
</div>  
<script>
function submitCarYdtjOut(){
	var year = document.getElementById("year1").value;
	var month = document.getElementById("month1").value;
	if(year=="0" && month!="0"){
		$.messager.alert('提示',"请先输入年份在输入月份查询！");
	}else{
		$("#carYdtjOutList").datagrid({
	        title:'车辆调入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYdtjOut", url:'carYdtjOut/search_carYdtjOut?year1='+year+'&month1='+month, method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	        	{field : 'ck', checkbox:true }, 
             	{field : 'newnum72', width : 100, align : 'center', title : '车辆牌照',formatter:formatCarNum72},
             	{field : 'rbieyong2', width : 80, align : 'center', title : '调出人'},
             	{field : 'dep72', width : 110, align : 'center', title : '调入部门',formatter:formatDepartment72},
             	{field : 'deep72', width : 110, align : 'center', title : '调出部门',formatter:formatDepartment721},
             	{field : 'removetime', width : 120, align:'center', title : '调出日期',formatter:TAOTAO.formatDate},
             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
             	{field : 'rbeiyong1', width : 100, align : 'center', title : '车辆性质'}
        ] ],  
	    });
	}
}
function  formatCarNum72(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment72(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department2.departmentName+"";
	}
};
function  formatDepartment721(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department3.departmentName+"";
	}
};
    function getCarYdtjOutSelectionsIds(){
    	var carYdtjOutList = $("#carYdtjOutList");
    	var sels = carYdtjOutList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].inId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    } 

    function carYdtjOut_reload(){
    	$("#carYdtjOutList").datagrid("reload");
    }
    
  
    $(function(){
        var $_year=$("#year1");
        for(var i= new Date().getFullYear();i>=2007 ;i--){
          var element = document.createElement("OPTION");
  		$_year[0].add(element);
  		element.value =i;
  		element.innerText = i;
        
           }
           //为了解决查询保存状态
  		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
           var $_month=$("#month1");
        for(var i=1;i<=12;i++){
          var element = document.createElement("OPTION");
  		$_month[0].add(element);
  		element.value =i;
  		element.innerText = i;
           }
           $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
       });
</script>