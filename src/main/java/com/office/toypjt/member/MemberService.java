package com.office.toypjt.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberService {

    private String CLASS_NAME = "[MemberService]";
    private MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    private int signUp(MemberDto memberDto) {
        int result = memberDao.insertNewMember(memberDto);

        if (result > 0) {
            System.out.println(CLASS_NAME.concat("signUp() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("signUp() FAIL!!"));
        }

        return result;
    }

    private MemberDto signIn(MemberDto memberDto) {
        MemberDto loginedMember = memberDao.selectMember(memberDto);

        if (loginedMember != null) {
            System.out.println(CLASS_NAME.concat("signIn() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("signIn() FAIL!!"));
        }

        return loginedMember;
    }


    public int userSignUpMember(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(request.getParameter("id"));
        memberDto.setPw(request.getParameter("pw"));

        return signUp(memberDto);
    }

    public String userSignInMember(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(request.getParameter("id"));
        memberDto.setPw(request.getParameter("pw"));

        MemberDto loginedMember = signIn(memberDto);

        return (loginedMember != null) ? loginedMember.getId() : null;
    }

    public MemberDto getcurrentSigninedMember(String signinedMemberId) {
        return memberDao.selectMemberById(signinedMemberId);
    }

    public int modifyMemberNo(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(request.getParameter("id"));

        int result = memberDao.updateMember(memberDto);

        if (result > 0) {
            System.out.println(CLASS_NAME.concat("modifyMemberNo() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat("modifyMemberNo() FAIL!!"));
        }

        return result;
    }

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
