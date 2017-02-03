package com.bitacademy.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeptDAO {
	/*
	 * 단대 번호가 일치하는 학과의 학과정보 리턴
	 * 매개변수:colno -조회하려는 단대번호
	 */
	public static ArrayList<Dept> selectDeptList(String colno)throws Exception{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<Dept>deptList=
				new ArrayList<Dept>();//colno가 일치하는 학과리스트를저장할 객체
		try{
			//1.JDBC Driver를 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			//3.TB_Dept 테이블에서 colno가 일치하는 전체 학과을 
			//조회하는 쿼리를 실행하는
			// PreparedStatement 객체를 생성해셔 변수 psmt에 저장한다
			//실행할 쿼리: select  deptno,dname,loc,colno from tb_dept where colno=?
			// psmt=conn.prepareStatement(실행할 쿼리)
			psmt = conn.prepareStatement("select  deptno,dname,loc,colno from tb_dept where colno=?");
			//4. 3의 쿼리의 ?에 변수 colno를 저장한다
			//psmt.setString(?인덱스,저장할 변수)
			//psmt.setString(1,colno)
			psmt.setString(1,colno);

			
			//5.쿼리를 실행하고 조회결과를 변수 rs에 저장한다
			rs=psmt.executeQuery();	
				
				while(rs.next()){
				//6.Dept 객체를 생성한다
				//  Dept 객체이름=new Dept();	
					Dept dept = new Dept();
				//7.4의 조회결과중 학과번호,이름을  6객체의 속성에 저장한다
				//6객체이름.속성이름=rs.getString(컬럼인덱스);
				// 조회결과에서 학과 번호는 첫번째 컬럼이므로 컬럼인덱스는 1
				//6객체이름.deptno=rs.getString(1);	
					dept.deptno = rs.getString(1);
				// 6객체이름.dname=rs.getString(컬럼인덱스);
				// 조회결과에서 학과 이름은 두번째 컬럼이므로 컬럼인덱스는 2
				// 즉 다음과 같이 구현 6객체.dname=rs.getString(2);
					dept.dname = rs.getString(2);
				// 6객체이름.loc=rs.getString(컬럼인덱스);
				// 조회결과에서 학과 위치는 세번째 컬럼이므로 컬럼인덱스는 3
				// 즉 다음과 같이 구현 6객체.loc=rs.getString(3);
					dept.loc = rs.getString(3);
				// 6객체이름.colno=rs.getString(컬럼인덱스);
				// 조회결과에서 단과대학교 번호는 네번째 컬럼이므로 컬럼인덱스는 4
				// 즉 다음과 같이 구현 6객체.colno=rs.getString(4);	
					dept.colno = rs.getString(4);
				//11.6객체를 속성 colList에 추가한다
				//colList.add(6객체이름);	
					deptList.add(dept);
				}
				
			}catch(Exception e){e.printStackTrace();}
			finally{
				if(rs!=null){
					try{
					rs.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				if(psmt!=null){
					try{
					psmt.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				if(conn!=null){
					try{
					  conn.close();
					 }catch(Exception e){
						e.printStackTrace();
					}
				}//end if
			}//end finally
			return deptList;//전체 학과 정보 리턴
	}
}


