package com.bitacademy.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
	/* 단대 번호가 일치하는 학과의 학과정보 리턴
	 * 매개변수:colno -조회하려는 단대번호 */
	
	public static ArrayList<Dept> selectDeptList(String colno) throws Exception {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		ArrayList<Dept> deptList = new ArrayList<Dept>(); //colno가 일치하는 학과리스트를저장할 객체
		
		try {
			//1.JDBC Driver를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");

			//3.TB_Dept 테이블에서 colno가 일치하는 전체 학과을 
			//조회하는 쿼리를 실행하는
			// PreparedStatement 객체를 생성해셔 변수 psmt에 저장한다
			//실행할 쿼리:
			//select  deptno,dname,loc,colno from tb_dept where colno=?
			psmt=conn.prepareStatement("select deptno,dname,loc,colno from tb_dept where colno=?");

			//4. 3의 쿼리의 ?에 변수 colno를 저장한다
			//psmt.setString(?인덱스,저장할 변수)
			psmt.setString(1,colno);

			//5.쿼리를 실행하고 조회결과를 변수 rs에 저장한다
			rs=psmt.executeQuery();	

			while (rs.next()) {
				
				// Dept 객체를 생성한다
				Dept dept=new Dept();
				
				// 객체에 DB에서 받아온값 하나씩 넣어준다
				dept.deptno=rs.getString(1);
				dept.dname=rs.getString(2);
				dept.loc=rs.getString(3);
				dept.colno=rs.getString(4);
				
				// 리스트에 채워진 객체를 넣어진다
				deptList.add(dept);
	
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
		return deptList;//전체 학과 정보 리턴
	}

	public static String selectDeptListName(String deptname) throws Exception {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String deptno =null;
		
		try {
			//1.JDBC Driver를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");

			//3.TB_Dept 테이블에서 colno가 일치하는 전체 학과을 
			//조회하는 쿼리를 실행하는
			// PreparedStatement 객체를 생성해셔 변수 psmt에 저장한다
			//실행할 쿼리:
			//select  deptno,dname,loc,colno from tb_dept where colno=?
			psmt=conn.prepareStatement("select deptno from tb_dept where dname=?");

			//4. 3의 쿼리의 ?에 변수 colno를 저장한다
			//psmt.setString(?인덱스,저장할 변수)
			psmt.setString(1,deptname);

			//5.쿼리를 실행하고 조회결과를 변수 rs에 저장한다
			rs=psmt.executeQuery();	

			while (rs.next()) {
		
				// 객체에 DB에서 받아온값 하나씩 넣어준다
				deptno=rs.getString(1);

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
		return deptno;//전체 학과 정보 리턴
	}
}
