<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车辆台账</title>
</head>
<body>
	<div style="margin:20px 0;">
	<a href="#" class="easyui-linkbutton" onclick="collapseAll()">CollapseAll</a>
		<a href="#" class="easyui-linkbutton" onclick="expandAll()">ExpandAll</a>
	</div>
	<div class="easyui-panel" style="padding:5px">
		<ul class="easyui-tree">
			<li >
				<span>部门名称</span>
				<ul>
				<c:forEach var="item" items="${list }">
					<li>
						<span>${item.departmentName }</span>
						<ul id="xjz">
						<c:forEach var="ite" items="${listc }">
							<c:if test="${item.departmentId == ite.department.departmentId }">
							<li>
								<span>车牌号:<span style="color:blue">${ite.carnumber }</span>&nbsp;&nbsp;&nbsp;&nbsp;
									车型名称:<span style="color:blue">${ite.carType.typename }</span>&nbsp;&nbsp;&nbsp;&nbsp;
									车辆性质:<span style="color:blue">${ite.usenature }</span>
								</span>
							</li>
							</c:if>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
					
				</ul>
			</li>
		</ul>
	</div>
	<script type="text/javascript">
		function collapseAll(){
			$('#xjz').tree('collapseAll');
		}
		function expandAll(){
			$('#xjz').tree('expandAll');
		}
		
	</script>
 
</body>
</html>