package com.Score6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

//표준 DAO 
public class ScoreDAO2 {	//Data Access Ojbect

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


	//전체 출력
	public List<ScoreDTO> getList(){

		List<ScoreDTO> dtoList = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hak, name, kor, eng, mat,";
			sql += "(kor + eng + mat) as tot, (kor + eng + mat) / 3 as avg,";
			sql += "rank() over (order by (kor + eng + mat) desc) rank ";
			sql += "from score";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ScoreDTO dto = new ScoreDTO();

				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				dto.setRank(rs.getInt("rank"));


				dtoList.add(dto);
			}

			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dtoList;
	}


	//이름 검색
	public List<ScoreDTO> getList(String pName){

		List<ScoreDTO> dtoList = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hak, name, kor, eng, mat,";
			sql += "(kor + eng + mat) as tot, (kor + eng + mat) / 3 as avg ";
			sql += "from score where name like ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ScoreDTO dto = new ScoreDTO();

				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));


				dtoList.add(dto);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dtoList;
	}

	//학번 검색
	public ScoreDTO getLists(String pHak){

		ScoreDTO dto = null;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select hak, name, kor, eng, mat,";
			sql += "(kor + eng + mat) as tot, (kor + eng + mat) / 3 as avg ";
			sql += "from score where hak = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pHak);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				dto = new ScoreDTO();

				dto.setHak(rs.getString("hak"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

}





