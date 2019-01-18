<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${user.id}    <!-- 입력된 id가 세션에 저장됨. user.getid()의 의미임. 컨트롤러에서 model.addAttrubute 해주지 않아도됨 -->
</body>
</html>