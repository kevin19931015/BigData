<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.kevin.cn/myfn" prefix="mf" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>编辑客户信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
    <h1>编辑客户信息</h1>
    
    <form action="${pageContext.request.contextPath}/servlet/updatecustomer" method="post">
    <input type="hidden" name="id" value="${c.id}"/>
    <table width="88%" border="1">
    <tr>
    <td>姓名</td>
    <td>
    <input type="text" name="name" value="${c.name}${formbean.name}"/>
    </td>
    </tr>
    <tr>
    <td>性别</td>
    <td><input type="radio" name="gender" value="1" ${c.gender=="1"?"checked='checked'":""}${formbean.gender=="1"?"checked='checked'":""}/>男
    	<input type="radio" name="gender" value="0" ${c.gender=="0"?"checked='checked'":""}${formbean.gender=="0"?"checked='checked'":""}/>女
    </td>
    </tr>
    <tr>
    <td>生日(yyyy-MM-dd)</td>
    <td>
    <input type="text" name="birthday" value="${c.birthday}${formbean.birthday}"/>${formbean.errors.birthday}
    </td>
    </tr>
    <tr>
    <td>电话</td>
    <td>
    <input type="text" name="phoneNumber" value="${c.phoneNumber}${formbean.phoneNumber}"></input>
    </td>
    </tr>
    <tr>
    <td>邮箱</td>
    <td>
    <input type="text" name="email" value="${c.email}${formbean.email}"></input>
    </td>
    </tr>
    <tr>
    <td>爱好</td>
    <td>
    <input type="checkbox" name="hobbies" value="吃饭" ${fn:contains(c.hobby,'吃饭')?'checked="checked"':''}${mf:contains(formbean.hobbies,'吃饭')?'checked="checked"':''}/>吃饭
    <input type="checkbox" name="hobbies" value="睡觉" ${fn:contains(c.hobby,'睡觉')?'checked="checked"':''}${mf:contains(formbean.hobbies,'睡觉')?'checked="checked"':''}/>睡觉
    <input type="checkbox" name="hobbies" value="篮球" ${fn:contains(c.hobby,'篮球')?'checked="checked"':''}${mf:contains(formbean.hobbies,'篮球')?'checked="checked"':''}/>篮球
    </td>
    </tr>
    <tr>
    <td>类型</td>
    <td><input type="radio" name="type" value="普通客户" ${c.type=="普通客户"?"checked='checked'":""}${formbean.type=="普通客户"?"checked='checked'":""}/>普通客户
    	<input type="radio" name="type" value="VIP" ${c.type=="VIP"?"checked='checked'":""}${formbean.type=="VIP"?"checked='checked'":""}/>VIP
    </td>
    </tr>
    <tr>
    <td>描述</td>
    <td>
    <textarea rows="3" cols="48" name="description">${c.description }${formbean.description }</textarea>
    </td>
    </tr>
    <tr>
    <td colspan="2" align="center">
    <input type="submit" value="保存"/>
    </td>
    </tr>
    </table>
    </form>
  </body>
</html>
