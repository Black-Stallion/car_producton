<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/echarts.min.js" type="text/javascript"></script>
<script src="js/echarts.js" type="text/javascript"></script>
<title>222</title>
</head>
<body>
<div class="easyui-tabs" style="width:100%;height:100%;">
<div title="部门机动车分析" id="cjj" style="width: 900px;height:600px;"></div>
<div title="机动车使用性质分析" id="cjj2" style="width: 600px;height:540px;"></div>
<div title="机动车车型分析" id="cjj1" style="width: 900px;height:600px;"></div>
<div title="机动车调动分析" id="cjj3" style="width: 900px;height:540px;"></div>

</div>
<script type="text/javascript">
	var data = genData();
	var data1 = genData1();
	var data2 = genData2();
	var data3 = genData3();
function genData() {
			 var Chart=echarts.init(document.getElementById("cjj"));
			 Chart.showLoading({text: '正在努力的读取数据中...'  });
			 option = {
					    title: {
					        text: '济南通信段部门机动车统计分析',
					        subtext: '',
					        left: 'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					    	 type: 'scroll',
					        orient: 'vertical',
					        top: 'middle',
					        bottom: 10,
					        left: 'right',
					        data:[ ],
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            dataView : {show: true, readOnly: false},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    series : [
					        {	
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
				 		
			        	url:"carTongji/cardepnums",
			        	dataType:"json",
			        	success:function(data){
			        	$.each(data,function(i){
			        	label.push(data[i].department.departmentName);
			        	value.push({'name':data[i].department.departmentName,'value':data[i].depcarnums});
			        	});
			            Chart.hideLoading();
			        		option.legend.data=label;
			            	option.series[0]['data']=value;
			            	//optionPie.series[0]['radius']=[0,100];
			        	Chart.setOption(option);  
			        	}
			        	});
}
function genData1() {
	 var Chart=echarts.init(document.getElementById("cjj1"));
	 Chart.showLoading({text: '正在努力的读取数据中...'  });
	 option1 = {
			    title: {
			        text: '济南通信段机动车车型统计分析',
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
			        data:[ ],
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
			        {	
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
	 var label1=[];
	 var value1=[];
	 $.ajax({
		 		
	        	url:"carTongji/carTypenums",
	        	dataType:"json",
	        	success:function(data1){
	        	$.each(data1,function(i){
	        	label1.push(data1[i].carType.typename);
	        	value1.push({'name':data1[i].carType.typename,'value':data1[i].depcarnums});
	        	});
	            Chart.hideLoading();
	        		option1.legend.data=label1;
	            	option1.series[0]['data']=value1;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart.setOption(option1);  
	        	}
	        	});
}	    
function genData2() {
	 var Chart=echarts.init(document.getElementById("cjj2"));
	 Chart.showLoading({text: '正在努力的读取数据中...'  });
	 option2 = {
			  title: {
			        text: '济南通信段机动车使用性质分析',
			        subtext: '',
			        left: 'center'
			    },
			  color: ['#3398DB'],
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
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
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data :[],
			            axisTick: {
			                alignWithLabel: true
			            }
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'机动车数量（辆）',
			            type:'bar',
			            barWidth: '60%',
			            data:[]
			        }
			    ]
			};
	 var label2=[];
	 var value2=[];
	 $.ajax({
		 		
	        	url:"carTongji/carUsenaturenums",
	        	dataType:"json",
	        	success:function(data2){
	        	$.each(data2,function(i){
	        	label2.push(data2[i].usenature);
	        	value2.push(data2[i].depcarnums);
	        	});
	            Chart.hideLoading();
	        		option2.xAxis[0]['data']=label2;
	            	option2.series[0]['data']=value2;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart.setOption(option2);  
	        	}
	        	});
}	    
function genData3() {
	 var Chart1=echarts.init(document.getElementById("cjj3"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 option3 = {
			  title: {
			        text: '济南通信段机动车调动分析',
			        subtext: '',
			        left: 'center'
			    },
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
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
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data :[],
			            axisTick: {
			                alignWithLabel: true
			            }
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'调动次数',
			            type:'bar',
			            barWidth: '60%',
			            data:[]
			        }
			    ]
			};
	 var label=[];
	 var value=[];
	 $.ajax({
		 		
	        	url:"carTongji/carYidongnums",
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].stats);
	        	value.push({'name':data[i].stats,'value':data[i].yidongnums});
	        	});
	            Chart1.hideLoading();
	        		option3.xAxis[0]['data']=label;
	            	option3.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(option3);  
	        	}
	        	});    
}
</script>
</body>
</html>