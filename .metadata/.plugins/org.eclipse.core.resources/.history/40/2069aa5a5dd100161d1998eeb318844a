package bitjava.day06.Prob02;

public class Line { // extends Point 
	Point begin;
	Point end;

	public static void main(String[] args) {
		Line l = new Line(3, 2, 5, 2);
	}

	//
	public Line(int x1, int y1, int x2, int y2) {
		/*
		 * begin.setX(x1);
		 * begin.setY(y1);
		 * end.setX(x2);
		 * end.setY(y2);
		 */

		begin = new Point(x1, y1);
		end = new Point(x2, y2);
	}

	public Line(Point begin, Point end) {
		this.begin = begin;
		this.end = end;
	}

	// Begin
	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	// End
	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	// BeginX
	public int getBeginX() {
		return begin.getX();
	}

	public void setBeginX(int x) {
		this.begin.setX(x);
	}

	// BeginY
	public int getBeginY() {
		return begin.getY();
	}

	public void setBeginY(int y) {
		this.begin.setY(y);
	}

	// BeginXY
	public int[] getBeginXY() {
		return begin.getXY();
	}

	public void setBeginXY(int x, int y) {
		//distance 구하는 거겠지..흠..
		begin.setXY(x, y);
	}

	//EndX
	public int getEndX() {
		return end.getX();

	}

	public void setEndX(int x) {
		this.end.setX(x);
	}

	//EndY
	public int getEndY() {
		return end.getY();

	}

	public void setEndY(int y) {
		this.end.setY(y);
	}

	//EndXY
	public int[] getEndXY() {
		return end.getXY();
	}

	public void setEndXY(int x, int y) {
		end.setXY(x, y);
	}

	@Override
	public String toString() {
		return "Line [begin=" + begin + ", end=" + end + "]"; // begin.toString()이 자동으로 써져서 문자열로 바뀜
	}

	public double getLength() {
		double dx = begin.getX() - end.getX();
		double dy = begin.getY() - end.getY();

		return Math.sqrt(dx * dx + dy * dy);

	}

}
