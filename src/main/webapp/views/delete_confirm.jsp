<%@ page import="com.office.toypjt.member.MemberConfig" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>

<h2>회원 탈퇴</h2>

<p>정말 탈퇴하시겠습니까?</p>

<form action="<%=request.getContextPath().concat(MemberConfig.MEMBER_DELETE_CONFIRM)%>" method="post">
    <input type="submit" value="탈퇴">
    <input type="button" value="취소"
           onclick="location.href='<%=request.getContextPath()%>/'">
</form>

</body>
</html>