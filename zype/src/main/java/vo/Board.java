package vo;

public class Board {

	int board_num;
	String board_title;
	String board_content; // int member_num; // 외래키임
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	@Override
	public String toString() {
		return "Board [board_num=" + board_num + ", board_title=" + board_title + ", board_content=" + board_content + "]";
	}
	
	
}
