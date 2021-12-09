package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		 * 
		 */
		Stream<String> stringLines = Files.lines(Paths.get("input/input_day4.txt"));

		stringLines.close();
		
		return 0;
	}
	
	public static int solution2() { return 0; }
}
