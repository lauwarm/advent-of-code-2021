package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
	
	public static int solution1() throws IOException {
		
		Stream<String> stringLines = Files.lines(Paths.get("input/input_day1.txt"));
		List<Integer> intLines =  stringLines.map(Integer::valueOf)
											 .collect(Collectors.toList());
		stringLines.close();
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (int z = 0; z < intLines.size(); z++) {
			a = intLines.get(z);
			if (a > b) {
				c++;
			}
			b = a;
		}
		
		c--;
		
		return c;
	}
	
	public static int solution2() { return 0; }

}
