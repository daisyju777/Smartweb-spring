<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%-- jsp에서는 컨트롤러에서 보낸 값을 ${}표현함. serverTime1 이라고 하면 컨트롤러에서 지정해준 이름이 아니기 때문에  아무것도 뜨지않음--%>
<form action="<%=request.getContextPath() %>/" method="get">
	<input type="text" name="id">
	<button type="submit">확인</button>  <!-- 따로 지정안하면 폼태그 안 버튼의 타입은 submit임 -->
</form>
<a href="<%= request.getContextPath() %>/signup">회원가입</a>
<script>
	var signup=${signup};
	if(signup==true) alert ("회원가입에 성공했습니다.");
</script>
</body>
</html>
