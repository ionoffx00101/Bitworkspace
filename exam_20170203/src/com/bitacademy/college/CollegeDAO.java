package com.bitacademy.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CollegeDAO {
	
	/*
	전체 단과대학 조회
	 */
	public static ArrayList<College> selectCollegeList()throws Exception{
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		ArrayList<College>colList=new ArrayList<College>();//전체 단과대학 정보를 저장할 객체
		try{
		//1.JDBC Driver를 로드한다
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.DB에 접속하고 Connection 객체를 지역변수 conn에 대입한다.
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		
		//3.TB_College 테이블에서 전체 단과대학을 
		//조회하는 쿼리를 실행하는
		// PreparedStatement 객체를 생성해셔 변수 psmt에 저장한다
		//실행할 쿼리 : select  colno,cname from tb_college
		// psmt=conn.prepareStatement(실행할 쿼리)
		psmt = conn.prepareStatement("select  colno,cname from tb_college");
		//4.쿼리를 실행하고 조회결과를 변수 rs에 저장한다
		rs=psmt.executeQuery();	
			
			while(rs.next()){
			//6.College 객체를 생성한다
			//  College 객체이름=new College();	
				College college = new College();
				
			//7.4의 조회결과중 단과대학번호,이름을  6객체의 속성에 저장한다
			//6객체이름.속성이름=rs.getString(컬럼인덱스);
			// 조회결과에서 단과대학 번호는 첫번째 컬럼이므로 컬럼인덱스는 1
			//6객체이름.colno=rs.getString(1);	
				college.colno = rs.getString(1);	
			// 6객체.cname=rs.getString(컬럼인덱스);
			// 조회결과에서 단과대학 이름은 두번째 컬럼이므로 컬럼인덱스는 2
			// 즉 다음과 같이 구현 6객체.cname=rs.getString(2);
				college.colname = rs.getString(2);
			
			//11.6객체를 속성 colList에 추가한다
			//colList.add(6객체);	
				colList.add(college);
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
		return colList;//전체 단과대학 정보 리턴
  }
}


