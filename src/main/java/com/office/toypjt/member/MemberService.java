package com.office.toypjt.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.office.toypjt.IToyPjtConfig;

public class MemberService implements IToyPjtConfig {

    private String CLASS_NAME = "[MemberService]";
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    // 회원가입
    public int userSignUpMember(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbId(request.getParameter("id"));
        memberDto.setMbPw(request.getParameter("pw"));
        memberDto.setMbMail(request.getParameter("mail"));
        memberDto.setMbPhone(request.getParameter("phone"));
        
        int result = memberDao.insertNewMember(memberDto);

        result = 0;
        
        if (result > 0) {
            System.out.println(CLASS_NAME.concat("signUp() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("signUp() FAIL!!"));
        }

        return result;
    }
    
    // 로그인
    public String userSignInMember(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbId(request.getParameter("id"));
        memberDto.setMbPw(request.getParameter("pw"));
        
        MemberDto loginedMember = new MemberDto();
        loginedMember.setMbId("someone");
        
//      MemberDto loginedMember = memberDao.selectMember(memberDto);
        
        if (loginedMember != null) {
            System.out.println(CLASS_NAME.concat("signIn() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("signIn() FAIL!!"));
        }

        return (loginedMember != null) ? loginedMember.getMbId() : null;
    }
    
    // 회원 조회
    public MemberDto getcurrentSigninedMember(String signinedMemberId) {
        return memberDao.selectMemberById(signinedMemberId);
    }
    
    // 회원 정보 수정
    public int modifyMemberNo(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbId(request.getParameter("id"));

        int result = memberDao.updateMember(memberDto);

        if (result > 0) {
            System.out.println(CLASS_NAME.concat("modifyMemberNo() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("modifyMemberNo() FAIL!!"));
        }

        return result;
    }
    
    // 회원 정보 삭제
    public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int result = memberDao.deleteMember(id);

        if (result > 0) {
            System.out.println(CLASS_NAME.concat("deleteMember() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("deleteMember() FAIL!!"));
        }

        return result;
    }
}
