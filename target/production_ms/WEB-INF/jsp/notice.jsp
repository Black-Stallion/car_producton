<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div>
<table class="easyui-datagrid" id="workList" title="公告信息" 
       data-options="singleSelect:false,collapsible:true,rownumbers:true,url:'work/list',
       	method:'get',pageSize:10, fitColumns:true,toolbar:toolbar_work1">
    <thead>
        <tr>
        	<th data-options="field:'workId',width:370">类型</th>
        	<th data-options="field:'workId',width:230">标题</th>
        </tr>
    </thead>
</table>
<div  id="toolbar_work1" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="work_reload()">刷新</a>  
	</div>  
</div> 
</div> 


