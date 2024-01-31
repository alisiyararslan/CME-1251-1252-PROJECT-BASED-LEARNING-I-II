import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import enigma.console.TextAttributes;
import java.awt.Color;


public class Game {
   public enigma.console.Console cn = Enigma.getConsole("Keyboard Mouse 2",100,30,20,2); // col,row,fontsize,fonttype
   public enigma.console.TextWindow cnt = cn.getTextWindow();
   public static TextAttributes att0 = new TextAttributes(Color.white, Color.black);  //foreground, background color
   public static TextAttributes att1 = new TextAttributes(Color.black, Color.white);
   public TextMouseListener tmlis; 
   public KeyListener klis; 

   static MultiLinkedList mll = new MultiLinkedList();
   static MultiLinkedList mll_justified = new MultiLinkedList();
   
   // ------ Standard variables for keyboard and mouse 2 --------------------------
   public int mousepr;          // mouse pressed?
   public int mousex, mousey;   // mouse text coords.
   public int keypr;   // key pressed?
   public int rkey;    // key   (for press/release)
   public int rkeymod;      // key modifiers
   public int capslock=0;   // 0:off    1:on
   // -----------------------------------------------------------------------------
   
   
   Game() throws Exception {   // --- Contructor
                 
      // ------ Standard code for keyboard and mouse 2 -------- Do not change -----
//      tmlis=new TextMouseListener() {
//         public void mouseClicked(TextMouseEvent arg0) {}
//         public void mousePressed(TextMouseEvent arg0) {
//            if(mousepr==0) {
//               mousepr=1;
//               mousex=arg0.getX();
//               mousey=arg0.getY();
//            }
//         }
//         public void mouseReleased(TextMouseEvent arg0) {}
//      };
//      cn.getTextWindow().addTextMouseListener(tmlis);
    
      klis=new KeyListener() {
         public void keyTyped(KeyEvent e) {}
         public void keyPressed(KeyEvent e) {
            if(keypr==0) {
               keypr=1;
               rkey=e.getKeyCode();
               rkeymod=e.getModifiersEx();
               if(rkey == KeyEvent.VK_CAPS_LOCK) {
                 if(capslock==0) capslock=1;
                 else capslock=0;
               }
            }
         }
         public void keyReleased(KeyEvent e) {}
      };
      cn.getTextWindow().addKeyListener(klis);
      // --------------------------------------------------------------------------
      
      int curtype;
      curtype=cnt.getCursorType();   // default:2 (invisible)       0-1:visible
      cnt.setCursorType(1);
      cn.setTextAttributes(att0);
      boolean mode = true;
      /*
      // console clear (white background)
      cn.setTextAttributes(att1);
      for(int x=0; x<100*30-1; x++) {
        System.out.print(" ");
      }
      */
      
      int px=1 ,py=1;
      
      System.out.print(' ');
      TextAttributes attrs = new TextAttributes(Color.WHITE, Color.BLUE);
	  TextAttributes attrs2 = new TextAttributes(Color.WHITE, Color.BLACK);
	  mll.addColumn(py,"*");
	  int header = 1;
	  int row = 1;
	  int start_px = 0;
      int start_py = 0;
      int end_px = 0;
      int end_py = 0;
      int[] pos = new int[20];
      int line = 1;
      pos[0] = 0;
      pos[line] = 1;
      int[] head = new int[20];
      head[py] = header;
      boolean keyPressed= false;
      String copied = null;
      boolean justified = false;
      boolean alignLeft = true;
      int count_next = 0;//--
      //--- main game loop ---
      while(true) {
    	 cnt.setCursorPosition(px, py);
    	 boolean cut = false;
         if(mousepr==1) {  // if mouse button pressed
            cn.getTextWindow().output(mousex,mousey,'#');  // write a char to x,y position without changing cursor position
            px=mousex; py=mousey;
            mousepr=0;     // last action
         }
         if(keypr==1) {    // if keyboard button pressed
            if(rkey == KeyEvent.VK_LEFT && px > 1) {
            	px--;
            	row = px;
            	keyPressed = true;
            }
            
            if(rkey == KeyEvent.VK_RIGHT && px < 60) {
            	if (pos[py] > px) {       // if true, return a number between 0-60
            		px++;
				}
            	row = px;
            	keyPressed = true;
            }
            
            if(rkey == KeyEvent.VK_UP && py > 1) {
            	py--;
            	if (px > pos[py]) {
            		px = pos[py] + 1;
				}
            	row = px;
            	keyPressed = true;
            }
            
            if(rkey == KeyEvent.VK_DOWN && py < 20) {
            	if (pos[py + 1] > 0) {
            		py++;
				}
            	if (px > pos[py]+1) {
            		px = pos[py];
				}
            	row = px;
            	keyPressed = true;
            }
            
            char rckey=(char)rkey;
            cnt.setCursorPosition(px, py);
            //cn.getTextWindow().output("",attrs);
            //        left          right          up            down
            if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='(') {    // test without using VK (Virtual Keycode)
              cn.getTextWindow().setCursorPosition(px, py);
            }
            else {
            	if (rkey == KeyEvent.VK_INSERT) {
            		if(mode == false) {
            			cnt.setCursorType(1);
            			cn.getTextWindow().setCursorPosition(px, py);
            			cn.getTextWindow().output(" "); 
            			mode = true;
            		}
            		else {
            			cnt.setCursorType(2);									    //overwrite mode
            			cn.getTextWindow().setCursorPosition(px, py);
            			cn.getTextWindow().output(" ", attrs);    					//////////////////
            			mode = false;
            		}
				}
              if(rckey>='0' && rckey<='9') {
            	  char data = (char)rckey;
                 	addData(data,row,head[py],mode);
                 	row++;
                 	px++;
              }
              if(rckey>='A' && rckey<='Z') {
  				boolean swtch = false;
				if(((rkeymod & KeyEvent.SHIFT_DOWN_MASK) > 0) || capslock==1) {
                	char data = (char)rckey;
                   	addData(data,row,head[py],mode);
                   	row++;
                }
                else {
                	row = mll.rowFinder(row,py);
                	char data = (char)(rckey+32);
                	addData(data,row,head[py],mode);
                	row++;
                }
                px++;
                pos[line] = px;
                if (px > 60) {
					System.out.println();
					px = 1;
					py++;
					head[py] = header;
					line++;
				}
                //mll.arrPos(px,py);                                //////////// check it
                if (swtch) {
                keyPressed = false;
				}
               
              }
              if((rkeymod & KeyEvent.SHIFT_DOWN_MASK) == 0) {
                if(rckey=='.' || rckey==',' || rckey=='-') System.out.print(rckey);
              }
              else {
                if(rckey=='.') System.out.print(':');
                if(rckey==',') System.out.print(';');
              }
            }
			if (rkey == KeyEvent.VK_ENTER && py < 20) {
				addData('+', row, head[py], mode);
				row = 1;
				header++;
				line++;
				py++;
				px = 1;
				head[py] = header;
			}
			
            if(rkey==KeyEvent.VK_SPACE) {
            	addData('_', row, head[py], mode);
            	row++;
                px++;
                pos[line] = px;
            }
            if (rkey==KeyEvent.VK_F11) {				// load op
            	cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("Your File is Opening...");
            	Thread.sleep(500);
            	cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("                       ");
            	mll = removeMll();
            	FileOpen();
			}
            if (rkey == KeyEvent.VK_F12) {				// save op
            	cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("File Successfully Saved");
            	Thread.sleep(500);
            	cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("                       ");
				fileSave(mll);
			}
            boolean isDel;
            if (rkey==KeyEvent.VK_BACK_SPACE && px > 1) {
            	isDel = false;
            	mll.delete(row, head[py], isDel);
            	if (px > 1) {
            		px--;
            		pos[line] = px;
				}
            	if (row >=1) {
					row--;
				}
            	for (int i = 0; i < 2; i++) {
            		cn.getTextWindow().output(px + i , py, ' ');
				}
			}
            if (rkey==KeyEvent.VK_DELETE ) {
            	isDel = true;
            	mll.delete(px, py, isDel);
            	for (int i = 0; i < rowSize(py,false); i++) {
            		cn.getTextWindow().output(px + i , py, ' ');
				}
            	pos[line] = px;
			}
            
            if (rkey==KeyEvent.VK_HOME) {
            	px = 1;
            	cn.getTextWindow().setCursorPosition(px,py);
			}
            if (rkey==KeyEvent.VK_END) {
            	px = rowSize(header,true) + 1;
            	if(px > 61) {
            		px = 61;
            	}
            	cn.getTextWindow().setCursorPosition(px,py);
			}
            if (rkey==KeyEvent.VK_PAGE_UP) {
				px = 1;
				py = 1;
				cn.getTextWindow().setCursorPosition(px,py);
			}
            if (rkey==KeyEvent.VK_PAGE_DOWN) {
            	px = 1;
				py = columnSize(py);
				cn.getTextWindow().setCursorPosition(px,py);
			}
            if (rkey == KeyEvent.VK_F1) {
            	mll.update_select();
                start_px = px;
                start_py = py;
            }
            
            if (rkey == KeyEvent.VK_F2) {
                end_px = px;
                end_py = py;

                for (int i = start_py; i <= end_py; i++) {
                    if (start_py == end_py) {
                        for (int j = start_px; j < end_px; j++) {
                            mll.select(j, i);
                        }
                    } else {
                        if (i == start_py) {
                            for (int j = start_px; j < rowSize(i,false); j++) {
                                mll.select(j, i);
                            }
                        } else if (i == end_py) {
                            for (int j = 0; j < rowSize(i,false); j++) {
                                mll.select(j, i);
                            }
                        } else {
                            for (int j = 0; j < end_py; j++) {
                                mll.select(j, i);
                            }
                        }
                    }
                }
            }
            
			if (rkey == KeyEvent.VK_F3) {// cut
				copied=null;
				copied = mll.copy();
				for (int i = 0; i < copied.length(); i++) {
					mll.delete(px, py, false);
					if (px > 1) {
						px--;
					}
					for (int j = 0; j < rowSize(py,false); j++) {
						cn.getTextWindow().output(px + j, py, ' ');
					}
				}
				cut = true;
				// mll.update_select();
			}
			if (rkey == KeyEvent.VK_F4) {// copy
				copied = null;
				copied = mll.copy();
				// mll.update_select();
				cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("Copied");
            	Thread.sleep(500);
            	cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("      ");

			}

			if (copied != "" && rkey == KeyEvent.VK_F5) {// paste
				if (copied != null) {
					for (int i = 0; i < copied.length(); i++) {
						addData(copied.charAt(i), px, head[py], true);
						px++;
						pos[line] = px;
					}
				}
			}
				//copied = null;
			if (rkey == KeyEvent.VK_F6) {// find
				cn.getTextWindow().setCursorPosition(63,17);
				System.out.print("Write the word to find: ");
				Scanner sc = new Scanner(System.in);
				String dataToFind = sc.next();
				mll.find(dataToFind);
				Thread.sleep(500);
				cn.getTextWindow().setCursorPosition(63,17);
				System.out.print("                                            ");
				}
			
			if (rkey == KeyEvent.VK_F7) {
                cn.getTextWindow().setCursorPosition(63,19);
                System.out.print("Write the word to replace: ");
                int length=0;
                for (int i = 0; i < mll.replace().length; i++) {
                    if (mll.replace()[i]!=0) {
                        length++;
                    }
                }
                Scanner sc = new Scanner(System.in);
                String dataToReplace = sc.next();
                for (int k = 0; k < length/4; k++) {//length/4+1
                    int start_px_ = mll.replace()[0];
                    int start_py_ = mll.replace()[1];
                    int end_px_ = mll.replace()[2];
                    int end_py_ = mll.replace()[3];
                    int temp_start_px_=start_px_;
                    int temp_end_px__=end_px_;
                    for (int i = 0; i <= temp_end_px__-temp_start_px_; i++) {//del
                        mll.delete(end_px_+1, start_py_, false);
                        if (end_px_ > 1) {
                            end_px_--;
                        }
                        for (int j = 0; j < rowSize(start_py_,false); j++) {
                            cn.getTextWindow().output(start_px_ + j, start_py_, ' ');
                        }
                    }
                    
                    for (int i = 0; i < dataToReplace.length(); i++) {//paste
                        addData(dataToReplace.charAt(i), temp_start_px_, start_py_, true);
                        temp_start_px_++;
                        pos[line] = temp_start_px_;
                    }
                }
                for (int i = 0; i < 20; i++) {
					for (int j = 0; j < 60; j++) {
						System.out.print(" ");
					}
					System.out.println();
				}
            }
			if (rkey == KeyEvent.VK_F8) {// next
				int length = 0;
				for (int i = 0; i < mll.replace().length; i++) {
					if (mll.replace()[i] != 0) {
						length++;
					}
				}
				if (count_next - 1 == length / 4) {
					count_next = 1;
				}
				mll.update_selected_next();
				mll.next(count_next);
				count_next++;

			}
			if(rkey == KeyEvent.VK_F9) {
				alignLeft=true;
				justified=false;
			}
			if(rkey == KeyEvent.VK_F10) {
				justified=true;
				alignLeft=false;
			}
			if(rkey == KeyEvent.VK_ESCAPE) {
				mll.update_select();
			}
            keypr=0;    // last action  
         }
         Thread.sleep(20);
         int x = px;
         int y = py;
         //cn.getTextWindow().setCursorPosition(px - 1, py);
         cn.getTextWindow().setCursorPosition(1,1);
         cn.getTextWindow().output("  ");
         cn.getTextWindow().setCursorPosition(1,1);
         if (justified) {
        	 //		mll = mll_just
		}
         else {
        	 //   	 mll = mll_left
         }
         //mll.arrPos(px,py);
         if(mll.getHead() != null) {
        	 if (justified) {
            	 //		mll = mll_just
        		 //row = row + mll.justified(mode,head[py],row,y);
        		 cn.getTextWindow().setCursorPosition(0,0);
        		 System.out.println("                                                                                \r\n"
        		 		+ "                                                                \r\n"
        		 		+ "                                                                         \r\n"
        		 		+ "                                                                        \r\n"
        		 		+ "                                                                       \r\n"
        		 		+ "                                                                  \r\n"
        		 		+ "                                                                     \r\n"
        		 		+ "                                                                      \r\n"
        		 		+ "                                                                  \r\n"
        		 		+ "                                                                    \r\n"
        		 		+ "                                                                    \r\n"
        		 		+ "                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                              \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "");
        		 cn.getTextWindow().setCursorPosition(1,1);
        		 mll.justified();
        		 justified=false;
    		}
             else if(alignLeft){
            	 //   	 mll = mll_left
            	 cn.getTextWindow().setCursorPosition(0,0);
        		 System.out.println("                                                                                \r\n"
        		 		+ "                                                                \r\n"
        		 		+ "                                                                         \r\n"
        		 		+ "                                                                        \r\n"
        		 		+ "                                                                       \r\n"
        		 		+ "                                                                  \r\n"
        		 		+ "                                                                     \r\n"
        		 		+ "                                                                      \r\n"
        		 		+ "                                                                  \r\n"
        		 		+ "                                                                    \r\n"
        		 		+ "                                                                    \r\n"
        		 		+ "                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                              \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "                                                                                \r\n"
        		 		+ "");
        		 cn.getTextWindow().setCursorPosition(1,1);
            	 row = row + mll.display(mode,head[py],row,y);
             }
        	 
        	 //px = row%60;
         }
         if (cut) {
				cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("Cut");
            	Thread.sleep(800);
            	cn.getTextWindow().setCursorPosition(63, 17);
            	System.out.print("    ");
		}
         showScreen(mode);
      } //end of game loop
      
   }


   
private MultiLinkedList removeMll() {
	MultiLinkedList mll2 = new MultiLinkedList();
	return mll2;
	
}

private int columnSize(int y) {
	ColumnNode temp = mll.getHead();
	int size = 0;
	while(temp != null) {
		size++;
		temp = temp.getDown();
	}
	return size;
}

public int rowSize(int y, boolean key) {				// if key true return number 0-60
	ColumnNode temp = mll.getHead();
	int size = 0;
	while(temp != null) {
		if (y == temp.getLine()) {
			RowNode temp2 = temp.getRight();
			while (temp2 != null)
				{
				size++;
				temp2 = temp2.getNext();
				}
		}
		temp = temp.getDown();
	}
	if (key) {
		size = size%60;
		return size;
	}
	else{
		return size;
	}
}



public void addData(char data,int px, int py, boolean mode) {
	if (mode) {
		if (isEnter(data)) {
			mll.addColumn(py + 1 ,"*");
			mll.addRow(mode,px, py, data);
		}
		ColumnNode temp = mll.getHead();
		while(temp != null) {
			if (py == temp.getLine() && temp.getData() == null) {
				temp.setData(' ');
			}
			temp = temp.getDown();
		}
		if (!isEnter(data)) {
			mll.addRow(mode,px, py, data);
		}
	}
	else {
		if (isEnter(data)) {
			mll.addColumn(py + 1 ,"*");
			mll.addRow(mode,px, py, data);
		}
		ColumnNode temp = mll.getHead();
		while(temp != null) {
			if (py == temp.getLine() && temp.getData() == null) {
				temp.setData(' ');
			}
			temp = temp.getDown();
		}
		if (!isEnter(data)) {
			mll.addRow(mode,px, py, data);
		}
	}
}
private boolean isEnter(char data) {
	if (data == '+') {
		return true;		
	}
	return false;
	
}
private void showScreen(boolean mode) {
	cn.getTextWindow().setCursorPosition(63, 0);
	System.out.print("F1:Selection start");
	cn.getTextWindow().setCursorPosition(63, 1);
	System.out.print("F2:Selection end");
	cn.getTextWindow().setCursorPosition(63, 2);
	System.out.print("F3:Cut");
	cn.getTextWindow().setCursorPosition(63, 3);
	System.out.print("F4:Copy");
	cn.getTextWindow().setCursorPosition(63, 4);
	System.out.print("F5:Paste");
	cn.getTextWindow().setCursorPosition(63, 5);
	System.out.print("F6:Find");
	cn.getTextWindow().setCursorPosition(63, 6);
	System.out.print("F7:Replace");
	cn.getTextWindow().setCursorPosition(63, 7);
	System.out.print("F8:Next");
	cn.getTextWindow().setCursorPosition(63, 8);
	System.out.print("F9:Align left");
	cn.getTextWindow().setCursorPosition(63, 9);
	System.out.print("F10:Justify");
	cn.getTextWindow().setCursorPosition(63, 10);
	System.out.print("F11:Load");
	cn.getTextWindow().setCursorPosition(63, 11);
	System.out.print("F12:Save");
	if (mode) {
		cn.getTextWindow().setCursorPosition(63, 13);
		System.out.print("Mode:Insert   ");
	}
	else {
		cn.getTextWindow().setCursorPosition(63, 13);
		System.out.print("Mode:Overwrite");
	}
	
	cn.getTextWindow().setCursorPosition(63, 15);
	System.out.print("Alignment:Justified");
	cn.getTextWindow().setCursorPosition(0, 0);
	System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----++");
	for (int i = 0; i <= 20; i++) {
		if (i % 5 == 0) {
			cn.getTextWindow().output(0, i, '+');
			cn.getTextWindow().output(61, i, '+');
		} else {
			cn.getTextWindow().output(0, i, '|');
			cn.getTextWindow().output(61, i, '|');
		}
	}
	cn.getTextWindow().setCursorPosition(0, 21);
	System.out.println("+----+----+----+----+----+----+----+----+----+----+----+----++");
	
}

public void FileOpen() {
	mll.addColumn(1,"*");
	String filename = "D:\\text.txt";
	try {
		File text = new File(filename);
		boolean mode = true;
		int colNo = 1;
		int rowNo;
		Scanner sc = new Scanner(text);
		while (sc.hasNextLine()) {
			rowNo = 1;
			String word = sc.nextLine();
			for (int i = 0; i < word.length() + 1; i++) {
				if (i == word.length()) {
					addData('+',rowNo,colNo,mode);
				}
				else {
					addData(word.charAt(i),rowNo,colNo,mode);  //char data,int px, int py, boolean mode
				}
				rowNo++;
			}
			colNo++;
		}
		sc.close();
	} catch (FileNotFoundException e) {
		System.out.println("File not found");
	}
	 catch (NoSuchElementException e) {
			System.out.println("word not found");
	}
	
}
private void fileSave(MultiLinkedList mll) {
	String filename = "D:\\text.txt";
	ColumnNode temp = mll.getHead();
	try {
		FileWriter writeto_file = new FileWriter(filename);
		while(temp != null) {
			String letter = null;
			if (temp.getData().toString().equals("_")) {
				letter = " ";
			}
			else if (temp.getData().toString().equals("+")) {
				letter = "\n";
			}
			else if (temp.getData().toString().equals("*")) {
				letter = "";
			}
			else {
				letter = temp.getData().toString();
			}
			
			writeto_file.write(letter);
			RowNode temp2 = temp.getRight();
			while (temp2 != null)
				{
				if (temp2.getData().toString().equals("_")) {
					letter = " ";
				}
				else if (temp2.getData().toString().equals("+")) {
					letter = "\n";
				}
				else if (temp2.getData().toString().equals("*")) {
					letter = "";
				}
				else {
					letter = temp2.getData().toString();
				}
				writeto_file.write(letter);
				temp2 = temp2.getNext();
				}
			//writeto_file.write("\n");
			temp = temp.getDown();
			
		}
		writeto_file.close();
    }
	catch (IOException e) {
		System.out.println("Error!: Write error to file.");
		e.printStackTrace();
    }
	
}
}
