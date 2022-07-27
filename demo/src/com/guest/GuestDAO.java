package com.guest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConn;

import oracle.jdbc.OracleTypes;

//표준 DAO 
public class GuestDAO {	//Data Access Ojbect

	Connection conn = DBConn.getConnection();
	CallableStatement cstmt = null;
	ResultSet rs = null;
	String sql;
	
	//insert CallableStatement
	public int writeInfo(GuestCustomDTO pDTO) {
		int result = 0;

		try {
			sql = "{call writeInfo(?,?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, pDTO.getId());
			cstmt.setString(2, pDTO.getPw());
			cstmt.setString(3, pDTO.getName());

			//일단 여기 리턴값이 정확히 숫자로 주는지를 나중에 확인
			result = cstmt.executeUpdate();

			cstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//updateRecord CallableStatement
	public int updateRecord(GuestRecordDTO pDTO) {
		int result = 0;

		try {
			sql = "{call updateRecord(?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, pDTO.getId());
			cstmt.setString(2, pDTO.getG_content());

			result = cstmt.executeUpdate();

			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//searchID CallableStatement
	public GuestDTO[] searchID(String pID){

		GuestDTO[] dto = null;

		try {
			sql = "{call searchID(?, ?)}";
			cstmt = conn.prepareCall(sql);

			//out파라미터의 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, pID);

			//프로시져 실행
			cstmt.executeUpdate();

			//out파라미터의 값을 받음
			rs = (ResultSet)cstmt.getObject(1);

			if(rs.next()) {
				dto = new GuestDTO[2];

				GuestCustomDTO cDTO = new GuestCustomDTO();
				GuestRecordDTO rDTO = new GuestRecordDTO();

				cDTO.setId(rs.getString("id"));
				cDTO.setPw(rs.getString("pw"));
				cDTO.setName(rs.getString("name"));

				rDTO.setId(rs.getString("id"));
				rDTO.setG_content(rs.getString("g_content"));
				rDTO.setCreated(rs.getString("created"));
				dto[0] = cDTO;
				dto[1] = rDTO;
			}
			rs.close();
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	//updateInfo CallableStatement
	public int updateInfo(GuestCustomDTO pDTO) {
		int result = 0;

		try {
			sql = "{call updateInfo(?,?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, pDTO.getId());
			cstmt.setString(2, pDTO.getPw());
			cstmt.setString(3, pDTO.getName());

			result = cstmt.executeUpdate();

			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//delete CallableStatement
	public int deleteData(String pID) {
		int result = 0;

		try {
			sql = "{call deleteData(?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, pID);

			result = cstmt.executeUpdate();

			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	//printData CallableStatement
	public List<GuestDTO[]> printData(){

		List<GuestDTO[]> dtoList = new ArrayList<>();

		try {
			sql = "{call printData(?)}";

			cstmt = conn.prepareCall(sql);

			//out파라미터의 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);

			//프로시져 실행
			cstmt.executeQuery();

			//out파라미터의 값을 받음
			rs = (ResultSet)cstmt.getObject(1);

			while (rs.next()) {

				GuestDTO[] dto = new GuestDTO[2];

				GuestCustomDTO cDTO = new GuestCustomDTO();
				GuestRecordDTO rDTO = new GuestRecordDTO();

				cDTO.setId(rs.getString("id"));
				cDTO.setPw(rs.getString("pw"));
				cDTO.setName(rs.getString("name"));

				rDTO.setId(rs.getString("id"));
				rDTO.setG_content(rs.getString("g_content"));
				rDTO.setCreated(rs.getString("created"));
				dto[0] = cDTO;
				dto[1] = rDTO;


				dtoList.add(dto);
			}

			rs.close();
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dtoList;
	}

	//id,pw check(여기서는 꼭 있어야 하는 것을 체크함.)
	public String CheckInfo(String pID, String pPW){

		String result = null;

		try {
			sql = "{call checkinfo(?,?)}";

			cstmt = conn.prepareCall(sql);

			//out파라미터의 자료형 설정
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);

			cstmt.setString(2, pID);

			//프로시져 실행
			cstmt.executeQuery();

			//out파라미터의 값을 받음
			rs = (ResultSet)cstmt.getObject(1);


			if(rs.next()) {	
				if(rs.getString("pw").equals(pPW)) {
					result = rs.getString("id");	//아이디와 비밀번호가 모두 일치함.
				}
			}
			if(result == null) {
				System.out.println("아이디가 존재하지 않거나 비밀번호가 틀렸습니다.");
			}

			rs.close();
			cstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	/*
	//insert CallableStatement
		//구조 변경으로 안씀
		//	public int writeRecord(GuestRecordDTO pDTO) {
		//		int result = 0;
		//
		//		Connection conn = DBConn.getConnection();
		//		CallableStatement cstmt = null;
		//		String sql;
		//
		//		try {
		//			sql = " { call writeRecord(?, ?, ?) } ";
		//
		//			cstmt = conn.prepareCall(sql);
		//
		//			cstmt.setString(1, pDTO.getId());
		//			cstmt.setString(2, pDTO.getG_content());
		//			cstmt.setString(3, pDTO.getCreated());
		//
		//			//일단 여기 리턴값이 정확히 숫자로 주는지를 나중에 확인
		//			result = cstmt.executeUpdate();
		//
		//			cstmt.close();
		//
		//		} catch (Exception e) {
		//			System.out.println(e.toString());
		//		}
		//		return result;
		//	}
		 
		 */

}





