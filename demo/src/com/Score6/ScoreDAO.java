package com.Score6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

import oracle.jdbc.OracleTypes;

//표준 DAO 
public class ScoreDAO {	//Data Access Ojbect

	//insert CallableStatement
	public int insertData(ScoreDTO pDTO) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;

		try {
			sql = "{call insertScore(?,?,?,?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, pDTO.getHak());
			cstmt.setString(2, pDTO.getName());
			cstmt.setInt(3, pDTO.getKor());
			cstmt.setInt(4, pDTO.getEng());
			cstmt.setInt(5, pDTO.getMat());

			result = cstmt.executeUpdate();

			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//update CallableStatement
	public int updateData(ScoreDTO pDTO) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;

		try {
			sql = "{call updateScore(?,?,?,?)}";

			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, pDTO.getHak());
			cstmt.setInt(2, pDTO.getKor());
			cstmt.setInt(3, pDTO.getEng());
			cstmt.setInt(4, pDTO.getMat());
			

			result = cstmt.executeUpdate();

			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//delete CallableStatement
	public int deleteData(String pHak) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		String sql;

		try {
			sql = "{call deleteScore(?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, pHak);

			result = cstmt.executeUpdate();

			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}


	//전체 출력
	public List<ScoreDTO> getList(){

		List<ScoreDTO> dtoList = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "{call selectAllScore(?)}";

			cstmt = conn.prepareCall(sql);
			
			//out파라미터의 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);

			//프로시져 실행
			cstmt.executeQuery();

			//out파라미터의 값을 받음
			rs = (ResultSet)cstmt.getObject(1);
			
		
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
			cstmt.close();


		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dtoList;
	}


	//이름 검색
	public List<ScoreDTO> getList(String pName){

		List<ScoreDTO> dtoList = new ArrayList<>();

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "{call selectNameScore(?, ?)}";

			cstmt = conn.prepareCall(sql);
			
			//out파라미터의 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, pName);
			
			//프로시져 실행
			
			cstmt.executeUpdate();

			//out파라미터의 값을 받음
			rs = (ResultSet)cstmt.getObject(1);

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
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dtoList;
	}

	//학번 검색
	public ScoreDTO getLists(String pHak){

		ScoreDTO dto = null;

		Connection conn = DBConn.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "{call selectHakScore(?, ?)}";

			cstmt = conn.prepareCall(sql);
			
			//out파라미터의 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, pHak);
			
			//프로시져 실행
			cstmt.executeUpdate();
			
			//out파라미터의 값을 받음
			rs = (ResultSet)cstmt.getObject(1);
			
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
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

}





