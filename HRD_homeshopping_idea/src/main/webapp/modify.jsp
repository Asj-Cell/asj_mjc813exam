<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mjc813.hrd.DTO.MemberDto" %>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<MemberDto>list = new ArrayList<MemberDto>();
list = (ArrayList<MemberDto>)request.getAttribute("list");
		
int custno = list.get(0).getCustno();
String custname = list.get(0).getCustname();
String phone = list.get(0).getPhone();
String address = list.get(0).getAddress();
String joindate = list.get(0).getJoindate();
String grade = list.get(0).getGrade();
String city = list.get(0).getCity();

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
홈쇼핑 회원 정보 수정
</div>
<form name="frm" action="update" method="post">
<input type="hidden" id="GUBUN" value="update" >
<div class="wrapper">
<table>
	<tr>
		<th>회원번호(자동발생)</th>
		<!-- 10번 라인의 custno 변수값을 출력 -->
		<td><input name="custno" value="<%=custno %>" readonly value="1"></td>
	</tr>
	<tr>
		<th>회원성명 (최대 5자)</th>
		<!-- 11번 라인의 custname 변수값을 출력 -->
		<td><input type="text" name="custname" value="<%=custname%>" maxlength="5"></td>
	</tr>
	<tr>
		<th>회원전화 (010-XXXX-XXXX)</th>
		<!-- 12번 라인의 phone 변수값을 출력 -->
		<td><input type="text" name="phone" value="<%=phone%>" maxlength="13"></td>
	</tr>
	<tr>
		<th>회원주소 (최대 20자)</th>
		<!-- 13번 라인의 address 변수값을 출력 -->
		<td><input type="text" name="address" value="<%=address%>" maxlength="20"></td>
	</tr>
	<tr>
		<th>가입일자 (YYYY-MM-DD)</th>
		<!-- 14번 라인의 joindate 변수값을 출력 -->
		<td><input type="text" name="joindate" value="<%=joindate%>" maxlength="10"></td>
	</tr>
	<tr>
		<th>고객등급 [A:VIP, B:일반, C:직원] (최대 1자)</th>
		<!-- 15번 라인의 grade 변수값을 출력 -->
		<td><input type="text" name="grade" value="<%=grade%>" maxlength="1"></td>
	</tr>
	<tr>
		<th>도시코드 [01:서울, 30:울릉, 60:제주] (최대 2자)</th>
		<!-- 16번 라인의 city 변수값을 출력 -->
		<td><input type="text" name="city" value="<%=city%>" maxlength="2"></td>
	</tr>
	<tr>
		<td colspan="2">
		<button class="btn" type="submit" onclick="fn_submit(); return false;">수 정</button>
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