package dice;

import java.sql.Connection;

public class ConnDAO {

	// instance��� �̸��� ���� ��ü�� �ѹ��� ����
	private static ConnDAO instance = new ConnDAO();

	private ConnDAO() {

	}

	// ���� conndao�� ã���� �ν�ź���� ������
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
