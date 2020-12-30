<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Home</title>
</head>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#logoutBnt").on("click", function(){
			location.href = "/member/logout";
		});
		
		$("#registerBtn").on("click", function(){
			
			location.href = "member/register";
			
		});
		
		$("#memberUpdateBtn").on("click", function(){
			location.href = "member/memberUpdateView";
		});
		
		$("#memberDeleteBtn").on("click", function(){
			location.href = "member/memberDeleteView";
		});
		
	});

</script>
<body>
	<form name="homeForm" method="post" action="/member/login">
		<c:if test="${member == null }">
			<div>
				<label for="userId">아이디</label>
				<input type="text" id="uesrId" name="userId"/>
			</div>
			
			<div>
				<label for="userPass">비밀번호</label>
				<input type="password" id="userPass" name="userPass"/>
			</div>
			
			<div>
				<button type="submit">로그인</button>
				<button type="button" id="registerBtn" name="registerBtn">회원가입</button>
			</div>
		</c:if>
		
		<c:if test="${member != null }">
			<div><%@include file="/WEB-INF/views/nav.jsp" %></div>
			
			<div>
				<p>${member.userId }님 환영합니다.</p>
				<button type="button" id="memberUpdateBtn" name="memberUpdateBtn">회원정보수정</button>
				<button type="button" id="memberDeleteBtn" name="memberDeleteBtn">회원탈퇴</button>
				<button type="button" id="logoutBnt" name="logoutBnt">로그아웃</button>
			</div>
		</c:if>
		
		<c:if test="${msg == false }">
			<div>
				<p>아이디와 비밀번호를 확인해주세요.</p>
			</div>
		</c:if>
	</form>
</body>
</html>
