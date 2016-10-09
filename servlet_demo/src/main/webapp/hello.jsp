<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>

	hello,${msg } ${param.a } 文件上传：
	<form action="/jstl/upload" method="post" enctype="multipart/form-data">
		<input type="text" name="month" /> <input type="text" name="day" /> <input
			type="file" name="file" />
		<button type="submit">提交</button>

	</form>

	<c:if test="${param.a > '100' }">
		参数a的值是100
	</c:if>

	<table>
		<c:forEach items="${names }" var="i">
			<tr>
				<td>name:</td>
				<td>${i }</td>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="load()">获取学生信息</button>
	<table id="table">
		
	</table>

	<h1>
		现在时间
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" />
	</h1>
<script type="text/javascript" src="/webjars/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
$.ajax({
    type: "GET",
    url: "/jstl/stu",
    dataType: "json",
    success: function(data){
               console.log(data)
    }
});

//等价于
function load(){
	$.get('/jstl/stu',{
	},function(data){
		for(var i in data){
		 	$('#table').append(
		 			$('<tr>').append(
		 						$('<td>').text(data[i].name)
		 					).append(
		 						$('<td>').text(data[i].age)
		 					)
		 		)
		}
	  }
	,'json')
}
</script>
</body>
</html>