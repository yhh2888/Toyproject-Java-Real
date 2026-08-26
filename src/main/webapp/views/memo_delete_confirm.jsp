<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String m_no = request.getParameter("m_no");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 삭제</title>
</head>
<body>

<h2>메모 삭제</h2>

<p>정말 삭제하시겠습니까?</p>

<form action="<%=request.getContextPath()%>/memo_delete_confirm.memo" method="post">

    <input type="hidden" name="m_no" value="<%=m_no%>">

    <input type="submit" value="삭제">
    <input type="button" value="취소"
           onclick="location.href='<%=request.getContextPath()%>/memo_list.memo'">

</form>

</body>
</html>