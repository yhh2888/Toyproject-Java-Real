package com.office.toypjt.member;

import java.io.IOException;

import com.office.toypjt.IToyPjtConfig;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("*.mem")
public class MemberController extends HttpServlet implements IToyPjtConfig {
	private static final long serialVersionUID = 1L;
       
   
	private String CLASS_NAME = "[MemberController]";
	
	
    public MemberController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String nextPage = null;
		
		MemberService memberService = null;
		
		switch (command) {
		
		// 회원가입
		case MemberConfig.MEMBER_SIGNUP_FORM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_SIGNUP_FORM));
		
			nextPage = generateViewName("/signup_form");
			
			break;
			
		case MemberConfig.MEMBER_SIGNUP_CONFRIM :
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_SIGNUP_CONFRIM));
			
			memberService = new MemberService(new MemberDao());
			
			int result = memberService.userSignUpMember(request,response);
//			System.out.println(result + " result");
			
			if (IS_DEV) {
				result = 1;
			}

			if(result > 0) {
				System.out.println(CLASS_NAME.concat("MEMBER SIGN UP SUCCESS!!"));
				nextPage = generateViewName("/signup_ok");
				
			} else {
				System.out.println(CLASS_NAME.concat("MEMBER SIGN UP FAIL!!"));
				nextPage = generateViewName("/signup_ng");
			}
			
			break;	
		
		// 로그인
		case MemberConfig.MEMBER_SIGNIN_FORM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_SIGNIN_FORM));
			nextPage = generateViewName("/signin_form");
			
			break;
			
		case MemberConfig.MEMBER_SIGNIN_CONFIRM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_SIGNIN_CONFIRM));
			
			memberService = new MemberService(new MemberDao());
			
			String signmemId = memberService.userSignInMember(request,response);
			
			// dumy data
			if (IS_DEV) {
				signmemId = "gildong";
				
			}
			
			if(signmemId != null) {
				System.out.println(CLASS_NAME.concat("MEMBER SIGN IN SUCCESS!!"));
				nextPage = generateViewName("/signin_ok");
				
				HttpSession session = request.getSession();
				session.setAttribute(MemberConfig.SIGNINED_MEMBERID,signmemId);
			
			} else {
				System.out.println(CLASS_NAME.concat("MEMBER SIGN IN FAIL!!"));
				nextPage = generateViewName("/signin_ng");
			}
			
			break;
		
		// 회원 정보 수정
		case MemberConfig.MEMBER_MODIFY_FORM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_MODIFY_FORM));
			
			memberService = new MemberService(new MemberDao());
			
			HttpSession session = request.getSession();
			String signinedMemberId = String.valueOf(session.getAttribute(MemberConfig.SIGNINED_MEMBERID));
			
			MemberDto currentSigninedMember = memberService.getcurrentSigninedMember(signinedMemberId);
			request.setAttribute("currentSigninedMember", currentSigninedMember);
			
			nextPage = generateViewName("/modify_form");
			
			break; 
			
		case MemberConfig.MEMBER_MODIFY_CONFIRM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_MODIFY_CONFIRM));
			
			memberService = new MemberService(new MemberDao());
			int resultForModifyMember = memberService.modifyMemberNo(request, response);
			
			
			if(resultForModifyMember > 0) {
				System.out.println(CLASS_NAME.concat("MEMBER MODIFY SUCCESS!!"));
				nextPage = generateViewName("/modify_ok");
				
			} else {
				System.out.println(CLASS_NAME.concat("MEMBER MODIFY FAIL!!"));
				nextPage = generateViewName("/modify_ng");			
			}
			
			break;
			
		// 회원 정보 삭제
		case MemberConfig.MEMBER_DELETE_FORM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_DELETE_FORM));
			nextPage = generateViewName("/delete_form");
			
			break;
			
		case MemberConfig.MEMBER_DELETE_CONFIRM:
			System.out.println(CLASS_NAME.concat(MemberConfig.MEMBER_DELETE_CONFIRM));
			
			memberService = new MemberService(new MemberDao());
			int resultForDelete = memberService.deleteMember(request, response);
			
			if(resultForDelete > 0) {
				System.out.println(CLASS_NAME.concat("MEMBER DELETE SUCCESS!!"));
				nextPage = generateViewName("/delete_ok");
				
			} else {
				System.out.println(CLASS_NAME.concat("MEMBER DELETE FAIL!!"));
				nextPage = generateViewName("/delete_ng");
				
			}
			
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

	
	private String generateViewName(String viewName) {
		
		return MemberConfig.DEFAULT_VIEW_PATH.concat(viewName).
				concat(MemberConfig.DEFAULT_VIEW_SUFFIX);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}

}
