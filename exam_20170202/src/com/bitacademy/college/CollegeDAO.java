package com.bitacademy.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CollegeDAO {

	/*전체 단과대학 조회 */
	public static ArrayList<College> selectCollegeList() throws Exception {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ArrayList<College> colList = new ArrayList<College>();//전체 단과대학 정보를 저장할 객체
		
		try {
			
			// JDBC Driver를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");

			// TB_College 테이블에서 전체 단과대학을 조회하는 쿼리를 실행하는 PreparedStatement 객체를 생성해셔 변수 psmt에 저장한다
			// 실행할 쿼리: select colno,colname from tb_college
			psmt = conn.prepareStatement("select colno,cname from tb_college");
			// 쿼리를 실행하고 조회결과를 변수 rs에 저장한다
			rs = psmt.executeQuery();

			while (rs.next()) {
				
				// collage 객체를 생성한다
				College collage = new College();
				
				// 조회결과들을 하나하나 collage 객체에 저장해준다
				collage.colno = rs.getString(1);
				collage.colname = rs.getString(2);
				
				// collage 객체를 colList에 추가한다
				colList.add(collage);
				
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//end if
		}//end finally
		return colList;//전체 단과대학 정보 리턴
	}
}
