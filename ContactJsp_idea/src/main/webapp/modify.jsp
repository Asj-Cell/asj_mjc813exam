<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mjc813.contactjsp.DTO.ContactDto" %>
<%
request.setCharacterEncoding("UTF-8");
// ArrayList<ContactDto>list = new ArrayList<ContactDto>(); // 이 줄은 필요 없음
// list = (ArrayList<ContactDto>)request.getAttribute("list"); // 이 줄도 필요 없음

// 'contact'라는 이름으로 저장된 ContactDto 객체를 가져옵니다.
ContactDto contact = (ContactDto)request.getAttribute("contact");

// 만약 contact 객체가 null일 경우를 대비하여 방어 코드 추가 (예외 처리)
if (contact == null) {
    // 에러 메시지를 표시하거나 리스트 페이지로 리다이렉트하는 등의 처리를 할 수 있습니다.
    response.sendRedirect("list"); // 예시: 목록 페이지로 리다이렉트
    return; // JSP 페이지의 더 이상 실행을 막습니다.
}

// 이제 contact 객체에서 직접 값을 가져옵니다.
int id = contact.getId();
String name = contact.getName();
String phoneNumber = contact.getPhoneNumber();
String zipNumber = contact.getZipNumber();
String email = contact.getEmail();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 정보 수정</title> <%-- 타이틀 명확화 --%>
<script src="script.js"></script>
<link rel="stylesheet" href="style.css?ver=1">
</head>
<body>
<%@ include file="topmenu.jsp" %>
<section>
<div class="title">
연락처 정보 수정
</div>
<%-- form action을 현재 Context Root 기준으로 /update로 변경 --%>
<form name="frm" action="<%= request.getContextPath() %>/update" method="post">
<%-- GUBUN hidden 필드는 사용하지 않는다면 제거하는 것이 좋습니다. --%>
<%-- <input type="hidden" id="GUBUN" value="update" > --%>
<div class="wrapper">
<table>
    <tr>
       <th>ID (자동발생)</th>
       <%-- readonly 속성만으로 충분하며, value="1"은 삭제 --%>
       <td><input name="id" value="<%=id %>" readonly></td>
    </tr>
    <tr>
       <th>연락처성명 (최대 5자)</th>
       <td><input type="text" name="name" value="<%=name%>" maxlength="5"></td>
    </tr>
    <tr>
       <th>연락처전화 (010-XXXX-XXXX)</th>
       <td><input type="text" name="phoneNumber" value="<%=phoneNumber%>" maxlength="13"></td>
    </tr>
    <tr>
       <th>우편번호 (최대 5자)</th>
       <td><input type="text" name="zipNumber" value="<%=zipNumber%>" maxlength="5"></td>
    </tr>
    <tr>
       <th>이메일주소</th>
       <td><input type="text" name="email" value="<%=email%>" maxlength="100"></td>
    </tr>
    <tr>
       <td colspan="2">
       <%-- onclick 이벤트에서 form을 직접 submit하고 false를 리턴하여 기본 제출 방지 --%>
       <button class="btn" type="submit" onclick="document.frm.submit(); return false;">수 정</button>
       <%-- location='list' 대신 /list로 변경하여 컨텍스트 루트 문제 해결 --%>
       <button class="btn" type="button" onclick="location='<%= request.getContextPath() %>/list'">조 회</button>
       </td>
    </tr>
</table>
</div>
</form>
</section>
<%@ include file="footer.jsp" %>
</body>
</html>