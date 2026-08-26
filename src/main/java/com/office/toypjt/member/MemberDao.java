package com.office.toypjt.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.office.toypjt.IToyPjtConfig;




public class MemberDao implements IToyPjtConfig {
	
	public int insertNewMember(MemberDto memberDto) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "INSERT INTO tbl_mb(mb_id, mb_pw, mb_mail, mb_phone) "
					+ "VALUES(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			// set
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	

}
