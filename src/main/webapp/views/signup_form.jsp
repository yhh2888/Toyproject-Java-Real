<%@page import="com.office.toypjt.member.MemberConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./include/title.jsp" />
</head>
<body>

	<h1>MEMEBER SIGNUP FORM</h1>
	
	<jsp:include page="./include/nav.jsp" />
	
	<div>
	
		<form
			action= "<%= request.getContextPath().concat(MemberConfig.MEMBER_SIGNUP_CONFRIM) %>"
			name="member_signup_form"
			method="post">
			
			<input type="text" name="memId" placeholder="Input new member ID!">
			<br>
			<input type="password" name="memPw" placeholder="Input new member PW!">
			<br>
			<input type="email" name="memMail" placeholder="Input new member MAIL!">
			<br>
			<input type="text" name="memPhone" placeholder="Input new member PHONE!">
			<br>
			<input type="submit" value="SIGN-UP">
			<input type="reset" value="RESET">
						
		</form>
	
	</div>
	
	

</body>
</html>