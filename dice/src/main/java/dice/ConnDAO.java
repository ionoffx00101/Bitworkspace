package dice;

import java.sql.Connection;

public class ConnDAO {

	// instance라는 이름을 가진 객체로 한번만 생성
	private static ConnDAO instance = new ConnDAO();

	private ConnDAO() {

	}

	// 누가 conndao를 찾으면 인스탄스를 보내줌
	public static ConnDAO getInstance() {
		return instance;
	}

	private Connection getConnection() {
		Connection connection = null;
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
