package com.office.toypjt.memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.office.toypjt.IToyPjtConfig;

public class MemoDao implements IToyPjtConfig{
	
	final private String CLASS_NAME = "[MemoDao]";
	
	// 메모 생성(create)
	public int insertNewMemo(MemoDto memoDto) {
		System.out.println(CLASS_NAME.concat("insertNewMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO tbl_memo("
					+ "memo_name, "
					+ "memo_content, "
					+ "memo_writer_id, "
					+ "memo_write_date, "
					+ "memo_last_modify) "
				+ "VALUES(?, ?, ?, NOW(), NOW())";
	
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, memoDto.getMemoName());
	pstmt.setString(2, memoDto.getMemoContent());
	pstmt.setString(3, memoDto.getMemoWriterId());
	
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
	
	// 메모 조회(read)
	public List<MemoDto> selectMemoList(String memberId) {
		System.out.println(CLASS_NAME.concat("selectedMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemoDto> memoDtos = new ArrayList<MemoDto>();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM tbl_memo ORDER BY memo_no DESC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemoDto memoDto = new MemoDto();
				memoDto.setMemoNo(rs.getInt("memo_no"));
				memoDto.setMemoName(rs.getString("memo_name"));
				memoDto.setMemoContent(rs.getString("memo_content"));
				memoDto.setMemoWriterId(rs.getString("memo_writer_id"));
				memoDto.setMemoWriteDate(rs.getString("memo_write_date"));
				memoDto.setMemoLastModify(rs.getString("memo_last_modify"));
				
				memoDtos.add(memoDto);
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
		return memoDtos;
	}

	// 메모 한 건 조회(read)
	public MemoDto selectMemo(int memoNo) {
		System.out.println(CLASS_NAME.concat("selectMemo()"));

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemoDto memoDto = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM tbl_memo WHERE memo_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memoNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memoDto = new MemoDto();
				memoDto.setMemoNo(rs.getInt("memo_no"));
				memoDto.setMemoName(rs.getString("memo_name"));
				memoDto.setMemoContent(rs.getString("memo_content"));
				memoDto.setMemoWriterId(rs.getString("memo_writer_id"));
				memoDto.setMemoWriteDate(rs.getString("memo_write_date"));
				memoDto.setMemoLastModify(rs.getString("memo_last_modify"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return memoDto;
	}
	
	// 메모 수정(update)
	public int updateMemo(MemoDto memoDto) {
		System.out.println(CLASS_NAME.concat("updateForMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "UPDATE tbl_memo "
							+ "SET "
								+ "memo_name = ?, memo_content = ? "
							+ "WHERE "
								+ "memo_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memoDto.getMemoName());
			pstmt.setString(2, memoDto.getMemoContent());
			pstmt.setInt(3, memoDto.getMemoNo());
			
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
	
	// 삭제(delete)
	public int deleteMemo(int memoNo) {
		System.out.println(CLASS_NAME.concat("deleteForMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM tbl_memo "
							+ "WHERE "
								+ "memo_no = ?";
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memoNo);
			
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
