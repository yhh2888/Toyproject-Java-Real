package com.office.toypjt.memo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.memo")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String CLASS_NAME = "[MemoController] ";
       
    public MemoController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		String nextPage = null;
		
		MemoService memoService = null;
		
		switch (command) {
		// 메모 작성
		case MemoConfig.MEMO_WRITE_FORM:
			System.out.println(CLASS_NAME.concat(MemoConfig.MEMO_WRITE_FORM));
			
			nextPage = generateView("memo_write_form");
			
			break;
			
		case MemoConfig.MEMO_WRITE_CONFIRM:
			System.out.println(CLASS_NAME.concat(MemoConfig.MEMO_WRITE_CONFIRM));
			
			memoService = new MemoService();
			
			int resultForWrite = memoService.writeMemo(request,response);
			
			if (resultForWrite > 0) {
				System.out.println(CLASS_NAME.concat("MEMO WRITE SUCCESS!!"));
				
				response.sendRedirect(request.getContextPath().concat(MemoConfig.MEMO_LIST));
				
				return;
				
			} else {
				System.out.println(CLASS_NAME.concat("MEMO WRITE FAIL!!"));
				
				nextPage = generateView("memo_write_form");
				
			}
			
			break;
		
		// 메모 리스트
		case MemoConfig.MEMO_LIST:
			System.out.println(CLASS_NAME.concat(MemoConfig.MEMO_LIST));
			
			memoService = new MemoService();
			memoService.getMemos(request, response);
			
			nextPage = generateView("memo_list");
			
			break;
		
		// 메모 수정
		case MemoConfig.MEMO_MODIFY_FORM:
			System.out.println(CLASS_NAME.concat(MemoConfig.MEMO_MODIFY_FORM));
			
			memoService = new MemoService();
			memoService.getMemo(request, response);
			
			nextPage = generateView("memo_modify_form");
			
			break;
			
		case MemoConfig.MEMO_MODIFY_CONFIRM:
			System.out.println(CLASS_NAME.concat(MemoConfig.MEMO_MODIFY_CONFIRM));
			
			memoService = new MemoService();
			
			int resultForModify = memoService.modifyMemo(request, response);
			
			if (resultForModify > 0) {
				System.out.println(CLASS_NAME.concat("MEMO MODIFY SUCCESS!!"));
				
			} else {
				System.out.println(CLASS_NAME.concat("MEMO MODIFY FAIL!!"));
			}
			
			response.sendRedirect(request.getContextPath().concat(MemoConfig.MEMO_LIST));
			
			return;
			
		case MemoConfig.MEMO_DELETE_CONFIRM:
			System.out.println(CLASS_NAME.concat(MemoConfig.MEMO_DELETE_CONFIRM));
			
			memoService = new MemoService();
			
			int resultForDelete = memoService.deleteMemo(request, response);
			
			if (resultForDelete > 0) {
				System.out.println(CLASS_NAME.concat("MEMO DELETE SUCCESS!!"));
				
			} else {
				System.out.println(CLASS_NAME.concat("MEMO DELETE FAIL!!"));
			}
			
			response.sendRedirect(request.getContextPath().concat(MemoConfig.MEMO_LIST));
			
			return;

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	private String generateView(String viewName) {
		
		return MemoConfig.DEFAULT_VIEW_PATH
				.concat(viewName)
				.concat(MemoConfig.DEFAULT_VIEW_SUFFIX);
	}

}
