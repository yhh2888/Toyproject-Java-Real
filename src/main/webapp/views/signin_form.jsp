<%@page import="com.office.ex.MemberConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="./include/title.jsp" />
</head>
<body>

	<h1>MEMEBER SIGNIN FORM</h1>
	
	<jsp:include page="./include/nav.jsp" />
	
	<div>
	
		<form
			action= "<%= request.getContextPath().concat(MemberConfig.MEMBER_SIGNIN_CONFIRM) %>"
			name="member_signin_form"
			method="post">
			
			<input type="text" name="memId" placeholder="Input member ID!">
			<br>
			<input type="password" name="memPw" placeholder="Input member PW!">
			<br>
			<input type="submit" value="SIGN-IN">
			<input type="reset" value="RESET">
						
		</form>
	
	</div>
	
	

</body>
</html>