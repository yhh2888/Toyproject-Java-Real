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
	
	public int insertNewMemo(MemoDto memoDto) {
		System.out.println(CLASS_NAME.concat("insertNewMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO tbl_memo("
					+ "memo_no, "
					+ "memo_name, "
					+ "memo_content, "
					+ "memo_writer_id, "
					+ "memo_write_date, "
					+ "memo_last_modify) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
	
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setInt(1, memoDto.getMemoNo());
	pstmt.setString(2, memoDto.getMemoName());
	pstmt.setString(3, memoDto.getMemoContent());
	pstmt.setString(4, memoDto.getMemoWriterId());
	pstmt.setString(5, memoDto.getMemoWriteDate());
	pstmt.setString(6, memoDto.getMemoLastModify());
	
	result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public int List<MemoDto> selectedMemo(MemoDto memoDto) {
		System.out.println(CLASS_NAME.concat("selectedMemo()"));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemoDto> memoDtos = new ArrayList<MemoDto>();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT *FROM tbl_memo";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemoDto memoDto = new MemoDto();
				
				memoDto.set
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
