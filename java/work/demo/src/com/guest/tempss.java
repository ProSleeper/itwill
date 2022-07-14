package com.guest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.db.DBConn;

import oracle.jdbc.OracleTypes;

public class tempss {
	public int updateRecord(GuestRecordDTO pDTO) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "{call updateRecord(?,?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, pDTO.getId());
			cstmt.setString(3, pDTO.getG_content());

			result = cstmt.executeUpdate();
			rs = (ResultSet)cstmt.getObject(1);

			
			//하나 고민인건 제대로 update가 될 경우 result가 1을 반환해줄텐데
			//그것도 검사해야하나 고민
			if(rs.next()) {
				//ID가 있을 경우 여기로 들어옴
				//한마디로 로그인 가능.
				
				System.out.println(rs.getString("id") + "나옴?");
			
			}
			
			
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
}
