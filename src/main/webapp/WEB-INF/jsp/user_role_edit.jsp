<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="userRoleEditForm" class="roleForm" method="post">
		<input id="roleId" type="hidden" name="roleId"/>
	    <span>角色名</span>
	    <input class="easyui-textbox" type="text" name="roleName" data-options="required:true"></input><br><br>
	    <span >状&nbsp态</span>
		<select class="easyui-combobox" name="available" data-options="width:150, editable:false">
			<option value="1">有效</option>
			<option value="2">锁定</option>
		</select><br><br>
        <span>功能权限</span><br><br>
        <input type="hidden" name="permission" ></input>
        	<span style="font-weight: bold;">车型管理</span>
			<label><input name="permissionOption3" type="checkbox" value="111" />车型新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="112" />车型修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="113" />车型删除 </label> 
			<br><br>
            <span style="font-weight: bold;">技术特性管理</span>
			<label><input name="permissionOption3" type="checkbox" value="121" />特性新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="122" />特性修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="123" />特性删除 </label> 
			<br><br>
            <span style="font-weight: bold;">维护要求管理</span>
			<label><input name="permissionOption3" type="checkbox" value="131" />要求新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="132" />要求修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="133" />要求删除 </label> 
			<br><br>
			<span style="font-weight: bold;">专用汽车管理</span>
			<label><input name="permissionOption3" type="checkbox" value="151" />汽车新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="152" />汽车修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="153" />汽车删除 </label> 
			<br><br>
			<span style="font-weight: bold;">公务用车管理</span>
			<label><input name="permissionOption3" type="checkbox" value="141" />汽车新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="142" />汽车修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="143" />汽车删除 </label> 
			<br><br>
			<span style="font-weight: bold;">生产用车管理</span>
			<label><input name="permissionOption3" type="checkbox" value="411" />汽车新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="412" />汽车修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="413" />汽车删除 </label> 
			<br><br>
			<span style="font-weight: bold;">随车工具管理：</span>
			<label><input name="permissionOption3" type="checkbox" value="161" />工具新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="162" />工具修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="163" />工具删除 </label>
			<br><br>
			<span style="font-weight: bold;">油卡管理</span>
			<label><input name="permissionOption3" type="checkbox" value="431" />油卡新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="432" />油卡修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="433" />油卡删除 </label>
			<label><input name="permissionOption3" type="checkbox" value="433" />油卡充值 </label>
			<br><br>
			<span style="font-weight: bold;">用油管理</span>
			<label><input name="permissionOption3" type="checkbox" value="441" />用油新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="442" />用油修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="443" />用油删除 </label>
			<br><br>
			<span style="font-weight: bold;">用油申请管理</span>
			<label><input name="permissionOption3" type="checkbox" value="461" />新增申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="462" />修改申请</label> 
			<label><input name="permissionOption3" type="checkbox" value="463" />删除申请</label>
			<br><br>
			<span style="font-weight: bold;">用油审批管理</span>
			<label><input name="permissionOption3" type="checkbox" value="466" />用油审批 </label> 
			<br><br>
			<span style="font-weight: bold;">用车申请管理</span>
			<label><input name="permissionOption3" type="checkbox" value="181" />新增申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="182" />修改申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="183" />删除申请 </label>
			<br><br>
			<span style="font-weight: bold;">用车审批管理</span>
			<label><input name="permissionOption3" type="checkbox" value="192" />用车审批 </label> 
			<br><br>
			<span style="font-weight: bold;">派车单管理</span>
			<label><input name="permissionOption3" type="checkbox" value="231" />新增派车单</label> 
			<label><input name="permissionOption3" type="checkbox" value="232" />修改派车单 </label> 
			<label><input name="permissionOption3" type="checkbox" value="233" />删除派车单 </label> 
			<br><br>
			<span style="font-weight: bold;">购入管理</span>
			<label><input name="permissionOption3" type="checkbox" value="241" />新增购入</label> 
			<label><input name="permissionOption3" type="checkbox" value="242" />修改购入 </label> 
			<label><input name="permissionOption3" type="checkbox" value="243" />删除购入 </label> 
			<br><br>
			<span style="font-weight: bold;">调入管理</span>
			<label><input name="permissionOption3" type="checkbox" value="261" />新增调入</label> 
			<label><input name="permissionOption3" type="checkbox" value="262" />修改调入 </label> 
			<label><input name="permissionOption3" type="checkbox" value="263" />删除调入 </label> 
			<br><br>
			<span style="font-weight: bold;">调出管理</span>
			<label><input name="permissionOption3" type="checkbox" value="271" />新增调出</label> 
			<label><input name="permissionOption3" type="checkbox" value="272" />修改调出 </label> 
			<label><input name="permissionOption3" type="checkbox" value="273" />删除调出 </label> 
			<br><br>
			<span style="font-weight: bold;">段内调配管理</span>
			<label><input name="permissionOption3" type="checkbox" value="21" />新增调配</label> 
			<label><input name="permissionOption3" type="checkbox" value="22" />修改调配 </label> 
			<label><input name="permissionOption3" type="checkbox" value="23" />删除调配 </label> 
			<br><br>
			<span style="font-weight: bold;">报废管理</span>
			<label><input name="permissionOption3" type="checkbox" value="266" />新增报废单</label> 
			<label><input name="permissionOption3" type="checkbox" value="267" />修改报废单 </label> 
			<label><input name="permissionOption3" type="checkbox" value="268" />删除报废单 </label> 
			<br><br>
			<span style="font-weight: bold;">司机调配管理</span>
			<label><input name="permissionOption3" type="checkbox" value="471" />新增调配单</label> 
			<label><input name="permissionOption3" type="checkbox" value="472" />修改调配单 </label> 
			<label><input name="permissionOption3" type="checkbox" value="473" />删除调配单 </label> 
			<br><br>
			<span style="font-weight: bold;">保养管理</span>
			<label><input name="permissionOption3" type="checkbox" value="291" />新增保养单</label> 
			<label><input name="permissionOption3" type="checkbox" value="292" />修改保养单 </label> 
			<label><input name="permissionOption3" type="checkbox" value="293" />删除保养单 </label> 
			<br><br>
			<span style="font-weight: bold;">维修申请管理</span>
			<label><input name="permissionOption3" type="checkbox" value="301" />新增申请</label> 
			<label><input name="permissionOption3" type="checkbox" value="302" />修改申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="303" />删除申请 </label> 
			<br><br>
			<span style="font-weight: bold;">维修审批管理</span>
			<label><input name="permissionOption3" type="checkbox" value="311" />维修审批</label> 
			<br><br>
			<span style="font-weight: bold;">轮胎使用管理</span>
			<label><input name="permissionOption3" type="checkbox" value="331" />新增使用单</label> 
			<label><input name="permissionOption3" type="checkbox" value="332" />修改使用单 </label> 
			<label><input name="permissionOption3" type="checkbox" value="333" />删除使用单 </label> 
			<br><br>
			<span style="font-weight: bold;">车辆运用记录管理</span>
			<label><input name="permissionOption3" type="checkbox" value="341" />新增记录单</label> 
			<label><input name="permissionOption3" type="checkbox" value="342" />修改记录单 </label> 
			<label><input name="permissionOption3" type="checkbox" value="343" />删除记录单 </label> 
			<br><br>
			<span style="font-weight: bold;">车辆月检记录管理</span>
			<label><input name="permissionOption3" type="checkbox" value="351" />新增记录单</label> 
			<label><input name="permissionOption3" type="checkbox" value="352" />修改记录单</label> 
			<label><input name="permissionOption3" type="checkbox" value="353" />删除记录单</label> 
			<br><br>
			<span style="font-weight: bold;">所换大件管理</span>
			<label><input name="permissionOption3" type="checkbox" value="321" />新增大件记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="322" />修改大件记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="323" />删除大件记录 </label> 
			<br><br>
			<span style="font-weight: bold;">司机管理</span>
			<label><input name="permissionOption3" type="checkbox" value="221" />新增司机</label> 
			<label><input name="permissionOption3" type="checkbox" value="222" />修改司机</label> 
			<label><input name="permissionOption3" type="checkbox" value="223" />删除司机 </label> 
			<label><input name="permissionOption3" type="checkbox" value="224" />导入司机 </label>
			<br><br>
			<span style="font-weight: bold;">安全学习管理</span>
			<label><input name="permissionOption3" type="checkbox" value="361" />新增学习记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="362" />修改学习记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="363" />删除学习记录 </label> 
			<br><br>
			<span style="font-weight: bold;">安全行驶管理</span>
			<label><input name="permissionOption3" type="checkbox" value="371" />新增行驶记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="372" />修改行驶记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="373" />删除行驶记录 </label> 
			<br><br>
			<span style="font-weight: bold;">月度考核管理</span>
			<label><input name="permissionOption3" type="checkbox" value="381" />新增考核记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="382" />修改考核记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="383" />删除考核记录 </label> 
			<br><br>
			<span style="font-weight: bold;">交通事故管理</span>
			<label><input name="permissionOption3" type="checkbox" value="391" />新增事故记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="392" />修改事故记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="393" />删除事故记录 </label> 
			<br><br>
			<span style="font-weight: bold;">违章记录管理</span>
			<label><input name="permissionOption3" type="checkbox" value="401" />新增违章记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="402" />修改违章记录</label> 
			<label><input name="permissionOption3" type="checkbox" value="403" />删除违章记录 </label> 
			<br><br>
			<span style="font-weight: bold;">报表统计管理</span>
			<label><input name="permissionOption3" type="checkbox" value="421" />车辆报表</label> 
			<label><input name="permissionOption3" type="checkbox" value="423" />异动报表</label> 
			<label><input name="permissionOption3" type="checkbox" value="425" />打印报表 </label>
			<br><br>
			<span style="font-weight: bold;">文件管理</span>
			<label><input name="permissionOption3" type="checkbox" value="451" />添加文件</label> 
			<label><input name="permissionOption3" type="checkbox" value="452" />修改文件</label> 
			<label><input name="permissionOption3" type="checkbox" value="453" />删除文件 </label>
			<label><input name="permissionOption3" type="checkbox" value="543" />局发权限 </label>
			<label><input name="permissionOption3" type="checkbox" value="542" />段发权限 </label>
			<label><input name="permissionOption3" type="checkbox" value="544" />车间发权限 </label>
			<br><br>
			<span style="font-weight: bold;">保养单位管理</span>
			<label><input name="permissionOption3" type="checkbox" value="482" />添加保养单位</label> 
			<label><input name="permissionOption3" type="checkbox" value="483" />删除保养单位 </label>
			<br><br>
			<span style="font-weight: bold;">注意事项管理</span>
			<label><input name="permissionOption3" type="checkbox" value="486" />添加注意事项</label> 
			<label><input name="permissionOption3" type="checkbox" value="487" />删除注意事项</label>
			<br><br>
			<span style="font-weight: bold;">车间管理</span>
			<label><input name="permissionOption3" type="checkbox" value="41" />车间新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="42" />车间修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="43" />车间删除 </label> 
			<br><br>
			<span style="font-weight: bold;">用户管理</span>
			<label><input name="permissionOption3" type="checkbox" value="201" />用户新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="202" />用户修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="203" />用户删除 </label> 
			<br><br>
			<span style="font-weight: bold;">角色管理</span>
			<label><input name="permissionOption3" type="checkbox" value="211" />角色新增 </label> 
			<label><input name="permissionOption3" type="checkbox" value="212" />角色修改 </label> 
			<label><input name="permissionOption3" type="checkbox" value="213" />角色删除 </label> 
			<br><br><br>
			<span >菜单权限</span><br><br>
			<span style="font-weight: bold;">基本菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="30" />基本信息管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="144" />公务用车管理 </label>
			<label><input name="permissionOption3" type="checkbox" value="145" />生产用车管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="146" />专用车管理 </label>
			<label><input name="permissionOption3" type="checkbox" value="147" />随车工具管理 </label>
			<br><br>
			<label><input name="permissionOption3" type="checkbox" value="31" />车型管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="114" />车型 </label> 
			<label><input name="permissionOption3" type="checkbox" value="124" />技术特性 </label>  
			<label><input name="permissionOption3" type="checkbox" value="134" />维护要求 </label>  
			<br><br>
			<span style="font-weight: bold;">油卡菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="32" />油卡管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="500" />油卡及累计用油</label> 
			<label><input name="permissionOption3" type="checkbox" value="501" />用油记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="502" />用油申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="503" />用油审批 </label> 
			<br><br>
			<span style="font-weight: bold;">异动菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="33" />车辆异动管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="504" />购入记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="505" />调入记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="506" />调出记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="507" />段内调配记录 </label>
			<br><br>
			<label><input name="permissionOption3" type="checkbox" value="508" />报废记录 </label>
			<label><input name="permissionOption3" type="checkbox" value="509" />主车司机变动 </label> 
			<br><br>
			<span style="font-weight: bold;">用车菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="34" />用车管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="510" />用车申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="511" />用车审批 </label> 
			<label><input name="permissionOption3" type="checkbox" value="512" />派车单 </label> 
			<br><br>
			<span style="font-weight: bold;">维保菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="35" />车辆维保管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="513" />保养 </label> 
			<label><input name="permissionOption3" type="checkbox" value="514" />维修申请 </label> 
			<label><input name="permissionOption3" type="checkbox" value="515" />维修审批 </label>
			<label><input name="permissionOption3" type="checkbox" value="516" />轮胎使用 </label> 
			<br><br>
			<span style="font-weight: bold;">运行菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="36" />车辆运行管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="517" />运用记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="518" />月检记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="519" />所换大件记录 </label>
			<br><br>
			<span style="font-weight: bold;">司机菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="37" />驾驶员管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="520" />司机管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="521" />安全学习记录 </label> 
			<label><input name="permissionOption3" type="checkbox" value="522" />安全行驶里程记录 </label>
			<label><input name="permissionOption3" type="checkbox" value="523" />月度考核表 </label> 
			<br><br>
			<span style="font-weight: bold;">安全菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="38" />安全管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="524" />交通事故管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="525" />违章记录管理 </label> 
			<br><br>
			<span style="font-weight: bold;">报表菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="39" />报表管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="526" />车辆统计报表 </label> 
			<label><input name="permissionOption3" type="checkbox" value="527" />车辆维护统计报表 </label> 
			<label><input name="permissionOption3" type="checkbox" value="528" />车辆调入统计报表 </label> 
			<br><br>
			<label><input name="permissionOption3" type="checkbox" value="529" />车辆调出统计报表 </label> 
			<label><input name="permissionOption3" type="checkbox" value="530" />车辆段内调配统计报表 </label> 
			<label><input name="permissionOption3" type="checkbox" value="531" />车辆购入统计报表 </label> 
			<br><br>
			<span style="font-weight: bold;">文件菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="50" />公共文件管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="532" />资料文件 </label> 
			<br><br>
			<span style="font-weight: bold;">提醒菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="51" />系统提醒 </label> 
			<label><input name="permissionOption3" type="checkbox" value="533" />车辆保养提醒 </label> 
			<label><input name="permissionOption3" type="checkbox" value="534" />车辆年检提醒 </label> 
			<label><input name="permissionOption3" type="checkbox" value="535" />车辆保险提醒 </label> 
			<br><br>
			<span style="font-weight: bold;">字典菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="52" />数据字典管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="536" />车辆保养单位 </label> 
			<label><input name="permissionOption3" type="checkbox" value="537" />派出注意事项</label> 
			<br><br>
			<span style="font-weight: bold;">系统菜单信息</span>
			<label><input name="permissionOption3" type="checkbox" value="54" />系统管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="538" />部门管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="539" />用户管理 </label> 
			<label><input name="permissionOption3" type="checkbox" value="540" />角色管理</label> 
			<br><br><br>
	</form>
	<br><br>
	
</div>
<script type="text/javascript">
	function userPermissionInit(){
		var roleId = $('#userRoleEditForm [name=roleId]').val();
		$.get("permission/get_permission", {roleId : roleId}, function(data){
			//获得所要回显的值，此处为","分割的字符串
	        var checkeds = data.sysPermissionId;
	        if(checkeds != '' && checkeds != null){
		        //拆分为字符串数组
		        checkArray =checkeds.split(",");
		    	//获得所有的复选框对象
			    var checkBoxAll = $("input[name='permissionOption3']");
			    //获得所有复选框的value值，然后，用checkArray中的值和他们比较，如果有，则说明该复选框被选中
			    for(var i=0;i<checkArray.length-1;i++){
				    //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
				    $.each(checkBoxAll,function(j,checkbox){
					    //获取复选框的value属性
					    var checkValue=$(checkbox).val();
					    
					    if(checkArray[i]==checkValue){
					    	/* alert("checkArray[i] = "+checkArray[i])
						    alert("checkValue = "+checkValue) */
					    	$(checkbox).prop("checked",true);
					    }
				    });
			   	}
	        }
		}); 
	}
	
	function submitRoleEditForm(){
		if(!$('#userRoleEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
	
		if($("input[name='permissionOption3']:checked").length>0){
			var permission = '';
			$("input[name='permissionOption3']:checked").each(function(){
				permission += $(this).val()+',';
			}); 
			$("#userRoleEditForm [name=permission]").val(permission);
		}
		$.post("role/update_all",$("#userRoleEditForm").serialize(), function(data){
			if(data.label == 200){
				$.messager.alert('提示', data.msg);
				$("#userRoleWindow").window('close');
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
</script>
