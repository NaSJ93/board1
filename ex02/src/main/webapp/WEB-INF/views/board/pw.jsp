<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <form action="/board/remove" method="post">
 비밀번호<br>
 <input type="password" id="pw"> 
 <input type="submit" value="확인" id="test">
 </form>
 
 
 <script>
 $("#test").onclick(function({
	 var p1=document.getElementById("pw").value;
	 if(p1.equals("1234")){
		return true; 
	 }else
		 alert("비밀번호를 확인하시오");
	 	return false;
 }));
 </script>