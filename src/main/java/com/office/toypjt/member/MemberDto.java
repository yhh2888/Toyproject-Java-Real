package com.office.toypjt.member;

public class MemberDto {

    private int mbNo;
    private String mbId;
    private String mbPw;
    private String mbMail;
    private String mbPhone;

    public MemberDto() {
    }

    public MemberDto(int mbNo, String mbId, String mbPw,
                     String mbMail, String mbPhone) {
        this.mbNo = mbNo;
        this.mbId = mbId;
        this.mbPw = mbPw;
        this.mbMail = mbMail;
        this.mbPhone = mbPhone;
    }
 
    public int getMbNo() {
        return mbNo;
    }

    public void setMbNo(int mbNo) {
        this.mbNo = mbNo;
    }

    public String getMbId() {
        return mbId;
    }

    public void setMbId(String mbId) {
        this.mbId = mbId;
    }

    public String getMbPw() {
        return mbPw;
    }

    public void setMbPw(String mbPw) {
        this.mbPw = mbPw;
    }

    public String getMbMail() {
        return mbMail;
    }

    public void setMbMail(String mbMail) {
        this.mbMail = mbMail;
    }

    public String getMbPhone() {
        return mbPhone;
    }

    public void setMbPhone(String mbPhone) {
        this.mbPhone = mbPhone;
    }
}
//