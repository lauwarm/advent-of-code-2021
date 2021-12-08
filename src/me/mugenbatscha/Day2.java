package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day2 {

	public static int solution1() throws IOException {
		
		var wrapper_horizontal = new Object() { int horizontal = 0; };
		var wrapper_depth = new Object() { int depth = 0; };
		
		Stream<String> stringLines = Files.lines(Paths.get("input_day2_1.txt"));

		
		stringLines.forEach(l -> {
			if(l.matches("forward(.*)")) {				
				wrapper_horizontal.horizontal += Integer.parseInt(l.substring(8));
			}
			else if (l.matches("up(.*)")) {
				wrapper_depth.depth -= Integer.parseInt(l.substring(3));
			}
			else if(l.matches("down(.*)")) {
				wrapper_depth.depth += Integer.parseInt(l.substring(5));
			}
		});
		
		stringLines.close();

		return wrapper_horizontal.horizontal * wrapper_depth.depth;
		
	}
	
	public static int solution2() { return 0; }

}
