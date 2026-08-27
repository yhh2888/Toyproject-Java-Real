<%@page import="com.office.toypjt.member.MemberConfig"%>
<%@page import="com.office.toypjt.memo.MemoConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<a href="<%=request.getContextPath() %>/">HOME</a>
	&nbsp;&nbsp; | &nbsp;&nbsp;
	
	<%
		String signinedMemId = null;
		if (session.getAttribute("signinedMemId") !=
				null) {
			signinedMemId = String.valueOf(session.getAttribute("signinedMemId"));	
	%>		
	
			<a href="<%=request.getContextPath().concat(MemoConfig.MEMO_LIST) %>">MEMO</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="<%=request.getContextPath().concat(MemberConfig.MEMBER_LOGOUT) %>">SIGN-OUT</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="<%=request.getContextPath().concat(MemberConfig.MEMBER_MODIFY_FORM) %>">MODIFY</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="<%=request.getContextPath().concat(MemberConfig.MEMBER_DELETE_FORM) %>">DELETE</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
	<%
		} else {
	%>
			<a href="<%=request.getContextPath().concat(MemberConfig.MEMBER_SIGNUP_FORM) %>">SIGN-UP</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="<%=request.getContextPath().concat(MemberConfig.MEMBER_SIGNIN_FORM) %>">SIGN-IN</a>
	<%
		}
	%>
	
	
</div>