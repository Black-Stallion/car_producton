<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript" src="js/LodopFuncs.js"></script>
	<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
	    <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop32.exe" />
	</object>
	<div>
	   <center>
			<table style="border:1px solid">
				<tr>
					<td colspan="4" style="text-align:center;border:1px">
						<h3>济南铁路局济南通信段派车单</h3>
					</td>
				</tr>
				<tr>
					<td>派车编号</td>
					<td><input type="text" value="${carSend.sendnums }" name="applyId"/>
					</td>
					<td>日期</td>
					<td><input value="<fmt:formatDate value="${carSend.sdate }" pattern="yyyy-MM-dd"/>" name="sdate"/></td>
				</tr>
				<tr>
					<td>用车单位</td>
					<td><input value="${carSend.department.departmentName }" name="departmentName"/></td>

					<td>车牌号</td>
					<td><input value="${carSend.carRegister.usenature }" name="usenature" size="6.5"/> 
						<input value="${carSend.carRegister.carnumber }" name="carnumber" size="7"/></td>
				</tr>
				<tr>
					<td>派车人</td>
					<td><input value="${carSend.senduser }" name="senduser" />
					</td>
					<td>用车人</td>
					<td><input value="${carSend.usercarpeople }" name="usercarpeople" />
					</td>
				</tr>
				<tr>
					<td>汽车驾驶员</td>
					<td><input value="${carSend.carDriver.drviername }" name="drviername" />
					</td>
					<td>第一责任人</td>
					<td><input value="${carSend.firstduty }" name="firstduty" />
					</td>
				</tr>
				<tr>
					<td>特殊情况领导审批</td>
					<td><input type="text" value="${carSend.notes }" name="notes"></input>
					</td>
					<td>安全监督岗</td>
					<td><input  type="text" value="${carSend.safe }" name="safe"></input>
					</td>
				</tr>
				<tr>
					<td>出车时间</td>
					<td><input value="<fmt:formatDate value="${carSend.senddate }" pattern="yyyy-MM-dd hh:mm:ss"/>" name="senddate"/></td>
					<td>返回时间</td>
					<td><input value="<fmt:formatDate value="${carSend.endcardate }" pattern="yyyy-MM-dd hh:mm:ss"/>" name="endcardate"/>
					</td>
				</tr>
				<tr>
					<td>行走公里</td>
					<td colspan="3">开始&nbsp;
					<input type="text" value="${carSend.firstkm }" name="firstkm" size="18.5">&nbsp;公里
					 &nbsp;&nbsp;&nbsp;&nbsp;
						结束&nbsp;
						<input type="text" value="${carSend.endkm }" name="endkm" size="18.5"/>公里
					</td>
				</tr>
				<tr>
					<td>注意事项</td>
					<td colspan="3"><textarea
							style="width:470px; height:60px;" name="note">${carSend.note }</textarea>
					</td>
				</tr>
				<tr>
					<td>任务地点及路线</td>
					<td colspan="3"><textarea 
							style="width:470px; height:100px;"
							  name="road">${carSend.road }</textarea></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align:center">
						<h3>驾驶员三检记录</h3>
					</td>
				</tr>
				<tr>
					<td>天气</td>
					<td><input type="text" value="${carSend.tianqi }" name="tianqi"></input></td>
					<td>出车前</td>
					<td><input type="text" value="${carSend.chucheq }" name="chucheq"></input></td>
				</tr>
				<tr>
					<td>行驶中</td>
					<td><input type="text" value="${carSend.xingshiz }" name="xingshiz"></input></td>
					<td>收车后</td>
					<td><input type="text" value="${carSend.shoucheh }" name="shoucheh"></input></td>
				</tr>
			</table>
</div>

