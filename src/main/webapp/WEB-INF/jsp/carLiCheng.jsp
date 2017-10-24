<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/echarts.min.js" type="text/javascript"></script>
<script src="js/echarts.js" type="text/javascript"></script>
</head>
<body>
<div class="easyui-tabs" style="width:100%;height:100%;">
<div title="部门司机里程分析" style="width: 600px;height:640px;">
<div  id="toolbar_carli2" style=" height: 22px; padding: 3px 11px; background: #fafafa;">    
			<div style="float:left;">
			<div id="carli2Find">
				&nbsp;&nbsp;日期<select name="year" id="yearl2" style="width:120px;">
								</select> 
								<c:if test="${leve==2 }">
								部门名称<input class="easyui-combobox" id="departmenCom12" panelHeight="200" size="15px" />
	            					<input id="depart122" type="hidden" value="${departmentId }"/>
	            					<input id="depart132" type="hidden" />
								</c:if>
					<c:choose>
						<c:when test="${leve==2 }">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarLi2()">查询</a>
						</c:when>
						<c:otherwise>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarLi12()">查询</a>
						</c:otherwise>
					</c:choose>		
			 	
			</div>
			</div> 
		</div>
	<div id="li2"  style="width: 900px;height:600px;">
	
	</div>
</div>
<div title="部门车辆里程分析" style="width: 600px;height:640px;">
	<div  id="toolbar_carli" style=" height: 22px; padding: 3px 11px; background: #fafafa;">    
			<div style="float:left;">
			<div id="carliFind">
				&nbsp;&nbsp;日期<select name="year" id="yearl" style="width:120px;">
								</select> 
								<c:if test="${leve==2 }">
								部门名称<input class="easyui-combobox" id="departmenCom1" panelHeight="200" size="15px" />
	            					<input id="depart12" type="hidden" value="${departmentId }"/>
	            					<input id="depart13" type="hidden" />
								</c:if>
					<c:choose>
						<c:when test="${leve==2 }">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarLi()">查询</a>
						</c:when>
						<c:otherwise>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitCarLi1()">查询</a>
						</c:otherwise>
					</c:choose>		
			 	
			</div>
			</div> 
		</div>
	<div id="li1"  style="width: 900px;height:600px;">
	
	</div>
</div>
</div>
<script type="text/javascript">
$(function(){
    var $_year=$("#yearl");
    for(var i= new Date().getFullYear();i>=2016 ;i--){
      var element = document.createElement("OPTION");
		$_year[0].add(element);
		element.value =i;
		element.innerText = i;
    
       }
   });
$('#departmenCom1').combobox({  
    url: "department/get_data_first",  
    editable:false,  
    valueField:'departmentId',   
    textField:'departmentName',  
   // panelHeight:'auto',  
    onSelect : function(data){  
        $('#depart12').val(data.departmentId); 
        $('#depart13').val(data.departmentName); 
    }  
});
$(function(){
    var $_year=$("#yearl2");
    for(var i= new Date().getFullYear();i>=2016 ;i--){
      var element = document.createElement("OPTION");
		$_year[0].add(element);
		element.value =i;
		element.innerText = i;
    
       }
   });
$('#departmenCom12').combobox({  
    url: "department/get_data_first",  
    editable:false,  
    valueField:'departmentId',   
    textField:'departmentName',  
   // panelHeight:'auto',  
    onSelect : function(data){  
        $('#depart122').val(data.departmentId); 
        $('#depart132').val(data.departmentName); 
    }  
});
var dali = genli();
var dali2 = genli2();
function genli() {
	 var Chart1=echarts.init(document.getElementById("li1"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 var date=new Date;
	 var year=date.getFullYear(); 
	 optionli = {
			    title: {
			        text: year+'年，济南通信段本部门车辆里程分析',
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
			    	            name:''+year+'年已跑里程(/km)',
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
		 		
	        	url:"carTongji/carCarnums?year="+year,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].carnumber);
	        		value.push(data[i].kkk1);
	        	});
	            Chart1.hideLoading();
	        		optionli.xAxis[0]['data']=label;
	            	optionli.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optionli);  
	        	}
	        	});
			}
function submitCarLi(){
	var year = document.getElementById("yearl").value;
	var departmentId = document.getElementById("depart12").value;
	var departmentName = document.getElementById("depart13").value;
	 var Chart1=echarts.init(document.getElementById("li1"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 optionli = {
			    title: {
			        text: year+'年，济南通信段  '+departmentName+' 车辆里程分析',
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
			    	            name:''+year+'年已跑里程(/km)',
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
		 		
	        	url:"carTongji/carCarnums2?year="+year+"&departmentId="+departmentId,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].carnumber);
	        		value.push(data[i].kkk1);
	        	});
	            Chart1.hideLoading();
	        		optionli.xAxis[0]['data']=label;
	            	optionli.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optionli);  
	        	}
	        	});
}
function submitCarLi1(){
	var year = document.getElementById("yearl").value;
	 var Chart1=echarts.init(document.getElementById("li1"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 optionli = {
			    title: {
			        text: year+'年，济南通信段本部门车辆里程分析',
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
			    	            name:''+year+'年已跑里程(/km)',
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
		 		
	        	url:"carTongji/carCarnums3?year="+year,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].carnumber);
	        		value.push(data[i].kkk1);
	        	});
	            Chart1.hideLoading();
	        		optionli.xAxis[0]['data']=label;
	            	optionli.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optionli);  
	        	}
	        	});
}
function genli2() {
	 var Chart1=echarts.init(document.getElementById("li2"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 var date=new Date;
	 var year=date.getFullYear(); 
	 optionli2 = {
			    title: {
			        text: year+'年，济南通信段本部门司机里程分析',
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
			    	            name:''+year+'年累积里程(/km)',
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
		 		
	        	url:"carTongji/carDrivernums?year="+year,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        		label.push(data[i].drviername);
	        		value.push(data[i].kkk1);
	        	});
	            Chart1.hideLoading();
	        		optionli2.xAxis[0]['data']=label;
	            	optionli2.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optionli2);  
	        	}
	        	});
			}
function submitCarLi2(){
	var year = document.getElementById("yearl2").value;
	var departmentId = document.getElementById("depart122").value;
	var departmentName = document.getElementById("depart132").value;
	 var Chart1=echarts.init(document.getElementById("li2"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 optionli2 = {
			    title: {
			        text: year+'年，济南通信段  '+departmentName+' 车辆里程分析',
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
			    	            name:''+year+'年已跑里程(/km)',
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
		 		
	        	url:"carTongji/carDrivernums2?year="+year+"&departmentId="+departmentId,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        		label.push(data[i].drviername);
	        		value.push(data[i].kkk1);
	        	});
	            Chart1.hideLoading();
	        		optionli2.xAxis[0]['data']=label;
	            	optionli2.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optionli2);  
	        	}
	        	});
}
function submitCarLi12(){
	var year = document.getElementById("yearl2").value;
	 var Chart1=echarts.init(document.getElementById("li2"));
	 Chart1.showLoading({text: '正在努力的读取数据中...'  });
	 optionli2 = {
			    title: {
			        text: year+'年，济南通信段本部门司机里程分析',
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
			    	            name:''+year+'年已跑里程(/km)',
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
		 		
	        	url:"carTongji/carDrivernums3?year="+year,
	        	dataType:"json",
	        	success:function(data){
	        	$.each(data,function(i){
	        	label.push(data[i].drviername);
	        		value.push(data[i].kkk1);
	        	});
	            Chart1.hideLoading();
	        		optionli2.xAxis[0]['data']=label;
	            	optionli2.series[0]['data']=value;
	            	//optionPie.series[0]['radius']=[0,100];
	        	Chart1.setOption(optionli2);  
	        	}
	        	});
}
   </script>
</body>
</html>