import java.awt.Color;
import java.util.Iterator;

import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class MultiLinkedList {
	public enigma.console.Console cnd = Enigma.getConsole("Keyboard Mouse 2",100,30,20,2); // col,row,fontsize,fonttype
	private ColumnNode head;
	private ColumnNode tail;
	private RowNode rowTail;
	private boolean space = false;
	public void addColumn(int line, Object dataToAdd) {
			ColumnNode newNode = new ColumnNode(dataToAdd);
			if(head == null) {
				head = newNode;
				tail=newNode;
				head.setLine(line);
			}
			else {
				newNode.setUp(tail);
				tail.setDown(newNode);
				tail=newNode;
				tail.setLine(line);
			}
	}
	
	public ColumnNode getHead() {
		return head;
	}

	public void setHead(ColumnNode head) {
		this.head = head;
	}

	public ColumnNode getTail() {
		return tail;
	}

	public void setTail(ColumnNode tail) {
		this.tail = tail;
	}
	
	public void addRow(boolean mode,int row,int line ,Object dataToAdd) {
		if (mode) {								// insert
				int rowNumber = 1;
				ColumnNode temp = head;
				while (temp != null)
				{
					if (line==temp.getLine()) {
						RowNode temp2 = temp.getRight();
						RowNode newnode = new RowNode(dataToAdd);
						if (temp2 == null) {
							temp2 = newnode;
							temp2.setPosition(row);
							temp.setRight(temp2);
					}
						else {
								for (int i = 0; i < row-2; i++)  {
									if (temp2.getNext() != null) {
										temp2 = temp2.getNext();
									}
								}
								if (row==61 || row==121 || row==181 || row==241 || row==301) {
									rowNumber++;
								}
								temp2.setRowNumber(rowNumber);     /////// we were here
								newnode.setPrev(temp2);
								newnode.setNext(temp2.getNext());
								if (temp2.getNext() != null) {
									temp2.getNext().setPrev(newnode);
								}
								else {
									rowTail = newnode;
								}
								temp2.setNext(newnode);
								temp2.getNext().setPosition(row);
//								while (temp2.getNext() != null) {
//									for (int i = 0; i < 10; i++) {
//										temp2.setPosition(row+i);
//									}
//									temp2 = temp2.getNext();
//								}
						}
							         
					}
					temp = temp.getDown();
				}
			}
			else if (!mode) {
				ColumnNode temp = head;																// ?
				while (temp != null)
				{
					if (line==temp.getLine()) {
						RowNode temp2 = temp.getRight();
						RowNode newnode = new RowNode(dataToAdd);
						if (temp2 == null) {
							temp2 = newnode;
							temp2.setPosition(row);
							temp.setRight(temp2);
						}
						else {
							for (int i = 0; i < row-2; i++)  {
								temp2 = temp2.getNext();
							}
							temp2.setNext(newnode);
							newnode.setPrev(temp2);
							temp2.getNext().setPosition(row);
							
						}			          
					}
					temp = temp.getDown();
				}
			}
		}
		
	public void delete(int px,int py, boolean isDel) {
		ColumnNode temp = head;
		while (temp != null)
		{
			if (py==temp.getLine()) {
				RowNode temp2 = temp.getRight();
				int a = 0;
				if(!isDel) {
					a = 3;
				}
				else {
					a = 2;
				}
				for (int i = 0; i < px-a; i++) {
					temp2 = temp2.getNext();
				}

				if (temp2.getNext() == null) {
					if(!isDel) {
						temp.setRight(null);
						temp2 = null;
					}
				}
				else if (temp2.getNext().getNext() != null) {
					temp2.setNext(temp2.getNext().getNext());
					temp2.getNext().setPrev(temp2);
				}
				else {
					if(!isDel) {
						temp2.setNext(null);
					}
					else {
						temp2.setPrev(null);
					}
					
				}
				
			}
			temp = temp.getDown();
			
		}
	}
	
	public int display(boolean mode, int header, int px, int py) {
		int count = 0;
		space = false;
        TextAttributes attrs = new TextAttributes(Color.WHITE, Color.BLACK);
        if (head == null)
            System.out.println("linked list is empty");
        else {
            ColumnNode temp = head;
            while (temp != null) {
                boolean oneShot = true;
                RowNode temp2 = temp.getRight();
                while (temp2 != null) {
                    boolean newline = false;
                    if (!temp2.getData().equals('+')) {
                    	if (oneShot && temp2.getPosition()%60 == 0 && !temp2.getData().equals('_') && !temp2.getData().equals('-')) {
                    		while(!temp2.getData().equals('_')) {
                    			temp2 = temp2.getPrev();
                    			count++;
                			}
                			//cnd.getTextWindow().setCursorPosition(temp2.getPosition()%60 + 1, py-1);
							for (int i = 1; i <= count; i++) {
								addRow(mode,temp2.getPosition() + i, header, '-');
								
							}
							System.out.println();
							System.out.print(" ");

							for (int j = 0; j <= count; j++) {
								temp2 = temp2.getNext();
							}
							RowNode temp3 = temp2;
							int k = temp2.getPosition();
							while(temp3 != null) {
								temp3.setPosition(k+count);
								temp3 = temp3.getNext();
								k++;
							}
							newline = true;
							oneShot = false;
							space = true;
                    	}
//                    	if (space == false && oneShot == false) {
//							delSpaces(py);
//						}
                		if (temp2.getData().equals('_') || temp2.getData().equals('-')) {
                            System.out.print(" ");
                            newline = false;
                        } else if (!temp2.getData().equals('_') && !temp2.getData().equals('-')) {
                            if (temp2.isSelected()) {
                                attrs = new TextAttributes(Color.BLACK, Color.WHITE);
                            } else {
                                attrs = new TextAttributes(Color.WHITE, Color.BLACK);
                            }
                            if (temp2.isSelected_next()) {
                            	attrs = new TextAttributes(Color.WHITE, Color.BLUE);
							}
                            cnd.getTextWindow().output((char) temp2.getData(), attrs);
                            newline = false;
                        }
//                    	else {
//                    		addRow(mode,temp2.getPosition(), header, "-");
//                    		System.out.print(" ");
//                    	}
                        if (temp2.getPosition()%60 == 0) {
                        	if (!newline) {
                              System.out.println();
                              System.out.print(" ");
                              newline = true;
                              //oneShot = false;
                          }
						}
                        
                    } else {
                        System.out.println();
                        System.out.print(" ");
                    }
                    temp2 = temp2.getNext();
                }
                temp = temp.getDown();
            }
        }
        return count;
    }
	private void delSpaces(int py) {
		ColumnNode temp = head;
		int row = 1;
		int size = 1;
		while(temp != null) {
				RowNode temp2 = temp.getRight();			////
				while (temp2 != null)
					{
					if (temp2.getData().equals('-')) {
						delete(row,size,false);
					}
					row++;
					temp2 = temp2.getNext();
					}
			}
			size++;
			temp = temp.getDown();	
	}

	public void arrPos(int px, int py) {	
		ColumnNode temp = head;
		int size = 0;
		while(temp != null) {
				if (py == temp.getLine()) {
					RowNode temp2 = temp.getRight();			////
					while (temp2 != null)
						{
						size++;
						temp2.setPosition(size);
						temp2 = temp2.getNext();
						}
				}
				temp = temp.getDown();
			}
	}
	public int findPos(int px, int py) {
		int pos = 0;
        ColumnNode temp = head;
        int row = 2;
        int column = 1;
        while (temp != null) {
            RowNode temp2 = temp.getRight();
            while (temp2 != null) {
                if (px == row && py == column) {
                	pos = temp2.getPosition();
                }
                temp2 = temp2.getNext();
                row++;
            }
            temp = temp.getDown();
            column++;
        }
        return pos;
	}
	
	public void select(int px, int py) {

        if (head == null)
            System.out.println("linked list is empty");
        else {
            ColumnNode temp = head;
            int column = 1;
            while (temp != null) {
            	int row = 1;
                RowNode temp2 = temp.getRight();
                while (temp2 != null) {
                    if (px == row && py == column) {

                        temp2.setSelected(true);
                    }
                    temp2 = temp2.getNext();
                    row++;

                }
                temp = temp.getDown();
                column++;
            }
        }

    }
	public void update_select() {

        if (head == null)
            System.out.println("linked list is empty");
        else {
            ColumnNode temp = head;
            while (temp != null) {
                RowNode temp2 = temp.getRight();
                while (temp2 != null) {
                    

                        temp2.setSelected(false);
                    
                    temp2 = temp2.getNext();
                    

                }
                temp = temp.getDown();
                
            }
        }

    }
	public String copy() {
		String copied="";
		
		if (head == null)    
			System.out.println("linked list is empty");
		else {
			ColumnNode temp = head;
			while (temp != null)
			{
				int cont = 61;
				RowNode temp2 = temp.getRight();
				while (temp2 != null)
				{
					int control = cont - temp2.getPosition()%61;
					boolean newline = false;
					if(!temp2.getData().equals('+')) {
						if (temp2.getData().equals('_') && control < 61) {
							
							newline = false;
						}
						else if(!temp2.getData().equals('_') && control < 61) {
							if (temp2.isSelected()) {
								copied+=temp2.getData();
								}

							newline = false;
						}
						else if(!temp2.getData().equals('_') && (control == 61 || control == 121 || control >= 181|| control >= 241|| control >= 301 )){
							if(!newline) {
								
								newline = true;
							}
							if (temp2.isSelected()) {
								copied+=temp2.getData();
							}
							
						}
					}
					
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
			}
		}
		return copied;
	}
	 public void find(Object data)
	    {
		 	String word = "";
		 	boolean isLetter = true;
		 	int len = data.toString().length();
		 	char ch = data.toString().charAt(0);
	        ColumnNode temp = head;
            while (temp != null) {
                RowNode temp2 = temp.getRight();
                while (temp2 != null) {
                	if (temp2.getData().equals(data.toString().charAt(0))) {
                		word += ch;
                		temp2.setSelected(true);
    	                	for (int i = 1; i < len; i++) {
    	                		isLetter = false;
        	                	temp2 = temp2.getNext();
        	                	if (temp2!=null && !temp2.getData().equals(data.toString().charAt(i))) {
        	                		temp2.getPrev().setSelected(false);
        	                		break;
								}
        	                	else {
        	                		word = word + data.toString().charAt(i);
        	                		if (temp2 != null) {
        	                			temp2.setSelected(true);
									}
        	                	}
        					}
    	            }
                	if (temp2 != null) {
                		temp2 = temp2.getNext();
					}
                    word = "";
                }
                temp = temp.getDown();
            }
	    }
	
	 
	 public int[] replace() {
	        int start_px = 0;
	        int start_py = 0;
	        int end_px = 0;
	        int end_py = 0;
	        boolean first_step_start=true;
	        boolean first_step_end=true;
	        int[] items=new int[100];
	        ColumnNode temp = head;
	        int column = 1;
	        int count=0;
	        while (temp != null) {
	            int row = 1;
	            RowNode temp2 = temp.getRight();
	            while (temp2 != null) {
	                if (temp2.isSelected()) {
	                    if (first_step_start) {
	                        start_px=row;
	                        start_py=column;
	                        first_step_start=false;
	                        items[count]=start_px;
	                        count++;
	                        items[count]=start_py;
	                        count++;
	                    } else {
	                        if (first_step_end) {
	                            end_px=row;
	                            end_py=column;
	                            items[count]=end_px;
	                            count++;
	                            items[count]=end_py;
	                            count++;
	                            first_step_end=false;
	                        } else {
	                            count-=2;
	                            end_px=row;
	                            end_py=column;
	                            items[count]=end_px;
	                            count++;
	                            items[count]=end_py;
	                            count++;
	                        }
	                    }
	                }else {
	                    first_step_start=true;
	                    first_step_end=true;
	                }
	                    //temp2.setSelected(false);
	                row++;
	                temp2 = temp2.getNext();
	                

	            }
	            temp = temp.getDown();
	            column++;
	        }
	        //int[] items=new int[] {start_px,start_py,end_px,end_py};
	        return items;
	    }
	 
	public void addFile(int row , int line ,Object dataToAdd) {
			if (head == null)    
				System.out.println("Add a Category before Item");
			else {
				ColumnNode temp = head;
				while (temp != null)
				{	    	 
					if (line==temp.getLine()) {
						RowNode temp2 = temp.getRight();
						RowNode newnode = new RowNode(dataToAdd);
						
						if (temp2 == null) {
							temp2 = newnode;
							temp.setRight(temp2);
						}
						else {	 
							for (int i = 1; i < row - 1; i++) {
								temp2 = temp2.getNext();
							}
							temp2.setNext(newnode);
							newnode.setPrev(temp2);
						}			          
					}
					temp = temp.getDown();
				}
			}
		}

	public int rowFinder(int px, int py) {
		 ColumnNode temp = head;
         while (temp != null) {
             RowNode temp2 = temp.getRight();
             while (temp2 != null) {
            	if (px + ((py-1)*60) == temp2.getPosition()) {
            			//int multy = (int)Math.floor(px/60);
            			px = px + ((py-1)*60);
     	                return px;
					}
            	else {
            	}
                 temp2 = temp2.getNext();
             }
             temp = temp.getDown();
         }
		return px;
	}

//	public void justified() {
//		ColumnNode temp = head;
//        while (temp != null) {
//        	RowNode temp2 = temp.getRight();
//        	//boyut    
//        }
//	}
	public void update_selected_next() {

        if (head == null)
            System.out.println("linked list is empty");
        else {
            ColumnNode temp = head;
            
            while (temp != null) {
                RowNode temp2 = temp.getRight();
                while (temp2 != null) {
                    

                        temp2.setSelected_next(false);
                    
                    temp2 = temp2.getNext();
                    

                }
                temp = temp.getDown();
                
            }
        }

    }
	public void next(int order) {

		boolean first_step_start = true;
		boolean first_step_end = true;

		ColumnNode temp = head;
		int count = 1;
		while (temp != null) {
			RowNode temp2 = temp.getRight();
			while (temp2 != null) {
				if (temp2.isSelected()) {
					if (first_step_start) {

						if (count == order) {
							temp2.setSelected_next(true);
						}
						first_step_start = false;
						count++;

					} else {
						if (first_step_end) {
							if (count == order+1) {
								temp2.setSelected_next(true);
							}
							first_step_end = false;
						} else {
							if (count == order+1) {
								temp2.setSelected_next(true);
							}
						}

					}

				} else {
					first_step_start = true;
					first_step_end = true;
				}

				temp2 = temp2.getNext();

			}
			temp = temp.getDown();

		}
	}

	public void justified() {
		TextAttributes attrs = new TextAttributes(Color.WHITE, Color.BLACK);
		if (head == null)
			System.out.println("linked list is empty");
		else {
			ColumnNode temp = head;
			while (temp != null) {
				int cont = 61;
				RowNode temp2 = temp.getRight();
				int letterCounter = 0;
				int spaceCounter = 0;
				while (temp2 != null) {

					int control = cont - temp2.getPosition() % 61;
					boolean newline = false;
					if (!temp2.getData().equals('+')) {
						if (temp2.getData().equals('_') && control < 61) {
							spaceCounter++;
							newline = false;
						} else if (!temp2.getData().equals('_') && control < 61) {

							
							letterCounter++;

							newline = false;
						} else if (!temp2.getData().equals('_') && (control == 61 || control == 121 || control >= 181
								|| control >= 241 || control >= 301)) {
							if (!newline) {

								newline = true;
							}
							letterCounter++;

						}
					} else {

					}
					temp2 = temp2.getNext();
				}
				// -------------
				int unused = 60 - letterCounter;
				double per_space = unused / (spaceCounter);

				int cont_ = 61;
				RowNode temp2_ = temp.getRight();
				while (temp2_ != null) {

					int control_ = cont_ - temp2_.getPosition() % 61;
					boolean newline_ = false;
					if (!temp2_.getData().equals('+')) {
						if (temp2_.getData().equals('_') && control_ < 61) {
							for (int i = 0; i < per_space; i++) {//--
								System.out.print(" ");
							}

							newline_ = false;
						} else if (!temp2_.getData().equals('_') && control_ < 61) {
							if (temp2_.isSelected()) {
								attrs = new TextAttributes(Color.BLACK, Color.WHITE);
							} else {
								attrs = new TextAttributes(Color.WHITE, Color.BLACK);
							}
							if (temp2_.isSelected_next()) {
								attrs = new TextAttributes(Color.WHITE, Color.BLUE);
							}
							cnd.getTextWindow().output((char) temp2_.getData(), attrs);

							newline_ = false;
						} else if (!temp2_.getData().equals('_') && (control_ == 61 || control_ == 121
								|| control_ >= 181 || control_ >= 241 || control_ >= 301)) {
							if (!newline_) {
								System.out.println();
								System.out.print(" ");
								newline_ = true;
							}

							if (temp2_.isSelected()) {
								attrs = new TextAttributes(Color.BLACK, Color.WHITE);
							} else {
								attrs = new TextAttributes(Color.WHITE, Color.BLACK);
							}
							if (temp2_.isSelected_next()) {
								attrs = new TextAttributes(Color.BLUE, Color.WHITE);
							}
							cnd.getTextWindow().output((char) temp2_.getData(), attrs);
						}
					} else {
						System.out.println();
						System.out.print(" ");
					}

					temp2_ = temp2_.getNext();
				}
				temp = temp.getDown();
			}
		}
	}

}
