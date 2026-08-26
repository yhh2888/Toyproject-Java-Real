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

    // 성공/실패 로그를 한 곳에서 처리하는 헬퍼 메서드
    // result > 0이면 성공 로그, 아니면 실패 로그를 찍고 그 결과를 그대로 반환
    private int logResult(String methodName, int result) {
        if (result > 0) {
            System.out.println(CLASS_NAME.concat(methodName).concat("() SUCCESS!!"));
        } else {
            System.out.println(CLASS_NAME.concat(methodName).concat("() FAIL!!"));
        }
        return result;
    }

    // 회원가입
    public int userSignUpMember(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbId(request.getParameter("mb_id"));
        memberDto.setMbPw(request.getParameter("mb_pw"));
        memberDto.setMbMail(request.getParameter("mb_mail"));
        memberDto.setMbPhone(request.getParameter("mb_phone"));

        return logResult("signUp", memberDao.insertNewMember(memberDto));
    }

    // 로그인 
    public String userSignInMember(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbId(request.getParameter("mb_id"));
        memberDto.setMbPw(request.getParameter("mb_pw"));

        MemberDto loginedMember = memberDao.selectMember(memberDto);

        if (loginedMember != null) {
            System.out.println(CLASS_NAME.concat("signIn() SUCCESS!!"));
            return loginedMember.getMbId();
        } else {
            System.out.println(CLASS_NAME.concat("signIn() FAIL!!"));
        }

        return null;
    }

    // 회원 조회
    public MemberDto getcurrentSigninedMember(String signinedMemberId) {
        return memberDao.selectMemberById(signinedMemberId);
    }

    // 회원 정보 수정
    public int modifyMemberNo(HttpServletRequest request, HttpServletResponse response) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMbId(request.getParameter("mb_id"));

        return logResult("modifyMemberNo", memberDao.updateMember(memberDto));
    }

    // 회원 정보 삭제
    public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("mb_id");

        return logResult("deleteMember", memberDao.deleteMember(id));
    }
}
