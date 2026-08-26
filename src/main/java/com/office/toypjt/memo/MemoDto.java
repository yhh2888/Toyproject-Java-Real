package com.office.toypjt.memo;

import java.sql.Timestamp;

public class MemoDto {

    private int memoNo;                // memo_no (메모 번호, PK)
    private String memoName;           // memo_name (메모 제목)
    private String memoContent;        // memo_content (메모 내용)
    private String memoWriterId;       // memo_writer_id (작성자 아이디)
    private Timestamp memoWriteDate;   // memo_write_date (작성 날짜)
    private Timestamp memoLastModify;  // memo_last_modify (마지막 수정 날짜)

    // 기본 생성자
    public MemoDto() {
    }

    // 매개변수 생성자 (전체 필드)
    public MemoDto(int memoNo, String memoName, String memoContent, String memoWriterId,
                   Timestamp memoWriteDate, Timestamp memoLastModify) {
        this.memoNo = memoNo;
        this.memoName = memoName;
        this.memoContent = memoContent;
        this.memoWriterId = memoWriterId;
        this.memoWriteDate = memoWriteDate;
        this.memoLastModify = memoLastModify;
    }

    // Getter & Setter
    public int getMemoNo() {
        return memoNo;
    }

    public void setMemoNo(int memoNo) {
        this.memoNo = memoNo;
    }

    public String getMemoName() {
        return memoName;
    }

    public void setMemoName(String memoName) {
        this.memoName = memoName;
    }

    public String getMemoContent() {
        return memoContent;
    }

    public void setMemoContent(String memoContent) {
        this.memoContent = memoContent;
    }

    public String getMemoWriterId() {
        return memoWriterId;
    }

    public void setMemoWriterId(String memoWriterId) {
        this.memoWriterId = memoWriterId;
    }

    public Timestamp getMemoWriteDate() {
        return memoWriteDate;
    }

    public void setMemoWriteDate(Timestamp memoWriteDate) {
        this.memoWriteDate = memoWriteDate;
    }

    public Timestamp getMemoLastModify() {
        return memoLastModify;
    }

    public void setMemoLastModify(Timestamp memoLastModify) {
        this.memoLastModify = memoLastModify;
    }

    // toString()
    @Override
    public String toString() {
        return "MemoDto [memoNo=" + memoNo + ", memoName=" + memoName + ", memoContent=" + memoContent
                + ", memoWriterId=" + memoWriterId + ", memoWriteDate=" + memoWriteDate
                + ", memoLastModify=" + memoLastModify + "]";
    }
}
