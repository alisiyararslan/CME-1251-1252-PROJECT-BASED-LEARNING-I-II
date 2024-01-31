public class RowNode {
	private Object data;
	private RowNode prev;
	private ColumnNode prev2;
	private RowNode next;
	private int position;
	private int rowNumber;
	private boolean selected_next;
	
	public boolean isSelected_next() {
		return selected_next;
	}
	public void setSelected_next(boolean selected_next) {
		this.selected_next = selected_next;
	}
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	private boolean selected;
	private boolean found;
	
	
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public  RowNode(Object data) { 
		this.data = data; 
		prev = null;
		next = null;
		prev2 = null;
		position = 0;
		rowNumber = 1;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public RowNode getPrev() {
		return prev;
	}
	public void setPrev(RowNode prev) {
		this.prev = prev;
	}
	
	public RowNode getNext() {
		return next;
	}
	public void setNext(RowNode next) {
		this.next = next;
	}
	public ColumnNode getPrev2() {
		return prev2;
	}
	public void setPrev2(ColumnNode prev2) {
		this.prev2 = prev2;
	}
}
