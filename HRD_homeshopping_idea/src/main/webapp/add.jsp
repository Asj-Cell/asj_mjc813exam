<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mjc813.hrd.DTO.MemberDto" %>
<%
request.setCharacterEncoding("UTF-8");
int custno = 0;
custno = (Integer)request.getAttribute("custno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="script.js"></script>
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<%@ include file="topmenu.jsp" %>
<section>
<div class="title">
홈쇼핑 회원 등록
</div>
<form name="frm" action="insert" method="post">
<input type="hidden" id="GUBUN" value="insert" >
<div class="wrapper">
<table>
	<tr>
		<th>회원번호(자동발생)</th>
		<td><input name="custno" value="<%=custno %>" readonly value="1"></td>
	</tr>
	<tr>
		<th>회원성명 (최대 5자)</th>
		<td><input type="text" name="custname" maxlength="5"></td>
	</tr>
	<tr>
		<th>회원전화 (010-XXXX-XXXX)</th>
		<td><input type="text" name="phone" maxlength="13"></td>
	</tr>
	<tr>
		<th>회원주소 (최대 20자)</th>
		<td><input type="text" name="address" maxlength="20"></td>
	</tr>
	<tr>
		<th>가입일자 (YYYY-MM-DD)</th>
		<td><input type="text" name="joindate" maxlength="10"></td>
	</tr>
	<tr>
		<th>고객등급 [A:VIP, B:일반, C:직원] (최대 1자)</th>
		<td><input type="text" name="grade" maxlength="1"></td>
	</tr>
	<tr>
		<th>도시코드 [01:서울, 30:울릉, 60:제주] (최대 2자)</th>
		<td><input type="text" name="city" maxlength="2"></td>
	</tr>
	<tr>
		<td colspan="2">
		<button class="btn" type="submit" onclick="fn_submit(); return false;">등 록</button>
		<button class="btn" type="button" onclick="location='list'">조 회</button>
		</td>
	</tr>
</table>
</div>
</form>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>