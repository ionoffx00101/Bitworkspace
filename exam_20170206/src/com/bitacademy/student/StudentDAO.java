package com.bitacademy.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bitacademy.dept.Dept;

public class StudentDAO {
	/*
	 * 아이디가 일치하는 학생정보를 DB에서 조회 Student 객체의 속성에 저장해서 Student 객체를 리턴 
	 * 매개변수 : userid 조회하려는 학생 아이디
	 */
	public static Student selectStudent(String userid) throws Exception {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Student student = null;
		
		try {
			// 1.JDBC Driver를 로드한다
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");

			// 3.TB_Stu 테이블에서 전체 학생을
			// 조회하는 쿼리를 실행하는
			// PreparedStatement 객체를 생성해셔 변수 psmt에 저장한다
			// -실행할 쿼리
			// select s.studno,s.name,s.userid,s.pw,d.deptno,d.dname,d.loc from
			// tb_stu s,tb_dept d where s.deptno=d.deptno and s.userid=?

			// psmt=conn.prepareStatement(실행할 쿼리)
			// 4.3의 ?에 매개변수 userid을 대입한다.
			// ? 가 하나이므로 psmt.setString(1,userid);
			
			String query = "select s.studno, s.name, s.userid, s.pw, d.deptno, d.dname, d.loc from tb_stu s, tb_dept d where s.deptno = d.deptno and s.userid = ?";
			psmt = conn.prepareStatement(query);
			psmt.setString(1, userid);

			// 5.쿼리를 실행하고 조회결과를 변수 rs에 저장한다
			// rs=psmt.executeQuery();
			
			rs = psmt.executeQuery();

			if (rs.next()) {
				// 6.Student 객체를 생성해서 지역변수 student에 저장한다
				// student=new Student();
				
				student = new Student();

				// 7.4의 조회결과중 학생번호,이름,학년을 6객체의 속성에 저장한다
				// 6객체.studno=rs.getString(컬럼인덱스);
				// 조회결과에서 학생 번호는 첫번째 컬럼이므로 컬럼인덱스는 1
				// 즉 다음과 같이 구현 6객체.studno=rs.getString(1);
				// 6객체.name=rs.getString(컬럼인덱스);
				// 조회결과에서 학생 이름은 두번째 컬럼이므로 컬럼인덱스는 2
				// 즉 다음과 같이 구현 6객체.name=rs.getString(2);
				
				student.studno = rs.getString(1);
				student.name = rs.getString(2);

				// 아이디, 비밀번호 도 같은 방법으로 userid, pw 속성에 저장한다
				
				student.userid = rs.getString(3);
				student.pw = rs.getString(4);

				// 8.Dept 객체를 생성한다
				// Dept dept=new Dept();
				
				Dept dept = new Dept();

				// 9.4의 조회결과중 학과번호,학과명,학과위치는 8객체의 속성에 저장한다
				// 8객체.deptno=rs.getString(컬럼인덱스 4)
				
				dept.deptno = rs.getString(5);

				// 학과명 학과 위치도 같은 방법으로 구현한다.
				
				dept.dname = rs.getString(6);
				dept.loc = rs.getString(7);

				// 10.8객체를 6객체에 저장한다
				// 6객체.dept=8객체;
				// student.dept=dept;
				
				student.dept = dept;
			}
		} 
		finally {
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
			}// end if
		}// end finally
		
		return student;// 학생 정보 리턴
	}

	/*
	 * 학생정보를 DB에 저장하는 메서드 매개변수 student -DB 에 저장하고 싶은 학생의 학번,이름,학년,학과번호를 속성으로
	 * 저장하고있는 객체
	 */
	public static void insertStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1.JDBC Driver를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");

			// 3.TB_STUDENT 테이블에 학생정보를 저장하는 쿼리를 실행하는
			// PreparedStatement 객체를 생성해서 지역변수 psmt에 대입한다.
			// 실행할 쿼리 :
			// INSERT INTO TB_STU (studno,name,userid,pw,deptno)
			// VALUES(?,?,?,?,?)
			// psmt=conn.prepareStatement(실행할 쿼리)
			psmt = conn
					.prepareStatement("INSERT INTO TB_STU (studno,name,userid,pw,deptno) VALUES(?,?,?,?,?)");
			// 4.3의 ?에 매개변수 student의 속성들을 대입한다.
			// psmt.setString (?의 인덱스 1부터 시작, ?에 대입할값)
			// psmt.setString (1,student.studno)
			// --> 첫번째 ? 에 student 객체의 studno 속성의 값대입
			// -->나머지 ? 에도 student의 속성을 대입
			// 대입하는 값의 순서와 insert into .. (컬럼1,컬럼2..)의
			// 컬럼1,컬럼2의 컬럼순서가 일치해야 한다
			// deptno 컬럼에 저장할 학과번호 값은 student.dept.deptno 에 저장되있다
			psmt.setString(1, student.studno);
			psmt.setString(2, student.name);
			psmt.setString(3, student.userid);
			psmt.setString(4, student.pw);
			psmt.setString(5, student.dept.deptno);

			// 5.쿼리를 실행한다.
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
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
			}// end if
		}// end finally
	}// end method

}