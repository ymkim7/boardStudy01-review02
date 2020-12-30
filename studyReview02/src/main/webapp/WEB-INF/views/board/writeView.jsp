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
		
		fn_addFile();
		
		var formObj = $("form[name='writeForm']");
		
		$(".write_btn").on("click", function(){
			
			if(fn_valiChk()) {
				return false;
			}
			
			formObj.attr("action", "/board/write");
			formObj.attr("method", "post");
			formObj.submit();
			
		});
		
	});
	
	function fn_valiChk() {
		
		var regForm = $("form[name='writeForm'] .chk").length;
		
		for(var i = 0; i < regForm; i++) {
			if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null) {
				alert($(".chk").eq(i).attr("title"));
				return true;
			}
		}
		
	}
	
	function fn_addFile() {
		var fileIndex = 1;
		$(".fileAdd_btn").on("click", function(){
			$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
		});
		
		$(document).on("click","#fileDelBtn", function(){
			$(this).parent().remove();
		});
	}
	
</script>
<body>
	<div id="root">
		<header><h1>게시판</h1></header>
		<hr/>
		
		<div><%@include file="/WEB-INF/views/nav.jsp" %></div>
		
		<section id="container">
			<form name="writeForm" method="post" action="/board/write" enctype="multipart/form-data">
				<table>
					<tbody>
						<c:if test="${member.userId != null }">
							<tr>
								<td>
									<label for="title">제목</label>
									<input type="text" class="chk" id="title" name="title" title="제목을 입력해주세요."/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="content">내용</label>
									<textarea class="chk" id="content" name="content" title="내용을 입력해주세요."></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label>
									<input class="chk" type="text" id="writer" name="writer" title="작성자를 입력해주세요."/>
								</td>
							</tr>
							<tr>
								<td id="fileIndex"></td>
							</tr>
							<tr>
								<td>
									<button class="write_btn" type="button">작성</button>
									<button class="fileAdd_btn" type="button">파일추가</button>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${member.userId == null }">
							<p>로그인 후에 이용해주세요.</p>
						</c:if>
					</tbody>
				</table>
			</form>
		</section>
	</div>
</body>
</html>