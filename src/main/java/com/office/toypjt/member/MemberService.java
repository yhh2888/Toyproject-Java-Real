package com.office.toypjt.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberService {
	
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
    
    public int signUp(MemberDto memberDto) {
        int result = memberDao.insertNewMember(memberDto);

        if (result > 0) {
            System.out.println("[MemberService] signUp() SUCCESS!!");
        } else {
            System.out.println("[MemberService] signUp() FAIL!!");
        }

        return result;
    }

    public MemberDto signIn(MemberDto memberDto) {
//        MemberDto loginedMember = memberDao.selectMember(memberDto);
//
//        if (loginedMember != null) {
//            System.out.println("[MemberService] signIn() SUCCESS!!");
//        } else {
//            System.out.println("[MemberService] signIn() FAIL!!");
//        }
//
//        return loginedMember;
    	
    	return null;
    	
    }

	public int userSignUpMember(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String userSignInMember(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberDto getcurrentSigninedMember(String signinedMemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int modifyMemberNo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}
}
