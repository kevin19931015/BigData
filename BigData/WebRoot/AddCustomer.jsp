<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.kevin.cn/myfn" prefix="mf" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加用户</title>
    
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
    <h1>添加用户</h1>
    
    <form action="${pageContext.request.contextPath}/servlet/addcustomer" method="post">
    <table width="88%" border="1">
    <tr>
    <td>姓名</td>
    <td>
    <input type="text" name="name" value="${formbean.name}"/>
    </td>
    </tr>
    <tr>
    <td>性别</td>
    <td><input type="radio" name="gender" value="1" ${formbean.gender=="1"?"checked='checked'":""}/>男
    	<input type="radio" name="gender" value="0" ${formbean.gender=="0"?"checked='checked'":""}/>女
    </td>
    </tr>
    <tr>
    <td>生日(yyyy-MM-dd)</td>
    <td>
    <input type="text" name="birthday" value="${formbean.birthday}"/>${formbean.errors.birthday}
    </td>
    </tr>
    <tr>
    <td>电话</td>
    <td>
    <input type="text" name="phoneNumber" value="${formbean.phoneNumber}"></input>
    </td>
    </tr>
    <tr>
    <td>邮箱</td>
    <td>
    <input type="text" name="email" value="${formbean.email}"></input>
    </td>
    </tr>
    <tr>
    <td>爱好</td>
    <td>
    <input type="checkbox" name="hobbies" value="吃饭" ${mf:contains(formbean.hobbies,'吃饭')?'checked="checked"':''}/>吃饭
    <input type="checkbox" name="hobbies" value="睡觉" ${mf:contains(formbean.hobbies,'睡觉')?'checked="checked"':''}/>睡觉
    <input type="checkbox" name="hobbies" value="篮球" ${mf:contains(formbean.hobbies,'篮球')?'checked="checked"':''}/>篮球
    </td>
    </tr>
    <tr>
    <td>类型</td>
    <td><input type="radio" name="type" value="普通客户" ${formbean.type=="普通客户"?"checked='checked'":""}/>普通客户
    	<input type="radio" name="type" value="VIP" ${formbean.type=="VIP"?"checked='checked'":""}/>VIP
    </td>
    </tr>
    <tr>
    <td>描述</td>
    <td>
    <textarea rows="3" cols="48" name="description">${formbean.description }</textarea>
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
