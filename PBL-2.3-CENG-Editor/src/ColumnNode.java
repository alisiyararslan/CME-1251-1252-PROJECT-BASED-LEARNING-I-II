
public class ColumnNode {
	private Object data;
	private ColumnNode up;
	private ColumnNode down;
	private RowNode right;
	private int line;
	
	//private int ColumnRow = 0;
	//private boolean nodeType;
	
	public ColumnNode(Object data) {//Object data, boolean type
		this.data = data; 
		up = null;
		down = null;
		right = null;
		line = 0;
		//nodeType = type;
		//ColumnRow++;
	}
	
	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ColumnNode getUp() {
		return up;
	}
	public void setUp(ColumnNode up) {
		this.up = up;
	}
	public ColumnNode getDown() {
		return down;
	}
	public void setDown(ColumnNode down) {
		this.down = down;
	}
	public RowNode getRight() {
		return right;
	}

	public void setRight(RowNode right) {
		this.right = right;
	}

//	public boolean isNodeType() {
//		return nodeType;
//	}
//
//	public void setNodeType(boolean nodeType) {
//		this.nodeType = nodeType;
//	}
	
}
