package me.mugenbatscha;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Day3 {
	
	public static int solution1() throws IOException { 

		var wrapper_gammaRate = new Object() { int gamaRate = 0; };
		var wrapper_epsilonRate = new Object() { int epsilonRate = 0; };
		var wrapper_commonBit = new Object() { int[] commonBit = new int[12]; };
		
		for (int a = 0; a < wrapper_commonBit.commonBit.length; a++) {
			wrapper_commonBit.commonBit[a] = 0;
		}
		
		Stream<String> stringLines = Files.lines(Paths.get("input_day3.txt"));

		stringLines.forEach(l -> {
			for (int a = 0; a < l.length(); a++) {
				if (l.charAt(a) == '0') {
					wrapper_commonBit.commonBit[a] -= 1;
				}
				else if (l.charAt(a) == '1') {
					wrapper_commonBit.commonBit[a] += 1;
				}
			}
		});

		stringLines.close();

		for (int b = 0; b < wrapper_commonBit.commonBit.length; b++) {
			if (wrapper_commonBit.commonBit[b] < 0) {
				wrapper_commonBit.commonBit[b] = 0;
			}
			else if (wrapper_commonBit.commonBit[b] > 0) {
				wrapper_commonBit.commonBit[b] = 1;
			}			
		}
		
		wrapper_gammaRate.gamaRate = Integer.parseInt(Arrays.toString(wrapper_commonBit.commonBit).replaceAll("\\[|\\]|,|\\s", ""),2);
		
		for (int c = 0; c < wrapper_commonBit.commonBit.length; c++) {
			if (wrapper_commonBit.commonBit[c] == 0) {
				wrapper_commonBit.commonBit[c] = 1;
			}
			else if (wrapper_commonBit.commonBit[c] == 1) {
				wrapper_commonBit.commonBit[c] = 0;
			}
		}
		
		wrapper_epsilonRate.epsilonRate = Integer.parseInt(Arrays.toString(wrapper_commonBit.commonBit).replaceAll("\\[|\\]|,|\\s", ""),2);
		
		return wrapper_gammaRate.gamaRate * wrapper_epsilonRate.epsilonRate;
		
	}
	
	public static int solution2() { return 0; }

}
