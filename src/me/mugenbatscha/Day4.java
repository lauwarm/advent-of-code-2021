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

	//	stringLines.flatMap(x -> Arrays.stream(x.split(","))).forEach(System.out::println);
		
		tmpArray = stringLines.toArray(String[]::new);
		
		for (int a = 0; a < 100; a++) {
			System.out.println(tmpArray[0].split(",")[a]);
		}
		
//		System.out.println(tmpArray[0].split(",")[1]);
	
		stringLines.close();
		
		return 0;
	}
	
	public static int solution2() { return 0; }
}
