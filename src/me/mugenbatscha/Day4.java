package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Day4 {

	public static int solution1() throws IOException {
		/*
		 * BINGO
		 * 25 numbers in a "board"
		 * row or column complete to win
		 * ---
		 * put board into an array?
		 * "marked" entries convert to 0
		 * 10 possible win situations, 5 vert, 5 hori
		 * 22 13 17 11  0
		 * 8   2 23  4 24
		 * 21  9 14 16  7
		 *  6 10  3 18  5
		 *  1 12 20 15 19
		 *  ---
		 *  22 13 16 11 0 8 2 23 4 24 21 9 14 16 7 6 10 3 18 5 1 12 20 15 19
		 *  a____________ b__________ c___________ d__________ e____________
		 *  a  b  c  d  e a b c  d e
		 *  
		 *  use a 2d array
		 *  index for number of board
		 *  
		 *  iterate over array... set picked number to 0
		 *  iterate over array... check if winning rule applies
		 *  have a variable currentPickedNumber
		 */
		
		var wrapper_drawNumbers = new Object() { int[] drawNumbers; };
		var wrapper_boards = new Object() { int[] boards; };
		var wrapper_currentNumber = new Object() { int currentNumber = 0; };
		
		String[] tmpArray;
		
		Stream<String> stringLines = Files.lines(Paths.get("input/input_day4.txt"));

		tmpArray = stringLines.toArray(String[]::new);
		wrapper_drawNumbers.drawNumbers = new int[100];

		for (int a = 0; a < 100; a++) {
			//System.out.println(tmpArray[0].split(",")[a]);
			wrapper_drawNumbers.drawNumbers[a] = Integer.parseInt(tmpArray[0].split(",")[a]);
		}
		int leer = 0;
		int emptyLine = 0;
		int emptyNumber = 0;
		wrapper_boards.boards = new int[2500];

		for (int b = 2; b < 601; b++) {
			if (tmpArray[b].length() == 0) {
				//System.out.println("Empty Line");
				emptyLine += 1;
			}
			else {
				for (int c = 0; c < tmpArray[b].split(" +").length; c++) {
					if (tmpArray[b].split(" +")[c].length() == 0) {
						//System.out.println("Empty");
						emptyNumber += 1;
					}
					else {
						//System.out.println(tmpArray[b].split(" +")[c]);
						wrapper_boards.boards[leer] = Integer.parseInt(tmpArray[b].split(" +")[c]);
						leer += 1;
					}
				}
			}
		}

		int test = 0;

		for (int d = 0; d < wrapper_drawNumbers.drawNumbers.length; d++) {

			for (int e = 0; e < wrapper_boards.boards.length; e++) {
				if (wrapper_boards.boards[e] == wrapper_drawNumbers.drawNumbers[d]) {
					wrapper_boards.boards[e] = 0;
				}
			}

		}

		System.out.println(test++);
/*
		for (int f = 0; f < wrapper_boards.boards.length; f++) {
			System.out.println(wrapper_boards.boards[f]);
		}
*/
		System.out.println("Board: " + wrapper_boards.boards.length);
		System.out.println("DrawNumbers: " + wrapper_drawNumbers.drawNumbers.length);
		//System.out.println(tmpArray[21].length());
		//System.out.println(tmpArray[21].split(" +").length);
		//System.out.println(leer);
		//System.out.println(tmpArray[7].length());
		//System.out.println(tmpArray[2].split(" ")[4]);
	
		stringLines.close();
		
		return 0;
	}
	
	public static int solution2() { return 0; }
}
