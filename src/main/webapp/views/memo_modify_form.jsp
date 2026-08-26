<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.office.toypjt.memo.MemoDto" %>

<%
    MemoDto memoDto = (MemoDto)request.getAttribute("memoDto");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 수정</title>
</head>
<body>

<h2>메모 수정</h2>

<form action="<%=request.getContextPath()%>/memo_modify_confirm.memo" method="post">

    <input type="hidden" name="memoNo" value="<%=memoDto.getMemoNo()%>">

    <p>
        제목<br>
        <input type="text" name="memoName"
               value="<%=memoDto.getMemoName()%>" size="50" required>
    </p>

    <p>
        내용<br>
        <textarea name="memoContent" rows="10" cols="60" required><%=memoDto.getMemoContent()%></textarea>
    </p>

    <p>
        작성자 : <b><%=memoDto.getMemoWriterId()%></b>
    </p>

    <input type="submit" value="수정 완료">

    <input type="button" value="취소"
        onclick="location.href='<%=request.getContextPath()%>/memo_list.memo'">

</form>

</body>
</html>