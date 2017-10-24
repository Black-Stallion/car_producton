<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carYdtjRemoveList" title="车辆异动列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carYdtjRemove/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carYdtjRemove">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'newnum73',align:'center',width:100,formatter:formatCarNum73">车辆牌照</th>
        	<th data-options="field:'rbieyong2',align:'center',width:80">购入人</th>
        	<th data-options="field:'dep73',align:'center',width:110,formatter:formatDepartment73">购入部门</th>
        	<th data-options="field:'removetime',align:'center',width:120,formatter:TAOTAO.formatDate">购入日期</th>
            <th data-options="field:'removenum',align:'center',width:150">调拨文号</th>
            <th data-options="field:'rbeiyong1',align:'center',width:100">车辆性质</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carYdtjRemove" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carYdtj:add' }" >
		    <div style="float: left;">  
		       <a href="carYdtjRemove/get_down" class="easyui-linkbutton" plain="true" icon="icon-add">导出报表</a>
		    </div>  
		</c:if>
		
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carYdtjRemove_reload()">刷新</a>  
	</div>  
	<div style="float:left;">
	<div id="carYdtjRemoveFind">
		&nbsp;&nbsp;日期<select name="year" id="year2" style="width:120px;">
										<option value="0">全部</option>
								</select> &nbsp;&nbsp;&nbsp; 
								<select name="month" id="month2" style="width:120px;">
										<option value="0">全部</option>
								</select>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarYdtjRemove()">查询</a>
	</div>
	</div> 
</div>  

<script>
function submitCarYdtjRemove(){ //用户输入用户名,点击搜素,触发此函数  
	var year = document.getElementById("year2").value;
	var month = document.getElementById("month2").value;
	if(year=="0" && month!="0"){
		$.messager.alert('提示',"请先输入年份在输入月份查询！");
	}else{
		$("#carYdtjRemoveList").datagrid({
	        title:'异动车辆列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carYdtjRemove", url:'carYdtjRemove/search_carYdtjRemove?year2='+year+'&month2='+month, method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'newnum73', width : 100, align : 'center', title : '购入车辆',formatter:formatCarNum73},
	             	{field : 'rbieyong2', width : 80, align : 'center', title : '购入人'},
	             	{field : 'dep73', width : 110, align : 'center', title : '接收部门',formatter:formatDepartment73},
	             	{field : 'removetime', width : 120, align:'center', title : '购入日期',formatter:TAOTAO.formatDate},
	             	{field : 'removenum', width : 150, align : 'center', title : '调拨文号'},
	             	{field : 'rbeiyong1', width : 100, align : 'center', title : '车辆性质'}
	           ]],
	    });
	}
}
function  formatCarNum73(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment73(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};
    function getCarYdtjRemoveSelectionsIds(){
    	var carYdtjRemoveList = $("#carYdtjRemoveList");
    	var sels = carYdtjRemoveList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].removeId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    function carYdtjRemove_reload(){
    	$("#carYdtjRemoveList").datagrid("reload");
    }

    $(function(){
        var $_year=$("#year2");
        for(var i= new Date().getFullYear();i>=2007 ;i--){
          var element = document.createElement("OPTION");
  		$_year[0].add(element);
  		element.value =i;
  		element.innerText = i;
        
           }
           //为了解决查询保存状态
  		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
           var $_month=$("#month2");
        for(var i=1;i<=12;i++){
          var element = document.createElement("OPTION");
  		$_month[0].add(element);
  		element.value =i;
  		element.innerText = i;
           }
           $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
       });
</script>