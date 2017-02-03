package dice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends AbstractDAO{
	
	public List<BoardDTO> getAllBoard() {
		conn = getConnection();
		//String sql = "SELECT t1.*, TRUNC((ROWNUM-1)/10)+1 page FROM ( SELECT num,LPAD(' ', (LEVEL-1)*4,'¡¡') || DECODE(LEVEL,1,'','¦Æ ')||title as title,contents,wdate,author,hits,REF,ATTNUM,Filename FROM board START WITH ref='0' CONNECT BY PRIOR Num=Ref order siblings by num) t1";
		String sql = "Select * from board where rownum=1";
		try {
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			List<BoardDTO> list = new ArrayList<>();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_num(rs.getInt("board_num"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_content(rs.getString("board_content"));
				dto.setMember_num(rs.getInt("member_num"));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}
}
