<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/echarts.min.js" type="text/javascript"></script>
<script src="js/echarts.js" type="text/javascript"></script>
</head>
<body>
<div class="easyui-tabs" style="width:100%;height:100%;">
<div title="油卡预分配额度分析" style="width: 600px;height:640px;">
	<div  id="toolbar_caryou1" style=" height: 22px; padding: 3px 11px; background: #fafafa;">    
			<div style="float:left;">
			<div id="caryou1Find">
				&nbsp;&nbsp;日期<select name="year" id="yeary1" style="width:120px;">
										</select> 
			 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCaryou1()">查询</a>
			</div>
			</div> 
		</div>
	<div id="you"  style="width: 900px;height:600px;">
	
	</div>
</div>

<div title="部门油卡充值月分配分析"  style="width: 900px;height:640px;">
	<div  id="toolbar_caryou" style=" height: 22px; padding: 3px 11px; background: #fafafa;">    
		<div style="float:left;">
		<div id="caryouFind">
			&nbsp;&nbsp;日期<select name="year" id="yeary" style="width:120px;">
									</select> &nbsp;&nbsp;&nbsp; 
									<select name="month" id="monthy" style="width:120px;">
									</select>
		 	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCaryou()">查询</a>
		</div>
		</div> 
	</div>
<div id="you2"  style="width: 900px;height:600px;">

</div>
</div>
</div>
<script type="text/javascript">

$(function(){
    var $_year=$("#yeary");
    for(var i= new Date().getFullYear();i>=2016 ;i--){
      var element = document.createElement("OPTION");
		$_year[0].add(element);
		element.value =i;
		element.innerText = i;
    
       }
       //为了解决查询保存状态
		$_year.val(<%=request.getParameter("year") == null? "0": request.getParameter("year")%>);
       var $_month=$("#monthy");
    for(var i=1;i<=12;i++){
      var element = document.createElement("OPTION");
		$_month[0].add(element);
		element.value =i;
		element.innerText = i;
       }
       $_month.val(<%=request.getParameter("month") == null? "0": request.getParameter("month")%>);
   });
$(function(){
    var $_year=$("#yeary1");
    for(var i= new Date().getFullYear();i>=2016 ;i--){
      var element = document.createElement("OPTION");
		$_year[0].add(element);
		element.value =i;
		element.innerText = i;
    
       }
   });
var you = genyou();
var you1 = genyou1();
function submitCaryou(){
	
	var year = document.getElementById("yeary").value;
	var month = document.getElementById("monthy").value;
	 var Chart1=echarts.init(document.getElementById("you2"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 optiony = {
			    title: {
			        text: year+'年'+month+'月，济南通信段部门油卡充值金额分析',
			        subtext: '',
			        left: 'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        top: 'middle',
			        bottom: 10,
			        left: 'right',
			        data:[],
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            dataView : {show: true, readOnly: false},
			            //magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    series : [
			        {	name:'部门油卡充值金额(/元):',
			            type: 'pie',
			            radius : '65%',
			            center: ['45%', '50%'],
			            selectedMode: 'single',
			            data:[ ],
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			        }
			    ]
			};
	 var label=[];
	 var value=[];
	 $.ajax({
		 		
	        	url:"carTongji/carMoneynums?year="+year+"&month="+month,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].depatmentname);
	        	value.push({'name':data[i].depatmentname,'value':data[i].money1});
	        	});
	            Chart1.hideLoading();
	            debugger;
	        		optiony.legend.data=label;
	            	optiony.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optiony);  
	        	}
	        	});
}
function genyou() {
	 var Chart1=echarts.init(document.getElementById("you2"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 var date=new Date;
	 var year=date.getFullYear(); 
	 var month=date.getMonth()+1;
	 optiony = {
			    title: {
			        text: year+'年'+month+'月，济南通信段部门油卡充值金额分析',
			        subtext: '',
			        left: 'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        top: 'middle',
			        bottom: 10,
			        left: 'right',
			        data:[],
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            dataView : {show: true, readOnly: false},
			            //magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    series : [
			        {	name:'部门油卡充值金额(/元):',
			            type: 'pie',
			            radius : '65%',
			            center: ['45%', '50%'],
			            selectedMode: 'single',
			            data:[ ],
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			        }
			    ]
			};
	 var label=[];
	 var value=[];
	 $.ajax({
		 		
	        	url:"carTongji/carMoneynums?year="+year+"&month="+month,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].depatmentname);
	        	value.push({'name':data[i].depatmentname,'value':data[i].money1});
	        	});
	            Chart1.hideLoading();
	        		optiony.legend.data=label;
	            	optiony.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optiony);  
	        	}
	        	});
			}
function submitCaryou1(){
	var year = document.getElementById("yeary1").value;
	 var Chart1=echarts.init(document.getElementById("you"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 optiony1 = {
			    title: {
			        text: year+'年，济南通信段每月油卡预分配额度分析',
			        subtext: '',
			        left: 'center'
			    },
			     tooltip : {
			    	        trigger: 'axis'
			    	    },
			    	    toolbox: {
			    	        show : true,
			    	        feature : {
			    	            dataView : {show: true, readOnly: false},
			    	            magicType : {show: true, type: ['line', 'bar']},
			    	            restore : {show: true},
			    	            saveAsImage : {show: true}
			    	        }
			    	    },
			    	    calculable : true,
			    	    xAxis : [
			    	        {
			    	            type : 'category',
			    	            data : []
			    	        }
			    	    ],
			    	    yAxis : [
			    	        {
			    	            type : 'value'
			    	        }
			    	    ],
			    	    series : [
			    	        {
			    	            name:'预分配额度(/元)',
			    	            type:'bar',
			    	            data:[],
			    	            markPoint : {
			    	                data : [
			    	                    {type : 'max', name: '最大值'},
			    	                    {type : 'min', name: '最小值'}
			    	                ]
			    	            },
			    	            markLine : {
			    	                data : [
			    	                    {type : 'average', name: '平均值'}
			    	                ]
			    	            }
			    	        },
			    	    ]
			    	};

	 var label=[];
	 var value=[];
	 $.ajax({
		 		
	        	url:"carTongji/carFXnums?year="+year,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].month1+"月");
	        		value.push(data[i].money1);
	        	});
	            Chart1.hideLoading();
	        		optiony1.xAxis[0]['data']=label;
	            	optiony1.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optiony1);  
	        	}
	        	});
}
function genyou1() {
	 var Chart1=echarts.init(document.getElementById("you"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 var date=new Date;
	 var year=date.getFullYear(); 
	 optiony1 = {
			    title: {
			        text: year+'年，济南通信段每月油卡预分配额度分析',
			        subtext: '',
			        left: 'center'
			    },
			     tooltip : {
			    	        trigger: 'axis'
			    	    },
			    	    toolbox: {
			    	        show : true,
			    	        feature : {
			    	            dataView : {show: true, readOnly: false},
			    	            magicType : {show: true, type: ['line', 'bar']},
			    	            restore : {show: true},
			    	            saveAsImage : {show: true}
			    	        }
			    	    },
			    	    calculable : true,
			    	    xAxis : [
			    	        {
			    	            type : 'category',
			    	            data : []
			    	        }
			    	    ],
			    	    yAxis : [
			    	        {
			    	            type : 'value'
			    	        }
			    	    ],
			    	    series : [
			    	        {
			    	            name:'预分配额度(/元)',
			    	            type:'bar',
			    	            data:[],
			    	            markPoint : {
			    	                data : [
			    	                    {type : 'max', name: '最大值'},
			    	                    {type : 'min', name: '最小值'}
			    	                ]
			    	            },
			    	            markLine : {
			    	                data : [
			    	                    {type : 'average', name: '平均值'}
			    	                ]
			    	            }
			    	        },
			    	    ]
			    	};
	var label=[];
	 var value=[];
	 $.ajax({
		 		
	        	url:"carTongji/carFXnums?year="+year,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].month1+"月");
	        		value.push(data[i].money1);
	        	});
	            Chart1.hideLoading();
	        		optiony1.xAxis[0]['data']=label;
	            	optiony1.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optiony1);  
	        	}
	        	});
			}

</script>
</body>
</html>