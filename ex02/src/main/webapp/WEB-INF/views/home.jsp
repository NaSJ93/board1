<%@ pagepageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="board/list">이동</a><br>
1.게시글 목록 숫자 변경 기능<br>
2.총 게시물 수<br>
3.페이지 이동 기능 추가(처음, 마지막)<br>
</body>
</html>