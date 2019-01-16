<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<%-- 컨트롤러에서 전달한 데이터를 받기위해 ${컨트롤러에서 전달한 이름}을 사용한다. --%>
<P>  The time on the server is ${serverTime}. </P>
<!-- jsp에서 컨트롤러로 데이터를 전달하려면 form태그를 이용 -->
<form method="post" action="<%=request.getContextPath() %>/">   
<!-- 액션에 따로 주소를 지정해 주지 않으면 브라우저 주소창에 입력해준 /?name=홍길동 이 들어감. 유관순을 입력하고 제출하주면
jsp에서 넘어온 값: 홍길동,유관순 이 콘솔창에 뜸. 그러므로 따로 경로를 지정해줘야함. 프로젝트에 따라 경로가 바뀌므로 경로를
위와 같이 request.getContextPath() 지정해줌. 그러면 제출한 유관순 하나만 뜨게됨. 
  -->
	<!-- 전달하려는 데이터가 있는 태그의 속성name을 입력한다. -->
	<input type="text" name="name">
	<button>제출</button>
</form>
</body>
</html>
