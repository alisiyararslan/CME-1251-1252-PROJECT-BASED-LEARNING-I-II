import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import enigma.core.Enigma;

public class Main {

	public static enigma.console.Console cn = Enigma.getConsole("Mouse and keyboard");
	
	

	public static void displayBoard(int[][] gameBoard) {
		for (int row = 0; row < gameBoard.length; row++) { // rows
			for (int j = 0; j < gameBoard[row].length; j++) { // columns
				if (gameBoard[row][j] == -1) { // display # for walls
					System.out.print("#");
				} else if (gameBoard[row][j] == 0) { // display empty spaces
					System.out.print(" ");
				} else { // display numbers
					System.out.print(gameBoard[row][j]);
				}

			}
			System.out.println(); // alt satýra geç
		}

	}

	public static void main(String[] args) throws Exception {

		Game myGame = new Game();

		int gameBoard[][] = new int[23][55]; // gameboard with 23 rows 55 columns

		File myFile = new File("maze.txt");
		try {
			Scanner myReader = new Scanner(myFile);
			int row = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				for (int j = 0; j < data.length(); j++) {
					if (data.charAt(j) == '#') {
						gameBoard[row][j] = -1; // write -1 for walls
					}
					// else diyip 0 yazmaya gerek yok sanýrým java kendisi 0 ile dolduruyor en baþta
				}
				row++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("The file is not found!");
		}

		displayBoard(gameBoard);

	}

}
