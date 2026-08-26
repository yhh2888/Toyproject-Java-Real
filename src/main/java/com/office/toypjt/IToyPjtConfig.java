package com.office.toypjt;

import com.office.toypjt.member.MemberDto;

public interface IToyPjtConfig {

	public final boolean IS_DEV = false;
	
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String URL = "jdbc:mysql://127.0.0.1:3306/db_toy";
	public final String USER = "root";
	public final String PASSWORD = "1234";
	
	int insertNewMember(MemberDto memberDto);

	
}
