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

	<h1>MEMEBER MODIFY FORM</h1>
	
	<jsp:include page="./include/nav.jsp" />
	
	<div>
	
		<form
			action= "<%= request.getContextPath().concat(MemberConfig.MEMBER_MODIFY_CONFIRM) %>"
			name="member_modify_form"
			method="post">
			
			<input type="hidden" name="memNo" value="${currentSigninedMember.memNo}">
			<%-- <input type="hidden" name="memId" value="${currentSigninedMember.memId}"> --%>
			
			<input type="text" value="${currentSigninedMember.memId}" readonly disabled>
			<br>
			<input type="password" name="memPw" value="${currentSigninedMember.memPw}" placeholder="Input member PW!">
			<br>
			<input type="email" name="memMail" value="${currentSigninedMember.memMail}" placeholder="Input member MAIL!">
			<br>
			<input type="text" name="memPhone" value="${currentSigninedMember.memPhone}" placeholder="Input member PHONE!">
			<br>
			<input type="submit" value="MODIFY">
			<input type="reset" value="RESET">
						
		</form>
	
	</div>
	
	

</body>
</html>