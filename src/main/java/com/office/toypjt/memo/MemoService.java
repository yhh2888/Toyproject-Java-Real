package com.office.toypjt.memo;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.office.toypjt.member.MemberConfig;

public class MemoService {

    private MemoDao memoDao;

    final private String CLASS_NAME = "[MemoService] ";

    // 기본 생성자
    public MemoService() {
        this.memoDao = new MemoDao();
    }


    // ==========================================
    // 메모 작성
    // ==========================================
    public int writeMemo(HttpServletRequest request,
                          HttpServletResponse response) {

        System.out.println(
                CLASS_NAME.concat("writeMemo()")
        );

        MemoDto memoDto = new MemoDto();


        // 제목
        String memoName =
                request.getParameter("memo_name");


        // 내용
        String memoContent =
                request.getParameter("memo_content");


        memoDto.setMemoName(memoName);
        memoDto.setMemoContent(memoContent);


        // 로그인한 사용자 ID
        HttpSession session =
                request.getSession();

        String memberId =
                String.valueOf(
                        session.getAttribute(
                                MemberConfig.SIGNINED_MEMBERID
                        )
                );


        memoDto.setMemoWriterId(memberId);


        // DAO 호출
        int result =
                memoDao.insertNewMemo(memoDto);


        if (result > 0) {

            System.out.println(
                    CLASS_NAME.concat(
                            "MEMO WRITE SUCCESS!!"
                    )
            );

        } else {

            System.out.println(
                    CLASS_NAME.concat(
                            "MEMO WRITE FAIL!!"
                    )
            );
        }


        return result;
    }


    // ==========================================
    // 메모 목록
    // ==========================================
    public List<MemoDto> getMemos(
            HttpServletRequest request,
            HttpServletResponse response) {

        System.out.println(
                CLASS_NAME.concat("getMemos()")
        );


        // 로그인한 사용자 ID
        HttpSession session =
                request.getSession();

        String memberId =
                String.valueOf(
                        session.getAttribute(
                                MemberConfig.SIGNINED_MEMBERID
                        )
                );


        // DAO에서 메모 목록 가져오기
        List<MemoDto> memoList =
                memoDao.selectMemoList(memberId);


        return memoList;
    }


    // ==========================================
    // 메모 수정
    // ==========================================
        public MemoDto getMemo(HttpServletRequest request,
                                                   HttpServletResponse response) {
                int memoNo = Integer.parseInt(request.getParameter("memoNo"));
                return memoDao.selectMemo(memoNo);
        }

    public int modifyMemo(
            HttpServletRequest request,
            HttpServletResponse response) {

        System.out.println(
                CLASS_NAME.concat("modifyMemo()")
        );


        MemoDto memoDto =
                new MemoDto();


        // 메모 번호
        int memoNo =
                Integer.parseInt(
                        request.getParameter("memoNo")
                );


        // 수정할 제목
        String memoName =
                request.getParameter("memoName");


        // 수정할 내용
        String memoContent =
                request.getParameter("memoContent");


        memoDto.setMemoNo(memoNo);
        memoDto.setMemoName(memoName);
        memoDto.setMemoContent(memoContent);


        // DAO 호출
        int result =
                memoDao.updateMemo(memoDto);


        if (result > 0) {

            System.out.println(
                    CLASS_NAME.concat(
                            "MEMO MODIFY SUCCESS!!"
                    )
            );

        } else {

            System.out.println(
                    CLASS_NAME.concat(
                            "MEMO MODIFY FAIL!!"
                    )
            );
        }


        return result;
    }


    // ==========================================
    // 메모 삭제
    // ==========================================
    public int deleteMemo(
            HttpServletRequest request,
            HttpServletResponse response) {

        System.out.println(
                CLASS_NAME.concat("deleteMemo()")
        );


        // 삭제할 메모 번호
        int memoNo =
                Integer.parseInt(
                        request.getParameter("memoNo")
                );


        // DAO 호출
        int result =
                memoDao.deleteMemo(memoNo);


        if (result > 0) {

            System.out.println(
                    CLASS_NAME.concat(
                            "MEMO DELETE SUCCESS!!"
                    )
            );

        } else {

            System.out.println(
                    CLASS_NAME.concat(
                            "MEMO DELETE FAIL!!"
                    )
            );
        }


        return result;
    }

}