package com.office.toypjt.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		
		System.out.println(CLASS_NAME.concat("selectMember()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDto selectedMember = null;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT "
					+ "* "
					+ "FROM tbl_mb "
					+ "WHERE "
					+ "mb_id = ? AND mb_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// set
			pstmt.setString(1, memberDto.getMbId());
			pstmt.setString(2, memberDto.getMbPw());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				selectedMember = new MemberDto();
				
				selectedMember.setMbId(rs.getString("mb_id"));
				selectedMember.setMbPw(rs.getString("mb_pw"));
				selectedMember.setMbMail(rs.getString("mb_mail"));
				selectedMember.setMbPhone(rs.getString("mb_phone"));			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return selectedMember;
	}
	
	public MemberDto selectMemberById(String signinedMemberId) {
		
		System.out.println(CLASS_NAME.concat("selectMemberById()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDto selectedMember = null;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT "
					+ "* "
					+ "FROM tbl_mb "
					+ "WHERE "
					+ "mb_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// set
			pstmt.setString(1, signinedMemberId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				selectedMember = new MemberDto();
				
				selectedMember.setMbId(rs.getString("mb_id"));
				selectedMember.setMbPw(rs.getString("mb_pw"));
				selectedMember.setMbMail(rs.getString("mb_mail"));
				selectedMember.setMbPhone(rs.getString("mb_phone"));			
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return selectedMember;
	}

	public int updateMember(MemberDto memberDto) {
		
		System.out.println(CLASS_NAME.concat("updateMember()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "UPDATE "
					+ "tbl_mb "
					+ "SET "
					+ "mb_pw = ?, mb_mail = ?, mb_phone = ? "
					+ "WHERE "
					+ "mb_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// set			
			pstmt.setString(1, memberDto.getMbPw());
			pstmt.setString(2, memberDto.getMbMail());
			pstmt.setString(3, memberDto.getMbPhone());
			pstmt.setString(4, memberDto.getMbId());
			
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

	public int deleteMember(String id) {
		System.out.println(CLASS_NAME.concat("deleteMember()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "DELETE FROM "
					+ "tbl_mb "
					+ "WHERE "
					+ "mb_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// set			
			pstmt.setString(1, id);

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
