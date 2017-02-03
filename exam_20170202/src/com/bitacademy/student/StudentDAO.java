package com.bitacademy.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bitacademy.dept.Dept;

public class StudentDAO {
	/* 학생정보를 DB에 저장하는 메서드
	 * 매개변수 student
	 * -DB 에 저장하고 싶은 학생의 학번,이름,학년,학과번호를
	 * 속성으로 저장하고있는 객체 */
	public static void insertStudent(Student student) throws Exception {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			
			//JDBC Driver를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다. 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");
			
			//3.TB_STUDENT 테이블에 학생정보를 저장하는 쿼리를 실행하는 PreparedStatement 객체를 생성해서 지역변수 psmt에 대입한다.
			// 실행할 쿼리 : INSERT INTO TB_STU (studno,name,userid,pw,deptno) VALUES(?,?,?,?,?) 
			psmt=conn.prepareStatement("INSERT INTO TB_STU (studno,name,userid,pw,deptno) VALUES(?,?,?,?,?)"); //TB_STU_SEQ.nextval
			
			//4.3의 ?에 매개변수 student의 속성들을 대입한다.
			
			// psmt.setString (?의 인덱스 1부터 시작, ?에 대입할값)
			psmt.setString (1,student.studno);
			//psmt.setInt (1,Integer.parseInt(student.studno));
			psmt.setString (2,student.name);
			psmt.setString (3,student.userid);
			psmt.setString (4,student.pw);
			
			Dept dept = student.dept;
			psmt.setString (5,dept.getDeptno());
			/*String gdeptno = dept.getDeptno();
			int deptno = Integer.parseInt(gdeptno);
			psmt.setInt (5,deptno);*/
			
			System.out.println(student);
			
			//5.쿼리를 실행한다.
			psmt.executeUpdate();
			
		} finally {
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
	}//end method

}