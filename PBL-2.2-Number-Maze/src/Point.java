
public class Point {

	private int rowCoordinate;
	private int columnCoordinate;
	private boolean canMove;
	private int score;
	private String color;
	private Point previous;

	public Point(int rowCoordinate, int columnCoordinate, int score) {
		if (score == 1 || score == 2 || score == 3) { // green numbers
			this.canMove = false; // green numbers don't move
		} 
		else if (score == -1 || score == 0) { // walls, empties
			this.canMove = false;
		}
		else {
			this.canMove = true;
		}

		if (score == 1 || score == 2 || score == 3) {
			this.color = "green";
		} else if (score == 4 || score == 5 || score == 6) {
			this.color = "yellow";
		} else if (score == 7 || score == 8 || score == 9) {
			this.color = "red";
		}

		this.rowCoordinate = rowCoordinate;
		this.columnCoordinate = columnCoordinate;

		this.score = score;
	}
	
	public Point(int rowCoordinate, int columnCoordinate, int score,Point previous ) {//path finding
//		if (score == 1 || score == 2 || score == 3) { // green numbers
//			this.canMove = false; // green numbers don't move
//		} 
//		else if (score == -1 || score == 0) { // walls, empties
//			this.canMove = false;
//		}
//		else {
//			this.canMove = true;
//		}
//
//		if (score == 1 || score == 2 || score == 3) {
//			this.color = "green";
//		} else if (score == 4 || score == 5 || score == 6) {
//			this.color = "yellow";
//		} else if (score == 7 || score == 8 || score == 9) {
//			this.color = "red";
//		}

		this.rowCoordinate = rowCoordinate;
		this.columnCoordinate = columnCoordinate;
		this.previous=previous;

		this.score = score;
	}

	// overload
	public Point(int rowCoordinate, int columnCoordinate) { // another constructor for creating human's point
		this.canMove = true;
		this.color = "blue";
		this.rowCoordinate = rowCoordinate;
		this.columnCoordinate = columnCoordinate;
		this.score = 5; // Blue human number (5)
	}

	public int getRowCoordinate() {
		return rowCoordinate;
	}

	public void setRowCoordinate(int rowCoordinate) {
		this.rowCoordinate = rowCoordinate;
	}

	public int getColumnCoordinate() {
		return columnCoordinate;
	}

	public void setColumnCoordinate(int columnCoordinate) {
		this.columnCoordinate = columnCoordinate;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Point getPrevious() {
		return previous;
	}

	public void setPrevious(Point previous) {
		this.previous = previous;
	}

}
