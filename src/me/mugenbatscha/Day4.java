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
		
		String[] inputFile;
		
		Stream<String> stringLines = Files.lines(Paths.get("input/input_day4.txt"));

		inputFile = stringLines.toArray(String[]::new);

		wrapper_drawNumbers.drawNumbers = new int[100];//100,27
		wrapper_boards.boards = new int[2500]; //2500,75

		for (int a = 0; a < 100; a++) { //100,27
			wrapper_drawNumbers.drawNumbers[a] = Integer.parseInt(inputFile[0].split(",")[a]);
		}

		int singleDigit = 0;

		for (int b = 2; b < 601; b++) { //601,19
			if (inputFile[b].length() == 0) {
			}
			else {
				for (int c = 0; c < inputFile[b].split(" +").length; c++) {
					if (inputFile[b].split(" +")[c].length() == 0) { }
					else {
						wrapper_boards.boards[singleDigit] = Integer.parseInt(inputFile[b].split(" +")[c]);
						singleDigit += 1;
					}
				}
			}
		}

		int winningIndex = 0;
		for (int d = 0; d < wrapper_drawNumbers.drawNumbers.length; d++) {
			System.out.println("-");
			for (int e = 0; e < wrapper_boards.boards.length; e++) {
				if (wrapper_boards.boards[e] == wrapper_drawNumbers.drawNumbers[d]) {
					wrapper_boards.boards[e] = -1;
				}
				if(e%5 == 0) {
					if (e < 2496) {
						System.out.println(wrapper_boards.boards[e] + " " + wrapper_boards.boards[e + 1]
								+ " " + wrapper_boards.boards[e + 2] + " " + wrapper_boards.boards[e + 3]
								+ " " + wrapper_boards.boards[e + 4]);
					}
					if (e < 2496) {
						if (((wrapper_boards.boards[e] == -1) &&
								(wrapper_boards.boards[e+1] == -1) &&
								(wrapper_boards.boards[e+2] == -1) &&
								(wrapper_boards.boards[e+3] == -1) &&
								(wrapper_boards.boards[e+4] == -1))) {
							System.out.println("WINNING INDEX?: " + e);
							System.out.println("WINNING NUMBER?: " + wrapper_drawNumbers.drawNumbers[d-1]);
							winningIndex = e;
						}
					}
				}
				if (e%25 == 0) {
					if (e < 2480) { //2480,55
						for (int f = 0; f < 4; f++) {
							if(((wrapper_boards.boards[e+f] == -1) &&
									(wrapper_boards.boards[e+f+5] == -1) &&
									(wrapper_boards.boards[e+f+10] == -1) &&
									(wrapper_boards.boards[e+f+15] == -1) &&
									(wrapper_boards.boards[e+f+20] == -1))) {
								System.out.println("WINNING INDEX?: " + e);
								System.out.println("WINNING NUMBER?: " + wrapper_drawNumbers.drawNumbers[d-1]);
								winningIndex = e;
							}
						}

					}
				}

			}
			if (winningIndex != 0) {
				int winningBoard = winningIndex /25;
				int boardStartIndex = winningBoard*25;
				int result = 0;
				System.out.println(boardStartIndex);
				for (int i = 0; i < 25; i++) {
					if (wrapper_boards.boards[boardStartIndex] != -1) {
						System.out.println("Number: " + wrapper_boards.boards[boardStartIndex]);
						result += wrapper_boards.boards[boardStartIndex];

					}
					boardStartIndex++;
				}
				System.out.println("Result: " + result);
				result = result * wrapper_drawNumbers.drawNumbers[d-1];

				return result;
			}
		}

		stringLines.close();
		
		return 0;
	}
	
	public static int solution2() { return 0; }
}
