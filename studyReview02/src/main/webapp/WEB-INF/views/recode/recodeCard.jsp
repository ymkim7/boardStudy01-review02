<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="/resources/css/recode/recode.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title></title>
</head>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#user_comp_enterdate").datepicker({
			showOn:"button"
			, buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
			, buttonImageOnly: true
			, dateFormat: 'yy-mm-dd'
		});
		
		$("#user_army_serv_enter").datepicker({
			showOn:"button"
			, buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
			, buttonImageOnly: true
			, dateFormat: 'yy-mm-dd'
		});
		
		$("#user_army_serv_leave").datepicker({
			showOn:"button"
			, buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
			, buttonImageOnly: true
			, dateFormat: 'yy-mm-dd'
		});
		
		$("#insertBtn").on("click", function(){
			var formObj = $("form[name='insertForm']");
			
			formObj.attr("action", "/recode/recodeCard");
			formObj.attr("method", "post");
			formObj.submit();
		});
		
		/* $("#addEduBtn").on("click", function(){
			
			var html = "";
			var eduCnt = $("#tbody tr").length;
			var edu = eduCnt + 1;
			var params = {
				"edu_school_nane" : $("#edu_school_nane").val()
				, "edu_status" : $("#edu_status").val()
				, "edu_year" : $("#edu_year").val()
				, "edu_month" : $("#edu_month").val()
			};
			
			html += "<tr id='edu_idx'>";
			html += "	<th><input type='text' id='edu_school_nane' name='edu_school_nane'/></th>";
			html += "	<th>";
			html += "		<select id='edu_status' name='edu_status'>";
			html += "			<option>선택없음</option>";
			html += "			<option value='1'>졸업</option>";
			html += "			<option value='2'>편입</option>";
			html += "			<option value='3'>수료</option>";
			html += "		</select>";
			html += "	</th>";
			html += "	<th><input type='text' id='edu_year' name='edu_year'/></th>";
			html += "	<th>";
			html += "		<input type='text' id='edu_month' name='edu_month' style='width: 80px;'/>";
			html += "		<button type='button' id='delBtn' style='margin-left: 5px;'>-</button>";
			html += "	</th>";
			html += "</tr>";
			
			$(".table02 > tbody:last").append(html);
			
			$.ajax({
				url : "/recode/recodeCard"
				, type : "post"
				, dataType : "json"
				, data : JSON.stringify(params)
				, success : function(data) {
					
				}
			});
			
			$("#delBtn").on("click", function(){
				$("#edu_idx").remove();
			});
		}); */
		
		$("#addEduBtn").on("click", function(){
			ajaxAdd();
		});
	});
	
	function ajaxAdd(){
		
		var params = {
			edu_school_nane : $("#edu_school_nane").val()
			, edu_status : $("#edu_status").val()
			, edu_year : $("#edu_year").val()
			, edu_month : $("#edu_month").val()
		};
		
		$.ajax({
			url : "/recode/recodeCard"
			, type : "post"
			, dataType : "json"
			, data : {
				edu_school_nane : edu_school_nane
				, edu_status : edu_status
				, edu_year : edu_year
				, edu_month : edu_month
			}
			, success : function(result) {
				if(result.length > 0) {
					var html = "";
					html += "<tr id='edu_idx'>";
					html += "	<th><input type='text' id='edu_school_nane' name='edu_school_nane'/></th>";
					html += "	<th>";
					html += "		<select id='edu_status' name='edu_status'>";
					html += "			<option>선택없음</option>";
					html += "			<option value='1'>졸업</option>";
					html += "			<option value='2'>편입</option>";
					html += "			<option value='3'>수료</option>";
					html += "		</select>";
					html += "	</th>";
					html += "	<th><input type='text' id='edu_year' name='edu_year'/></th>";
					html += "	<th>";
					html += "		<input type='text' id='edu_month' name='edu_month' style='width: 80px;'/>";
					html += "		<button type='button' id='delBtn' style='margin-left: 5px;'>-</button>";
					html += "	</th>";
					html += "</tr>";
				}
				$(".table02 > tbody:last").append(html);
			}
		});
	}
	
</script>
<body>
	<div class="container01">
		<header><h4>개 인 이 력 카 드</h4></header>
		
		<form name="insertForm" method="post" action="/recode/recodeCard">
			<div class="container02">
				&#8251;새 이력 작성
				<button class="float-right" type="button">출력</button>
				<button class="float-right" type="button">불러오기</button>
				<button class="float-right" type="button">새로작성</button>
				<button class="float-right" type="button">초기화</button>
				<button class="float-right" type="button" id="insertBtn" name="insertBtn">저장</button>
			</div>
		
			<table class="table01">
				<tr>
					<th>성명</th>
					<th><input type="text" id="user_name" name="user_name"/></th>
					<th>주민등록번호</th>
					<th colspan="3"><input type="text" id="user_social_secunum" name="user_social_secunum" placeholder=" ' - ' 를 제외한 숫자만 입력"/></th>
					<th>성별</th>
					<th>
						<select id="user_gender" name="user_gender">
							<option>선택없음</option>
							<option value="1">남자</option>
							<option value="2">여자</option>
						</select>
					</th>
				</tr>
				
				<tr>
					<th>소속회사</th>
					<th colspan="5"><input type="text" id="user_comp" name="user_comp"/></th>
					<th>입사일</th>
					<th><input type="text" id="user_comp_enterdate" name="user_comp_enterdate" style="width:80%"/></th>
				</tr>
				
				<tr>
					<th style="width:10%;">부서</th>
					<th style="width:10%;"><input type="text" id="user_dept" name="user_dept"/></th>
					<th style="width:10%;">직위</th>
					<th style="width:10%;"><input type="text" id="user_spot" name="user_spot"/></th>
					<th style="width:10%;">병역</th>
					<th style="width:10%;"><input type="text" id="user_army_serv" name="user_army_serv"/></th>
					<th style="width:10%;">결혼</th>
					<th style="width:10%;">
						<select id="user_marital_status" name="user_marital_status">
							<option>선택없음</option>
							<option value="1">미혼</option>
							<option value="2">기혼</option>
						</select>
					</th>
				</tr>
				
				<tr>
					<th>병역</th>
					<th colspan="2"><input type="text" id="user_army_serv_enter" name="user_army_serv_enter" style="width:80%"/></th>
					<th>~</th>
					<th colspan="2"><input type="text" id="user_army_serv_leave" name="user_army_serv_leave" style="width:80%"/></th>
					<th>역종/병과</th>
					<th><input type="text" id="user_army_serv_period" name="user_army_serv_period"/></th>
				</tr>
				
				<tr>
					<th>전화</th>
					<th colspan="3"><input type="text" id="user_telnum_wireless" name="user_telnum_wireless" placeholder="휴대전화 '-' 포함"/></th>
					<th colspan="4"><input type="text" id="user_telnum_wired" name="user_telnum_wired" placeholder="유선 '-' 포함"/></th>
				</tr>
				
				<tr>
					<th>이메일</th>
					<th colspan="8"><input type="text" id="user_email" name="user_email"/></th>
				</tr>
				
				<tr>
					<th>주소</th>
					<th colspan="3"><input type="text" id="user_address" name="user_address"/></th>
					<th>우편번호 찾기</th>
					<th colspan="3"><input type="text" id="user_zipcode" name="user_zipcode"/></th>
				</tr>
			</table>
			
			<table class="table02">
				<tr>
					<th colspan="4"><button type="button" class="addEduBtn" id="addEduBtn" name="addEduBtn">추가</button></th>
				</tr>
				
				<tr>
					<th style="width:25%;">학교명</th>
					<th style="width:25%;">상태</th>
					<th style="width:25%;">년</th>
					<th style="width:25%;">월</th>
				</tr>
				
				<tbody id="tbody">
					<tr id="edu_idx">
						<th><input type="text" id="edu_school_nane" name="edu_school_nane"/></th>
						<th>
							<select id="edu_status" name="edu_status">
								<option>선택없음</option>
								<option value="1">졸업</option>
								<option value="2">편입</option>
								<option value="3">수료</option>
							</select>
						</th>
						<th><input type="text" id="edu_year" name="edu_year"/></th>
						<th><input type="text" id="edu_month" name="edu_month"/></th>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>