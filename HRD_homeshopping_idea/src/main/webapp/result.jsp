<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mjc813.hrd.DTO.MoneyDto" %>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<MoneyDto>list = new ArrayList<MoneyDto>();
list = (ArrayList<MoneyDto>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<%@ include file="topmenu.jsp" %>
<section>
<div class="title">
회원매출조회
</div>
<div class="wrapper">
<table>
<tr>
	<th>회원번호</th>
	<th>회원성명</th>
	<th>고객등급</th>
	<th>매출</th>
</tr>
<%
// 8번 라인의 list 배열 객체를 for 반복 문으로 출력함
for(int i=0; i<list.size(); i++){
%>
<tr>
	<td><%=list.get(i).getCustno() %></td>
	<td><%=list.get(i).getCustname() %></td>
	<td><%=list.get(i).getGrade() %></td>
	<td><%=list.get(i).getPrice() %></td>
</tr>
<%}%>
</table>
</div>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>