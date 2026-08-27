<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.office.toypjt.memo.MemoDto" %>

<%
    List<MemoDto> memoDtos = (List<MemoDto>) request.getAttribute("memoDtos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 목록</title>

<style>
table{
    border-collapse: collapse;
    width: 800px;
}
th, td{
    border:1px solid #000;
    padding:8px;
    text-align:center;
}
a{
    text-decoration:none;
    margin:0 5px;
}
</style>

</head>
<body>

<h2>메모 목록</h2>

<p>
    <button onclick="location.href='<%=request.getContextPath()%>/memo_write_form.memo'">
        메모 작성
    </button>

    <button onclick="location.href='<%=request.getContextPath()%>/logout.mem'">
        로그아웃
    </button>
</p>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>수정일</th>
        <th>관리</th>
    </tr>

<%
if(memoDtos != null && !memoDtos.isEmpty()){
    for(MemoDto memo : memoDtos){
%>

    <tr>
        <td><%=memo.getMemoNo()%></td>
        <td><%=memo.getMemoName()%></td>
        <td><%=memo.getMemoContent()%></td>
        <td><%=memo.getMemoWriterId()%></td>
        <td><%=memo.getMemoWriteDate()%></td>
        <td><%=memo.getMemoLastModify()%></td>

        <td>
            <a href="<%=request.getContextPath()%>/memo_modify_form.memo?memoNo=<%=memo.getMemoNo()%>">
                수정
            </a>

            |

            <a href="<%=request.getContextPath()%>/memo_delete_confirm.memo?memoNo=<%=memo.getMemoNo()%>"
               onclick="return confirm('정말 삭제하시겠습니까?');">
                삭제
            </a>
        </td>
    </tr>

<%
    }
}else{
%>

    <tr>
        <td colspan="7">등록된 메모가 없습니다.</td>
    </tr>

<%
}
%>

</table>

</body>
</html>