package com.office.toypjt.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.office.toypjt.IToyPjtConfig;

public class MemberDao implements IToyPjtConfig {
	
	final private String CLASS_NAME = "[MemberDao] ";
	
	@Override
	public int insertNewMember(MemberDto memberDto) {
		
		System.out.println(CLASS_NAME.concat("insertNewMember()"));
	
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
			pstmt.setString(1, memberDto.getMbId());
			pstmt.setString(2, memberDto.getMbPw());
			pstmt.setString(3, memberDto.getMbMail());
			pstmt.setString(4, memberDto.getMbPhone());
			
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

	public MemberDto selectMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public MemberDto selectMemberById(String signinedMemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
