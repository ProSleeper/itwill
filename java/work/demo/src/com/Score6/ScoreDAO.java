package com.Score6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.db.DBConn;

public class ScoreDAO {	//Data Access Ojbect

	//	insert statement방법
	//		public int insertData(ScoreDTO pDTO) {
	//			int result = 0;
	//			
	//			Connection conn = DBConn.getConnection();
	//			Statement stmt = null;
	//			String sql;
	//			
	//			try {
	//				sql = "insert into score (hak, name, kor, eng, mat) ";
	//				sql += "values ('" + pDTO.getHak() + "', '";
	//				sql += pDTO.getName() + "', ";
	//				sql += pDTO.getKor() + ", ";
	//				sql += pDTO.getEng() + ", ";
	//				sql += pDTO.getMat() + ")";
	//				
	//				System.out.println(sql);
	//				
	//				stmt = conn.createStatement();
	//				result = stmt.executeUpdate(sql);
	//				stmt.close();
	//				
	//			} catch (Exception e) {
	//				System.out.println(e.toString());
	//			}
	//			return result;
	//		}


	//insert PreparedStatement방법
	public int insertData(ScoreDTO pDTO) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into score (hak, name, kor, eng, mat) ";
			sql += "values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pDTO.getHak());
			pstmt.setString(2, pDTO.getName());
			pstmt.setInt(3, pDTO.getKor());
			pstmt.setInt(4, pDTO.getEng());
			pstmt.setInt(5, pDTO.getMat());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//update PreparedStatement방법
	public int updateData(ScoreDTO pDTO) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "update score set kor = ?, eng = ?, mat = ? ";
			sql += "where hak = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pDTO.getKor());
			pstmt.setInt(2, pDTO.getEng());
			pstmt.setInt(3, pDTO.getMat());
			pstmt.setString(4, pDTO.getHak());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//delete PreparedStatement방법
	public int deleteData(String pHak) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "DELETE score WHERE hak = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pHak);

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
}





