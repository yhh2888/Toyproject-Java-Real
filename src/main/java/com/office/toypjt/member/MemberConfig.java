package com.office.toypjt.member;

public class MemberConfig {

	// 회원가입
	final static public String MEMBER_SIGNUP_FORM = "/signup_form.mem";
	final static public String MEMBER_SIGNUP_CONFRIM = "/signup_confirm.mem";
	
	// 로그인
	final static public String MEMBER_SIGNIN_FORM = "/signin_form.mem";
	final static public String MEMBER_SIGNIN_CONFIRM = "/signin_confirm.mem";
	
	// 로그아웃
	final static public String MEMBER_LOGOUT = "/logout_confirm.mem";
	
	// 회원 정보 수정
	final static public String MEMBER_MODIFY_FORM = "/modify_form.mem";
	final static public String MEMBER_MODIFY_CONFIRM = "/modify_confirm.mem";
	
	// 회원 정보 삭제
	final static public String MEMBER_DELETE_FORM = "/delete_form.mem";
	final static public String MEMBER_DELETE_CONFIRM = "/delete_confirm.mem";
	
	// 저장된 아이디
	final static public String SIGNINED_MEMBERID = "signinedMemId";
	
	final static public String DEFAULT_VIEW_PATH = "views/";
	final static public String DEFAULT_VIEW_SUFFIX = ".jsp";
	
	
}

