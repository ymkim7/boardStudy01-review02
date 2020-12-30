<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		//취소
		$(".cancel").on("click", function(){
			location.href = "/";
		});
		
		//회원가입
		$("#submit").on("click", function(){
			
			if($("#userPass").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#userPass").focus();
				return false;
			}
			
			if($("#userName").val() == "") {
				alert("이름을 입력해주세요.");
				$("#userName").focus();
				return false;
			}
			
			$.ajax({
				url : "/member/passChk"
				, type : "post"
				, dataType : "json"
				, data : $("#updateForm").serializeArray();
				, success : function(data) {
					if(data == true) {
						if(confirm("수정하시겠습니까?")) {
							$("#updateForm").submit();
						}
					} else {
						alert("비밀번호를 확인해주세요.");
						return;
					}
				}
			});
			
		});
	});
	
</script>
<body>
	<section id="container">
		<form method="post" action="/member/memberUpdate" id="updateForm" name="updateForm">
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId" value="${member.userId }" readonly="readonly"/>
			</div>
			
			<div class="form-group has-feedback">
				<label class="control-label" for="userPass">비밀번호</label>
				<input class="form-control" type="password" id="userPass" name="userPass"/>
			</div>
			
			<div class="form-group has-feedback">
				<label class="control-label" for="userName">이름</label>
				<input class="form-control" type="text" id="userName" name="userName" value="${member.userName }"/>
			</div>
		
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="button" id="submit" name="submit">회원정보수정</button>
				<button class="cancel btn btn-danger" type="button">취소</button>
			</div>
		</form>
	</section>
</body>
</html>