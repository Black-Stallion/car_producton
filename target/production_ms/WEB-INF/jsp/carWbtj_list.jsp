<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="carWbtjList" title="车辆调入列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'carWbtj/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_carWbtj">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'carnum53',align:'center',width:100,formatter:formatCarNum53">保养车辆</th>
        	<th data-options="field:'intervalkm',align:'center',width:100">当前里程(/公里)</th>
        	<th data-options="field:'dep',align:'center',width:100,formatter:formatDepartment">所在部门</th>
        	<th data-options="field:'startdate',align:'center',width:80,formatter:TAOTAO.formatDate">开始日期</th>
        	<th data-options="field:'enddate',align:'center',width:80,formatter:TAOTAO.formatDate">截止日期</th>
            <th data-options="field:'repairtype',align:'center',width:200">保养级别或保养项目</th>
            <th data-options="field:'suppliername',align:'center',width:80">厂家名称</th>
           <th data-options="field:'beiyong2',align:'center',width:80">车辆性质</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_carWbtj" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='carWbtj:add' }" >
		    <div style="float: left;">  
		        <a href="carWbtj/get_down" class="easyui-linkbutton" plain="true" icon="icon-add">导出报表</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="carWbtj_reload()">刷新</a>  
	</div> 
	<div style="float:left;">
	<div id="carWbtjFind">
		&nbsp;&nbsp;日期<select name="year" id="year6" style="width:70px;">
										<option value="0">全部</option>
								</select> &nbsp; 
								<select name="month" id="month6" style="width:70px;">
										<option value="0">全部</option>
								</select>&nbsp;&nbsp;
								车牌号<input type="text" name="cnumber" id="cnumber" size="10" value="0"></input>
	</select>
	 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarWbtjFind()">查询</a>
	</div>
	</div>
</div>  
<script>
function submitCarWbtjFind(){
	var year = document.getElementById("year6").value;
	var month = document.getElementById("month6").value;
	var cnumber = document.getElementById("cnumber").value;
	if(year=="0" && month!="0"){
		$.messager.alert('提示',"请先输入年份在输入月份查询！");
	}else{
		$("#carWbtjList").datagrid({
	        title:'车辆调入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_carWbtj", url:'carWbtj/search_carWbtj?year6='+year+'&month6='+month+'&cnumber='+cnumber, method:'get', loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'carnum53', width : 100, align : 'center', title : '保养车辆',formatter:formatCarNum53},
	             	{field : 'intervalkm', width : 100, align : 'center', title : '当前里程(/公里)'},
	             	{field : 'dep', width : 100, align : 'center', title : '所在部门',formatter:formatDepartment},
	             	{field : 'startdate', width : 80, align : 'center', title : '开始日期',formatter:TAOTAO.formatDate},
	             	{field : 'enddate', width : 80, align:'center', title : '截止日期',formatter:TAOTAO.formatDate},
	             	{field : 'repairtype', width : 200, align : 'center', title : '保养级别或保养项目'},
	             	{field : 'suppliername', width : 80, align : 'center', title : '厂家名称'}
	        ] ],  
	    });
	}
}
function  formatCarNum53(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.carRegister.carnumber+"";
	}
};
function  formatDepartment(value, row, index){ 
	if(value ==null && value == ''){
		return '无';}
	else{
		return ""+row.department.departmentName+"";
	}
};

    function getCarWbtjSelectionsIds(){
    	var carWbtjList = $("#carWbtjList");
    	var sels = carWbtjList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].keepId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    


    function carWbtj_reload(){
    	$("#carWbtjList").datagrid("reload");
    }
    $(function(){
        var $_year=$("#year6");
        for(var i= new Date().getFullYear();i>=2007 ;i--){
          var element = document.createElement("OPTION");
  		$_year[0].add(element);
  		element.value =i;
  		element.innerText = i;
        
           }
           //为了解决查询保存状态
  		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
           var $_month=$("#month6");
        for(var i=1;i<=12;i++){
          var element = document.createElement("OPTION");
  		$_month[0].add(element);
  		element.value =i;
  		element.innerText = i;
           }
           $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
       });
</script>