
import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import enigma.console.TextAttributes;
import java.awt.Color;

public class Game {
	public static enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
	public TextMouseListener tmlis;
	public KeyListener klis;
	private static int score = 0;
	private static int _human = 5;
	private static Point human;

	private static String seconds;

	// ------ Standard variables for mouse and keyboard ------
	public int mousepr; // mouse pressed?
	public int mousex, mousey; // mouse text coords.
	public int keypr; // key pressed?
	public int rkey; // key (for press/release)
	// ----------------------------------------------------

	// Oyun boardunu ekrana yazdï¿½rï¿½r
	public static void displayBoard(Point[][] gameBoard) {
		cn.getTextWindow().setCursorPosition(0, 0);
		for (int row = 0; row < gameBoard.length; row++) { // rows
			for (int j = 0; j < gameBoard[row].length; j++) { // columns
				if (gameBoard[row][j] != null) {
					if (gameBoard[row][j].getScore() == -1) { // display # for walls
						TextAttributes attrs = new TextAttributes(Color.CYAN, Color.BLACK); // Changes the colorS of
																							// foreground,background
						cn.setTextAttributes(attrs);
						System.out.print("#");
					} else if (gameBoard[row][j].getScore() == 0) { // display empty spaces
						System.out.print(" ");
					} else if (gameBoard[row][j].getColor().equalsIgnoreCase("blue")) { // human
						TextAttributes a = new TextAttributes(Color.BLUE, Color.BLACK);
						cn.setTextAttributes(a);
						System.out.print(gameBoard[row][j].getScore());

					} else { // display numbers
						// BURADA DA NOKTANIN RENGï¿½NE Gï¿½RE RENKLENDï¿½RME YAPILACAK
						if (gameBoard[row][j].getScore() <= 3) {
							TextAttributes a = new TextAttributes(Color.GREEN, Color.BLACK);
							cn.setTextAttributes(a);
							System.out.print(gameBoard[row][j].getScore());
						} else if (gameBoard[row][j].getScore() <= 6) {
							TextAttributes a = new TextAttributes(Color.YELLOW, Color.BLACK);
							cn.setTextAttributes(a);
							System.out.print(gameBoard[row][j].getScore());

						} else {
							TextAttributes a = new TextAttributes(Color.RED, Color.BLACK);
							cn.setTextAttributes(a);
							System.out.print(gameBoard[row][j].getScore());

						}
					}

					// System.out.print(gameBoard[row][j]);
				}
				TextAttributes attrs = new TextAttributes(Color.WHITE, Color.BLACK); // Changes the colorS of
																						// foreground,background
				cn.setTextAttributes(attrs);
			}
			System.out.println(); // alt satï¿½ra geï¿½
		}
		TextAttributes attrs = new TextAttributes(Color.WHITE, Color.BLACK); // Changes the colorS of
																				// foreground,background
		cn.setTextAttributes(attrs);
	}

	// ************
	public static void printQueue(CircularQueue q) {
		for (int i = 0; i < q.size(); i++) {
			if (i < 11)
				System.out.print(q.peek());
			q.enqueue(q.dequeue());
		}
	}

	public static void addRandomNumberQueue(CircularQueue q) {
		Random rnd = new Random();
		int GenerationProbability = rnd.nextInt(100) + 1;

		if (GenerationProbability <= 75) {
			q.enqueue(rnd.nextInt(3) + 1);
		} else if (GenerationProbability <= 95) {
			q.enqueue(rnd.nextInt(3) + 4);
		} else {
			q.enqueue(rnd.nextInt(4) + 6);
		}
	}

	// Parametre olarak queue gelebilir buna ilerde
	public static void displayInput(CircularQueue q) { // saï¿½ ï¿½stteki sayï¿½lar queue gï¿½sterir//
		cn.getTextWindow().setCursorPosition(60, 0); // Sï¿½TUN VE SATIR OLARAK KOORDï¿½NAT
		System.out.print("Input");
		cn.getTextWindow().setCursorPosition(60, 1);
		System.out.print("<<<<<<<<<<");
		cn.getTextWindow().setCursorPosition(60, 2);
		printQueue(q);
		cn.getTextWindow().setCursorPosition(60, 3);
		System.out.print("<<<<<<<<<<");
		cn.getTextWindow().setCursorPosition(0, 0);
	}

	// ***********************

	// Parametre olarak stackler (right and left) gelebilir buna ilerde
	public void displayBackpacks() {
		cn.getTextWindow().setCursorPosition(60, 5);
		System.out.print("Backpacks");
		for (int i = 0; i < 8; i++) {
			cn.getTextWindow().setCursorPosition(60, 6 + i);
			System.out.print("|   |   |   |");
		}

		cn.getTextWindow().setCursorPosition(60, 14);
		System.out.print("+---+   +---+");
		cn.getTextWindow().setCursorPosition(60, 15);
		System.out.print("Left    Right");
		cn.getTextWindow().setCursorPosition(60, 16);
		System.out.print("  Q       W");

	}

	public static void PrintBackpacks(Stack backpack1, Stack backpack2) {
		int row = 14 - backpack1.size(); // -1 gelcek sanki
		Stack temp = new Stack(10);
		while (!backpack1.isEmpty()) {
			cn.getTextWindow().setCursorPosition(62, row);
			System.out.print(backpack1.peek());
			temp.push(backpack1.pop());
			row++;
		}
		while (!temp.isEmpty())
			backpack1.push(temp.pop());

		row = 14 - backpack2.size(); // -1 gelcek sanki
		while (!backpack2.isEmpty()) {
			cn.getTextWindow().setCursorPosition(70, row);
			System.out.print(backpack2.peek());
			temp.push(backpack2.pop());
			row++;
		}
		while (!temp.isEmpty())
			backpack2.push(temp.pop());
	}

	public static void ClearBackpacks(Stack backpack1, Stack backpack2) {
		int row = 6;
		while (row != 14) {
			cn.getTextWindow().setCursorPosition(62, row);
			System.out.print(" ");
			cn.getTextWindow().setCursorPosition(70, row);
			System.out.print(" ");
			row++;
		}
	}

	public static void AlwaysWorkParts(Point[][] gameBoard, CircularQueue InputList, Stack backpack1, Stack backpack2)
			throws InterruptedException {
		cn.getTextWindow().setCursorPosition(0, 0);
		Random rnd = new Random();
		Stack temp_backpack1 = new Stack(8);
		Stack temp_backpack2 = new Stack(8);

		String minutes;
		String write;
		long start = System.currentTimeMillis();
		while (true) {
			Thread.sleep(1000);// StopWaych
			long time = System.currentTimeMillis() - start;
			time = time / 1000;
			seconds = Integer.toString((int) time % 60);
			minutes = Integer.toString((int) time % 3600 / 60);
			if (seconds.length() < 2)
				seconds = "0" + seconds;
			if (minutes.length() < 2)
				minutes = "0" + minutes;
			write = minutes + ":" + seconds;
			cn.getTextWindow().setCursorPosition(60, 20);
			System.out.print("Time: " + write);

			if (Integer.parseInt(seconds) % 5 == 0) {
				while (true) { // RandomNumbers
					int row = rnd.nextInt(gameBoard.length);
					int column = rnd.nextInt(gameBoard[1].length);
					if (gameBoard[row][column].getScore() == 0) {
						Point nPoint = new Point(row, column, (Integer) InputList.dequeue());
						gameBoard[row][column] = nPoint;
						addRandomNumberQueue(InputList);
						// displayBoard(gameBoard);
						displayInput(InputList);

						break;
					}
				}
			}
			while (!backpack1.isEmpty() && !backpack2.isEmpty()) { // Score calculating
				int score_factor = 0;
				if (backpack1.size() == backpack2.size()) {
					if (backpack1.peek() == backpack2.peek()) {
						if ((int) backpack1.peek() <= 3) {
							score_factor = 1;
						} else if ((int) backpack1.peek() <= 6) {
							score_factor = 5;
						} else {
							score_factor = 25;
						}
						score += (int) backpack1.peek() * score_factor;
						backpack1.pop();
						backpack2.pop();
						_human += 1;
						human.setScore(human.getScore() + 1);
					} else {
						temp_backpack1.push(backpack1.pop());
						temp_backpack2.push(backpack2.pop());
					}

				} else if (backpack1.size() > backpack2.size()) {

					while (backpack1.size() != backpack2.size()) {
						temp_backpack1.push(backpack1.pop());

					}

				} else if (backpack1.size() < backpack2.size()) {//

					while (backpack1.size() != backpack2.size()) {
						temp_backpack2.push(backpack2.pop());

					}

				}

			}
			while (!temp_backpack1.isEmpty()) {
				backpack1.push(temp_backpack1.pop());
			}
			while (!temp_backpack2.isEmpty()) {
				backpack2.push(temp_backpack2.pop());
			}

			ClearBackpacks(backpack1, backpack2);
			PrintBackpacks(backpack1, backpack2);
			// displayScoreTime();
			if (_human == 9) {
				_human = 1;
				human.setScore(1);
			}
			cn.getTextWindow().setCursorPosition(60, 18);
			System.out.print("Score: " + score);
			cn.getTextWindow().setCursorPosition(0, 0);

		}

	}

	public void displayAlwaysWorkParts(Stack backpack1, Stack backpack2, Point[][] gameBoard, CircularQueue InputList) {

		// SKOR YAZDIRILCAK
		new Thread(new Runnable() { // MultiThreading. To run multiple programs at the same time

			public void run() {
				try {
					cn.getTextWindow().setCursorPosition(0, 0);
					AlwaysWorkParts(gameBoard, InputList, backpack1, backpack2);
					cn.getTextWindow().setCursorPosition(0, 0);
					displayInput(InputList);
					cn.getTextWindow().setCursorPosition(0, 0);
					displayBackpacks();
					cn.getTextWindow().setCursorPosition(0, 0);
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void randomMove(Point[][] gameBoard, Point human) throws InterruptedException {

		Random rnd = new Random();

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {

				if (gameBoard[i][j] != human && (gameBoard[i][j].getScore() == 4 || gameBoard[i][j].getScore() == 5
						|| gameBoard[i][j].getScore() == 6)) {

					while (true) {
						// Thread.sleep(300);
						if (gameBoard[i][j + 1].getScore() != 0 && gameBoard[i - 1][j].getScore() != 0
								&& gameBoard[i][j - 1].getScore() != 0 && gameBoard[i + 1][j].getScore() != 0) {
							break;
						}
						int direction = rnd.nextInt(4) + 1;
						if (direction == 1 && gameBoard[i][j + 1].getScore() == 0) {
							gameBoard[i][j + 1] = new Point(i, j + 1, gameBoard[i][j].getScore());
							//cn.getTextWindow().output(j, i, ' ');
							Point p = new Point(i, j, 0);
							gameBoard[i][j] = p; // write empty for previous place
							break;

						} else if (direction == 2 && gameBoard[i - 1][j].getScore() == 0) {
							gameBoard[i - 1][j] = new Point(i - 1, j, gameBoard[i][j].getScore());
							//cn.getTextWindow().output(j, i, ' ');
							Point p = new Point(i, j, 0);
							gameBoard[i][j] = p; // write empty for previous place
							break;

						} else if (direction == 3 && gameBoard[i][j - 1].getScore() == 0) {
							gameBoard[i][j - 1] = new Point(i, j - 1, gameBoard[i][j].getScore());
							//cn.getTextWindow().output(j, i, ' ');
							Point p = new Point(i, j, 0);
							gameBoard[i][j] = p; // write empty for previous place
							break;

						} else if (direction == 4 && gameBoard[i + 1][j].getScore() == 0) {
							gameBoard[i + 1][j] = new Point(i + 1, j, gameBoard[i][j].getScore());
							//cn.getTextWindow().output(j, i, ' ');
							Point p = new Point(i, j, 0);
							gameBoard[i][j] = p; // write empty for previous place
							break;
						}
					}
				}
			}
		}
	}

	public void pathFinding(Point[][] gameBoard, Point human)throws InterruptedException {// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

		

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				

				if ((gameBoard[i][j].getScore() >= 7) && gameBoard[i][j].getColor() != "blue") {
					Point[][] gameBoard2 = new Point[23][55];
					Stack path = new Stack(2000);
					int number = 1;

					for (int k = 0; k < gameBoard.length; k++) {
						for (int l = 0; l < gameBoard[k].length; l++) {
							if (gameBoard[k][l].getScore() == -1) {
								Point p = new Point(k, l, -1);
								gameBoard2[k][l] = p; // write -1 for walls
							} else {
								Point p = new Point(k, l, 0);
								gameBoard2[k][l] = p; // write -1 for walls
							}

						}
					}

					int value_protect_i = i;
					int value_protect_j = j;
					boolean firstStep=true;
					int firstStep_i=0;
					int firstStep_j = 0;

					gameBoard2[i][j] = new Point(i, j, number, new Point(i, j, number));// first point initialize

					while (true) {

						int temp_number = number;

						if (gameBoard2[i][j + 1].getScore() == 0 && gameBoard[i][j + 1].getScore() == 0) {

							Point p = new Point(i, j + 1, number, new Point(i, j, temp_number));
							path.push(p);
							gameBoard2[i][j + 1] = p; // write 0 for empties
							number++;
							if (firstStep) {//++
								firstStep_i=i;
								firstStep_j=j + 1;
								firstStep=false;
							}
						}
						if (gameBoard2[i - 1][j].getScore() == 0 && gameBoard[i - 1][j].getScore() == 0) {

							Point p = new Point(i - 1, j, number, new Point(i, j, temp_number));
							path.push(p);
							gameBoard2[i - 1][j] = p; // write 0 for empties
							number++;
							if (firstStep) {//++
								firstStep_i=i-1;
								firstStep_j=j ;
								firstStep=false;
							}

						}
						if (gameBoard2[i][j - 1].getScore() == 0 && gameBoard[i][j - 1].getScore() == 0) {

							Point p = new Point(i, j - 1, number, new Point(i, j, temp_number));
							path.push(p);
							gameBoard2[i][j - 1] = p; // write 0 for empties
							number++;
							if (firstStep) {//++
								firstStep_i=i;
								firstStep_j=j -1;
								firstStep=false;
							}

						}
						if (gameBoard2[i + 1][j].getScore() == 0 && gameBoard[i + 1][j].getScore() == 0) {

							Point p = new Point(i + 1, j, number, new Point(i, j, temp_number));
							path.push(p);
							gameBoard2[i + 1][j] = p; // write 0 for empties
							number++;
							if (firstStep) {//++
								firstStep_i=i+1;
								firstStep_j=j ;
								firstStep=false;
							}

						}

//						Point p = new Point(i, j, -2);//tried
//						gameBoard2[i][j] = p;

						if (gameBoard[i][j + 1] == human || gameBoard[i - 1][j] == human || gameBoard[i][j - 1] == human
								|| gameBoard[i + 1][j] == human || path.isEmpty()) {
							break;
						}

						Point top_number = (Point) path.pop();
						i = top_number.getRowCoordinate();
						j = top_number.getColumnCoordinate();
						
						
						

					}
					
					
					
					gameBoard[firstStep_i][firstStep_j] = new Point(firstStep_i, firstStep_j, gameBoard[value_protect_i][value_protect_j].getScore());//++
					Point p = new Point(value_protect_i, value_protect_j, 0);
					gameBoard[value_protect_i][value_protect_j] = p; // write empty for previous place
									
						
					
					
					while (i != value_protect_i || j != value_protect_j) {
						i = gameBoard2[i][j].getPrevious().getRowCoordinate();
						j = gameBoard2[i][j].getPrevious().getColumnCoordinate();

						cn.getTextWindow().output(j, i, '.');// !!ekran kaymasına sebep olabilir
					}

					i = value_protect_i;
					j = value_protect_j;
				}
			}
		}

	}

	Game() throws Exception { // --- Constructor

		Point[][] gameBoard = new Point[23][55]; // gameboard with 23 rows 55 columns

		Stack backpack1 = new Stack(8);
		Stack backpack2 = new Stack(8);

		File myFile = new File("maze.txt");
		try {
			Scanner myReader = new Scanner(myFile);
			int row = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				for (int j = 0; j < data.length(); j++) {
					if (data.charAt(j) == '#') { // walls
						Point p = new Point(row, j, -1);

						gameBoard[row][j] = p; // write -1 for walls

					} else if (data.charAt(j) == ' ') { // empties
						Point p = new Point(row, j, 0);

						gameBoard[row][j] = p; // write 0 for empties

					}

				}
				row++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("The file is not found!");
		}
		// ********************************

		Random rnd = new Random();

		while (true) { // add human player randomly
			int row = rnd.nextInt(gameBoard.length);
			int column = rnd.nextInt(gameBoard[1].length);
			if (gameBoard[row][column].getScore() == 0) {
				human = new Point(row, column);
				gameBoard[row][column] = human;
				break;
			}
		}

		int numberCount = 0;

		while (numberCount != 25) { // add 25 computer numbers randomly
			Point p;
			int row = rnd.nextInt(gameBoard.length);
			int column = rnd.nextInt(gameBoard[1].length);
			int GenerationProbability = rnd.nextInt(100) + 1;
			if (gameBoard[row][column].getScore() == 0) {
				if (GenerationProbability <= 75) { // 1,2,3
					p = new Point(row, column, rnd.nextInt(3) + 1);
				} else if (GenerationProbability <= 95) { // 4,5,6
					p = new Point(row, column, rnd.nextInt(3) + 4);
				} else {
					p = new Point(row, column, rnd.nextInt(4) + 6);
				}
				gameBoard[row][column] = p;
				numberCount++;
			}
		}

		CircularQueue InputList = new CircularQueue(10);
		for (int i = 0; i < 10; i++) {
			addRandomNumberQueue(InputList);
		}

		displayInput(InputList);
		displayBackpacks();
		cn.getTextWindow().setCursorPosition(0, 0);
		displayAlwaysWorkParts(backpack1, backpack2, gameBoard, InputList);

		// ------ Standard code for mouse and keyboard ------ Do not change
//		tmlis = new TextMouseListener() {
//			public void mouseClicked(TextMouseEvent arg0) {
//			}
//
//			public void mousePressed(TextMouseEvent arg0) {
//				if (mousepr == 0) {
//					mousepr = 1;
//					mousex = arg0.getX();
//					mousey = arg0.getY();
//				}
//			}
//
//			public void mouseReleased(TextMouseEvent arg0) {
//			}
//		};
//		cn.getTextWindow().addTextMouseListener(tmlis);

		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		cn.getTextWindow().addKeyListener(klis);
		// ----------------------------------------------------

		int px = human.getColumnCoordinate(), py = human.getRowCoordinate();
		boolean gameOver = false;
		boolean wait = false;
		int startTime = 0;

		// cn.getTextWindow().output(px, py, (char) (_human + '0'));
		while (!gameOver) {
			cn.getTextWindow().setCursorPosition(0, 0);
			Thread.sleep(150);
			cn.getTextWindow().setCursorPosition(0, 0);
			randomMove(gameBoard, human);
			gameBoard[py][px] = human;
			cn.getTextWindow().setCursorPosition(0, 0);
			displayBoard(gameBoard);
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			pathFinding(gameBoard, human);
			

			if (keypr == 1 && wait != true) { // if keyboard button pressed
				// Thread.sleep(150);
				if (rkey == KeyEvent.VK_LEFT && gameBoard[py][px - 1].getScore() != -1) {
					Point p = new Point(py, px, 0);
					gameBoard[py][px] = p; // write empty for previous place
					px--;
				}

				if (rkey == KeyEvent.VK_RIGHT && gameBoard[py][px + 1].getScore() != -1) {
					Point p = new Point(py, px, 0);
					gameBoard[py][px] = p; // write empty for previous place
					px++;
				}
				if (rkey == KeyEvent.VK_UP && gameBoard[py - 1][px].getScore() != -1) {
					Point p = new Point(py, px, 0);
					gameBoard[py][px] = p; // write empty for previous place
					py--;
				}

				if (rkey == KeyEvent.VK_DOWN && gameBoard[py + 1][px].getScore() != -1) {
					Point p = new Point(py, px, 0);
					gameBoard[py][px] = p; // write empty for previous place
					py++;
				}
				if (gameBoard[py][px].getScore() != 0 && gameBoard[py][px] != human
						&& gameBoard[py][px].getScore() != -1) { // It will be change soon.
					if (gameBoard[py][px].getScore() > _human) { // GAME OVER!
						gameOver = true;
						break;
					}

					if (!backpack1.isFull()) {
						backpack1.push(gameBoard[py][px].getScore());
					} else {
						backpack1.pop();
						backpack1.push(gameBoard[py][px].getScore());
					}
					gameBoard[py][px] = human; // write human point for new destination
					ClearBackpacks(backpack1, backpack2);
					PrintBackpacks(backpack1, backpack2);
				}
				if (rkey == KeyEvent.VK_W && !backpack2.isFull() && !backpack1.isEmpty()) {
					backpack2.push(backpack1.pop());
					ClearBackpacks(backpack1, backpack2);
					PrintBackpacks(backpack1, backpack2);
				}
				if (rkey == KeyEvent.VK_Q && !backpack1.isFull() && !backpack2.isEmpty()) {
					backpack1.push(backpack2.pop());
					ClearBackpacks(backpack1, backpack2);
					PrintBackpacks(backpack1, backpack2);
				}
				// calculateScore(backpack1, backpack2);
				if (_human == 1 && wait == false) {
					wait = true;
					startTime = Integer.parseInt(seconds); // başlangıç süresi
				}

				keypr = 0; // last action
			}
			if (wait && Integer.parseInt(seconds) - startTime == 4) { // 4 saniye bekle
				_human += 1; // skorunu 2 yap
				human.setScore(human.getScore() + 1); // skorunu 2 yap
				wait = false; // artık beklemeyecek
			} else if (wait && human.getScore() != 1) { // veya çantadan eşlemeyle puan kazan
				wait = false; // artık beklemeyecek
			}

		}

		cn.getTextWindow().setCursorPosition(60, 10);
		TextAttributes attrs = new TextAttributes(Color.RED, Color.BLACK); // Changes the colorS of
																			// foreground,background
		cn.setTextAttributes(attrs);
		System.out.print("***GAME OVER***");

	}
}
