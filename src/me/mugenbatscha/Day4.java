package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Day4 {

	public static int solution1() throws IOException {

		var wrapper_drawNumbers = new Object() { int[] drawNumbers; };
		var wrapper_boards = new Object() { int[] boards; };
		var wrapper_currentNumber = new Object() { int currentNumber = 0; };
		
		String[] tmpArray;
		
		Stream<String> stringLines = Files.lines(Paths.get("input/input_day4.txt"));

		tmpArray = stringLines.toArray(String[]::new);
		wrapper_drawNumbers.drawNumbers = new int[100];//100,27

		for (int a = 0; a < 100; a++) { //100,27
			wrapper_drawNumbers.drawNumbers[a] = Integer.parseInt(tmpArray[0].split(",")[a]);
		}

		int leer = 0;
		int emptyLine = 0;
		int emptyNumber = 0;
		wrapper_boards.boards = new int[2500]; //2500,75

		for (int b = 2; b < 601; b++) { //601,19
			if (tmpArray[b].length() == 0) {
				emptyLine += 1;
			}
			else {
				for (int c = 0; c < tmpArray[b].split(" +").length; c++) {
					if (tmpArray[b].split(" +")[c].length() == 0) {
						emptyNumber += 1;
					}
					else {
						wrapper_boards.boards[leer] = Integer.parseInt(tmpArray[b].split(" +")[c]);
						leer += 1;
					}
				}
			}
		}

		int test = 0;
		int temp = 0;
		for (int d = 0; d < wrapper_drawNumbers.drawNumbers.length; d++) {
			System.out.println("-");
			for (int e = 0; e < wrapper_boards.boards.length; e++) {
				if (wrapper_boards.boards[e] == wrapper_drawNumbers.drawNumbers[d]) {
					wrapper_boards.boards[e] = -1;
				}
				if(e%5 == 0) {
					System.out.println(wrapper_boards.boards[e] + " " + wrapper_boards.boards[e+1]
							+ " " + wrapper_boards.boards[e+2]+ " " + wrapper_boards.boards[e+3]
							+ " " + wrapper_boards.boards[e+4]);

					if(((wrapper_boards.boards[e] == -1) &&
							(wrapper_boards.boards[e+1] == -1) &&
							(wrapper_boards.boards[e+2] == -1) &&
							(wrapper_boards.boards[e+3] == -1) &&
							(wrapper_boards.boards[e+4] == -1))) {
						System.out.println("WINNING INDEX?: " + e);
						System.out.println("WINNING NUMBER?: " + wrapper_drawNumbers.drawNumbers[d-1]);
						test = e;
						wrapper_boards.boards[e] = wrapper_drawNumbers.drawNumbers[d];
					}
					if (e < 2480) { //2480,55
						if(((wrapper_boards.boards[e] == -1) &&
								(wrapper_boards.boards[e+5] == -1) &&
								(wrapper_boards.boards[e+10] == -1) &&
								(wrapper_boards.boards[e+15] == -1) &&
								(wrapper_boards.boards[e+20] == -1))) {
							System.out.println("WINNING INDEX?: " + e);
							System.out.println("WINNING NUMBER?: " + wrapper_drawNumbers.drawNumbers[d-1]);
							test = e;
							wrapper_boards.boards[e] = wrapper_drawNumbers.drawNumbers[d];
						}
					}
				}
			}
			if (test != 0) {
				int test1 = test /25;
				int boardStart = test1*25;
				int ergebnis = 0;
				System.out.println(boardStart);
				for (int i = 0; i < 25; i++) {
					if (wrapper_boards.boards[boardStart] != -1) {
						System.out.println("Number: " + wrapper_boards.boards[boardStart]);
						ergebnis += wrapper_boards.boards[boardStart];

					}
					boardStart++;
				}
				System.out.println("Ergebnis: " + ergebnis);
				ergebnis = ergebnis * wrapper_drawNumbers.drawNumbers[d-1];

				return ergebnis;
			}
		}

		stringLines.close();
		
		return 0;
	}
	
	public static int solution2() { return 0; }
}
