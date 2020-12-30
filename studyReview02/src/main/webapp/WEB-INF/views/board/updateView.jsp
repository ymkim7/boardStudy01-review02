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
		
		$(document).on("click","#fileDel", function(){
			$(this).parent().remove();
		});
		
		var formObj = $("form[name='updateForm']");
		
		$(".update_btn").on("click", function(){
			
			if(fn_valiChk()) {
				return false;
			}
			
			formObj.attr("action", "/board/update");
			formObj.attr("method", "post");
			formObj.submit();
			
		});
		
		$(".cancel_btn").on("click", function(){
			
			location.href = "/board/readView?bno=${update.bno}"
							+"&page=${scri.page}"
							+"&perPageNum=${scri.perPageNum}"
							+"&searchType=${scri.searchType}"
							+"&keyword=${scri.keyword}";
			
		});
		
	});
	
	function fn_valiChk() {
		
		var regForm = $("form[name='updateForm'] .chk").length;
		
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
	
	function fn_del(value, name) {
		var fileNoArray = new Array();
		var fileNameArray = new Array();
		
		fileNoArray.push(value);
		fileNameArray.push(name);
		
		$("#fileNoDel").attr("value", fileNoArray);
		$("#fileNameDel").attr("value", fileNameArray);
	}
	
</script>
<body>
	<div id="root">
		<header><h1>게시판</h1></header>
		<hr/>
		
		<div><%@include file="/WEB-INF/views/nav.jsp" %></div>
		
		<section id="container">
			<form name="updateForm" method="post" action="/board/update" enctype="multipart/form-data">
				<input type="hidden" name="bno" value="${update.bno }" readonly="readonly"/>
				<input type="hidden" id="page" name="page" value="${scri.page }"/>
				<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum }"/>
				<input type="hidden" id="searchType" name="searchType" value="${scri.searchType }"/>
				<input type="hidden" id="keyword" name="keyword" value="${scri.keyword }"/>
				<input type="hidden" id="fileNoDel" name="fileNoDel[]" value=""/>
				<input type="hidden" id="fileNameDel" name="fileNameDel[]" value=""/>
				
				<table>
					<tbody>
						<tr>
							<td>
								<label for="bno">글 번호</label>
								<input class="chk" type="text" id="bno" name="bno" value="${update.bno }" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="title">제목</label>
								<input class="chk" type="text" id="title" name="title" value="${update.title }" title="제목을 입력해주세요."/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="content">내용</label>
								<textarea class="chk" id="content" name="content" title="내용을 입력해주세요.">
									<c:out value="${update.content }"></c:out>
								</textarea>
							</td>
						</tr>
						<tr>
							<td>
								<label for="writer">작성자</label>
								<input class="chk" type="text" id="writer" name="writer" value="${update.writer }" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="regdate">작성날짜</label>
								<fmt:formatDate value="${update.regdate }" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<td id="fileIndex">
								<c:forEach items="${file }" var="file" varStatus="var">
									<div>
										<input type="hidden" id="FILE_NO" name="FILE_NO_${var.index }" value="${file.FILE_NO }"/>
										<input type="hidden" id="FILE_NAME" name="FILE_NAME_${var.index }"/>
										<a href="#" id="fileName" onclick="return false;">${file.ORG_FILE_NAME}</a>(${file.FILE_SIZE}kb)
										<button id="fileDel" onclick="fn_del('${file.FILE_NO}','FILE_NO_${var.index}');" type="button">삭제</button>
										<br/>
									</div>
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
				
				<div>
					<button type="button" class="update_btn">저장</button>
					<button type="button" class="cancel_btn">취소</button>
					<button type="button" class="fileAdd_btn">파일추가</button>
				</div>
			</form>
		</section>
		<hr/>
	</div>
</body>
</html>