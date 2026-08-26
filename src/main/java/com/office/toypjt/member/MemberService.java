package com.office.toypjt.member;

public class MemberService {
    private MemberDao memberDao = new MemberDao();

    public int signUp(MemberDto memberDto) {
        int result = memberDao.insertMember(memberDto);

        if (result > 0) {
            System.out.println("[MemberService] signUp() SUCCESS!!");
        } else {
            System.out.println("[MemberService] signUp() FAIL!!");
        }

        return result;
    }

    public MemberDto signIn(MemberDto memberDto) {
        MemberDto loginedMember = memberDao.selectMember(memberDto);

        if (loginedMember != null) {
            System.out.println("[MemberService] signIn() SUCCESS!!");
        } else {
            System.out.println("[MemberService] signIn() FAIL!!");
        }

        return loginedMember;
    }
}
