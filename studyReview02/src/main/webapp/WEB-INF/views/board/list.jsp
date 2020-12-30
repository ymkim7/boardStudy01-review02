<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
	li{
		list-style : none;
		float : left;
		padding : 6px;
	}
</style>
<title>게시판</title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#searchBtn").on("click", function(){
			self.location = "list" + '${pageMaker.makeQuery(1)}'
							+ "&searchType="
							+ $("select option:selected").val()
							+ "&keyword="
							+ encodeURIComponent($("#keywordInput").val());
							
		});
		
	});
	
</script>
<body>
	<div id="container">
		<header><h1>게시판</h1></header>
		<hr/>
		
		<div><%@include file="/WEB-INF/views/nav.jsp" %></div>
		
		<section id="container">
			<form role="form" method="get">
				<table class="table table-hover">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
					
					<c:forEach items="${list }" var="list">
						<tr>
							<td><c:out value="${list.bno }"></c:out></td>
							<td>
								<a href="/board/readView?bno=${list.bno }
										&page=${scri.page}
										&perPageNum=${scri.perPageNum}
										&searchType=${scri.searchType}
										&keyword=${scri.keyword}">
									<c:out value="${list.title }"></c:out>
								</a>
							</td>
							<td><c:out value="${list.writer }"></c:out></td>
							<td><fmt:formatDate value="${list.regdate }" pattern="yyyy-MM-dd"/></td>
							<td><c:out value="${list.hit }"></c:out> </td>
						</tr>
					</c:forEach>
				</table>
				
				<div class="search row">
					<div class="col-xs-2 col-sm-2">
						<select class="form-control" name="searchType">
							<option value="n" <c:out value="${scri.searchType == null ? 'selected' : '' }"/>>=======</option>
							<option value="t" <c:out value="${scri.searchType eq 't' ? 'selected' : '' }"/>>제목</option>
							<option value="c" <c:out value="${scri.searchType eq 'c' ? 'selected' : '' }"/>>내용</option>
							<option value="w" <c:out value="${scri.searchType eq 'w' ? 'selected' : '' }"/>>작성자</option>
							<option value="tc" <c:out value="${scri.searchType eq 'tc' ? 'selected' : '' }"/>>제목+내용</option>
						</select>
					</div>
					
					<div class="col-xs-10 col-sm-10">
						<div class="input-group">
							<input class="form-control" type="text" name="keyword" id="keywordInput" value="${scri.keyword }"/>
							<span class="input-group-btn">
								<button class="btn btn-default" type="button" id="searchBtn">검색</button>
							</span>
						</div>
					</div>
				</div>
				
				<div class="col-md-offset-3">
					<ul class="pagination">
						<c:if test="${pageMaker.prev }">
							<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">이전</a></li>
						</c:if>
						
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
							<li><a href="list${pageMaker.makeSearch(idx) }">${idx }</a></li>
						</c:forEach>
						
						<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
							<li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1) }">다음</a></li>
						</c:if>
					</ul>
				</div>
			</form>
		</section>
	</div>
</body>
</html>