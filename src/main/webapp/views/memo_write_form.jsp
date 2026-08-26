<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 작성</title>
</head>
<body>

<h2>메모 작성</h2>

<form action="<%=request.getContextPath()%>/memo_write_confirm.memo" method="post">

    <p>
        제목 : <input type="text" name="m_title" required>
    </p>

    <p>
        내용 <br>
        <textarea name="m_content" rows="10" cols="50" required></textarea>
    </p>

    <input type="submit" value="작성">
    <input type="button" value="목록"
           onclick="location.href='<%=request.getContextPath()%>/memo_list.memo'">

</form>

</body>
</html>