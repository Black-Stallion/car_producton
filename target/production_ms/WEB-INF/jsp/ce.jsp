<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="css/skin/jedate.css"  media="all">
    <script type="text/javascript" src="js/modules/jeui.js"></script>
    <script type="text/javascript" src="js/userdata.js"></script>

</head>
<body>
<table>
<tr>
					<td bgcolor="#F0F8FF" align="right">出车时间:</td>
					<td><input type="text" name="senddate" id="inpstart" readonly></td>
					<td bgcolor="#F0F8FF" align="right">返回时间:</td>
					<td><input type="text" name="endcardate" id="inpend" readonly></td>
				</tr>
</table>
</body>

</html>   <script type="text/javascript">
  jeui.use(["jquery","jeDate"],function(){
	    var start = {
	        format: 'YYYY-MM-DD hh:mm:ss',
	        minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
	        isinitVal:true,
	        //festival:true,
	        ishmsVal:false,
	        choosefun: function(elem, val, date){
	            end.minDate = date; //开始日选好后，重置结束日的最小日期
	            endDates();
	        }
	    };
	    var end = {
	        format: 'YYYY-MM-DD hh:mm:ss',
	        minDate: $.nowDate({DD:0}), //设定最小日期为当前日期
	        //festival:true,
	 		isinitVal:true,
	        //festival:true,
	        ishmsVal:false,
	        maxDate: '2099-06-16 23:59:59', //最大日期
	        choosefun: function(elem, val, date){
	            start.maxDate = date; //将结束日的初始值设定为开始日的最大日期
	        }
	    };
	    //这里是日期联动的关键        
	    function endDates() {
	        //将结束日期的事件改成 false 即可
	        end.trigger = false;
	        $("#inpend").jeDate(end);
	    }
	    $('#inpstart').jeDate(start);
	    $('#inpend').jeDate(end);    
	});
</script>