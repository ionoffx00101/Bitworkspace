package kr.bit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.impl.GenericObjectPool;*/


import kr.bit.dto.MemberDto;

public class MemberDao {

	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {
		/*// DB 커넥션 풀 생성 - 이 예제에서는 편의상 여기에.
	    GenericObjectPool objectPool = new GenericObjectPool();
	    DriverManagerConnectionFactory connectionFactory 
	                    = new DriverManagerConnectionFactory( "jdbc:oracle:thin:@localhost:1521:xe", "scott" , "tiger");
	    new PoolableConnectionFactory(connectionFactory, objectPool, null, null, false, true);
	    PoolingDriver driver = new PoolingDriver();
	    driver.registerPool("/webdb_pool", objectPool);*/

	}
	
	public static MemberDao getInstance(){
		return instance;
	}
	
	public int insertMember(MemberDto dto) {
		int nReturn = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into member (id, pw, name, email, address, tel) values (?,?,?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getTel() );
			pstmt.executeUpdate();
			nReturn = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return nReturn;
	}
	
	public boolean confirmMemberId(String id) {
		boolean bUserExist = false;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from member where id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if(set.next()){
				bUserExist = true;
			} else {
				bUserExist = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return bUserExist;
	}
	
	public boolean memberCheck( String id, String pw) {
		boolean bUserExists = false;
		String dbPw;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from member where id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()) {
				dbPw = set.getString("pw");
				if(dbPw.equals(pw)) {
					bUserExists = true;			// 로그인 Ok
				} else {
					bUserExists = false;		// 비번 X
				}
			} else {
				bUserExists = false;		// 회원 X	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bUserExists;
	}
	
	public MemberDto getMember(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from member where id = ?";
		MemberDto dto = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.seteMail(rs.getString("eMail"));
				dto.setAddress(rs.getString("address"));
				dto.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
	public int updateMember(MemberDto dto) {
		int nReturn = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "update member set pw=?, eMail=?, address=?, tel=? where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getId());
			nReturn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return nReturn;
	}
	
	private Connection getConnection() {
		
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
