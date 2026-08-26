package com.office.toypjt.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemoDao {
	
	final private String CLASS_NAME = "[MemoDao]";
	
	public int insertNewMemo(MemoDto memoDto) {
		System.out.println(CLASS_NAME.concat("insertNewMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
