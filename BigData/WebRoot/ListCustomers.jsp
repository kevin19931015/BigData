<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String patd = request.getContextPath();
	String basePatd = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ patd + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePatd%>">

<title>客户信息列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="tdis is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<h1>客户信息列表</h1>
	<form id="f1" action="${pageContext.request.contextPath}/servlet/DelMultiCustomer" method="post">
	<table width="88%" border="0">
		<tr>
			<td><a href="${pageContext.request.contextPath}/AddCustomer.jsp">添加</a>&nbsp;&nbsp;
				<a href="javascript:delMulti()">删除</a>
			</td>
		</tr>
		<tr>
			<td>
			<c:if test="${empty page.records}">
			对不起，没有客户信息。
			</c:if>
			<c:if test="${!empty page.records}">
			<table border="1" width="100%">
			<tr>
			<th>选择</th>
			<th>姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>电话</th>
			<th>邮箱</th>
			<th>爱好</th>
			<th>类型</th>
			<th>描述</th>
			<th>操作</th>
			</tr>
			<c:forEach items="${page.records}" var="c" varStatus="vs">
			<tr bgcolor="${vs.index%2==0?'#C9C9C9':'#6192B0'}">
			<td><input type="checkbox" name="ids" value="${c.id}"></input></td>
			<td>${c.name}</td>
			<td>${c.gender==1?"男":"女"}</td>
			<td>${c.birthday}</td>
			<td>${c.phoneNumber}</td>
			<td>${c.email}</td>
			<td>${c.hobby}</td>
			<td>${c.type}</td>
			<td>${c.description}</td>
			<td>
				<a href="${pageContext.request.contextPath}/servlet/updatecustomerui?customerId=${c.id}">修改</a>
				<a href="javascript:delOne('${c.id}')">删除</a>
			</td>
			</tr>
			</c:forEach>
			</table>
			</c:if>
			</td>
		</tr>
		<tr align="center">
			<td>
			第${page.pageIndex}页/共${page.pageCount}页
			<a href="${pageContext.request.contextPath}/servlet/showallcustomer?pagenum=1">首页</a>
			<a href="${pageContext.request.contextPath}/servlet/showallcustomer?pagenum=${page.pageIndex-1==0?1:page.pageIndex-1}">上一页</a>
			<a href="${pageContext.request.contextPath}/servlet/showallcustomer?pagenum=${page.pageIndex+1>page.pageCount?page.pageCount:page.pageIndex+1}">下一页</a>
			<a href="${pageContext.request.contextPath}/servlet/showallcustomer?pagenum=${page.pageCount}">尾页</a>
			<select id="s1">
			<c:forEach begin="1" end="${page.pageCount}" var="num">
			<option value="${num}" ${page.pageIndex==num?'selected="selected"':'' }>${num}</option>
			</c:forEach>
			</select>
			<a href="javascript:jump()">跳转</a>
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript">
	function jump(){
		var num = document.getElementById("s1").value;
		window.location.href="${pageContext.request.contextPath}/servlet/showallcustomer?pagenum="+num;
		
	}
	function delOne(customerId){
		var sure = window.confirm("确定要删除吗？");
		if(sure){
			window.location.href="${pageContext.request.contextPath}/servlet/deleteonecustomer?customerId="+customerId;
		}
	}
	function delMulti(){
		var idsObj = document.getElementsByName("ids");//数组
		//alert(idsObj.length);
		var selected = false;//是否选择了
		for(var i=0;i<idsObj.length;i++){
			if(idsObj[i].checked){
				selected=true;
				break;
			}	
		}
		if(selected){
				//选择了
			var sure = window.confirm("确定要删除吗？");
			if(sure){
				document.getElementById("f1").submit();//提交表单
			}
		}else{
			alert("请先选择要删除的记录");
		}
	}
	</script>
</body>
</html>
